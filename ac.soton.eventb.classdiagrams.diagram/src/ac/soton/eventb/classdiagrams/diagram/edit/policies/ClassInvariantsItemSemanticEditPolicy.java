package ac.soton.eventb.classdiagrams.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import ac.soton.eventb.classdiagrams.diagram.edit.commands.ClassInvariantCreateCommand;
import ac.soton.eventb.classdiagrams.diagram.providers.ClassdiagramsElementTypes;

/**
 * @generated
 */
public class ClassInvariantsItemSemanticEditPolicy extends
		ClassdiagramsBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ClassInvariantsItemSemanticEditPolicy() {
		super(ClassdiagramsElementTypes.Class_2002);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (ClassdiagramsElementTypes.ClassInvariant_3005 == req
				.getElementType()) {
			return getGEFWrapper(new ClassInvariantCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
