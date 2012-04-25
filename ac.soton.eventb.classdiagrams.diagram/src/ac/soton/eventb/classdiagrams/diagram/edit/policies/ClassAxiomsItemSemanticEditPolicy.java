package ac.soton.eventb.classdiagrams.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import ac.soton.eventb.classdiagrams.diagram.edit.commands.ClassAxiomCreateCommand;
import ac.soton.eventb.classdiagrams.diagram.providers.ClassdiagramsElementTypes;

/**
 * @generated
 */
public class ClassAxiomsItemSemanticEditPolicy extends
		ClassdiagramsBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ClassAxiomsItemSemanticEditPolicy() {
		super(ClassdiagramsElementTypes.Class_2002);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (ClassdiagramsElementTypes.ClassAxiom_3006 == req.getElementType()) {
			return getGEFWrapper(new ClassAxiomCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
