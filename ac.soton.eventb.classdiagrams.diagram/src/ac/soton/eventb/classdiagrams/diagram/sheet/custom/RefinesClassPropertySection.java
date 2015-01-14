/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IFilter;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.emf.diagrams.sheet.AbstractEnumerationPropertySection;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;

/**
 * Refines property section for State.
 * 
 *
 */
public class RefinesClassPropertySection extends AbstractEnumerationPropertySection {

	/**
	 * Element Filter for this property section.
	 */
	public static final class Filter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof Class;
		}
	}
	
	@Override
	protected EStructuralFeature getFeature() {
		return ClassdiagramsPackage.Literals.CLASS__REFINES;
	}

	@Override
	protected String[] getEnumerationFeatureValues() {
		EList<EObject> classesToRefine = getClassesToRefine();
		String[] values = new String[classesToRefine.size()];
		int i = 0;
		for (EObject c : classesToRefine) {
			values[i++] = c == null ? ""
					: ((Class) c).getName();
		}
		return values;
	}

	@Override
	protected String getFeatureAsText() {
		Class c = ((Class) eObject).getRefines();
		return c == null ? "" 
				: ((Class) c).getName();
	}

	@Override
	protected String getLabelText() {
		return "Refines:";
	}

	@Override
	protected List<EObject> getAvailableDataElements(){
		return (List<EObject>)getClassesToRefine();
	}
	
	@SuppressWarnings("unchecked")
	private EList<EObject> getClassesToRefine(){
		EObject container = EcoreUtil.getRootContainer(eObject);
		if (container instanceof Machine) {
			Machine machine = (Machine) container;
			EList<Machine> abstractMachines = machine.getRefines();
			if (abstractMachines.size() > 0) {
				return abstractMachines.get(0).getAllContained(ClassdiagramsPackage.Literals.CLASS, true);
			}
		}else if (container instanceof Context) {
			Context context = (Context) container;
			EList<Context> abstractContexts = context.getExtends();
			if (abstractContexts.size() > 0) {
				return abstractContexts.get(0).getAllContained(ClassdiagramsPackage.Literals.CLASS, true);
			}
		}
		return (EList<EObject>) ECollections.EMPTY_ELIST;
	}
	
}
