/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.sheet.custom;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.IFilter;
import org.eventb.emf.core.CorePackage;

import ac.soton.eventb.emf.diagrams.sheet.AbstractEditTableWithDefaultNamingPropertySection;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;
import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.StatemachinesPackage;

/**
 * Entry Actions property section for State.
 * 
 * @author cfs
 *
 */
public class EntryActionsPropertySection extends AbstractEditTableWithDefaultNamingPropertySection {

	/**
	 * Element Filter for this property section.
	 */
	public static final class Filter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof State;
		}
	}
	
	@Override
	protected EReference getFeature() {
		return StatemachinesPackage.Literals.STATE__ENTRY_ACTIONS;
	}

	@Override
	protected EStructuralFeature getFeatureForCol(final int col) {
		switch (col) {
		case 0 : return CorePackage.Literals.EVENT_BNAMED__NAME;
		case 1 : return CorePackage.Literals.EVENT_BACTION__ACTION;
		case 2 : return CorePackage.Literals.EVENT_BCOMMENTED__COMMENT;
		default : return null;
		}
	}

	@Override
	protected boolean isRodinKeyboard(final int col) {
		return col==1 ? true : false;
	}
	
	@Override
	protected boolean isMulti(final int col){
		switch (col) {
		case 0 : return false;	//name
		case 1 : return true;	//action field
		case 2 : return true;	//comment field
		default : return false;	//unknown
		}
	}
	
	@Override
	protected int columnWidth(final int col){
		switch (col) {
		case 0 : return 160;	//name
		case 1 : return 400;	//action field
		case 2 : return 400;	//comment field
		default : return -1;	//unknown
		}
	}

}
