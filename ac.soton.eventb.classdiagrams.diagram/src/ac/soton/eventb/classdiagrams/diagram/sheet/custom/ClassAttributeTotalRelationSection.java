package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;

import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;

public class ClassAttributeTotalRelationSection extends AbstractEnumerationPropertySection {

	
	@Override
	protected Object getFeatureByValue(Object value) {
		return (Boolean)value;
	}

	@Override
	protected boolean isEqual(String selection) {
		return Boolean.toString(((ClassAttribute)(eObject)).isTotal()).equals(selection);
	}

	@Override
	protected String[] getEnumerationFeatureValues() {
		return new String[]{"true", "false"};
	}

	@Override
	protected String getFeatureAsText() {
		return Boolean.toString(((ClassAttribute)(eObject)).isTotal());
	}
	
	@Override
	protected Object getFeatureValue(String selection) {
		return Boolean.valueOf(selection);
	}

	@Override
	protected String getLabelText() {
		return "Total:";
	}

	@Override
	protected EStructuralFeature getFeature() {
		return ClassdiagramsPackage.Literals.ASSOCIATIVE_ELEMENT__TOTAL;
	}

}
