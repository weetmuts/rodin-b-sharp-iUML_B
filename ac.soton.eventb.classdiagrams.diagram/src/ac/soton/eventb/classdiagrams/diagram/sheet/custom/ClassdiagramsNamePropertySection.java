/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import org.eclipse.jface.viewers.IFilter;
import org.eventb.emf.core.EventBNamed;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.emf.diagrams.sheet.NamePropertySection;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;

/**
 * Name property section for EventBNamed.
 * 
 *
 */
public class ClassdiagramsNamePropertySection extends NamePropertySection {

	/**
	 * Element Filter for this property section.
	 */
	public static final class Filter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof EventBNamed;
		}
	}
	
	@Override
	public boolean isReadOnly() {
		return super.isReadOnly() || (eObject instanceof Class && ((Class)eObject).getRefines() !=null);
	}
}
