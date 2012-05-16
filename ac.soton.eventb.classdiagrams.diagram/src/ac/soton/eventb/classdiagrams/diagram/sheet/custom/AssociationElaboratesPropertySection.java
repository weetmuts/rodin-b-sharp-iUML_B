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
import java.util.StringTokenizer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.EventBNamedCommentedDerivedPredicateElement;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.Variable;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.Classdiagram;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.impl.AssociationImpl;
import ac.soton.eventb.classdiagrams.parser.Scanner;
import ac.soton.eventb.classdiagrams.parser.Token;
import ac.soton.eventb.classdiagrams.ElaborativeElement;
import org.eclipse.swt.widgets.Text;

import org.eventb.emf.core.machine.Invariant;

/**
 * Elaborates property section for Classdiagrams.
 * 
 * @author vitaly
 * 
 */
public class AssociationElaboratesPropertySection extends AbstractLOVPropertySection {

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
		
		//TODO filter to show only relevant elements! 
		if (container instanceof Machine){
			Machine machine = (Machine) container;
			
			popupTitle = machine.getName();
			valuesList.addAll(machine.getInvariants());
			
			for (Context context : machine.getSees()){
				valuesList.addAll(context.getAxioms());
			}
			
		} else if (container instanceof Context){
			Context context = (Context)container;
			
			popupTitle = context.getName();
			
			valuesList.addAll(context.getAxioms());
		}
		
		filterList((EventBNamedCommentedComponentElement)container, valuesList);
		
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
	
	protected void clearElement(){
		super.clearElement();
		
		EditingDomain editingDomain = ((DiagramDocumentEditor) getPart()).getEditingDomain();
		
		AbstractOverrideableCommand command;
		
		//change association name value
		
		Object eref = ClassdiagramsPackage.Literals.ASSOCIATION.getEStructuralFeature(ClassdiagramsPackage.ASSOCIATION__NAME);
		
		if (getFeature().isMany() == true){
				command = (AddCommand) AddCommand.create(
						editingDomain,
						eObject, 
						ClassdiagramsPackage.eINSTANCE.getName(), 
						"changeMe");
		} else {
			command = (SetCommand) SetCommand.create(
					editingDomain,
					eObject, 
					eref,
					"changeMe");
		}
		
		editingDomain.getCommandStack().execute(command);
	}

	
	protected void modifyElement(Object pNewChild){
		super.modifyElement(pNewChild);
		
		EditingDomain editingDomain = ((DiagramDocumentEditor) getPart()).getEditingDomain();
		
		AbstractOverrideableCommand command;
		
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

	private void filterList(EventBNamedCommentedComponentElement pContainer, List<? super EventBNamed> pValuesList) {
		List<EventBNamed> filteredList = new LinkedList<EventBNamed>();
		
		
		//for every list element
		for (Object eb : pValuesList){
			
			//get the predicate string
			String predicate = ((EventBNamedCommentedDerivedPredicateElement)eb).getPredicate();
			
			//parse it into Tokens
			Scanner s = new Scanner((EventBNamedCommentedComponentElement)pContainer, predicate);
			List<Token> li = new LinkedList<Token>();

			while (s.hasMoreElements()){
				li.add(s.nextElement());
			}
			
			//shortlist valid elements for elaboration
			//standard association definition got 5 elements:  association = variable1 <assoc type> variable2
			if (li.size() == 5 &&  
				//variable1 must be equal to the source element feature of the class element in the classdiagrams
				li.get(2).eventBElement.getName().equals( ((AssociationImpl)eObject).getSource().getName()) &&
				//variable2 must be equal to the target element feature of the class element in the classdiagrams
				li.get(4).eventBElement.getName().equals( ((AssociationImpl)eObject).getTarget().getName()) 
//TODO			li.get(3) == one of the relation arrows - check whether it is a relation.
				){
				
				filteredList.add((EventBNamed)eb);
			}
		}
		
		pValuesList.clear();
		pValuesList.addAll(filteredList);
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

	@Override
	public String getLOVValue() {
		if (eObject != null && ((Association) eObject).getElaborates() != null) { 
			return ((Association) eObject).getElaborates().getName();
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
