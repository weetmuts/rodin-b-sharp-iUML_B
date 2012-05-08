package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.IFilter;
import org.eventb.emf.core.EventBCommented;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.machine.Invariant;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.Classdiagram;
import ac.soton.eventb.emf.core.extension.coreextension.EventBLabeled;

public class ClassdiagramsSheetPropertyFilter {
	/*
	 * Copyright (c) 2010 University of Southampton. All rights reserved. This
	 * program and the accompanying materials are made available under the terms
	 * of the Eclipse Public License v1.0 which accompanies this distribution,
	 * and is available at http://www.eclipse.org/legal/epl-v10.html
	 */

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
	 * Filter for properties of labeled element.
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
	 * Filter for properties of class element.
	 */
	public static final class ClassFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return unwrap(toTest) instanceof Class;
		}
	}

	/**
	 * Filter for properties of association element.
	 */
	public static final class AssociationFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return unwrap(toTest) instanceof Association;
		}
	}
	
	/**
	 * Filter for properties of class element.
	 */
	public static final class ElaborativeElement implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return unwrap(toTest) instanceof Class;
		}
	}

}
