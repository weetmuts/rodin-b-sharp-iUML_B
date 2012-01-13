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

import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.StatemachinesPackage;

/**
 * Refines property section for State.
 * 
 * @author vitaly
 *
 */
public class RefinesStatePropertySection extends AbstractEnumerationPropertySection {

	private EList<EObject> statesToRefine;

	@Override
	protected boolean isEqual(int index) {
		return false;
	}

	@Override
	protected EStructuralFeature getFeature() {
		return StatemachinesPackage.Literals.STATE__REFINES;
	}

	@Override
	protected String[] getEnumerationFeatureValues() {
		EObject container = EcoreUtil.getRootContainer(eObject);
		if (container instanceof Machine) {
			Machine machine = (Machine) container;
			EList<Machine> abstractMachines = machine.getRefines();
			if (abstractMachines.size() > 0) {
				statesToRefine = abstractMachines.get(0).getAllContained(StatemachinesPackage.Literals.STATE, true);
				String[] values = new String[statesToRefine.size()];
				int i = 0;
				for (EObject s : statesToRefine) {
					values[i++] = s == null ? ""
							: ((State) s).getName();
				}
				return values;
			}
		}
		return new String[0];
	}

	@Override
	protected String getFeatureAsText() {
		State state = ((State) eObject).getRefines();
		return state == null ? "" 
				: ((State) state).getName();
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
