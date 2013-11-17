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
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eventb.emf.core.machine.MachinePackage;

import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.diagram.edit.parts.Any2EditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.AnyEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.FinalEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.Fork2EditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.ForkEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InitialEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerFinalEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerInitialEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InvariantEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.Junction2EditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.JunctionEditPart;
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
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			StatemachinesDiagramEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory());

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
	public static final IElementType Junction_2009 = getElementType("ac.soton.eventb.statemachines.diagram.Junction_2009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Any_2010 = getElementType("ac.soton.eventb.statemachines.diagram.Any_2010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Fork_2011 = getElementType("ac.soton.eventb.statemachines.diagram.Fork_2011"); //$NON-NLS-1$

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
	public static final IElementType Junction_3015 = getElementType("ac.soton.eventb.statemachines.diagram.Junction_3015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Any_3016 = getElementType("ac.soton.eventb.statemachines.diagram.Any_3016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Fork_3017 = getElementType("ac.soton.eventb.statemachines.diagram.Fork_3017"); //$NON-NLS-1$

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
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
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

			elements.put(Junction_2009,
					StatemachinesPackage.eINSTANCE.getJunction());

			elements.put(Any_2010, StatemachinesPackage.eINSTANCE.getAny());

			elements.put(Fork_2011, StatemachinesPackage.eINSTANCE.getFork());

			elements.put(Statemachine_3001,
					StatemachinesPackage.eINSTANCE.getStatemachine());

			elements.put(Initial_3011,
					StatemachinesPackage.eINSTANCE.getInitial());

			elements.put(Final_3012, StatemachinesPackage.eINSTANCE.getFinal());

			elements.put(State_3013, StatemachinesPackage.eINSTANCE.getState());

			elements.put(Invariant_3014,
					MachinePackage.eINSTANCE.getInvariant());

			elements.put(Junction_3015,
					StatemachinesPackage.eINSTANCE.getJunction());

			elements.put(Any_3016, StatemachinesPackage.eINSTANCE.getAny());

			elements.put(Fork_3017, StatemachinesPackage.eINSTANCE.getFork());

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
			KNOWN_ELEMENT_TYPES.add(Junction_2009);
			KNOWN_ELEMENT_TYPES.add(Any_2010);
			KNOWN_ELEMENT_TYPES.add(Fork_2011);
			KNOWN_ELEMENT_TYPES.add(Statemachine_3001);
			KNOWN_ELEMENT_TYPES.add(Initial_3011);
			KNOWN_ELEMENT_TYPES.add(Final_3012);
			KNOWN_ELEMENT_TYPES.add(State_3013);
			KNOWN_ELEMENT_TYPES.add(Invariant_3014);
			KNOWN_ELEMENT_TYPES.add(Junction_3015);
			KNOWN_ELEMENT_TYPES.add(Any_3016);
			KNOWN_ELEMENT_TYPES.add(Fork_3017);
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
		case JunctionEditPart.VISUAL_ID:
			return Junction_2009;
		case AnyEditPart.VISUAL_ID:
			return Any_2010;
		case ForkEditPart.VISUAL_ID:
			return Fork_2011;
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
		case Junction2EditPart.VISUAL_ID:
			return Junction_3015;
		case Any2EditPart.VISUAL_ID:
			return Any_3016;
		case Fork2EditPart.VISUAL_ID:
			return Fork_3017;
		case TransitionEditPart.VISUAL_ID:
			return Transition_4001;
		case TransitionGhostEditPart.VISUAL_ID:
			return Transition_4002;
		}
		return null;
	}

	/**
	 * @generated
	 */
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(
			elementTypeImages) {

		/**
		 * @generated
		 */
		@Override
		public boolean isKnownElementType(IElementType elementType) {
			return ac.soton.eventb.statemachines.diagram.providers.StatemachinesElementTypes
					.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return ac.soton.eventb.statemachines.diagram.providers.StatemachinesElementTypes
					.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(
				IAdaptable elementTypeAdapter) {
			return ac.soton.eventb.statemachines.diagram.providers.StatemachinesElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
