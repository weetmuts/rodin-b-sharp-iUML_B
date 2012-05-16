package ac.soton.eventb.classdiagrams.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import ac.soton.eventb.classdiagrams.diagram.edit.commands.ClassAttributeCreateCommand;
import ac.soton.eventb.classdiagrams.diagram.providers.ClassdiagramsElementTypes;

/**
 * @generated
 */
public class ClassAttributesItemSemanticEditPolicy extends
		ClassdiagramsBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ClassAttributesItemSemanticEditPolicy() {
		super(ClassdiagramsElementTypes.Class_2002);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (ClassdiagramsElementTypes.ClassAttribute_3021 == req
				.getElementType()) {
			return getGEFWrapper(new ClassAttributeCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
