/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.Classdiagram;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;

/**
 * Refines property section for Statemachine.
 * 
 * @author vitaly
 *
 */
public class RefinesClassPropertySection extends AbstractEnumerationPropertySection {

	private EList<EObject> classesToRefine;

	@Override
	protected boolean isEqual(int index) {
		return false;
	}

	@Override
	protected EStructuralFeature getFeature() {
		return ClassdiagramsPackage.Literals.CLASS__REFINES;
	}

	@Override
	protected String[] getEnumerationFeatureValues() {
		EObject container = EcoreUtil.getRootContainer(eObject);
		if (container instanceof Machine) {
			Machine machine = (Machine) container;
			EList<Machine> abstractMachines = machine.getRefines();
			if (abstractMachines.size() > 0) {
				classesToRefine = abstractMachines.get(0).getAllContained(ClassdiagramsPackage.Literals.CLASS, true);
				String[] values = new String[classesToRefine.size()];
				int i = 0;
				for (EObject sm : classesToRefine) {
					values[i++] = sm == null ? ""
							: ((Classdiagram) sm).getName();
				}
				return values;
			}
		}
		return new String[0];
	}

	@Override
	protected String getFeatureAsText() {
		Class classdiagram = ((Class) eObject).getRefines();
		return classdiagram == null ? "" 
				: ((Classdiagram) classdiagram).getName();
	}

	@Override
	protected Object getFeatureValue(int index) {
		return classesToRefine.get(index);
	}

	@Override
	protected String getLabelText() {
		return "Refines:";
	}

}
