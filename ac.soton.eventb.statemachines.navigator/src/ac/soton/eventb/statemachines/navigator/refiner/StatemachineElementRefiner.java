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

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eventb.emf.core.EventBObject;

import ac.soton.eventb.emf.core.extension.navigator.refiner.CoreextensionElementRefiner;
import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.Transition;

/**
 * State-machine Element Refiner 
 * 
 * @author cfsnook
 *
 */
public class StatemachineElementRefiner extends CoreextensionElementRefiner {

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
	 * incoming, outgoing, source and target (as intra-level references).
	 * Instances
	 */
	@Override
	protected void populateReferenceMap(final Map<EReference,RefHandling> referencemap){
		super.populateReferenceMap(referencemap);
		referencemap.put(StatemachinesPackage.Literals.STATE__REFINES, RefHandling.CHAIN);
		referencemap.put(StatemachinesPackage.Literals.STATEMACHINE__REFINES, RefHandling.CHAIN);	
		referencemap.put(StatemachinesPackage.Literals.ABSTRACT_NODE__INCOMING, RefHandling.EQUIV);
		referencemap.put(StatemachinesPackage.Literals.ABSTRACT_NODE__OUTGOING, RefHandling.EQUIV);
		referencemap.put(StatemachinesPackage.Literals.TRANSITION__SOURCE, RefHandling.EQUIV);
		referencemap.put(StatemachinesPackage.Literals.TRANSITION__TARGET, RefHandling.EQUIV);
		referencemap.put(StatemachinesPackage.Literals.STATEMACHINE__INSTANCES, RefHandling.EQUIV);
	}
	
	/**
	 * Change this to specialise the meaning of 'equivalent' 
	 * (used when finding reference targets in the refined model)
	 * 
	 */
	public EventBObject getEquivalentObject(EObject concreteParent, EObject abstractObject) {
		//EClass clazz = abstractObject.eClass();
		if (abstractObject instanceof Transition){
			Transition t = (Transition) abstractObject;
			TreeIterator<EObject> contents = concreteParent.eAllContents();
			while (contents.hasNext()){
				Object possible = contents.next();
				if (possible instanceof Transition){
					Transition e = (Transition) possible;
					if (//e.getInternalId().equals(t.getInternalId()) || 
							(
							e.getLabel().equals(t.getLabel()) &&
							e.getSource()==getEquivalentObject(concreteParent, t.getSource()) &&
							e.getTarget()==getEquivalentObject(concreteParent, t.getTarget())
							)
						){
						return (EventBObject) possible;
					}
				}
			}
			return null;
		}else{
			return super.getEquivalentObject(concreteParent, abstractObject);
		}
	}
	
}
