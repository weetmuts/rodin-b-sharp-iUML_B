package ac.soton.eventb.classdiagrams.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.classdiagrams.generator.strings.Strings;
import ac.soton.eventb.emf.core.extension.coreextension.DataKind;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Is;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class ClassAttributeRule extends AbstractRule  implements IRule {
	
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
		int elementType = element.getDataKind().getValue();
		
		//if it's not elaborating an existing element, create one
		if (element.getElaborates() == null){
			//if does not elaborate, then create a variable/constant and the appropriate predicate (invariant/axiom)
			switch (elementType) {
				case DataKind.CONSTANT_VALUE :
					ret.add(Make.descriptor(container, 
							constants, 
							Make.constant(element.getName(), 
							element.getComment()),
							10));
					ret.add(Make.descriptor(container, 
							axioms, 
							Make.axiom(Strings.CLASS_ATTRIBUTE_PRED_NAME(element.getName()), 
							Strings.CLASS_ATTRIBUTE_PRED(element), 
							element.getComment()),
							10));
					if (element.isInjective()){
						ret.add(Make.descriptor(container, 
							axioms, 
							Make.axiom(Strings.CLASS_ATTRIBUTE_PRED_INJECTIVE_NAME(element.getName()), 
							Strings.CLASS_ATTRIBUTE_PRED_INJECTIVE(element), 
							element.getComment()),
							10));						
					}
					break;
				case DataKind.VARIABLE_VALUE :
					ret.add(Make.descriptor(container,
							variables,
							Make.variable(element.getName(), element.getComment()),
							10));
					ret.add(Make.descriptor(container, 
							invariants, 
							Make.invariant(Strings.CLASS_ATTRIBUTE_PRED_NAME(element.getName()), 
							Strings.CLASS_ATTRIBUTE_PRED(element), 
							element.getComment()),
							10));
					if (element.isInjective()){
						ret.add(Make.descriptor(container, 
							invariants, 
							Make.invariant(Strings.CLASS_ATTRIBUTE_PRED_INJECTIVE_NAME(element.getName()), 
							Strings.CLASS_ATTRIBUTE_PRED_INJECTIVE(element), 
							element.getComment()),
							10));						
					}
					break;
			}
		}	
		return ret;
	}	
}
