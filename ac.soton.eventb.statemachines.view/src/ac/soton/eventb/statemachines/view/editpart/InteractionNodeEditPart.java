/**
 * Copyright (c) 2011 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.view.editpart;


import java.util.List;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import ac.soton.eventb.statemachines.AbstractStatemachine;
import ac.soton.eventb.statemachines.RefinedStatemachine;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.view.figure.InteractionNodeFigure;
import ac.soton.eventb.statemachines.view.model.InteractionEdge;
import ac.soton.eventb.statemachines.view.model.InteractionNode;

/**
 * Interaction view node edit part.
 * 
 * @author vitaly
 *
 */
public class InteractionNodeEditPart extends AbstractGraphicalEditPart implements NodeEditPart {

	private ChopboxAnchor sourceAnchor;
	private ChopboxAnchor targetAnchor;

	@Override
	public boolean isSelectable() {
		return false;
	}

	@Override
	protected IFigure createFigure() {
		InteractionNode model = (InteractionNode) getModel();
		AbstractStatemachine element = model.getElement();
		String name = element instanceof Statemachine ? ((Statemachine) element).getName() : element instanceof RefinedStatemachine ? ((RefinedStatemachine) element).getLabel() : "unknown";
		InteractionNodeFigure nodeFigure = new InteractionNodeFigure(name);
		sourceAnchor = new ChopboxAnchor(nodeFigure);
		targetAnchor = new ChopboxAnchor(nodeFigure);
		return nodeFigure;
	}

	@Override
	protected void createEditPolicies() {
		/* not implemented */
	}

	@Override
	protected void registerVisuals() {
		InteractionNodeFigure nodeFigure = (InteractionNodeFigure) getFigure();
		Point location = nodeFigure.getRectangleFigure().getLocation();
		Dimension size = nodeFigure.getRectangleFigure().getSize();
		InteractionDiagramEditPart diagram = (InteractionDiagramEditPart) getParent();
		Rectangle constraint = new Rectangle(location, size);
		diagram.setLayoutConstraint(this, nodeFigure, constraint);
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(
			ConnectionEditPart connection) {
		return sourceAnchor;
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return sourceAnchor;
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(
			ConnectionEditPart connection) {
		return targetAnchor;
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return targetAnchor;
	}

	@Override
	protected List<InteractionEdge> getModelSourceConnections() {
		return ((InteractionNode) getModel()).getSourceEdges();
	}

	@Override
	protected List<InteractionEdge> getModelTargetConnections() {
		return ((InteractionNode) getModel()).getTargetEdges();
	}
}
