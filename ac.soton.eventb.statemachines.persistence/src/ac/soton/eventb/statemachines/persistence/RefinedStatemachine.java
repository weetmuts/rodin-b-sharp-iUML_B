/**
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.persistence;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.core.basis.EventBElement;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

/**
 * Implementation of a Rodin internal element for RefinedStatemachine.
 * 
 * @author vitaly
 *
 */
public class RefinedStatemachine extends EventBElement implements IRefinedStatemachine {

	public RefinedStatemachine(String name, IRodinElement parent) {
		super(name, parent);
	}

	/**
	 * @see org.rodinp.core.basis.InternalElement#getElementType()
	 */
	@Override
	public IInternalElementType<? extends IInternalElement> getElementType() {
		return ELEMENT_TYPE;
	}

	/**
	 * @see ac.soton.eventb.statemachines.persistence.IAbstractStatemachine#hasSerialised()
	 */
	@Override
	public boolean hasSerialised() throws RodinDBException {
		return hasAttribute(SERIALISED_ATTRIBUTE);
	}

	/**
	 * @see ac.soton.eventb.statemachines.persistence.IAbstractStatemachine#getSerialised()
	 */
	@Override
	public String getSerialised() throws RodinDBException {
		return getAttributeValue(SERIALISED_ATTRIBUTE);
	}

	/**
	 * @see ac.soton.eventb.statemachines.persistence.IAbstractStatemachine#setSerialised(java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void setSerialised(String string, IProgressMonitor monitor)
			throws RodinDBException {
		setAttributeValue(SERIALISED_ATTRIBUTE, string, monitor);
	}

}
