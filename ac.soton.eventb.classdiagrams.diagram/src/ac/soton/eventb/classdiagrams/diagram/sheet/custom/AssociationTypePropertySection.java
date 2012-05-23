/*
 * Copyright (c) 2011 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.AssociationType;
import ac.soton.eventb.classdiagrams.ClassType;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.Class;

/**
 * Translation property section for Classdiagrams.
 * 
 * @author vitaly
 *
 */
public class AssociationTypePropertySection extends AbstractEnumerationPropertySection {
	
	private Map<String, String> getAssociationTypeMap(){
		Map<String, String> associationTypeMap = new TreeMap<String, String>();
		
		EObject container = EcoreUtil.getRootContainer(eObject);
		
		
		//TODO determine associated class types
		Class source = ((Association)eObject).getSource();
		Class target = ((Association)eObject).getTarget();
		
		//association may be constant only when both classes are constants
		if ((source.getClassType() != ClassType.VARIABLE) && (target.getClassType() != ClassType.VARIABLE) &&
			container instanceof Context){
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
		return ((Association) eObject).getAssociationType().getLiteral().equals(selection);
	}

	@Override
	protected String[] getEnumerationFeatureValues() {
		return getAssociationTypeMap().values().toArray(new String[0]);
	}

	@Override
	protected String getFeatureAsText() {
		return getCurrentAssociationType().getLiteral();
	}

	@Override
	protected Object getFeatureValue(String selection) {
		return AssociationType.get(selection).getValue();
	}

	@Override
	protected String getLabelText() {
		return "Class type:";
	}

	@Override
	protected EStructuralFeature getFeature() {
		return ClassdiagramsPackage.Literals.ASSOCIATION__ASSOCIATION_TYPE;
	}

	@Override
	public void refresh() {
		combo.setItems(getEnumerationFeatureValues());
		combo.setText(getFeatureAsText());
		combo.setEnabled(((Association)eObject).getElaborates() == null);
	}
	
	private AssociationType getCurrentAssociationType(){
		if (((Association)(eObject)).getElaborates() != null){
			EventBNamed ebe = ((Association)(eObject)).getElaborates();
			
		 if (ebe.eContainingFeature().getName().equals("constants")){
				return AssociationType.CONSTANT;			
			} else {
				return AssociationType.VARIABLE;
			}
		} else {
//			return ((Association) eObject).getAssociationType();
			return (AssociationType)getFeatureByValue(getFeatureValue(combo.getItem(0)));
		}
	}
	
	@Override
	protected Object getFeatureByValue(Object value) {
		Integer ftValue = (Integer)value; 
		return AssociationType.get(ftValue);
	}
}
