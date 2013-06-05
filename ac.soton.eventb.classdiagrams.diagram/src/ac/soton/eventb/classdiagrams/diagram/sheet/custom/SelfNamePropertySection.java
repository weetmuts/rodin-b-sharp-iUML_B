/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import org.eclipse.emf.ecore.EObject;
import ac.soton.eventb.statemachines.Statemachine;

/**
 * SelfName property section for Statemachine.
 * 
 * @author cfs
 *
 */
public class SelfNamePropertySection extends AbstractTextPropertySection {

	@Override
	protected String getPropertyNameLabel() {
		return "SelfName:";
	}

	@Override
	protected void setPropertyValue(EObject object, Object value) {
		assert object instanceof Statemachine;
		((Statemachine) object).setSelfName((String) value);
	}

	@Override
	protected String getPropertyValueString() {
		return ((Statemachine) getEObject()).getSelfName();
	}

	@Override
	protected String getPropertyChangeCommandName() {
		return "change selfName";
	}

}
