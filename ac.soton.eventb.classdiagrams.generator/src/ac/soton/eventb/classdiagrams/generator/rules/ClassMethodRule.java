package ac.soton.eventb.classdiagrams.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.machine.Action;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Guard;
import org.eventb.emf.core.machine.Witness;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassMethod;
import ac.soton.eventb.classdiagrams.generator.strings.Strings;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.core.extension.coreextension.TypedParameter;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Is;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class ClassMethodRule extends AbstractRule  implements IRule {
	
	protected static final EReference elaborates = CoreextensionPackage.Literals.EVENT_BDATA_ELABORATION__ELABORATES;

	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception{
		assert(sourceElement instanceof ClassMethod);
		if (!(((ClassMethod)sourceElement).eContainer() instanceof Class)) return false;
		return true;
	}
	
	@Override
	public boolean dependenciesOK(EventBElement sourceElement, final List<GenerationDescriptor> generatedElements) throws Exception  {
		Class parentClass = (Class) ((ClassMethod)sourceElement).eContainer();	
		if (parentClass.getElaborates() != null || Is.generated(generatedElements,null,null,parentClass.getName())) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Class parentClass = (Class) ((ClassMethod)sourceElement).eContainer();	
		EventBNamed classSet = parentClass.getElaborates();
		ClassMethod element = (ClassMethod)sourceElement;
		EList<Event> events = element.getElaborates();

		//create a parameter and its typing guard for each elaborated event
		
		//prepare the strings
		String parameterName = Strings.CLASS_PARAMETER_NAME("this"+parentClass.getName());
		String guardName = Strings.CLASS_PARAMETER_GUARD_NAME("this"+parentClass.getName());
		String guardPredicate = Strings.CLASS_PARAMETER_GUARD_PRED("this"+parentClass.getName(), classSet.getName());
		
		//make the descriptors
		for (Event elaboratedEvent : events){
			ret.add(Make.descriptor(elaboratedEvent, parameters, Make.parameter(parameterName, "generated class instance"), 1));
			ret.add(Make.descriptor(elaboratedEvent, guards, Make.guard(guardName, guardPredicate), 1));			

			//generate users parameters 
			for (TypedParameter p : element.getParameters()){
				//parameter
				ret.add(Make.descriptor(elaboratedEvent,parameters,Make.parameter(p.getName(),p.getComment()),10));
				//guard for type of parameter
				ret.add(Make.descriptor(elaboratedEvent,guards,Make.guard(Strings.USER_PARAMETER_TYPE_GUARD_NAME(p), Strings.USER_PARAMETER_TYPE_GUARD_PRED(p)),10));
			}
			
			//generate users witnesses 
			for (Witness w : element.getWitnesses()){
				ret.add(Make.descriptor(elaboratedEvent,witnesses,Make.witness(w.getName(), w.getPredicate(), w.getComment()),10));				
			}
			
			//generate users guards 
			for (Guard g : element.getGuards()){
				ret.add(Make.descriptor(elaboratedEvent,guards,Make.guard(g.getName(), g.isTheorem(), g.getPredicate(), g.getComment()),10));				
			}
			
			//generate users actions
			for (Action a : element.getActions()){
				ret.add(Make.descriptor(elaboratedEvent,actions,Make.action(a.getName(), a.getAction(), a.getComment()),10));				
			}
			
		
		}
		return ret;
	}	
}
