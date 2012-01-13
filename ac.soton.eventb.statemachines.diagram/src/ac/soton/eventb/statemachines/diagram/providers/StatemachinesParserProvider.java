/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.providers;

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

import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateNameEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InvariantEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateNameEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionGhostLabelEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionLabelEditPart;
import ac.soton.eventb.statemachines.diagram.parsers.MessageFormatParser;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesVisualIDRegistry;

/**
 * @generated
 */
public class StatemachinesParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser stateName_5009Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_5009Parser() {
		if (stateName_5009Parser == null) {
			EAttribute[] features = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			stateName_5009Parser = parser;
		}
		return stateName_5009Parser;
	}

	/**
	 * @generated
	 */
	private IParser stateName_5008Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_5008Parser() {
		if (stateName_5008Parser == null) {
			EAttribute[] features = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			stateName_5008Parser = parser;
		}
		return stateName_5008Parser;
	}

	/**
	 * @generated
	 */
	private IParser invariant_3014Parser;

	/**
	 * @generated
	 */
	private IParser getInvariant_3014Parser() {
		if (invariant_3014Parser == null) {
			EAttribute[] features = new EAttribute[] {
					CorePackage.eINSTANCE.getEventBPredicate_Predicate(),
					CorePackage.eINSTANCE.getEventBDerived_Theorem() };
			EAttribute[] editableFeatures = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBPredicate_Predicate() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			invariant_3014Parser = parser;
		}
		return invariant_3014Parser;
	}

	/**
	 * @generated
	 */
	private IParser transitionLabel_6001Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionLabel_6001Parser() {
		if (transitionLabel_6001Parser == null) {
			EAttribute[] features = new EAttribute[] { CoreextensionPackage.eINSTANCE
					.getEventBLabeled_Label() };
			MessageFormatParser parser = new MessageFormatParser(features);
			transitionLabel_6001Parser = parser;
		}
		return transitionLabel_6001Parser;
	}

	/**
	 * @generated
	 */
	private IParser transitionLabel_6002Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionLabel_6002Parser() {
		if (transitionLabel_6002Parser == null) {
			EAttribute[] features = new EAttribute[] { CoreextensionPackage.eINSTANCE
					.getEventBLabeled_Label() };
			MessageFormatParser parser = new MessageFormatParser(features);
			transitionLabel_6002Parser = parser;
		}
		return transitionLabel_6002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case StateNameEditPart.VISUAL_ID:
			return getStateName_5009Parser();
		case InnerStateNameEditPart.VISUAL_ID:
			return getStateName_5008Parser();
		case InvariantEditPart.VISUAL_ID:
			return getInvariant_3014Parser();
		case TransitionLabelEditPart.VISUAL_ID:
			return getTransitionLabel_6001Parser();
		case TransitionGhostLabelEditPart.VISUAL_ID:
			return getTransitionLabel_6002Parser();
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
			return getParser(StatemachinesVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(StatemachinesVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (StatemachinesElementTypes.getElement(hint) == null) {
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
