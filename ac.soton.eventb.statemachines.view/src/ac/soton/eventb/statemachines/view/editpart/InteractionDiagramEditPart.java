/**
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.view.editpart;

import java.util.ArrayList;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import ac.soton.eventb.statemachines.view.layout.InteractionFreeformLayout;
import ac.soton.eventb.statemachines.view.layout.InteractionGraphLayout;
import ac.soton.eventb.statemachines.view.model.InteractionDiagram;
import ac.soton.eventb.statemachines.view.model.InteractionNode;
import ac.soton.eventb.statemachines.view.policy.InteractionViewXYLayoutEditPolicy;

/**
 * @author vitaly
 *
 */
public class InteractionDiagramEditPart extends AbstractGraphicalEditPart {

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		FreeformLayer freeformLayer = new FreeformLayer();
		freeformLayer.setLayoutManager(new InteractionGraphLayout(this));//new InteractionFreeformLayout());
		return freeformLayer;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE,
				new InteractionViewXYLayoutEditPolicy());
	}

	@Override
	protected ArrayList<InteractionNode> getModelChildren() {
		return ((InteractionDiagram) getModel()).getNodes();
	}

	@Override
	protected void registerVisuals() {
		ConnectionLayer connectionLayer = (ConnectionLayer) getLayer(LayerConstants.CONNECTION_LAYER);
		connectionLayer.setConnectionRouter(ConnectionRouter.NULL);
	}
}
