package org.eventb.emf.diagram.project.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eventb.emf.diagram.project.edit.commands.ContextExtendsCreateCommand;
import org.eventb.emf.diagram.project.edit.commands.ContextExtendsReorientCommand;
import org.eventb.emf.diagram.project.edit.commands.MachineSeesCreateCommand;
import org.eventb.emf.diagram.project.edit.commands.MachineSeesReorientCommand;
import org.eventb.emf.diagram.project.edit.parts.ContextExtendsEditPart;
import org.eventb.emf.diagram.project.edit.parts.MachineSeesEditPart;
import org.eventb.emf.diagram.project.providers.EventbcoreElementTypes;

/**
 * @generated
 */
public class ContextItemSemanticEditPolicy extends
		EventbcoreBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ContextItemSemanticEditPolicy() {
		super(EventbcoreElementTypes.Context_2002);
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
		if (EventbcoreElementTypes.ContextExtends_4001 == req.getElementType()) {
			return getGEFWrapper(new ContextExtendsCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (EventbcoreElementTypes.MachineSees_4002 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (EventbcoreElementTypes.ContextExtends_4001 == req.getElementType()) {
			return getGEFWrapper(new ContextExtendsCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (EventbcoreElementTypes.MachineSees_4002 == req.getElementType()) {
			return getGEFWrapper(new MachineSeesCreateCommand(req,
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
		case ContextExtendsEditPart.VISUAL_ID:
			return getGEFWrapper(new ContextExtendsReorientCommand(req));
		case MachineSeesEditPart.VISUAL_ID:
			return getGEFWrapper(new MachineSeesReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
