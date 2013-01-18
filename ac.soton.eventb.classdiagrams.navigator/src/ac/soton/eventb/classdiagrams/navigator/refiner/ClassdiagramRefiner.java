/*******************************************************************************
 * Copyright (c) 2012 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ac.soton.eventb.classdiagrams.navigator.refiner;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eventb.emf.core.machine.MachinePackage;

import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.emf.core.extension.navigator.refiner.AbstractExtensionRefiner;

/**
 * Class diagram Refiner 
 * 
 * @author cfsnook
 *
 */
public class ClassdiagramRefiner extends AbstractExtensionRefiner {

	/**
	 * populate the given list with the meta-classes that the refiner needs to filter out
	 *  from the copy for statemachine refinement.
	 * (e.g. state invariants)
	 */
	@Override
	protected void populateFilterByTypeList(final List<EClass> filterList){
		filterList.add(MachinePackage.Literals.INVARIANT);
	}
	
	/**
	 * populate the given map with the reference features that the refiner needs to copy for class diagram refinement.
	 * This is refines (as references to their abstract counterparts) and
	 * elaborates, incoming, outgoing, source and target (as intra-level references) 
	 */
	@Override
	protected void populateReferenceMap(final Map<EReference,Boolean> referencemap){
		super.populateReferenceMap(referencemap);
		referencemap.put(ClassdiagramsPackage.Literals.CLASS__REFINES, true);
		referencemap.put(ClassdiagramsPackage.Literals.CLASSDIAGRAM__REFINES, true);	
		referencemap.put(ClassdiagramsPackage.Literals.ASSOCIATION__SOURCE, false);
		referencemap.put(ClassdiagramsPackage.Literals.ASSOCIATION__TARGET, false);
		referencemap.put(ClassdiagramsPackage.Literals.CLASS__INCOMING, false);
		referencemap.put(ClassdiagramsPackage.Literals.CLASS__OUTGOING, false);
	}

/**
 * returns the Components Extension ID
 */
	@Override
	protected String getExtensionID() {
		return ClassdiagramsPackage.CLASSDIAGRAMS_EXTENSION_ID;
	}

}
