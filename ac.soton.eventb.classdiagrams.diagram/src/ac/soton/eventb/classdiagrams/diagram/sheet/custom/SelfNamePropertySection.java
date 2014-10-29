/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IFilter;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.emf.diagrams.sheet.AbstractTextPropertySection;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;

/**
 * SelfName property section for Class.
 * 
 * @author cfs
 *
 */
public class SelfNamePropertySection extends AbstractTextPropertySection {

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
	protected String getPropertyNameLabel() {
		return "Self Name:";
	}

	@Override
	protected void setPropertyValue(EObject object, Object value) {
		assert object instanceof Class;
		((Class) object).setSelfName((String) value);
	}

	@Override
	protected String getPropertyValueString() {
		return ((Class) getEObject()).getSelfName();
	}

	@Override
	protected String getPropertyChangeCommandName() {
		return "change selfName";
	}

}
