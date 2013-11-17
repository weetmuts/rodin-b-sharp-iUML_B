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
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EcorePackage;
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
import org.eclipse.swt.graphics.Color;

import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.diagram.edit.policies.InitialItemSemanticEditPolicy;
import ac.soton.eventb.statemachines.diagram.providers.StatemachinesElementTypes;

/**
 * @generated
 */
public class InitialEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2006;

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
	public InitialEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new InitialItemSemanticEditPolicy());
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

		primaryShape = new InitialFigure();

		return primaryShape;
	}

	/**
	 * @generated
	 */
	public InitialFigure getPrimaryShape() {
		return (InitialFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(20, 20);
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
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(StatemachinesElementTypes.Transition_4001);
		types.add(StatemachinesElementTypes.Transition_4002);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof ac.soton.eventb.statemachines.diagram.edit.parts.InitialEditPart) {
			types.add(StatemachinesElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof FinalEditPart) {
			types.add(StatemachinesElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof StateEditPart) {
			types.add(StatemachinesElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof JunctionEditPart) {
			types.add(StatemachinesElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof AnyEditPart) {
			types.add(StatemachinesElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof ForkEditPart) {
			types.add(StatemachinesElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof InnerInitialEditPart) {
			types.add(StatemachinesElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof InnerFinalEditPart) {
			types.add(StatemachinesElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof InnerStateEditPart) {
			types.add(StatemachinesElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof Junction2EditPart) {
			types.add(StatemachinesElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof Any2EditPart) {
			types.add(StatemachinesElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof Fork2EditPart) {
			types.add(StatemachinesElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof ac.soton.eventb.statemachines.diagram.edit.parts.InitialEditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		if (targetEditPart instanceof FinalEditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		if (targetEditPart instanceof StateEditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		if (targetEditPart instanceof JunctionEditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		if (targetEditPart instanceof AnyEditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		if (targetEditPart instanceof ForkEditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		if (targetEditPart instanceof StatemachineEditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		if (targetEditPart instanceof InnerInitialEditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		if (targetEditPart instanceof InnerFinalEditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		if (targetEditPart instanceof InnerStateEditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		if (targetEditPart instanceof Junction2EditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		if (targetEditPart instanceof Any2EditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		if (targetEditPart instanceof Fork2EditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == StatemachinesElementTypes.Transition_4001) {
			types.add(StatemachinesElementTypes.Initial_2006);
			types.add(StatemachinesElementTypes.Final_2007);
			types.add(StatemachinesElementTypes.State_2008);
			types.add(StatemachinesElementTypes.Junction_2009);
			types.add(StatemachinesElementTypes.Any_2010);
			types.add(StatemachinesElementTypes.Fork_2011);
			types.add(StatemachinesElementTypes.Initial_3011);
			types.add(StatemachinesElementTypes.Final_3012);
			types.add(StatemachinesElementTypes.State_3013);
			types.add(StatemachinesElementTypes.Junction_3015);
			types.add(StatemachinesElementTypes.Any_3016);
			types.add(StatemachinesElementTypes.Fork_3017);
		} else if (relationshipType == StatemachinesElementTypes.Transition_4002) {
			types.add(StatemachinesElementTypes.Initial_2006);
			types.add(StatemachinesElementTypes.Final_2007);
			types.add(StatemachinesElementTypes.State_2008);
			types.add(StatemachinesElementTypes.Junction_2009);
			types.add(StatemachinesElementTypes.Any_2010);
			types.add(StatemachinesElementTypes.Fork_2011);
			types.add(StatemachinesElementTypes.Statemachine_3001);
			types.add(StatemachinesElementTypes.Initial_3011);
			types.add(StatemachinesElementTypes.Final_3012);
			types.add(StatemachinesElementTypes.State_3013);
			types.add(StatemachinesElementTypes.Junction_3015);
			types.add(StatemachinesElementTypes.Any_3016);
			types.add(StatemachinesElementTypes.Fork_3017);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(StatemachinesElementTypes.Transition_4001);
		types.add(StatemachinesElementTypes.Transition_4002);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == StatemachinesElementTypes.Transition_4001) {
			types.add(StatemachinesElementTypes.Initial_2006);
			types.add(StatemachinesElementTypes.Final_2007);
			types.add(StatemachinesElementTypes.State_2008);
			types.add(StatemachinesElementTypes.Junction_2009);
			types.add(StatemachinesElementTypes.Any_2010);
			types.add(StatemachinesElementTypes.Fork_2011);
			types.add(StatemachinesElementTypes.Initial_3011);
			types.add(StatemachinesElementTypes.Final_3012);
			types.add(StatemachinesElementTypes.State_3013);
			types.add(StatemachinesElementTypes.Junction_3015);
			types.add(StatemachinesElementTypes.Any_3016);
			types.add(StatemachinesElementTypes.Fork_3017);
		} else if (relationshipType == StatemachinesElementTypes.Transition_4002) {
			types.add(StatemachinesElementTypes.Initial_2006);
			types.add(StatemachinesElementTypes.Final_2007);
			types.add(StatemachinesElementTypes.State_2008);
			types.add(StatemachinesElementTypes.Junction_2009);
			types.add(StatemachinesElementTypes.Any_2010);
			types.add(StatemachinesElementTypes.Fork_2011);
			types.add(StatemachinesElementTypes.Statemachine_3001);
			types.add(StatemachinesElementTypes.Initial_3011);
			types.add(StatemachinesElementTypes.Final_3012);
			types.add(StatemachinesElementTypes.State_3013);
			types.add(StatemachinesElementTypes.Junction_3015);
			types.add(StatemachinesElementTypes.Any_3016);
			types.add(StatemachinesElementTypes.Fork_3017);
		}
		return types;
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {

		// update line width and color if state changes
		if (StatemachinesPackage.eINSTANCE.getState_Active().equals(
				event.getFeature())) {
			boolean active = event.getNewBooleanValue();
			setLineWidth(1 + (active ? 2 : 0));
			setForegroundColor(active ? ColorConstants.black
					: ColorConstants.gray);
		}

		if (event.getNotifier() == getModel()
				&& EcorePackage.eINSTANCE.getEModelElement_EAnnotations()
						.equals(event.getFeature())) {
			handleMajorSemanticChange();
		} else {
			super.handleNotificationEvent(event);
		}
	}

	/**
	 * @generated
	 */
	public class InitialFigure extends Ellipse {

		/**
		 * @generated
		 */
		public InitialFigure() {
			this.setOutline(false);
			this.setBackgroundColor(ColorConstants.black);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(20),
					getMapMode().DPtoLP(20)));
		}

	}

}
