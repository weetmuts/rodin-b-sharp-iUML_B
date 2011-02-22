/*******************************************************************************
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ac.soton.eventb.statemachines.navigator.actions;

import java.io.IOException;
import java.util.LinkedList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;

import ac.soton.eventb.statemachines.DiagramRoot;
import ac.soton.eventb.statemachines.diagram.edit.parts.DiagramRootEditPart;
import ac.soton.eventb.statemachines.diagram.navigator.StatemachinesDomainNavigatorItem;
import ac.soton.eventb.statemachines.diagram.part.Messages;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesDiagramEditorPlugin;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesDiagramEditorUtil;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesVisualIDRegistry;
import ac.soton.eventb.statemachines.navigator.StatemachinesNavUtil;
import ac.soton.eventb.statemachines.navigator.StatemachinesNavigatorPlugin;

/**
 * Open statemachine action.
 * Opens a statemachine diagram; creates one before opening if it doesn't exist.
 * 
 * @author vitaly
 *
 */
public class OpenStatemachineAction extends Action implements
		ISelectionChangedListener {

	private ISelection selection;

	/**
	 * 
	 */
	public OpenStatemachineAction() {
		super("&Open Diagram", StatemachinesDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.statemachines/icons/iUMLB.png"));
	}

	/**
	 * @param aSite
	 */
	public OpenStatemachineAction(ICommonActionExtensionSite aSite) {
		this();
		selection = aSite.getStructuredViewer().getSelection();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
	 */
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		selection = event.getSelection();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		//FIXME: must not be null at the time of activation
		if (selection == null)
			return;
		final EObject modelElement = ((StatemachinesDomainNavigatorItem) ((IStructuredSelection) selection).getFirstElement()).getEObject();
		assert modelElement instanceof DiagramRoot;
		
		// get diagram file handle
		IFile file = WorkspaceSynchronizer.getFile(modelElement.eResource());
		IProject project = file.getProject();
		IFile diagramFile = project.getFile(StatemachinesNavUtil.getDiagramFileName(file.getFullPath(),(DiagramRoot) modelElement));
		
		// create diagram creation command
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
		LinkedList<IFile> affectedFiles = new LinkedList<IFile>();
		affectedFiles.add(diagramFile);
		URI diagramModelURI = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
		ResourceSet resourceSet = editingDomain.getResourceSet();
		final Resource diagramResource = resourceSet.createResource(diagramModelURI);
		AbstractTransactionalCommand command = new AbstractTransactionalCommand(
				editingDomain,
				"Create diagram",
				affectedFiles) {

			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				int diagramVID = StatemachinesVisualIDRegistry
						.getDiagramVisualID(modelElement);
				if (diagramVID != DiagramRootEditPart.VISUAL_ID) {
					return CommandResult
							.newErrorCommandResult(Messages.StatemachinesNewDiagramFileWizard_IncorrectRootError);
				}
				Diagram diagram = ViewService
						.createDiagram(
								modelElement,
								DiagramRootEditPart.MODEL_ID,
								StatemachinesDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				diagramResource.getContents().add(diagram);
				return CommandResult.newOKCommandResult();
			}
		};

		// execute and open
		try {
			if (!diagramFile.exists()) {
				OperationHistoryFactory.getOperationHistory().execute(command,
						new NullProgressMonitor(), null);
				diagramResource.save(StatemachinesDiagramEditorUtil
						.getSaveOptions());
				StatemachinesDiagramEditorUtil.setCharset(diagramFile);
			}
			StatemachinesDiagramEditorUtil.openDiagram(diagramResource);
		} catch (ExecutionException e) {
			StatemachinesNavigatorPlugin.getDefault().logError("Unable to create diagram", e);
		} catch (IOException e) {
			StatemachinesNavigatorPlugin.getDefault().logError("Save operation failed for: " + diagramModelURI, e);
		} catch (PartInitException e) {
			StatemachinesNavigatorPlugin.getDefault().logError("Unable to open editor", e);
		}
	}

	

}
