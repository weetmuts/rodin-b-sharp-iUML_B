/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.edit.policies.custom;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eventb.emf.core.EventBElement;

import ac.soton.eventb.statemachines.Transition;

/**
 * Edit policy for reorienting transitions when their source/target state container compartment is collapsed/expanded.
 * Reorients transition to statemachine or containing state on compartment collapsing;
 * reorients to topmost container which is collapsed or to original state if all compartments are expanded.
 * 
 * @author vitaly
 *
 */
public class TransitionReorientOnCollapsedCompartmentEditPolicy extends CanonicalListenerEditPolicy {

	public static final String TROCC_ROLE = "TROCC_ROLE";
	private static final int SOURCE = 1;
	private static final int TARGET = 2;

	@Override
	protected void handleNotificationEvent(Notification notification) {
		Object feature = notification.getFeature();
		if (feature.equals(NotationPackage.eINSTANCE.getDrawerStyle_Collapsed())) {
			GraphicalEditPart host = (GraphicalEditPart) getHost();
			View parentView = (View) host.getParent().getModel();
			EventBElement container = (EventBElement) getSemanticHost();
			
			Set<Edge> sourceEdges = new HashSet<Edge>();
			Set<Edge> targetEdges = new HashSet<Edge>();
			getAllRelatedEdgesForView2((View) parentView, sourceEdges, SOURCE);
			getAllRelatedEdgesForView2((View) parentView, targetEdges, TARGET);
			// set source/target of an edge either to container, or topmost containing element whose view is collapsed
			// depending if a host part was collapsed or expanded
			for (Edge edge : sourceEdges) {
				Transition t = (Transition) edge.getElement();
				if (!notification.getNewBooleanValue())
					container = (EventBElement) findTopCollapsedContainer(host, t.getSource());
				t.setSourceContainer(container);
			}
			for (Edge edge : targetEdges) {
				Transition t = (Transition) edge.getElement();
				if (!notification.getNewBooleanValue())
					container = (EventBElement) findTopCollapsedContainer(host, t.getTarget());
				t.setTargetContainer(container);
			}
			// refresh the diagram
			EditPart diagramPart = (EditPart) getHost().getRoot().getChildren().get(0);
			CanonicalEditPolicy policy = (CanonicalEditPolicy) diagramPart.getEditPolicy(EditPolicyRoles.CANONICAL_ROLE);
			if (policy != null)
				policy.refresh();
		}
	}

	/**
	 * Returns child's topmost containing element whose view is collapsed.
	 * If no collapsed container is found, returns the child itself.
	 * 
	 * @param topPart an editpart to look in
	 * @param child a domain element contained within the structure of containers in editpart
	 * @return domain element of topmost collapsed container
	 */
	static public EObject findTopCollapsedContainer(GraphicalEditPart topPart, EObject child) {
		View topView = topPart.getNotationView();
		EditPart childPart = topPart.findEditPart(null, child);
		if (childPart != null) {
			Object result = null;
			for (EObject view = (EObject) childPart.getModel(); view != null && !view.equals(topView); view = view.eContainer()) {
				if (view instanceof BasicCompartment) {
					if (((BasicCompartment) view).isCollapsed())
						result = view;
				}
			}
			if (result != null)
				return ((View) result).getElement();
		}
		return child;
	}

	/**
	 * Modified {@link org.eclipse.gmf.runtime.diagram.core.util.ViewUtil#getAllRelatedEdgesForView(View, Set)}
	 * to support selective edge search (only source or only target edges).
	 * @param view a view to look in
	 * @param allEdges a set of edges found
	 * @param flag source or target edges
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static public void  getAllRelatedEdgesForView2(View view, Set<Edge> allEdges, int flag) {
		if ((flag & SOURCE) != 0) allEdges.addAll(ViewUtil.getSourceConnections(view));
		if ((flag & TARGET) != 0) allEdges.addAll(ViewUtil.getTargetConnections(view));
		for (Iterator itr = view.getChildren().iterator(); itr.hasNext();) {
			Object obj = itr.next();
			if (obj instanceof View) {
				getAllRelatedEdgesForView2((View)obj, allEdges, flag);
			}
		}
	}

}
