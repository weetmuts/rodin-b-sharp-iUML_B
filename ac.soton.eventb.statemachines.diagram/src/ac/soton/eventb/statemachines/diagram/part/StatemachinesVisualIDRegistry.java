/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eventb.emf.core.machine.MachinePackage;

import ac.soton.eventb.statemachines.DiagramRoot;
import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.Transition;
import ac.soton.eventb.statemachines.diagram.edit.parts.ANYEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.DiagramRootEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.FinalEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InitialEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerANYEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerFinalEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerInitialEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerRefinedStateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerRefinedStateInvariantsCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerRefinedStateLabelEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerRefinedStateStatemachinesCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateInvariantsCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateNameEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateStatemachinesCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateInvariantEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateInvariantsCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateLabelEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateStatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateStatemachineNameEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateStatemachinesCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStatemachineLabelEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStatemachineStatesCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateInvariantEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateInvariantsCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateNameEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateStatemachinesCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StatemachineNameEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StatemachineStatesCompartment2EditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StatemachineStatesCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionGhostEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionGhostNameEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionNameEditPart;
import ac.soton.eventb.statemachines.diagram.expressions.StatemachinesOCLFactory;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class StatemachinesVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "ac.soton.eventb.statemachines.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (DiagramRootEditPart.MODEL_ID.equals(view.getType())) {
				return DiagramRootEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return ac.soton.eventb.statemachines.diagram.part.StatemachinesVisualIDRegistry
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
				StatemachinesDiagramEditorPlugin.getInstance().logError(
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
		if (StatemachinesPackage.eINSTANCE.getDiagramRoot().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((DiagramRoot) domainElement)) {
			return DiagramRootEditPart.VISUAL_ID;
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
		String containerModelID = ac.soton.eventb.statemachines.diagram.part.StatemachinesVisualIDRegistry
				.getModelID(containerView);
		if (!DiagramRootEditPart.MODEL_ID.equals(containerModelID)
				&& !"statemachines".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (DiagramRootEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = ac.soton.eventb.statemachines.diagram.part.StatemachinesVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = DiagramRootEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case DiagramRootEditPart.VISUAL_ID:
			if (StatemachinesPackage.eINSTANCE.getInitial().isSuperTypeOf(
					domainElement.eClass())) {
				return InitialEditPart.VISUAL_ID;
			}
			if (StatemachinesPackage.eINSTANCE.getFinal().isSuperTypeOf(
					domainElement.eClass())) {
				return FinalEditPart.VISUAL_ID;
			}
			if (StatemachinesPackage.eINSTANCE.getANY().isSuperTypeOf(
					domainElement.eClass())) {
				return ANYEditPart.VISUAL_ID;
			}
			if (StatemachinesPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())) {
				return StateEditPart.VISUAL_ID;
			}
			if (StatemachinesPackage.eINSTANCE.getRefinedState().isSuperTypeOf(
					domainElement.eClass())) {
				return RefinedStateEditPart.VISUAL_ID;
			}
			break;
		case StateStatemachinesCompartmentEditPart.VISUAL_ID:
			if (StatemachinesPackage.eINSTANCE.getStatemachine().isSuperTypeOf(
					domainElement.eClass())) {
				return StatemachineEditPart.VISUAL_ID;
			}
			break;
		case StateInvariantsCompartmentEditPart.VISUAL_ID:
			if (MachinePackage.eINSTANCE.getInvariant().isSuperTypeOf(
					domainElement.eClass())) {
				return StateInvariantEditPart.VISUAL_ID;
			}
			break;
		case StatemachineStatesCompartmentEditPart.VISUAL_ID:
			if (StatemachinesPackage.eINSTANCE.getInitial().isSuperTypeOf(
					domainElement.eClass())) {
				return InnerInitialEditPart.VISUAL_ID;
			}
			if (StatemachinesPackage.eINSTANCE.getFinal().isSuperTypeOf(
					domainElement.eClass())) {
				return InnerFinalEditPart.VISUAL_ID;
			}
			if (StatemachinesPackage.eINSTANCE.getANY().isSuperTypeOf(
					domainElement.eClass())) {
				return InnerANYEditPart.VISUAL_ID;
			}
			if (StatemachinesPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())) {
				return InnerStateEditPart.VISUAL_ID;
			}
			break;
		case InnerStateStatemachinesCompartmentEditPart.VISUAL_ID:
			if (StatemachinesPackage.eINSTANCE.getStatemachine().isSuperTypeOf(
					domainElement.eClass())) {
				return StatemachineEditPart.VISUAL_ID;
			}
			break;
		case InnerStateInvariantsCompartmentEditPart.VISUAL_ID:
			if (MachinePackage.eINSTANCE.getInvariant().isSuperTypeOf(
					domainElement.eClass())) {
				return StateInvariantEditPart.VISUAL_ID;
			}
			break;
		case RefinedStateStatemachinesCompartmentEditPart.VISUAL_ID:
			if (StatemachinesPackage.eINSTANCE.getRefinedStatemachine()
					.isSuperTypeOf(domainElement.eClass())) {
				return RefinedStatemachineEditPart.VISUAL_ID;
			}
			if (StatemachinesPackage.eINSTANCE.getStatemachine().isSuperTypeOf(
					domainElement.eClass())) {
				return RefinedStateStatemachineEditPart.VISUAL_ID;
			}
			break;
		case RefinedStateInvariantsCompartmentEditPart.VISUAL_ID:
			if (MachinePackage.eINSTANCE.getInvariant().isSuperTypeOf(
					domainElement.eClass())) {
				return RefinedStateInvariantEditPart.VISUAL_ID;
			}
			break;
		case RefinedStatemachineStatesCompartmentEditPart.VISUAL_ID:
			if (StatemachinesPackage.eINSTANCE.getInitial().isSuperTypeOf(
					domainElement.eClass())) {
				return InnerInitialEditPart.VISUAL_ID;
			}
			if (StatemachinesPackage.eINSTANCE.getFinal().isSuperTypeOf(
					domainElement.eClass())) {
				return InnerFinalEditPart.VISUAL_ID;
			}
			if (StatemachinesPackage.eINSTANCE.getANY().isSuperTypeOf(
					domainElement.eClass())) {
				return InnerANYEditPart.VISUAL_ID;
			}
			if (StatemachinesPackage.eINSTANCE.getRefinedState().isSuperTypeOf(
					domainElement.eClass())) {
				return InnerRefinedStateEditPart.VISUAL_ID;
			}
			break;
		case InnerRefinedStateStatemachinesCompartmentEditPart.VISUAL_ID:
			if (StatemachinesPackage.eINSTANCE.getRefinedStatemachine()
					.isSuperTypeOf(domainElement.eClass())) {
				return RefinedStatemachineEditPart.VISUAL_ID;
			}
			if (StatemachinesPackage.eINSTANCE.getStatemachine().isSuperTypeOf(
					domainElement.eClass())) {
				return RefinedStateStatemachineEditPart.VISUAL_ID;
			}
			break;
		case InnerRefinedStateInvariantsCompartmentEditPart.VISUAL_ID:
			if (MachinePackage.eINSTANCE.getInvariant().isSuperTypeOf(
					domainElement.eClass())) {
				return RefinedStateInvariantEditPart.VISUAL_ID;
			}
			break;
		case StatemachineStatesCompartment2EditPart.VISUAL_ID:
			if (StatemachinesPackage.eINSTANCE.getInitial().isSuperTypeOf(
					domainElement.eClass())) {
				return InnerInitialEditPart.VISUAL_ID;
			}
			if (StatemachinesPackage.eINSTANCE.getFinal().isSuperTypeOf(
					domainElement.eClass())) {
				return InnerFinalEditPart.VISUAL_ID;
			}
			if (StatemachinesPackage.eINSTANCE.getANY().isSuperTypeOf(
					domainElement.eClass())) {
				return InnerANYEditPart.VISUAL_ID;
			}
			if (StatemachinesPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())) {
				return InnerStateEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = ac.soton.eventb.statemachines.diagram.part.StatemachinesVisualIDRegistry
				.getModelID(containerView);
		if (!DiagramRootEditPart.MODEL_ID.equals(containerModelID)
				&& !"statemachines".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (DiagramRootEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = ac.soton.eventb.statemachines.diagram.part.StatemachinesVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = DiagramRootEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case DiagramRootEditPart.VISUAL_ID:
			if (InitialEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FinalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ANYEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RefinedStateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateEditPart.VISUAL_ID:
			if (StateNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateStatemachinesCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateInvariantsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RefinedStateEditPart.VISUAL_ID:
			if (RefinedStateLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RefinedStateStatemachinesCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RefinedStateInvariantsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StatemachineEditPart.VISUAL_ID:
			if (StatemachineStatesCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InnerStateEditPart.VISUAL_ID:
			if (InnerStateNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InnerStateStatemachinesCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InnerStateInvariantsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RefinedStatemachineEditPart.VISUAL_ID:
			if (RefinedStatemachineStatesCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InnerRefinedStateEditPart.VISUAL_ID:
			if (InnerRefinedStateLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InnerRefinedStateStatemachinesCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InnerRefinedStateInvariantsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RefinedStateStatemachineEditPart.VISUAL_ID:
			if (StatemachineStatesCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateStatemachinesCompartmentEditPart.VISUAL_ID:
			if (StatemachineEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateInvariantsCompartmentEditPart.VISUAL_ID:
			if (StateInvariantEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StatemachineStatesCompartmentEditPart.VISUAL_ID:
			if (InnerInitialEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InnerFinalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InnerANYEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InnerStateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InnerStateStatemachinesCompartmentEditPart.VISUAL_ID:
			if (StatemachineEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InnerStateInvariantsCompartmentEditPart.VISUAL_ID:
			if (StateInvariantEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RefinedStateStatemachinesCompartmentEditPart.VISUAL_ID:
			if (RefinedStatemachineEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RefinedStateStatemachineEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RefinedStateInvariantsCompartmentEditPart.VISUAL_ID:
			if (RefinedStateInvariantEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RefinedStatemachineStatesCompartmentEditPart.VISUAL_ID:
			if (InnerInitialEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InnerFinalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InnerANYEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InnerRefinedStateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InnerRefinedStateStatemachinesCompartmentEditPart.VISUAL_ID:
			if (RefinedStatemachineEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RefinedStateStatemachineEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InnerRefinedStateInvariantsCompartmentEditPart.VISUAL_ID:
			if (RefinedStateInvariantEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StatemachineStatesCompartment2EditPart.VISUAL_ID:
			if (InnerInitialEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InnerFinalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InnerANYEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InnerStateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TransitionEditPart.VISUAL_ID:
			if (TransitionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TransitionGhostEditPart.VISUAL_ID:
			if (TransitionGhostNameEditPart.VISUAL_ID == nodeVisualID) {
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
		if (StatemachinesPackage.eINSTANCE.getTransition().isSuperTypeOf(
				domainElement.eClass())
				&& isTransition_4001((Transition) domainElement)) {
			return TransitionEditPart.VISUAL_ID;
		}
		if (StatemachinesPackage.eINSTANCE.getTransition().isSuperTypeOf(
				domainElement.eClass())
				&& isTransition_4002((Transition) domainElement)) {
			return TransitionGhostEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(DiagramRoot element) {
		return true;
	}

	/**
	 * @generated
	 */
	private static boolean isTransition_4001(Transition domainElement) {
		Object result = StatemachinesOCLFactory.getExpression(0,
				StatemachinesPackage.eINSTANCE.getTransition(), null).evaluate(
				domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isTransition_4002(Transition domainElement) {
		Object result = StatemachinesOCLFactory.getExpression(1,
				StatemachinesPackage.eINSTANCE.getTransition(), null).evaluate(
				domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

}
