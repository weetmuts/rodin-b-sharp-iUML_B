/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import javax.swing.text.StyleConstants.ColorConstants;
import javax.xml.soap.Text;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.EventBNamedCommentedElement;

import ac.soton.eventb.classdiagrams.ElaborativeElement;

/**
 * Name property section for EventBNamed.
 * 
 * @author vitaly
 *
 */
public class NamePropertySection extends AbstractTextPropertySection {

	@Override
	protected String getPropertyNameLabel() {
		return "Name:";
	}

	public void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		doCreateControls(parent, aTabbedPropertySheetPage);
		
		getTextWidget().addModifyListener(new ModifyListener(){

			@Override
			public void modifyText(ModifyEvent e) {
				
				EventBNamed ebn = (EventBNamed) eObject;
				
				if (ebn instanceof ElaborativeElement){
					ElaborativeElement ee = (ElaborativeElement)ebn;
					if (ee.getElaborates() != null){
//						ebn.setName(ee.getElaborates().getName());
						getTextWidget().setEditable(false);
					} else {
						getTextWidget().setEditable(true);
					}
				}
			}
			
		});
	}
	
	@Override
	protected void setPropertyValue(EObject object, Object value) {
		assert object instanceof EventBNamed;
		
		((EventBNamed) object).setName((String) value);
	}

	@Override
	protected String getPropertyValueString() {
		return ((EventBNamed) getEObject()).getName();
	}

	@Override
	protected String getPropertyChangeCommandName() {
		return "change name";
	}

	
	@Override
	public void handleElementModifiedEvent(Notification notification,
			EObject element) {
		// TODO Auto-generated method stub
		super.handleElementModifiedEvent(notification, element);
	}
	
	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		super.refresh();
		
		if (eObject instanceof ElaborativeElement && ((ElaborativeElement) eObject).getElaborates() != null){
			getTextWidget().setForeground(org.eclipse.draw2d.ColorConstants.gray);
			getTextWidget().setEnabled(false);
		} else {
			getTextWidget().setForeground(org.eclipse.draw2d.ColorConstants.black);
			getTextWidget().setEnabled(true);
		}
	}
}
