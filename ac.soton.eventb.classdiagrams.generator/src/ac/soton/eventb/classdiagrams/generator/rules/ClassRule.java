package ac.soton.eventb.classdiagrams.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.context.ContextPackage;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachinePackage;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.generator.strings.Strings;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.core.extension.coreextension.DataKind;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class ClassRule  extends AbstractRule  implements IRule {
	
	protected static final EReference elaborates = CoreextensionPackage.Literals.EVENT_BDATA_ELABORATION__ELABORATES;
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception{
		assert(sourceElement instanceof Class);
		return ((Class)sourceElement).getElaborates() != null;
	}
		
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
	
		// generate supertype invariants
		Class element = (Class)sourceElement;
		EventBElement elaborated = (EventBElement) element.getElaborates();
		if (element.getSupertypes() != null && element.getSupertypes().size() > 0){
			int pri = distanceFromCarrierSet(element);
			switch (element.getDataKind().getValue()) {
			case DataKind.SET_VALUE :
				//nothing to do - sets don't have supertypes
				break;
			case DataKind.CONSTANT_VALUE :
				Context context = (Context) elaborated.getContaining(ContextPackage.Literals.CONTEXT);
				ret.add(Make.descriptor(context, axioms, Make.axiom(
						Strings.CLASS_SUPERTYPE_NAME(element), 
						Strings.CLASS_SUPERTYPE_PRED(element, element.getSupertypes()), element.getComment()),pri));
				break;
			case DataKind.VARIABLE_VALUE :
				Machine machine = (Machine) elaborated.getContaining(MachinePackage.Literals.MACHINE);
				ret.add(Make.descriptor(machine, invariants, Make.invariant(
						Strings.CLASS_SUPERTYPE_NAME(element), 
						Strings.CLASS_SUPERTYPE_PRED(element, element.getSupertypes()), element.getComment()),pri));
				break;
			}
		}
		
		return ret;
	}

	private Integer distanceFromCarrierSet(Class element) {
		Class c = element;
		if (c.getDataKind().equals(DataKind.SET)){
			return 0;
		}else if (c.getSupertypes().isEmpty()){
			return null;
		}else{
			Integer p = 9; //FIXME: There is a limit to the number of priorities we can use.
			for (int i=0; i<c.getSupertypes().size(); i++){
					Integer d = distanceFromCarrierSet(c.getSupertypes().get(0));
					if (d!=null && d<p) p = d;
			}
			return p == null? null : p+1;
		}
	}
	
}
