/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import ac.soton.eventb.statemachines.diagram.edit.parts.ANYEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.DiagramRootEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.FinalEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InitialEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerANYEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerFinalEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerInitialEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerRefinedStateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateStatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStatemachineStatesCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StatemachineStatesCompartment2EditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StatemachineStatesCompartmentEditPart;
import ac.soton.eventb.statemachines.diagram.part.Messages;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesDiagramEditorPlugin;

/**
 * @generated
 */
public class StatemachinesModelingAssistantProvider extends
		ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof DiagramRootEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(5);
			types.add(StatemachinesElementTypes.Initial_2001);
			types.add(StatemachinesElementTypes.Final_2002);
			types.add(StatemachinesElementTypes.ANY_2003);
			types.add(StatemachinesElementTypes.State_2004);
			types.add(StatemachinesElementTypes.RefinedState_2005);
			return types;
		}
		if (editPart instanceof StateEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(StatemachinesElementTypes.Statemachine_3001);
			types.add(StatemachinesElementTypes.Invariant_3006);
			return types;
		}
		if (editPart instanceof RefinedStateEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(3);
			types.add(StatemachinesElementTypes.RefinedStatemachine_3007);
			types.add(StatemachinesElementTypes.Statemachine_3009);
			types.add(StatemachinesElementTypes.Invariant_3010);
			return types;
		}
		if (editPart instanceof InnerStateEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(StatemachinesElementTypes.Statemachine_3001);
			types.add(StatemachinesElementTypes.Invariant_3006);
			return types;
		}
		if (editPart instanceof InnerRefinedStateEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(3);
			types.add(StatemachinesElementTypes.RefinedStatemachine_3007);
			types.add(StatemachinesElementTypes.Statemachine_3009);
			types.add(StatemachinesElementTypes.Invariant_3010);
			return types;
		}
		if (editPart instanceof StatemachineStatesCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(4);
			types.add(StatemachinesElementTypes.Initial_3002);
			types.add(StatemachinesElementTypes.Final_3003);
			types.add(StatemachinesElementTypes.ANY_3004);
			types.add(StatemachinesElementTypes.State_3005);
			return types;
		}
		if (editPart instanceof RefinedStatemachineStatesCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(4);
			types.add(StatemachinesElementTypes.Initial_3002);
			types.add(StatemachinesElementTypes.Final_3003);
			types.add(StatemachinesElementTypes.ANY_3004);
			types.add(StatemachinesElementTypes.RefinedState_3008);
			return types;
		}
		if (editPart instanceof StatemachineStatesCompartment2EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(4);
			types.add(StatemachinesElementTypes.Initial_3002);
			types.add(StatemachinesElementTypes.Final_3003);
			types.add(StatemachinesElementTypes.ANY_3004);
			types.add(StatemachinesElementTypes.State_3005);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof InitialEditPart) {
			return ((InitialEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof FinalEditPart) {
			return ((FinalEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ANYEditPart) {
			return ((ANYEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof StateEditPart) {
			return ((StateEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof RefinedStateEditPart) {
			return ((RefinedStateEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof StatemachineEditPart) {
			return ((StatemachineEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof InnerInitialEditPart) {
			return ((InnerInitialEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof InnerFinalEditPart) {
			return ((InnerFinalEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof InnerANYEditPart) {
			return ((InnerANYEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof InnerStateEditPart) {
			return ((InnerStateEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof RefinedStatemachineEditPart) {
			return ((RefinedStatemachineEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof InnerRefinedStateEditPart) {
			return ((InnerRefinedStateEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof RefinedStateStatemachineEditPart) {
			return ((RefinedStateStatemachineEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof InitialEditPart) {
			return ((InitialEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof FinalEditPart) {
			return ((FinalEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ANYEditPart) {
			return ((ANYEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof StateEditPart) {
			return ((StateEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof RefinedStateEditPart) {
			return ((RefinedStateEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof StatemachineEditPart) {
			return ((StatemachineEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof InnerInitialEditPart) {
			return ((InnerInitialEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof InnerFinalEditPart) {
			return ((InnerFinalEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof InnerANYEditPart) {
			return ((InnerANYEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof InnerStateEditPart) {
			return ((InnerStateEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof RefinedStatemachineEditPart) {
			return ((RefinedStatemachineEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof InnerRefinedStateEditPart) {
			return ((InnerRefinedStateEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof RefinedStateStatemachineEditPart) {
			return ((RefinedStateStatemachineEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof InitialEditPart) {
			return ((InitialEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof FinalEditPart) {
			return ((FinalEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ANYEditPart) {
			return ((ANYEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof StateEditPart) {
			return ((StateEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof RefinedStateEditPart) {
			return ((RefinedStateEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof StatemachineEditPart) {
			return ((StatemachineEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof InnerInitialEditPart) {
			return ((InnerInitialEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof InnerFinalEditPart) {
			return ((InnerFinalEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof InnerANYEditPart) {
			return ((InnerANYEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof InnerStateEditPart) {
			return ((InnerStateEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof RefinedStatemachineEditPart) {
			return ((RefinedStatemachineEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof InnerRefinedStateEditPart) {
			return ((InnerRefinedStateEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof RefinedStateStatemachineEditPart) {
			return ((RefinedStateStatemachineEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof InitialEditPart) {
			return ((InitialEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof FinalEditPart) {
			return ((FinalEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ANYEditPart) {
			return ((ANYEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof StateEditPart) {
			return ((StateEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof RefinedStateEditPart) {
			return ((RefinedStateEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof StatemachineEditPart) {
			return ((StatemachineEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof InnerInitialEditPart) {
			return ((InnerInitialEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof InnerFinalEditPart) {
			return ((InnerFinalEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof InnerANYEditPart) {
			return ((InnerANYEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof InnerStateEditPart) {
			return ((InnerStateEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof RefinedStatemachineEditPart) {
			return ((RefinedStatemachineEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof InnerRefinedStateEditPart) {
			return ((InnerRefinedStateEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof RefinedStateStatemachineEditPart) {
			return ((RefinedStateStatemachineEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof InitialEditPart) {
			return ((InitialEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof FinalEditPart) {
			return ((FinalEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ANYEditPart) {
			return ((ANYEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof StateEditPart) {
			return ((StateEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof RefinedStateEditPart) {
			return ((RefinedStateEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof StatemachineEditPart) {
			return ((StatemachineEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof InnerInitialEditPart) {
			return ((InnerInitialEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof InnerFinalEditPart) {
			return ((InnerFinalEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof InnerANYEditPart) {
			return ((InnerANYEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof InnerStateEditPart) {
			return ((InnerStateEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof RefinedStatemachineEditPart) {
			return ((RefinedStatemachineEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof InnerRefinedStateEditPart) {
			return ((InnerRefinedStateEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof RefinedStateStatemachineEditPart) {
			return ((RefinedStateStatemachineEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target,
			IElementType relationshipType) {
		return selectExistingElement(target,
				getTypesForSource(target, relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source,
			IElementType relationshipType) {
		return selectExistingElement(source,
				getTypesForTarget(source, relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		HashSet<EObject> elements = new HashSet<EObject>();
		for (Iterator<EObject> it = diagram.getElement().eAllContents(); it
				.hasNext();) {
			EObject element = it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements
				.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(
				element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
				StatemachinesDiagramEditorPlugin.getInstance()
						.getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell, labelProvider);
		dialog.setMessage(Messages.StatemachinesModelingAssistantProviderMessage);
		dialog.setTitle(Messages.StatemachinesModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
