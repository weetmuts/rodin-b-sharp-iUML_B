package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.machine.Variable;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.diagram.part.ClassdiagramsDiagramEditor;

/**
 * General text property section, used for string properties of an object.
 * 
 * @author vitaly
 * 
 */
public abstract class AbstractLOVPropertySection extends
		AbstractClassPropertySection {

	/**
	 * the table control for the section.
	 */
	protected Text lovText;

	/**
	 * the add button for the section.
	 */
	protected Button addButton;

	/**
	 * the remove button for the section.
	 */
	protected Button clearButton;

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#createControls(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	public void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		Composite composite = getWidgetFactory()
				.createFlatFormComposite(parent);
		FormData data;
		int labelWidth = getPropertyLabelWidth(composite);

		// TODO substitute with the textfield!

		lovText = getWidgetFactory().createText(composite, ""); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 100);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		lovText.setLayoutData(data);
		lovText.setEditable(false);
		// labelText.addModifyListener(listener);

		CLabel labelLabel = getWidgetFactory().createCLabel(composite,
				"Elaborates:"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(lovText,
				-ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(lovText, 0, SWT.CENTER);
		labelLabel.setLayoutData(data);

		addButton = getWidgetFactory().createButton(composite, "Elaborate",
				SWT.PUSH);
		data = new FormData();
		data.left = new FormAttachment(0, 100);
		// data.right = new FormAttachment(20, 0);
		// data.bottom = new FormAttachment(100, -5);
		data.top = new FormAttachment(lovText, 0);
		addButton.setLayoutData(data);
		
		addButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				
				executeAddButtonAction();
			}	
		
		});
		
		clearButton = getWidgetFactory().createButton(composite, "Clear",
				SWT.PUSH);
		data = new FormData();
		data.left = new FormAttachment(addButton, 0);
		// data.right = new FormAttachment(0, 0);
		// data.bottom = new FormAttachment(0, 0);
		data.top = new FormAttachment(lovText, 0);
		clearButton.setLayoutData(data);
		
		clearButton.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent event) {
				clearElement();
			}
		});

	}

	protected void clearElement() {
		EditingDomain editingDomain = ((ClassdiagramsDiagramEditor) getPart()).getEditingDomain();
		
		AbstractOverrideableCommand command;
		
		if (getFeature().isMany() == true){
			command = (AddCommand) AddCommand.create(editingDomain, eObject, getFeature(), null);
		} else {
			command = (SetCommand) SetCommand.create(editingDomain, eObject, getFeature(), null);
		}
		
		editingDomain.getCommandStack().execute(command);
	}

	protected void executeAddButtonAction() {
		Object newChild = getNewChild();
		if (newChild == null){
			return;
		}
		
		modifyElement(newChild);
	}

	protected void modifyElement(Object pNewChild) {
		EditingDomain editingDomain = ((DiagramDocumentEditor) getPart()).getEditingDomain();
		
		AbstractOverrideableCommand command;
		
		if (getFeature().isMany() == true){
				command = (AddCommand) AddCommand.create(editingDomain, eObject, getFeature(), pNewChild);
		} else {
				command = (SetCommand) SetCommand.create(editingDomain, eObject, getFeature(), pNewChild);
		}
		
		editingDomain.getCommandStack().execute(command);
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
	 */
	public void refresh() {
		lovText.setText(getLOVValue());
	}

	/**
	 * 
	 */
	abstract public String getLOVValue();
	
	/**
	 * 
	 */
	abstract protected Object getNewChild();
	
	@Override
	abstract protected EStructuralFeature getFeature();
	
	public Text getTextWidget(){
		return lovText;
	}
}
