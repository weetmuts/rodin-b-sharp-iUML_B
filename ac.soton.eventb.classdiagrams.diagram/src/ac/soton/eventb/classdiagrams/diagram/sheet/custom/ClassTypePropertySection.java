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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.ClassType;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.Class;

/**
 * Translation property section for Classdiagrams.
 * 
 * @author vitaly
 *
 */
public class ClassTypePropertySection extends AbstractEnumerationPropertySection {
	
	private Map<String, String> getClassTypeMap(){
		Map<String, String> classTypeMap = new HashMap<String, String>();
		
		EObject container = EcoreUtil.getRootContainer(eObject);
		
		if (container instanceof Context){
			classTypeMap.put(ClassType.SET.getName(), ClassType.SET.getLiteral());
			classTypeMap.put(ClassType.CONSTANT.getName(), ClassType.CONSTANT.getLiteral());			
		}
		
		//TODO left the possibility to set it to variable although association may be a constant
		if (container instanceof Machine){
			classTypeMap.put(ClassType.VARIABLE.getName(), ClassType.VARIABLE.getLiteral());
		} 
		
		return classTypeMap;
	}
	
	public void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
	}

	@Override
	protected boolean isEqual(int index) {
		return ClassType.VALUES.get(index).equals(((Class) eObject).getClassType());
	}

	@Override
	protected String[] getEnumerationFeatureValues() {
		return getClassTypeMap().values().toArray(new String[0]);
	}

	@Override
	protected String getFeatureAsText() {
		return getCurrentClassType().getLiteral();
	}

	@Override
	protected Object getFeatureValue(int index) {
		return ClassType.VALUES.get(index);
	}

	@Override
	protected String getLabelText() {
		return "Class type:";
	}

	@Override
	protected EStructuralFeature getFeature() {
		return ClassdiagramsPackage.Literals.CLASS__CLASS_TYPE;
	}
	
	@Override
	public void refresh() {
		combo.setItems(getEnumerationFeatureValues());
		combo.setText(getFeatureAsText());
		combo.setEnabled(((Class)eObject).getElaborates() == null);
	}
	
	private ClassType getCurrentClassType(){
		if (((Class)(eObject)).getElaborates() != null){
			EventBNamed ebe = ((Class)(eObject)).getElaborates();
			
			if (ebe.eContainingFeature().getName().equals("sets")){
				return ClassType.SET;
			} else if (ebe.eContainingFeature().getName().equals("constants")){
				return ClassType.CONSTANT;			
			} else {
				return ClassType.VARIABLE;
			}
		} else {
			return ((Class) eObject).getClassType();
		}
	}

}
