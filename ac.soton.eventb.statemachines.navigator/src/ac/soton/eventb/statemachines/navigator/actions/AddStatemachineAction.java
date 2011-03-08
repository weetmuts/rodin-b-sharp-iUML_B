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

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eventb.core.IMachineRoot;
import org.eventb.emf.core.machine.Machine;
import org.eventb.ui.EventBUIPlugin;

import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachinesFactory;
import ac.soton.eventb.statemachines.diagram.StatemachinesEditorUtil;
import ac.soton.eventb.statemachines.diagram.navigator.StatemachinesDomainNavigatorItem;
import ac.soton.eventb.statemachines.navigator.StatemachinesNavigatorPlugin;
import ac.soton.eventb.statemachines.util.StatemachinesAdapterFactory;

/**
 * Add statemachine navigator toolbar action.
 * Adds a new statemachine to selected machine.
 * 
 * @author vitaly
 *
 */
public class AddStatemachineAction extends Action implements ISelectionChangedListener {

	private ISelection selection;
	private IViewPart view;
	
	// new statemachine name validator
	static final IInputValidator nameValidator = new IInputValidator(){

		@Override
		public String isValid(String name) {
			if (name.trim().isEmpty())
				return "";
			return null;
		}
	};

	public AddStatemachineAction(String string, IViewPart view) {
		super(string);
		this.view = view;
		view.getViewSite().getSelectionProvider().addSelectionChangedListener(this);
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		selection = event.getSelection();
	}

	@Override
	public void run() {
		assert selection != null : "Add Statemachine action selection is empty";
		Object selectedElement = ((IStructuredSelection) selection).getFirstElement();
		
		// find a container resource for new statemachine
		final Resource resource;
		if (selectedElement instanceof IMachineRoot) {
			IFile file = ((IMachineRoot) selectedElement).getResource();
			resource = new ResourceSetImpl().getResource(URI.createPlatformResourceURI(file.getFullPath().toString(), true), true);
		} else if (selectedElement instanceof StatemachinesDomainNavigatorItem) {
			resource = ((StatemachinesDomainNavigatorItem) selectedElement).getEObject().eResource();
		} else {
			//FIXME: provide an alternative here, e.g. a selection dialog to query a user on a resource to put a new statemachine to
			return;
		}
		
		if (resource != null && resource.isLoaded()) {
			// check for opened unsaved editors
			try {
				if (StatemachinesEditorUtil.isUnsavedEditorOpenFor(resource))
					if (false == MessageDialog.openQuestion(
									EventBUIPlugin.getActiveWorkbenchShell(),
									"Warning: unsaved editors",
									"Unsaved editors found for " 
									+ resource.getURI().toPlatformString(true) 
									+ "\nAdding a statemachine now will cause unsaved changes to be lost!\nContinue?"))
						return;
			} catch (PartInitException e) {
				StatemachinesNavigatorPlugin.getDefault().logError("Unable to restore editor input for: " + resource.getURI(), e);
				return;
			}
		
			// ask for statemachine name
			InputDialog dialog = new InputDialog(view.getSite().getShell(), 
					"New Statemachine", 
					"Enter statemachine name: ",
					null, nameValidator);
			if (dialog.open() == InputDialog.CANCEL)
				return;
			String name = dialog.getValue().trim();
			
			// new statemachine
			final Statemachine statemachine = StatemachinesFactory.eINSTANCE.createStatemachine();
			statemachine.setName(name);
			
			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(resource);
			if (editingDomain == null)
				editingDomain = new TransactionalEditingDomainImpl(new StatemachinesAdapterFactory());
			Command cmd = new RecordingCommand(editingDomain, "Add Statemachine") {
				protected void doExecute() {
					((Machine) resource.getContents().get(0)).getExtensions().add(statemachine);
				}
			};

			try {
				editingDomain.getCommandStack().execute(cmd);
				resource.save(Collections.emptyMap());
			} catch (IOException e) {
				StatemachinesNavigatorPlugin.getDefault().logError("Save operation failed for: " + resource.getURI(), e);
			}
		}
	}

}
