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
import org.eclipse.draw2d.RoundedRectangle;
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
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.diagram.edit.policies.RefinedStateItemSemanticEditPolicy;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesVisualIDRegistry;
import ac.soton.eventb.statemachines.diagram.providers.StatemachinesElementTypes;

/**
 * @generated
 */
public class RefinedStateEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2005;

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
	public RefinedStateEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new RefinedStateItemSemanticEditPolicy());
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
		return primaryShape = new RefinedStateFigure();
	}

	/**
	 * @generated
	 */
	public RefinedStateFigure getPrimaryShape() {
		return (RefinedStateFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof RefinedStateLabelEditPart) {
			((RefinedStateLabelEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureRefinedStateLabelFigure());
			return true;
		}
		if (childEditPart instanceof RefinedStateStatemachinesCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureRefinedStateStatemachinesCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((RefinedStateStatemachinesCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		if (childEditPart instanceof RefinedStateInvariantsCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureRefinedStateInvariantsCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((RefinedStateInvariantsCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof RefinedStateLabelEditPart) {
			return true;
		}
		if (childEditPart instanceof RefinedStateStatemachinesCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureRefinedStateStatemachinesCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((RefinedStateStatemachinesCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		if (childEditPart instanceof RefinedStateInvariantsCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureRefinedStateInvariantsCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((RefinedStateInvariantsCompartmentEditPart) childEditPart)
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
		if (editPart instanceof RefinedStateStatemachinesCompartmentEditPart) {
			return getPrimaryShape()
					.getFigureRefinedStateStatemachinesCompartmentFigure();
		}
		if (editPart instanceof RefinedStateInvariantsCompartmentEditPart) {
			return getPrimaryShape()
					.getFigureRefinedStateInvariantsCompartmentFigure();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
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
				.getType(RefinedStateLabelEditPart.VISUAL_ID));
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
		if (targetEditPart instanceof InitialEditPart) {
			types.add(StatemachinesElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof FinalEditPart) {
			types.add(StatemachinesElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof ANYEditPart) {
			types.add(StatemachinesElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof StateEditPart) {
			types.add(StatemachinesElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateEditPart) {
			types.add(StatemachinesElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof InnerInitialEditPart) {
			types.add(StatemachinesElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof InnerFinalEditPart) {
			types.add(StatemachinesElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof InnerANYEditPart) {
			types.add(StatemachinesElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof InnerStateEditPart) {
			types.add(StatemachinesElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof InnerRefinedStateEditPart) {
			types.add(StatemachinesElementTypes.Transition_4001);
		}
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
		if (targetEditPart instanceof ac.soton.eventb.statemachines.diagram.edit.parts.RefinedStateEditPart) {
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
		if (targetEditPart instanceof RefinedStatemachineEditPart) {
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
		if (relationshipType == StatemachinesElementTypes.Transition_4001) {
			types.add(StatemachinesElementTypes.Initial_2001);
			types.add(StatemachinesElementTypes.Final_2002);
			types.add(StatemachinesElementTypes.ANY_2003);
			types.add(StatemachinesElementTypes.State_2004);
			types.add(StatemachinesElementTypes.RefinedState_2005);
			types.add(StatemachinesElementTypes.Initial_3002);
			types.add(StatemachinesElementTypes.Final_3003);
			types.add(StatemachinesElementTypes.ANY_3004);
			types.add(StatemachinesElementTypes.State_3005);
			types.add(StatemachinesElementTypes.RefinedState_3008);
		} else if (relationshipType == StatemachinesElementTypes.Transition_4002) {
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
			types.add(StatemachinesElementTypes.Initial_2001);
			types.add(StatemachinesElementTypes.Final_2002);
			types.add(StatemachinesElementTypes.ANY_2003);
			types.add(StatemachinesElementTypes.State_2004);
			types.add(StatemachinesElementTypes.RefinedState_2005);
			types.add(StatemachinesElementTypes.Initial_3002);
			types.add(StatemachinesElementTypes.Final_3003);
			types.add(StatemachinesElementTypes.ANY_3004);
			types.add(StatemachinesElementTypes.State_3005);
			types.add(StatemachinesElementTypes.RefinedState_3008);
		} else if (relationshipType == StatemachinesElementTypes.Transition_4002) {
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
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request)
					.getViewAndElementDescriptor()
					.getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter
					.getAdapter(IElementType.class);
			if (type == StatemachinesElementTypes.RefinedStatemachine_3007) {
				return getChildBySemanticHint(StatemachinesVisualIDRegistry
						.getType(RefinedStateStatemachinesCompartmentEditPart.VISUAL_ID));
			}
			if (type == StatemachinesElementTypes.Statemachine_3009) {
				return getChildBySemanticHint(StatemachinesVisualIDRegistry
						.getType(RefinedStateStatemachinesCompartmentEditPart.VISUAL_ID));
			}
			if (type == StatemachinesElementTypes.Invariant_3010) {
				return getChildBySemanticHint(StatemachinesVisualIDRegistry
						.getType(RefinedStateInvariantsCompartmentEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {

		// update line width if state changes
		if (StatemachinesPackage.eINSTANCE.getAbstractState_Active().equals(
				event.getFeature())) {
			boolean value = event.getNewBooleanValue();
			setLineWidth(1 + (value ? 1 : 0));
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
	public class RefinedStateFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureRefinedStateLabelFigure;
		/**
		 * @generated
		 */
		private RectangleFigure fFigureRefinedStateStatemachinesCompartmentFigure;
		/**
		 * @generated
		 */
		private RectangleFigure fFigureRefinedStateInvariantsCompartmentFigure;

		/**
		 * @generated
		 */
		public RefinedStateFigure() {

			BorderLayout layoutThis = new BorderLayout();
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(8),
					getMapMode().DPtoLP(8)));
			this.setForegroundColor(ColorConstants.gray);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureRefinedStateLabelFigure = new WrappingLabel();
			fFigureRefinedStateLabelFigure.setText("<...>");

			fFigureRefinedStateLabelFigure.setBorder(new MarginBorder(
					getMapMode().DPtoLP(0), getMapMode().DPtoLP(5),
					getMapMode().DPtoLP(0), getMapMode().DPtoLP(5)));

			this.add(fFigureRefinedStateLabelFigure, BorderLayout.TOP);

			fFigureRefinedStateStatemachinesCompartmentFigure = new RectangleFigure();
			fFigureRefinedStateStatemachinesCompartmentFigure.setFill(false);
			fFigureRefinedStateStatemachinesCompartmentFigure.setOutline(false);

			this.add(fFigureRefinedStateStatemachinesCompartmentFigure,
					BorderLayout.CENTER);

			fFigureRefinedStateInvariantsCompartmentFigure = new RectangleFigure();
			fFigureRefinedStateInvariantsCompartmentFigure.setFill(false);
			fFigureRefinedStateInvariantsCompartmentFigure.setOutline(false);

			this.add(fFigureRefinedStateInvariantsCompartmentFigure,
					BorderLayout.BOTTOM);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureRefinedStateLabelFigure() {
			return fFigureRefinedStateLabelFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureRefinedStateStatemachinesCompartmentFigure() {
			return fFigureRefinedStateStatemachinesCompartmentFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureRefinedStateInvariantsCompartmentFigure() {
			return fFigureRefinedStateInvariantsCompartmentFigure;
		}

	}

}
