package org.eventb.emf.diagram.project.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eventb.emf.diagram.project.providers.EventbcoreElementTypes;

/**
 * @generated
 */
public class MachineSeesItemSemanticEditPolicy extends
		EventbcoreBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public MachineSeesItemSemanticEditPolicy() {
		super(EventbcoreElementTypes.MachineSees_4002);
	}

	/**
	 * @generated NOT
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

}
