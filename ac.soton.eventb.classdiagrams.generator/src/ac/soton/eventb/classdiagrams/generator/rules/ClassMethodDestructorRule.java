package ac.soton.eventb.classdiagrams.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Variable;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.classdiagrams.ClassMethod;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.MethodKind;
import ac.soton.eventb.classdiagrams.generator.strings.Strings;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class ClassMethodDestructorRule  extends AbstractClassMethodRule  implements IRule {

	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception{
		assert(sourceElement instanceof ClassMethod);
		return super.enabled(sourceElement) &&
				((ClassMethod)sourceElement).getKind()==MethodKind.DESTRUCTOR &&
				((Class)sourceElement.getContaining(ClassdiagramsPackage.Literals.CLASS)).getElaborates() instanceof Variable;
	}

	@Override
	protected String getInstanceParameterGuardPredicate(ClassMethod method) {
		return Strings.CLASS_PARAMETER_GUARD_PRED(selfName, instancesName);
	}

	@Override
	protected String getInstanceParameterActionExpression(ClassMethod method) {
		return Strings.CLASS_PARAMETER_DESTRUCTOR_ACTION_EXPR(selfName, instancesName);
	}
	
	@Override
	protected List<Object> getInstanceActions(ClassMethod method) {
		List<Object> ret = new ArrayList<Object>();
		Class cl = (Class) method.getContaining(ClassdiagramsPackage.Literals.CLASS);
		for (ClassAttribute ca: cl.getClassAttributes()){
			ret.add(Make.action(
					Strings.ATTRIBUTE_DESTRUCTION_ACTION_NAME(ca.getName()), 
					Strings.ATTRIBUTE_DESTRUCTION_ACTION_EXPR(ca.getName(), selfName)
					));
		}
		for (Association ca: cl.getOutgoing()){
			ret.add(Make.action(
					Strings.ATTRIBUTE_DESTRUCTION_ACTION_NAME(ca.getName()), 
					Strings.ATTRIBUTE_DESTRUCTION_ACTION_EXPR(ca.getName(), selfName)
					));
		}
		return ret;
	}

}