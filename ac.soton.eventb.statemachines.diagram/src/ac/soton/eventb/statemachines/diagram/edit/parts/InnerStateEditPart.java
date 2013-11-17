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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import ac.soton.eventb.statemachines.diagram.edit.policies.InnerStateItemSemanticEditPolicy;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesVisualIDRegistry;
import ac.soton.eventb.statemachines.diagram.providers.StatemachinesElementTypes;

/**
 * @generated
 */
public class InnerStateEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3013;

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
	public InnerStateEditPart(View view) {
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
				new InnerStateItemSemanticEditPolicy());
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

		primaryShape = new StateFigure();

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
	public StateFigure getPrimaryShape() {
		return (StateFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof InnerStateNameEditPart) {
			((InnerStateNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureStateNameFigure());
			return true;
		}
		if (childEditPart instanceof InnerStateStatemachinesCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureStateStatemachinesCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((InnerStateStatemachinesCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		if (childEditPart instanceof InnerStateInvariantsCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureStateInvariantsCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((InnerStateInvariantsCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof InnerStateNameEditPart) {
			return true;
		}
		if (childEditPart instanceof InnerStateStatemachinesCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureStateStatemachinesCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((InnerStateStatemachinesCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		if (childEditPart instanceof InnerStateInvariantsCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureStateInvariantsCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((InnerStateInvariantsCompartmentEditPart) childEditPart)
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
		if (editPart instanceof InnerStateStatemachinesCompartmentEditPart) {
			return getPrimaryShape()
					.getFigureStateStatemachinesCompartmentFigure();
		}
		if (editPart instanceof InnerStateInvariantsCompartmentEditPart) {
			return getPrimaryShape()
					.getFigureStateInvariantsCompartmentFigure();
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
				.getType(InnerStateNameEditPart.VISUAL_ID));
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
		if (targetEditPart instanceof ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateEditPart) {
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
		if (targetEditPart instanceof StatemachineEditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		if (targetEditPart instanceof InnerInitialEditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		if (targetEditPart instanceof InnerFinalEditPart) {
			types.add(StatemachinesElementTypes.Transition_4002);
		}
		if (targetEditPart instanceof ac.soton.eventb.statemachines.diagram.edit.parts.InnerStateEditPart) {
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
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request)
					.getViewAndElementDescriptor()
					.getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter
					.getAdapter(IElementType.class);
			if (type == StatemachinesElementTypes.Statemachine_3001) {
				return getChildBySemanticHint(StatemachinesVisualIDRegistry
						.getType(InnerStateStatemachinesCompartmentEditPart.VISUAL_ID));
			}
			if (type == StatemachinesElementTypes.Invariant_3014) {
				return getChildBySemanticHint(StatemachinesVisualIDRegistry
						.getType(InnerStateInvariantsCompartmentEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
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
	public class StateFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureStateNameFigure;
		/**
		 * @generated
		 */
		private RectangleFigure fFigureStateStatemachinesCompartmentFigure;
		/**
		 * @generated
		 */
		private RectangleFigure fFigureStateInvariantsCompartmentFigure;

		/**
		 * @generated
		 */
		public StateFigure() {

			BorderLayout layoutThis = new BorderLayout();
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(8),
					getMapMode().DPtoLP(8)));
			this.setForegroundColor(ColorConstants.gray);
			this.setBackgroundColor(THIS_BACK);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureStateNameFigure = new WrappingLabel();

			fFigureStateNameFigure.setText("<...>");

			fFigureStateNameFigure.setBorder(new MarginBorder(getMapMode()
					.DPtoLP(0), getMapMode().DPtoLP(5), getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(5)));

			this.add(fFigureStateNameFigure, BorderLayout.TOP);

			fFigureStateStatemachinesCompartmentFigure = new RectangleFigure();

			fFigureStateStatemachinesCompartmentFigure.setFill(false);
			fFigureStateStatemachinesCompartmentFigure.setOutline(false);

			this.add(fFigureStateStatemachinesCompartmentFigure,
					BorderLayout.CENTER);

			fFigureStateInvariantsCompartmentFigure = new RectangleFigure();

			fFigureStateInvariantsCompartmentFigure.setFill(false);
			fFigureStateInvariantsCompartmentFigure.setOutline(false);

			this.add(fFigureStateInvariantsCompartmentFigure,
					BorderLayout.BOTTOM);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureStateNameFigure() {
			return fFigureStateNameFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureStateStatemachinesCompartmentFigure() {
			return fFigureStateStatemachinesCompartmentFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureStateInvariantsCompartmentFigure() {
			return fFigureStateInvariantsCompartmentFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 196, 204, 255);

}
