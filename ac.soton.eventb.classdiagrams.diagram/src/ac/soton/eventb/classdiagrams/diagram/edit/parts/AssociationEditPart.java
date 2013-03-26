/*
 * Copyright (c) 2012 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;

import ac.soton.eventb.classdiagrams.diagram.edit.policies.AssociationItemSemanticEditPolicy;

/**
 * @generated
 */
public class AssociationEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4005;

	/**
	 * @generated
	 */
	public AssociationEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new AssociationItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof AssociationNameEditPart) {
			((AssociationNameEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureAssociationLabelFigure());
			return true;
		}
		if (childEditPart instanceof AssociationSurjectiveInjectiveEditPart) {
			((AssociationSurjectiveInjectiveEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureAssociationLabelSource());
			return true;
		}
		if (childEditPart instanceof AssociationTotalFunctionalEditPart) {
			((AssociationTotalFunctionalEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureAssociationLabelTarget());
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
		if (childEditPart instanceof AssociationNameEditPart) {
			return true;
		}
		if (childEditPart instanceof AssociationSurjectiveInjectiveEditPart) {
			return true;
		}
		if (childEditPart instanceof AssociationTotalFunctionalEditPart) {
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
		return new AssociationFigure();
	}

	/**
	 * @generated
	 */
	public AssociationFigure getPrimaryShape() {
		return (AssociationFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class AssociationFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureAssociationLabelSource;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureAssociationLabelTarget;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureAssociationLabelFigure;

		/**
		 * @generated
		 */
		public AssociationFigure() {
			this.setForegroundColor(ColorConstants.gray);

			createContents();
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureAssociationLabelFigure = new WrappingLabel();
			fFigureAssociationLabelFigure.setText("");
			fFigureAssociationLabelFigure
					.setBackgroundColor(ColorConstants.lightGray);

			this.add(fFigureAssociationLabelFigure);

			fFigureAssociationLabelSource = new WrappingLabel();
			fFigureAssociationLabelSource.setText("");

			this.add(fFigureAssociationLabelSource);

			fFigureAssociationLabelTarget = new WrappingLabel();
			fFigureAssociationLabelTarget.setText("");

			this.add(fFigureAssociationLabelTarget);

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
		public WrappingLabel getFigureAssociationLabelSource() {
			return fFigureAssociationLabelSource;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureAssociationLabelTarget() {
			return fFigureAssociationLabelTarget;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureAssociationLabelFigure() {
			return fFigureAssociationLabelFigure;
		}

	}

}
