package ac.soton.eventb.classdiagrams.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import ac.soton.eventb.classdiagrams.diagram.part.ClassdiagramsVisualIDRegistry;

/**
 * @generated
 */
public class ClassdiagramsNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7007;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof ClassdiagramsNavigatorItem) {
			ClassdiagramsNavigatorItem item = (ClassdiagramsNavigatorItem) element;
			return ClassdiagramsVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
