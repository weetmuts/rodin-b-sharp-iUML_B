/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.preferences.custom;

import org.eclipse.gmf.runtime.common.ui.preferences.AbstractPreferencePage;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import ac.soton.eventb.statemachines.diagram.part.StatemachinesDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramBehaviourPreferencePage extends AbstractPreferencePage {

	private static final String AUTOSAVE_SETTINGS_GROUP_LABEL = "Autosaving";

	private static final String AUTOSAVE_ON_DEACTIVATE_LABEL = "Autosave when editor is deactiveated";

	private BooleanFieldEditor autosaveOnEditorDeactivation;

	/**
	 * @generated
	 */
	public DiagramBehaviourPreferencePage() {
		setPreferenceStore(StatemachinesDiagramEditorPlugin.getInstance()
				.getPreferenceStore());
	}

	/**
	 * @generated NOT
	 */
	protected void addFields(Composite parent) {
		addAutosaveFields(parent);
	}

	/**
	 * Adds autosave group fields to parent control.
	 * 
	 * @param parent
	 */
	private void addAutosaveFields(Composite parent) {
		// Create a Group to hold the autosave fields
		Group group = new Group(parent, SWT.NONE);
		group.setText(AUTOSAVE_SETTINGS_GROUP_LABEL);

		GridLayout gridLayout = new GridLayout(2, false);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 2;

		// Add the fields to the group		

		autosaveOnEditorDeactivation = new BooleanFieldEditor(
				IStatemachinesPreferenceConstants.PREF_AUTOSAVE_ON_DEACTIVATE,
				AUTOSAVE_ON_DEACTIVATE_LABEL, group);
		addField(autosaveOnEditorDeactivation);

		group.setLayoutData(gridData);
		group.setLayout(gridLayout);
	}

	/**
	 * @generated
	 */
	protected void initHelp() {
		// TODO implement this method if needed, or leave as no-op
	}

	/**
	 * @generated NOT
	 */
	public static void initDefaults(IPreferenceStore store) {
		store.setDefault(
				IStatemachinesPreferenceConstants.PREF_AUTOSAVE_ON_DEACTIVATE,
				true);
	}

}
