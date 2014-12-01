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
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.KeyEvent;
import org.eclipse.draw2d.KeyListener;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;
import org.eventb.emf.core.machine.Action;
import org.eventb.emf.core.machine.Guard;
import org.eventb.emf.core.machine.Witness;

import ac.soton.eventb.emf.core.extension.coreextension.TypedParameter;
import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.Transition;
import ac.soton.eventb.statemachines.diagram.edit.policies.TransitionItemSemanticEditPolicy;

/**
 * @generated
 */
public class TransitionEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4001;

	/**
	 * @generated
	 */
	public TransitionEditPart(View view) {
		super(view);
	}
	
	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new TransitionItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof TransitionLabelEditPart) {
			((TransitionLabelEditPart) childEditPart)
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
		if (childEditPart instanceof TransitionLabelEditPart) {
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
			this.setForegroundColor(ColorConstants.gray);

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
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {
		// update line width and color if link state changes
		if (StatemachinesPackage.eINSTANCE.getTransition_Operations().equals(
				event.getFeature())) {
			Collection<?> operations = ((Transition) ((View) getModel())
					.getElement()).getOperations();
			boolean enabled = operations != null && !operations.isEmpty();
			getPrimaryShape().setLineWidth(1 + (enabled ? 2 : 0));
			getPrimaryShape().setForegroundColor(
					enabled ? ColorConstants.darkGreen : ColorConstants.gray);
		}

		super.handleNotificationEvent(event);
	}
	
	
	/////////// mouse-over feedback text ///////////	
	Label feedbackFigure=null;
	String feedbackText=null;;

	
	/*
	 * Provides mouse over feedback:
	 * Customised to  show the contents (params, witnesses, guards and actions) of the method
	 * @custom
	 */
	@Override
	public void showTargetFeedback(Request request) {
		super.showTargetFeedback(request);
		// the feedback layer figures do not receive mouse e
		if (feedbackText==null) {
			feedbackText = getMethodText();
			if (feedbackText.length()>0){
				feedbackFigure = new Label(feedbackText);
				feedbackFigure.setFont(new Font(null, "Arial", 12, SWT.NORMAL));
				Rectangle bounds = feedbackFigure.getTextBounds().getCopy().expand(10, 10);
				bounds.setLocation(getFigure().getBounds().getLocation()
						.translate(200, 100));
				feedbackFigure.setBounds(bounds);
				feedbackFigure.setForegroundColor(ColorConstants.darkGray);  //tooltipForeground);
				feedbackFigure.setBackgroundColor(ColorConstants.lightGray); //tooltipBackground);
				feedbackFigure.setOpaque(true);
				//feedbackFigure.setBorder(new LineBorder());
	
				IFigure layer = getLayer(LayerConstants.FEEDBACK_LAYER);
				layer.add(feedbackFigure);
			}
		}
	}

	private String getMethodText() {
		Transition method = (Transition) resolveSemanticElement();
		String text = "";

		if (method.getParameters().size()>0){
			text = text + "\nParameters: \n"; 
			for (TypedParameter p : method.getParameters()){
				text = text + "\t"+p.getName()+" : "+p.getType()+"\n";
			}
		}
		if (method.getWitnesses().size()>0){
			text = text + "\nWitnesses: \n";
			for (Witness w : method.getWitnesses()){
				text = text + "\t"+w.getName()+" : "+indent(w.getName().length(),w.getPredicate())+(w.getComment().length()>0? " //"+w.getComment():"")+"\n";
			}
		}
		if (method.getGuards().size()>0){
			text = text + "\nGuards: \n";
			for (Guard w : method.getGuards()){
				text = text + "\t"+w.getName()+":"+indent(w.getName().length(),w.getPredicate())+(w.getComment().length()>0? " //"+w.getComment():"")+"\n";
			}
		}
		if (method.getActions().size()>0){
			text = text + "\nActions: \n";
			for (Action w : method.getActions()){
				text = text + "\t"+w.getName()+" : "+indent(w.getName().length(),w.getAction())+(w.getComment().length()>0? " //"+w.getComment():"")+"\n";
			}
		}
		
		if (text.length()>0){
			text = method.getLabel()
				+(method.isExtended()? "  [extended]":"")
				+(method.getComment()!=null && method.getComment().length()>0? "  //"+method.getComment():"")+"\n"
				+text;
		}

		return text;
	}
	
	private static String indent(int nameLength, String text){
		if (text==null || text.length()<1) return "";
		int tabs = ((nameLength+1)/4) + 1;
		String indent = "";
		for (int i=0; i<tabs; i++){
			indent = indent+"\t";
		}
		return "\t"+text.replace("\n", "\n"+indent);
	}

	/* Erases mouse-over feedback.
	 * @custom
	 */
	@Override
	public void eraseTargetFeedback(Request request) {
		super.eraseTargetFeedback(request);
		if (request instanceof CreateConnectionRequest)
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
