package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import org.eclipse.emf.ecore.EStructuralFeature;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;

public class AssociationTotalRelationSection extends AbstractEnumerationPropertySection {

	
	@Override
	protected Object getFeatureByValue(Object value) {
		return (Boolean)value;
	}

	@Override
	protected boolean isEqual(String selection) {
		return Boolean.toString(((Association)(eObject)).isTotal()).equals(selection);
	}

	@Override
	protected String[] getEnumerationFeatureValues() {
		return new String[]{"true", "false"};
	}

	@Override
	protected String getFeatureAsText() {
		return Boolean.toString(((Association)(eObject)).isTotal());
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
		return ClassdiagramsPackage.Literals.ASSOCIATION__TOTAL;
	}
}
