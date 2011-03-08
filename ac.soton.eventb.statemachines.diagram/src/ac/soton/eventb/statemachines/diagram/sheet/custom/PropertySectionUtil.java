/**
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.sheet.custom;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Font;
import org.rodinp.keyboard.RodinKeyboardPlugin;
import org.rodinp.keyboard.preferences.PreferenceConstants;

/**
 * Utility class for property sections.
 * 
 * @author vitaly
 *
 */
public final class PropertySectionUtil {
	
	public static final ModifyListener eventBListener = RodinKeyboardPlugin.getDefault().createRodinModifyListener();
	public static final Font rodinFont = JFaceResources.getFont(PreferenceConstants.RODIN_MATH_FONT);
}
