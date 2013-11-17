/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.sheet.custom;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.IFilter;
import org.eventb.emf.core.EventBCommented;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.machine.Invariant;

import ac.soton.eventb.emf.core.extension.coreextension.EventBDataElaboration;
import ac.soton.eventb.emf.core.extension.coreextension.EventBLabeled;
import ac.soton.eventb.statemachines.AbstractNode;
import ac.soton.eventb.statemachines.Fork;
import ac.soton.eventb.statemachines.Junction;
import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.Transition;
import ac.soton.eventb.statemachines.TranslationKind;

/**
 * Custom property sheet filter collection.
 * Contains filters for properties of different statemachine diagram elements.
 * 
 * @author vitaly
 *
 */
public class StatemachinesSheetPropertyFilter {
	
	/**
	 * Unwraps eobject from passed diagram object.
	 * 
	 * @param object
	 * @return
	 */
	public static EObject unwrap(Object object) {
		if (object instanceof EObject)
			return (EObject) object;
		if (object instanceof EditPart) {
			Object model = ((EditPart) object).getModel();
			return model instanceof View ? ((View) model).getElement() : null;
		}
		if (object instanceof View) {
			return ((View) object).getElement();
		}
		if (object instanceof IAdaptable) {
			View view = (View) ((IAdaptable) object).getAdapter(View.class);
			if (view != null) {
				return view.getElement();
			}
		}
		return null;
	}
	
	/**
	 * Filter for properties of named element.
	 */
	public static final class NamedElementFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return unwrap(toTest) instanceof EventBNamed;
		}
	}
	
	/**
	 * Filter for properties of labelled element.
	 */
	public static final class LabeledElementFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return unwrap(toTest) instanceof EventBLabeled;
		}
	}
	
	/**
	 * Filter for comment property of commented element.
	 */
	public static final class CommentedElementFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return unwrap(toTest) instanceof EventBCommented;
		}
	}
	
	/**
	 * Filter for properties of transition element.
	 */
	public static final class TransitionFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return unwrap(toTest) instanceof Transition;
		}
	}
	
	/**
	 * Filter for elaborates properties of transition element.
	 * (elaborates property is suppressed for certain kinds of transition)
	 */
	public static final class TransitionElaboratesFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			EObject unwrapped = unwrap(toTest);
			if (! (unwrapped instanceof Transition)) return false;
			AbstractNode target = ((Transition)unwrapped).getTarget();
			AbstractNode source = ((Transition)unwrapped).getSource();
			if (target instanceof Junction || 
				(target instanceof Fork && ((Fork)target).isJoin()) ||
				(source instanceof Fork && ((Fork)source).isFork())){
				return false;
			}else{
				return true;
			}
		}
	}
	
	/**
	 * Filter for guards of transition element.
	 * (guards are suppressed for certain kinds of transition)
	 */
	public static final class TransitionGuardsFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			EObject unwrapped = unwrap(toTest);
			if (! (unwrapped instanceof Transition)) return false;
			AbstractNode target = ((Transition)unwrapped).getTarget();
			AbstractNode source = ((Transition)unwrapped).getSource();
			if (
				(target instanceof Fork && ((Fork)target).isJoin()) ||
				(source instanceof Fork && ((Fork)source).isFork())){
				return false;
			}else{
				return true;
			}
		}
	}
	
	/**
	 * Filter for properties of statemachine element.
	 */
	public static final class StatemachineFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return unwrap(toTest) instanceof Statemachine;
		}
	}
	
	/**
	 * Filter for properties of statemachine element.
	 */
	public static final class StatemachineElaboratesDataFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			EObject unwrapped = unwrap(toTest);
			return 	unwrapped instanceof EventBDataElaboration && unwrapped instanceof Statemachine && 
					TranslationKind.SINGLEVAR == ((Statemachine)unwrapped).getTranslation();
		}
	}
	
	/**
	 * Filter for properties of tate element.
	 */
	public static final class StateFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return unwrap(toTest) instanceof State;
		}
	}
	
	/**
	 * Filter for properties of invariant element.
	 */
	public static final class InvariantFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return unwrap(toTest) instanceof Invariant;
		}
	}
	
	/**
	 * Filter for properties of root statemachine element.
	 */
	public static final class RootStatemachineFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			EObject element = unwrap(toTest);
			return element instanceof Statemachine && !(element.eContainer() instanceof State);
		}
	}

}
