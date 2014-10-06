package ac.soton.eventb.emf.diagrams.generator.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.emf.diagrams.generator.utils.Is;

public class GeneratedRemover {

	private AbstractExtension abstractExtension;
	private String sourceExtensionID;
	private List<Resource> modifiedResources;
	
	public GeneratedRemover(TransactionalEditingDomain editingDomain, EObject element) {
		if (element instanceof AbstractExtension){
			abstractExtension = ( AbstractExtension)element;
			//Obtain the extension ID from the source abstractExtension
			sourceExtensionID = abstractExtension.getExtensionId();
		}else{
			abstractExtension = null;
			sourceExtensionID = null;
		}
	}
	
	public boolean canExecute(){
		return abstractExtension != null && sourceExtensionID!=null ;
	}	
	
	
	public List<Resource> removeGenerated(){
		modifiedResources = new ArrayList<Resource>();
		List<EObject> previouslyGeneratedElements = getPreviouslyGeneratedElements(
				(EventBNamedCommentedComponentElement) abstractExtension.getContaining(CorePackage.Literals.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT),
				sourceExtensionID);
		for (EObject eObject : previouslyGeneratedElements){
			EcoreUtil.delete(eObject, true);	//this deletes the object from its containment and removes all references to it and its content
		}
		
		return modifiedResources;

	}
	
	
	/*
	 * finds all elements that have previously been generated with this generators generatorID
	 * Returns a list of the modified resources
	 * @return List of elements
	 */
	private ArrayList<EObject> getPreviouslyGeneratedElements(final EventBNamedCommentedComponentElement component, String sourceExtensionID) {
		EList<EObject> contents = component.getAllContained(CorePackage.eINSTANCE.getEventBElement(),false);
		contents.remove(null);
		contents.add(0,component);
		modifiedResources.add(component.eResource());
		ArrayList<EObject> remove = new ArrayList<EObject>();
		for(EObject eObject : contents){
			if(eObject instanceof Machine){
				for(Context ctx : ((Machine)eObject).getSees()){
//					if(!ctx.getName().equals(((Machine)eObject).getName() + "_implicitContext"))	
//						continue;
					for(EObject ieObject : ctx.eContents()){
						if(Is.generatedBy(ieObject, sourceExtensionID)){
							remove.add(ieObject);
							if(!modifiedResources.contains(ctx))
								modifiedResources.add(ctx.eResource());
						}
					}
					


				}

			}
			if (Is.generatedBy(eObject,sourceExtensionID)){
				remove.add(eObject);						
			}
			
		}
		return remove;
	}

	
	
	
	
}
