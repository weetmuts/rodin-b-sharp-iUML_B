/**
 * Copyright (c) 2011 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.view.factory;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import ac.soton.eventb.statemachines.view.editpart.InteractionDiagramEditPart;
import ac.soton.eventb.statemachines.view.editpart.InteractionEdgeEditPart;
import ac.soton.eventb.statemachines.view.editpart.InteractionNodeEditPart;
import ac.soton.eventb.statemachines.view.model.InteractionDiagram;
import ac.soton.eventb.statemachines.view.model.InteractionEdge;
import ac.soton.eventb.statemachines.view.model.InteractionNode;

/**
 * @author vitaly
 *
 */
public class InteractionViewEditPartFactory implements EditPartFactory {

	/* (non-Javadoc)
	 * @see org.eclipse.gef.EditPartFactory#createEditPart(org.eclipse.gef.EditPart, java.lang.Object)
	 */
	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart editPart = null;
		if (model instanceof InteractionDiagram) {
			editPart = new InteractionDiagramEditPart();
		} else if (model instanceof InteractionNode) {
			editPart = new InteractionNodeEditPart();
		} else if (model instanceof InteractionEdge) {
			editPart = new InteractionEdgeEditPart();
		}

		if (editPart != null) {
			editPart.setModel(model);
		}

		return editPart;
	}

}
