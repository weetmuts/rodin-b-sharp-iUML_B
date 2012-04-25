package ac.soton.eventb.classdiagrams.diagram.providers;

import ac.soton.eventb.classdiagrams.diagram.part.ClassdiagramsDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = ClassdiagramsDiagramEditorPlugin
				.getInstance().getElementInitializers();
		if (cached == null) {
			ClassdiagramsDiagramEditorPlugin.getInstance()
					.setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
