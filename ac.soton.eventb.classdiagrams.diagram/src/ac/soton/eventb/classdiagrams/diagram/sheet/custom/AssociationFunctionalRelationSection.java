package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import org.eclipse.emf.ecore.EStructuralFeature;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;

public class AssociationFunctionalRelationSection extends AbstractEnumerationPropertySection {

	
	@Override
	protected Object getFeatureByValue(Object value) {
		return (Boolean)value;
	}

	@Override
	protected boolean isEqual(String selection) {
		return Boolean.toString(((Association)(eObject)).isFunctional()).equals(selection);
	}

	@Override
	protected String[] getEnumerationFeatureValues() {
		return new String[]{"true", "false"};
	}

	@Override
	protected String getFeatureAsText() {
		return Boolean.toString(((Association)(eObject)).isFunctional());
	}
	
	@Override
	protected Object getFeatureValue(String selection) {
		return Boolean.valueOf(selection);
	}

	@Override
	protected String getLabelText() {
		return "Functional:";
	}

	@Override
	protected EStructuralFeature getFeature() {
		return ClassdiagramsPackage.Literals.ASSOCIATION__FUNCTIONAL;
	}
}
