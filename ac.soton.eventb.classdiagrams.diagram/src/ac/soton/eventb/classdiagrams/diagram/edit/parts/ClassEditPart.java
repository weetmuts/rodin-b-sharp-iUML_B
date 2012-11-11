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
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eventb.emf.core.EventBElement;

import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.diagram.edit.policies.ClassItemSemanticEditPolicy;
import ac.soton.eventb.classdiagrams.diagram.part.ClassdiagramsVisualIDRegistry;
import ac.soton.eventb.classdiagrams.diagram.providers.ClassdiagramsElementTypes;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.emf.diagrams.generator.utils.Is;

/**
 * @generated
 */
public class ClassEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2002;

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
		if (childEditPart instanceof ClassAttributesEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureClassAttributesCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((ClassAttributesEditPart) childEditPart).getFigure());
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
		if (childEditPart instanceof ClassAttributesEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureClassAttributesCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((ClassAttributesEditPart) childEditPart).getFigure());
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
		if (editPart instanceof ClassAttributesEditPart) {
			return getPrimaryShape()
					.getFigureClassAttributesCompartmentFigure();
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
		types.add(ClassdiagramsElementTypes.Association_4001);
		types.add(ClassdiagramsElementTypes.ClassSupertypes_4004);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassEditPart) {
			types.add(ClassdiagramsElementTypes.Association_4001);
		}
		if (targetEditPart instanceof ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassEditPart) {
			types.add(ClassdiagramsElementTypes.ClassSupertypes_4004);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == ClassdiagramsElementTypes.Association_4001) {
			types.add(ClassdiagramsElementTypes.Class_2002);
		} else if (relationshipType == ClassdiagramsElementTypes.ClassSupertypes_4004) {
			types.add(ClassdiagramsElementTypes.Class_2002);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ClassdiagramsElementTypes.Association_4001);
		types.add(ClassdiagramsElementTypes.ClassSupertypes_4004);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == ClassdiagramsElementTypes.Association_4001) {
			types.add(ClassdiagramsElementTypes.Class_2002);
		} else if (relationshipType == ClassdiagramsElementTypes.ClassSupertypes_4004) {
			types.add(ClassdiagramsElementTypes.Class_2002);
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
			if (type == ClassdiagramsElementTypes.ClassAttribute_3021) {
				return getChildBySemanticHint(ClassdiagramsVisualIDRegistry
						.getType(ClassAttributesEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
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
		private WrappingLabel fFigureClassLabelFigure;

		/**
		 * @generated
		 */
		public ClassFigure() {
			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(8),
					getMapMode().DPtoLP(8)));
			this.setBackgroundColor(ColorConstants.lightGreen);
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
		public WrappingLabel getFigureClassLabelFigure() {
			return fFigureClassLabelFigure;
		}

	}

	/**
	 * CUSTOM SECTION
	 * Override notification to update colour depending on refines
	 */
	static final Color REFINED = ColorConstants.white;
	static final Color VISUALIZES = ColorConstants.lightBlue;
	static final Color DEFINES = ColorConstants.green;
	static final Color NOT_ELABORATED = ColorConstants.yellow;
	
	protected void handleNotificationEvent(Notification event) {
		// update background colour when refines property changed
		if (ClassdiagramsPackage.eINSTANCE.getClass_Refines().equals(event.getFeature())) {
			if (event.getNewValue() == null){
				setBackground(getElaborates(), false );
			}else{
				setBackground(getElaborates(), true );
			}
		// update background colour when elaborates property changed
		} else if (ClassdiagramsPackage.eINSTANCE.getElaborativeElement_Elaborates().equals(event.getFeature())) {
			setBackground(event.getNewValue(), isRefines());
		} else {
			//do nothing
		}
		
		if (event.getNotifier() == getModel()
				&& EcorePackage.eINSTANCE.getEModelElement_EAnnotations()
						.equals(event.getFeature())) {
			handleMajorSemanticChange();
		} else {
			super.handleNotificationEvent(event);
		}
	}
	
	private void setBackground(){
		setBackground(getElaborates(), isRefines());
	}
	
	private void setBackground(Object elabs, boolean refines){
		if (refines){
			setBackgroundColor(REFINED);			
		}else{
			if (elabs instanceof EventBElement){
				if (Is.generatedBy(elabs,getModelElement())){
						//((EventBElement) elabs).isLocalGenerated()){
					setBackgroundColor(DEFINES);
				}else{
					setBackgroundColor(VISUALIZES);
				}
			}else{
				setBackgroundColor(NOT_ELABORATED);
			}
		}
	}
	
	private Object getElaborates(){
		Object element = getModelElement();
		if (element instanceof Class){
			return ((Class)element).getElaborates();	
		}
		return null;
	}
	
	private boolean isRefines(){
		Object element = getModelElement();
		if (element instanceof Class){
			return ((Class)element).getRefines()!=null;	
		}
		return false;
	}
	
	private Object getModelElement(){
		Object model = getModel();
		if (model instanceof Node){
			return ((Node)model).getElement();
		}
		return null;
	}
	
	@Override
	public void refresh(){
		super.refresh();
		setBackground();
	}
}
