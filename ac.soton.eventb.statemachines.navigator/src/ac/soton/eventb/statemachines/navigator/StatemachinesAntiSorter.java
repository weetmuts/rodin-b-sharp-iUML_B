/*******************************************************************************
 * Copyright (c) 2010 University of Southampton and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package ac.soton.eventb.statemachines.navigator;

import org.eclipse.jface.viewers.Viewer;

import ac.soton.eventb.statemachines.DiagramRoot;
import ac.soton.eventb.statemachines.diagram.navigator.StatemachinesDomainNavigatorItem;
import fr.systerel.internal.explorer.navigator.sorters.AntiSorter;

/**
 * Anti-sorter for statemachines navigator plug-in.
 * Acts as anti-sorter of event-b navigator, except puts statemachine diagrams as the firs elements within a machine.
 * 
 * @author vitaly
 *
 */
@SuppressWarnings("restriction")
public class StatemachinesAntiSorter extends AntiSorter {

	/* (non-Javadoc)
	 * @see fr.systerel.internal.explorer.navigator.sorters.AntiSorter#compare(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		// just move statemachine diagrams to top of other items, don't sort them amongst themselves
		if (e2 instanceof StatemachinesDomainNavigatorItem && e1 instanceof StatemachinesDomainNavigatorItem == false)
			if (((StatemachinesDomainNavigatorItem) e2).getEObject() instanceof DiagramRoot)
				return 1;
		return super.compare(viewer, e1, e2);
	}

}
