package ac.soton.eventb.classdiagrams.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.context.Constant;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.Variable;

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
	
		// generate supertype invariants/axioms
		Class element = (Class)sourceElement;
		EventBElement elaborated = (EventBElement) element.getElaborates();
		if (element.getSupertypes() != null && element.getSupertypes().size() > 0){
			int pri = distanceFromCarrierSet(element);
			EventBNamedCommentedComponentElement sourceContainer = (EventBNamedCommentedComponentElement) element.getContaining(CorePackage.Literals.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT);
			EventBNamedCommentedComponentElement targetContainer = sourceContainer ;
			for (Class superClass : element.getSupertypes()){
				if (sourceContainer instanceof Machine && elaborated instanceof Constant && !(superClass.getElaborates() instanceof Variable)){
					for (Context ctx : ((Machine)sourceContainer).getSees()){
						if (sees(ctx,elaborated) && sees(ctx,(EventBElement) superClass.getElaborates())) {
							targetContainer = ctx;
						};
					}
				}
				if (targetContainer instanceof Machine){
					ret.add(Make.descriptor(targetContainer, invariants, Make.invariant(
							Strings.CLASS_SUPERTYPE_NAME(element), 
							Strings.CLASS_SUPERTYPE_PRED(element, superClass), element.getComment()),pri));
				}else if (targetContainer instanceof Context){
					ret.add(Make.descriptor(targetContainer, axioms, Make.axiom(
							Strings.CLASS_SUPERTYPE_NAME(element), 
							Strings.CLASS_SUPERTYPE_PRED(element, superClass), element.getComment()),pri));					
				}
			}	
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
