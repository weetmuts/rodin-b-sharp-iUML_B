/*
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.sheet.custom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.EventBNamedCommentedElement;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.emf.diagrams.sheet.AbstractEnumerationPropertySection;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachinesPackage;

/**
 * Instances property section for Statemachine.
 * 
 * @author cfs
 *
 */
public class InstancesPropertySection extends AbstractEnumerationPropertySection {
	
	@Override
	protected String[] getEnumerationFeatureValues() {
		List<Object> values = getAvailableDataElements();
		String[] ret = new String[values.size()];
		for (int i = 0; i < values.size(); i++) {
			if (values.get(i)instanceof EventBNamed) {
				ret[i] = ((EventBNamed)values.get(i)).eClass().getName()+": "+((EventBNamed)values.get(i)).getName();
			}else{
				ret[i] = "";
			}
		}
		return ret;
	}

	@Override
	protected String getFeatureAsText() {
		EventBNamedCommentedElement instances = ((Statemachine) eObject).getInstances();
		return instances==null? "" : instances.getName();
	}

	@Override
	protected String getLabelText() {
		return "Instances:";
	}

	@Override
	protected EStructuralFeature getFeature() {
		return StatemachinesPackage.Literals.STATEMACHINE__INSTANCES;
	}

	@Override
	protected List<Object> getAvailableDataElements(){
		EventBNamedCommentedComponentElement container = (EventBNamedCommentedComponentElement)((EventBElement)eObject).getContaining(CorePackage.Literals.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT);
		// find all data elements in scope
		List<Object> values = getAvailableDataElements(container);
		values.add(0, null);
		return values;
	}
	
	private List<Object> getAvailableDataElements(EventBNamedCommentedComponentElement container) {
		List<Object> list =  new ArrayList<Object>() ;
		if (container instanceof Machine){
			Machine m = ((Machine)container);
			list.addAll(m.getVariables());
			for (Context c : m.getSees()){
				list.addAll(getAvailableDataElements(c));
			}			
		}else if (container instanceof Context){
			Context c = ((Context)container);
			list.addAll(c.getSets());
			list.addAll(c.getConstants());
			for (Context x : c.getExtends()){
				list.addAll(getAvailableDataElements(x));
			}
		}
		return list;
	}
	
}
