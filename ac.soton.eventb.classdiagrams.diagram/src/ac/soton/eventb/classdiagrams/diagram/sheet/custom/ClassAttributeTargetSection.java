/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import org.eclipse.emf.ecore.EObject;

import ac.soton.eventb.classdiagrams.impl.ClassAttributeImpl;
import ac.soton.eventb.emf.diagrams.sheet.AbstractTextPropertySection;

/**
 * Type property section for Class Attributes.
 * 
 * @author gintautas
 *
 */
public class ClassAttributeTargetSection extends AbstractTextPropertySection {

	@Override
	protected String getPropertyNameLabel() {
		return "Type:";
	}

	@Override
	protected void setPropertyValue(EObject object, Object value) {
		assert object instanceof ClassAttributeImpl;
		((ClassAttributeImpl) object).setTarget((String) value);
	}

	@Override
	protected String getPropertyValueString() {
		String target = ((ClassAttributeImpl) getEObject()).getTarget();
		return target == null ? "" : target;
	}

	@Override
	protected String getPropertyChangeCommandName() {
		return "change type";
	}
	
	@Override
	public boolean isRodinKeyboard() {
		return true;
	}
	
	@Override
	public void refresh() {
		super.refresh();
	}
}
