package ac.soton.eventb.classdiagrams.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import ac.soton.eventb.classdiagrams.diagram.providers.ClassdiagramsElementTypes;

/**
 * @generated
 */
public class ClassSupertypesItemSemanticEditPolicy extends
		ClassdiagramsBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ClassSupertypesItemSemanticEditPolicy() {
		super(ClassdiagramsElementTypes.ClassSupertypes_4004);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
