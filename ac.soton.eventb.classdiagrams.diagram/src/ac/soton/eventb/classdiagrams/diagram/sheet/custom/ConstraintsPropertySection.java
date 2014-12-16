/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassConstraint;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.emf.diagrams.sheet.AbstractTablePropertySection;
import ac.soton.eventb.emf.diagrams.sheet.PropertySectionUtil;

/**
 * Constraints property section.
 * 
 * @author vitaly/cfsnook
 *
 */
public class ConstraintsPropertySection extends AbstractTablePropertySection {
	
	protected Button upButton;
	protected Button downButton;

	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		
		Control[] children = parent.getChildren();
		FormData data;
		
		upButton = getWidgetFactory().createButton((Composite) children[0], "Up", SWT.PUSH);
		data = new FormData();
		data.left = new FormAttachment(removeButton, 0);
		data.bottom = new FormAttachment(100, 0);
		data.width = 50;
		upButton.setLayoutData(data);
		upButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				EditingDomain editingDomain = ((DiagramEditor) getPart())
						.getEditingDomain();
				Object object = table.getSelection()[0].getData();
				int newIndex = table.getSelectionIndex() - 1;
				editingDomain.getCommandStack().execute(
						MoveCommand.create(editingDomain, eObject, getFeature(),
								object, newIndex));
				refresh();
				table.select(newIndex);
				table.notifyListeners(SWT.Selection, new Event());
			}
		});
		
		downButton = getWidgetFactory().createButton((Composite) children[0], "Down", SWT.PUSH);
		data = new FormData();
		data.left = new FormAttachment(upButton, 0);
		data.bottom = new FormAttachment(100, 0);
		data.width = 50;
		downButton.setLayoutData(data);
		downButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				EditingDomain editingDomain = ((DiagramEditor) getPart())
						.getEditingDomain();
				Object object = table.getSelection()[0].getData();
				int newIndex = table.getSelectionIndex() + 1;
				editingDomain.getCommandStack().execute(
						MoveCommand.create(editingDomain, eObject, getFeature(),
								object, newIndex));
				refresh();
				table.select(newIndex);
				table.notifyListeners(SWT.Selection, new Event());
			}
		});
		
		table.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				upButton.setEnabled(table.getSelectionIndex() > 0);
				downButton.setEnabled(table.getSelectionIndex() >= 0 && table.getSelectionIndex() < (table.getItemCount() - 1));
			}
		});
		
		table.setFont(PropertySectionUtil.rodinFont);
	}

//	/**
//	 * @param name
//	 * @return
//	 */
//	protected static boolean constriantNameExists(String name) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public void refresh() {
		upButton.setEnabled(false);
		downButton.setEnabled(false);
		super.refresh();
	}

	@Override
	protected String getButtonLabelText() {
		return "Constraint";
	}

	@Override
	protected EList<?> getOwnedRows() {
		return ((Class) eObject).getConstraints();
	}

	@Override
	protected List getValuesForRow(Object object) {
		ClassConstraint constraint = (ClassConstraint) object;
		return Arrays.asList(new String[]{constraint.getName(), Boolean.toString(constraint.isTheorem()), constraint.getPredicate()});
	}

	@Override
	protected List getColumnLabelText() {
		return Arrays.asList(new String[]{"Name", "Theorem", "Predicate"});
	}

	@Override
	protected Object getNewChild() {
		NewConstraintDialog constraintDialog = new NewConstraintDialog(getPart().getSite().getShell());
		if (Dialog.OK == constraintDialog.open()) {
			return constraintDialog.getInvariant();
		}
		return null;
	}

	@Override
	protected String getLabelText() {
		return "Constraints:";
	}

	@Override
	protected EStructuralFeature getFeature() {
		return ClassdiagramsPackage.Literals.CLASS__CONSTRAINTS;
	}

	@Override
	protected ISelection getEditorSelection(Object object) {
		DiagramEditor editor = (DiagramEditor) getPart();
		IStructuredSelection selection = (IStructuredSelection) editor.getDiagramGraphicalViewer().getSelection();
		if (selection != null && selection.size() == 1) {
			GraphicalEditPart selectedPart = (GraphicalEditPart) selection.getFirstElement();
			EditPart part = selectedPart.findEditPart(null, (EObject) object);
			if (part != null)
				return new StructuredSelection(part);
			if (selectedPart.getParent() != null) {
				part = ((GraphicalEditPart) selectedPart.getParent()).findEditPart(null, (EObject) object);
				if (part != null)
					return new StructuredSelection(part);
			}
		}
		return null;
	}

}
