/*******************************************************************************
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ac.soton.eventb.statemachines.navigator;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;

import ac.soton.eventb.statemachines.DiagramRoot;
import ac.soton.eventb.statemachines.diagram.navigator.StatemachinesDomainNavigatorItem;

/**
 * Statemachines navigator item property tester.
 * Tests a set of defined properties for expected values.
 * A receiver must be an instance of StatemachinesDomainNavigatorItem.
 * 
 * Additional properties can be added by adding a property name to a list in ac.soton.eventb.statemachines.navigator.StatemachinesDomainNavigatorItemTester extension
 * and adding a property value check in test().
 * 
 * @author vitaly
 *
 */
public class StatemachinesDomainNavigatorItemTester extends PropertyTester {

	private static final Object PROPERTY_IS_ROOT = "isRoot";

	@Override
	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {
		assert receiver instanceof StatemachinesDomainNavigatorItem : "Tested property receiver is not a StatemachinesDomainNavigatorItem";
		StatemachinesDomainNavigatorItem item = (StatemachinesDomainNavigatorItem) receiver;
		if (PROPERTY_IS_ROOT.equals(property)) {
			EObject element = item.getEObject();
			return Boolean.parseBoolean(expectedValue.toString()) == element instanceof DiagramRoot;
		}
		assert false;
		return false;
	}

}
