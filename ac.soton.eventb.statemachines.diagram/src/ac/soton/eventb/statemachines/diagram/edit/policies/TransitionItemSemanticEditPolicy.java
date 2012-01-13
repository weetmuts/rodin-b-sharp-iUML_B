/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import ac.soton.eventb.statemachines.diagram.edit.commands.TransitionGhostCreateCommand;
import ac.soton.eventb.statemachines.diagram.edit.commands.TransitionGhostReorientCommand;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionGhostEditPart;
import ac.soton.eventb.statemachines.diagram.providers.StatemachinesElementTypes;

/**
 * @generated
 */
public class TransitionItemSemanticEditPolicy extends
		StatemachinesBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public TransitionItemSemanticEditPolicy() {
		super(StatemachinesElementTypes.Transition_4001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super
				.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (StatemachinesElementTypes.Transition_4002 == req.getElementType()) {
			return getGEFWrapper(new TransitionGhostCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (StatemachinesElementTypes.Transition_4002 == req.getElementType()) {
			return getGEFWrapper(new TransitionGhostCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(
			ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case TransitionGhostEditPart.VISUAL_ID:
			return getGEFWrapper(new TransitionGhostReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
