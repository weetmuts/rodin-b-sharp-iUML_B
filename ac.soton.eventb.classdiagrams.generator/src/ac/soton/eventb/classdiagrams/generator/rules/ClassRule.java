package ac.soton.eventb.classdiagrams.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.generator.strings.Strings;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.core.extension.coreextension.DataKind;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Is;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class ClassRule  extends AbstractRule  implements IRule {
	
	protected static final EReference elaborates = CoreextensionPackage.Literals.EVENT_BDATA_ELABORATION__ELABORATES;
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception{
		assert(sourceElement instanceof Class);
		return true;
	}
	
	@Override
	public boolean dependenciesOK(EventBElement sourceElement, final List<GenerationDescriptor> generatedElements) throws Exception  {
		Class c = (Class)sourceElement;
		if (c.getSupertypes().size() > 0){
			for (Class superClass : c.getSupertypes()){
				if (!(superClass.getElaborates() instanceof EventBNamed) &&
					!(Is.generated(generatedElements, null, null, superClass.getName()))){
					return false;
				}
			}
		}
		return true; 
	}
	
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		
		EventBNamedCommentedComponentElement container = (EventBNamedCommentedComponentElement)EcoreUtil.getRootContainer(sourceElement);
		Class element = (Class)sourceElement;
		int dataKind = element.getDataKind().getValue();
		EventBElement elaborated = (EventBElement) element.getElaborates();
		//create element if it's a new one
		if (elaborated==null || Is.generatedBy(elaborated, sourceElement)){
			EventBElement newGeneratedElement = null;
			EReference newGeneratedElementContainer = null;
			switch (dataKind) {
				case DataKind.SET_VALUE :
					newGeneratedElement = (EventBElement) Make.set(element.getName(), element.getComment());
					newGeneratedElementContainer = sets;
					break;
				case DataKind.CONSTANT_VALUE :
					newGeneratedElement = (EventBElement) Make.constant(element.getName(), element.getComment());
					newGeneratedElementContainer = constants;
					break;
				case DataKind.VARIABLE_VALUE :
					newGeneratedElement = Make.variable(element.getName(), element.getComment());
					newGeneratedElementContainer = variables;
					break;
			}
			ret.add(Make.descriptor(container,newGeneratedElementContainer,newGeneratedElement,10));
			ret.add(Make.descriptor(sourceElement, elaborates, newGeneratedElement, 10));
		}
		
		// generate supertype invariants

		if (element.getSupertypes() != null && element.getSupertypes().size() > 0){
			switch (dataKind) {
			case DataKind.SET_VALUE :
				//nothing to do - sets don't have supertypes
				break;
			case DataKind.CONSTANT_VALUE :
				ret.add(Make.descriptor(container, axioms, Make.axiom(
						Strings.CLASS_SUPERTYPE_NAME(element), 
						Strings.CLASS_SUPERTYPE_PRED(element, element.getSupertypes()), element.getComment()),10));
				break;
			case DataKind.VARIABLE_VALUE :
				ret.add(Make.descriptor(container, invariants, Make.invariant(
						Strings.CLASS_SUPERTYPE_NAME(element), 
						Strings.CLASS_SUPERTYPE_PRED(element, element.getSupertypes()), element.getComment()),10));
				break;
			}
		}
		
		return ret;
	}
	
//OLD CODE :-
//	System.out.println("generatedElements: " + generatedElements.size());
//	
//	assert(enabled(sourceElement));
//	Class cp = (Class) sourceElement;
//	List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
//	
//	Machine machine = (Machine)sourceElement.getContaining(MachinePackage.Literals.MACHINE);
//	Event initialisation = (Event) Find.named(machine.getEvents(), "INITIALISATION");
//	
//	if (cp.isConstant()){
//		Context context = null;
//		
//		//look for an already existing context
//		for (GenerationDescriptor gd :  generatedElements){
//			if (gd.value instanceof Context){
//				if (((Context)gd.value).getName().equals(cp.getTargetContext())){
//					context = (Context)gd.value;
//				}
//			}
//		}
//		
//		//if nor found - create one
//		if (context == null){
//			context = (Context)Make.context(cp.getTargetContext(), "");
//			ret.add(Make.descriptor(null, components, context,10));
//			ret.add(Make.descriptor(machine, sees, context,10));
//		}
//		
//		
//		
//		if (cp.getInstance() == null || cp.getInstance().isEmpty()){
//			ret.add(Make.descriptor(context, sets, Make.set(cp.getName(), "wake up kinds"),10));
//		} else {
//			ret.add(Make.descriptor(context, constants, Make.constant(cp.getName(), "wake up kind: addEvent"),10));
//			ret.add(Make.descriptor(context, axioms, Make.axiom(cp.getName(), cp.getInstance(), ""),10));			
//		}
//		
//	} else {
//		//add class variable
//		ret.add(Make.descriptor(machine,variables,Make.variable(cp.getName(), cp.getComment()),10));
//		
//		//it's dynamic, so variable is defined in the machine
//		if (cp.getSupertypes().size() > 0) {
//			ret.add(Make.descriptor(machine,invariants,Make.invariant(Strings.CLASS_SUPERTYPE_NAME(cp), Strings.CLASS_SUPERTYPE_PRED(cp, cp.getSupertypes()), cp.getComment()),10));
//		}
//		
//		//set instance
//		//need instance field
//		if (cp.getInstance() != null && !cp.getInstance().isEmpty()){
//			ret.add(Make.descriptor(machine,invariants,Make.invariant(Strings.CLASS_INSTANCE_NAME(cp), Strings.CLASS_INSTANCE(cp), cp.getComment()),10));	
//		}
//		
//		ret.add(Make.descriptor(initialisation,actions,Make.action(Strings.CLASS_INITIALIZATION_NAME(cp), Strings.CLASS_INITIALIZATION_EXPR(cp), cp.getComment()),10));
//	}
	
	//generate users component attributes 
//	for (ClassAttribute a : cp.getClassAttributes()){
//		ret.add(Make.descriptor(machine,variables,Make.variable("var1", "comment1"  ),10));				
//	}
	


}
