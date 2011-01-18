/*******************************************************************************
 * Copyright (c) 2010 University of Southampton and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package ac.soton.eventb.statemachines.persistence;

import org.eclipse.core.runtime.IProgressMonitor;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

/**
 * Interface for Rodin internal type corresponding to EMF StatemachineCollection.
 * 
 * @author vitaly
 *
 */
public interface IStatemachineCollection extends IInternalElement {
	
	public static IInternalElementType<StatemachineCollection> ELEMENT_TYPE = RodinCore.getInternalElementType(StatemachinesPersistencePlugin.PLUGIN_ID + ".statemachineCollection");
	public static IAttributeType.String STATEMACHINES_ATTRIBUTE = RodinCore.getStringAttrType(StatemachinesPersistencePlugin.PLUGIN_ID + ".statemachines");
	
	/**
	 * Tests whether a serialised string of StatemachineCollection is set.
	 * 
	 * @return true if set, otherwise false
	 * @throws RodinDBException if there was a problem accessing the database
	 */
	boolean hasSerialisedString() throws RodinDBException;
	
	/**
	 * Returns a serialised string.
	 * 
	 * @return a string representation of a serialised StatemachineCollection object
	 * @throws RodinDBException if there was a problem accessing the database
	 */
	String getSerialisedString() throws RodinDBException;
	
	/**
	 * Sets the serialised string.
	 * 
	 * @param string a serialised StatemachineCollection string
	 * @param monitor progress monitor
	 * @throws RodinDBException if there was a problem accessing the database
	 */
	void setSerialisedString(String string, IProgressMonitor monitor) throws RodinDBException;

}