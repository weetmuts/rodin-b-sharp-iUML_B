/**
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.sheet.custom;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eventb.emf.core.EventBElement;

/**
 * Abstract property section for a feature of statemachines.
 * 
 * @author vitaly
 *
 */
public abstract class AbstractStatemachinesPropertySection extends
		AbstractModelerPropertySection {
	
	/**
	 * the property sheet page for this section.
	 */
	protected TabbedPropertySheetPage propertySheetPage;

	/**
	 * the GMF editing domain for the current diagram editor
	 */
	protected TransactionalEditingDomain editingDomain = null;

	/**
	 * The currently selected EventBElement or the first object in the selection
	 * when multiple objects are selected.
	 */
	protected EventBElement owner;

	/**
	 *
	 */
	protected Composite parent;
	
	
	@Override
	protected EObject unwrap(Object object) {
		return StatemachinesSheetPropertyFilter.unwrap(object);
	}

	/**
	 * Get section label width.
	 * Standard implementation uses label to calculate its width.
	 * Subclasses may override.
	 * 
	 * @param composite
	 * @return label width
	 */
	protected int getPropertyLabelWidth(Composite composite) {
		return 100;
//		return getStandardLabelWidth(composite,
//			new String[] {getLabelText()});
	}

	/**
	 * Get label of a section.
	 * 
	 * @return the label of section
	 */
	protected abstract String getLabelText();

	/**
	 * Get feature of a section.
	 * 
	 * @return the feature of section object
	 */
	protected abstract EStructuralFeature getFeature();



	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage propertySheetPage) {
		super.createControls(parent, propertySheetPage);
		this.parent = parent;
		this.propertySheetPage = propertySheetPage;
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (activeEditor instanceof DiagramEditor) {
			editingDomain = ((DiagramEditor) activeEditor).getEditingDomain();
		}
	}
	
	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		if (eObject instanceof EventBElement){
			owner = (EventBElement)eObject;
		}
	}

}