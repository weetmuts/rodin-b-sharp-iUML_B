package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.ui.dialogs.PopupDialog;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;

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
	@SuppressWarnings("unchecked")
	protected Object getNewChild() {
		EObject container = EcoreUtil.getRootContainer(eObject);
		String popupTitle = "no name";
		List<? super EventBNamed> valuesList = new LinkedList<EventBNamed>() ;
		
		
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
			}
			
		});
		
		refresh();
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
	
}
