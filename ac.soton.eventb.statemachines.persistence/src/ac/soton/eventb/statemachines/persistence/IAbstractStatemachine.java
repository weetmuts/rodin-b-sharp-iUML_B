/*******************************************************************************
 * Copyright (c) 2010 University of Southampton and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package ac.soton.eventb.statemachines.persistence;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.core.ICommentedElement;
import org.eventb.core.IIdentifierElement;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

/**
 * Interface for Rodin internal type corresponding to EMF AbstractStatemachine.
 * Stores AbstractStatemachine as a serialised string in named attribute.
 * 
 * @author vitaly
 *
 */
public interface IAbstractStatemachine extends IIdentifierElement, ICommentedElement {

	public static IAttributeType.String SERIALISED_ATTRIBUTE = RodinCore
			.getStringAttrType(StatemachinesPersistencePlugin.PLUGIN_ID
					+ ".serialised");

	/**
	 * Tests whether a serialised string of AbsractStatemachine is set.
	 * 
	 * @return true if set, otherwise false
	 * @throws RodinDBException if there was a problem accessing the database
	 */
	public abstract boolean hasSerialised() throws RodinDBException;

	/**
	 * Returns serialised string.
	 * 
	 * @return a string representation of a serialised AbsractStatemachine
	 * @throws RodinDBException if there was a problem accessing the database
	 */
	public abstract String getSerialised() throws RodinDBException;

	/**
	 * Sets serialised string.
	 * 
	 * @param string a serialised AbsractStatemachine
	 * @param monitor progress monitor
	 * @throws RodinDBException if there was a problem accessing the database
	 */
	public abstract void setSerialised(String string,
			IProgressMonitor monitor) throws RodinDBException;

}