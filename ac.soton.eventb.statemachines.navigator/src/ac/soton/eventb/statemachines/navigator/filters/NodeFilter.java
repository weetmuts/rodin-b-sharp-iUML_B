/*******************************************************************************
 * Copyright (c) 2011 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ac.soton.eventb.statemachines.navigator.filters;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import ac.soton.eventb.statemachines.AbstractNode;
import ac.soton.eventb.statemachines.State;

/**
 * Node filter for statemachine nodes in navigator.
 * Filters out all nodes except states.
 * 
 * @author vitaly
 *
 */
public class NodeFilter extends ViewerFilter {

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof IAdaptable) {
			EObject eobject = (EObject) ((IAdaptable) element).getAdapter(EObject.class);
			if (eobject != null 
					&& eobject instanceof AbstractNode 
					&& (eobject instanceof State == false))
				return false;
		}
		return true;
	}

}
