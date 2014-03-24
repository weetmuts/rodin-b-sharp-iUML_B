/*******************************************************************************
 * Copyright (c) 2012 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ac.soton.eventb.statemachines.navigator.refiner;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.emf.core.extension.navigator.refiner.AbstractExtensionRefiner;

/**
 * Statemachine Refiner 
 * 
 * @author cfsnook
 *
 */
public class StatemachineRefiner extends AbstractExtensionRefiner {

	/**
	 * populate the given list with the meta-classes that the refiner needs to filter out
	 *  from the copy for statemachine refinement.
	 * (e.g. state invariants)
	 */
	@Override
	protected void populateFilterByTypeList(final List<EClass> filterList){
		super.populateFilterByTypeList(filterList);
	}
	
	/**
	 * populate the given map with the reference features that the refiner needs to copy for statemachine refinement.
	 * This is refines (as references to their abstract counterparts) and
	 * incoming, outgoing, source and target (as intra-level references) 
	 */
	@Override
	protected void populateReferenceMap(final Map<EReference,Boolean> referencemap){
		super.populateReferenceMap(referencemap);
		referencemap.put(StatemachinesPackage.Literals.STATE__REFINES, true);
		referencemap.put(StatemachinesPackage.Literals.STATEMACHINE__REFINES, true);	
		referencemap.put(StatemachinesPackage.Literals.ABSTRACT_NODE__INCOMING, false);
		referencemap.put(StatemachinesPackage.Literals.ABSTRACT_NODE__OUTGOING, false);
		referencemap.put(StatemachinesPackage.Literals.TRANSITION__SOURCE, false);
		referencemap.put(StatemachinesPackage.Literals.TRANSITION__TARGET, false);
		referencemap.put(StatemachinesPackage.Literals.STATEMACHINE__INSTANCES, false);
	}

/**
 * returns the Components Extension ID
 */
	@Override
	protected String getExtensionID() {
		return StatemachinesPackage.STATEMACHINES_EXTENSION_ID;
	}
	
}
