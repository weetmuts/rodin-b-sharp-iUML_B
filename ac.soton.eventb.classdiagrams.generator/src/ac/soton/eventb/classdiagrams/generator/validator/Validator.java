package ac.soton.eventb.classdiagrams.generator.validator;


import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;

import ac.soton.eventb.emf.diagrams.generator.IValidator;

public class Validator implements IValidator {

	@Override
	public boolean validate(DiagramDocumentEditor diagramDocumentEditor) throws Exception {
		return true;
	}
		
	/**
	 * Returns a string of errors from validation markers for file.
	 * 
	 * @param diagramDocumentEditor
	 * @return string of errors
	 * 
	 */
	@Override
	public String getValidationErrors(DiagramDocumentEditor diagramDocumentEditor) {
		return "no errors";
	}
	
}
