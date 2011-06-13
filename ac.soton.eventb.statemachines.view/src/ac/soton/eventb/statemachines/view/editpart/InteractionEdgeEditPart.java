/**
 * Copyright (c) 2011 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.view.editpart;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;

import ac.soton.eventb.statemachines.view.figure.InteractionConnectionFigure;
import ac.soton.eventb.statemachines.view.model.InteractionEdge;
import ac.soton.eventb.statemachines.view.policy.InteractionConnectionEditPolicy;

/**
 * @author vitaly
 *
 */
public class InteractionEdgeEditPart extends AbstractConnectionEditPart {

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.CONNECTION_ROLE,
				new InteractionConnectionEditPolicy());
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE,
				new ConnectionEndpointEditPolicy());
	}

	@Override
	protected IFigure createFigure() {
		return new InteractionConnectionFigure(((InteractionEdge) getModel()).getName());
	}

}
