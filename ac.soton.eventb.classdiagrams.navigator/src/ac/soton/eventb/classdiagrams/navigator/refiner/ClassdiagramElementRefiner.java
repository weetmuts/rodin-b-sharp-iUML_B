package ac.soton.eventb.classdiagrams.navigator.refiner;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eventb.emf.core.EventBObject;

import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.emf.core.extension.navigator.refiner.CoreextensionElementRefiner;

/**
 * Class diagram Element Refiner 
 * 
 * @author cfsnook
 *
 */

public class ClassdiagramElementRefiner extends CoreextensionElementRefiner {

	/**
	 * populate the given list with the meta-classes that the refiner needs to filter out
	 *  from the copy for class diagram refinement.
	 * (e.g. state invariants)
	 */
	@Override
	protected void populateFilterByTypeList(final List<EClass> filterList){
		super.populateFilterByTypeList(filterList);
		filterList.add(ClassdiagramsPackage.Literals.CLASS_CONSTRAINT);
	}
	
	/**
	 * populate the given map with the reference features that the refiner needs to copy for class diagram refinement.
	 * 
	 */
	@Override
	protected void populateReferenceMap(final Map<EReference,RefHandling> referencemap){
		super.populateReferenceMap(referencemap);
		referencemap.put(ClassdiagramsPackage.Literals.CLASS__REFINES, RefHandling.CHAIN);
		referencemap.put(ClassdiagramsPackage.Literals.CLASSDIAGRAM__REFINES, RefHandling.CHAIN);	
		referencemap.put(ClassdiagramsPackage.Literals.ASSOCIATION__SOURCE, RefHandling.EQUIV);
		referencemap.put(ClassdiagramsPackage.Literals.ASSOCIATION__TARGET, RefHandling.EQUIV);
		referencemap.put(ClassdiagramsPackage.Literals.CLASS__INCOMING, RefHandling.EQUIV);
		referencemap.put(ClassdiagramsPackage.Literals.CLASS__OUTGOING, RefHandling.EQUIV);
		referencemap.put(ClassdiagramsPackage.Literals.CLASS__SUPERTYPES, RefHandling.DROP);
	}
	
	/**
	 * Change this to specialise the meaning of 'equivalent' 
	 * (used when finding reference targets in the refined model)
	 * 
	 */
	public EventBObject getEquivalentObject(EObject concreteParent, EObject abstractObject) {
		return super.getEquivalentObject(concreteParent, abstractObject);
	}
		
}