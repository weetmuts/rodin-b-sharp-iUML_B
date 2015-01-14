/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.common.ui.util.StatusLineUtil;
import org.eclipse.gmf.runtime.diagram.ui.properties.views.TextChangeHelper;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eventb.emf.core.machine.Action;
import org.eventb.emf.core.machine.Guard;
import org.eventb.emf.core.machine.Witness;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassConstraint;
import ac.soton.eventb.classdiagrams.ClassMethod;
import ac.soton.eventb.emf.diagrams.sheet.AbstractTextPropertySection;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;

/**
 * SelfName property section for Class.
 * 
 * @author cfs
 *
 */
public class SelfNamePropertySection extends AbstractTextPropertySection {

	/**
	 * Element Filter for this property section.
	 */
	public static final class Filter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof Class;
		}
	}
	@Override
	protected String getPropertyNameLabel() {
		return "Self Name:";
	}
	
	@Override
	protected void setPropertyValue(EObject object, Object value) {
		assert object instanceof Class;
		refactor((Class) object, ((Class) object).getSelfName(), (String)value);
		((Class) object).setSelfName((String)value);
	}

	private void refactor(Class cl, String oldSelfName, String newSelfName) {
		for (ClassConstraint inv : cl.getConstraints()){
			inv.setPredicate(refactor(inv.getPredicate(), oldSelfName, newSelfName));
		}
		for (ClassMethod cm : cl.getMethods()){
			for (Guard g : cm.getGuards()){
				g.setPredicate(refactor(g.getPredicate(), oldSelfName, newSelfName));				
			}
			for (Action a : cm.getActions()){
				a.setAction(refactor(a.getAction(), oldSelfName, newSelfName));				
			}
			for (Witness w : cm.getWitnesses()){
				w.setPredicate(refactor(w.getPredicate(), oldSelfName, newSelfName));				
			}
		}
		
	}

	private String refactor(String string, String oldSelfName, String newSelfName) {
		return 	string.replaceAll("(\\W)"+oldSelfName+"(?!\\w)", "$1"+newSelfName);
	}

	@Override
	protected String getPropertyValueString() {
		return ((Class) getEObject()).getSelfName();
	}

	@Override
	protected String getPropertyChangeCommandName() {
		return "change selfName";
	}

	@Override
	protected boolean isReadOnly() {
		return super.isReadOnly() || (eObject !=null && ((Class) eObject).getRefines() != null) ;
	}
	
	
	///////// FIX problem with selfName text changing to Class name when selected /////
	// This problem occurred when clicking in the text box for the Self Name property.
	// The text field immediately changed to the Class name and would not reset until
	// the property sheet was redrawn (e.g. by selecting a different kind of element
	// in the diagram).
	
	/**
	 * @return Returns the new listener.
	 */
	protected TextChangeHelper getListener() {
		return newlistener;
	}
	
	/**
	 * A helper to listen for events that indicate that a text field has been
	 * changed.
	 */
	private TextChangeHelper newlistener = new TextChangeHelper() {
		boolean textModified = false;
		/**
		 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
		 */
		public void handleEvent(Event event) {
			switch (event.type) {
				case SWT.Modify :
					textModified = !isNonUserChange();
					break;
				case SWT.KeyDown :
					if (event.character == SWT.CR) {
						textChanged((Control)event.widget);
					}
					break;
				case SWT.FocusOut :
					textChanged((Control)event.widget);
					refresh();							//this refresh added to solve default text changing problem
					break;
			}
		}
		
		public void textChanged(Control control) {
			if (textModified) {
				// clear error message
				IWorkbenchPart part = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage().getActivePart();
				StatusLineUtil.outputErrorMessage(part, StringStatics.BLANK);

				setPropertyValue(control);
				textModified = false;
			}
		}		
	};
}
