/*******************************************************************************
 * Copyright (c) 2010 University of Southampton and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eventb.emf.diagram.project.edit.policies;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.Project;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.diagram.project.part.EventbcoreDiagramEditorPlugin;
import org.rodinp.core.IRodinFile;
import org.rodinp.core.IRodinProject;
import org.rodinp.core.RodinCore;

/**
 * Edit policy to open an Event-B component from the project diagram.
 * Opens a Rodin component in a default editor when double-clicked on the project diagram.
 * 
 * @author vitaly
 *
 */
public class OpenEventbComponentEditPolicy extends OpenEditPolicy {

	@Override
	protected Command getOpenCommand(Request request) {
		EObject element = ((View) getHost().getModel()).getElement();
		if (!(element instanceof EventBNamedCommentedComponentElement))
			return UnexecutableCommand.INSTANCE;
		
		// get a Rodin file for the component
		EventBNamedCommentedComponentElement component = (EventBNamedCommentedComponentElement) element;
		String fileName = component.doGetName() + (component instanceof Machine ? ".bum" : ".buc");
		IRodinProject project = RodinCore.getRodinDB().getRodinProject(((Project) component.eContainer()).doGetName());
		final IRodinFile file = project.getRodinFile(fileName);
		
		// show warning if a corresponding file doesn't exist
		if (!file.exists()) {
			ErrorDialog.openError(null, 
					"Error", 
					"Cannot find a Rodin file '" + fileName + "'. Try refreshing the diagram.", 
					new Status(Status.WARNING, EventbcoreDiagramEditorPlugin.ID, "File was renamed or removed."));
			getHost().getViewer().deselect(getHost());
			return null;
		}
		
		// open a default editor command
		Command command = new Command() {

			@Override
			public void execute() {
				IEditorDescriptor editorDescriptor = IDE.getDefaultEditor((IFile) file.getResource());
				try {
					IDE.openEditor(
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), 
							new FileEditorInput((IFile) file.getResource()), 
							editorDescriptor.getId());
				} catch (PartInitException e) {
					EventbcoreDiagramEditorPlugin.getInstance().logError("Error opening an Event-B Editor", e);
				}
			}
			
		};
		return command;
	}

}
