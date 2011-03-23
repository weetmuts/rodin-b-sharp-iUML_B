/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import ac.soton.eventb.statemachines.DiagramRoot;
import ac.soton.eventb.statemachines.Final;
import ac.soton.eventb.statemachines.Initial;
import ac.soton.eventb.statemachines.diagram.edit.parts.ANYEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.DiagramRootEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.FinalEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InitialEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerANYEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerFinalEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerInitialEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerRefinedStateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerRefinedStateLabelEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateNameEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateInvariantEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateLabelEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateStatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateStatemachineNameEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStatemachineLabelEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateInvariantEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateNameEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StatemachineNameEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionGhostEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionGhostNameEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionNameEditPart;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesDiagramEditorPlugin;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesVisualIDRegistry;
import ac.soton.eventb.statemachines.diagram.providers.StatemachinesElementTypes;
import ac.soton.eventb.statemachines.diagram.providers.StatemachinesParserProvider;

/**
 * @generated
 */
public class StatemachinesNavigatorLabelProvider extends LabelProvider
		implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		StatemachinesDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		StatemachinesDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof StatemachinesNavigatorItem
				&& !isOwnView(((StatemachinesNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof StatemachinesNavigatorGroup) {
			StatemachinesNavigatorGroup group = (StatemachinesNavigatorGroup) element;
			return StatemachinesDiagramEditorPlugin.getInstance()
					.getBundledImage(group.getIcon());
		}

		if (element instanceof StatemachinesNavigatorItem) {
			StatemachinesNavigatorItem navigatorItem = (StatemachinesNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getImage(view);
			}
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (StatemachinesVisualIDRegistry.getVisualID(view)) {
		case TransitionGhostEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/statemachines?Transition", StatemachinesElementTypes.Transition_4002); //$NON-NLS-1$
		case InnerFinalEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/eventb/statemachines?Final", StatemachinesElementTypes.Final_3003); //$NON-NLS-1$
		case RefinedStateStatemachineEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/eventb/statemachines?Statemachine", StatemachinesElementTypes.Statemachine_3009); //$NON-NLS-1$
		case FinalEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/statemachines?Final", StatemachinesElementTypes.Final_2002); //$NON-NLS-1$
		case RefinedStateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/statemachines?RefinedState", StatemachinesElementTypes.RefinedState_2005); //$NON-NLS-1$
		case ANYEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/statemachines?ANY", StatemachinesElementTypes.ANY_2003); //$NON-NLS-1$
		case InnerRefinedStateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/eventb/statemachines?RefinedState", StatemachinesElementTypes.RefinedState_3008); //$NON-NLS-1$
		case TransitionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/statemachines?Transition", StatemachinesElementTypes.Transition_4001); //$NON-NLS-1$
		case StateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/statemachines?State", StatemachinesElementTypes.State_2004); //$NON-NLS-1$
		case InnerANYEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/eventb/statemachines?ANY", StatemachinesElementTypes.ANY_3004); //$NON-NLS-1$
		case StateInvariantEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://emf.eventb.org/models/core/machine?Invariant", StatemachinesElementTypes.Invariant_3006); //$NON-NLS-1$
		case RefinedStatemachineEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/eventb/statemachines?RefinedStatemachine", StatemachinesElementTypes.RefinedStatemachine_3007); //$NON-NLS-1$
		case RefinedStateInvariantEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://emf.eventb.org/models/core/machine?Invariant", StatemachinesElementTypes.Invariant_3010); //$NON-NLS-1$
		case StatemachineEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/eventb/statemachines?Statemachine", StatemachinesElementTypes.Statemachine_3001); //$NON-NLS-1$
		case InnerStateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/eventb/statemachines?State", StatemachinesElementTypes.State_3005); //$NON-NLS-1$
		case DiagramRootEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://soton.ac.uk/models/eventb/statemachines?DiagramRoot", StatemachinesElementTypes.DiagramRoot_1000); //$NON-NLS-1$
		case InnerInitialEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/eventb/statemachines?Initial", StatemachinesElementTypes.Initial_3002); //$NON-NLS-1$
		case InitialEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/statemachines?Initial", StatemachinesElementTypes.Initial_2001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = StatemachinesDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& StatemachinesElementTypes.isKnownElementType(elementType)) {
			image = StatemachinesElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof StatemachinesNavigatorGroup) {
			StatemachinesNavigatorGroup group = (StatemachinesNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof StatemachinesNavigatorItem) {
			StatemachinesNavigatorItem navigatorItem = (StatemachinesNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getText(view);
			}
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (StatemachinesVisualIDRegistry.getVisualID(view)) {
		case TransitionGhostEditPart.VISUAL_ID:
			return getTransition_4002Text(view);
		case InnerFinalEditPart.VISUAL_ID:
			return getFinal_3003Text(view);
		case RefinedStateStatemachineEditPart.VISUAL_ID:
			return getStatemachine_3009Text(view);
		case FinalEditPart.VISUAL_ID:
			return getFinal_2002Text(view);
		case RefinedStateEditPart.VISUAL_ID:
			return getRefinedState_2005Text(view);
		case ANYEditPart.VISUAL_ID:
			return getANY_2003Text(view);
		case InnerRefinedStateEditPart.VISUAL_ID:
			return getRefinedState_3008Text(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001Text(view);
		case StateEditPart.VISUAL_ID:
			return getState_2004Text(view);
		case InnerANYEditPart.VISUAL_ID:
			return getANY_3004Text(view);
		case StateInvariantEditPart.VISUAL_ID:
			return getInvariant_3006Text(view);
		case RefinedStatemachineEditPart.VISUAL_ID:
			return getRefinedStatemachine_3007Text(view);
		case RefinedStateInvariantEditPart.VISUAL_ID:
			return getInvariant_3010Text(view);
		case StatemachineEditPart.VISUAL_ID:
			return getStatemachine_3001Text(view);
		case InnerStateEditPart.VISUAL_ID:
			return getState_3005Text(view);
		case DiagramRootEditPart.VISUAL_ID:
			return getDiagramRoot_1000Text(view);
		case InnerInitialEditPart.VISUAL_ID:
			return getInitial_3002Text(view);
		case InitialEditPart.VISUAL_ID:
			return getInitial_2001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getANY_3004Text(View view) {
		ac.soton.eventb.statemachines.ANY domainModelElement = (ac.soton.eventb.statemachines.ANY) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getReference();
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTransition_4001Text(View view) {
		IParser parser = StatemachinesParserProvider.getParser(
				StatemachinesElementTypes.Transition_4001,
				view.getElement() != null ? view.getElement() : view,
				StatemachinesVisualIDRegistry
						.getType(TransitionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFinal_2002Text(View view) {
		Final domainModelElement = (Final) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getReference();
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInvariant_3010Text(View view) {
		IParser parser = StatemachinesParserProvider.getParser(
				StatemachinesElementTypes.Invariant_3010,
				view.getElement() != null ? view.getElement() : view,
				StatemachinesVisualIDRegistry
						.getType(RefinedStateInvariantEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 3010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStatemachine_3001Text(View view) {
		IParser parser = StatemachinesParserProvider.getParser(
				StatemachinesElementTypes.Statemachine_3001,
				view.getElement() != null ? view.getElement() : view,
				StatemachinesVisualIDRegistry
						.getType(StatemachineNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDiagramRoot_1000Text(View view) {
		DiagramRoot domainModelElement = (DiagramRoot) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getReference();
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getState_2004Text(View view) {
		IParser parser = StatemachinesParserProvider.getParser(
				StatemachinesElementTypes.State_2004,
				view.getElement() != null ? view.getElement() : view,
				StatemachinesVisualIDRegistry
						.getType(StateNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFinal_3003Text(View view) {
		Final domainModelElement = (Final) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getReference();
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRefinedState_2005Text(View view) {
		IParser parser = StatemachinesParserProvider.getParser(
				StatemachinesElementTypes.RefinedState_2005,
				view.getElement() != null ? view.getElement() : view,
				StatemachinesVisualIDRegistry
						.getType(RefinedStateLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTransition_4002Text(View view) {
		IParser parser = StatemachinesParserProvider.getParser(
				StatemachinesElementTypes.Transition_4002,
				view.getElement() != null ? view.getElement() : view,
				StatemachinesVisualIDRegistry
						.getType(TransitionGhostNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getState_3005Text(View view) {
		IParser parser = StatemachinesParserProvider.getParser(
				StatemachinesElementTypes.State_3005,
				view.getElement() != null ? view.getElement() : view,
				StatemachinesVisualIDRegistry
						.getType(InnerStateNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getANY_2003Text(View view) {
		ac.soton.eventb.statemachines.ANY domainModelElement = (ac.soton.eventb.statemachines.ANY) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getReference();
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRefinedStatemachine_3007Text(View view) {
		IParser parser = StatemachinesParserProvider.getParser(
				StatemachinesElementTypes.RefinedStatemachine_3007, view
						.getElement() != null ? view.getElement() : view,
				StatemachinesVisualIDRegistry
						.getType(RefinedStatemachineLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInitial_2001Text(View view) {
		Initial domainModelElement = (Initial) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getReference();
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInvariant_3006Text(View view) {
		IParser parser = StatemachinesParserProvider.getParser(
				StatemachinesElementTypes.Invariant_3006,
				view.getElement() != null ? view.getElement() : view,
				StatemachinesVisualIDRegistry
						.getType(StateInvariantEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 3006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInitial_3002Text(View view) {
		Initial domainModelElement = (Initial) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getReference();
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRefinedState_3008Text(View view) {
		IParser parser = StatemachinesParserProvider.getParser(
				StatemachinesElementTypes.RefinedState_3008,
				view.getElement() != null ? view.getElement() : view,
				StatemachinesVisualIDRegistry
						.getType(InnerRefinedStateLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStatemachine_3009Text(View view) {
		IParser parser = StatemachinesParserProvider
				.getParser(
						StatemachinesElementTypes.Statemachine_3009,
						view.getElement() != null ? view.getElement() : view,
						StatemachinesVisualIDRegistry
								.getType(RefinedStateStatemachineNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return DiagramRootEditPart.MODEL_ID
				.equals(StatemachinesVisualIDRegistry.getModelID(view));
	}

}
