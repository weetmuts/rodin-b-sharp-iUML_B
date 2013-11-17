/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import ac.soton.eventb.statemachines.diagram.part.StatemachinesVisualIDRegistry;

/**
 * @generated
 */
public class StatemachinesEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (StatemachinesVisualIDRegistry.getVisualID(view)) {

			case RootStatemachineEditPart.VISUAL_ID:
				return new RootStatemachineEditPart(view);

			case InitialEditPart.VISUAL_ID:
				return new InitialEditPart(view);

			case FinalEditPart.VISUAL_ID:
				return new FinalEditPart(view);

			case StateEditPart.VISUAL_ID:
				return new StateEditPart(view);

			case StateNameEditPart.VISUAL_ID:
				return new StateNameEditPart(view);

			case JunctionEditPart.VISUAL_ID:
				return new JunctionEditPart(view);

			case AnyEditPart.VISUAL_ID:
				return new AnyEditPart(view);

			case ForkEditPart.VISUAL_ID:
				return new ForkEditPart(view);

			case StatemachineEditPart.VISUAL_ID:
				return new StatemachineEditPart(view);

			case InnerInitialEditPart.VISUAL_ID:
				return new InnerInitialEditPart(view);

			case InnerFinalEditPart.VISUAL_ID:
				return new InnerFinalEditPart(view);

			case InnerStateEditPart.VISUAL_ID:
				return new InnerStateEditPart(view);

			case InnerStateNameEditPart.VISUAL_ID:
				return new InnerStateNameEditPart(view);

			case InvariantEditPart.VISUAL_ID:
				return new InvariantEditPart(view);

			case Junction2EditPart.VISUAL_ID:
				return new Junction2EditPart(view);

			case Any2EditPart.VISUAL_ID:
				return new Any2EditPart(view);

			case Fork2EditPart.VISUAL_ID:
				return new Fork2EditPart(view);

			case StateStatemachinesCompartmentEditPart.VISUAL_ID:
				return new StateStatemachinesCompartmentEditPart(view);

			case StateInvariantsCompartmentEditPart.VISUAL_ID:
				return new StateInvariantsCompartmentEditPart(view);

			case StatemachineStatesCompartmentEditPart.VISUAL_ID:
				return new StatemachineStatesCompartmentEditPart(view);

			case InnerStateStatemachinesCompartmentEditPart.VISUAL_ID:
				return new InnerStateStatemachinesCompartmentEditPart(view);

			case InnerStateInvariantsCompartmentEditPart.VISUAL_ID:
				return new InnerStateInvariantsCompartmentEditPart(view);

			case TransitionEditPart.VISUAL_ID:
				return new TransitionEditPart(view);

			case TransitionLabelEditPart.VISUAL_ID:
				return new TransitionLabelEditPart(view);

			case TransitionGhostEditPart.VISUAL_ID:
				return new TransitionGhostEditPart(view);

			case TransitionGhostLabelEditPart.VISUAL_ID:
				return new TransitionGhostLabelEditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE
				.getTextCellEditorLocator(source);
	}
}
