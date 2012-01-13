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

import ac.soton.eventb.statemachines.diagram.edit.commands.InnerFinalCreateCommand;
import ac.soton.eventb.statemachines.diagram.edit.commands.InnerInitialCreateCommand;
import ac.soton.eventb.statemachines.diagram.edit.commands.InnerStateCreateCommand;
import ac.soton.eventb.statemachines.diagram.providers.StatemachinesElementTypes;

/**
 * @generated
 */
public class StatemachineStatesCompartmentItemSemanticEditPolicy extends
		StatemachinesBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public StatemachineStatesCompartmentItemSemanticEditPolicy() {
		super(StatemachinesElementTypes.Statemachine_3001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (StatemachinesElementTypes.Initial_3011 == req.getElementType()) {
			return getGEFWrapper(new InnerInitialCreateCommand(req));
		}
		if (StatemachinesElementTypes.Final_3012 == req.getElementType()) {
			return getGEFWrapper(new InnerFinalCreateCommand(req));
		}
		if (StatemachinesElementTypes.State_3013 == req.getElementType()) {
			return getGEFWrapper(new InnerStateCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
