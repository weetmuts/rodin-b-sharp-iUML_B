/*
 * Copyright (c) 2012 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
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

import org.eventb.emf.core.EventBElement;


import ac.soton.eventb.classdiagrams.diagram.edit.policies.ClassItemSemanticEditPolicy;
import ac.soton.eventb.classdiagrams.diagram.part.ClassdiagramsVisualIDRegistry;
import ac.soton.eventb.classdiagrams.diagram.providers.ClassdiagramsElementTypes;
import ac.soton.eventb.emf.diagrams.generator.utils.Is;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;

/**
 * @generated
 */
public class ClassEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2003;

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
	public ClassEditPart(View view) {
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
				new ClassItemSemanticEditPolicy());
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
		return primaryShape = new ClassFigure();
	}

	/**
	 * @generated
	 */
	public ClassFigure getPrimaryShape() {
		return (ClassFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ClassNameEditPart) {
			((ClassNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureClassLabelFigure());
			return true;
		}
		if (childEditPart instanceof ClassAttributesCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureClassAttributesCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((ClassAttributesCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		if (childEditPart instanceof ClassMethodsCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureClassMethodsCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((ClassMethodsCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		if (childEditPart instanceof ClassConstraintsCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureClassContraintsCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((ClassConstraintsCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ClassNameEditPart) {
			return true;
		}
		if (childEditPart instanceof ClassAttributesCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureClassAttributesCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((ClassAttributesCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		if (childEditPart instanceof ClassMethodsCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureClassMethodsCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((ClassMethodsCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		if (childEditPart instanceof ClassConstraintsCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureClassContraintsCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((ClassConstraintsCompartmentEditPart) childEditPart)
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
		if (editPart instanceof ClassAttributesCompartmentEditPart) {
			return getPrimaryShape()
					.getFigureClassAttributesCompartmentFigure();
		}
		if (editPart instanceof ClassMethodsCompartmentEditPart) {
			return getPrimaryShape().getFigureClassMethodsCompartmentFigure();
		}
		if (editPart instanceof ClassConstraintsCompartmentEditPart) {
			return getPrimaryShape()
					.getFigureClassContraintsCompartmentFigure();
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
		return getChildBySemanticHint(ClassdiagramsVisualIDRegistry
				.getType(ClassNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ClassdiagramsElementTypes.Association_4005);
		types.add(ClassdiagramsElementTypes.ClassSupertypes_4006);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassEditPart) {
			types.add(ClassdiagramsElementTypes.Association_4005);
		}
		if (targetEditPart instanceof ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassEditPart) {
			types.add(ClassdiagramsElementTypes.ClassSupertypes_4006);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == ClassdiagramsElementTypes.Association_4005) {
			types.add(ClassdiagramsElementTypes.Class_2003);
		} else if (relationshipType == ClassdiagramsElementTypes.ClassSupertypes_4006) {
			types.add(ClassdiagramsElementTypes.Class_2003);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ClassdiagramsElementTypes.Association_4005);
		types.add(ClassdiagramsElementTypes.ClassSupertypes_4006);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == ClassdiagramsElementTypes.Association_4005) {
			types.add(ClassdiagramsElementTypes.Class_2003);
		} else if (relationshipType == ClassdiagramsElementTypes.ClassSupertypes_4006) {
			types.add(ClassdiagramsElementTypes.Class_2003);
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
			if (type == ClassdiagramsElementTypes.ClassAttribute_3022) {
				return getChildBySemanticHint(ClassdiagramsVisualIDRegistry
						.getType(ClassAttributesCompartmentEditPart.VISUAL_ID));
			}
			if (type == ClassdiagramsElementTypes.ClassMethod_3023) {
				return getChildBySemanticHint(ClassdiagramsVisualIDRegistry
						.getType(ClassMethodsCompartmentEditPart.VISUAL_ID));
			}
			if (type == ClassdiagramsElementTypes.ClassConstraint_3024) {
				return getChildBySemanticHint(ClassdiagramsVisualIDRegistry
						.getType(ClassConstraintsCompartmentEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated NOT
	 */
	protected void handleNotificationEvent(Notification event) {
//+++
		refresh();		//refresh to get background to dynamically change
//+++
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
	public class ClassFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private RectangleFigure fFigureClassAttributesCompartmentFigure;
		/**
		 * @generated
		 */
		private RectangleFigure fFigureClassMethodsCompartmentFigure;
		/**
		 * @generated
		 */
		private RectangleFigure fFigureClassContraintsCompartmentFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureClassLabelFigure;

		/**
		 * @generated
		 */
		public ClassFigure() {
			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(8),
					getMapMode().DPtoLP(8)));
			this.setBackgroundColor(ColorConstants.lightGray);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureClassLabelFigure = new WrappingLabel();
			fFigureClassLabelFigure.setText("ClassName");

			this.add(fFigureClassLabelFigure);

			fFigureClassAttributesCompartmentFigure = new RectangleFigure();
			fFigureClassAttributesCompartmentFigure.setFill(false);
			fFigureClassAttributesCompartmentFigure.setOutline(false);

			this.add(fFigureClassAttributesCompartmentFigure);

			fFigureClassMethodsCompartmentFigure = new RectangleFigure();
			fFigureClassMethodsCompartmentFigure.setFill(false);
			fFigureClassMethodsCompartmentFigure.setOutline(false);

			this.add(fFigureClassMethodsCompartmentFigure);

			fFigureClassContraintsCompartmentFigure = new RectangleFigure();
			fFigureClassContraintsCompartmentFigure.setFill(false);
			fFigureClassContraintsCompartmentFigure.setOutline(false);

			this.add(fFigureClassContraintsCompartmentFigure);

		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureClassAttributesCompartmentFigure() {
			return fFigureClassAttributesCompartmentFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureClassMethodsCompartmentFigure() {
			return fFigureClassMethodsCompartmentFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureClassContraintsCompartmentFigure() {
			return fFigureClassContraintsCompartmentFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureClassLabelFigure() {
			return fFigureClassLabelFigure;
		}

	}

	/**
	 * CUSTOM SECTION
	 * Override refresh to update background colour depending on elaborates and refines
	 */
	
	@Override
	public void refresh(){
		super.refresh();
		setBackground();
	}

	static final Color REFINED = ColorConstants.white;
	static final Color VISUALIZES = new Color(null, 255, 255, 200); //light yellow;
	static final Color DEFINES = new Color(null, 200, 255, 200); //light green;
	static final Color NOT_ELABORATED = new Color(null, 245, 255, 245); //very light green;
	private void setBackground() { //Object elabs, Object refines){
		Object refines = DiagramUtils.getModelFeatureValue(this, "refines");
		Object elabs = DiagramUtils.getModelFeatureValue(this, "elaborates");
		if (refines != null){
			setBackgroundColor(REFINED);			
		}else{
			if (elabs instanceof EventBElement){
				if (Is.generatedBy(elabs,DiagramUtils.unwrap(getModel()))){
					setBackgroundColor(DEFINES);
				}else{
					setBackgroundColor(VISUALIZES);
				}
			}else{
				setBackgroundColor(NOT_ELABORATED);
			}
		}
	}

}
