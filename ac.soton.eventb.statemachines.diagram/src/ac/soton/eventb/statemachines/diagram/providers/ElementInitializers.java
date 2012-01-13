/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.providers;

import ac.soton.eventb.statemachines.diagram.part.StatemachinesDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = StatemachinesDiagramEditorPlugin
				.getInstance().getElementInitializers();
		if (cached == null) {
			StatemachinesDiagramEditorPlugin.getInstance()
					.setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
