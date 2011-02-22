/*******************************************************************************
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ac.soton.eventb.statemachines.navigator.actions;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eventb.ui.EventBUIPlugin;

import ac.soton.eventb.statemachines.DiagramRoot;
import ac.soton.eventb.statemachines.diagram.navigator.StatemachinesDomainNavigatorItem;
import ac.soton.eventb.statemachines.navigator.StatemachinesNavUtil;
import ac.soton.eventb.statemachines.navigator.StatemachinesNavigatorPlugin;

/**
 * Delete statemachine action. Removes selected statemachine in navigator from its resource.
 * 
 * @author vitaly
 *
 */
public class DeleteStatemachineAction extends Action implements
		ISelectionChangedListener {

	private ISelection selection;

	/**
	 * 
	 */
	public DeleteStatemachineAction() {
		super("&Delete", PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
	}

	/**
	 * @param aSite
	 */
	public DeleteStatemachineAction(ICommonActionExtensionSite aSite) {
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

	@Override
	public void run() {
		//FIXME: selection must not be null at the moment of activation
		if (selection == null)
			return;
		final EObject modelElement = ((StatemachinesDomainNavigatorItem) ((IStructuredSelection) selection).getFirstElement()).getEObject();
		assert modelElement instanceof DiagramRoot : "Selected elements is not a diagram";
		
		// load as a new resource to avoid transaction exception
		final Resource resource = modelElement.eResource();
		if (resource != null && resource.isLoaded()) {
			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(resource);
			if (editingDomain != null) {
				// execute as command
				Command cmd = new RecordingCommand(editingDomain, "Delete Statemachine") {
					protected void doExecute() {
						EcoreUtil.delete(modelElement, true);
					}
				};

				try {
					if (StatemachinesNavUtil.isUnsavedEditorOpenFor(resource))
						if (false == MessageDialog.openQuestion(
										EventBUIPlugin.getActiveWorkbenchShell(),
										"Warning: unsaved editors",
										"Unsaved editors found for " 
										+ resource.getURI().toPlatformString(true) 
										+ "\nDeleting a statemachine now will cause unsaved changes to be lost!\nContinue?"))
							return;
					editingDomain.getCommandStack().execute(cmd);
					resource.save(Collections.emptyMap());
				} catch (IOException e) {
					StatemachinesNavigatorPlugin.getDefault().logError("Save operation failed for: " + resource.getURI(), e);
				} catch (PartInitException e) {
					StatemachinesNavigatorPlugin.getDefault().logError("Unable to restore editor input for: " + resource.getURI(), e);
				}
			}
		}
	}

}
