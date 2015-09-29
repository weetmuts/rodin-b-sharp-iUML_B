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
 * Invariants property section for State.
 * 
 * @author cfs
 *
 */
public class InvariantsPropertySection extends AbstractEditTableWithDefaultNamingPropertySection {

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
		return StatemachinesPackage.Literals.STATE__INVARIANTS;
	}

	@Override
	protected EStructuralFeature getFeatureForCol(final int col) {
		switch (col) {
		case 0 : return CorePackage.Literals.EVENT_BNAMED__NAME;
		case 1 : return CorePackage.Literals.EVENT_BDERIVED__THEOREM;
		case 2 : return CorePackage.Literals.EVENT_BPREDICATE__PREDICATE;
		case 3 : return CorePackage.Literals.EVENT_BCOMMENTED__COMMENT;
		default : return null;
		}
	}

	@Override
	protected boolean isRodinKeyboard(final int col) {
		return col==2 ? true : false;
	}
	
	@Override
	protected boolean isMulti(final int col){
		switch (col) {
		case 0 : return false;	//name
		case 1 : return false;		//theorem field
		case 2 : return true;	//predicate field
		case 3 : return true;	//comment field
		default : return false;	//unknown
		}
	}
	
	@Override
	protected int columnWidth(final int col){
		switch (col) {
		case 0 : return 160;	//name
		case 1 : return 60;		//theorem field
		case 2 : return 400;	//predicate field
		case 3 : return 400;	//comment field
		default : return -1;	//unknown
		}
	}

}
