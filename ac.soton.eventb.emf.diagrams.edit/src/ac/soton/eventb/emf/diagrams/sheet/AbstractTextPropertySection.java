/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package ac.soton.eventb.emf.diagrams.sheet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractBasicTextPropertySection;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.rodinp.keyboard.ui.RodinKeyboardUIPlugin;
import org.rodinp.keyboard.ui.preferences.PreferenceConstants;

import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;

/**
 * General text property section, used for string properties of an object.
 * 
 *
 */
public abstract class AbstractTextPropertySection extends
		AbstractBasicTextPropertySection {

	final int TEXT_MARGIN = 3;
	
	@Override
	protected EObject unwrap(Object object) {
		return DiagramUtils.unwrap(object);
	}
	
	@Override
	protected Text createTextWidget(Composite parent) {
		Text text;
		if (numberOfRows()>1){
			text = getWidgetFactory().createText(parent, StringStatics.BLANK, SWT.MULTI); //$NON-NLS-1$
			text.addListener(SWT.MeasureItem, new Listener() {
				@Override
				public void handleEvent(Event event) {
					Text item = (Text)event.item;
					String text = item.getText();
					Point size = event.gc.textExtent(text);
					event.width = size.x + 2 * TEXT_MARGIN;
					event.height = Math.max(event.height, size.y + TEXT_MARGIN);
				}

			});
			text.addListener(SWT.EraseItem, new Listener() {
				@Override
				public void handleEvent(Event event) {
					event.detail &= ~SWT.FOREGROUND;
				}
			});
//			text.addListener(SWT.PaintItem, new Listener() {
//				@Override
//				public void handleEvent(Event event) {
//					Text item = (Text)event.item;
//					String text = item.getText();
//					/* center column 1 vertically */
//					int yOffset = 0;
////					if (event.index == 1) {
////						Point size = event.gc.textExtent(text);
////						yOffset = Math.max(0, (event.height - size.y) / 2);
////					}
//					event.gc.drawText(text, event.x + TEXT_MARGIN, event.y + yOffset, true);
//				}
//			});
		}else{
			text = getWidgetFactory().createText(parent, StringStatics.BLANK); //$NON-NLS-1$			
		}
		FormData data = new FormData();
		data.left = new FormAttachment(0, getPropertyLabelWidth(parent));
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, 0);
		//GC gc = new GC(text);
		//int height = gc.getFontMetrics().getHeight();
		//data.height = numberOfRows()*height;
		text.setLayoutData(data);
		if (isRodinKeyboard()) {
			text.setFont(JFaceResources.getFont(PreferenceConstants.RODIN_MATH_FONT));
			text.addModifyListener(RodinKeyboardUIPlugin.getDefault().createRodinModifyListener());
		}
		if (isReadOnly())
			text.setEditable(false);
		//gc.dispose();
		return text;
	}

	/**
	 * By default the text field is NOT treated as a Rodin Keyboard.
	 * This method should be overridden to return true if the Rodin key combo modification is required.
	 * 
	 * @return whether or not to use a Rodin Keyboard modify listener for this text
	 */
	protected boolean isRodinKeyboard(){return false;}
	
	/**
	 * Returns width of property label.
	 * Standard implementation uses label text width to calculate the width.
	 * Subclasses may overrride.
	 * 
	 * @param parent
	 * @return
	 */
	private int getPropertyLabelWidth(Composite parent) {
		return 100;
	}

	/**
	 * Override to return more than 1 for a multi line text widget
	 * @return
	 */
	protected int numberOfRows(){
		return 1;
	}
}