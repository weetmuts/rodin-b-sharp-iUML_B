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
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Invariant;

import ac.soton.eventb.statemachines.AbstractNode;
import ac.soton.eventb.statemachines.Any;
import ac.soton.eventb.statemachines.Final;
import ac.soton.eventb.statemachines.Fork;
import ac.soton.eventb.statemachines.Initial;
import ac.soton.eventb.statemachines.Junction;
import ac.soton.eventb.statemachines.State;
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
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateStatemachinesCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InvariantEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.Junction2EditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.JunctionEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RootStatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateInvariantsCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateStatemachinesCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StatemachineEditPart;
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
		case RootStatemachineEditPart.VISUAL_ID:
			return getStatemachine_1000SemanticChildren(view);
		case StateStatemachinesCompartmentEditPart.VISUAL_ID:
			return getStateStateStatemachinesCompartment_7012SemanticChildren(view);
		case StateInvariantsCompartmentEditPart.VISUAL_ID:
			return getStateStateInvariantsCompartment_7013SemanticChildren(view);
		case StatemachineStatesCompartmentEditPart.VISUAL_ID:
			return getStatemachineStatemachineStatesCompartment_7003SemanticChildren(view);
		case InnerStateStatemachinesCompartmentEditPart.VISUAL_ID:
			return getStateStateStatemachinesCompartment_7014SemanticChildren(view);
		case InnerStateInvariantsCompartmentEditPart.VISUAL_ID:
			return getStateStateInvariantsCompartment_7015SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesNodeDescriptor> getStatemachine_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Statemachine modelElement = (Statemachine) view.getElement();
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
			if (visualID == StateEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == JunctionEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == AnyEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == ForkEditPart.VISUAL_ID) {
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
	public static List<StatemachinesNodeDescriptor> getStateStateStatemachinesCompartment_7012SemanticChildren(
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
			Statemachine childElement = (Statemachine) it.next();
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
	public static List<StatemachinesNodeDescriptor> getStateStateInvariantsCompartment_7013SemanticChildren(
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
		for (Iterator<?> it = modelElement.getInvariants().iterator(); it
				.hasNext();) {
			Invariant childElement = (Invariant) it.next();
			int visualID = StatemachinesVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == InvariantEditPart.VISUAL_ID) {
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
	public static List<StatemachinesNodeDescriptor> getStatemachineStatemachineStatesCompartment_7003SemanticChildren(
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
			if (visualID == InnerStateEditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == Junction2EditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == Any2EditPart.VISUAL_ID) {
				result.add(new StatemachinesNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == Fork2EditPart.VISUAL_ID) {
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
	public static List<StatemachinesNodeDescriptor> getStateStateStatemachinesCompartment_7014SemanticChildren(
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
			Statemachine childElement = (Statemachine) it.next();
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
	public static List<StatemachinesNodeDescriptor> getStateStateInvariantsCompartment_7015SemanticChildren(
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
		for (Iterator<?> it = modelElement.getInvariants().iterator(); it
				.hasNext();) {
			Invariant childElement = (Invariant) it.next();
			int visualID = StatemachinesVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == InvariantEditPart.VISUAL_ID) {
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
		case RootStatemachineEditPart.VISUAL_ID:
			return getStatemachine_1000ContainedLinks(view);
		case InitialEditPart.VISUAL_ID:
			return getInitial_2006ContainedLinks(view);
		case FinalEditPart.VISUAL_ID:
			return getFinal_2007ContainedLinks(view);
		case StateEditPart.VISUAL_ID:
			return getState_2008ContainedLinks(view);
		case JunctionEditPart.VISUAL_ID:
			return getJunction_2009ContainedLinks(view);
		case AnyEditPart.VISUAL_ID:
			return getAny_2010ContainedLinks(view);
		case ForkEditPart.VISUAL_ID:
			return getFork_2011ContainedLinks(view);
		case StatemachineEditPart.VISUAL_ID:
			return getStatemachine_3001ContainedLinks(view);
		case InnerInitialEditPart.VISUAL_ID:
			return getInitial_3011ContainedLinks(view);
		case InnerFinalEditPart.VISUAL_ID:
			return getFinal_3012ContainedLinks(view);
		case InnerStateEditPart.VISUAL_ID:
			return getState_3013ContainedLinks(view);
		case InvariantEditPart.VISUAL_ID:
			return getInvariant_3014ContainedLinks(view);
		case Junction2EditPart.VISUAL_ID:
			return getJunction_3015ContainedLinks(view);
		case Any2EditPart.VISUAL_ID:
			return getAny_3016ContainedLinks(view);
		case Fork2EditPart.VISUAL_ID:
			return getFork_3017ContainedLinks(view);
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
			return getInitial_2006IncomingLinks(view);
		case FinalEditPart.VISUAL_ID:
			return getFinal_2007IncomingLinks(view);
		case StateEditPart.VISUAL_ID:
			return getState_2008IncomingLinks(view);
		case JunctionEditPart.VISUAL_ID:
			return getJunction_2009IncomingLinks(view);
		case AnyEditPart.VISUAL_ID:
			return getAny_2010IncomingLinks(view);
		case ForkEditPart.VISUAL_ID:
			return getFork_2011IncomingLinks(view);
		case StatemachineEditPart.VISUAL_ID:
			return getStatemachine_3001IncomingLinks(view);
		case InnerInitialEditPart.VISUAL_ID:
			return getInitial_3011IncomingLinks(view);
		case InnerFinalEditPart.VISUAL_ID:
			return getFinal_3012IncomingLinks(view);
		case InnerStateEditPart.VISUAL_ID:
			return getState_3013IncomingLinks(view);
		case InvariantEditPart.VISUAL_ID:
			return getInvariant_3014IncomingLinks(view);
		case Junction2EditPart.VISUAL_ID:
			return getJunction_3015IncomingLinks(view);
		case Any2EditPart.VISUAL_ID:
			return getAny_3016IncomingLinks(view);
		case Fork2EditPart.VISUAL_ID:
			return getFork_3017IncomingLinks(view);
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
			return getInitial_2006OutgoingLinks(view);
		case FinalEditPart.VISUAL_ID:
			return getFinal_2007OutgoingLinks(view);
		case StateEditPart.VISUAL_ID:
			return getState_2008OutgoingLinks(view);
		case JunctionEditPart.VISUAL_ID:
			return getJunction_2009OutgoingLinks(view);
		case AnyEditPart.VISUAL_ID:
			return getAny_2010OutgoingLinks(view);
		case ForkEditPart.VISUAL_ID:
			return getFork_2011OutgoingLinks(view);
		case StatemachineEditPart.VISUAL_ID:
			return getStatemachine_3001OutgoingLinks(view);
		case InnerInitialEditPart.VISUAL_ID:
			return getInitial_3011OutgoingLinks(view);
		case InnerFinalEditPart.VISUAL_ID:
			return getFinal_3012OutgoingLinks(view);
		case InnerStateEditPart.VISUAL_ID:
			return getState_3013OutgoingLinks(view);
		case InvariantEditPart.VISUAL_ID:
			return getInvariant_3014OutgoingLinks(view);
		case Junction2EditPart.VISUAL_ID:
			return getJunction_3015OutgoingLinks(view);
		case Any2EditPart.VISUAL_ID:
			return getAny_3016OutgoingLinks(view);
		case Fork2EditPart.VISUAL_ID:
			return getFork_3017OutgoingLinks(view);
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
	public static List<StatemachinesLinkDescriptor> getStatemachine_1000ContainedLinks(
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
	public static List<StatemachinesLinkDescriptor> getInitial_2006ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getFinal_2007ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getState_2008ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getJunction_2009ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getAny_2010ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getFork_2011ContainedLinks(
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
	public static List<StatemachinesLinkDescriptor> getInitial_3011ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getFinal_3012ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getState_3013ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getInvariant_3014ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getJunction_3015ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getAny_3016ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getFork_3017ContainedLinks(
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
	public static List<StatemachinesLinkDescriptor> getInitial_2006IncomingLinks(
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
	public static List<StatemachinesLinkDescriptor> getFinal_2007IncomingLinks(
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
	public static List<StatemachinesLinkDescriptor> getState_2008IncomingLinks(
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
	public static List<StatemachinesLinkDescriptor> getJunction_2009IncomingLinks(
			View view) {
		Junction modelElement = (Junction) view.getElement();
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
	public static List<StatemachinesLinkDescriptor> getAny_2010IncomingLinks(
			View view) {
		Any modelElement = (Any) view.getElement();
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
	public static List<StatemachinesLinkDescriptor> getFork_2011IncomingLinks(
			View view) {
		Fork modelElement = (Fork) view.getElement();
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
	public static List<StatemachinesLinkDescriptor> getInitial_3011IncomingLinks(
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
	public static List<StatemachinesLinkDescriptor> getFinal_3012IncomingLinks(
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
	public static List<StatemachinesLinkDescriptor> getState_3013IncomingLinks(
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
	public static List<StatemachinesLinkDescriptor> getInvariant_3014IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getJunction_3015IncomingLinks(
			View view) {
		Junction modelElement = (Junction) view.getElement();
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
	public static List<StatemachinesLinkDescriptor> getAny_3016IncomingLinks(
			View view) {
		Any modelElement = (Any) view.getElement();
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
	public static List<StatemachinesLinkDescriptor> getFork_3017IncomingLinks(
			View view) {
		Fork modelElement = (Fork) view.getElement();
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
	public static List<StatemachinesLinkDescriptor> getInitial_2006OutgoingLinks(
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
	public static List<StatemachinesLinkDescriptor> getFinal_2007OutgoingLinks(
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
	public static List<StatemachinesLinkDescriptor> getState_2008OutgoingLinks(
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
	public static List<StatemachinesLinkDescriptor> getJunction_2009OutgoingLinks(
			View view) {
		Junction modelElement = (Junction) view.getElement();
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getAny_2010OutgoingLinks(
			View view) {
		Any modelElement = (Any) view.getElement();
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getFork_2011OutgoingLinks(
			View view) {
		Fork modelElement = (Fork) view.getElement();
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
	public static List<StatemachinesLinkDescriptor> getInitial_3011OutgoingLinks(
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
	public static List<StatemachinesLinkDescriptor> getFinal_3012OutgoingLinks(
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
	public static List<StatemachinesLinkDescriptor> getState_3013OutgoingLinks(
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
	public static List<StatemachinesLinkDescriptor> getInvariant_3014OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getJunction_3015OutgoingLinks(
			View view) {
		Junction modelElement = (Junction) view.getElement();
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getAny_3016OutgoingLinks(
			View view) {
		Any modelElement = (Any) view.getElement();
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachinesLinkDescriptor> getFork_3017OutgoingLinks(
			View view) {
		Fork modelElement = (Fork) view.getElement();
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4002(modelElement));
		return result;
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
			Statemachine container) {
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
			Statemachine container) {
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
		Statemachine container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Statemachine) {
				container = (Statemachine) element;
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
		Statemachine container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Statemachine) {
				container = (Statemachine) element;
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

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */
		@Override
		public List<StatemachinesNodeDescriptor> getSemanticChildren(View view) {
			return StatemachinesDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<StatemachinesLinkDescriptor> getContainedLinks(View view) {
			return StatemachinesDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<StatemachinesLinkDescriptor> getIncomingLinks(View view) {
			return StatemachinesDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<StatemachinesLinkDescriptor> getOutgoingLinks(View view) {
			return StatemachinesDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
