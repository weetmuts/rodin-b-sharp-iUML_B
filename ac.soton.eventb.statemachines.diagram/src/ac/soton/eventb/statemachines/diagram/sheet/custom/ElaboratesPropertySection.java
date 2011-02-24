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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.ui.dialogs.PopupDialog;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.Transition;

/**
 * Elaborates property section for Transition.
 * 
 * @author vitaly
 *
 */
public class ElaboratesPropertySection extends AbstractTablePropertySection {
	
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
	protected String getKeyForRow(Object object) {
		return "";
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
		eventsDialog.setMessage("Please select events for this transition to elaborate");
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


}
