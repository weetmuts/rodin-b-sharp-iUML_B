/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.sheet.custom;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.statemachines.AbstractState;
import ac.soton.eventb.statemachines.RefinedState;
import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.StatemachinesPackage;

/**
 * Refines property section for RefinedState.
 * 
 * @author vitaly
 *
 */
public class RefinesStatePropertySection extends AbstractEnumerationPropertySection {

	private EList<EObject> statesToRefine;

	@Override
	protected boolean isEqual(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected EStructuralFeature getFeature() {
		return StatemachinesPackage.Literals.REFINED_STATE__REFINES;
	}

	@Override
	protected String[] getEnumerationFeatureValues() {
		//FIXME: filter the choice of statemachines to refine
		// i.e. show only those available at the same level of statemachine tree hierarchy
		EObject container = EcoreUtil.getRootContainer(eObject);
		Machine machine = (Machine) container;
		EList<Machine> abstractMachines = machine.getRefines();
		if (abstractMachines.size() > 0) {
			statesToRefine = abstractMachines.get(0).getAllContained(StatemachinesPackage.Literals.ABSTRACT_STATE, true);
			String[] values = new String[statesToRefine.size()];
			int i = 0;
			for (EObject s : statesToRefine) {
				values[i++] = s == null ? ""
						: s instanceof State ? ((State) s).getName() 
								: ((RefinedState) s).getLabel();
			}
			return values;
		}
		return new String[0];
	}

	@Override
	protected String getFeatureAsText() {
		AbstractState state = ((RefinedState) eObject).getRefines();
		return state == null ? "" 
				: state instanceof State ? ((State) state).getName() 
						: ((RefinedState) state).getLabel();
	}

	@Override
	protected Object getFeatureValue(int index) {
		return statesToRefine.get(index);
	}

	@Override
	protected String getLabelText() {
		return "Refines:";
	}

}
