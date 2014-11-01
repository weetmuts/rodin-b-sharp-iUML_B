/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IFilter;
import org.eventb.emf.core.machine.Action;
import org.eventb.emf.core.machine.Guard;
import org.eventb.emf.core.machine.Witness;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassConstraint;
import ac.soton.eventb.classdiagrams.ClassMethod;
import ac.soton.eventb.emf.diagrams.sheet.AbstractTextPropertySection;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;

/**
 * SelfName property section for Class.
 * 
 * @author cfs
 *
 */
public class SelfNamePropertySection extends AbstractTextPropertySection {

	/**
	 * Element Filter for this property section.
	 */
	public static final class Filter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof Class;
		}
	}
	@Override
	protected String getPropertyNameLabel() {
		return "Self Name:";
	}

	@Override
	protected void setPropertyValue(EObject object, Object value) {
		assert object instanceof Class;
		refactor((Class) object, ((Class) object).getSelfName(), (String)value);
		((Class) object).setSelfName((String)value);
	}

	private void refactor(Class cl, String oldSelfName, String newSelfName) {
		for (ClassConstraint inv : cl.getConstraints()){
			inv.setPredicate(refactor(inv.getPredicate(), oldSelfName, newSelfName));
		}
		for (ClassMethod cm : cl.getMethods()){
			for (Guard g : cm.getGuards()){
				g.setPredicate(refactor(g.getPredicate(), oldSelfName, newSelfName));				
			}
			for (Action a : cm.getActions()){
				a.setAction(refactor(a.getAction(), oldSelfName, newSelfName));				
			}
			for (Witness w : cm.getWitnesses()){
				w.setPredicate(refactor(w.getPredicate(), oldSelfName, newSelfName));				
			}
		}
		
	}

	private String refactor(String string, String oldSelfName, String newSelfName) {
		return 	string.replaceAll("(\\W)"+oldSelfName+"(?!\\w)", "$1"+newSelfName);
	}

	@Override
	protected String getPropertyValueString() {
		return ((Class) getEObject()).getSelfName();
	}

	@Override
	protected String getPropertyChangeCommandName() {
		return "change selfName";
	}

}
