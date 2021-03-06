/*
 * Copyright (c) 2012 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.edit.commands;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;

import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassdiagramEditPart;

/**
 * @generated
 */
public class ClassdiagramsCreateShortcutDecorationsCommand extends
		AbstractTransactionalCommand {

	/**
	 * @generated
	 */
	private List myDescriptors;

	/**
	 * @generated
	 */
	public ClassdiagramsCreateShortcutDecorationsCommand(
			TransactionalEditingDomain editingDomain, View parentView,
			List viewDescriptors) {
		super(editingDomain, "Create Shortcuts", getWorkspaceFiles(parentView)); //$NON-NLS-1$
		myDescriptors = viewDescriptors;
	}

	/**
	 * @generated
	 */
	public ClassdiagramsCreateShortcutDecorationsCommand(
			TransactionalEditingDomain editingDomain, View parentView,
			CreateViewRequest.ViewDescriptor viewDescriptor) {
		this(editingDomain, parentView, Collections
				.singletonList(viewDescriptor));
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		for (Iterator it = myDescriptors.iterator(); it.hasNext();) {
			CreateViewRequest.ViewDescriptor nextDescriptor = (CreateViewRequest.ViewDescriptor) it
					.next();
			View view = (View) nextDescriptor.getAdapter(View.class);
			if (view != null && view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE
						.createEAnnotation();
				shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
				shortcutAnnotation.getDetails().put(
						"modelID", ClassdiagramEditPart.MODEL_ID); //$NON-NLS-1$
				view.getEAnnotations().add(shortcutAnnotation);
			}
		}
		return CommandResult.newOKCommandResult();
	}
}
