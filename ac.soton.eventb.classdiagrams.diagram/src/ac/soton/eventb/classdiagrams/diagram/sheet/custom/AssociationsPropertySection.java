/*******************************************************************************
 * Copyright (c) 20014 University of Southampton and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.IFilter;
import org.eventb.emf.core.CorePackage;

import ac.soton.eventb.classdiagrams.Classdiagram;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.diagrams.sheet.AbstractEditTablePropertySection;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;


public class AssociationsPropertySection extends AbstractEditTablePropertySection {

	/**
	 * Element Filter for this property section.
	 */
	public static final class Filter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof Classdiagram;
		}
	}

	@Override
	protected EReference getFeature() {
		return ClassdiagramsPackage.eINSTANCE.getClassdiagram_Associations();
	}

	@Override
	protected EStructuralFeature getFeatureForCol(final int col) {
		switch (col) {
		case 0 : return CorePackage.eINSTANCE.getEventBNamed_Name();
		case 1 : return ClassdiagramsPackage.eINSTANCE.getAssociation_Source();
		case 2 : return ClassdiagramsPackage.eINSTANCE.getAssociation_Target();
		case 3 : return CoreextensionPackage.eINSTANCE.getEventBDataElaboration_DataKind();
		case 4 : return CoreextensionPackage.eINSTANCE.getEventBDataElaboration_Elaborates();
		case 5 : return CoreextensionPackage.eINSTANCE.getEventBRelationKind_Surjective();
		case 6 : return CoreextensionPackage.eINSTANCE.getEventBRelationKind_Injective();
		case 7 : return CoreextensionPackage.eINSTANCE.getEventBRelationKind_Functional();
		case 8 : return CoreextensionPackage.eINSTANCE.getEventBRelationKind_Total();
		case 9 : return CorePackage.eINSTANCE.getEventBCommented_Comment();
		default : return null;
		}
	}

	@Override
	protected boolean isMulti(final int col){
		return col==9 ? true : false;
	}
	
	
	@Override
	protected boolean isRodinKeyboard(final int col) {
		return  false;
	}
	
	@Override
	protected boolean isReadOnly(final int col) {
		return  col>0 && col<5 ? true : false;
	}

	@Override
	protected boolean isReadOnly() {
		return  true;
	}

	@Override
	protected int columnWidth(final int col){
		switch (col) {
		case 0 : return 100;	//name field
		case 1 : return 100;	//source field
		case 2 : return 100;	//target field
		case 3 : return 100;	//dataKind field
		case 4 : return 100;	//elaborates field
		case 5 : return 50;		//surjective field
		case 6 : return 50;		//injective field
		case 7 : return 50;		//functional field
		case 8 : return 50;		//total field
		case 9 : return 400;	//comment field
		default : return -1;	//unknown
		}
	}

	@Override
	protected String getButtonLabelText() {
		return "Association  ";
	}

	
}
