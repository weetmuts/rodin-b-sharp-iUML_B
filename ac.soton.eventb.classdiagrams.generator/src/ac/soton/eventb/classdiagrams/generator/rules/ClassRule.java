package ac.soton.eventb.classdiagrams.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.context.Constant;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachinePackage;
import org.eventb.emf.core.machine.Variable;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.generator.strings.Strings;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.core.extension.coreextension.DataKind;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Find;
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
	
		// generate supertype invariants/axioms
		Class element = (Class)sourceElement;
		EventBElement elaborated = (EventBElement) element.getElaborates();
		if (element.getSupertypes() != null && element.getSupertypes().size() > 0){
			EventBNamedCommentedComponentElement sourceContainer = (EventBNamedCommentedComponentElement) element.getContaining(CorePackage.Literals.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT);
			EventBNamedCommentedComponentElement targetContainer;
			for (Class superClass : element.getSupertypes()){
				int pri = subsetPriority(superClass);
				targetContainer = sourceContainer ;				
				if (sourceContainer instanceof Machine && elaborated instanceof Constant && !(superClass.getElaborates() instanceof Variable)){
					for (Context ctx : ((Machine)sourceContainer).getSees()){
						if (sees(ctx,elaborated) && sees(ctx,(EventBElement) superClass.getElaborates())) {
							targetContainer = ctx;
						};
					}
				}
				if (targetContainer instanceof Machine){
					ret.add(Make.descriptor(targetContainer, invariants, Make.invariant(
							Strings.CLASS_SUPERTYPE_NAME(element, superClass), 
							Strings.CLASS_SUPERTYPE_PRED(element, superClass), element.getComment()),pri));
				}else if (targetContainer instanceof Context){
					ret.add(Make.descriptor(targetContainer, axioms, Make.axiom(
							Strings.CLASS_SUPERTYPE_NAME(element, superClass), 
							Strings.CLASS_SUPERTYPE_PRED(element, superClass), element.getComment()),pri));					
				}
			}	
		}
		//for variable instance classes, initialise the instances set to empty
		if (elaborated instanceof Variable){
			Event initialisationEvent = (Event) Find.named(
					((Machine) elaborated.getContaining(MachinePackage.Literals.MACHINE)).getEvents(),
					"INITIALISATION"
					);
			ret.add(Make.descriptor(
					initialisationEvent,
					actions, 
					Make.action(
							Strings.INITIALISATION_NAME((EventBNamed)sourceElement),
							Strings.EMPTY_INITIALISATION_ACTION_EXPR((EventBNamed)sourceElement))
					, 5));
		}
		return ret;
	}
	
	private boolean sees(Context ctx, EventBElement el) {
		if (ctx.getConstants().contains(el) || ctx.getSets().contains(el)){
			return true;
		}else{
			for (Context ectx : ctx.getExtends()){
				if (sees(ectx, el)) return true;
			}
		}
		return false;
	}

	/**
	 * calculates the priority of this subset constraint (1 high, 10 low)
	 * the priority must ensure that the superclass has got as type constraint with higher priority
	 * therefore we add one to the min distance (in supertype relations) of the supertype 
	 * from a carrier set (or class with no supertypes). If a class with no supertypes was found we
	 *  have to assume that the top class is defined in a context elsewhere.
	 * 
	 * @param element
	 * @return
	 */
	private int subsetPriority(Class element) {
		Class c = element;
		if (c.getDataKind().equals(DataKind.SET)){
			return 1;
		}else if (c.getSupertypes().isEmpty()){
			return 1;
		}else{
			Integer p = 10; //FIXME: There is a limit to the number of priorities we can use.
			for (Class s : c.getSupertypes()){
					int d = subsetPriority(s);
					if (d<p) p = d;
			}
			return p+1;
		}
	}
	
}
