package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection;
import org.eclipse.swt.widgets.Composite;

import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;

public abstract class AbstractClassPropertySection extends
		AbstractModelerPropertySection {

	@Override
	protected EObject unwrap(Object object) {
		return DiagramUtils.unwrap(object);
	}

	/**
	 * Get section label width. Standard implementation uses label to calculate
	 * its width. Subclasses may override.
	 * 
	 * @param composite
	 * @return label width
	 */
	protected int getPropertyLabelWidth(Composite composite) {
		return 100;
		// return getStandardLabelWidth(composite,
		// new String[] {getLabelText()});
	}

	/**
	 * Get label of a section.
	 * 
	 * @return the label of section
	 */
	protected abstract String getLabelText();

	/**
	 * Get feature of a section.
	 * 
	 * @return the feature of section object
	 */
	protected abstract EStructuralFeature getFeature();
}
