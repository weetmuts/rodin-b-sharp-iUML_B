package ac.soton.eventb.classdiagrams.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassConstraint;
import ac.soton.eventb.classdiagrams.generator.strings.Strings;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Is;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class ClassConstraintRule extends AbstractRule  implements IRule {
	
	protected static final EReference elaborates = CoreextensionPackage.Literals.EVENT_BDATA_ELABORATION__ELABORATES;

	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception{
		assert(sourceElement instanceof ClassConstraint);
		if (!(((ClassConstraint)sourceElement).eContainer() instanceof Class)) return false;
		return true;
	}
	
	@Override
	public boolean dependenciesOK(EventBElement sourceElement, final List<GenerationDescriptor> generatedElements) throws Exception  {
		Class parentClass = (Class) ((ClassConstraint)sourceElement).eContainer();	
		if (parentClass.getElaborates() != null || Is.generated(generatedElements,null,null,parentClass.getName())) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Class parentClass = (Class) ((ClassConstraint)sourceElement).eContainer();	
		EventBNamedCommentedComponentElement container = (EventBNamedCommentedComponentElement)EcoreUtil.getRootContainer(sourceElement);
		ClassConstraint element = (ClassConstraint)sourceElement;

		//create element
		EventBElement newGeneratedPredicateElement = null;
		EReference newGeneratedPredicateContainmentFeature = null;
		EventBNamed classSet = parentClass.getElaborates();
		String predicate = Strings.CLASS_CONSTRAINT_PRED("this"+parentClass.getName(), classSet.getName(), element.getPredicate());

		if (container instanceof Machine){
			newGeneratedPredicateContainmentFeature = invariants;
			newGeneratedPredicateElement = (EventBElement) Make.invariant(Strings.CLASS_CONSTRAINT_NAME(element.getName()), element.isTheorem(), predicate, element.getComment());			
		}else if (container instanceof Context){
			newGeneratedPredicateContainmentFeature = axioms;
			newGeneratedPredicateElement = (EventBElement) Make.axiom(Strings.CLASS_CONSTRAINT_NAME(element.getName()), element.isTheorem(), predicate, element.getComment());			
		}
		//return a descriptor
		if (newGeneratedPredicateElement != null){
			ret.add(Make.descriptor(container, newGeneratedPredicateContainmentFeature, newGeneratedPredicateElement, -1));			
		}
		return ret;
	}	
}
