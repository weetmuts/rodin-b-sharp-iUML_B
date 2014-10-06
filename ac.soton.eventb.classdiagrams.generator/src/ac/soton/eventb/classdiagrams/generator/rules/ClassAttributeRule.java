package ac.soton.eventb.classdiagrams.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.classdiagrams.generator.strings.Strings;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.core.extension.coreextension.DataKind;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Is;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class ClassAttributeRule extends AbstractRule  implements IRule {
	
	protected static final EReference elaborates = CoreextensionPackage.Literals.EVENT_BDATA_ELABORATION__ELABORATES;

	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception{
		assert(sourceElement instanceof ClassAttribute);
		if (!(((ClassAttribute)sourceElement).eContainer() instanceof Class)) return false;
		return true;
	}
	
	@Override
	public boolean dependenciesOK(EventBElement sourceElement, final List<GenerationDescriptor> generatedElements) throws Exception  {
		ClassAttribute at = (ClassAttribute)sourceElement;
		Class cl = (Class)at.eContainer();		
		if (cl.getElaborates() != null || Is.generated(generatedElements,null,null,cl.getName())) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		
		EventBNamedCommentedComponentElement container = (EventBNamedCommentedComponentElement)EcoreUtil.getRootContainer(sourceElement);
		ClassAttribute element = (ClassAttribute)sourceElement;
		int dataKind = element.getDataKind().getValue();
		EventBElement elaborated = (EventBElement) element.getElaborates();
		if (elaborated!=null){
			EObject elaboratedRoot = EcoreUtil.getRootContainer(elaborated);
			if (elaboratedRoot instanceof EventBNamedCommentedComponentElement){
				container = (EventBNamedCommentedComponentElement)elaboratedRoot;
			}else{
				return ret; //can't find root
			}
		}else{
			container = (EventBNamedCommentedComponentElement)EcoreUtil.getRootContainer(sourceElement);
			if (dataKind != DataKind.VARIABLE_VALUE){
				return ret; //NOT YET SUPPORTED
			}
		}
		EventBElement newGeneratedElement = null;
		EReference newGeneratedElementContainer = null;
		EventBElement newGeneratedTypePredicate = null;
		EReference newGeneratedTypePredicateContainer = null;
		EventBElement newGeneratedInjectionPredicate = null;
		switch (dataKind) {
		case DataKind.SET_VALUE :
			// should not get here - attributes cannot be sets. make a constant instead.
		case DataKind.CONSTANT_VALUE :
			if (elaborated==null || Is.generatedBy(elaborated, sourceElement)){
				newGeneratedElement = (EventBElement) Make.constant(element.getName(), element.getComment());
				newGeneratedElementContainer = constants;
			}				
			newGeneratedTypePredicate = (EventBElement) Make.axiom(Strings.CLASS_ATTRIBUTE_PRED_NAME(element.getName()), Strings.CLASS_ATTRIBUTE_PRED(element), element.getComment());
			newGeneratedTypePredicateContainer = axioms;
			if (!element.isFunctional() && element.isInjective()){
				newGeneratedInjectionPredicate = (EventBElement) Make.axiom(Strings.CLASS_ATTRIBUTE_PRED_INJECTIVE_NAME(element.getName()), Strings.CLASS_ATTRIBUTE_PRED_INJECTIVE(element), element.getComment());
			}
			break;
		case DataKind.VARIABLE_VALUE :
			if (elaborated==null || Is.generatedBy(elaborated, sourceElement)){
				newGeneratedElement = Make.variable(element.getName(), element.getComment());
				newGeneratedElementContainer = variables;
			}
			newGeneratedTypePredicate = (EventBElement) Make.invariant(Strings.CLASS_ATTRIBUTE_PRED_NAME(element.getName()), Strings.CLASS_ATTRIBUTE_PRED(element), element.getComment());
			newGeneratedTypePredicateContainer = invariants;
			if (!element.isFunctional() && element.isInjective()){
				newGeneratedInjectionPredicate = (EventBElement) Make.invariant(Strings.CLASS_ATTRIBUTE_PRED_INJECTIVE_NAME(element.getName()), Strings.CLASS_ATTRIBUTE_PRED_INJECTIVE(element), element.getComment());
			}
			break;
		}
		if (newGeneratedElement!=null){		
			ret.add(Make.descriptor(container,newGeneratedElementContainer,newGeneratedElement,10));
			ret.add(Make.descriptor(sourceElement, elaborates, newGeneratedElement, 10));
		}
		ret.add(Make.descriptor(container, newGeneratedTypePredicateContainer,newGeneratedTypePredicate, 10));
		if (newGeneratedInjectionPredicate != null){
			ret.add(Make.descriptor(container, newGeneratedTypePredicateContainer, newGeneratedInjectionPredicate, -1));			
		}
		return ret;
	}
	
}
