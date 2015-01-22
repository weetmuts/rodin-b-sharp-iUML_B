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

public class ClassMethodConstructorRule  extends AbstractClassMethodRule  implements IRule {

	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception{
		assert(sourceElement instanceof ClassMethod);
		return super.enabled(sourceElement) &&
				((ClassMethod)sourceElement).getKind()==MethodKind.CONSTRUCTOR &&
				((Class)sourceElement.getContaining(ClassdiagramsPackage.Literals.CLASS)).getElaborates() instanceof Variable;
	}

	@Override
	protected String getInstanceParameterGuardPredicate(ClassMethod method) {
		return Strings.CLASS_PARAMETER_CONSTRUCTOR_GUARD_PRED(selfName, instancesName);
	}

	@Override
	protected String getInstanceParameterActionExpression(ClassMethod method) {
		return Strings.CLASS_PARAMETER_CONSTRUCTOR_ACTION_EXPR(selfName, instancesName);
	}
	
	@Override
	protected List<Object> getInstanceActions(ClassMethod method) {
		List<Object> ret = new ArrayList<Object>();
		Class cl = (Class) method.getContaining(ClassdiagramsPackage.Literals.CLASS);
		for (ClassAttribute ca: cl.getClassAttributes()){
			String iv = ca.getInitialValue();
			if (iv!=null && iv.length()>0){
				ret.add(Make.action(
						Strings.ATTRIBUTE_INITIALISATION_ACTION_NAME(ca.getName()), 
						Strings.ATTRIBUTE_INITIALISATION_ACTION_EXPR(ca.getName(), selfName, iv)
						));
			}
		}
		for (Association ca: cl.getOutgoing()){
			String iv = ca.getInitialValue();
			if (iv!=null && iv.length()>0){
				ret.add(Make.action(
						Strings.ATTRIBUTE_INITIALISATION_ACTION_NAME(ca.getName()), 
						Strings.ATTRIBUTE_INITIALISATION_ACTION_EXPR(ca.getName(), selfName, iv)
						));
			}
		}
		return ret;
	}

}
