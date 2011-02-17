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

import ac.soton.eventb.statemachines.diagram.edit.commands.RefinedStateStatemachineCreateCommand;
import ac.soton.eventb.statemachines.diagram.edit.commands.RefinedStatemachineCreateCommand;
import ac.soton.eventb.statemachines.diagram.providers.StatemachinesElementTypes;

/**
 * @generated
 */
public class RefinedStateStatemachinesCompartmentItemSemanticEditPolicy extends
		StatemachinesBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RefinedStateStatemachinesCompartmentItemSemanticEditPolicy() {
		super(StatemachinesElementTypes.RefinedState_2005);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (StatemachinesElementTypes.RefinedStatemachine_3007 == req
				.getElementType()) {
			return getGEFWrapper(new RefinedStatemachineCreateCommand(req));
		}
		if (StatemachinesElementTypes.Statemachine_3009 == req.getElementType()) {
			return getGEFWrapper(new RefinedStateStatemachineCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
