/*******************************************************************************
 * Copyright (c) 2010 University of Southampton and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package ac.soton.eventb.statemachines.persistence;

import org.eclipse.core.runtime.IProgressMonitor;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;
import org.rodinp.core.basis.InternalElement;

/**
 * Implementation of a Rodin internal element for StatemachineCollection.
 * 
 * @author vitaly
 *
 */
public class StatemachineCollection extends InternalElement implements IStatemachineCollection {

	public StatemachineCollection(String name, IRodinElement parent) {
		super(name, parent);
	}

	/* (non-Javadoc)
	 * @see org.rodinp.core.basis.InternalElement#getElementType()
	 */
	@Override
	public IInternalElementType<? extends IInternalElement> getElementType() {
		return ELEMENT_TYPE;
	}

	/* (non-Javadoc)
	 * @see ac.soton.eventb.statemachines.persistence.IStatemachineCollection#hasSerialisedString()
	 */
	@Override
	public boolean hasSerialisedString() throws RodinDBException {
		return hasAttribute(STATEMACHINES_ATTRIBUTE);
	}

	/* (non-Javadoc)
	 * @see ac.soton.eventb.statemachines.persistence.IStatemachineCollection#getSerialisedString()
	 */
	@Override
	public String getSerialisedString() throws RodinDBException {
		return getAttributeValue(STATEMACHINES_ATTRIBUTE);
	}

	/* (non-Javadoc)
	 * @see ac.soton.eventb.statemachines.persistence.IStatemachineCollection#setSerialisedString(java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void setSerialisedString(String string, IProgressMonitor monitor)
			throws RodinDBException {
		setAttributeValue(STATEMACHINES_ATTRIBUTE, string, monitor);
	}

}
