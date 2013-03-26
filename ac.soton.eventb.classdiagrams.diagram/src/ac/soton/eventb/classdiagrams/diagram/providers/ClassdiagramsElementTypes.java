/*
 * Copyright (c) 2012 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eventb.emf.core.EventBNamed;

import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.AssociationEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassAttributeEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassConstraintEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassMethodEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassSupertypesEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassdiagramEditPart;
import ac.soton.eventb.classdiagrams.diagram.part.ClassdiagramsDiagramEditorPlugin;
import ac.soton.eventb.emf.core.extension.coreextension.EventBDataElaboration;

/**
 * @generated
 */
public class ClassdiagramsElementTypes {

	/**
	 * @generated
	 */
	private ClassdiagramsElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Classdiagram_1000 = getElementType("ac.soton.eventb.classdiagrams.diagram.Classdiagram_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Class_2003 = getElementType("ac.soton.eventb.classdiagrams.diagram.Class_2003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ClassAttribute_3022 = getElementType("ac.soton.eventb.classdiagrams.diagram.ClassAttribute_3022"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ClassMethod_3023 = getElementType("ac.soton.eventb.classdiagrams.diagram.ClassMethod_3023"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ClassConstraint_3024 = getElementType("ac.soton.eventb.classdiagrams.diagram.ClassConstraint_3024"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Association_4005 = getElementType("ac.soton.eventb.classdiagrams.diagram.Association_4005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ClassSupertypes_4006 = getElementType("ac.soton.eventb.classdiagrams.diagram.ClassSupertypes_4006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return ClassdiagramsDiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * This is added to allow dynamic icons (dependent on model state) to be stored in the registry
	 * (to avoid creating multiple images).
	 * Be careful to make sure the key is unique to the icon!
	 * 
	 * @custom
	 * @param key
	 * @param imageDescriptor
	 * @return
	 */
	public static Image getImage(EObject element){
		ENamedElement elementType = element.eClass();
		if (element instanceof EventBDataElaboration){
			EventBNamed data = ((EventBDataElaboration)element).getElaborates();
			if (data != null){
				elementType = data.eClass(); 
			}
		}
		return getImage(elementType);
	}
	
	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(Classdiagram_1000,
					ClassdiagramsPackage.eINSTANCE.getClassdiagram());

			elements.put(Class_2003, ClassdiagramsPackage.eINSTANCE.getClass_());

			elements.put(ClassAttribute_3022,
					ClassdiagramsPackage.eINSTANCE.getClassAttribute());

			elements.put(ClassMethod_3023,
					ClassdiagramsPackage.eINSTANCE.getClassMethod());

			elements.put(ClassConstraint_3024,
					ClassdiagramsPackage.eINSTANCE.getClassConstraint());

			elements.put(Association_4005,
					ClassdiagramsPackage.eINSTANCE.getAssociation());

			elements.put(ClassSupertypes_4006,
					ClassdiagramsPackage.eINSTANCE.getClass_Supertypes());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Classdiagram_1000);
			KNOWN_ELEMENT_TYPES.add(Class_2003);
			KNOWN_ELEMENT_TYPES.add(ClassAttribute_3022);
			KNOWN_ELEMENT_TYPES.add(ClassMethod_3023);
			KNOWN_ELEMENT_TYPES.add(ClassConstraint_3024);
			KNOWN_ELEMENT_TYPES.add(Association_4005);
			KNOWN_ELEMENT_TYPES.add(ClassSupertypes_4006);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case ClassdiagramEditPart.VISUAL_ID:
			return Classdiagram_1000;
		case ClassEditPart.VISUAL_ID:
			return Class_2003;
		case ClassAttributeEditPart.VISUAL_ID:
			return ClassAttribute_3022;
		case ClassMethodEditPart.VISUAL_ID:
			return ClassMethod_3023;
		case ClassConstraintEditPart.VISUAL_ID:
			return ClassConstraint_3024;
		case AssociationEditPart.VISUAL_ID:
			return Association_4005;
		case ClassSupertypesEditPart.VISUAL_ID:
			return ClassSupertypes_4006;
		}
		return null;
	}

}
