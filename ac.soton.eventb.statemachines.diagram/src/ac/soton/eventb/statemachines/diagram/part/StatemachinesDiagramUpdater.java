/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.part;

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
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Invariant;

import ac.soton.eventb.statemachines.AbstractNode;
import ac.soton.eventb.statemachines.AbstractStatemachine;
import ac.soton.eventb.statemachines.DiagramRoot;
import ac.soton.eventb.statemachines.Final;
import ac.soton.eventb.statemachines.Initial;
import ac.soton.eventb.statemachines.RefinedState;
import ac.soton.eventb.statemachines.RefinedStatemachine;
import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.Statemachine;
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
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerRefinedStateStatemachinesCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateInvariantsCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateStatemachinesCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateInvariantEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateInvariantsCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateStatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateStatemachinesCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStatemachineStatesCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateInvariantEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateInvariantsCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateStatemachinesCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StatemachineStatesCompartment2EditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StatemachineStatesCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionGhostEditPart;
import ac.soton.eventb.statemachines.diagram.providers.StatemachinesElementTypes;

/**
 * @generated
 */
public class StatemachinesDiagramUpdater {

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
	public static List<StatemachinesNodeDescriptor> getSemanticChildren(
			View view) {
		switch (StatemachinesVisualIDRegistry.getVisualID(view)) {
		case DiagramRootEditPart.VISUAL_ID:
			return getDiagramRoot_1000SemanticChildren(view);
		case StateStatemachinesCompartmentEditPart.VISUAL_ID:
			return getStateStatemachines_7001SemanticChildren(view);
		case StateInvariantsCompartmentEditPart.VISUAL_ID:
			return getStateInvariants_7002SemanticChildren(view);
		case StatemachineStatesCompartmentEditPart.VISUAL_ID:
			return getStatemachineStates_7003SemanticChildren(view);
		case InnerStateStatemachinesCompartmentEditPart.VISUAL_ID:
			return getStateStatemachines_7004SemanticChildren(view);
		case InnerStateInvariantsCompartmentEditPart.VISUAL_ID:
			return getStateInvariants_7005SemanticChildren(view);
		case RefinedStateStatemachinesCompartmentEditPart.VISUAL_ID:
			return getRefinedStateStatemachines_7006SemanticChildren(view);
		case RefinedStateInvariantsCompartmentEditPart.VISUAL_ID:
			return getRefinedStateInvariants_7007SemanticChildren(view);
		case RefinedStatemachineStatesCompartmentEditPart.VISUAL_ID:
			return getRefinedStatemachineStates_7008SemanticChildren(view);
		case InnerRefinedStateStatemachinesCompartmentEditPart.VISUAL_ID:
			return getRefinedStateStatemachines_7009SemanticChildren(view);
		case InnerRefinedStateInvariantsCompartmentEditPart.VISUAL_ID:
			return getRefinedStateInvariants_7010SemanticChildren(view);
		case StatemachineStatesCompartment2EditPart.VISUAL_ID:
			return getStatemachineStates_7011SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesNodeDescriptor> getDiagramRoot_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		DiagramRoot modelElement = (DiagramRoot) view.getElement();
		LinkedList<StatemachinesNodeDescriptor> result = new LinkedList<StatemachinesNodeDescriptor>();
		for (Iterator<?> it = modelElement.getNodes().iterator(); it.hasNext();) {
			AbstractNode childElement = (AbstractNode) it.next();
			int visualID = StatemachinesVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == InitialEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == FinalEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == ANYEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == StateEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == RefinedStateEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesNodeDescriptor> getStateStatemachines_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		State modelElement = (State) containerView.getElement();
		LinkedList<StatemachinesNodeDescriptor> result = new LinkedList<StatemachinesNodeDescriptor>();
		for (Iterator<?> it = modelElement.getStatemachines().iterator(); it
				.hasNext();) {
			AbstractStatemachine childElement = (AbstractStatemachine) it
					.next();
			int visualID = StatemachinesVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == StatemachineEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesNodeDescriptor> getStateInvariants_7002SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		State modelElement = (State) containerView.getElement();
		LinkedList<StatemachinesNodeDescriptor> result = new LinkedList<StatemachinesNodeDescriptor>();
		for (Iterator<?> it = modelElement.getConstraints().iterator(); it
				.hasNext();) {
			Invariant childElement = (Invariant) it.next();
			int visualID = StatemachinesVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == StateInvariantEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesNodeDescriptor> getStatemachineStates_7003SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Statemachine modelElement = (Statemachine) containerView.getElement();
		LinkedList<StatemachinesNodeDescriptor> result = new LinkedList<StatemachinesNodeDescriptor>();
		for (Iterator<?> it = modelElement.getNodes().iterator(); it.hasNext();) {
			AbstractNode childElement = (AbstractNode) it.next();
			int visualID = StatemachinesVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == InnerInitialEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == InnerFinalEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == InnerANYEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == InnerStateEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesNodeDescriptor> getStateStatemachines_7004SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		State modelElement = (State) containerView.getElement();
		LinkedList<StatemachinesNodeDescriptor> result = new LinkedList<StatemachinesNodeDescriptor>();
		for (Iterator<?> it = modelElement.getStatemachines().iterator(); it
				.hasNext();) {
			AbstractStatemachine childElement = (AbstractStatemachine) it
					.next();
			int visualID = StatemachinesVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == StatemachineEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesNodeDescriptor> getStateInvariants_7005SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		State modelElement = (State) containerView.getElement();
		LinkedList<StatemachinesNodeDescriptor> result = new LinkedList<StatemachinesNodeDescriptor>();
		for (Iterator<?> it = modelElement.getConstraints().iterator(); it
				.hasNext();) {
			Invariant childElement = (Invariant) it.next();
			int visualID = StatemachinesVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == StateInvariantEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesNodeDescriptor> getRefinedStateStatemachines_7006SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		RefinedState modelElement = (RefinedState) containerView.getElement();
		LinkedList<StatemachinesNodeDescriptor> result = new LinkedList<StatemachinesNodeDescriptor>();
		for (Iterator<?> it = modelElement.getStatemachines().iterator(); it
				.hasNext();) {
			AbstractStatemachine childElement = (AbstractStatemachine) it
					.next();
			int visualID = StatemachinesVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == RefinedStatemachineEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == RefinedStateStatemachineEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesNodeDescriptor> getRefinedStateInvariants_7007SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		RefinedState modelElement = (RefinedState) containerView.getElement();
		LinkedList<StatemachinesNodeDescriptor> result = new LinkedList<StatemachinesNodeDescriptor>();
		for (Iterator<?> it = modelElement.getConstraints().iterator(); it
				.hasNext();) {
			Invariant childElement = (Invariant) it.next();
			int visualID = StatemachinesVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == RefinedStateInvariantEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesNodeDescriptor> getRefinedStatemachineStates_7008SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		RefinedStatemachine modelElement = (RefinedStatemachine) containerView
				.getElement();
		LinkedList<StatemachinesNodeDescriptor> result = new LinkedList<StatemachinesNodeDescriptor>();
		for (Iterator<?> it = modelElement.getNodes().iterator(); it.hasNext();) {
			AbstractNode childElement = (AbstractNode) it.next();
			int visualID = StatemachinesVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == InnerInitialEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == InnerFinalEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == InnerANYEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == InnerRefinedStateEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesNodeDescriptor> getRefinedStateStatemachines_7009SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		RefinedState modelElement = (RefinedState) containerView.getElement();
		LinkedList<StatemachinesNodeDescriptor> result = new LinkedList<StatemachinesNodeDescriptor>();
		for (Iterator<?> it = modelElement.getStatemachines().iterator(); it
				.hasNext();) {
			AbstractStatemachine childElement = (AbstractStatemachine) it
					.next();
			int visualID = StatemachinesVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == RefinedStatemachineEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == RefinedStateStatemachineEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesNodeDescriptor> getRefinedStateInvariants_7010SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		RefinedState modelElement = (RefinedState) containerView.getElement();
		LinkedList<StatemachinesNodeDescriptor> result = new LinkedList<StatemachinesNodeDescriptor>();
		for (Iterator<?> it = modelElement.getConstraints().iterator(); it
				.hasNext();) {
			Invariant childElement = (Invariant) it.next();
			int visualID = StatemachinesVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == RefinedStateInvariantEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesNodeDescriptor> getStatemachineStates_7011SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Statemachine modelElement = (Statemachine) containerView.getElement();
		LinkedList<StatemachinesNodeDescriptor> result = new LinkedList<StatemachinesNodeDescriptor>();
		for (Iterator<?> it = modelElement.getNodes().iterator(); it.hasNext();) {
			AbstractNode childElement = (AbstractNode) it.next();
			int visualID = StatemachinesVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == InnerInitialEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == InnerFinalEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == InnerANYEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == InnerStateEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getContainedLinks(View view) {
		switch (StatemachinesVisualIDRegistry.getVisualID(view)) {
		case DiagramRootEditPart.VISUAL_ID:
			return getDiagramRoot_1000ContainedLinks(view);
		case InitialEditPart.VISUAL_ID:
			return getInitial_2001ContainedLinks(view);
		case FinalEditPart.VISUAL_ID:
			return getFinal_2002ContainedLinks(view);
		case ANYEditPart.VISUAL_ID:
			return getANY_2003ContainedLinks(view);
		case StateEditPart.VISUAL_ID:
			return getState_2004ContainedLinks(view);
		case RefinedStateEditPart.VISUAL_ID:
			return getRefinedState_2005ContainedLinks(view);
		case StatemachineEditPart.VISUAL_ID:
			return getStatemachine_3001ContainedLinks(view);
		case InnerInitialEditPart.VISUAL_ID:
			return getInitial_3002ContainedLinks(view);
		case InnerFinalEditPart.VISUAL_ID:
			return getFinal_3003ContainedLinks(view);
		case InnerANYEditPart.VISUAL_ID:
			return getANY_3004ContainedLinks(view);
		case InnerStateEditPart.VISUAL_ID:
			return getState_3005ContainedLinks(view);
		case StateInvariantEditPart.VISUAL_ID:
			return getInvariant_3006ContainedLinks(view);
		case RefinedStatemachineEditPart.VISUAL_ID:
			return getRefinedStatemachine_3007ContainedLinks(view);
		case InnerRefinedStateEditPart.VISUAL_ID:
			return getRefinedState_3008ContainedLinks(view);
		case RefinedStateStatemachineEditPart.VISUAL_ID:
			return getStatemachine_3009ContainedLinks(view);
		case RefinedStateInvariantEditPart.VISUAL_ID:
			return getInvariant_3010ContainedLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001ContainedLinks(view);
		case TransitionGhostEditPart.VISUAL_ID:
			return getTransition_4002ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getIncomingLinks(View view) {
		switch (StatemachinesVisualIDRegistry.getVisualID(view)) {
		case InitialEditPart.VISUAL_ID:
			return getInitial_2001IncomingLinks(view);
		case FinalEditPart.VISUAL_ID:
			return getFinal_2002IncomingLinks(view);
		case ANYEditPart.VISUAL_ID:
			return getANY_2003IncomingLinks(view);
		case StateEditPart.VISUAL_ID:
			return getState_2004IncomingLinks(view);
		case RefinedStateEditPart.VISUAL_ID:
			return getRefinedState_2005IncomingLinks(view);
		case StatemachineEditPart.VISUAL_ID:
			return getStatemachine_3001IncomingLinks(view);
		case InnerInitialEditPart.VISUAL_ID:
			return getInitial_3002IncomingLinks(view);
		case InnerFinalEditPart.VISUAL_ID:
			return getFinal_3003IncomingLinks(view);
		case InnerANYEditPart.VISUAL_ID:
			return getANY_3004IncomingLinks(view);
		case InnerStateEditPart.VISUAL_ID:
			return getState_3005IncomingLinks(view);
		case StateInvariantEditPart.VISUAL_ID:
			return getInvariant_3006IncomingLinks(view);
		case RefinedStatemachineEditPart.VISUAL_ID:
			return getRefinedStatemachine_3007IncomingLinks(view);
		case InnerRefinedStateEditPart.VISUAL_ID:
			return getRefinedState_3008IncomingLinks(view);
		case RefinedStateStatemachineEditPart.VISUAL_ID:
			return getStatemachine_3009IncomingLinks(view);
		case RefinedStateInvariantEditPart.VISUAL_ID:
			return getInvariant_3010IncomingLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001IncomingLinks(view);
		case TransitionGhostEditPart.VISUAL_ID:
			return getTransition_4002IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getOutgoingLinks(View view) {
		switch (StatemachinesVisualIDRegistry.getVisualID(view)) {
		case InitialEditPart.VISUAL_ID:
			return getInitial_2001OutgoingLinks(view);
		case FinalEditPart.VISUAL_ID:
			return getFinal_2002OutgoingLinks(view);
		case ANYEditPart.VISUAL_ID:
			return getANY_2003OutgoingLinks(view);
		case StateEditPart.VISUAL_ID:
			return getState_2004OutgoingLinks(view);
		case RefinedStateEditPart.VISUAL_ID:
			return getRefinedState_2005OutgoingLinks(view);
		case StatemachineEditPart.VISUAL_ID:
			return getStatemachine_3001OutgoingLinks(view);
		case InnerInitialEditPart.VISUAL_ID:
			return getInitial_3002OutgoingLinks(view);
		case InnerFinalEditPart.VISUAL_ID:
			return getFinal_3003OutgoingLinks(view);
		case InnerANYEditPart.VISUAL_ID:
			return getANY_3004OutgoingLinks(view);
		case InnerStateEditPart.VISUAL_ID:
			return getState_3005OutgoingLinks(view);
		case StateInvariantEditPart.VISUAL_ID:
			return getInvariant_3006OutgoingLinks(view);
		case RefinedStatemachineEditPart.VISUAL_ID:
			return getRefinedStatemachine_3007OutgoingLinks(view);
		case InnerRefinedStateEditPart.VISUAL_ID:
			return getRefinedState_3008OutgoingLinks(view);
		case RefinedStateStatemachineEditPart.VISUAL_ID:
			return getStatemachine_3009OutgoingLinks(view);
		case RefinedStateInvariantEditPart.VISUAL_ID:
			return getInvariant_3010OutgoingLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001OutgoingLinks(view);
		case TransitionGhostEditPart.VISUAL_ID:
			return getTransition_4002OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getDiagramRoot_1000ContainedLinks(
			View view) {
		DiagramRoot modelElement = (DiagramRoot) view.getElement();
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Transition_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Transition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getInitial_2001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getFinal_2002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getANY_2003ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getState_2004ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getRefinedState_2005ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getStatemachine_3001ContainedLinks(
			View view) {
		Statemachine modelElement = (Statemachine) view.getElement();
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Transition_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Transition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getInitial_3002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getFinal_3003ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getANY_3004ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getState_3005ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getInvariant_3006ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getRefinedStatemachine_3007ContainedLinks(
			View view) {
		RefinedStatemachine modelElement = (RefinedStatemachine) view
				.getElement();
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Transition_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Transition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getRefinedState_3008ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getStatemachine_3009ContainedLinks(
			View view) {
		Statemachine modelElement = (Statemachine) view.getElement();
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Transition_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Transition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getInvariant_3010ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getTransition_4001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getTransition_4002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getInitial_2001IncomingLinks(
			View view) {
		Initial modelElement = (Initial) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getFinal_2002IncomingLinks(
			View view) {
		Final modelElement = (Final) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getANY_2003IncomingLinks(
			View view) {
		ac.soton.eventb.statemachines.ANY modelElement = (ac.soton.eventb.statemachines.ANY) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getState_2004IncomingLinks(
			View view) {
		State modelElement = (State) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getRefinedState_2005IncomingLinks(
			View view) {
		RefinedState modelElement = (RefinedState) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getStatemachine_3001IncomingLinks(
			View view) {
		Statemachine modelElement = (Statemachine) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getInitial_3002IncomingLinks(
			View view) {
		Initial modelElement = (Initial) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getFinal_3003IncomingLinks(
			View view) {
		Final modelElement = (Final) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getANY_3004IncomingLinks(
			View view) {
		ac.soton.eventb.statemachines.ANY modelElement = (ac.soton.eventb.statemachines.ANY) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getState_3005IncomingLinks(
			View view) {
		State modelElement = (State) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getInvariant_3006IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getRefinedStatemachine_3007IncomingLinks(
			View view) {
		RefinedStatemachine modelElement = (RefinedStatemachine) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getRefinedState_3008IncomingLinks(
			View view) {
		RefinedState modelElement = (RefinedState) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getStatemachine_3009IncomingLinks(
			View view) {
		Statemachine modelElement = (Statemachine) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getInvariant_3010IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getTransition_4001IncomingLinks(
			View view) {
		Transition modelElement = (Transition) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getTransition_4002IncomingLinks(
			View view) {
		Transition modelElement = (Transition) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getInitial_2001OutgoingLinks(
			View view) {
		Initial modelElement = (Initial) view.getElement();
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getFinal_2002OutgoingLinks(
			View view) {
		Final modelElement = (Final) view.getElement();
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getANY_2003OutgoingLinks(
			View view) {
		ac.soton.eventb.statemachines.ANY modelElement = (ac.soton.eventb.statemachines.ANY) view
				.getElement();
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getState_2004OutgoingLinks(
			View view) {
		State modelElement = (State) view.getElement();
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getRefinedState_2005OutgoingLinks(
			View view) {
		RefinedState modelElement = (RefinedState) view.getElement();
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getStatemachine_3001OutgoingLinks(
			View view) {
		Statemachine modelElement = (Statemachine) view.getElement();
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getInitial_3002OutgoingLinks(
			View view) {
		Initial modelElement = (Initial) view.getElement();
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getFinal_3003OutgoingLinks(
			View view) {
		Final modelElement = (Final) view.getElement();
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getANY_3004OutgoingLinks(
			View view) {
		ac.soton.eventb.statemachines.ANY modelElement = (ac.soton.eventb.statemachines.ANY) view
				.getElement();
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getState_3005OutgoingLinks(
			View view) {
		State modelElement = (State) view.getElement();
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getInvariant_3006OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getRefinedStatemachine_3007OutgoingLinks(
			View view) {
		RefinedStatemachine modelElement = (RefinedStatemachine) view
				.getElement();
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getRefinedState_3008OutgoingLinks(
			View view) {
		RefinedState modelElement = (RefinedState) view.getElement();
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getStatemachine_3009OutgoingLinks(
			View view) {
		Statemachine modelElement = (Statemachine) view.getElement();
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getInvariant_3010OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getTransition_4001OutgoingLinks(
			View view) {
		Transition modelElement = (Transition) view.getElement();
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getTransition_4002OutgoingLinks(
			View view) {
		Transition modelElement = (Transition) view.getElement();
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<StatemachinesLinkDescriptor> getContainedTypeModelFacetLinks_Transition_4001(
			AbstractStatemachine container) {
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		for (Iterator<?> links = container.getTransitions().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition) linkObject;
			if (TransitionEditPart.VISUAL_ID != StatemachinesVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			AbstractNode dst = link.getTarget();
			AbstractNode src = link.getSource();
			result.add(new StatemachinesLinkDescriptor(src, dst, link,
					StatemachinesElementTypes.Transition_4001,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<StatemachinesLinkDescriptor> getContainedTypeModelFacetLinks_Transition_4002(
			AbstractStatemachine container) {
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		for (Iterator<?> links = container.getTransitions().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition) linkObject;
			if (TransitionGhostEditPart.VISUAL_ID != StatemachinesVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			EventBElement dst = link.getTargetContainer();
			EventBElement src = link.getSourceContainer();
			result.add(new StatemachinesLinkDescriptor(src, dst, link,
					StatemachinesElementTypes.Transition_4002,
					TransitionGhostEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<StatemachinesLinkDescriptor> getIncomingTypeModelFacetLinks_Transition_4001(
			AbstractNode target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != StatemachinesPackage.eINSTANCE
					.getTransition_Target()
					|| false == setting.getEObject() instanceof Transition) {
				continue;
			}
			Transition link = (Transition) setting.getEObject();
			if (TransitionEditPart.VISUAL_ID != StatemachinesVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			AbstractNode src = link.getSource();
			result.add(new StatemachinesLinkDescriptor(src, target, link,
					StatemachinesElementTypes.Transition_4001,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<StatemachinesLinkDescriptor> getIncomingTypeModelFacetLinks_Transition_4002(
			EventBElement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != StatemachinesPackage.eINSTANCE
					.getTransition_TargetContainer()
					|| false == setting.getEObject() instanceof Transition) {
				continue;
			}
			Transition link = (Transition) setting.getEObject();
			if (TransitionGhostEditPart.VISUAL_ID != StatemachinesVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			EventBElement src = link.getSourceContainer();
			result.add(new StatemachinesLinkDescriptor(src, target, link,
					StatemachinesElementTypes.Transition_4002,
					TransitionGhostEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<StatemachinesLinkDescriptor> getOutgoingTypeModelFacetLinks_Transition_4001(
			AbstractNode source) {
		AbstractStatemachine container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof AbstractStatemachine) {
				container = (AbstractStatemachine) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		for (Iterator<?> links = container.getTransitions().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition) linkObject;
			if (TransitionEditPart.VISUAL_ID != StatemachinesVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			AbstractNode dst = link.getTarget();
			AbstractNode src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new StatemachinesLinkDescriptor(src, dst, link,
					StatemachinesElementTypes.Transition_4001,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<StatemachinesLinkDescriptor> getOutgoingTypeModelFacetLinks_Transition_4002(
			EventBElement source) {
		AbstractStatemachine container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof AbstractStatemachine) {
				container = (AbstractStatemachine) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		for (Iterator<?> links = container.getTransitions().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition) linkObject;
			if (TransitionGhostEditPart.VISUAL_ID != StatemachinesVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			EventBElement dst = link.getTargetContainer();
			EventBElement src = link.getSourceContainer();
			if (src != source) {
				continue;
			}
			result.add(new StatemachinesLinkDescriptor(src, dst, link,
					StatemachinesElementTypes.Transition_4002,
					TransitionGhostEditPart.VISUAL_ID));
		}
		return result;
	}

}
