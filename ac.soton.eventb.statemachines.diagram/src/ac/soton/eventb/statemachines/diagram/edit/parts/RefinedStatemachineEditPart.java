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

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
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
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import ac.soton.eventb.statemachines.diagram.edit.policies.OpenDiagramEditPolicy;
import ac.soton.eventb.statemachines.diagram.edit.policies.RefinedStatemachineItemSemanticEditPolicy;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesVisualIDRegistry;
import ac.soton.eventb.statemachines.diagram.providers.StatemachinesElementTypes;

/**
 * @generated
 */
public class RefinedStatemachineEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3007;

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
	public RefinedStatemachineEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new RefinedStatemachineItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,
				new OpenDiagramEditPolicy());
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
		return primaryShape = new RefinedStatemachineFigure();
	}

	/**
	 * @generated
	 */
	public RefinedStatemachineFigure getPrimaryShape() {
		return (RefinedStatemachineFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof RefinedStatemachineLabelEditPart) {
			((RefinedStatemachineLabelEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureRefinedStatemachineLabelFigure());
			return true;
		}
		if (childEditPart instanceof RefinedStatemachineStatesCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureRefinedStatemachineCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((RefinedStatemachineStatesCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof RefinedStatemachineLabelEditPart) {
			return true;
		}
		if (childEditPart instanceof RefinedStatemachineStatesCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureRefinedStatemachineCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((RefinedStatemachineStatesCompartmentEditPart) childEditPart)
					.getFigure());
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
		super.addChildVisual(childEditPart, -1);
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
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof RefinedStatemachineStatesCompartmentEditPart) {
			return getPrimaryShape()
					.getFigureRefinedStatemachineCompartmentFigure();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(100, 80);
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
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
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
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(StatemachinesVisualIDRegistry
				.getType(RefinedStatemachineLabelEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		types.add(StatemachinesElementTypes.Transition_4002);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof InitialEditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		if (targetEditPart instanceof FinalEditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		if (targetEditPart instanceof ANYEditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		if (targetEditPart instanceof StateEditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		if (targetEditPart instanceof RefinedStateEditPart) {
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
		if (targetEditPart instanceof InnerANYEditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		if (targetEditPart instanceof InnerStateEditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		if (targetEditPart instanceof ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStatemachineEditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		if (targetEditPart instanceof InnerRefinedStateEditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		if (targetEditPart instanceof RefinedStateStatemachineEditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == StatemachinesElementTypes.Transition_4002) {
			types.add(StatemachinesElementTypes.Initial_2001);
			types.add(StatemachinesElementTypes.Final_2002);
			types.add(StatemachinesElementTypes.ANY_2003);
			types.add(StatemachinesElementTypes.State_2004);
			types.add(StatemachinesElementTypes.RefinedState_2005);
			types.add(StatemachinesElementTypes.Statemachine_3001);
			types.add(StatemachinesElementTypes.Initial_3002);
			types.add(StatemachinesElementTypes.Final_3003);
			types.add(StatemachinesElementTypes.ANY_3004);
			types.add(StatemachinesElementTypes.State_3005);
			types.add(StatemachinesElementTypes.RefinedStatemachine_3007);
			types.add(StatemachinesElementTypes.RefinedState_3008);
			types.add(StatemachinesElementTypes.Statemachine_3009);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		types.add(StatemachinesElementTypes.Transition_4002);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == StatemachinesElementTypes.Transition_4002) {
			types.add(StatemachinesElementTypes.Initial_2001);
			types.add(StatemachinesElementTypes.Final_2002);
			types.add(StatemachinesElementTypes.ANY_2003);
			types.add(StatemachinesElementTypes.State_2004);
			types.add(StatemachinesElementTypes.RefinedState_2005);
			types.add(StatemachinesElementTypes.Statemachine_3001);
			types.add(StatemachinesElementTypes.Initial_3002);
			types.add(StatemachinesElementTypes.Final_3003);
			types.add(StatemachinesElementTypes.ANY_3004);
			types.add(StatemachinesElementTypes.State_3005);
			types.add(StatemachinesElementTypes.RefinedStatemachine_3007);
			types.add(StatemachinesElementTypes.RefinedState_3008);
			types.add(StatemachinesElementTypes.Statemachine_3009);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class RefinedStatemachineFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureRefinedStatemachineLabelFigure;
		/**
		 * @generated
		 */
		private RectangleFigure fFigureRefinedStatemachineCompartmentFigure;

		/**
		 * @generated
		 */
		public RefinedStatemachineFigure() {

			BorderLayout layoutThis = new BorderLayout();
			this.setLayoutManager(layoutThis);

			this.setForegroundColor(ColorConstants.gray);
			this.setMaximumSize(new Dimension(getMapMode().DPtoLP(100),
					getMapMode().DPtoLP(80)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureRefinedStatemachineLabelFigure = new WrappingLabel();
			fFigureRefinedStatemachineLabelFigure.setText("<...>");

			fFigureRefinedStatemachineLabelFigure.setBorder(new MarginBorder(
					getMapMode().DPtoLP(0), getMapMode().DPtoLP(5),
					getMapMode().DPtoLP(0), getMapMode().DPtoLP(5)));

			this.add(fFigureRefinedStatemachineLabelFigure, BorderLayout.TOP);

			fFigureRefinedStatemachineCompartmentFigure = new RectangleFigure();
			fFigureRefinedStatemachineCompartmentFigure.setFill(false);
			fFigureRefinedStatemachineCompartmentFigure.setOutline(false);

			this.add(fFigureRefinedStatemachineCompartmentFigure,
					BorderLayout.CENTER);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureRefinedStatemachineLabelFigure() {
			return fFigureRefinedStatemachineLabelFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureRefinedStatemachineCompartmentFigure() {
			return fFigureRefinedStatemachineCompartmentFigure;
		}

	}

}
