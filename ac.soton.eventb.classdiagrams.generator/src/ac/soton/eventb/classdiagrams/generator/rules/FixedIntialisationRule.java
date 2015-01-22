package ac.soton.eventb.classdiagrams.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.context.CarrierSet;
import org.eventb.emf.core.context.Constant;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachinePackage;
import org.eventb.emf.core.machine.Variable;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.classdiagrams.EventBInitialisable;
import ac.soton.eventb.classdiagrams.generator.strings.Strings;
import ac.soton.eventb.emf.core.extension.coreextension.EventBNamedCommentedDataElaborationElement;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Find;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class FixedIntialisationRule extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception{
		assert(sourceElement instanceof Association || sourceElement instanceof ClassAttribute);
		EventBNamed elaborated = ((EventBNamedCommentedDataElaborationElement)sourceElement).getElaborates();
		String intialValue = ((EventBInitialisable)sourceElement).getInitialValue();
		EventBNamed classElaborated;
		if (sourceElement instanceof Association){
			classElaborated = ((Association) sourceElement).getSource().getElaborates();
		}else if (sourceElement instanceof ClassAttribute){
			classElaborated = ((Class)sourceElement.eContainer()).getElaborates();
		}else return false;
		return elaborated instanceof Variable && 
				(classElaborated instanceof Constant || classElaborated instanceof CarrierSet) &&
				 intialValue !=null && intialValue.length()>0;
	}
	
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		EventBElement elaborated = (EventBElement)((EventBNamedCommentedDataElaborationElement)sourceElement).getElaborates();
		Event initialisationEvent = (Event) Find.named(
				((Machine) elaborated.getContaining(MachinePackage.Literals.MACHINE)).getEvents(),
				"INITIALISATION"
				);
		ret.add(Make.descriptor(
				initialisationEvent,
				actions, 
				Make.action(
						Strings.FIXED_INITIALISATION_NAME((EventBNamed)sourceElement),
						Strings.FIXED_INITIALISATION_ACTION((EventBNamed)sourceElement))
				, 5));
		return ret;
	}
	
}
