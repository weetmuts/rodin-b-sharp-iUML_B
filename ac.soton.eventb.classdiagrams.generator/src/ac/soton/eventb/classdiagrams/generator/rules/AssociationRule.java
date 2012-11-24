package ac.soton.eventb.classdiagrams.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.generator.strings.Strings;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.core.extension.coreextension.DataKind;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Is;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class AssociationRule extends AbstractRule  implements IRule {

protected static final EReference elaborates = CoreextensionPackage.Literals.EVENT_BDATA_ELABORATION__ELABORATES;
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception{
		assert(sourceElement instanceof Association);
		return true;
	}
	
	@Override
	public boolean dependenciesOK(EventBElement sourceElement, final List<GenerationDescriptor> generatedElements) throws Exception  {
		Association c = (Association)sourceElement;
		if ((c.getSource().getElaborates() != null || Is.generated(generatedElements,null,null,c.getSource().getName())) &&
			(c.getTarget().getElaborates() != null || Is.generated(generatedElements,null,null,c.getTarget().getName()))){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		
		EventBNamedCommentedComponentElement container = (EventBNamedCommentedComponentElement)EcoreUtil.getRootContainer(sourceElement);
		Association element = (Association)sourceElement;
		int dataKind = element.getDataKind().getValue();
		EventBElement elaborated = (EventBElement) element.getElaborates();
		//create element if it's a new one
		if (elaborated==null || Is.generatedBy(elaborated, sourceElement)){
			EventBElement newGeneratedElement = null;
			EReference newGeneratedElementContainer = null;
			EventBElement newGeneratedTypePredicate = null;
			EReference newGeneratedTypePredicateContainer = null;
			EventBElement newGeneratedInjectionPredicate = null;
			switch (dataKind) {
			case DataKind.SET_VALUE :
				// should not get here - associations cannot be sets. make a constant instead.
			case DataKind.CONSTANT_VALUE :
				newGeneratedElement = (EventBElement) Make.constant(element.getName(), element.getComment());
				newGeneratedElementContainer = constants;
				newGeneratedTypePredicate = (EventBElement) Make.axiom(Strings.ASSOCIATION_PRED_NAME(element.getName()), Strings.ASSOCIATION_PRED(element), element.getComment());
				newGeneratedTypePredicateContainer = axioms;
				newGeneratedInjectionPredicate = (EventBElement) Make.axiom(Strings.ASSOCIATION_PRED_INJECTIVE_NAME(element.getName()), Strings.ASSOCIATION_PRED_INJECTIVE(element), element.getComment());
				break;
			case DataKind.VARIABLE_VALUE :
				newGeneratedElement = Make.variable(element.getName(), element.getComment());
				newGeneratedElementContainer = variables;
				newGeneratedTypePredicate = (EventBElement) Make.invariant(Strings.ASSOCIATION_PRED_NAME(element.getName()), Strings.ASSOCIATION_PRED(element), element.getComment());
				newGeneratedTypePredicateContainer = invariants;
				newGeneratedInjectionPredicate = (EventBElement) Make.axiom(Strings.ASSOCIATION_PRED_INJECTIVE_NAME(element.getName()), Strings.ASSOCIATION_PRED_INJECTIVE(element), element.getComment());
				break;
			}
			ret.add(Make.descriptor(container,newGeneratedElementContainer,newGeneratedElement,10));
			ret.add(Make.descriptor(sourceElement, elaborates, newGeneratedElement, 10));
			ret.add(Make.descriptor(container, newGeneratedTypePredicateContainer,newGeneratedTypePredicate, 10));
			if (newGeneratedInjectionPredicate != null){
				ret.add(Make.descriptor(container, newGeneratedTypePredicateContainer, newGeneratedTypePredicate, 10));			
			}
		}
		return ret;
	}

}
