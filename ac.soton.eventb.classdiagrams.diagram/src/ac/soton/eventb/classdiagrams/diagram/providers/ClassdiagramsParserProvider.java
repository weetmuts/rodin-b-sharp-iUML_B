package ac.soton.eventb.classdiagrams.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eventb.emf.core.CorePackage;

import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.AssociationFunctionalTotalEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.AssociationNameEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.AssociationSurjectiveInjectiveEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassAttributeNameEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassNameEditPart;
import ac.soton.eventb.classdiagrams.diagram.parsers.MessageFormatParser;
import ac.soton.eventb.classdiagrams.diagram.part.ClassdiagramsVisualIDRegistry;

/**
 * @generated
 */
public class ClassdiagramsParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser className_5006Parser;

	/**
	 * @generated
	 */
	private IParser getClassName_5006Parser() {
		if (className_5006Parser == null) {
			EAttribute[] features = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			className_5006Parser = parser;
		}
		return className_5006Parser;
	}

	/**
	 * @generated
	 */
	private IParser classAttributeName_5022Parser;

	/**
	 * @generated
	 */
	private IParser getClassAttributeName_5022Parser() {
		if (classAttributeName_5022Parser == null) {
			EAttribute[] features = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			classAttributeName_5022Parser = parser;
		}
		return classAttributeName_5022Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_6001Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6001Parser() {
		if (associationName_6001Parser == null) {
			EAttribute[] features = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			associationName_6001Parser = parser;
		}
		return associationName_6001Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationSurjectiveInjective_6002Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationSurjectiveInjective_6002Parser() {
		if (associationSurjectiveInjective_6002Parser == null) {
			EAttribute[] features = new EAttribute[] {
					ClassdiagramsPackage.eINSTANCE.getAssociation_Surjective(),
					ClassdiagramsPackage.eINSTANCE.getAssociation_Injective() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}..{1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}..{1}"); //$NON-NLS-1$
			parser.setEditPattern("{0}..{1}"); //$NON-NLS-1$
			associationSurjectiveInjective_6002Parser = parser;
		}
		return associationSurjectiveInjective_6002Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationFunctionalTotal_6003Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationFunctionalTotal_6003Parser() {
		if (associationFunctionalTotal_6003Parser == null) {
			EAttribute[] features = new EAttribute[] {
					ClassdiagramsPackage.eINSTANCE.getAssociation_Functional(),
					ClassdiagramsPackage.eINSTANCE.getAssociation_Total() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}..{1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}..{1}"); //$NON-NLS-1$
			parser.setEditPattern("{0}..{1}"); //$NON-NLS-1$
			associationFunctionalTotal_6003Parser = parser;
		}
		return associationFunctionalTotal_6003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ClassNameEditPart.VISUAL_ID:
			return getClassName_5006Parser();
		case ClassAttributeNameEditPart.VISUAL_ID:
			return getClassAttributeName_5022Parser();
		case AssociationNameEditPart.VISUAL_ID:
			return getAssociationName_6001Parser();
		case AssociationSurjectiveInjectiveEditPart.VISUAL_ID:
			return getAssociationSurjectiveInjective_6002Parser();
		case AssociationFunctionalTotalEditPart.VISUAL_ID:
			return getAssociationFunctionalTotal_6003Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object,
			String parserHint) {
		return ParserService.getInstance().getParser(
				new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(ClassdiagramsVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(ClassdiagramsVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (ClassdiagramsElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
