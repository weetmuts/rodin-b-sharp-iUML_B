/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.edit.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetViewMutabilityCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.gmf.tooling.runtime.update.UpdaterLinkDescriptor;
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
import ac.soton.eventb.statemachines.diagram.edit.parts.Junction2EditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.JunctionEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RootStatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionGhostEditPart;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesDiagramUpdater;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesLinkDescriptor;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesNodeDescriptor;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesVisualIDRegistry;

/**
 * @generated
 */

public class RootStatemachineCanonicalEditPolicy extends
		CanonicalConnectionEditPolicy {

	/**
	 * @generated
	 */
	protected void refreshOnActivate() {
		// Need to activate editpart children before invoking the canonical refresh for EditParts to add event listeners
		List<?> c = getHost().getChildren();
		for (int i = 0; i < c.size(); i++) {
			((EditPart) c.get(i)).activate();
		}
		super.refreshOnActivate();
	}

	/**
	 * @generated
	 */
	protected EStructuralFeature getFeatureToSynchronize() {
		return StatemachinesPackage.eINSTANCE.getStatemachine_Nodes();
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("rawtypes")
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		LinkedList<EObject> result = new LinkedList<EObject>();
		List<StatemachinesNodeDescriptor> childDescriptors = StatemachinesDiagramUpdater
				.getStatemachine_1000SemanticChildren(viewObject);
		for (StatemachinesNodeDescriptor d : childDescriptors) {
			result.add(d.getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection<EObject> semanticChildren,
			final View view) {
		if (isShortcut(view)) {
			return StatemachinesDiagramUpdater.isShortcutOrphaned(view);
		}
		return isMyDiagramElement(view)
				&& !semanticChildren.contains(view.getElement());
	}

	/**
	 * @generated
	 */
	private boolean isMyDiagramElement(View view) {
		int visualID = StatemachinesVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case InitialEditPart.VISUAL_ID:
		case FinalEditPart.VISUAL_ID:
		case StateEditPart.VISUAL_ID:
		case JunctionEditPart.VISUAL_ID:
		case AnyEditPart.VISUAL_ID:
		case ForkEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected static boolean isShortcut(View view) {
		return view.getEAnnotation("Shortcut") != null; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	protected void refreshSemantic() {
		if (resolveSemanticElement() == null) {
			return;
		}
		LinkedList<IAdaptable> createdViews = new LinkedList<IAdaptable>();
		List<StatemachinesNodeDescriptor> childDescriptors = StatemachinesDiagramUpdater
				.getStatemachine_1000SemanticChildren((View) getHost()
						.getModel());
		LinkedList<View> orphaned = new LinkedList<View>();
		// we care to check only views we recognize as ours and not shortcuts
		LinkedList<View> knownViewChildren = new LinkedList<View>();
		for (View v : getViewChildren()) {
			if (isShortcut(v)) {
				if (StatemachinesDiagramUpdater.isShortcutOrphaned(v)) {
					orphaned.add(v);
				}
				continue;
			}
			if (isMyDiagramElement(v)) {
				knownViewChildren.add(v);
			}
		}
		// alternative to #cleanCanonicalSemanticChildren(getViewChildren(), semanticChildren)
		//
		// iteration happens over list of desired semantic elements, trying to find best matching View, while original CEP
		// iterates views, potentially losing view (size/bounds) information - i.e. if there are few views to reference same EObject, only last one 
		// to answer isOrphaned == true will be used for the domain element representation, see #cleanCanonicalSemanticChildren()
		for (Iterator<StatemachinesNodeDescriptor> descriptorsIterator = childDescriptors
				.iterator(); descriptorsIterator.hasNext();) {
			StatemachinesNodeDescriptor next = descriptorsIterator.next();
			String hint = StatemachinesVisualIDRegistry.getType(next
					.getVisualID());
			LinkedList<View> perfectMatch = new LinkedList<View>(); // both semanticElement and hint match that of NodeDescriptor
			for (View childView : getViewChildren()) {
				EObject semanticElement = childView.getElement();
				if (next.getModelElement().equals(semanticElement)) {
					if (hint.equals(childView.getType())) {
						perfectMatch.add(childView);
						// actually, can stop iteration over view children here, but
						// may want to use not the first view but last one as a 'real' match (the way original CEP does
						// with its trick with viewToSemanticMap inside #cleanCanonicalSemanticChildren
					}
				}
			}
			if (perfectMatch.size() > 0) {
				descriptorsIterator.remove(); // precise match found no need to create anything for the NodeDescriptor
				// use only one view (first or last?), keep rest as orphaned for further consideration
				knownViewChildren.remove(perfectMatch.getFirst());
			}
		}
		// those left in knownViewChildren are subject to removal - they are our diagram elements we didn't find match to,
		// or those we have potential matches to, and thus need to be recreated, preserving size/location information.
		orphaned.addAll(knownViewChildren);
		//
		ArrayList<CreateViewRequest.ViewDescriptor> viewDescriptors = new ArrayList<CreateViewRequest.ViewDescriptor>(
				childDescriptors.size());
		for (StatemachinesNodeDescriptor next : childDescriptors) {
			String hint = StatemachinesVisualIDRegistry.getType(next
					.getVisualID());
			IAdaptable elementAdapter = new CanonicalElementAdapter(
					next.getModelElement(), hint);
			CreateViewRequest.ViewDescriptor descriptor = new CreateViewRequest.ViewDescriptor(
					elementAdapter, Node.class, hint, ViewUtil.APPEND, false,
					host().getDiagramPreferencesHint());
			viewDescriptors.add(descriptor);
		}

		boolean changed = deleteViews(orphaned.iterator());
		//
		CreateViewRequest request = getCreateViewRequest(viewDescriptors);
		Command cmd = getCreateViewCommand(request);
		if (cmd != null && cmd.canExecute()) {
			SetViewMutabilityCommand.makeMutable(
					new EObjectAdapter(host().getNotationView())).execute();
			executeCommand(cmd);
			@SuppressWarnings("unchecked")
			List<IAdaptable> nl = (List<IAdaptable>) request.getNewObject();
			createdViews.addAll(nl);
		}
		if (changed || createdViews.size() > 0) {
			postProcessRefreshSemantic(createdViews);
		}

		Collection<IAdaptable> createdConnectionViews = refreshConnections();

		if (createdViews.size() > 1) {
			// perform a layout of the container
			DeferredLayoutCommand layoutCmd = new DeferredLayoutCommand(host()
					.getEditingDomain(), createdViews, host());
			executeCommand(new ICommandProxy(layoutCmd));
		}

		createdViews.addAll(createdConnectionViews);

		makeViewsImmutable(createdViews);
	}

	/**
	 * @generated
	 */
	private Collection<IAdaptable> refreshConnections() {
		Domain2Notation domain2NotationMap = new Domain2Notation();
		Collection<StatemachinesLinkDescriptor> linkDescriptors = collectAllLinks(
				getDiagram(), domain2NotationMap);
		Collection existingLinks = new LinkedList(getDiagram().getEdges());
		for (Iterator linksIterator = existingLinks.iterator(); linksIterator
				.hasNext();) {
			Edge nextDiagramLink = (Edge) linksIterator.next();
			int diagramLinkVisualID = StatemachinesVisualIDRegistry
					.getVisualID(nextDiagramLink);
			if (diagramLinkVisualID == -1) {
				if (nextDiagramLink.getSource() != null
						&& nextDiagramLink.getTarget() != null) {
					linksIterator.remove();
				}
				continue;
			}
			EObject diagramLinkObject = nextDiagramLink.getElement();
			EObject diagramLinkSrc = nextDiagramLink.getSource().getElement();
			EObject diagramLinkDst = nextDiagramLink.getTarget().getElement();
			for (Iterator<StatemachinesLinkDescriptor> linkDescriptorsIterator = linkDescriptors
					.iterator(); linkDescriptorsIterator.hasNext();) {
				StatemachinesLinkDescriptor nextLinkDescriptor = linkDescriptorsIterator
						.next();
				if (diagramLinkObject == nextLinkDescriptor.getModelElement()
						&& diagramLinkSrc == nextLinkDescriptor.getSource()
						&& diagramLinkDst == nextLinkDescriptor
								.getDestination()
						&& diagramLinkVisualID == nextLinkDescriptor
								.getVisualID()) {
					linksIterator.remove();
					linkDescriptorsIterator.remove();
					break;
				}
			}
		}
		deleteViews(existingLinks.iterator());
		return createConnections(linkDescriptors, domain2NotationMap);
	}

	/**
	 * @generated
	 */
	private Collection<StatemachinesLinkDescriptor> collectAllLinks(View view,
			Domain2Notation domain2NotationMap) {
		if (!RootStatemachineEditPart.MODEL_ID
				.equals(StatemachinesVisualIDRegistry.getModelID(view))) {
			return Collections.emptyList();
		}
		LinkedList<StatemachinesLinkDescriptor> result = new LinkedList<StatemachinesLinkDescriptor>();
		switch (StatemachinesVisualIDRegistry.getVisualID(view)) {
		case RootStatemachineEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(StatemachinesDiagramUpdater
						.getStatemachine_1000ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case InitialEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(StatemachinesDiagramUpdater
						.getInitial_2006ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case FinalEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(StatemachinesDiagramUpdater
						.getFinal_2007ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case StateEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(StatemachinesDiagramUpdater
						.getState_2008ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case JunctionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(StatemachinesDiagramUpdater
						.getJunction_2009ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case AnyEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(StatemachinesDiagramUpdater
						.getAny_2010ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ForkEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(StatemachinesDiagramUpdater
						.getFork_2011ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case StatemachineEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(StatemachinesDiagramUpdater
						.getStatemachine_3001ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case InnerInitialEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(StatemachinesDiagramUpdater
						.getInitial_3011ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case InnerFinalEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(StatemachinesDiagramUpdater
						.getFinal_3012ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case InnerStateEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(StatemachinesDiagramUpdater
						.getState_3013ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case Junction2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(StatemachinesDiagramUpdater
						.getJunction_3015ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case Any2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(StatemachinesDiagramUpdater
						.getAny_3016ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case Fork2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(StatemachinesDiagramUpdater
						.getFork_3017ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case TransitionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(StatemachinesDiagramUpdater
						.getTransition_4001ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case TransitionGhostEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(StatemachinesDiagramUpdater
						.getTransition_4002ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		}
		for (Iterator children = view.getChildren().iterator(); children
				.hasNext();) {
			result.addAll(collectAllLinks((View) children.next(),
					domain2NotationMap));
		}
		for (Iterator edges = view.getSourceEdges().iterator(); edges.hasNext();) {
			result.addAll(collectAllLinks((View) edges.next(),
					domain2NotationMap));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<IAdaptable> createConnections(
			Collection<StatemachinesLinkDescriptor> linkDescriptors,
			Domain2Notation domain2NotationMap) {
		LinkedList<IAdaptable> adapters = new LinkedList<IAdaptable>();
		for (StatemachinesLinkDescriptor nextLinkDescriptor : linkDescriptors) {
			EditPart sourceEditPart = getSourceEditPart(nextLinkDescriptor,
					domain2NotationMap);
			EditPart targetEditPart = getTargetEditPart(nextLinkDescriptor,
					domain2NotationMap);
			if (sourceEditPart == null || targetEditPart == null) {
				continue;
			}
			CreateConnectionViewRequest.ConnectionViewDescriptor descriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(
					nextLinkDescriptor.getSemanticAdapter(),
					StatemachinesVisualIDRegistry.getType(nextLinkDescriptor
							.getVisualID()), ViewUtil.APPEND, false,
					((IGraphicalEditPart) getHost())
							.getDiagramPreferencesHint());
			CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(
					descriptor);
			ccr.setType(RequestConstants.REQ_CONNECTION_START);
			ccr.setSourceEditPart(sourceEditPart);
			sourceEditPart.getCommand(ccr);
			ccr.setTargetEditPart(targetEditPart);
			ccr.setType(RequestConstants.REQ_CONNECTION_END);
			Command cmd = targetEditPart.getCommand(ccr);
			if (cmd != null && cmd.canExecute()) {
				executeCommand(cmd);
				IAdaptable viewAdapter = (IAdaptable) ccr.getNewObject();
				if (viewAdapter != null) {
					adapters.add(viewAdapter);
				}
			}
		}
		return adapters;
	}

	/**
	 * @generated
	 */
	private EditPart getEditPart(EObject domainModelElement,
			Domain2Notation domain2NotationMap) {
		View view = (View) domain2NotationMap.get(domainModelElement);
		if (view != null) {
			return (EditPart) getHost().getViewer().getEditPartRegistry()
					.get(view);
		}
		return null;
	}

	/**
	 * @generated
	 */
	private Diagram getDiagram() {
		return ((View) getHost().getModel()).getDiagram();
	}

	/**
	 * @generated
	 */
	private EditPart getSourceEditPart(UpdaterLinkDescriptor descriptor,
			Domain2Notation domain2NotationMap) {
		return getEditPart(descriptor.getSource(), domain2NotationMap);
	}

	/**
	 * @generated
	 */
	private EditPart getTargetEditPart(UpdaterLinkDescriptor descriptor,
			Domain2Notation domain2NotationMap) {
		return getEditPart(descriptor.getDestination(), domain2NotationMap);
	}

	/**
	 * @generated
	 */
	protected final EditPart getHintedEditPart(EObject domainModelElement,
			Domain2Notation domain2NotationMap, int hintVisualId) {
		View view = (View) domain2NotationMap.getHinted(domainModelElement,
				StatemachinesVisualIDRegistry.getType(hintVisualId));
		if (view != null) {
			return (EditPart) getHost().getViewer().getEditPartRegistry()
					.get(view);
		}
		return null;
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("serial")
	protected static class Domain2Notation extends HashMap<EObject, View> {
		/**
		 * @generated
		 */
		public boolean containsDomainElement(EObject domainElement) {
			return this.containsKey(domainElement);
		}

		/**
		 * @generated
		 */
		public View getHinted(EObject domainEObject, String hint) {
			return this.get(domainEObject);
		}

		/**
		 * @generated
		 */
		public void putView(EObject domainElement, View view) {
			if (!containsKey(view.getElement()) || !isShortcut(view)) {
				this.put(domainElement, view);
			}
		}

	}

	/**
	 * @generated
	 */
	@Override
	protected List<EObject> getSemanticConnectionsList() {
		List<EObject> connections = new LinkedList<EObject>();
		TreeIterator<Object> it = EcoreUtil.getAllContents(getDiagram()
				.getElement(), true);
		while (it.hasNext()) {
			Object child = it.next();
			if (child instanceof Transition)
				connections.add((EObject) child);
		}
		return connections;
	}

	/**
	 * @generated
	 */
	@Override
	protected EObject getSourceElement(EObject relationship) {
		if (relationship instanceof Transition)
			return ((Transition) relationship).getSource();
		return null;
	}

	/**
	 * @generated
	 */
	@Override
	protected EObject getTargetElement(EObject relationship) {
		if (relationship instanceof Transition)
			return ((Transition) relationship).getTarget();
		return null;
	}

	////////////CUSTOM/////

	/**
	 * Return <tt>true</tt> if this editpolicy should try and delete the
	 * supplied view; otherwise <tt>false<tt>. 
	 *  
	 * For transitions, true is returned if the source or target of the view do not represent the semantic source or target resp.
	 * (i.e. if the transition has been moved to a different source or target state)
	 * 
	 * Otherwise the default behavior is returned
	 * 
	 * @CUSTOM
	 */
	protected boolean shouldDeleteView(View view) {
		EObject sel = ViewUtil.resolveSemanticElement(view);
		if (sel instanceof Transition && view instanceof Edge) {
			Transition tr = (Transition) sel;
			Edge ed = (Edge) view;
			if (ed.getSource().getElement() != tr.getSource()
					|| ed.getTarget().getElement() != tr.getTarget()) {
				return true;
			}
		}
		return super.shouldDeleteView(view);
	}

}
