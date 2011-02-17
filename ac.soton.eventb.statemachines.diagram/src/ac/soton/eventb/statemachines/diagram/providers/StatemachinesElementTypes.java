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
import ac.soton.eventb.statemachines.diagram.edit.parts.ANYEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.AbstractStatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.FinalEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InitialEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerANYEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerFinalEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerInitialEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerRefinedStateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateInvariantEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateStatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateInvariantEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateStatemachineEditPart;
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
	public static final IElementType DiagramRoot_1000 = getElementType("ac.soton.eventb.statemachines.diagram.DiagramRoot_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Initial_2001 = getElementType("ac.soton.eventb.statemachines.diagram.Initial_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Final_2002 = getElementType("ac.soton.eventb.statemachines.diagram.Final_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ANY_2003 = getElementType("ac.soton.eventb.statemachines.diagram.ANY_2003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType State_2004 = getElementType("ac.soton.eventb.statemachines.diagram.State_2004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType RefinedState_2005 = getElementType("ac.soton.eventb.statemachines.diagram.RefinedState_2005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Statemachine_3001 = getElementType("ac.soton.eventb.statemachines.diagram.Statemachine_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Initial_3002 = getElementType("ac.soton.eventb.statemachines.diagram.Initial_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Final_3003 = getElementType("ac.soton.eventb.statemachines.diagram.Final_3003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ANY_3004 = getElementType("ac.soton.eventb.statemachines.diagram.ANY_3004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType State_3005 = getElementType("ac.soton.eventb.statemachines.diagram.State_3005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Invariant_3006 = getElementType("ac.soton.eventb.statemachines.diagram.Invariant_3006"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType RefinedStatemachine_3007 = getElementType("ac.soton.eventb.statemachines.diagram.RefinedStatemachine_3007"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType RefinedState_3008 = getElementType("ac.soton.eventb.statemachines.diagram.RefinedState_3008"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Statemachine_3009 = getElementType("ac.soton.eventb.statemachines.diagram.Statemachine_3009"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Invariant_3010 = getElementType("ac.soton.eventb.statemachines.diagram.Invariant_3010"); //$NON-NLS-1$
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

			elements.put(DiagramRoot_1000,
					StatemachinesPackage.eINSTANCE.getDiagramRoot());

			elements.put(Initial_2001,
					StatemachinesPackage.eINSTANCE.getInitial());

			elements.put(Final_2002, StatemachinesPackage.eINSTANCE.getFinal());

			elements.put(ANY_2003, StatemachinesPackage.eINSTANCE.getANY());

			elements.put(State_2004, StatemachinesPackage.eINSTANCE.getState());

			elements.put(RefinedState_2005,
					StatemachinesPackage.eINSTANCE.getRefinedState());

			elements.put(Statemachine_3001,
					StatemachinesPackage.eINSTANCE.getStatemachine());

			elements.put(Initial_3002,
					StatemachinesPackage.eINSTANCE.getInitial());

			elements.put(Final_3003, StatemachinesPackage.eINSTANCE.getFinal());

			elements.put(ANY_3004, StatemachinesPackage.eINSTANCE.getANY());

			elements.put(State_3005, StatemachinesPackage.eINSTANCE.getState());

			elements.put(Invariant_3006,
					MachinePackage.eINSTANCE.getInvariant());

			elements.put(RefinedStatemachine_3007,
					StatemachinesPackage.eINSTANCE.getRefinedStatemachine());

			elements.put(RefinedState_3008,
					StatemachinesPackage.eINSTANCE.getRefinedState());

			elements.put(Statemachine_3009,
					StatemachinesPackage.eINSTANCE.getStatemachine());

			elements.put(Invariant_3010,
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
			KNOWN_ELEMENT_TYPES.add(DiagramRoot_1000);
			KNOWN_ELEMENT_TYPES.add(Initial_2001);
			KNOWN_ELEMENT_TYPES.add(Final_2002);
			KNOWN_ELEMENT_TYPES.add(ANY_2003);
			KNOWN_ELEMENT_TYPES.add(State_2004);
			KNOWN_ELEMENT_TYPES.add(RefinedState_2005);
			KNOWN_ELEMENT_TYPES.add(Statemachine_3001);
			KNOWN_ELEMENT_TYPES.add(Initial_3002);
			KNOWN_ELEMENT_TYPES.add(Final_3003);
			KNOWN_ELEMENT_TYPES.add(ANY_3004);
			KNOWN_ELEMENT_TYPES.add(State_3005);
			KNOWN_ELEMENT_TYPES.add(Invariant_3006);
			KNOWN_ELEMENT_TYPES.add(RefinedStatemachine_3007);
			KNOWN_ELEMENT_TYPES.add(RefinedState_3008);
			KNOWN_ELEMENT_TYPES.add(Statemachine_3009);
			KNOWN_ELEMENT_TYPES.add(Invariant_3010);
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
		case AbstractStatemachineEditPart.VISUAL_ID:
			return DiagramRoot_1000;
		case InitialEditPart.VISUAL_ID:
			return Initial_2001;
		case FinalEditPart.VISUAL_ID:
			return Final_2002;
		case ANYEditPart.VISUAL_ID:
			return ANY_2003;
		case StateEditPart.VISUAL_ID:
			return State_2004;
		case RefinedStateEditPart.VISUAL_ID:
			return RefinedState_2005;
		case StateStatemachineEditPart.VISUAL_ID:
			return Statemachine_3001;
		case InnerInitialEditPart.VISUAL_ID:
			return Initial_3002;
		case InnerFinalEditPart.VISUAL_ID:
			return Final_3003;
		case InnerANYEditPart.VISUAL_ID:
			return ANY_3004;
		case InnerStateEditPart.VISUAL_ID:
			return State_3005;
		case StateInvariantEditPart.VISUAL_ID:
			return Invariant_3006;
		case RefinedStatemachineEditPart.VISUAL_ID:
			return RefinedStatemachine_3007;
		case InnerRefinedStateEditPart.VISUAL_ID:
			return RefinedState_3008;
		case RefinedStateStatemachineEditPart.VISUAL_ID:
			return Statemachine_3009;
		case RefinedStateInvariantEditPart.VISUAL_ID:
			return Invariant_3010;
		case TransitionEditPart.VISUAL_ID:
			return Transition_4001;
		case TransitionGhostEditPart.VISUAL_ID:
			return Transition_4002;
		}
		return null;
	}

}
