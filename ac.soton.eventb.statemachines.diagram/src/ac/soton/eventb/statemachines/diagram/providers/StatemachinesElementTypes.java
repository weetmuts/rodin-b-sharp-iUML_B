/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eventb.emf.core.machine.MachinePackage;

import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.diagram.edit.parts.FinalEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InitialEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerFinalEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerInitialEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InvariantEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RootStatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionGhostEditPart;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesDiagramEditorPlugin;

/**
 * @generated
 */
public class StatemachinesElementTypes {

	/**
	 * @generated
	 */
	private StatemachinesElementTypes() {
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
	public static final IElementType Statemachine_1000 = getElementType("ac.soton.eventb.statemachines.diagram.Statemachine_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Initial_2006 = getElementType("ac.soton.eventb.statemachines.diagram.Initial_2006"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Final_2007 = getElementType("ac.soton.eventb.statemachines.diagram.Final_2007"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType State_2008 = getElementType("ac.soton.eventb.statemachines.diagram.State_2008"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Statemachine_3001 = getElementType("ac.soton.eventb.statemachines.diagram.Statemachine_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Initial_3011 = getElementType("ac.soton.eventb.statemachines.diagram.Initial_3011"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Final_3012 = getElementType("ac.soton.eventb.statemachines.diagram.Final_3012"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType State_3013 = getElementType("ac.soton.eventb.statemachines.diagram.State_3013"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Invariant_3014 = getElementType("ac.soton.eventb.statemachines.diagram.Invariant_3014"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Transition_4001 = getElementType("ac.soton.eventb.statemachines.diagram.Transition_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Transition_4002 = getElementType("ac.soton.eventb.statemachines.diagram.Transition_4002"); //$NON-NLS-1$

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
				return StatemachinesDiagramEditorPlugin.getInstance()
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
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(Statemachine_1000,
					StatemachinesPackage.eINSTANCE.getStatemachine());

			elements.put(Initial_2006,
					StatemachinesPackage.eINSTANCE.getInitial());

			elements.put(Final_2007, StatemachinesPackage.eINSTANCE.getFinal());

			elements.put(State_2008, StatemachinesPackage.eINSTANCE.getState());

			elements.put(Statemachine_3001,
					StatemachinesPackage.eINSTANCE.getStatemachine());

			elements.put(Initial_3011,
					StatemachinesPackage.eINSTANCE.getInitial());

			elements.put(Final_3012, StatemachinesPackage.eINSTANCE.getFinal());

			elements.put(State_3013, StatemachinesPackage.eINSTANCE.getState());

			elements.put(Invariant_3014,
					MachinePackage.eINSTANCE.getInvariant());

			elements.put(Transition_4001,
					StatemachinesPackage.eINSTANCE.getTransition());

			elements.put(Transition_4002,
					StatemachinesPackage.eINSTANCE.getTransition());
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
			KNOWN_ELEMENT_TYPES.add(Statemachine_1000);
			KNOWN_ELEMENT_TYPES.add(Initial_2006);
			KNOWN_ELEMENT_TYPES.add(Final_2007);
			KNOWN_ELEMENT_TYPES.add(State_2008);
			KNOWN_ELEMENT_TYPES.add(Statemachine_3001);
			KNOWN_ELEMENT_TYPES.add(Initial_3011);
			KNOWN_ELEMENT_TYPES.add(Final_3012);
			KNOWN_ELEMENT_TYPES.add(State_3013);
			KNOWN_ELEMENT_TYPES.add(Invariant_3014);
			KNOWN_ELEMENT_TYPES.add(Transition_4001);
			KNOWN_ELEMENT_TYPES.add(Transition_4002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case RootStatemachineEditPart.VISUAL_ID:
			return Statemachine_1000;
		case InitialEditPart.VISUAL_ID:
			return Initial_2006;
		case FinalEditPart.VISUAL_ID:
			return Final_2007;
		case StateEditPart.VISUAL_ID:
			return State_2008;
		case StatemachineEditPart.VISUAL_ID:
			return Statemachine_3001;
		case InnerInitialEditPart.VISUAL_ID:
			return Initial_3011;
		case InnerFinalEditPart.VISUAL_ID:
			return Final_3012;
		case InnerStateEditPart.VISUAL_ID:
			return State_3013;
		case InvariantEditPart.VISUAL_ID:
			return Invariant_3014;
		case TransitionEditPart.VISUAL_ID:
			return Transition_4001;
		case TransitionGhostEditPart.VISUAL_ID:
			return Transition_4002;
		}
		return null;
	}

}
