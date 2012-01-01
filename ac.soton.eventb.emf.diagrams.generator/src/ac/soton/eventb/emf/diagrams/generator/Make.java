package ac.soton.eventb.emf.diagrams.generator;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Action;
import org.eventb.emf.core.machine.Convergence;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Guard;
import org.eventb.emf.core.machine.Invariant;
import org.eventb.emf.core.machine.MachineFactory;
import org.eventb.emf.core.machine.Parameter;
import org.eventb.emf.core.machine.Variable;

public class Make {

	public static GenerationDescriptor descriptor(EventBElement parent, EStructuralFeature feature, Object value, int priority){
		return new GenerationDescriptor(parent,feature,value,Integer.valueOf(priority));
	}
	
	  public static Variable variable(String name, String comment) {
		Variable v =  MachineFactory.eINSTANCE.createVariable();
	    v.setName(name);
	    v.setLocalGenerated(true);
	    v.setComment(comment);
	    return v;  
	  }
	  
	public static Invariant invariant(String name, String predicate,String comment) {
		Invariant i =  MachineFactory.eINSTANCE.createInvariant();
	    i.setName(name);
	    i.setPredicate(predicate);
	    i.setLocalGenerated(true);
	    i.setComment(comment);
	    return i;  
	}

	public static Object event(String name) {
		return event(name, false, Convergence.ORDINARY, Collections.<String> emptyList(), "");
	}
		
	public static Object event(String name, boolean extended, Convergence convergence, List<String> refinesNames, String comment) {
		Event e =  MachineFactory.eINSTANCE.createEvent();
	    e.setName(name);
	    e.setExtended(extended);
	    e.setConvergence(convergence);
	    e.getRefinesNames().addAll(refinesNames);
	    e.setLocalGenerated(true);
	    e.setComment(comment);
	    return e;  
	}

	public static Object parameter(String name, String comment) {
		Parameter p =  MachineFactory.eINSTANCE.createParameter();
	    p.setName(name);
	    p.setLocalGenerated(true);
	    p.setComment(comment);
	    return p;  
	}
	
	public static Object guard(String name, String predicate){
		return guard(name, false, predicate, "");
	}
	
	public static Object guard(String name, boolean theorem, String invariant, String comment) {
		Guard g =  MachineFactory.eINSTANCE.createGuard();
	    g.setName(name);
	    g.setTheorem(theorem);
	    g.setPredicate(invariant);
	    g.setLocalGenerated(true);
	    g.setComment(comment);
	    return g;  
	}
	
	public static Object action(String name, String expression){
		return action(name, expression, "");
	}
	
	public static Object action(String name, String expression, String comment) {
		Action a =  MachineFactory.eINSTANCE.createAction();
	    a.setName(name);
	    a.setAction(expression);
	    a.setLocalGenerated(true);
	    a.setComment(comment);
	    return a;  
	}

}
