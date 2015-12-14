package ac.soton.eventb.classdiagrams.generator.validator;


import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.action.Action;

import ac.soton.eventb.classdiagrams.diagram.part.ValidateAction;
import ac.soton.eventb.classdiagrams.diagram.providers.ClassdiagramsMarkerNavigationProvider;
import ac.soton.eventb.emf.diagrams.generator.AbstractValidator;
import ac.soton.eventb.emf.diagrams.generator.IValidator;

public class Validator extends AbstractValidator implements IValidator {

	/* (non-Javadoc)
	 * @see ac.soton.eventb.emf.diagrams.generator.AbstractValidator#getMarkerType()
	 */
	@Override
	protected String getMarkerType() {
		return ClassdiagramsMarkerNavigationProvider.MARKER_TYPE;
	}

	/* (non-Javadoc)
	 * @see ac.soton.eventb.emf.diagrams.generator.AbstractValidator#getValidateAction(org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor)
	 */
	@Override
	protected Action getValidateAction(DiagramEditor diagramDocumentEditor) {
		return new ValidateAction(diagramDocumentEditor.getSite().getPage());
	}
	
	
	
}
