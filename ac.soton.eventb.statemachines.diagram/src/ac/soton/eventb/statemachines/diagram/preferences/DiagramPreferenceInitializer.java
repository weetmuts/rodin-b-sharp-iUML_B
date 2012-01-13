/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import ac.soton.eventb.statemachines.diagram.part.StatemachinesDiagramEditorPlugin;
import ac.soton.eventb.statemachines.diagram.preferences.custom.DiagramBehaviourPreferencePage;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * @generated
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		DiagramGeneralPreferencePage.initDefaults(store);
		DiagramAppearancePreferencePage.initDefaults(store);
		DiagramConnectionsPreferencePage.initDefaults(store);
		DiagramPrintingPreferencePage.initDefaults(store);
		DiagramRulersAndGridPreferencePage.initDefaults(store);
		DiagramBehaviourPreferencePage.initDefaults(store);

	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return StatemachinesDiagramEditorPlugin.getInstance()
				.getPreferenceStore();
	}
}
