package ac.soton.eventb.statemachines.generator.rules;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Action;
import org.eventb.emf.core.machine.Event;

import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;
import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.Transition;
import ac.soton.eventb.statemachines.generator.utils.Utils;

/**
 * Generation rule for State Entry Actions
 * 
 * @author cfs
 *
 */
public class StateEntryAction2ActionRule extends AbstractRule  implements IRule {
	
	/**
	 * StateEntryAction2Action
	 * 
	 * Generates actions on all events elaborated by incoming transitions from state entry actions.
	 * (If an event is elaborated by more than one incomer, the action is only added once).
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Set<Event> events = new HashSet<Event>();
		for (Transition incomingTransition : ((State) sourceElement).getIncoming()){
			events.addAll(Utils.getAllUpstreamElaboratedEvents(incomingTransition));
		}
		for (Event event: events){
			for(Action a : ((State) sourceElement).getEntryActions()){
				ret.add(Make.descriptor(event, actions, Make.action(a.getName(), a.getAction(), "(Entry Action from "+((State) sourceElement).getName()+") " +a.getComment()), 10));
			}				
		}
		return ret;		
	} 
	
}