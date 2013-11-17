/*******************************************************************************
 * Copyright (c) 2006,2007,2008 University of Southampton and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package ac.soton.eventb.statemachines.diagram.sheet.custom;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.emf.core.CorePackage;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;


/**
 * Operation parameters tab table property section.
 *
 * @author Colin Snook
 */

public class ParametersPropertySection extends AbstractEditTablePropertySection {


//	@Override
//	protected String getButtonLabelText(){
//		return "Parameter";
//	}



	@Override
	protected EReference getFeature() {
		return CoreextensionPackage.eINSTANCE.getEventBEventGroup_Parameters();
	}

//	@Override
//	protected List<String> getColumnLabelText() {
//		ArrayList<String> ret = new ArrayList<String>();
//		ret.add("Name");
//		return ret;
//	}

	@Override
	protected EStructuralFeature getFeatureForCol(final int col) {
		switch (col) {
		case 0 : return CorePackage.eINSTANCE.getEventBNamed_Name();
		case 1 : return CoreextensionPackage.eINSTANCE.getType_Type();
		case 2 : return CorePackage.eINSTANCE.getEventBCommented_Comment();
		default : return null;
		}
	}

	@Override
	protected boolean isRodinKeyboard(final int col) {
		return col==1? true : false;
	}

	@Override
	protected int columnWidth(final int col){
		switch (col) {
		case 0 : return 150;	//name field
		case 1 : return 150;	//name field
		case 2 : return 400;	//comment field
		default : return -1;	//unknown
		}
	}

	@Override
	protected String getLabelText() {
		return "parameters";
	}

}