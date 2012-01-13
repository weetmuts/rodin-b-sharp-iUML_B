/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import ac.soton.eventb.statemachines.diagram.part.StatemachinesVisualIDRegistry;

/**
 * @generated
 */
public class StatemachinesNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7017;

	/**
	 * @generated
	 */
	private static final int SHORTCUTS_CATEGORY = 7016;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof StatemachinesNavigatorItem) {
			StatemachinesNavigatorItem item = (StatemachinesNavigatorItem) element;
			if (item.getView().getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				return SHORTCUTS_CATEGORY;
			}
			return StatemachinesVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
