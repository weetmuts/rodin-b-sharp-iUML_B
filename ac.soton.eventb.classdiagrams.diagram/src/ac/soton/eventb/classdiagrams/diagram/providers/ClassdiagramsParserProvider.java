/*
 * Copyright (c) 2012 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
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
import ac.soton.eventb.classdiagrams.diagram.edit.parts.AssociationNameEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.AssociationSurjectiveInjectiveEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.AssociationTotalFunctionalEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassAttributeEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassConstraintEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassMethodEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassNameEditPart;
import ac.soton.eventb.classdiagrams.diagram.parsers.MessageFormatParser;
import ac.soton.eventb.classdiagrams.diagram.part.ClassdiagramsVisualIDRegistry;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;

/**
 * @generated
 */
public class ClassdiagramsParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser className_5007Parser;

	/**
	 * @generated
	 */
	private IParser getClassName_5007Parser() {
		if (className_5007Parser == null) {
			EAttribute[] features = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			className_5007Parser = parser;
		}
		return className_5007Parser;
	}

	/**
	 * @generated
	 */
	private IParser classAttribute_3022Parser;

	/**
	 * @generated
	 */
	private IParser getClassAttribute_3022Parser() {
		if (classAttribute_3022Parser == null) {
			EAttribute[] features = new EAttribute[] {
					CorePackage.eINSTANCE.getEventBNamed_Name(),
					ClassdiagramsPackage.eINSTANCE.getClassAttribute_Target() };
			EAttribute[] editableFeatures = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			parser.setViewPattern("{0}: {1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}: {1}"); //$NON-NLS-1$
			parser.setEditPattern("{0}: {1}"); //$NON-NLS-1$
			classAttribute_3022Parser = parser;
		}
		return classAttribute_3022Parser;
	}

	/**
	 * @generated
	 */
	private IParser classMethod_3023Parser;

	/**
	 * @generated
	 */
	private IParser getClassMethod_3023Parser() {
		if (classMethod_3023Parser == null) {
			EAttribute[] features = new EAttribute[] { CoreextensionPackage.eINSTANCE
					.getEventBLabeled_Label() };
			MessageFormatParser parser = new MessageFormatParser(features);
			classMethod_3023Parser = parser;
		}
		return classMethod_3023Parser;
	}

	/**
	 * @generated
	 */
	private IParser classConstraint_3024Parser;

	/**
	 * @generated
	 */
	private IParser getClassConstraint_3024Parser() {
		if (classConstraint_3024Parser == null) {
			EAttribute[] features = new EAttribute[] {
					CorePackage.eINSTANCE.getEventBNamed_Name(),
					CorePackage.eINSTANCE.getEventBPredicate_Predicate() };
			EAttribute[] editableFeatures = new EAttribute[] {
					CorePackage.eINSTANCE.getEventBNamed_Name(),
					CorePackage.eINSTANCE.getEventBPredicate_Predicate() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			parser.setViewPattern("{0}: {1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}: {1}"); //$NON-NLS-1$
			parser.setEditPattern("{0}: {1}"); //$NON-NLS-1$
			classConstraint_3024Parser = parser;
		}
		return classConstraint_3024Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_6004Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6004Parser() {
		if (associationName_6004Parser == null) {
			EAttribute[] features = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			associationName_6004Parser = parser;
		}
		return associationName_6004Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationSurjectiveInjective_6005Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationSurjectiveInjective_6005Parser() {
		if (associationSurjectiveInjective_6005Parser == null) {
			EAttribute[] features = new EAttribute[] {
					CoreextensionPackage.eINSTANCE
							.getEventBRelationKind_Surjective(),
					CoreextensionPackage.eINSTANCE
							.getEventBRelationKind_Injective() };
			EAttribute[] editableFeatures = new EAttribute[] {
					CoreextensionPackage.eINSTANCE
							.getEventBRelationKind_Surjective(),
					CoreextensionPackage.eINSTANCE
							.getEventBRelationKind_Injective() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			parser.setViewPattern("{0}..{1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}..{1}"); //$NON-NLS-1$
			parser.setEditPattern("{0}..{1}"); //$NON-NLS-1$
			associationSurjectiveInjective_6005Parser = parser;
		}
		return associationSurjectiveInjective_6005Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationTotalFunctional_6006Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationTotalFunctional_6006Parser() {
		if (associationTotalFunctional_6006Parser == null) {
			EAttribute[] features = new EAttribute[] {
					CoreextensionPackage.eINSTANCE
							.getEventBRelationKind_Total(),
					CoreextensionPackage.eINSTANCE
							.getEventBRelationKind_Functional() };
			EAttribute[] editableFeatures = new EAttribute[] {
					CoreextensionPackage.eINSTANCE
							.getEventBRelationKind_Total(),
					CoreextensionPackage.eINSTANCE
							.getEventBRelationKind_Functional() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			parser.setViewPattern("{0}..{1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}..{1}"); //$NON-NLS-1$
			parser.setEditPattern("{0}..{1}"); //$NON-NLS-1$
			associationTotalFunctional_6006Parser = parser;
		}
		return associationTotalFunctional_6006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ClassNameEditPart.VISUAL_ID:
			return getClassName_5007Parser();
		case ClassAttributeEditPart.VISUAL_ID:
			return getClassAttribute_3022Parser();
		case ClassMethodEditPart.VISUAL_ID:
			return getClassMethod_3023Parser();
		case ClassConstraintEditPart.VISUAL_ID:
			return getClassConstraint_3024Parser();
		case AssociationNameEditPart.VISUAL_ID:
			return getAssociationName_6004Parser();
		case AssociationSurjectiveInjectiveEditPart.VISUAL_ID:
			return getAssociationSurjectiveInjective_6005Parser();
		case AssociationTotalFunctionalEditPart.VISUAL_ID:
			return getAssociationTotalFunctional_6006Parser();
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
