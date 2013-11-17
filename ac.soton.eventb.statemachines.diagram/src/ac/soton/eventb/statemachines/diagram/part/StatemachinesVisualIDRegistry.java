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
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;
import org.eventb.emf.core.machine.MachinePackage;

import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.Transition;
import ac.soton.eventb.statemachines.diagram.edit.parts.Any2EditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.AnyEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.FinalEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.Fork2EditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.ForkEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InitialEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerFinalEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerInitialEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateInvariantsCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateNameEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateStatemachinesCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InvariantEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.Junction2EditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.JunctionEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RootStatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateInvariantsCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateNameEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateStatemachinesCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StatemachineStatesCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionGhostEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionGhostLabelEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionLabelEditPart;
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
			if (RootStatemachineEditPart.MODEL_ID.equals(view.getType())) {
				return RootStatemachineEditPart.VISUAL_ID;
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
		if (StatemachinesPackage.eINSTANCE.getStatemachine().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((Statemachine) domainElement)) {
			return RootStatemachineEditPart.VISUAL_ID;
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
		if (!RootStatemachineEditPart.MODEL_ID.equals(containerModelID)
				&& !"statemachines".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (RootStatemachineEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = ac.soton.eventb.statemachines.diagram.part.StatemachinesVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = RootStatemachineEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case RootStatemachineEditPart.VISUAL_ID:
			if (StatemachinesPackage.eINSTANCE.getInitial().isSuperTypeOf(
					domainElement.eClass())) {
				return InitialEditPart.VISUAL_ID;
			}
			if (StatemachinesPackage.eINSTANCE.getFinal().isSuperTypeOf(
					domainElement.eClass())) {
				return FinalEditPart.VISUAL_ID;
			}
			if (StatemachinesPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())) {
				return StateEditPart.VISUAL_ID;
			}
			if (StatemachinesPackage.eINSTANCE.getJunction().isSuperTypeOf(
					domainElement.eClass())) {
				return JunctionEditPart.VISUAL_ID;
			}
			if (StatemachinesPackage.eINSTANCE.getAny().isSuperTypeOf(
					domainElement.eClass())) {
				return AnyEditPart.VISUAL_ID;
			}
			if (StatemachinesPackage.eINSTANCE.getFork().isSuperTypeOf(
					domainElement.eClass())) {
				return ForkEditPart.VISUAL_ID;
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
				return InvariantEditPart.VISUAL_ID;
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
			if (StatemachinesPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())) {
				return InnerStateEditPart.VISUAL_ID;
			}
			if (StatemachinesPackage.eINSTANCE.getJunction().isSuperTypeOf(
					domainElement.eClass())) {
				return Junction2EditPart.VISUAL_ID;
			}
			if (StatemachinesPackage.eINSTANCE.getAny().isSuperTypeOf(
					domainElement.eClass())) {
				return Any2EditPart.VISUAL_ID;
			}
			if (StatemachinesPackage.eINSTANCE.getFork().isSuperTypeOf(
					domainElement.eClass())) {
				return Fork2EditPart.VISUAL_ID;
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
				return InvariantEditPart.VISUAL_ID;
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
		if (!RootStatemachineEditPart.MODEL_ID.equals(containerModelID)
				&& !"statemachines".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (RootStatemachineEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = ac.soton.eventb.statemachines.diagram.part.StatemachinesVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = RootStatemachineEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case RootStatemachineEditPart.VISUAL_ID:
			if (InitialEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FinalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (JunctionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AnyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForkEditPart.VISUAL_ID == nodeVisualID) {
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
		case StateStatemachinesCompartmentEditPart.VISUAL_ID:
			if (StatemachineEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateInvariantsCompartmentEditPart.VISUAL_ID:
			if (InvariantEditPart.VISUAL_ID == nodeVisualID) {
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
			if (InnerStateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Junction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Any2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Fork2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InnerStateStatemachinesCompartmentEditPart.VISUAL_ID:
			if (StatemachineEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InnerStateInvariantsCompartmentEditPart.VISUAL_ID:
			if (InvariantEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TransitionEditPart.VISUAL_ID:
			if (TransitionLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TransitionGhostEditPart.VISUAL_ID:
			if (TransitionGhostLabelEditPart.VISUAL_ID == nodeVisualID) {
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
	private static boolean isDiagram(Statemachine element) {
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

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView,
			EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(int visualID) {
		switch (visualID) {
		case StateStatemachinesCompartmentEditPart.VISUAL_ID:
		case StateInvariantsCompartmentEditPart.VISUAL_ID:
		case StatemachineStatesCompartmentEditPart.VISUAL_ID:
		case InnerStateStatemachinesCompartmentEditPart.VISUAL_ID:
		case InnerStateInvariantsCompartmentEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case RootStatemachineEditPart.VISUAL_ID:
			return false;
		case InitialEditPart.VISUAL_ID:
		case FinalEditPart.VISUAL_ID:
		case JunctionEditPart.VISUAL_ID:
		case AnyEditPart.VISUAL_ID:
		case ForkEditPart.VISUAL_ID:
		case InnerInitialEditPart.VISUAL_ID:
		case InnerFinalEditPart.VISUAL_ID:
		case InvariantEditPart.VISUAL_ID:
		case Junction2EditPart.VISUAL_ID:
		case Any2EditPart.VISUAL_ID:
		case Fork2EditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		 * @generated
		 */
		@Override
		public int getVisualID(View view) {
			return ac.soton.eventb.statemachines.diagram.part.StatemachinesVisualIDRegistry
					.getVisualID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getModelID(View view) {
			return ac.soton.eventb.statemachines.diagram.part.StatemachinesVisualIDRegistry
					.getModelID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return ac.soton.eventb.statemachines.diagram.part.StatemachinesVisualIDRegistry
					.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean checkNodeVisualID(View containerView,
				EObject domainElement, int candidate) {
			return ac.soton.eventb.statemachines.diagram.part.StatemachinesVisualIDRegistry
					.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return ac.soton.eventb.statemachines.diagram.part.StatemachinesVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return ac.soton.eventb.statemachines.diagram.part.StatemachinesVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
