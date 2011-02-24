/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.sheet.custom;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eventb.emf.core.machine.Invariant;
import org.eventb.emf.core.machine.MachineFactory;

import ac.soton.eventb.statemachines.AbstractState;
import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesDiagramEditor;

/**
 * Invariants property section for AbstractState.
 * 
 * @author vitaly
 *
 */
public class InvariantsPropertySection extends AbstractTablePropertySection {

	/**
	 * New Invariant creation dialog.
	 * 
	 * @author vitaly
	 *
	 */
	private final class NewInvariantDialog extends InputDialog {
		private Button theoremButton;
		protected boolean isTheorem = false;

		/**
		 * @param parentShell
		 * @param dialogTitle
		 * @param dialogMessage
		 * @param initialValue
		 * @param validator
		 */
		private NewInvariantDialog(Shell parentShell, String dialogTitle,
				String dialogMessage, String initialValue,
				IInputValidator validator) {
			super(parentShell, dialogTitle, dialogMessage, initialValue,
					validator);
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Composite composite = (Composite) super.createDialogArea(parent);
			theoremButton = getWidgetFactory().createButton(composite, "Theorem", SWT.CHECK);
			GridData data = new GridData(GridData.GRAB_HORIZONTAL
	                | GridData.HORIZONTAL_ALIGN_FILL);
			theoremButton.setLayoutData(data);
			theoremButton.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					isTheorem  = theoremButton.getSelection();
				}});
			return composite;
		}

		public boolean isTheorem() {
			return isTheorem;
		}
	}

	static final IInputValidator invariantValidator = new IInputValidator(){

		@Override
		public String isValid(String name) {
			if (name.trim().isEmpty())
				return "";
			return null;
		}
	};

	@Override
	protected String getButtonLabelText() {
		return "Invariant";
	}

	@Override
	protected List getOwnedRows() {
		return ((AbstractState) eObject).getConstraints();
	}

	@Override
	protected String getKeyForRow(Object object) {
		return "";
	}

	@Override
	protected List getValuesForRow(Object object) {
		Invariant invariant = (Invariant) object;
		return Arrays.asList(new String[]{Boolean.toString(invariant.isTheorem()), invariant.getPredicate()});
	}

	@Override
	protected List getColumnLabelText() {
		return Arrays.asList(new String[]{"Theorem", "Predicate"});
	}

	@Override
	protected Object getNewChild() {
		NewInvariantDialog invariantDialog = new NewInvariantDialog(getPart().getSite().getShell(), 
				"New Invariant", 
				"Please enter new invariant predicate:", 
				null, 
				invariantValidator);
		if (Dialog.OK == invariantDialog.open()) {
			Invariant invariant = MachineFactory.eINSTANCE.createInvariant();
			invariant.setPredicate(invariantDialog.getValue());
			invariant.setTheorem(invariantDialog.isTheorem());
			return invariant;
		}
		return null;
	}

	@Override
	protected String getLabelText() {
		return "Invariants:";
	}

	@Override
	protected EStructuralFeature getFeature() {
		return StatemachinesPackage.Literals.ABSTRACT_STATE__CONSTRAINTS;
	}

	@Override
	protected ISelection getEditorSelection(Object object) {
		StatemachinesDiagramEditor editor = (StatemachinesDiagramEditor) getPart();
		IStructuredSelection selection = (IStructuredSelection) editor.getDiagramGraphicalViewer().getSelection();
		if (selection != null && selection.size() == 1) {
			GraphicalEditPart selectedPart = (GraphicalEditPart) selection.getFirstElement();
			EditPart part = selectedPart.findEditPart(null, (EObject) object);
			if (part != null)
				return new StructuredSelection(part);
		}
		return null;
	}

}
