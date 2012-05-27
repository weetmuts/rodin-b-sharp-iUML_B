/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import org.eclipse.emf.ecore.EObject;
import org.eventb.emf.core.EventBCommented;

import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.classdiagrams.ElaborativeElement;
import ac.soton.eventb.classdiagrams.impl.ClassAttributeImpl;

/**
 * Comment property section for EventBCommented.
 * 
 * @author vitaly
 *
 */
public class ClassAttributeTargetSection extends AbstractTextPropertySection {

	@Override
	protected String getPropertyNameLabel() {
		return "Target:";
	}

	@Override
	protected void setPropertyValue(EObject object, Object value) {
		assert object instanceof ClassAttributeImpl;
		((ClassAttributeImpl) object).setTarget((String) value);
	}

	@Override
	protected String getPropertyValueString() {
		String comment = ((ClassAttributeImpl) getEObject()).getTarget();
		return comment == null ? "" : comment;
	}

	@Override
	protected String getPropertyChangeCommandName() {
		return "change target";
	}

	
	@Override
	public void refresh() {
		super.refresh();
		
		if (((ClassAttribute)eObject).getElaborates() != null){
			getTextWidget().setEditable(false);
		} else {
			getTextWidget().setEditable(true);
		}
	}
}
