/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.edit.parts;

import java.util.Collection;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.Color;

import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.Transition;
import ac.soton.eventb.statemachines.diagram.edit.policies.TransitionGhostItemSemanticEditPolicy;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesDiagramEditorPlugin;
import ac.soton.eventb.statemachines.diagram.preferences.SpecificDiagramAppearancePreferencePage;

/**
 * @generated
 */
public class TransitionGhostEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4002;

	/**
	 * @generated
	 */
	protected static final IPreferenceStore prefStore = StatemachinesDiagramEditorPlugin
			.getInstance().getPreferenceStore();

	/**
	 * @generated
	 */
	public TransitionGhostEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new TransitionGhostItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof TransitionGhostLabelEditPart) {
			((TransitionGhostLabelEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureTransitionLabelFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, index);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof TransitionGhostLabelEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */

	protected Connection createConnectionFigure() {
		return new TransitionFigure();
	}

	/**
	 * @generated
	 */
	public TransitionFigure getPrimaryShape() {
		return (TransitionFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class TransitionFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureTransitionLabelFigure;

		/**
		 * @generated
		 */
		public TransitionFigure() {

			createContents();
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureTransitionLabelFigure = new WrappingLabel();

			fFigureTransitionLabelFigure.setText("");

			this.add(fFigureTransitionLabelFigure);

		}

		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			PolylineDecoration df = new PolylineDecoration();
			df.setFill(false);
			return df;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureTransitionLabelFigure() {
			return fFigureTransitionLabelFigure;
		}

	}

	/**
	 * Refresh the colour of the connection from preferences.
	 * 
	 * @generated
	 */
	protected void refreshForegroundColor() {
		org.eclipse.swt.graphics.RGB rgb = null;
		// set foreground line color
		EObject element = resolveSemanticElement();
		if (element != null) {
			EClass eClazz = element.eClass();
			rgb = PreferenceConverter.getColor(prefStore,
					SpecificDiagramAppearancePreferencePage
							.getLineColorPreference(eClazz, false));
		}

		if (rgb != null) {
			setForegroundColor(new Color(null, rgb));
		} else {
			super.refreshForegroundColor();
		}
	}

	/**
	 * Set the line width of the connection.
	 * @param width the new line width
	 * @generated
	 */
	protected void setLineWidth(int width) {
		getPrimaryShape().setLineWidth(width);
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {
		String featureName = event.getFeature() instanceof EStructuralFeature ? ((EStructuralFeature) event
				.getFeature()).getName() : "";
		// update line width and color if state of enabled operations changes
		if ("operations".equals(featureName)) {
			boolean active = event.getNewValue() == null ? false
					: !((Collection<?>) event.getNewValue()).isEmpty();
			setLineWidth(1 + (active ? 2 : 0));
		}

		super.handleNotificationEvent(event);
	}
}
