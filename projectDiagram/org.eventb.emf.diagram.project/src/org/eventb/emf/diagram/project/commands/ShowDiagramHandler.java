/*******************************************************************************
 * Copyright (c) 2010 University of Southampton and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eventb.emf.diagram.project.commands;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eventb.emf.diagram.project.part.EventbcoreDiagramEditorPlugin;
import org.eventb.emf.diagram.project.part.EventbcoreDiagramEditorUtil;

/**
 * Show Diagram command handler.
 * Either creates a project diagram or opens one if already exists.
 * 
 * @author vitaly
 *
 */
public class ShowDiagramHandler extends AbstractHandler {

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * Modified code from EventbcoreCreationWizard#doFinish()
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
			// create file names
			String projectName = ((IProject) ((IStructuredSelection) selection).getFirstElement()).getName();
			final URI modelURI = URI.createPlatformResourceURI(projectName + "/" + projectName + ".prj", true);
			final URI diagramURI = URI.createPlatformResourceURI(projectName + "/" + projectName + ".prj_diag", true);
			final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
			
			// create a diagram and open it
			IRunnableWithProgress op = new WorkspaceModifyOperation(null) {
	
				protected void execute(IProgressMonitor monitor)
						throws CoreException, InterruptedException {
					TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
					Resource diagram = editingDomain.getResourceSet().createResource(diagramURI);
					
					// don't create a diagram if already exists
					if (!WorkspaceSynchronizer.getFile(diagram).exists())
						diagram = EventbcoreDiagramEditorUtil.createDiagram(diagramURI, modelURI, monitor);
					if (diagram != null) {
						try {
							EventbcoreDiagramEditorUtil.openDiagram(diagram);
						} catch (PartInitException e) {
							ErrorDialog
									.openError(
											window.getShell(),
											"Error opening a project diagram",
											null, e.getStatus());
						}
					}
				}
			};
		
			try {
				window.run(false, true, op);
			} catch (InterruptedException e) {
				return false;
			} catch (InvocationTargetException e) {
				if (e.getTargetException() instanceof CoreException) {
					ErrorDialog.openError(window.getShell(),
							"Error creating a project diagram", null,
							((CoreException) e.getTargetException()).getStatus());
				} else {
					EventbcoreDiagramEditorPlugin.getInstance().logError(
							"Error creating diagram", e.getTargetException()); //$NON-NLS-1$
				}
				return false;
			}
		}
		return null;
	}

}
