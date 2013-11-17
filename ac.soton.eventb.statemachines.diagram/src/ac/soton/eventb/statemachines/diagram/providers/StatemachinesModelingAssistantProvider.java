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

import ac.soton.eventb.statemachines.diagram.edit.parts.Any2EditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.AnyEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.FinalEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.Fork2EditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.ForkEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InitialEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerFinalEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerInitialEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.Junction2EditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.JunctionEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.RootStatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StateEditPart;
import ac.soton.eventb.statemachines.diagram.edit.parts.StatemachineEditPart;
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
		if (editPart instanceof RootStatemachineEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(6);
			types.add(StatemachinesElementTypes.Initial_2006);
			types.add(StatemachinesElementTypes.Final_2007);
			types.add(StatemachinesElementTypes.State_2008);
			types.add(StatemachinesElementTypes.Junction_2009);
			types.add(StatemachinesElementTypes.Any_2010);
			types.add(StatemachinesElementTypes.Fork_2011);
			return types;
		}
		if (editPart instanceof StateEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(StatemachinesElementTypes.Statemachine_3001);
			types.add(StatemachinesElementTypes.Invariant_3014);
			return types;
		}
		if (editPart instanceof InnerStateEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(StatemachinesElementTypes.Statemachine_3001);
			types.add(StatemachinesElementTypes.Invariant_3014);
			return types;
		}
		if (editPart instanceof StatemachineStatesCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(6);
			types.add(StatemachinesElementTypes.Initial_3011);
			types.add(StatemachinesElementTypes.Final_3012);
			types.add(StatemachinesElementTypes.State_3013);
			types.add(StatemachinesElementTypes.Junction_3015);
			types.add(StatemachinesElementTypes.Any_3016);
			types.add(StatemachinesElementTypes.Fork_3017);
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
		if (sourceEditPart instanceof StateEditPart) {
			return ((StateEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof JunctionEditPart) {
			return ((JunctionEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof AnyEditPart) {
			return ((AnyEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ForkEditPart) {
			return ((ForkEditPart) sourceEditPart).getMARelTypesOnSource();
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
		if (sourceEditPart instanceof InnerStateEditPart) {
			return ((InnerStateEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Junction2EditPart) {
			return ((Junction2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Any2EditPart) {
			return ((Any2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Fork2EditPart) {
			return ((Fork2EditPart) sourceEditPart).getMARelTypesOnSource();
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
		if (targetEditPart instanceof StateEditPart) {
			return ((StateEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof JunctionEditPart) {
			return ((JunctionEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof AnyEditPart) {
			return ((AnyEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ForkEditPart) {
			return ((ForkEditPart) targetEditPart).getMARelTypesOnTarget();
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
		if (targetEditPart instanceof InnerStateEditPart) {
			return ((InnerStateEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Junction2EditPart) {
			return ((Junction2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Any2EditPart) {
			return ((Any2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Fork2EditPart) {
			return ((Fork2EditPart) targetEditPart).getMARelTypesOnTarget();
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
		if (sourceEditPart instanceof StateEditPart) {
			return ((StateEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof JunctionEditPart) {
			return ((JunctionEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof AnyEditPart) {
			return ((AnyEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ForkEditPart) {
			return ((ForkEditPart) sourceEditPart)
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
		if (sourceEditPart instanceof InnerStateEditPart) {
			return ((InnerStateEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Junction2EditPart) {
			return ((Junction2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Any2EditPart) {
			return ((Any2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Fork2EditPart) {
			return ((Fork2EditPart) sourceEditPart)
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
		if (targetEditPart instanceof StateEditPart) {
			return ((StateEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof JunctionEditPart) {
			return ((JunctionEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof AnyEditPart) {
			return ((AnyEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ForkEditPart) {
			return ((ForkEditPart) targetEditPart)
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
		if (targetEditPart instanceof InnerStateEditPart) {
			return ((InnerStateEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Junction2EditPart) {
			return ((Junction2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Any2EditPart) {
			return ((Any2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Fork2EditPart) {
			return ((Fork2EditPart) targetEditPart)
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
		if (sourceEditPart instanceof StateEditPart) {
			return ((StateEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof JunctionEditPart) {
			return ((JunctionEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof AnyEditPart) {
			return ((AnyEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ForkEditPart) {
			return ((ForkEditPart) sourceEditPart)
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
		if (sourceEditPart instanceof InnerStateEditPart) {
			return ((InnerStateEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Junction2EditPart) {
			return ((Junction2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Any2EditPart) {
			return ((Any2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Fork2EditPart) {
			return ((Fork2EditPart) sourceEditPart)
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
