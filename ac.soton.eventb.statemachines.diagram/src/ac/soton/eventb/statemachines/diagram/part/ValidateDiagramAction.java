/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.part;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * @generated
 */
public class ValidateDiagramAction extends AbstractHandler {

	/**
	 * @generated NOT
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editor = HandlerUtil.getActiveEditorChecked(event);
		if (editor instanceof IDiagramWorkbenchPart) {
			IDiagramWorkbenchPart diagramEditor = (IDiagramWorkbenchPart) editor;

			// run validation
			ValidateAction action = new ValidateAction(editor.getSite()
					.getPage());
			action.run();

			// show feedback
			try {
				IFile file = WorkspaceSynchronizer.getFile(diagramEditor
						.getDiagram().eResource());
				String errors = ValidateAction.getValidationErrors(file);
				if (errors.isEmpty())
					MessageDialog.openInformation(editor.getSite().getShell(),
							"Validation Information",
							"Validation completed successfully");
				else
					MessageDialog.openError(editor.getSite().getShell(),
							"Validation Information",
							"Validation has found problems in your model:\n"
									+ errors);
			} catch (CoreException e) {
				throw new ExecutionException(
						"Validation result retrieval failed", e);
			}
		}

		return null;
	}

}
