/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.sheet.custom;

import org.eclipse.emf.ecore.EObject;
import org.eventb.emf.core.EventBNamed;

/**
 * Name property section for EventBNamed.
 * 
 * @author vitaly
 *
 */
public class NamePropertySection extends AbstractTextPropertySection {

	@Override
	protected String getPropertyNameLabel() {
		return "Name:";
	}

	@Override
	protected void setPropertyValue(EObject object, Object value) {
		assert object instanceof EventBNamed;
		((EventBNamed) object).setName((String) value);
	}

	@Override
	protected String getPropertyValueString() {
		return ((EventBNamed) getEObject()).getName();
	}

	@Override
	protected String getPropertyChangeCommandName() {
		return "change name";
	}

}
