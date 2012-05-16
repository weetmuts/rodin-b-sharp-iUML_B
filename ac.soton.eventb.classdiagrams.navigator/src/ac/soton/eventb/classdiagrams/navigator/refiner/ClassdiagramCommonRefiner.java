package ac.soton.eventb.classdiagrams.navigator.refiner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.ClassdiagramsFactory;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;

public class ClassdiagramCommonRefiner {

	/**
	 * Returns refined state from abstract state.
	 * 
	 * @param absClass abstract state
	 * @param map refinement map
	 * @return refined state
	 */
	public static Class refineClass(URI sourceURI, URI targetURI, Class absClass) {
		
		// create refined state
		Class refinedClass = ClassdiagramsFactory.eINSTANCE.createClass();
		refinedClass.setRefines((Class) EMFCoreUtil.createProxy(
				ClassdiagramsPackage.eINSTANCE.getClass_(),
				sourceURI.appendFragment(EcoreUtil.getID(absClass))));
		
		refinedClass.setReference(absClass.getReference());
		
		refinedClass.setName(absClass.getName());
		
		// set transition references
		for (Association inTransition : refinedClass.getIncoming())
			refinedClass.getIncoming().add((Association) EMFCoreUtil.createProxy(
									ClassdiagramsPackage.eINSTANCE.getAssociation(),
									targetURI.appendFragment(EcoreUtil.getURI(inTransition).fragment())));
		for (Association outTransition : refinedClass.getOutgoing())
			refinedClass.getOutgoing().add((Association) EMFCoreUtil.createProxy(
									ClassdiagramsPackage.eINSTANCE.getAssociation(),
									targetURI.appendFragment(EcoreUtil.getURI(outTransition).fragment())));

		return refinedClass;
	}
	
	/**
	 * Refines transitions in abstract classdiagram.
	 * 
	 * @param absSM abstract classdiagram
	 * @param map refinement map
	 */
	public static Association refineAssociation(URI sourceURI, URI targetURI, Association absSM) {
		// process transitions of current abstract classdiagram
		Association refinedAssoc = ClassdiagramsFactory.eINSTANCE.createAssociation();
		refinedAssoc.setReference(absSM.getReference());

		refinedAssoc.setName(absSM.getName());
		
		// set source and target
			refinedAssoc.setSource((Class) EMFCoreUtil.createProxy(
					absSM.getSource().eClass(), 
					targetURI.appendFragment(EcoreUtil.getID(absSM.getSource()))));
			refinedAssoc.setTarget((Class) EMFCoreUtil.createProxy(
					absSM.getTarget().eClass(), 
					targetURI.appendFragment(EcoreUtil.getID(absSM.getTarget()))));
			
		return refinedAssoc;
	}
	
}
