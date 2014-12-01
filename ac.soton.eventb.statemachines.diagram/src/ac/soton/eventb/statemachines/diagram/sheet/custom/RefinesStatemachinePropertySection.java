/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.sheet.custom;

import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.emf.diagrams.sheet.AbstractEnumerationPropertySection;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachinesPackage;

/**
 * Refines property section for Statemachine.
 * 
 *
 */
public class RefinesStatemachinePropertySection extends AbstractEnumerationPropertySection {
	
	@Override
	protected EStructuralFeature getFeature() {
		return StatemachinesPackage.Literals.STATEMACHINE__REFINES;
	}

	@Override
	protected String[] getEnumerationFeatureValues() {
		EList<EObject> statemachinesToRefine = getStatemachinesToRefine();
		String[] values = new String[statemachinesToRefine.size()];
		int i = 0;
		for (EObject sm : statemachinesToRefine) {
			values[i++] = sm == null ? ""
					: ((Statemachine) sm).getName();
		}
		return values;
	}

	@Override
	protected String getFeatureAsText() {
		Statemachine statemachine = ((Statemachine) eObject).getRefines();
		return statemachine == null ? "" 
				: ((Statemachine) statemachine).getName();
	}
	
	@Override
	protected String getLabelText() {
		return "Refines:";
	}

	@Override
	protected List<EObject> getAvailableDataElements(){
		return (List<EObject>)getStatemachinesToRefine();
	}
	
	
	@SuppressWarnings("unchecked")
	private EList<EObject> getStatemachinesToRefine(){
		EObject container = EcoreUtil.getRootContainer(eObject);
		if (container instanceof Machine) {
			Machine machine = (Machine) container;
			EList<Machine> abstractMachines = machine.getRefines();
			if (abstractMachines.size() > 0) {
				return abstractMachines.get(0).getAllContained(StatemachinesPackage.Literals.STATEMACHINE, true);
			}
		}
		return (EList<EObject>) ECollections.EMPTY_ELIST;
	}
}
