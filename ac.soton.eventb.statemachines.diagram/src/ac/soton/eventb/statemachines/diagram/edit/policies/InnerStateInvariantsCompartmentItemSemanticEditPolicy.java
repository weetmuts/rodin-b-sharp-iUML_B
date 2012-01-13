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

import ac.soton.eventb.statemachines.diagram.edit.commands.InvariantCreateCommand;
import ac.soton.eventb.statemachines.diagram.providers.StatemachinesElementTypes;

/**
 * @generated
 */
public class InnerStateInvariantsCompartmentItemSemanticEditPolicy extends
		StatemachinesBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public InnerStateInvariantsCompartmentItemSemanticEditPolicy() {
		super(StatemachinesElementTypes.State_3013);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (StatemachinesElementTypes.Invariant_3014 == req.getElementType()) {
			return getGEFWrapper(new InvariantCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
