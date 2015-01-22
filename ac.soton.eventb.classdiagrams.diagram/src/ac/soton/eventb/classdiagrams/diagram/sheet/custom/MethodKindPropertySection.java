/*
 * Copyright (c) 2015 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.IFilter;

import ac.soton.eventb.classdiagrams.ClassMethod;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.MethodKind;
import ac.soton.eventb.emf.diagrams.sheet.AbstractEnumerationPropertySection;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;

/**
 * property section for MethodKinds.
 * 
 * @author colin
 *
 */
public class MethodKindPropertySection extends AbstractEnumerationPropertySection {
	
	/**
	 * Element Filter for this property section.
	 */
	public static final class Filter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof ClassMethod;
		}
	}

	@Override
	protected String[] getEnumerationFeatureValues() {
		List<String> methodKinds = new ArrayList<String>();
		for (MethodKind dk : MethodKind.VALUES){
			methodKinds.add(dk.getLiteral());
		}
		return methodKinds.toArray(new String[methodKinds.size()]);
	}


	@Override
	protected String getFeatureAsText() {
		return ((ClassMethod)eObject).getKind().getLiteral();
	}

	@Override
	protected Object getFeatureValue(String selection) {
		return MethodKind.get(selection).getValue();
	}

	@Override
	protected String getLabelText() {
		return "Method Kind:";
	}

	@Override
	protected EStructuralFeature getFeature() {
		return ClassdiagramsPackage.Literals.CLASS_METHOD__KIND;
	}
	
	@Override
	protected Object getFeatureByValue(Object value) {
		Integer ftValue = (Integer)value; 
		return MethodKind.get(ftValue);
	}

	@Override
	protected List<MethodKind> getAvailableDataElements() {
		return MethodKind.VALUES;
	}

}

