/*******************************************************************************
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package ac.soton.eventb.statemachines.navigator.filters;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.diagram.navigator.StatemachinesDomainNavigatorItem;

/**
 * State filter for statemachine simple states in navigator.
 * Filters out simple states: initial, final and ANY.
 * 
 * @author vitaly
 *
 */
public class StateFilter extends ViewerFilter {

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof StatemachinesDomainNavigatorItem)
			switch (((StatemachinesDomainNavigatorItem) element).getEObject().eClass().getClassifierID()) {
				case StatemachinesPackage.INITIAL: ;
				case StatemachinesPackage.FINAL: ;
				case StatemachinesPackage.ANY: return false;
			}
		return true;
	}

}
