/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.common.ui.dialogs.PopupDialog;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.EventBObject;
import org.eventb.emf.core.context.CarrierSet;
import org.eventb.emf.core.context.Constant;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.Variable;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassType;
import ac.soton.eventb.classdiagrams.Classdiagram;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.ElaborativeElement;
import ac.soton.eventb.classdiagrams.diagram.part.ClassdiagramsDiagramEditor;
import ac.soton.eventb.classdiagrams.util.ClassdiagramUtil;

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
		List<EventBNamed> valuesList = new LinkedList<EventBNamed>() ;
		
		
		if (container instanceof Machine){
			popupTitle = ((Machine)container).getName();
			
			List<Machine> machines = getAllMachines((Machine)container, new LinkedList<Machine>());
			
			for (Machine m : machines){
				valuesList.addAll(m.getVariables());
				
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
	
	private void filterList(EventBNamedCommentedComponentElement pContainer, List<EventBNamed> pValuesList) {
		List<EventBNamed> filters = new LinkedList<EventBNamed>();
		EObject diagram = ((Class)eObject).getContaining(ClassdiagramsPackage.Literals.CLASSDIAGRAM);
		if (diagram instanceof Classdiagram){
			for (EObject diagramElement : ((Classdiagram)diagram).getAllContained(CorePackage.Literals.EVENT_BELEMENT, true) ){
				if (diagramElement instanceof ElaborativeElement &&
						((ElaborativeElement)diagramElement).getElaborates()!= null ){
					filters.add(((ElaborativeElement)diagramElement).getElaborates());
				}
			}
		}
		pValuesList.removeAll(filters);
	}

	private List<EventBNamed> fillValuesListWithContextContents(Context context) {
		List<EventBNamed> valuesList = new LinkedList<EventBNamed>();
		
		List<Context> contexts = getAllContexts(context, new LinkedList<Context>());
		
		for (Context c : contexts){
			valuesList.addAll(c.getConstants());
			valuesList.addAll(c.getSets());	
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
				
				//if refined or elaborated, disable text editing
				if (eObject != null && 
						(((Class)eObject).getRefines() != null || 
						((Class)eObject).getElaborates() != null)){
						lovText.setEnabled(false);
//						lovText.setForeground(ColorConstants.gray);
				} else {
						lovText.setEnabled(true);
//						lovText.setForeground(ColorConstants.black);
				}
			}
			
		});
		
		refresh();
	}

	@Override
	protected void clearElement() {
		super.clearElement();
		EditingDomain editingDomain = ((ClassdiagramsDiagramEditor) getPart()).getEditingDomain();
		AbstractOverrideableCommand command;
		EventBNamed generated = getGenerated((EventBNamed)eObject);
		if (generated instanceof EObject){
			command = (RemoveCommand) RemoveCommand.create(editingDomain, ((EObject)generated).eContainer(), ((EObject)generated).eContainingFeature(), generated);
			editingDomain.getCommandStack().execute(command);
		}
	}
	
	protected void modifyElement(Object pNewChild){
		super.modifyElement(pNewChild);
		
		EditingDomain editingDomain = ((DiagramDocumentEditor) getPart()).getEditingDomain();
		
		AbstractOverrideableCommand command;
		
		//set class name value
		Object eref = ClassdiagramsPackage.Literals.CLASS.getEStructuralFeature(ClassdiagramsPackage.CLASS__NAME);
		
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
		
		//AbstractOverrideableCommand command2;
		
		//set type to match new elaborated element
		ClassType type = null;
		EventBElement elaboratedElement = ((EventBElement)pNewChild);
		if (elaboratedElement instanceof CarrierSet) type = ClassType.SET;
		else if (elaboratedElement instanceof Constant) type = ClassType.CONSTANT;
		else if (elaboratedElement instanceof Variable) type = ClassType.VARIABLE;
		command = (SetCommand) SetCommand.create(
				editingDomain,
				eObject, 
				ClassdiagramsPackage.Literals.CLASS__CLASS_TYPE,
				type);;
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
	
	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
	 */
	public void refresh() {
		super.refresh();
		EventBNamed generated;

		if (eObject != null && (((Class)eObject).getElaborates() == null) && 
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
	
}
