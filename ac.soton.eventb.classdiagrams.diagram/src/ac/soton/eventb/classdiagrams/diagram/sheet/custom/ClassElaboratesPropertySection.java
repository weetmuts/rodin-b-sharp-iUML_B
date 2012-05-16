/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.common.ui.dialogs.PopupDialog;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.Variable;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.ElaborativeElement;

/**
 * Elaborates property section for Classdiagrams.
 * 
 * @author vitaly
 * 
 */
public class ClassElaboratesPropertySection extends AbstractLOVPropertySection {

	private static ILabelProvider variableLabelProvider = new LabelProvider() {

		@Override
		public String getText(Object element) {
			if (element instanceof EventBNamed){
				return ((EventBNamed)element).getName();
			} else {
				return "not an EventBNamed element";				
			}
		}
	};

	/**
	 * Get a new child instance for the result of clicking the add button.
	 * 
	 * @return a new child instance.
	 */
	protected Object getNewChild() {
		EObject container = EcoreUtil.getRootContainer(eObject);
		String popupTitle = "no name";
		List<? super EventBNamed> valuesList = new LinkedList<EventBNamed>() ;
		
		
		if (container instanceof Machine){
			Machine machine = (Machine) container;
			
			popupTitle = machine.getName();
			valuesList.addAll(machine.getVariables());
			
			
			for (Context context : machine.getSees()){
				valuesList.addAll(context.getConstants());
				valuesList.addAll(context.getSets());
			}
			
		} else if (container instanceof Context){
			Context context = (Context)container;
			
			popupTitle = context.getName();
			
			valuesList.addAll(context.getConstants());
			valuesList.addAll(context.getSets());
		}
		
		
		//TODO limit only to a single selection
		PopupDialog variablesDialog = new PopupDialog(getPart().getSite()
				.getShell(), valuesList, variableLabelProvider);
		variablesDialog.setTitle(popupTitle + " elements");
		variablesDialog.setMessage("Please select an element to elaborate");
		
		if (Dialog.OK == variablesDialog.open()) {
			if (variablesDialog.getResult().length > 0){
				return variablesDialog.getResult()[0]; 
			}
		}
		return null;
	}

	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		getTextWidget().addModifyListener(new ModifyListener(){

			@Override
			public void modifyText(ModifyEvent e) {
				if (eObject != null && ((ElaborativeElement)eObject).getElaborates() != null){
					addButton.setEnabled(false);
					clearButton.setEnabled(true);
				} else {
					addButton.setEnabled(true);
					clearButton.setEnabled(false);
				}
			}
			
		});
		
		refresh();
	}
	
	protected void modifyElement(Object pNewChild){
		super.modifyElement(pNewChild);
		
		EditingDomain editingDomain = ((DiagramDocumentEditor) getPart()).getEditingDomain();
		
		AbstractOverrideableCommand command;
		
		//set class name value
		Object eref = ClassdiagramsPackage.Literals.ASSOCIATION.getEStructuralFeature(ClassdiagramsPackage.ASSOCIATION__NAME);
		
		if (getFeature().isMany() == true){
				command = (AddCommand) AddCommand.create(
						editingDomain,
						eObject, 
						ClassdiagramsPackage.eINSTANCE.getName(), 
						((EventBNamed)pNewChild).getName());
		} else {
			command = (SetCommand) SetCommand.create(
					editingDomain,
					eObject, 
					eref,
					((EventBNamed)pNewChild).getName());
		}
		
		editingDomain.getCommandStack().execute(command);
	}

	@Override
	public String getLOVValue() {
		if (eObject != null && ((Class) eObject).getElaborates() != null) { 
			return ((Class) eObject).getElaborates().getName();
		} else {
			return "no name";
		}
	}

	@Override
	protected EStructuralFeature getFeature() {
		return ClassdiagramsPackage.Literals.ELABORATIVE_ELEMENT__ELABORATES;
	}

	@Override
	protected String getLabelText() {
		return "Elaborates:";
	}

}
