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

import ac.soton.eventb.statemachines.Any;
import ac.soton.eventb.statemachines.Final;
import ac.soton.eventb.statemachines.Fork;
import ac.soton.eventb.statemachines.Initial;
import ac.soton.eventb.statemachines.Junction;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.diagram.edit.parts.Any2EditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.AnyEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.FinalEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.Fork2EditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.ForkEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InitialEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerFinalEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerInitialEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateNameEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InvariantEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.Junction2EditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.JunctionEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RootStatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateNameEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionGhostEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionGhostLabelEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.TransitionLabelEditPart;
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
		case RootStatemachineEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://soton.ac.uk/models/eventb/statemachines/2014?Statemachine", StatemachinesElementTypes.Statemachine_1000); //$NON-NLS-1$
		case InitialEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/statemachines/2014?Initial", StatemachinesElementTypes.Initial_2006); //$NON-NLS-1$
		case FinalEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/statemachines/2014?Final", StatemachinesElementTypes.Final_2007); //$NON-NLS-1$
		case StateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/statemachines/2014?State", StatemachinesElementTypes.State_2008); //$NON-NLS-1$
		case JunctionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/statemachines/2014?Junction", StatemachinesElementTypes.Junction_2009); //$NON-NLS-1$
		case AnyEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/statemachines/2014?Any", StatemachinesElementTypes.Any_2010); //$NON-NLS-1$
		case ForkEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/statemachines/2014?Fork", StatemachinesElementTypes.Fork_2011); //$NON-NLS-1$
		case StatemachineEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/eventb/statemachines/2014?Statemachine", StatemachinesElementTypes.Statemachine_3001); //$NON-NLS-1$
		case InnerInitialEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/eventb/statemachines/2014?Initial", StatemachinesElementTypes.Initial_3011); //$NON-NLS-1$
		case InnerFinalEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/eventb/statemachines/2014?Final", StatemachinesElementTypes.Final_3012); //$NON-NLS-1$
		case InnerStateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/eventb/statemachines/2014?State", StatemachinesElementTypes.State_3013); //$NON-NLS-1$
		case InvariantEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://emf.eventb.org/models/core/machine/2014?Invariant", StatemachinesElementTypes.Invariant_3014); //$NON-NLS-1$
		case Junction2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/eventb/statemachines/2014?Junction", StatemachinesElementTypes.Junction_3015); //$NON-NLS-1$
		case Any2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/eventb/statemachines/2014?Any", StatemachinesElementTypes.Any_3016); //$NON-NLS-1$
		case Fork2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/eventb/statemachines/2014?Fork", StatemachinesElementTypes.Fork_3017); //$NON-NLS-1$
		case TransitionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/statemachines/2014?Transition", StatemachinesElementTypes.Transition_4001); //$NON-NLS-1$
		case TransitionGhostEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/statemachines/2014?Transition", StatemachinesElementTypes.Transition_4002); //$NON-NLS-1$
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
		case RootStatemachineEditPart.VISUAL_ID:
			return getStatemachine_1000Text(view);
		case InitialEditPart.VISUAL_ID:
			return getInitial_2006Text(view);
		case FinalEditPart.VISUAL_ID:
			return getFinal_2007Text(view);
		case StateEditPart.VISUAL_ID:
			return getState_2008Text(view);
		case JunctionEditPart.VISUAL_ID:
			return getJunction_2009Text(view);
		case AnyEditPart.VISUAL_ID:
			return getAny_2010Text(view);
		case ForkEditPart.VISUAL_ID:
			return getFork_2011Text(view);
		case StatemachineEditPart.VISUAL_ID:
			return getStatemachine_3001Text(view);
		case InnerInitialEditPart.VISUAL_ID:
			return getInitial_3011Text(view);
		case InnerFinalEditPart.VISUAL_ID:
			return getFinal_3012Text(view);
		case InnerStateEditPart.VISUAL_ID:
			return getState_3013Text(view);
		case InvariantEditPart.VISUAL_ID:
			return getInvariant_3014Text(view);
		case Junction2EditPart.VISUAL_ID:
			return getJunction_3015Text(view);
		case Any2EditPart.VISUAL_ID:
			return getAny_3016Text(view);
		case Fork2EditPart.VISUAL_ID:
			return getFork_3017Text(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001Text(view);
		case TransitionGhostEditPart.VISUAL_ID:
			return getTransition_4002Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getState_3013Text(View view) {
		IParser parser = StatemachinesParserProvider.getParser(
				StatemachinesElementTypes.State_3013,
				view.getElement() != null ? view.getElement() : view,
				StatemachinesVisualIDRegistry
						.getType(InnerStateNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5008); //$NON-NLS-1$
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
						.getType(TransitionGhostLabelEditPart.VISUAL_ID));
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
	private String getStatemachine_3001Text(View view) {
		Statemachine domainModelElement = (Statemachine) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStatemachine_1000Text(View view) {
		Statemachine domainModelElement = (Statemachine) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFinal_2007Text(View view) {
		Final domainModelElement = (Final) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getReference();
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2007); //$NON-NLS-1$
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
						.getType(TransitionLabelEditPart.VISUAL_ID));
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
	private String getInitial_2006Text(View view) {
		Initial domainModelElement = (Initial) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getReference();
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInitial_3011Text(View view) {
		Initial domainModelElement = (Initial) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getReference();
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFinal_3012Text(View view) {
		Final domainModelElement = (Final) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getReference();
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getState_2008Text(View view) {
		IParser parser = StatemachinesParserProvider.getParser(
				StatemachinesElementTypes.State_2008,
				view.getElement() != null ? view.getElement() : view,
				StatemachinesVisualIDRegistry
						.getType(StateNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getJunction_2009Text(View view) {
		Junction domainModelElement = (Junction) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getReference();
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAny_2010Text(View view) {
		Any domainModelElement = (Any) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getReference();
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFork_2011Text(View view) {
		Fork domainModelElement = (Fork) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getReference();
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInvariant_3014Text(View view) {
		IParser parser = StatemachinesParserProvider.getParser(
				StatemachinesElementTypes.Invariant_3014,
				view.getElement() != null ? view.getElement() : view,
				StatemachinesVisualIDRegistry
						.getType(InvariantEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 3014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getJunction_3015Text(View view) {
		Junction domainModelElement = (Junction) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getReference();
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAny_3016Text(View view) {
		Any domainModelElement = (Any) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getReference();
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFork_3017Text(View view) {
		Fork domainModelElement = (Fork) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getReference();
		} else {
			StatemachinesDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3017); //$NON-NLS-1$
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
		return RootStatemachineEditPart.MODEL_ID
				.equals(StatemachinesVisualIDRegistry.getModelID(view));
	}

}
