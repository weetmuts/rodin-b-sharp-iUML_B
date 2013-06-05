/**
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import ac.soton.eventb.classdiagrams.ClassConstraint;
import ac.soton.eventb.classdiagrams.ClassdiagramsFactory;

/**
 * New invariant creation dialog.
 * 
 * @author vitaly
 *
 */
public class NewConstraintDialog extends Dialog {

	private Text predicateText;
	private Button theoremButton;
	private Text nameText;
	private Text commentText;
	private IInputValidator predicateValidator;
	private IInputValidator nameValidator;
	private boolean predicateValid;
	private boolean nameValid;
	
	private ClassConstraint constraint;

	/**
	 * @param parentShell
	 */
	protected NewConstraintDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Add New Constraint");
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		
		Group group = new Group(composite, SWT.SHADOW_ETCHED_IN);
		group.setText("Constraint");
		GridLayout layout = new GridLayout(2, false);
		group.setLayout(layout);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd.widthHint = 300;
		group.setLayoutData(gd);
		
		// predicate
		Label predicateLabel = new Label(group, SWT.NONE);
		predicateLabel.setText("Predicate:");
		predicateLabel.setData(new GridData(SWT.TOP));
		predicateText = new Text(group, SWT.SINGLE | SWT.BORDER);
		GridData data = new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL);
		data.widthHint = IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH;
		predicateText.setLayoutData(data);
		predicateText.setFont(PropertySectionUtil.rodinFont);
		predicateText.addModifyListener(PropertySectionUtil.eventBListener);
		predicateText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                validatePredicate();
            }
        });
		
		// name
		Label nameLabel = new Label(group, SWT.NONE);
		nameLabel.setText("Name:");
		nameText = new Text(group, SWT.SINGLE | SWT.BORDER);
		nameText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		nameText.setFont(PropertySectionUtil.rodinFont);
		nameText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                validateName();
            }
        });
		
		// comment
		Label commentLabel = new Label(group, SWT.NONE);
		commentLabel.setText("Comment:");
		commentText = new Text(group, SWT.SINGLE | SWT.BORDER);
		commentText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		commentText.setFont(PropertySectionUtil.rodinFont);

		// theorem
		@SuppressWarnings("unused")
		Label theoremLabel = new Label(group, SWT.NONE);
		theoremButton = new Button(group, SWT.CHECK);
		theoremButton.setText("Theorem");
		
		// validators
		predicateValidator = new DecoratedInputValidator(PropertySectionUtil.createDecorator(predicateText, "Please enter predicate", FieldDecorationRegistry.DEC_ERROR, false)) {

			@Override
			public String isValidInput(String predicate) {
				if (predicate == null || predicate.trim().isEmpty())
					return "Predicate cannot be empty";
				return null;
			}
		};
		
		nameValidator = new DecoratedInputValidator(PropertySectionUtil.createDecorator(nameText, "Please enter name", FieldDecorationRegistry.DEC_ERROR, false)) {
			
			@Override
			public String isValidInput(String name) {
				if (name == null || name.trim().isEmpty())
					return "Name cannot be empty";
				return null;
			}
		};
		
		return composite;
	}

	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		// only here the buttons are available, so that's where OK can be disabled for initial state
		update();
		return contents;
	}

	/**
	 * Validates predicate.
	 */
	protected void validatePredicate() {
		String errorMessage = null;
        if (predicateValidator != null) {
            errorMessage = predicateValidator.isValid(predicateText.getText());
            predicateValid = errorMessage == null;
        }
		update();
	}

	/**
	 * Validates name.
	 */
	protected void validateName() {
		String errorMessage = null;
        if (nameValidator != null) {
            errorMessage = nameValidator.isValid(nameText.getText());
            nameValid = errorMessage == null;
        }
		update();
	}

	private void update() {
		Control button = getButton(IDialogConstants.OK_ID);
		if (button != null) {
			button.setEnabled(predicateValid && nameValid);
		}
	}
	
	/**
	 * Returns invariant created by this dialog.
	 * 
	 * @return new invariant
	 */
	public ClassConstraint getInvariant() {
		return constraint;
	}

	@Override
	protected void okPressed() {
		constraint = ClassdiagramsFactory.eINSTANCE.createClassConstraint();
		
		constraint.setPredicate(predicateText.getText().trim());
		constraint.setName(nameText.getText().trim());
		constraint.setComment(commentText.getText());
		constraint.setTheorem(theoremButton.getSelection());
		
		super.okPressed();
	}
}
