/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ScalablePolygonShape;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.Color;

import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.diagram.edit.policies.Any2ItemSemanticEditPolicy;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesDiagramEditorPlugin;
import ac.soton.eventb.statemachines.diagram.preferences.SpecificDiagramAppearancePreferencePage;
import ac.soton.eventb.statemachines.diagram.providers.StatemachinesElementTypes;

/**
 * @generated
 */
public class Any2EditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3016;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	protected static final IPreferenceStore prefStore = StatemachinesDiagramEditorPlugin
			.getInstance().getPreferenceStore();

	/**
	 * @generated
	 */
	public Any2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new Any2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		primaryShape = new ANYFigure();
		return primaryShape;
	}

	/**
	 * @generated
	 */
	public ANYFigure getPrimaryShape() {
		return (ANYFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(21, 21);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {

		super.handleNotificationEvent(event);
	}

	/**
	 * @generated
	 */
	public class ANYFigure extends Ellipse {

		/**
		 * @generated
		 */
		public ANYFigure() {
			this.setLayoutManager(new StackLayout());
			this.setOutline(false);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			ScalablePolygonShape aNYFigureInner0 = new ScalablePolygonShape();

			aNYFigureInner0.addPoint(new Point(getMapMode().DPtoLP(20),
					getMapMode().DPtoLP(0)));
			aNYFigureInner0.addPoint(new Point(getMapMode().DPtoLP(24),
					getMapMode().DPtoLP(10)));
			aNYFigureInner0.addPoint(new Point(getMapMode().DPtoLP(34),
					getMapMode().DPtoLP(6)));
			aNYFigureInner0.addPoint(new Point(getMapMode().DPtoLP(30),
					getMapMode().DPtoLP(16)));
			aNYFigureInner0.addPoint(new Point(getMapMode().DPtoLP(40),
					getMapMode().DPtoLP(20)));
			aNYFigureInner0.addPoint(new Point(getMapMode().DPtoLP(30),
					getMapMode().DPtoLP(24)));
			aNYFigureInner0.addPoint(new Point(getMapMode().DPtoLP(34),
					getMapMode().DPtoLP(34)));
			aNYFigureInner0.addPoint(new Point(getMapMode().DPtoLP(24),
					getMapMode().DPtoLP(30)));
			aNYFigureInner0.addPoint(new Point(getMapMode().DPtoLP(20),
					getMapMode().DPtoLP(40)));
			aNYFigureInner0.addPoint(new Point(getMapMode().DPtoLP(16),
					getMapMode().DPtoLP(30)));
			aNYFigureInner0.addPoint(new Point(getMapMode().DPtoLP(6),
					getMapMode().DPtoLP(34)));
			aNYFigureInner0.addPoint(new Point(getMapMode().DPtoLP(10),
					getMapMode().DPtoLP(24)));
			aNYFigureInner0.addPoint(new Point(getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(20)));
			aNYFigureInner0.addPoint(new Point(getMapMode().DPtoLP(10),
					getMapMode().DPtoLP(16)));
			aNYFigureInner0.addPoint(new Point(getMapMode().DPtoLP(6),
					getMapMode().DPtoLP(6)));
			aNYFigureInner0.addPoint(new Point(getMapMode().DPtoLP(16),
					getMapMode().DPtoLP(10)));
			aNYFigureInner0.addPoint(new Point(getMapMode().DPtoLP(20),
					getMapMode().DPtoLP(0)));
			aNYFigureInner0.setFill(true);

			this.add(aNYFigureInner0);

		}

		/**
		 * sets the foreground colour of the primary figure and also sets the 
		 * background and foreground colours of the child figure to the foreground colour
		 * (i.e. the child is assumed to be a solid foreground item)
		 * 
		 * @custom
		 */
		public void setForegroundColor(Color fg) {
			for (Object child : getChildren()) {
				if (child instanceof Figure) {
					((Figure) child).setBackgroundColor(fg);
					((Figure) child).setForegroundColor(fg);
				}
			}
			super.setForegroundColor(fg);
		}

	}

	/**
	 * Refresh the colour of the foreground from the preferences.
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
	 * Refresh the colour of the background from the preferences.
	 * 
	 * @generated
	 */
	protected void refreshBackgroundColor() {
		org.eclipse.swt.graphics.RGB rgb = null;
		// set background fill color
		EObject element = resolveSemanticElement();
		if (element != null) {
			EClass eClazz = element.eClass();

			rgb = PreferenceConverter.getColor(prefStore,
					SpecificDiagramAppearancePreferencePage
							.getFillColorPreference(eClazz, false));

		}

		if (rgb != null) {
			setBackgroundColor(new Color(null, rgb));
		} else {
			super.refreshBackgroundColor();
		}
	}

}
