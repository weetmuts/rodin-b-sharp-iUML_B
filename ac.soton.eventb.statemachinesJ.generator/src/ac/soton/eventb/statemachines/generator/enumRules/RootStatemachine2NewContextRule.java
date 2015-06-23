package ac.soton.eventb.statemachines.generator.enumRules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Find;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.TranslationKind;
import ac.soton.eventb.statemachines.generator.strings.Strings;
import ac.soton.eventb.statemachines.generator.utils.Utils;

public class RootStatemachine2NewContextRule extends AbstractRule implements IRule{
	
	
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {	
		//Machine container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		return Utils.isRootStatemachine((Statemachine)sourceElement) &&
				((Statemachine) sourceElement).getTranslation().equals(TranslationKind.SINGLEVAR); //&& 
				//!hasImplicitContext(container);
				
	
	}
	/**
	 * Generates the implicit context
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		
		Machine container = (Machine)EcoreUtil.getRootContainer(sourceElement);

		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
	
		Context ctx =  (Context) Make.context(container.getName() + Strings._IMPLICIT_CONTEXT, "");
		if(!hasImplicitContext(container)){
			ret.add(Make.descriptor(Find.project(container), components,ctx ,1));
			ret.add(Make.descriptor(container, seesNames, ctx.getName(), 1));
		}
		else if(!container.getSeesNames().contains(Strings.CTX_NAME(container))){
			container.getSeesNames().add(Strings.CTX_NAME(container));
		}
		if(container.getRefines().size() != 0){
			List<Context> abstractCtxs = getGeneratedAbstractContext(container);

			for(Context ictx : abstractCtxs)
				if(!ctx.getExtendsNames().contains(ictx.getName()))
					ctx.getExtendsNames().add(ictx.getName());
		}

		return ret;

	}
	
	private boolean hasImplicitContext(Machine m){
		IProject project = getProject(m);
		return project.exists() && project.getFile(m.getName() + Strings._IMPLICIT_CONTEXT + ".buc").exists();
	}
	
	private IProject getProject(Machine m){
		URI uri = EcoreUtil.getURI(m);
		return ResourcesPlugin.getWorkspace().getRoot().getProject(uri.segment(1).toString());	
	}

	
	private List<Context> getGeneratedAbstractContext(Machine mac){
		List<Context> abstractCtxs = new ArrayList<Context>();
		for(Machine imac : mac.getRefines()){
			for(Context ctx : imac.getSees()){
				if(ctx.getName().equals(imac.getName() + Strings._IMPLICIT_CONTEXT)){
					abstractCtxs.add(ctx);
				}
			}

		}
		return abstractCtxs;
	}
	
	
	
	
	
}



	
	
	
