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
import org.eventb.emf.core.EventBNamedCommentedPredicateElement;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.Variable;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.Classdiagram;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.impl.AssociationImpl;
import ac.soton.eventb.classdiagrams.parser.Scanner;
import ac.soton.eventb.classdiagrams.parser.SymbolUtil;
import ac.soton.eventb.classdiagrams.parser.Token;
import ac.soton.eventb.classdiagrams.util.ClassdiagramUtil;
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
			if (element instanceof EventBNamedCommentedDerivedPredicateElement){
				return ((EventBNamedCommentedDerivedPredicateElement)element).getPredicate();
			} else {
				return "not an EventBNamedCommentedDerivedPredicateElement element";				
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
		List<? super EventBNamed> valuesList = new LinkedList<EventBNamed>();
		
		if (container instanceof Machine){
			popupTitle = ((Machine)container).getName();
			
			List<Machine> machines = getAllMachines((Machine)container, new LinkedList<Machine>());
			
			for (Machine m : machines){
				valuesList.addAll(m.getInvariants());
				
				for (Context context : m.getSees()){
					valuesList.addAll(fillValuesListWithContextContents(context));
				}		
				
			}
		} else if (container instanceof Context){

			popupTitle = ((Context)container).getName();
	
			valuesList.addAll(fillValuesListWithContextContents((Context)container));
		}
		
		filterList((EventBNamedCommentedComponentElement)container, valuesList);
		
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
	
	private List<EventBNamed> fillValuesListWithContextContents(Context context) {
		List<EventBNamed> valuesList = new LinkedList<EventBNamed>();
		
		List<Context> contexts = getAllContexts(context, new LinkedList<Context>());
		
		for (Context c : contexts){
			valuesList.addAll(c.getAxioms());
		}
		
		return valuesList;
	}

	private List<Machine> getAllMachines(Machine container, List<Machine> pMachines) {
		pMachines.add(container);		

		List<Machine> machines = container.getRefines();
		
		for (Machine m : machines){
			getAllMachines(m, pMachines);
		}
		
		return pMachines;
	}
	
	private List<Context> getAllContexts(Context container, List<Context> pContexts) {
		pContexts.add(container);
		
		List<Context> machines = container.getExtends();
		
		for (Context c : machines){
			getAllContexts(c, pContexts);
		}
		
		return pContexts;
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
		//TODO pass predicate's assigned variable, NOT the whole invariant!
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
				//variable 'association' must not be already elaborated
				!ClassdiagramUtil.isElaborated(li.get(0).eventBElement) &&	
				//variable1 must be equal to the source element feature of the class element in the classdiagrams
				li.get(2).eventBElement != null && li.get(2).eventBElement.getName().equals( ((AssociationImpl)eObject).getSource().getName()) &&
				//li.get(3) == one of the relation arrows - check whether it is a relation.
				SymbolUtil.isRelation(li.get(3).stringValue)  && 
				//variable2 must be equal to the target element feature of the class element in the classdiagrams
				li.get(4).eventBElement != null && li.get(4).eventBElement.getName().equals( ((AssociationImpl)eObject).getTarget().getName())
				){
				
				filteredList.add((EventBNamedCommentedPredicateElement)eb);
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
				
				if (eObject != null && 
						((Association)eObject).getElaborates() != null){
						lovText.setEnabled(false);
				} else {
						lovText.setEnabled(true);
				}
			}
			
		});
		
		refresh();
	}
	
	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
	 */
	public void refresh() {
		super.refresh();
		EventBNamed generated;

		if (eObject != null && (((Association)eObject).getElaborates() == null) && 
			((generated = getGenerated((EventBNamed)eObject)) != null)){
			
			setElaborates(generated);
		}
	}
	
	public EventBNamed getGenerated(EventBNamed pEventBNamed) {
		EObject container = EcoreUtil.getRootContainer(pEventBNamed);
		List<EventBElement> objectsToCompare = new LinkedList<EventBElement>();
		
		if (container instanceof Machine){
			objectsToCompare.addAll( ((Machine)container).getVariables());
		} else if (container instanceof Context){
			objectsToCompare.addAll( ((Context)container).getConstants());
		}
		
		for (EventBElement e : objectsToCompare){
			if (e.isGenerated() && 
				e.isLocalGenerated() && 
				e instanceof EventBNamed &&
				((EventBNamed)e).getName() != null &&
				((EventBNamed)e).getName().equals(pEventBNamed.getName())){
				return (EventBNamed)e;
			}
		}
		
		return null;
	}
	
	private void setElaborates(EventBNamed pEventBnamed){
		EditingDomain editingDomain = ((DiagramDocumentEditor) getPart()).getEditingDomain();
		
		AbstractOverrideableCommand command;
		
		command = (SetCommand) SetCommand.create(
				editingDomain,
				eObject, 
				getFeature(),
				pEventBnamed);
		
		editingDomain.getCommandStack().execute(command);
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
