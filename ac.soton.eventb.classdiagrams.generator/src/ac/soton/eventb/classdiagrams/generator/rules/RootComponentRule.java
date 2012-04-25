package ac.soton.eventb.classdiagrams.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.Project;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.context.ContextPackage;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachinePackage;

import ac.soton.eventb.classdiagrams.Classdiagram;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Find;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class RootComponentRule  extends AbstractRule  implements IRule {
//
//	protected static final EReference components = CorePackage.Literals.PROJECT__COMPONENTS;
//	protected static final EReference sees = MachinePackage.Literals.MACHINE__SEES;
//	protected static final EReference sets = ContextPackage.Literals.CONTEXT__SETS;
//	protected static final EReference constants = ContextPackage.Literals.CONTEXT__CONSTANTS;
//	protected static final EReference axioms = ContextPackage.Literals.CONTEXT__AXIOMS;
//	
//	@Override
//	public boolean enabled(EventBElement sourceElement) throws Exception{
//		assert(sourceElement instanceof Classdiagram);
//		return sourceElement == ClassdiagramsUtil.getRootComponent(sourceElement);
//	}
//	
//
//	@Override
//	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
//		assert(enabled(sourceElement));
//		Classdiagram rootComponent = (Classdiagram) sourceElement;
//		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
//		
//		
//		Machine machine = (Machine)sourceElement.getContaining(MachinePackage.Literals.MACHINE);
//		Event initialisation = (Event) Find.named(machine.getEvents(), "INITIALISATION");
//		ret.add(Make.descriptor(machine,variables,Make.variable(Strings.CT_NAME(rootComponent), "current time for component"),10));
//		ret.add(Make.descriptor(machine,invariants,Make.invariant(Strings.CT_TYPE_NAME(rootComponent), Strings.CT_TYPE_PRED(rootComponent),""),10));
//		ret.add(Make.descriptor(initialisation,actions,Make.action(Strings.CT_INIT_NAME(rootComponent), Strings.CT_INIT_EXPR(rootComponent), ""),10));
//		
//		Event timerEvent = (Event)Make.event(Strings.TE_NAME(rootComponent));
//		//if this root component refines one in an abstract machine, set timer event refines
//		if (rootComponent.getRefines() != null){
//			timerEvent.getRefinesNames().add(timerEvent.getName());
//		}
//		ret.add(Make.descriptor(machine, events, timerEvent,10));
//		
//		ret.add(Make.descriptor(timerEvent, actions, Make.action(Strings.TE_INC_TIME_NAME(rootComponent),Strings.TE_INC_TIME_EXPR(rootComponent), ""),10));
//
//		// make a seen context and use it to define the enumerated set for Wake kinds
//		Project project = Find.project(machine);
//		Context context = (Context)Make.context(Strings.CTXT_NAME(rootComponent), "");
//		ret.add(Make.descriptor(project, components, context,10));
//		ret.add(Make.descriptor(machine, sees, context,10));
//		
//		//if this root component refines one in an abstract machine,
//			// extend the corresponding context of the refined component
//		if (rootComponent.getRefines() != null){
//			ret.add(Make.descriptor(context, ContextPackage.Literals.CONTEXT__EXTENDS_NAMES, Strings.CTXT_NAME(rootComponent.getRefines()),10));
//		}else{
//			// most abstract component must define wake kinds in its context
//			ret.add(Make.descriptor(context, sets, Make.set(Strings.WK_NAME(rootComponent), "wake up kinds"),10));
//			ret.add(Make.descriptor(context, constants, Make.constant(Strings.WK_ADDEVENT_NAME(rootComponent), "wake up kind: addEvent"),10));
//			ret.add(Make.descriptor(context, axioms, Make.axiom(Strings.WK_ENUM_NAME(rootComponent), Strings.WK_ENUM_PRED(rootComponent), ""),10));			
//		}
//		return ret;
//	}	
//	
}
