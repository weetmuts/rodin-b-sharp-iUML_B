/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import ac.soton.eventb.statemachines.diagram.edit.commands.InnerANYCreateCommand;
import ac.soton.eventb.statemachines.diagram.edit.commands.InnerFinalCreateCommand;
import ac.soton.eventb.statemachines.diagram.edit.commands.InnerInitialCreateCommand;
import ac.soton.eventb.statemachines.diagram.edit.commands.InnerRefinedStateCreateCommand;
import ac.soton.eventb.statemachines.diagram.providers.StatemachinesElementTypes;

/**
 * @generated
 */
public class RefinedStatemachineStatesCompartmentItemSemanticEditPolicy extends
		StatemachinesBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RefinedStatemachineStatesCompartmentItemSemanticEditPolicy() {
		super(StatemachinesElementTypes.RefinedStatemachine_3007);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (StatemachinesElementTypes.Initial_3002 == req.getElementType()) {
			return getGEFWrapper(new InnerInitialCreateCommand(req));
		}
		if (StatemachinesElementTypes.Final_3003 == req.getElementType()) {
			return getGEFWrapper(new InnerFinalCreateCommand(req));
		}
		if (StatemachinesElementTypes.ANY_3004 == req.getElementType()) {
			return getGEFWrapper(new InnerANYCreateCommand(req));
		}
		if (StatemachinesElementTypes.RefinedState_3008 == req.getElementType()) {
			return getGEFWrapper(new InnerRefinedStateCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
