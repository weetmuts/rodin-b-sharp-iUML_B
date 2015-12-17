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
import ac.soton.eventb.statemachines.AbstractNode;
import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.Transition;
import ac.soton.eventb.statemachines.generator.utils.Utils;

/**
 * Generation rule for State Exit Actions
 * 
 * @author cfs
 *
 */
public class StateExitAction2ActionRule extends AbstractRule  implements IRule {
	
	/**
	 * StateExitAction2Action
	 * 
	 * Generates actions from state entry actions and adds them on all events elaborated by outgoing transitions from this
	 * state and any of its parent super-states.
	 * (If an event is elaborated by more than one outgoing transition, the action is only added once).
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Set<Event> events = new HashSet<Event>();
		for (AbstractNode node : Utils.getSuperStates((State) sourceElement)){
			for (Transition outgoingTransition : node.getOutgoing()){
				events.addAll(Utils.getAllDownstreamElaboratedEvents(outgoingTransition));
			}			
		}
		for (Event event: events){
			for(Action a : ((State) sourceElement).getExitActions()){
				ret.add(Make.descriptor(event, actions, Make.action(a.getName(), a.getAction(), "(Exit Action from "+((State) sourceElement).getName()+") " +a.getComment()), 10));
			}				
		}
		return ret;		
	} 
	
}