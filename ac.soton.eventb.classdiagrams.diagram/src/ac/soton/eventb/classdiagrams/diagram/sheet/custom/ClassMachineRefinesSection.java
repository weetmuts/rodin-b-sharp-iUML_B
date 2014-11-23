package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import java.util.Iterator;
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
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.EventBObject;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.emf.diagrams.sheet.AbstractLOVPropertySection;

public class ClassMachineRefinesSection extends AbstractLOVPropertySection {
	
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
		EventBObject container = eObject instanceof EventBObject? ((EventBObject)eObject).getContaining(CorePackage.Literals.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT):null;
		String popupTitle = "no name";
		List<EventBNamed> valuesList = new LinkedList<EventBNamed>() ;
		
		
		if (container instanceof Machine){
			List<Machine> machines = ((Machine) container).getRefines();
			
			if (machines != null && machines.size() > 0){
				Machine machine = machines.get(0);
				popupTitle = machine.getName();
				
				List<?> li =  machine.getAllContained(ClassdiagramsPackage.Literals.CLASS, false);
				
				for (Object o : li){
					if (o != null){
						valuesList.add((EventBNamed)o);						
					}
				}
			}
			
		}
		
		filterList((EventBNamedCommentedComponentElement)container, valuesList);
		
		
		//TODO limit only to a single selection
		PopupDialog variablesDialog = new PopupDialog(getPart().getSite()
				.getShell(), valuesList, variableLabelProvider);
		variablesDialog.setTitle(popupTitle + " elements");
		variablesDialog.setMessage("Please select an element to refine");
		
		if (Dialog.OK == variablesDialog.open()) {
			if (variablesDialog.getResult().length > 0){
				return variablesDialog.getResult()[0]; 
			}
		}
		return null;
	}
	
	private void filterList(EventBNamedCommentedComponentElement pContainer, List<EventBNamed> pValuesList) {
		List<EventBNamed> filteredList = new LinkedList<EventBNamed>();
		
		
		//for every list element, check whether it is elaborated
		for (EventBNamed eb : pValuesList){
			
			if (!isRefined(pContainer, eb)){	
				filteredList.add((EventBNamed)eb);
			}
		}
		
		pValuesList.clear();
		pValuesList.addAll(filteredList);
	}
	
	public static boolean isRefined(EventBNamedCommentedComponentElement pContainer, EventBNamed pEventBNamed){
		
		Iterator<EObject> iter = pContainer.eAllContents(); 
		EObject o;
		Class ebn;
		
		while (iter.hasNext()){
			o = iter.next();
			
			if (o instanceof Class && ((Class)o).getRefines() != null){
				ebn = ((Class)o).getRefines();
				
				if ((ebn.getClass() == pEventBNamed.getClass()) &&
					(ebn.getName() != null) &&	
					(ebn.getName().equals(pEventBNamed.getName()))){
					
					return true;
				}
			}
		}
	
	return false;
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
	}

	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		getTextWidget().addModifyListener(new ModifyListener(){

			@Override
			public void modifyText(ModifyEvent e) {
				if (eObject != null && ((Class)eObject).getRefines() != null){
					addButton.setEnabled(false);
					clearButton.setEnabled(true);
				} else {
					addButton.setEnabled(true);
					clearButton.setEnabled(false);
				}
				
				if (eObject != null && 
					(((Class)eObject).getRefines() != null || 
					((Class)eObject).getElaborates() != null)){
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

		if (eObject != null && (((Class)eObject).getElaborates() == null) && 
			((generated = getGenerated((EventBNamed)eObject)) != null)){
			
			setRefines(generated);
		}
	}
	
	public EventBNamed getGenerated(EventBNamed pEventBNamed) {
		EventBObject container = pEventBNamed instanceof EventBObject? ((EventBObject)pEventBNamed).getContaining(CorePackage.Literals.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT):null;
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
	
	@Override
	public String getLOVValue() {
		if (eObject != null && ((Class) eObject).getRefines() != null) { 
			return ((Class) eObject).getRefines().getName();
		} else {
			return "no name";
		}
	}

	@Override
	protected EStructuralFeature getFeature() {
		return ClassdiagramsPackage.Literals.CLASS__REFINES;
	}

	@Override
	protected String getLabelText() {
		return "Refines:";
	}
	
	protected  String getClearButtonLabel() {
		return "Clear";
	}

	protected String getPickValueButtonLabel() {
		return "Refine";
	}

	protected String getLOVLabel() {
		return "Refines:";
	}
	
	private void setRefines(EventBNamed pEventBnamed){
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
