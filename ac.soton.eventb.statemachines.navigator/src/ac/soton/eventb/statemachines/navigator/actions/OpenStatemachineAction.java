/*******************************************************************************
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ac.soton.eventb.statemachines.navigator.actions;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.statemachines.DiagramRoot;
import ac.soton.eventb.statemachines.diagram.edit.parts.DiagramRootEditPart;
import ac.soton.eventb.statemachines.diagram.navigator.StatemachinesDomainNavigatorItem;
import ac.soton.eventb.statemachines.diagram.part.Messages;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesDiagramEditor;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesDiagramEditorPlugin;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesDiagramEditorUtil;
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

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		selection = event.getSelection();
	}

	@Override
	public void run() {
		//FIXME: must not be null at the time of activation
		if (selection == null)
			return;
		EObject element = ((StatemachinesDomainNavigatorItem) ((IStructuredSelection) selection).getFirstElement()).getEObject();
		assert element instanceof DiagramRoot;
		
		Command command = new ICommandProxy(new OpenStatemachineCommand(element));
		if (command.canExecute())
			command.execute();
	}

	/**
	 * Open statemachine diagram command.
	 * Wraps opening process into transactional command.
	 * 
	 * @author vitaly
	 *
	 */
	private static class OpenStatemachineCommand extends AbstractTransactionalCommand {

		private EObject statemachine;

		public OpenStatemachineCommand(EObject statemachine) {
			super(GMFEditingDomainFactory.INSTANCE.createEditingDomain(), Messages.CommandName_OpenDiagram, null);
			this.statemachine = statemachine;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			monitor.beginTask("Opening statemachine diagram", IProgressMonitor.UNKNOWN);
			
			// find topmost container statemachine
			EObject root = statemachine;
			for (; false == root.eContainer() instanceof Machine; root = root.eContainer());
			IFile file = WorkspaceSynchronizer.getFile(root.eResource());
			String diagramName = StatemachinesNavUtil.getDiagramFileName(file.getFullPath(),(DiagramRoot) root);
			IFile diagramFile = file.getProject().getFile(new Path(diagramName));
			
			try {
				TransactionalEditingDomain editingDomain = getEditingDomain();
				URI fileURI = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
				
				// if no diagram file exists, create one using the topmost statemachine
				if (diagramFile.exists() == false) {
					Resource res = editingDomain.getResourceSet().createResource(fileURI);
					// add top-level diagram first to let it be the default diagram of a diagram file
					intializeNewDiagram(res, root);
					res.save(StatemachinesDiagramEditorUtil.getSaveOptions());
					StatemachinesDiagramEditorUtil.setCharset(diagramFile);
				}
				Resource resource = editingDomain.getResourceSet().getResource(fileURI, true);
				
				// find or create a diagram element
				Diagram diagram = getDiagramToOpen(resource, statemachine);
				if (diagram == null) {
					diagram = intializeNewDiagram(resource, statemachine);
				}
				
				// open diagram in editor
				URI uri = EcoreUtil.getURI(diagram);
				String editorName = StatemachinesNavUtil.getEditorName(diagram);
				IEditorInput editorInput = new URIEditorInput(uri, editorName);
				IWorkbenchPage page = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				page.openEditor(editorInput, getEditorID());
				return CommandResult.newOKCommandResult();
			} catch (PartInitException e) {
				StatemachinesNavigatorPlugin.getDefault().logError("Unable to open editor", e);
				return CommandResult.newErrorCommandResult(e);
			} catch (ExecutionException e) {
				StatemachinesNavigatorPlugin.getDefault().logError("Unable to create diagram", e);
				return CommandResult.newErrorCommandResult(e);
			} catch (IOException e) {
				StatemachinesNavigatorPlugin.getDefault().logError("Save operation failed for: " + diagramFile.getFullPath().toString(), e);
				return CommandResult.newErrorCommandResult(e);
			} finally {
				monitor.done();
			}
		}

		/**
		 * Returns a diagram that corresponds to domain element.
		 * 
		 * @param resource a resource containing a diagram
		 * @param element a domain element
		 * @return diagram element or null if not found
		 */
		private Diagram getDiagramToOpen(Resource resource, EObject element) {
			Diagram diagram = null;
			for (EObject e : resource.getContents())
				if (e instanceof Diagram && EcoreUtil.equals(((Diagram) e).getElement(), element)) {
					diagram = (Diagram) e;
					break;
				}
			return diagram;
		}

		/**
		 * Initialises diagram resource with new diagram element.
		 * 
		 * @param resource a diagram resource
		 * @param element a domain element
		 * @return diagram element
		 * @throws ExecutionException if diagram creation operation failed
		 */
		private Diagram intializeNewDiagram(final Resource resource, final EObject element) throws ExecutionException {
			Diagram d = ViewService.createDiagram(element,
					getDiagramKind(), getPreferencesHint());
			resource.getContents().add(d);
			try {
				new WorkspaceModifyOperation() {
					protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
						try {
							if (resource.isLoaded() && !getEditingDomain().isReadOnly(resource))
								resource.save(StatemachinesDiagramEditorUtil.getSaveOptions());
						} catch (IOException e) {
							throw new InvocationTargetException(e, "Save operation failed");
						}
					}
				}.run(null);
			} catch (InvocationTargetException e) {
				throw new ExecutionException("Can't create diagram of '"
						+ getDiagramKind() + "' kind", e);
			} catch (InterruptedException e) {
				throw new ExecutionException("Can't create diagram of '"
						+ getDiagramKind() + "' kind", e);
			}
			return d;
		}

		/**
		 * Returns preferences hint.
		 * 
		 * @return diagram preferences hint
		 */
		protected PreferencesHint getPreferencesHint() {
			return StatemachinesDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
		}

		/**
		 * Returns diagram kind.
		 * 
		 * @return diagram kind
		 */
		protected String getDiagramKind() {
			return DiagramRootEditPart.MODEL_ID;
		}

		/**
		 * Returns statemachine diagram editor id.
		 * 
		 * @return editor id
		 */
		protected String getEditorID() {
			return StatemachinesDiagramEditor.ID;
		}
		
	}

}
