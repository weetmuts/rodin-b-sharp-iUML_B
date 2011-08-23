package org.eventb.emf.diagram.project.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eventb.emf.diagram.project.edit.commands.MachineRefinesCreateCommand;
import org.eventb.emf.diagram.project.edit.commands.MachineRefinesReorientCommand;
import org.eventb.emf.diagram.project.edit.commands.MachineSeesCreateCommand;
import org.eventb.emf.diagram.project.edit.commands.MachineSeesReorientCommand;
import org.eventb.emf.diagram.project.edit.parts.MachineRefinesEditPart;
import org.eventb.emf.diagram.project.edit.parts.MachineSeesEditPart;
import org.eventb.emf.diagram.project.providers.EventbcoreElementTypes;

/**
 * @generated
 */
public class MachineItemSemanticEditPolicy extends
		EventbcoreBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public MachineItemSemanticEditPolicy() {
		super(EventbcoreElementTypes.Machine_2001);
	}

	/**
	 * @generated NOT
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return UnexecutableCommand.INSTANCE;
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
		if (EventbcoreElementTypes.MachineSees_4002 == req.getElementType()) {
			return getGEFWrapper(new MachineSeesCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (EventbcoreElementTypes.MachineRefines_4003 == req.getElementType()) {
			return getGEFWrapper(new MachineRefinesCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (EventbcoreElementTypes.MachineSees_4002 == req.getElementType()) {
			return null;
		}
		if (EventbcoreElementTypes.MachineRefines_4003 == req.getElementType()) {
			return getGEFWrapper(new MachineRefinesCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(
			ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case MachineSeesEditPart.VISUAL_ID:
			return getGEFWrapper(new MachineSeesReorientCommand(req));
		case MachineRefinesEditPart.VISUAL_ID:
			return getGEFWrapper(new MachineRefinesReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
