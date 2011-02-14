/*******************************************************************************
 * Copyright (c) 2010 University of Southampton and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package ac.soton.eventb.statemachines.persistence;

import org.rodinp.core.IInternalElementType;
import org.rodinp.core.RodinCore;

/**
 * Interface for Rodin internal type corresponding to EMF RefinedStatemachine.
 * 
 * @author vitaly
 *
 */
public interface IRefinedStatemachine extends IAbstractStatemachine {
	
	public static IInternalElementType<IRefinedStatemachine> ELEMENT_TYPE = RodinCore.getInternalElementType(StatemachinesPersistencePlugin.PLUGIN_ID + ".refinedStatemachine");

}