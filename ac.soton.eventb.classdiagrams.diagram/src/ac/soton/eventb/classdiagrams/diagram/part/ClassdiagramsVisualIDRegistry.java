/*
 * Copyright (c) 2012 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import ac.soton.eventb.classdiagrams.Classdiagram;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.AssociationEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.AssociationNameEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.AssociationSurjectiveInjectiveEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.AssociationTotalFunctionalEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassAttributeEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassAttributesCompartmentEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassConstraintEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassConstraintsCompartmentEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassMethodEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassMethodsCompartmentEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassNameEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassdiagramEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class ClassdiagramsVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "ac.soton.eventb.classdiagrams.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (ClassdiagramEditPart.MODEL_ID.equals(view.getType())) {
				return ClassdiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return ac.soton.eventb.classdiagrams.diagram.part.ClassdiagramsVisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				ClassdiagramsDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (ClassdiagramsPackage.eINSTANCE.getClassdiagram().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((Classdiagram) domainElement)) {
			return ClassdiagramEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = ac.soton.eventb.classdiagrams.diagram.part.ClassdiagramsVisualIDRegistry
				.getModelID(containerView);
		if (!ClassdiagramEditPart.MODEL_ID.equals(containerModelID)
				&& !"classdiagrams".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (ClassdiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = ac.soton.eventb.classdiagrams.diagram.part.ClassdiagramsVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ClassdiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case ClassdiagramEditPart.VISUAL_ID:
			if (ClassdiagramsPackage.eINSTANCE.getClass_().isSuperTypeOf(
					domainElement.eClass())) {
				return ClassEditPart.VISUAL_ID;
			}
			break;
		case ClassAttributesCompartmentEditPart.VISUAL_ID:
			if (ClassdiagramsPackage.eINSTANCE.getClassAttribute()
					.isSuperTypeOf(domainElement.eClass())) {
				return ClassAttributeEditPart.VISUAL_ID;
			}
			break;
		case ClassMethodsCompartmentEditPart.VISUAL_ID:
			if (ClassdiagramsPackage.eINSTANCE.getClassMethod().isSuperTypeOf(
					domainElement.eClass())) {
				return ClassMethodEditPart.VISUAL_ID;
			}
			break;
		case ClassConstraintsCompartmentEditPart.VISUAL_ID:
			if (ClassdiagramsPackage.eINSTANCE.getClassConstraint()
					.isSuperTypeOf(domainElement.eClass())) {
				return ClassConstraintEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = ac.soton.eventb.classdiagrams.diagram.part.ClassdiagramsVisualIDRegistry
				.getModelID(containerView);
		if (!ClassdiagramEditPart.MODEL_ID.equals(containerModelID)
				&& !"classdiagrams".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (ClassdiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = ac.soton.eventb.classdiagrams.diagram.part.ClassdiagramsVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ClassdiagramEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case ClassdiagramEditPart.VISUAL_ID:
			if (ClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassEditPart.VISUAL_ID:
			if (ClassNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassAttributesCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMethodsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassConstraintsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassAttributesCompartmentEditPart.VISUAL_ID:
			if (ClassAttributeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassMethodsCompartmentEditPart.VISUAL_ID:
			if (ClassMethodEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassConstraintsCompartmentEditPart.VISUAL_ID:
			if (ClassConstraintEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssociationEditPart.VISUAL_ID:
			if (AssociationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationSurjectiveInjectiveEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationTotalFunctionalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (ClassdiagramsPackage.eINSTANCE.getAssociation().isSuperTypeOf(
				domainElement.eClass())) {
			return AssociationEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Classdiagram element) {
		return true;
	}

}
