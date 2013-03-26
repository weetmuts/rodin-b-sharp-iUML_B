package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IFilter;
import org.eventb.emf.core.EventBCommented;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.emf.core.extension.coreextension.EventBLabeled;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;

public class ClassdiagramsSheetPropertyFilter {
	/*
	 * Copyright (c) 2010 University of Southampton. All rights reserved. This
	 * program and the accompanying materials are made available under the terms
	 * of the Eclipse Public License v1.0 which accompanies this distribution,
	 * and is available at http://www.eclipse.org/legal/epl-v10.html
	 */

	/**
	 * Filter for properties of named element.
	 */
	public static final class NamedElementFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof EventBNamed;
		}
	}

	/**
	 * Filter for properties of labeled element.
	 */
	public static final class LabeledElementFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof EventBLabeled;
		}
	}

	/**
	 * Filter for comment property of commented element.
	 */
	public static final class CommentedElementFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof EventBCommented;
		}
	}

	/**
	 * Filter for properties of class element.
	 */
	public static final class ClassFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof Class;
		}
	}

	/**
	 * Filter for properties of association element.
	 */
	public static final class AssociationFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof Association;
		}
	}
	
	/**
	 * Filter for properties of association element.
	 */
	public static final class ClassAttributeFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof ClassAttribute;
		}
	}
	
	/**
	 * Filter for properties of class element.
	 */
	public static final class ElaborativeElement implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof Class;
		}
	}
	
	/**
	 * Filter for properties of class element residing in the Context.
	 */
	public static final class ContextClassFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			if (( DiagramUtils.unwrap(toTest) instanceof Class) &&
					(EcoreUtil.getRootContainer( DiagramUtils.unwrap(toTest)) instanceof Context ) ) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	/**
	 * Filter for properties of class element residing in the Machine.
	 */
	public static final class MachineClassFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			if (( DiagramUtils.unwrap(toTest) instanceof Class) &&
					(EcoreUtil.getRootContainer( DiagramUtils.unwrap(toTest)) instanceof Machine ) ) {
				return true;
			} else {
				return false;
			}
		}
	}

}
