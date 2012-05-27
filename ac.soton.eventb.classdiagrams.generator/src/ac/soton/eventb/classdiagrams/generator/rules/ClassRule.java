package ac.soton.eventb.classdiagrams.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.EventBNamedCommentedElement;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.context.ContextPackage;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachinePackage;
import org.eventb.emf.core.machine.Variable;
import org.eventb.emf.core.machine.impl.InvariantImpl;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.classdiagrams.ClassType;
import ac.soton.eventb.classdiagrams.generator.strings.Strings;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class ClassRule  extends AbstractRule  implements IRule {

	protected static final EReference components = CorePackage.Literals.PROJECT__COMPONENTS;
	protected static final EReference sees = MachinePackage.Literals.MACHINE__SEES;
	protected static final EReference sets = ContextPackage.Literals.CONTEXT__SETS;
	protected static final EReference constants = ContextPackage.Literals.CONTEXT__CONSTANTS;
	protected static final EReference axioms = ContextPackage.Literals.CONTEXT__AXIOMS;
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception{
		assert(sourceElement instanceof Class);

		if (sourceElement instanceof Class){
			return true;
		} else {
			return false;
		}//TODO change to true
	}
	
	@Override
	public boolean dependenciesOK(EventBElement sourceElement, final List<GenerationDescriptor> generatedElements) throws Exception  {
		
		Class c = (Class)sourceElement;
		
		if (c.getSupertypes().size() > 0){
			for (Class superClass : c.getSupertypes()){
				if (!isGenerated(superClass, generatedElements)){
					return false;
				}
			}
		}
		
		return true; 
	}
	
	private boolean isGenerated(EventBNamedCommentedElement source, final List<GenerationDescriptor> generatedElements) {
		for (GenerationDescriptor gd : generatedElements){
			if (gd.value instanceof EventBNamedCommentedElement){

				if (source.getName().equals(((EventBNamedCommentedElement)gd.value).getName())){
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		
		EventBNamedCommentedComponentElement container = 
				(EventBNamedCommentedComponentElement)EcoreUtil.getRootContainer(sourceElement);
		Class element = (Class)sourceElement;
		
		boolean isContext = container instanceof Context; 
		
		//create element if it's a new one
		if (element.getElaborates() == null){
			int ct = element.getClassType().getValue();
			
			switch (ct) {
				case ClassType.SET_VALUE :
					ret.add(Make.descriptor(container, sets, Make.set(element.getName(), element.getComment()),10));
					break;
				case ClassType.CONSTANT_VALUE :
					ret.add(Make.descriptor(container, constants, Make.constant(element.getName(), element.getComment()),10));
					break;
				case ClassType.VARIABLE_VALUE :
					ret.add(Make.descriptor(container,variables,Make.variable(element.getName(), element.getComment()),10));
					break;
			}
		}
		
		//TODO process attributes? or is it possible to do it separately in the other class?
		//-----------------
		
		//TODO process supertype invariants
		if (element.getSupertypes() != null && element.getSupertypes().size() > 0){
			if (isContext){
				ret.add(Make.descriptor(container,getPredicate(container), Make.axiom(
						Strings.CLASS_SUPERTYPE_NAME(element), 
						Strings.CLASS_SUPERTYPE_PRED(
								element, element.getSupertypes()), 
						element.getComment()),10));
			} else {
				ret.add(Make.descriptor(container,getPredicate(container), Make.invariant(
						Strings.CLASS_SUPERTYPE_NAME(element), 
						Strings.CLASS_SUPERTYPE_PRED(
								element, element.getSupertypes()), 
						element.getComment()),10));
			}
		}
		
//		System.out.println("generatedElements: " + generatedElements.size());
//		
//		assert(enabled(sourceElement));
//		Class cp = (Class) sourceElement;
//		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
//		
//		Machine machine = (Machine)sourceElement.getContaining(MachinePackage.Literals.MACHINE);
//		Event initialisation = (Event) Find.named(machine.getEvents(), "INITIALISATION");
//		
//		if (cp.isConstant()){
//			Context context = null;
//			
//			//look for an already existing context
//			for (GenerationDescriptor gd :  generatedElements){
//				if (gd.value instanceof Context){
//					if (((Context)gd.value).getName().equals(cp.getTargetContext())){
//						context = (Context)gd.value;
//					}
//				}
//			}
//			
//			//if nor found - create one
//			if (context == null){
//				context = (Context)Make.context(cp.getTargetContext(), "");
//				ret.add(Make.descriptor(null, components, context,10));
//				ret.add(Make.descriptor(machine, sees, context,10));
//			}
//			
//			
//			
//			if (cp.getInstance() == null || cp.getInstance().isEmpty()){
//				ret.add(Make.descriptor(context, sets, Make.set(cp.getName(), "wake up kinds"),10));
//			} else {
//				ret.add(Make.descriptor(context, constants, Make.constant(cp.getName(), "wake up kind: addEvent"),10));
//				ret.add(Make.descriptor(context, axioms, Make.axiom(cp.getName(), cp.getInstance(), ""),10));			
//			}
//			
//		} else {
//			//add class variable
//			ret.add(Make.descriptor(machine,variables,Make.variable(cp.getName(), cp.getComment()),10));
//			
//			//it's dynamic, so variable is defined in the machine
//			if (cp.getSupertypes().size() > 0) {
//				ret.add(Make.descriptor(machine,invariants,Make.invariant(Strings.CLASS_SUPERTYPE_NAME(cp), Strings.CLASS_SUPERTYPE_PRED(cp, cp.getSupertypes()), cp.getComment()),10));
//			}
//			
//			//set instance
//			//need instance field
//			if (cp.getInstance() != null && !cp.getInstance().isEmpty()){
//				ret.add(Make.descriptor(machine,invariants,Make.invariant(Strings.CLASS_INSTANCE_NAME(cp), Strings.CLASS_INSTANCE(cp), cp.getComment()),10));	
//			}
//			
//			ret.add(Make.descriptor(initialisation,actions,Make.action(Strings.CLASS_INITIALIZATION_NAME(cp), Strings.CLASS_INITIALIZATION_EXPR(cp), cp.getComment()),10));
//		}
		
		//generate users component attributes 
//		for (ClassAttribute a : cp.getClassAttributes()){
//			ret.add(Make.descriptor(machine,variables,Make.variable("var1", "comment1"  ),10));				
//		}
		
//		return ret;
		
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

	private Context getContext(Class cp,
			List<GenerationDescriptor> generatedElements,
			Machine machine) {
//		
//		for (GenerationDescriptor gd :  generatedElements){
//			if (gd.value instanceof Context){
//				if (((Context)gd.value).getName().equals(cp.getTargetContext())){
//					return (Context)gd.value;
//				}
//			}
//		}
//		
//		Context context = (Context)Make.context(cp.getTargetContext(), "");
//		
//		return context;
		return null;
	}	
	
}
