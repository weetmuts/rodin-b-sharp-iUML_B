package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import java.util.Map;
import java.util.TreeMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.classdiagrams.AssociationType;
import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.classdiagrams.ClassType;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;

public class ClassAttributeTypePropertySection extends AbstractEnumerationPropertySection {
	
	private Map<String, String> getClassAttributeTypeMap(){
		Map<String, String> associationTypeMap = new TreeMap<String, String>();
		
		EObject container = EcoreUtil.getRootContainer(eObject);
		
		if (container instanceof Context){
			associationTypeMap.put(AssociationType.CONSTANT.getName(), AssociationType.CONSTANT.getLiteral());
		}
		
		if (container instanceof Machine){
			associationTypeMap.put(AssociationType.VARIABLE.getName(), AssociationType.VARIABLE.getLiteral());			
		}
		
		return associationTypeMap;
	}
	
	public void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
	}

	@Override
	protected boolean isEqual(String selection) {
		return ((ClassAttribute) eObject).getAssociationType().getLiteral().equals(selection);
	}

	@Override
	protected String[] getEnumerationFeatureValues() {
		return getClassAttributeTypeMap().values().toArray(new String[0]);
	}

	@Override
	protected String getFeatureAsText() {
		return getClassAttributeType().getLiteral();
	}

	@Override
	protected Object getFeatureValue(String selection) {
		return AssociationType.get(selection).getValue();
	}

	@Override
	protected String getLabelText() {
		return "Attribute type:";
	}

	@Override
	protected EStructuralFeature getFeature() {
		return ClassdiagramsPackage.Literals.ASSOCIATIVE_ELEMENT__ASSOCIATION_TYPE;
	}

	@Override
	public void refresh() {
		combo.setItems(getEnumerationFeatureValues());
		combo.setText(getFeatureAsText());
		combo.setEnabled(((ClassAttribute)eObject).getElaborates() == null);
	}
	
	private AssociationType getClassAttributeType(){
//		if (((ClassAttribute)(eObject)).getElaborates() != null){
//			EventBNamed ebe = ((ClassAttribute)(eObject)).getElaborates();
//			
//		 if (ebe.eContainingFeature().getName().equals("constants")){
//				return ClassAttributeType.CONSTANT;			
//			} else {
//				return ClassAttributeType.VARIABLE;
//			}
//		} else {
////			return ((ClassAttribute) eObject).getClassAttributeType();
//			return (ClassAttributeType)getFeatureByValue(getFeatureValue(combo.getItem(1)));
//		}
		
		return ((ClassAttribute)eObject).getAssociationType();
	}
	
	@Override
	protected Object getFeatureByValue(Object value) {
		Integer ftValue = (Integer)value; 
		return AssociationType.get(ftValue);
	}

}
