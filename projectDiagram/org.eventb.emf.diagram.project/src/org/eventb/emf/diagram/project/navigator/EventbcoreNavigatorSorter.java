package org.eventb.emf.diagram.project.navigator;

import org.eclipse.jface.viewers.ViewerSorter;
import org.eventb.emf.diagram.project.part.EventbcoreVisualIDRegistry;

/**
 * @generated
 */
public class EventbcoreNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 4005;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof EventbcoreNavigatorItem) {
			EventbcoreNavigatorItem item = (EventbcoreNavigatorItem) element;
			return EventbcoreVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
