/*
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.IFilter;
import org.eventb.emf.core.CorePackage;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.diagrams.sheet.AbstractEditTablePropertySection;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;


/**
 * Class Supertypes property section
 * 
 *
 */
public class SupertypesPropertySection extends AbstractEditTablePropertySection {

	/**
	 * Element Filter for this property section.
	 */
	public static final class Filter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof Class;
		}
	}
	
	@Override
	protected EStructuralFeature getFeature() {
		return ClassdiagramsPackage.Literals.CLASS__SUPERTYPES;
	}

	@Override
	protected Object getFeatureForCol(int col) {
		switch (col) {
		case 0 : return CorePackage.eINSTANCE.getEventBNamed_Name();
		case 1 : return ClassdiagramsPackage.eINSTANCE.getClass_SelfName();
		case 2 : return CoreextensionPackage.eINSTANCE.getEventBDataElaboration_DataKind();
		case 3 : return CoreextensionPackage.eINSTANCE.getEventBDataElaboration_Elaborates();
		case 4 : return ClassdiagramsPackage.eINSTANCE.getClass_Refines();
		case 5 : return CorePackage.eINSTANCE.getEventBCommented_Comment();
		default : return null;
		}
	}
	
	@Override
	protected boolean isMulti(final int col){
		return col==5 ? true : false;
	}
	
	@Override
	protected boolean isReadOnly(final int col) {
		return  col==2 || col==3 || col==4 ? true : false;
	}

	@Override
	protected int columnWidth(final int col){
		switch (col) {
		case 0 : return 100;	//name field
		case 1 : return 100;	//selfname field
		case 2 : return 100;	//dataKind field
		case 3 : return 100;	//elaborates field
		case 4 : return 100;	//refines field
		case 5 : return 400;	//comment field
		default : return -1;	//unknown
		}
	}
		
}