/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import ac.soton.eventb.statemachines.diagram.edit.commands.AnyCreateCommand;
import ac.soton.eventb.statemachines.diagram.edit.commands.FinalCreateCommand;
import ac.soton.eventb.statemachines.diagram.edit.commands.ForkCreateCommand;
import ac.soton.eventb.statemachines.diagram.edit.commands.InitialCreateCommand;
import ac.soton.eventb.statemachines.diagram.edit.commands.JunctionCreateCommand;
import ac.soton.eventb.statemachines.diagram.edit.commands.StateCreateCommand;
import ac.soton.eventb.statemachines.diagram.providers.StatemachinesElementTypes;

/**
 * @generated
 */
public class RootStatemachineItemSemanticEditPolicy extends
		StatemachinesBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RootStatemachineItemSemanticEditPolicy() {
		super(StatemachinesElementTypes.Statemachine_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (StatemachinesElementTypes.Initial_2006 == req.getElementType()) {
			return getGEFWrapper(new InitialCreateCommand(req));
		}
		if (StatemachinesElementTypes.Final_2007 == req.getElementType()) {
			return getGEFWrapper(new FinalCreateCommand(req));
		}
		if (StatemachinesElementTypes.State_2008 == req.getElementType()) {
			return getGEFWrapper(new StateCreateCommand(req));
		}
		if (StatemachinesElementTypes.Junction_2009 == req.getElementType()) {
			return getGEFWrapper(new JunctionCreateCommand(req));
		}
		if (StatemachinesElementTypes.Any_2010 == req.getElementType()) {
			return getGEFWrapper(new AnyCreateCommand(req));
		}
		if (StatemachinesElementTypes.Fork_2011 == req.getElementType()) {
			return getGEFWrapper(new ForkCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}

	}

}
