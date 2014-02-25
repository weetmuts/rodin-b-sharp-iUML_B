package ac.soton.eventb.statemachines.navigator.refiner;

/*******************************************************************************
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.core.IAction;
import org.eventb.core.IEvent;
import org.eventb.core.IEventBRoot;
import org.eventb.core.IGuard;
import org.eventb.core.IInvariant;
import org.eventb.core.IVariable;
import org.eventb.core.basis.Invariant;
import org.eventb.core.basis.Variable;
import org.eventb.emf.core.EventBElement;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IAttributeValue;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IRefinementParticipant;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

import ac.soton.eventb.emf.core.extension.persistence.ISerialisedExtension;
import ac.soton.eventb.emf.core.extension.persistence.SerialisedExtensionSynchroniser;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.TranslationKind;

/**
 * Refinement participant to carry out the data refinement involved in the 'Refined Enumeration' style of statemachine translation.
 * 
 * @author panos/cfsnook
 *
 */

public class RefinedEnumerationStatemachineRefiner implements IRefinementParticipant {
	
	private static final IAttributeType genAttType = RodinCore.getAttributeType("org.eventb.emf.persistence.generator_ID");
	private static final SerialisedExtensionSynchroniser synchroniser = new SerialisedExtensionSynchroniser();
	private Map<String,String> refinedEnumSMmap;
	private Map<String,Integer> refinementLevelMap;

	public void process(IInternalElement targetRoot, IInternalElement sourceRoot, IProgressMonitor monitor) throws RodinDBException {
		final IEventBRoot concreteEventBRoot = (IEventBRoot) targetRoot;
		final IEventBRoot abstractEventBRoot = (IEventBRoot) sourceRoot;		
		refinedEnumSMmap = getAllRefinedEnumerationStatemachines(abstractEventBRoot);
		refinementLevelMap = new HashMap<String,Integer>();

		for (IVariable variable : abstractEventBRoot.getChildrenOfType(IVariable.ELEMENT_TYPE)){
			if(isGeneratedByRefEnumSM(variable)){
				String key = getGeneratedByRefEnum(variable);
				String oldSMVariableIdentifier = variable.getIdentifierString();
				refinementLevelMap.put(key, getRefinementLevel(oldSMVariableIdentifier));
				String newSMVariableIdentifier = oldSMVariableIdentifier.substring(0, oldSMVariableIdentifier.lastIndexOf('_')+1) + refinementLevelMap.get(key);
				//change the name of the corresponding concrete variable
				for (IVariable concreteVariable : concreteEventBRoot.getChildrenOfType(Variable.ELEMENT_TYPE)){
					if(isGeneratedBySameRefEnumSM(concreteVariable,variable) &&
						oldSMVariableIdentifier.equals(concreteVariable.getIdentifierString())){
						concreteVariable.setIdentifierString(newSMVariableIdentifier, monitor);							
					}
				}
				//add a gluing invariant
				// (THE GLUING INVARINAT WILL BE REPLACED WHEN THE STATEMACHINE IS FIRST GENERATED).
				IInvariant newInvariant = (Invariant) concreteEventBRoot.createChild(Invariant.ELEMENT_TYPE, null , monitor);
				newInvariant.setLabel("valueof_"+ newSMVariableIdentifier, monitor);
				newInvariant.setPredicateString(newSMVariableIdentifier + " = " + oldSMVariableIdentifier, monitor);
				newInvariant.setAttributeValue(variable.getAttributeValue(genAttType),monitor);
			}
		}
	
// THE GLUING INVARIANT IS SUFFICIENT FOR TYPING AND NON-TYPING INVARIANTS SHOULD NOT BE COPIED
// (THE GLUING INVARINAT WILL BE REPLACED WHEN THE STATEMACHINE IS FIRST GENERATED).
//		for (IInvariant invariant : abstractEventBRoot.getChildrenOfType(IInvariant.ELEMENT_TYPE)){
//			if(isGeneratedByRefEnumSM(invariant)){ 		// != null && refinementLevelMap.containsKey(key)){
//				//if(invariant.getLabel().startsWith("typeof")){
//					//copy all generated invariants from the abstract model to the concrete adjusting their refinement levels
//					IInvariant newInvariant = (Invariant) concreteEventBRoot.createChild(Invariant.ELEMENT_TYPE, null , monitor);
//					if(invariant.hasPredicateString()){
//						newInvariant.setPredicateString(fixTorefinementLevel(invariant.getPredicateString()), monitor);
//					}
//					if(invariant.hasLabel()){
//						newInvariant.setLabel(fixTorefinementLevel(invariant.getLabel()), monitor);
//					}
//					if(invariant.hasComment()){
//						newInvariant.setComment(fixTorefinementLevel(invariant.getComment()), monitor);
//					}
//					if(invariant.hasAttribute(genAttType)){
//						newInvariant.setAttributeValue(invariant.getAttributeValue(genAttType),monitor);
//					}
//				//}
//			}
//		}

		for (IEvent event : abstractEventBRoot.getChildrenOfType(IEvent.ELEMENT_TYPE)){
	 		//if the event uses a statemachine variable then is set to refines instead of extends
			boolean flag = false;
			//check if there is a generated child element or one that references a statemachine variable
			for(IRodinElement child : event.getChildren()) { //abstractActions){
				if (child instanceof IInternalElement && 
						(isGeneratedByRefEnumSM((IInternalElement)child) || usesStatemachineVariable((IInternalElement)child)) ){
						flag = true;
				}
			}
			if(flag == true){
				for (IEvent concreteEvent : concreteEventBRoot.getChildrenOfType(IEvent.ELEMENT_TYPE)){
					if(concreteEvent.getLabel().equals(event.getLabel())){
						concreteEvent.setExtended(false,monitor);
						//copy all actions of the event of abstract model to the concrete
						for(IAction abstAction : event.getActions()){
							IAction newAction = concreteEvent.createChild(IAction.ELEMENT_TYPE, null , monitor);
						 	if(abstAction.hasAssignmentString())
						 		newAction.setAssignmentString(fixTorefinementLevel(abstAction.getAssignmentString()), monitor);
						 	if(abstAction.hasLabel())
						 		newAction.setLabel(fixTorefinementLevel(abstAction.getLabel()), monitor);
						 	if(abstAction.hasComment())
						 		newAction.setComment(abstAction.getComment(), monitor);
							if(abstAction.hasAttribute(genAttType)){
								newAction.setAttributeValue(abstAction.getAttributeValue(genAttType),monitor);
							}
						 }
						//copy all guards of the event of abstract model to the concrete
						for(IGuard abstGuard : event.getGuards()){
							IGuard newGuard = concreteEvent.createChild(IGuard.ELEMENT_TYPE, null , monitor);
						 	if(abstGuard.hasPredicateString())
						 		newGuard.setPredicateString(fixTorefinementLevel(abstGuard.getPredicateString()), monitor);
						 	if(abstGuard.hasLabel())
						 		newGuard.setLabel(fixTorefinementLevel(abstGuard.getLabel()), monitor);
						 	if(abstGuard.hasComment())
						 		newGuard.setComment(abstGuard.getComment(), monitor);
						 	if(abstGuard.hasAttribute(genAttType)){
								newGuard.setAttributeValue(abstGuard.getAttributeValue(genAttType),monitor);
						 	}
						}
					}
				}
			}
	 	}
	}

/**
 * gets the SM id of the refinedEnumeration SM that generated the given element (if any)
 * otherwise returns null	
 * @param internalElement
 * @return
 */
	private String getGeneratedByRefEnum(IInternalElement internalElement) {
		try {
			if (internalElement.hasAttribute(genAttType) &&
					refinedEnumSMmap.containsKey(internalElement.getAttributeValue(genAttType).getValue())){
				return (String) internalElement.getAttributeValue(genAttType).getValue();
			}else{
				return null;
			}
		} catch (RodinDBException e) {
			return null;
		}
	}

	/**
	 * Finds all the statemachines in the given root and returns them as a map 
	 * from their extension ID's to their statemachine names
	 * @param eventBRoot
	 * @return
	 */
			
	private Map<String, String> getAllRefinedEnumerationStatemachines(IEventBRoot eventBRoot) {
		Map<String,String> refinedEnumSMmap = new HashMap<String,String>();
		try {
			ISerialisedExtension[] serialisedExts = eventBRoot.getChildrenOfType(ISerialisedExtension.ELEMENT_TYPE);
			for (ISerialisedExtension serialisedExt : serialisedExts){
				EventBElement extension = synchroniser.load(serialisedExt, null, null);
				if((extension instanceof Statemachine) && ((Statemachine)extension).getTranslation().equals(TranslationKind.REFINEDVAR)){
					String key = serialisedExt.getExtensionId();
					String value = ((Statemachine)extension).getName();
					refinedEnumSMmap.put(key, value);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Collections.emptyMap();
		}
		return refinedEnumSMmap;
	}


	/**
	 * checks the internal element to see whether it has a generator ID attribute and if so
	 * whether the element was generated by one of the refined enumeration statemachines
	 * 		
	 * @param internalElement
	 * @return
	 */
	private boolean isGeneratedByRefEnumSM(IInternalElement internalElement) {
		try {
			if (internalElement.hasAttribute(genAttType)){
				return refinedEnumSMmap.containsKey(internalElement.getAttributeValue(genAttType).getValue());
			}else{
				return false;
			}
		} catch (RodinDBException e) {
			return false;
		}
	}


	/**
	 * checks the internal elements to see whether they both have a generator ID attribute and if so
	 * whether they are the same and are generated by one of the refined enumeration statemachines.
	 * 		
	 * @param internalElement1
	 * @param internalElement2
	 * @return
	 */
	private boolean isGeneratedBySameRefEnumSM(IInternalElement internalElement1, IInternalElement internalElement2) {
		try {
			if (internalElement1.hasAttribute(genAttType) && internalElement2.hasAttribute(genAttType)){
				return (internalElement1.getAttributeValue(genAttType).getValue() == internalElement2.getAttributeValue(genAttType).getValue())
						&& refinedEnumSMmap.containsKey(internalElement1.getAttributeValue(genAttType).getValue());
			}else{
				return false;
			}
		} catch (RodinDBException e) {
			return false;
		}
	}

	/**
	 * gets the current refinement level (i.e. suitable for the concrete machine being produced)
	 * from the given string which should be a statemachine variable name
	 * @param string
	 * @return
	 */
	private int getRefinementLevel (String string){
		string = string.substring(string.lastIndexOf("_")+1, string.length());
		return Integer.parseInt(string)+1;
	}
	
	/**
	 * This method changes all the occurrences of the abstract statemachine variable and fixes its suffix to the current refinement level
	 * @param string
	 * @return
	 * @throws RodinDBException
	 */
	private String fixTorefinementLevel(String string) throws RodinDBException{
		String s = string;
		for(String key : refinementLevelMap.keySet()){
			String smName = refinedEnumSMmap.get(key);
			Integer refinementLevel = refinementLevelMap.get(key);
			if(s.contains(smName + "_" + (refinementLevel-1))){
				s = s.replace(smName + "_" + (refinementLevel-1), smName + "_" + refinementLevel);
			}
			if(s.contains(smName + "_" + (refinementLevel-2))){
				s = s.replace(smName + "_" + (refinementLevel-2), smName + "_" + (refinementLevel-1));
			}
		}
		return s;		
	}
	
		
	/**
	 * returns true if the element refers to any of the known refined enumerated SM's in its atttributes
	 * @param internalElement
	 * @return
	 */
	private boolean usesStatemachineVariable (IInternalElement internalElement){
		try {
			for (IAttributeValue attribute : internalElement.getAttributeValues()) {
				if (attribute.getType().equals(IAttributeType.String.class)){
					for(String key : refinementLevelMap.keySet()){
						String smName = refinedEnumSMmap.get(key);
						Integer refinementLevel = refinementLevelMap.get(key);
						if(attribute.getValue().toString().contains(smName+"_"+ (refinementLevel-1)) ||
						   attribute.getValue().toString().contains(smName+"_"+ (refinementLevel-2)) ){
							return true;
						}
					}
				}
			}
		} catch (RodinDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
