package ac.soton.eventb.classdiagrams.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.context.ContextPackage;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachinePackage;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.AssociationType;
import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassType;
import ac.soton.eventb.classdiagrams.generator.strings.Strings;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class AssociationRule   extends AbstractRule  implements IRule {

	protected static final EReference components = CorePackage.Literals.PROJECT__COMPONENTS;
	protected static final EReference sees = MachinePackage.Literals.MACHINE__SEES;
	protected static final EReference sets = ContextPackage.Literals.CONTEXT__SETS;
	protected static final EReference constants = ContextPackage.Literals.CONTEXT__CONSTANTS;
	protected static final EReference axioms = ContextPackage.Literals.CONTEXT__AXIOMS;
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception{
		assert(sourceElement instanceof Association);
		return true;
	}
	
	@Override
	public boolean dependenciesOK(EventBElement sourceElement, final List<GenerationDescriptor> generatedElements) throws Exception  {
		
//		Class c = (Class)sourceElement;
//		
//		if (c.getSupertypes().size() > 0){
//			for (Class superClass : c.getSupertypes()){
//				if (!supertypeDependenciesSatisfied(superClass, generatedElements)){
//					return false;
//				}
//			}
//		}
		
		return true; //TODO change
	}
	
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		
		EventBNamedCommentedComponentElement container = 
				(EventBNamedCommentedComponentElement)EcoreUtil.getRootContainer(sourceElement);
		Association element = (Association)sourceElement;
		
		//if it's not elaborating the invariant - create one
		if (element.getElaborates() == null){
			int elementType = element.getAssociationType().getValue();
			
			//if does not elaborate, then create a variable/constant and the appropriate predicate (invariant/axiom)
			switch (elementType) {
				case AssociationType.CONSTANT_VALUE :
					ret.add(Make.descriptor(container, 
							constants, 
							Make.constant(element.getName(), 
							element.getComment()),
							10));
					ret.add(Make.descriptor(container, 
							axioms, 
							Make.axiom(Strings.ASSOCIATION_PRED_NAME(element.getName()), 
							Strings.ASSOCIATION_PRED(element), 
							element.getComment()),
							10));
					if (element.isInjective()){
						ret.add(Make.descriptor(container, 
							axioms, 
							Make.axiom(Strings.ASSOCIATION_PRED_INJECTIVE_NAME(element.getName()), 
							Strings.ASSOCIATION_PRED_INJECTIVE(element), 
							element.getComment()),
							10));						
					}
					break;
				case AssociationType.VARIABLE_VALUE :
					ret.add(Make.descriptor(container,
							variables,
							Make.variable(element.getName(), element.getComment()),
							10));
					ret.add(Make.descriptor(container, 
							invariants, 
							Make.invariant(Strings.ASSOCIATION_PRED_NAME(element.getName()), 
							Strings.ASSOCIATION_PRED(element), 
							element.getComment()),
							10));
					if (element.isInjective()){
						ret.add(Make.descriptor(container, 
							invariants, 
							Make.invariant(Strings.ASSOCIATION_PRED_INJECTIVE_NAME(element.getName()), 
							Strings.ASSOCIATION_PRED_INJECTIVE(element), 
							element.getComment()),
							10));						
					}
					break;
			}
		}
		
		return ret;
	}
	
	private EStructuralFeature getPredicate(
			EventBNamedCommentedComponentElement pContainer) {
		if (pContainer instanceof Context){
			return axioms;
		} else if (pContainer instanceof Machine){
			return invariants;
		} else {
			return null;			
		}
	}
}
