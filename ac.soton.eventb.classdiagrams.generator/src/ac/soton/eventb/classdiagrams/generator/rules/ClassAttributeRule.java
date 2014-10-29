package ac.soton.eventb.classdiagrams.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;

import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.classdiagrams.generator.strings.Strings;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.core.extension.coreextension.DataKind;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class ClassAttributeRule extends AbstractRule  implements IRule {
	
	protected static final EReference elaborates = CoreextensionPackage.Literals.EVENT_BDATA_ELABORATION__ELABORATES;

	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception{
		assert(sourceElement instanceof ClassAttribute);
		return ((ClassAttribute)sourceElement).getElaborates() != null;
	}
	
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		ClassAttribute element = (ClassAttribute)sourceElement;
		EventBElement elaborated = (EventBElement) element.getElaborates();
		EventBNamedCommentedComponentElement component = (EventBNamedCommentedComponentElement) elaborated.getContaining(CorePackage.Literals.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT);		
		EventBElement newGeneratedTypePredicate = null;
		EReference newGeneratedTypePredicateContainer = null;
		EventBElement newGeneratedInjectionPredicate = null;
		switch (element.getDataKind().getValue()) {
		case DataKind.SET_VALUE :
			// should not get here - attributes cannot be sets. make a constant instead.
		case DataKind.CONSTANT_VALUE :
			newGeneratedTypePredicate = (EventBElement) Make.axiom(Strings.CLASS_ATTRIBUTE_PRED_NAME(element.getName()), Strings.CLASS_ATTRIBUTE_PRED(element), element.getComment());
			newGeneratedTypePredicateContainer = axioms;
			if (!element.isFunctional() && element.isInjective()){
				newGeneratedInjectionPredicate = (EventBElement) Make.axiom(Strings.CLASS_ATTRIBUTE_PRED_INJECTIVE_NAME(element.getName()), Strings.CLASS_ATTRIBUTE_PRED_INJECTIVE(element), element.getComment());
			}
			break;
		case DataKind.VARIABLE_VALUE :
			newGeneratedTypePredicate = (EventBElement) Make.invariant(Strings.CLASS_ATTRIBUTE_PRED_NAME(element.getName()), Strings.CLASS_ATTRIBUTE_PRED(element), element.getComment());
			newGeneratedTypePredicateContainer = invariants;
			if (!element.isFunctional() && element.isInjective()){
				newGeneratedInjectionPredicate = (EventBElement) Make.invariant(Strings.CLASS_ATTRIBUTE_PRED_INJECTIVE_NAME(element.getName()), Strings.CLASS_ATTRIBUTE_PRED_INJECTIVE(element), element.getComment());
			}
			break;
		}
		ret.add(Make.descriptor(component, newGeneratedTypePredicateContainer,newGeneratedTypePredicate, 10));
		if (newGeneratedInjectionPredicate != null){
			ret.add(Make.descriptor(component, newGeneratedTypePredicateContainer, newGeneratedInjectionPredicate, -1));			
		}
		return ret;
	}
	
}
