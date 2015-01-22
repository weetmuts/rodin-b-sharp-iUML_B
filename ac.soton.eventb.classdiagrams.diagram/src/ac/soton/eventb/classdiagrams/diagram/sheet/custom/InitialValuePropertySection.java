/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IFilter;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.emf.core.extension.coreextension.DataKind;
import ac.soton.eventb.emf.core.extension.coreextension.EventBNamedCommentedDataElaborationElement;
import ac.soton.eventb.emf.diagrams.sheet.AbstractTextPropertySection;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;

/**
 * SelfName property section for Class.
 * 
 * @author cfs
 *
 */
public class InitialValuePropertySection extends AbstractTextPropertySection {

	/**
	 * Element Filter for this property section.
	 */
	public static final class Filter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			EObject model = DiagramUtils.unwrap(toTest);
			return (model instanceof Association || model instanceof ClassAttribute);
		}
	}
	@Override
	protected String getPropertyNameLabel() {
		return "Initial Value:";
	}
	
	@Override
	protected void setPropertyValue(EObject object, Object value) {
		if (eObject instanceof Association){
			((Association)eObject).setInitialValue((String)value);
		}else if (eObject instanceof ClassAttribute){
			((ClassAttribute)eObject).setInitialValue((String)value);
		}
	}

	@Override
	protected String getPropertyValueString() {
		String ret = null;
		if (((EventBNamedCommentedDataElaborationElement)eObject).getDataKind()!=DataKind.VARIABLE){
			return "";
		}
		if (eObject instanceof Association){
			ret= ((Association)eObject).getInitialValue();
		}else if (eObject instanceof ClassAttribute){
			ret= ((ClassAttribute)eObject).getInitialValue();
		}
		return ret==null? "":ret;
	}

	@Override
	protected String getPropertyChangeCommandName() {
		return "change initialValue";
	}
	
	@Override
	protected boolean isReadOnly() {
		return super.isReadOnly() || 
				(eObject instanceof EventBNamedCommentedDataElaborationElement && 
						((EventBNamedCommentedDataElaborationElement)eObject).getDataKind()!=DataKind.VARIABLE
				) ;
	}
	
//	///////// FIX problem with selfName text changing to Class name when selected /////
//	// This problem occurred when clicking in the text box for the Self Name property.
//	// The text field immediately changed to the Class name and would not reset until
//	// the property sheet was redrawn (e.g. by selecting a different kind of element
//	// in the diagram).
//	
//	/**
//	 * @return Returns the new listener.
//	 */
//	@Override
//	protected TextChangeHelper getListener() {
//		return newlistener;
//	}
//	
//	/**
//	 * A helper to listen for events that indicate that a text field has been
//	 * changed.
//	 */
//	private TextChangeHelper newlistener = new TextChangeHelper() {
//		boolean textModified = false;
//		/**
//		 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
//		 */
//		public void handleEvent(Event event) {
//			switch (event.type) {
//				case SWT.Modify :
//					textModified = !isNonUserChange();
//					break;
//				case SWT.KeyDown :
//					if (event.character == SWT.CR) {
//						textChanged((Control)event.widget);
//					}
//					break;
//				case SWT.FocusOut :
//					textChanged((Control)event.widget);
//					refresh();							//this refresh added to solve default text changing problem
//					break;
//			}
//		}
//		
//		public void textChanged(Control control) {
//			if (textModified) {
//				// clear error message
//				IWorkbenchPart part = PlatformUI.getWorkbench()
//					.getActiveWorkbenchWindow().getActivePage().getActivePart();
//				StatusLineUtil.outputErrorMessage(part, StringStatics.BLANK);
//
//				setPropertyValue(control);
//				textModified = false;
//			}
//		}		
//	};
}
