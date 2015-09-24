/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.edit.parts;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.RGB;

import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.diagram.edit.policies.StateItemSemanticEditPolicy;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesDiagramEditorPlugin;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesVisualIDRegistry;
import ac.soton.eventb.statemachines.diagram.preferences.SpecificDiagramAppearancePreferencePage;
import ac.soton.eventb.statemachines.diagram.providers.StatemachinesElementTypes;

/**
 * @generated
 */
public class StateEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2008;

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
	public StateEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicyWithCustomReparent(
						StatemachinesVisualIDRegistry.TYPED_INSTANCE));
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new StateItemSemanticEditPolicy());
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
		if (childEditPart instanceof StateNameEditPart) {
			((StateNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureStateNameFigure());
			return true;
		}
		if (childEditPart instanceof StateStatemachinesCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureStateStatemachinesCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((StateStatemachinesCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		if (childEditPart instanceof StateInvariantsCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureStateInvariantsCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((StateInvariantsCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof StateNameEditPart) {
			return true;
		}
		if (childEditPart instanceof StateStatemachinesCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureStateStatemachinesCompartmentFigure();
			pane.remove(((StateStatemachinesCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		if (childEditPart instanceof StateInvariantsCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureStateInvariantsCompartmentFigure();
			pane.remove(((StateInvariantsCompartmentEditPart) childEditPart)
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

		if (editPart instanceof StateStatemachinesCompartmentEditPart) {
			return getPrimaryShape()
					.getFigureStateStatemachinesCompartmentFigure();
		}
		if (editPart instanceof StateInvariantsCompartmentEditPart) {
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
				.getType(StateNameEditPart.VISUAL_ID));
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
						.getType(StateStatemachinesCompartmentEditPart.VISUAL_ID));
			}
			if (type == StatemachinesElementTypes.Invariant_3014) {
				return getChildBySemanticHint(StatemachinesVisualIDRegistry
						.getType(StateInvariantsCompartmentEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {

		String featureName = event.getFeature() instanceof EStructuralFeature ? ((EStructuralFeature) event
				.getFeature()).getName() : "";

		// update line width depending on active state
		if ("active".equals(featureName)) {
			boolean active = event.getNewBooleanValue();
			setLineWidth(1 + (active ? 2 : 0));
		}

		// update colour when refines changes
		if ("refines".equals(featureName)) {
			refreshForegroundColor();
			refreshBackgroundColor();
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

			EStructuralFeature refinesFeature = eClazz
					.getEStructuralFeature("refines");
			boolean refined = refinesFeature == null ? false : element
					.eIsSet(refinesFeature);
			rgb = PreferenceConverter.getColor(prefStore,
					SpecificDiagramAppearancePreferencePage
							.getLineColorPreference(eClazz, refined));

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

			EStructuralFeature refinesFeature = eClazz
					.getEStructuralFeature("refines");
			boolean refined = refinesFeature == null ? false : element
					.eIsSet(refinesFeature);
			rgb = PreferenceConverter.getColor(prefStore,
					SpecificDiagramAppearancePreferencePage
							.getFillColorPreference(eClazz, refined));

		}

		if (rgb != null) {
			setBackgroundColor(new Color(null, rgb));
		} else {
			super.refreshBackgroundColor();
		}
	}

	/////////// mouse-over feedback text ///////////	
	Label feedbackFigure = null;
	String feedbackText = null;;

	/*
	 * Provides mouse over feedback:
	 * Customised to show the active instances (probably only while animating)
	 * @custom
	 */
	@Override
	public void showTargetFeedback(Request request) {
		super.showTargetFeedback(request);
		// the feedback layer figures do not receive mouse e
		if (feedbackText == null) {
			feedbackText = getText();
			if (feedbackText.length() > 0) {
				feedbackFigure = new Label(feedbackText);
				feedbackFigure.setFont(new Font(null, "Arial", 12, SWT.NORMAL));
				Rectangle bounds = feedbackFigure.getTextBounds().getCopy()
						.expand(2, 2);
				Dimension stateSize = getFigure().getSize();
				Point location = getFigure()
						.getBounds()
						.getLocation()
						.translate(stateSize.width - bounds.width,
								stateSize.height - bounds.height);
				getFigure().translateToAbsolute(location);
				bounds.setLocation(location);
				feedbackFigure.setBounds(bounds);
				feedbackFigure.setForegroundColor(ColorConstants.black); //tooltipForeground);
				feedbackFigure.setBackgroundColor(ColorConstants.white); //tooltipBackground);
				feedbackFigure.setOpaque(true);
				//feedbackFigure.setBorder(new LineBorder());

				IFigure layer = getLayer(LayerConstants.FEEDBACK_LAYER);
				layer.add(feedbackFigure);
			}
		}
	}

	private String getText() {
		State state = (State) resolveSemanticElement();
		String text = "";
		EList<?> ains = state.getActiveInstances();
		if (ains != null && ains.size() > 0) {
			for (Object ins : ains) {
				if (ins instanceof String) {
					if (text.length() > 0)
						text = text + "\n";
					text = text + ins;
				}
			}
		}
		return text;
	}

	/* Erases mouse-over feedback.
	 * @custom
	 */
	@Override
	public void eraseTargetFeedback(Request request) {
		super.eraseTargetFeedback(request);
		if (request instanceof CreateConnectionRequest)
			return;
		if (getViewer() == null)
			return;
		IFigure layer = getLayer(LayerConstants.FEEDBACK_LAYER);
		if (layer != null && feedbackFigure != null
				&& feedbackFigure.getParent() != null) {
			layer.remove(feedbackFigure);
		}
		feedbackFigure = null;
		feedbackText = null;
	}

}
