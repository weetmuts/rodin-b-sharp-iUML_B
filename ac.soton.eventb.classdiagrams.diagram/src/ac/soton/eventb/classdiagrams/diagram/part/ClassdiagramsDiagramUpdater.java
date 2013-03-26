/*
 * Copyright (c) 2012 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.classdiagrams.ClassConstraint;
import ac.soton.eventb.classdiagrams.ClassMethod;
import ac.soton.eventb.classdiagrams.Classdiagram;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.AssociationEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassAttributeEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassAttributesCompartmentEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassConstraintEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassConstraintsCompartmentEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassMethodEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassMethodsCompartmentEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassSupertypesEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassdiagramEditPart;
import ac.soton.eventb.classdiagrams.diagram.providers.ClassdiagramsElementTypes;

/**
 * @generated
 */
public class ClassdiagramsDiagramUpdater {

	/**
	 * @generated
	 */
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null
				|| view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	public static List<ClassdiagramsNodeDescriptor> getSemanticChildren(
			View view) {
		switch (ClassdiagramsVisualIDRegistry.getVisualID(view)) {
		case ClassdiagramEditPart.VISUAL_ID:
			return getClassdiagram_1000SemanticChildren(view);
		case ClassAttributesCompartmentEditPart.VISUAL_ID:
			return getClassAttributesCompartment_7006SemanticChildren(view);
		case ClassMethodsCompartmentEditPart.VISUAL_ID:
			return getClassMethodsCompartment_7007SemanticChildren(view);
		case ClassConstraintsCompartmentEditPart.VISUAL_ID:
			return getClassConstraintsCompartment_7008SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassdiagramsNodeDescriptor> getClassdiagram_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Classdiagram modelElement = (Classdiagram) view.getElement();
		LinkedList<ClassdiagramsNodeDescriptor> result = new LinkedList<ClassdiagramsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getClasses().iterator(); it
				.hasNext();) {
			Class childElement = (Class) it.next();
			int visualID = ClassdiagramsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ClassEditPart.VISUAL_ID) {
				result.add(new ClassdiagramsNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ClassdiagramsNodeDescriptor> getClassAttributesCompartment_7006SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Class modelElement = (Class) containerView.getElement();
		LinkedList<ClassdiagramsNodeDescriptor> result = new LinkedList<ClassdiagramsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getClassAttributes().iterator(); it
				.hasNext();) {
			ClassAttribute childElement = (ClassAttribute) it.next();
			int visualID = ClassdiagramsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ClassAttributeEditPart.VISUAL_ID) {
				result.add(new ClassdiagramsNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ClassdiagramsNodeDescriptor> getClassMethodsCompartment_7007SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Class modelElement = (Class) containerView.getElement();
		LinkedList<ClassdiagramsNodeDescriptor> result = new LinkedList<ClassdiagramsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getMethods().iterator(); it
				.hasNext();) {
			ClassMethod childElement = (ClassMethod) it.next();
			int visualID = ClassdiagramsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ClassMethodEditPart.VISUAL_ID) {
				result.add(new ClassdiagramsNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ClassdiagramsNodeDescriptor> getClassConstraintsCompartment_7008SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Class modelElement = (Class) containerView.getElement();
		LinkedList<ClassdiagramsNodeDescriptor> result = new LinkedList<ClassdiagramsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getConstraints().iterator(); it
				.hasNext();) {
			ClassConstraint childElement = (ClassConstraint) it.next();
			int visualID = ClassdiagramsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ClassConstraintEditPart.VISUAL_ID) {
				result.add(new ClassdiagramsNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ClassdiagramsLinkDescriptor> getContainedLinks(View view) {
		switch (ClassdiagramsVisualIDRegistry.getVisualID(view)) {
		case ClassdiagramEditPart.VISUAL_ID:
			return getClassdiagram_1000ContainedLinks(view);
		case ClassEditPart.VISUAL_ID:
			return getClass_2003ContainedLinks(view);
		case ClassAttributeEditPart.VISUAL_ID:
			return getClassAttribute_3022ContainedLinks(view);
		case ClassMethodEditPart.VISUAL_ID:
			return getClassMethod_3023ContainedLinks(view);
		case ClassConstraintEditPart.VISUAL_ID:
			return getClassConstraint_3024ContainedLinks(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_4005ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassdiagramsLinkDescriptor> getIncomingLinks(View view) {
		switch (ClassdiagramsVisualIDRegistry.getVisualID(view)) {
		case ClassEditPart.VISUAL_ID:
			return getClass_2003IncomingLinks(view);
		case ClassAttributeEditPart.VISUAL_ID:
			return getClassAttribute_3022IncomingLinks(view);
		case ClassMethodEditPart.VISUAL_ID:
			return getClassMethod_3023IncomingLinks(view);
		case ClassConstraintEditPart.VISUAL_ID:
			return getClassConstraint_3024IncomingLinks(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_4005IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassdiagramsLinkDescriptor> getOutgoingLinks(View view) {
		switch (ClassdiagramsVisualIDRegistry.getVisualID(view)) {
		case ClassEditPart.VISUAL_ID:
			return getClass_2003OutgoingLinks(view);
		case ClassAttributeEditPart.VISUAL_ID:
			return getClassAttribute_3022OutgoingLinks(view);
		case ClassMethodEditPart.VISUAL_ID:
			return getClassMethod_3023OutgoingLinks(view);
		case ClassConstraintEditPart.VISUAL_ID:
			return getClassConstraint_3024OutgoingLinks(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_4005OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassdiagramsLinkDescriptor> getClassdiagram_1000ContainedLinks(
			View view) {
		Classdiagram modelElement = (Classdiagram) view.getElement();
		LinkedList<ClassdiagramsLinkDescriptor> result = new LinkedList<ClassdiagramsLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Association_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ClassdiagramsLinkDescriptor> getClass_2003ContainedLinks(
			View view) {
		Class modelElement = (Class) view.getElement();
		LinkedList<ClassdiagramsLinkDescriptor> result = new LinkedList<ClassdiagramsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Class_Supertypes_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ClassdiagramsLinkDescriptor> getClassAttribute_3022ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassdiagramsLinkDescriptor> getClassMethod_3023ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassdiagramsLinkDescriptor> getClassConstraint_3024ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassdiagramsLinkDescriptor> getAssociation_4005ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassdiagramsLinkDescriptor> getClass_2003IncomingLinks(
			View view) {
		Class modelElement = (Class) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ClassdiagramsLinkDescriptor> result = new LinkedList<ClassdiagramsLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Association_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Class_Supertypes_4006(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ClassdiagramsLinkDescriptor> getClassAttribute_3022IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassdiagramsLinkDescriptor> getClassMethod_3023IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassdiagramsLinkDescriptor> getClassConstraint_3024IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassdiagramsLinkDescriptor> getAssociation_4005IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassdiagramsLinkDescriptor> getClass_2003OutgoingLinks(
			View view) {
		Class modelElement = (Class) view.getElement();
		LinkedList<ClassdiagramsLinkDescriptor> result = new LinkedList<ClassdiagramsLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4005(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Class_Supertypes_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ClassdiagramsLinkDescriptor> getClassAttribute_3022OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassdiagramsLinkDescriptor> getClassMethod_3023OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassdiagramsLinkDescriptor> getClassConstraint_3024OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassdiagramsLinkDescriptor> getAssociation_4005OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<ClassdiagramsLinkDescriptor> getContainedTypeModelFacetLinks_Association_4005(
			Classdiagram container) {
		LinkedList<ClassdiagramsLinkDescriptor> result = new LinkedList<ClassdiagramsLinkDescriptor>();
		for (Iterator<?> links = container.getAssociations().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (AssociationEditPart.VISUAL_ID != ClassdiagramsVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class dst = link.getTarget();
			Class src = link.getSource();
			result.add(new ClassdiagramsLinkDescriptor(src, dst, link,
					ClassdiagramsElementTypes.Association_4005,
					AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ClassdiagramsLinkDescriptor> getIncomingTypeModelFacetLinks_Association_4005(
			Class target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ClassdiagramsLinkDescriptor> result = new LinkedList<ClassdiagramsLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != ClassdiagramsPackage.eINSTANCE
					.getAssociation_Target()
					|| false == setting.getEObject() instanceof Association) {
				continue;
			}
			Association link = (Association) setting.getEObject();
			if (AssociationEditPart.VISUAL_ID != ClassdiagramsVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class src = link.getSource();
			result.add(new ClassdiagramsLinkDescriptor(src, target, link,
					ClassdiagramsElementTypes.Association_4005,
					AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ClassdiagramsLinkDescriptor> getIncomingFeatureModelFacetLinks_Class_Supertypes_4006(
			Class target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ClassdiagramsLinkDescriptor> result = new LinkedList<ClassdiagramsLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == ClassdiagramsPackage.eINSTANCE
					.getClass_Supertypes()) {
				result.add(new ClassdiagramsLinkDescriptor(
						setting.getEObject(), target,
						ClassdiagramsElementTypes.ClassSupertypes_4006,
						ClassSupertypesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ClassdiagramsLinkDescriptor> getOutgoingTypeModelFacetLinks_Association_4005(
			Class source) {
		Classdiagram container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Classdiagram) {
				container = (Classdiagram) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<ClassdiagramsLinkDescriptor> result = new LinkedList<ClassdiagramsLinkDescriptor>();
		for (Iterator<?> links = container.getAssociations().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (AssociationEditPart.VISUAL_ID != ClassdiagramsVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class dst = link.getTarget();
			Class src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new ClassdiagramsLinkDescriptor(src, dst, link,
					ClassdiagramsElementTypes.Association_4005,
					AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ClassdiagramsLinkDescriptor> getOutgoingFeatureModelFacetLinks_Class_Supertypes_4006(
			Class source) {
		LinkedList<ClassdiagramsLinkDescriptor> result = new LinkedList<ClassdiagramsLinkDescriptor>();
		for (Iterator<?> destinations = source.getSupertypes().iterator(); destinations
				.hasNext();) {
			Class destination = (Class) destinations.next();
			result.add(new ClassdiagramsLinkDescriptor(source, destination,
					ClassdiagramsElementTypes.ClassSupertypes_4006,
					ClassSupertypesEditPart.VISUAL_ID));
		}
		return result;
	}

}
