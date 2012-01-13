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

import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachinesPackage;

/**
 * Refines property section for Statemachine.
 * 
 * @author vitaly
 *
 */
public class RefinesStatemachinePropertySection extends AbstractEnumerationPropertySection {

	private EList<EObject> statemachinesToRefine;

	@Override
	protected boolean isEqual(int index) {
		return false;
	}

	@Override
	protected EStructuralFeature getFeature() {
		return StatemachinesPackage.Literals.STATEMACHINE__REFINES;
	}

	@Override
	protected String[] getEnumerationFeatureValues() {
		EObject container = EcoreUtil.getRootContainer(eObject);
		if (container instanceof Machine) {
			Machine machine = (Machine) container;
			EList<Machine> abstractMachines = machine.getRefines();
			if (abstractMachines.size() > 0) {
				statemachinesToRefine = abstractMachines.get(0).getAllContained(StatemachinesPackage.Literals.STATEMACHINE, true);
				String[] values = new String[statemachinesToRefine.size()];
				int i = 0;
				for (EObject sm : statemachinesToRefine) {
					values[i++] = sm == null ? ""
							: ((Statemachine) sm).getName();
				}
				return values;
			}
		}
		return new String[0];
	}

	@Override
	protected String getFeatureAsText() {
		Statemachine statemachine = ((Statemachine) eObject).getRefines();
		return statemachine == null ? "" 
				: ((Statemachine) statemachine).getName();
	}

	@Override
	protected Object getFeatureValue(int index) {
		return statemachinesToRefine.get(index);
	}

	@Override
	protected String getLabelText() {
		return "Refines:";
	}

}
