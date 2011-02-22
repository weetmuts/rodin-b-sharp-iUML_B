/*******************************************************************************
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package ac.soton.eventb.statemachines.navigator.providers;

import ac.soton.eventb.statemachines.diagram.navigator.StatemachinesDomainNavigatorItem;
import ac.soton.eventb.statemachines.diagram.navigator.StatemachinesDomainNavigatorLabelProvider;

/**
 * Label provider for statemachine items in the navigator.
 * Extends generated label provider for statemachine diagrams.
 * 
 * @author vitaly
 *
 */
public class StatemachinesLabelProvider extends StatemachinesDomainNavigatorLabelProvider {

	/* (non-Javadoc)
	 * @see ac.soton.eventb.statemachines.diagram.navigator.StatemachinesDomainNavigatorLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof StatemachinesDomainNavigatorItem) {
			// FIXME if label needs to be altered from original one provided by standard label provider
		}
		return super.getText(element);
	}

}
