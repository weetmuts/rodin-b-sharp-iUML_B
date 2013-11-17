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

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.eclipse.gmf.runtime.draw2d.ui.figures.OneLineBorder;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.diagram.edit.policies.OpenDiagramEditPolicy;
import ac.soton.eventb.statemachines.diagram.edit.policies.StatemachineItemSemanticEditPolicy;
import ac.soton.eventb.statemachines.diagram.providers.StatemachinesElementTypes;

/**
 * @generated
 */
public class StatemachineEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3001;

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
	public StatemachineEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new StatemachineItemSemanticEditPolicy());
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

		primaryShape = new StatemachineFigure();

		// set background color to white if domain element refines something
		EObject element = resolveSemanticElement();
		if (element != null) {
			EStructuralFeature feature = element.eClass()
					.getEStructuralFeature("refines");
			if (feature != null && element.eIsSet(feature))
				primaryShape.setBackgroundColor(ColorConstants.white);
		}

		return primaryShape;
	}

	/**
	 * @generated
	 */
	public StatemachineFigure getPrimaryShape() {
		return (StatemachineFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof StatemachineStatesCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureStatemachineCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((StatemachineStatesCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof StatemachineStatesCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureStatemachineCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((StatemachineStatesCompartmentEditPart) childEditPart)
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
		if (editPart instanceof StatemachineStatesCompartmentEditPart) {
			return getPrimaryShape().getFigureStatemachineCompartmentFigure();
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
		if (targetEditPart instanceof ac.soton.eventb.statemachines.diagram.edit.parts.StatemachineEditPart) {
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
		if (relationshipType == StatemachinesElementTypes.Transition_4002) {
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

		// update background color when refines propeerty changed
		if (StatemachinesPackage.eINSTANCE.getState_Refines().equals(
				event.getFeature())
				|| StatemachinesPackage.eINSTANCE.getStatemachine_Refines()
						.equals(event.getFeature())) {
			if (event.getNewValue() == null)
				setBackgroundColor(THIS_BACK);
			else
				setBackgroundColor(ColorConstants.white);
		}

		super.handleNotificationEvent(event);
	}

	/**
	 * @generated
	 */
	public class StatemachineFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private RectangleFigure fFigureStatemachineCompartmentFigure;

		/**
		 * @generated
		 */
		public StatemachineFigure() {

			BorderLayout layoutThis = new BorderLayout();
			this.setLayoutManager(layoutThis);

			this.setOutline(false);
			this.setForegroundColor(ColorConstants.gray);
			this.setBackgroundColor(THIS_BACK);
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(100),
					getMapMode().DPtoLP(80)));
			this.setBorder(createBorder0());
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureStatemachineCompartmentFigure = new RectangleFigure();

			fFigureStatemachineCompartmentFigure.setFill(false);
			fFigureStatemachineCompartmentFigure.setOutline(false);

			this.add(fFigureStatemachineCompartmentFigure, BorderLayout.CENTER);

		}

		/**
		 * @generated
		 */
		private Border createBorder0() {
			OneLineBorder result = new OneLineBorder();
			result.setPosition(PositionConstants.TOP);
			result.setStyle(Graphics.LINE_DASH);

			return result;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureStatemachineCompartmentFigure() {
			return fFigureStatemachineCompartmentFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 240, 240, 255);

}
