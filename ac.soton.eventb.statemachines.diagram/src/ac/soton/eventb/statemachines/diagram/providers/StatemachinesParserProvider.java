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

import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerRefinedStateLabelEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateNameEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateInvariantEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateLabelEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateStatemachineNameEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStatemachineLabelEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateInvariantEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateNameEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateStatemachineNameEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionGhostNameEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionNameEditPart;
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
	private IParser stateName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_5003Parser() {
		if (stateName_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			stateName_5003Parser = parser;
		}
		return stateName_5003Parser;
	}

	/**
	 * @generated
	 */
	private IParser refinedStateLabel_5007Parser;

	/**
	 * @generated
	 */
	private IParser getRefinedStateLabel_5007Parser() {
		if (refinedStateLabel_5007Parser == null) {
			EAttribute[] features = new EAttribute[] { StatemachinesPackage.eINSTANCE
					.getEventBLabeled_Label() };
			MessageFormatParser parser = new MessageFormatParser(features);
			refinedStateLabel_5007Parser = parser;
		}
		return refinedStateLabel_5007Parser;
	}

	/**
	 * @generated
	 */
	private IParser statemachineName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getStatemachineName_5002Parser() {
		if (statemachineName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			statemachineName_5002Parser = parser;
		}
		return statemachineName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser stateName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_5001Parser() {
		if (stateName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			stateName_5001Parser = parser;
		}
		return stateName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser invariant_3006Parser;

	/**
	 * @generated
	 */
	private IParser getInvariant_3006Parser() {
		if (invariant_3006Parser == null) {
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
			invariant_3006Parser = parser;
		}
		return invariant_3006Parser;
	}

	/**
	 * @generated
	 */
	private IParser refinedStatemachineLabel_5006Parser;

	/**
	 * @generated
	 */
	private IParser getRefinedStatemachineLabel_5006Parser() {
		if (refinedStatemachineLabel_5006Parser == null) {
			EAttribute[] features = new EAttribute[] { StatemachinesPackage.eINSTANCE
					.getEventBLabeled_Label() };
			MessageFormatParser parser = new MessageFormatParser(features);
			refinedStatemachineLabel_5006Parser = parser;
		}
		return refinedStatemachineLabel_5006Parser;
	}

	/**
	 * @generated
	 */
	private IParser refinedStateLabel_5005Parser;

	/**
	 * @generated
	 */
	private IParser getRefinedStateLabel_5005Parser() {
		if (refinedStateLabel_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { StatemachinesPackage.eINSTANCE
					.getEventBLabeled_Label() };
			MessageFormatParser parser = new MessageFormatParser(features);
			refinedStateLabel_5005Parser = parser;
		}
		return refinedStateLabel_5005Parser;
	}

	/**
	 * @generated
	 */
	private IParser statemachineName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getStatemachineName_5004Parser() {
		if (statemachineName_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			statemachineName_5004Parser = parser;
		}
		return statemachineName_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser invariant_3010Parser;

	/**
	 * @generated
	 */
	private IParser getInvariant_3010Parser() {
		if (invariant_3010Parser == null) {
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
			invariant_3010Parser = parser;
		}
		return invariant_3010Parser;
	}

	/**
	 * @generated
	 */
	private IParser transitionName_6001Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionName_6001Parser() {
		if (transitionName_6001Parser == null) {
			EAttribute[] features = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			transitionName_6001Parser = parser;
		}
		return transitionName_6001Parser;
	}

	/**
	 * @generated
	 */
	private IParser transitionName_6002Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionName_6002Parser() {
		if (transitionName_6002Parser == null) {
			EAttribute[] features = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CorePackage.eINSTANCE
					.getEventBNamed_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			transitionName_6002Parser = parser;
		}
		return transitionName_6002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case StateNameEditPart.VISUAL_ID:
			return getStateName_5003Parser();
		case RefinedStateLabelEditPart.VISUAL_ID:
			return getRefinedStateLabel_5007Parser();
		case StateStatemachineNameEditPart.VISUAL_ID:
			return getStatemachineName_5002Parser();
		case InnerStateNameEditPart.VISUAL_ID:
			return getStateName_5001Parser();
		case StateInvariantEditPart.VISUAL_ID:
			return getInvariant_3006Parser();
		case RefinedStatemachineLabelEditPart.VISUAL_ID:
			return getRefinedStatemachineLabel_5006Parser();
		case InnerRefinedStateLabelEditPart.VISUAL_ID:
			return getRefinedStateLabel_5005Parser();
		case RefinedStateStatemachineNameEditPart.VISUAL_ID:
			return getStatemachineName_5004Parser();
		case RefinedStateInvariantEditPart.VISUAL_ID:
			return getInvariant_3010Parser();
		case TransitionNameEditPart.VISUAL_ID:
			return getTransitionName_6001Parser();
		case TransitionGhostNameEditPart.VISUAL_ID:
			return getTransitionName_6002Parser();
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
