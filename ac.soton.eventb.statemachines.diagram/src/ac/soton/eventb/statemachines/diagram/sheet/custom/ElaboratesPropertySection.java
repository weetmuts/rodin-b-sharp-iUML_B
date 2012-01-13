/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.sheet.custom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.common.ui.dialogs.PopupDialog;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachinePackage;

import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.Transition;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesDiagramEditor;

/**
 * Elaborates property section for Transition.
 * 
 * @author vitaly
 *
 */
public class ElaboratesPropertySection extends AbstractTablePropertySection {
	
	private Button newButton;
	
	private static ILabelProvider eventLabelProvider = new LabelProvider() {

		@Override
		public String getText(Object element) {
			return ((Event) element).getName();
		}};

	@Override
	protected String getButtonLabelText() {
		return "Event";
	}

	@Override
	protected List getOwnedRows() {
		return ((Transition) eObject).getElaborates();
	}

	@Override
	protected EStructuralFeature getFeature() {
		return StatemachinesPackage.Literals.TRANSITION__ELABORATES;
	}

	@Override
	protected List getValuesForRow(Object object) {
		return Collections.singletonList(((Event) object).getName());
	}

	@Override
	protected List getColumnLabelText() {
		return Collections.singletonList("Event");
	}

	@Override
	protected Object getNewChild() {
		EObject container = EcoreUtil.getRootContainer(eObject);
		Machine machine = (Machine) container;
		PopupDialog eventsDialog = new PopupDialog(getPart().getSite().getShell(), machine.getEvents(), eventLabelProvider);
		eventsDialog.setTitle(machine.getName() + " Events");
		eventsDialog.setMessage("Please select an event for this transition to elaborate");
		if (Dialog.OK == eventsDialog.open()) {
			Object[] result = eventsDialog.getResult();
			if (result.length > 0) {
				List<Event> events = new ArrayList<Event>();
				for (Object obj : result)
					events.add((Event) obj);
				return events;
			}
		}
		return null;
	}

	@Override
	protected String getLabelText() {
		return "Elaborates:";
	}

	@Override
	protected ISelection getEditorSelection(Object object) {
		return null;
	}

	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		
		Control[] children = parent.getChildren();
		FormData data;
		
		// overriding "Delete" label
		removeButton.setText("Remove Event");
		
		// a new button to create eventB event and add it to elaborates
		newButton = getWidgetFactory().createButton((Composite) children[0], "Create && Add", SWT.PUSH);
		data = new FormData();
		data.left = new FormAttachment(removeButton, 0);
		data.bottom = new FormAttachment(100, 0);
		newButton.setLayoutData(data);
		newButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				// remember selection
				int idx = table.getSelectionIndex();
				
				// create and add new event
				EObject container = EcoreUtil.getRootContainer(eObject);
				Machine machine = (Machine) container;
				NewEventDialog dialog = new NewEventDialog(getPart().getSite().getShell(), machine, null);
				if (Dialog.OK == dialog.open()) {
					EObject newChild = dialog.getEvent();
					if (newChild == null)
						return;
					EditingDomain editingDomain = ((StatemachinesDiagramEditor) getPart())
						.getEditingDomain();
					CompoundCommand cc = new CompoundCommand("Add new event for elaborates");
					// new event
					cc.append(AddCommand.create(editingDomain, machine, MachinePackage.Literals.MACHINE__EVENTS, newChild));
					// elaborate
					cc.append(AddCommand.create(editingDomain, eObject, getFeature(), newChild));
					editingDomain.getCommandStack().execute(cc);
					
					refresh();
					
					// restore selection
					table.select(idx);
					table.notifyListeners(SWT.Selection, new org.eclipse.swt.widgets.Event());
				}
				
			}
		});
	}


}
