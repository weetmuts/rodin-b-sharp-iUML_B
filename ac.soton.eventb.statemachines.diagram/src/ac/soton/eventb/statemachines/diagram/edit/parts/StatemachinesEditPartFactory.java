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

			case DiagramRootEditPart.VISUAL_ID:
				return new DiagramRootEditPart(view);

			case InitialEditPart.VISUAL_ID:
				return new InitialEditPart(view);

			case FinalEditPart.VISUAL_ID:
				return new FinalEditPart(view);

			case ANYEditPart.VISUAL_ID:
				return new ANYEditPart(view);

			case StateEditPart.VISUAL_ID:
				return new StateEditPart(view);

			case StateNameEditPart.VISUAL_ID:
				return new StateNameEditPart(view);

			case RefinedStateEditPart.VISUAL_ID:
				return new RefinedStateEditPart(view);

			case RefinedStateLabelEditPart.VISUAL_ID:
				return new RefinedStateLabelEditPart(view);

			case StatemachineEditPart.VISUAL_ID:
				return new StatemachineEditPart(view);

			case StatemachineNameEditPart.VISUAL_ID:
				return new StatemachineNameEditPart(view);

			case InnerInitialEditPart.VISUAL_ID:
				return new InnerInitialEditPart(view);

			case InnerFinalEditPart.VISUAL_ID:
				return new InnerFinalEditPart(view);

			case InnerANYEditPart.VISUAL_ID:
				return new InnerANYEditPart(view);

			case InnerStateEditPart.VISUAL_ID:
				return new InnerStateEditPart(view);

			case InnerStateNameEditPart.VISUAL_ID:
				return new InnerStateNameEditPart(view);

			case StateInvariantEditPart.VISUAL_ID:
				return new StateInvariantEditPart(view);

			case RefinedStatemachineEditPart.VISUAL_ID:
				return new RefinedStatemachineEditPart(view);

			case RefinedStatemachineLabelEditPart.VISUAL_ID:
				return new RefinedStatemachineLabelEditPart(view);

			case InnerRefinedStateEditPart.VISUAL_ID:
				return new InnerRefinedStateEditPart(view);

			case InnerRefinedStateLabelEditPart.VISUAL_ID:
				return new InnerRefinedStateLabelEditPart(view);

			case RefinedStateStatemachineEditPart.VISUAL_ID:
				return new RefinedStateStatemachineEditPart(view);

			case RefinedStateStatemachineNameEditPart.VISUAL_ID:
				return new RefinedStateStatemachineNameEditPart(view);

			case RefinedStateInvariantEditPart.VISUAL_ID:
				return new RefinedStateInvariantEditPart(view);

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

			case RefinedStateStatemachinesCompartmentEditPart.VISUAL_ID:
				return new RefinedStateStatemachinesCompartmentEditPart(view);

			case RefinedStateInvariantsCompartmentEditPart.VISUAL_ID:
				return new RefinedStateInvariantsCompartmentEditPart(view);

			case RefinedStatemachineStatesCompartmentEditPart.VISUAL_ID:
				return new RefinedStatemachineStatesCompartmentEditPart(view);

			case InnerRefinedStateStatemachinesCompartmentEditPart.VISUAL_ID:
				return new InnerRefinedStateStatemachinesCompartmentEditPart(
						view);

			case InnerRefinedStateInvariantsCompartmentEditPart.VISUAL_ID:
				return new InnerRefinedStateInvariantsCompartmentEditPart(view);

			case StatemachineStatesCompartment2EditPart.VISUAL_ID:
				return new StatemachineStatesCompartment2EditPart(view);

			case TransitionEditPart.VISUAL_ID:
				return new TransitionEditPart(view);

			case TransitionNameEditPart.VISUAL_ID:
				return new TransitionNameEditPart(view);

			case TransitionGhostEditPart.VISUAL_ID:
				return new TransitionGhostEditPart(view);

			case TransitionGhostNameEditPart.VISUAL_ID:
				return new TransitionGhostNameEditPart(view);

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
		if (source.getFigure() instanceof WrappingLabel)
			return new TextCellEditorLocator((WrappingLabel) source.getFigure());
		else {
			return new LabelCellEditorLocator((Label) source.getFigure());
		}
	}

	/**
	 * @generated
	 */
	static private class TextCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private WrappingLabel wrapLabel;

		/**
		 * @generated
		 */
		public TextCellEditorLocator(WrappingLabel wrapLabel) {
			this.wrapLabel = wrapLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getWrapLabel() {
			return wrapLabel;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getWrapLabel().getTextBounds().getCopy();
			getWrapLabel().translateToAbsolute(rect);
			if (!text.getFont().isDisposed()) {
				if (getWrapLabel().isTextWrapOn()
						&& getWrapLabel().getText().length() > 0) {
					rect.setSize(new Dimension(text.computeSize(rect.width,
							SWT.DEFAULT)));
				} else {
					int avr = FigureUtilities.getFontMetrics(text.getFont())
							.getAverageCharWidth();
					rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
							SWT.DEFAULT)).expand(avr * 2, 0));
				}
			}
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}

	/**
	 * @generated
	 */
	private static class LabelCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private Label label;

		/**
		 * @generated
		 */
		public LabelCellEditorLocator(Label label) {
			this.label = label;
		}

		/**
		 * @generated
		 */
		public Label getLabel() {
			return label;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getLabel().getTextBounds().getCopy();
			getLabel().translateToAbsolute(rect);
			if (!text.getFont().isDisposed()) {
				int avr = FigureUtilities.getFontMetrics(text.getFont())
						.getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
						SWT.DEFAULT)).expand(avr * 2, 0));
			}
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
