/*
 * Copyright (c) 2010-2015 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.preferences;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.common.ui.preferences.AbstractPreferencePage;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;

import ac.soton.eventb.statemachines.diagram.part.StatemachinesDiagramEditorPlugin;

/**
 * @generated
 */
public class SpecificDiagramAppearancePreferencePage extends
		AbstractPreferencePage {

	// Not much is generated.. we have to provide these fields by hand coding
	// (mostly inspired by org.eclipse.gmf.runtime.diagram.ui.preferences)

	private static String STATEMACHINE_FILL_COLOR_LABEL = PreferencePageMessages.PreferencePage_statemachineFillColor_label;
	private static String REFINED_STATEMACHINE_FILL_COLOR_LABEL = PreferencePageMessages.PreferencePage_refinedStatemachineFillColor_label;
	private static String STATE_FILL_COLOR_LABEL = PreferencePageMessages.PreferencePage_stateFillColor_label;
	private static String REFINED_STATE_FILL_COLOR_LABEL = PreferencePageMessages.PreferencePage_refinedStateFillColor_label;
	private static String INITIAL_FILL_COLOR_LABEL = PreferencePageMessages.PreferencePage_initialFillColor_label;
	private static String FINAL_FILL_COLOR_LABEL = PreferencePageMessages.PreferencePage_finalFillColor_label;
	private static String ANY_FILL_COLOR_LABEL = PreferencePageMessages.PreferencePage_anyFillColor_label;
	private static String JUNCTION_FILL_COLOR_LABEL = PreferencePageMessages.PreferencePage_junctionFillColor_label;
	private static String FORK_FILL_COLOR_LABEL = PreferencePageMessages.PreferencePage_forkFillColor_label;
	private static String TRANSITION_FILL_COLOR_LABEL = PreferencePageMessages.PreferencePage_transitionFillColor_label;
	private static String STATEMACHINE_LINE_COLOR_LABEL = PreferencePageMessages.PreferencePage_statemachineLineColor_label;
	private static String REFINED_STATEMACHINE_LINE_COLOR_LABEL = PreferencePageMessages.PreferencePage_refinedStatemachineLineColor_label;
	private static String STATE_LINE_COLOR_LABEL = PreferencePageMessages.PreferencePage_stateLineColor_label;
	private static String REFINED_STATE_LINE_COLOR_LABEL = PreferencePageMessages.PreferencePage_refinedStateLineColor_label;
	private static String INITIAL_LINE_COLOR_LABEL = PreferencePageMessages.PreferencePage_initialLineColor_label;
	private static String FINAL_LINE_COLOR_LABEL = PreferencePageMessages.PreferencePage_finalLineColor_label;
	private static String ANY_LINE_COLOR_LABEL = PreferencePageMessages.PreferencePage_anyLineColor_label;
	private static String JUNCTION_LINE_COLOR_LABEL = PreferencePageMessages.PreferencePage_junctionLineColor_label;
	private static String FORK_LINE_COLOR_LABEL = PreferencePageMessages.PreferencePage_forkLineColor_label;
	private static String TRANSITION_LINE_COLOR_LABEL = PreferencePageMessages.PreferencePage_transitionLineColor_label;

	//preference page editor controls 
	private ColorFieldEditor statemachineFillColorEditor = null;
	private ColorFieldEditor refinedStatemachineFillColorEditor = null;
	private ColorFieldEditor stateFillColorEditor = null;
	private ColorFieldEditor refinedStateFillColorEditor = null;
	private ColorFieldEditor initialFillColorEditor = null;
	private ColorFieldEditor finalFillColorEditor = null;
	private ColorFieldEditor anyFillColorEditor = null;
	private ColorFieldEditor junctionFillColorEditor = null;
	private ColorFieldEditor forkFillColorEditor = null;
	private ColorFieldEditor transitionFillColorEditor = null;
	private ColorFieldEditor statemachineLineColorEditor = null;
	private ColorFieldEditor refinedStatemachineLineColorEditor = null;
	private ColorFieldEditor stateLineColorEditor = null;
	private ColorFieldEditor refinedStateLineColorEditor = null;
	private ColorFieldEditor initialLineColorEditor = null;
	private ColorFieldEditor finalLineColorEditor = null;
	private ColorFieldEditor anyLineColorEditor = null;
	private ColorFieldEditor junctionLineColorEditor = null;
	private ColorFieldEditor forkLineColorEditor = null;
	private ColorFieldEditor transitionLineColorEditor = null;

	// Define some default colors to use as defaults (these are referred to in the gmfgen model in order to generate the initialise code below)
	private static final Color DEFAULT_STATEMACHINE_FILL_COLOR = new Color(
			null, 240, 250, 255); //240, 240, 255
	private static final Color DEFAULT_REFINED_STATEMACHINE_FILL_COLOR = new Color(
			null, 240, 240, 255); //240, 255, 240
	private static final Color DEFAULT_STATE_FILL_COLOR = new Color(
			null, 200, 240, 255);
	private static final Color DEFAULT_REFINED_STATE_FILL_COLOR = new Color(
			null, 220, 220, 255);
	private static final Color DEFAULT_INITIAL_FILL_COLOR = ColorConstants.gray;
	private static final Color DEFAULT_FINAL_FILL_COLOR = ColorConstants.white;
	private static final Color DEFAULT_ANY_FILL_COLOR = ColorConstants.white;
	private static final Color DEFAULT_JUNCTION_FILL_COLOR = ColorConstants.gray;
	private static final Color DEFAULT_FORK_FILL_COLOR = ColorConstants.gray;
	private static final Color DEFAULT_TRANSITION_FILL_COLOR = ColorConstants.gray;

	private static final Color DEFAULT_STATEMACHINE_LINE_COLOR = ColorConstants.gray;
	private static final Color DEFAULT_REFINED_STATEMACHINE_LINE_COLOR = ColorConstants.gray;
	private static final Color DEFAULT_STATE_LINE_COLOR = ColorConstants.gray;
	private static final Color DEFAULT_REFINED_STATE_LINE_COLOR = ColorConstants.gray;
	private static final Color DEFAULT_INITIAL_LINE_COLOR = ColorConstants.gray;
	private static final Color DEFAULT_FINAL_LINE_COLOR = ColorConstants.gray;
	private static final Color DEFAULT_ANY_LINE_COLOR = ColorConstants.gray;
	private static final Color DEFAULT_JUNCTION_LINE_COLOR = ColorConstants.gray;
	private static final Color DEFAULT_FORK_LINE_COLOR = ColorConstants.gray;
	private static final Color DEFAULT_TRANSITION_LINE_COLOR = ColorConstants.gray;

	/**
	 * @generated
	 */
	public static final String PREF_STATEMACHINE_FILL_COLOR = "SpecificDiagramAppearance.STATEMACHINE.FILL.COLOR"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final String PREF_REFINED_STATEMACHINE_FILL_COLOR = "SpecificDiagramAppearance.REFINED.STATEMACHINE.FILL.COLOR"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final String PREF_STATE_FILL_COLOR = "SpecificDiagramAppearance.STATE.FILL.COLOR"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final String PREF_REFINED_STATE_FILL_COLOR = "SpecificDiagramAppearance.REFINED.STATE.FILL.COLOR"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final String PREF_INITIAL_FILL_COLOR = "SpecificDiagramAppearance.INITIAL.FILL.COLOR"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final String PREF_FINAL_FILL_COLOR = "SpecificDiagramAppearance.FINAL.FILL.COLOR"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final String PREF_ANY_FILL_COLOR = "SpecificDiagramAppearance.ANY.FILL.COLOR"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final String PREF_JUNCTION_FILL_COLOR = "SpecificDiagramAppearance.JUNCTION.FILL.COLOR"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final String PREF_FORK_FILL_COLOR = "SpecificDiagramAppearance.FORK.FILL.COLOR"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final String PREF_TRANSITION_FILL_COLOR = "SpecificDiagramAppearance.TRANSITION.FILL.COLOR"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final String PREF_STATEMACHINE_LINE_COLOR = "SpecificDiagramAppearance.STATEMACHINE.LINE.COLOR"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final String PREF_REFINED_STATEMACHINE_LINE_COLOR = "SpecificDiagramAppearance.REFINED.STATEMACHINE.LINE.COLOR"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final String PREF_STATE_LINE_COLOR = "SpecificDiagramAppearance.STATE.LINE.COLOR"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final String PREF_REFINED_STATE_LINE_COLOR = "SpecificDiagramAppearance.REFINED.STATE.LINE.COLOR"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final String PREF_INITIAL_LINE_COLOR = "SpecificDiagramAppearance.INITIAL.LINE.COLOR"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final String PREF_FINAL_LINE_COLOR = "SpecificDiagramAppearance.FINAL.LINE.COLOR"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final String PREF_ANY_LINE_COLOR = "SpecificDiagramAppearance.ANY.LINE.COLOR"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final String PREF_JUNCTION_LINE_COLOR = "SpecificDiagramAppearance.JUNCTION.LINE.COLOR"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final String PREF_FORK_LINE_COLOR = "SpecificDiagramAppearance.FORK.LINE.COLOR"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final String PREF_TRANSITION_LINE_COLOR = "SpecificDiagramAppearance.TRANSITION.LINE.COLOR"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public SpecificDiagramAppearancePreferencePage() {
		setPreferenceStore(StatemachinesDiagramEditorPlugin.getInstance()
				.getPreferenceStore());
	}

	/**
	 * @generated NOT
	 */
	protected void addFields(Composite composite) {

		statemachineFillColorEditor = new ColorFieldEditor(
				PREF_STATEMACHINE_FILL_COLOR, STATEMACHINE_FILL_COLOR_LABEL,
				composite);
		addField(statemachineFillColorEditor);

		statemachineLineColorEditor = new ColorFieldEditor(
				PREF_STATEMACHINE_LINE_COLOR, STATEMACHINE_LINE_COLOR_LABEL,
				composite);
		addField(statemachineLineColorEditor);

		refinedStatemachineFillColorEditor = new ColorFieldEditor(
				PREF_REFINED_STATEMACHINE_FILL_COLOR,
				REFINED_STATEMACHINE_FILL_COLOR_LABEL, composite);
		addField(refinedStatemachineFillColorEditor);

		refinedStatemachineLineColorEditor = new ColorFieldEditor(
				PREF_REFINED_STATEMACHINE_LINE_COLOR,
				REFINED_STATEMACHINE_LINE_COLOR_LABEL, composite);
		addField(refinedStatemachineLineColorEditor);

		stateFillColorEditor = new ColorFieldEditor(PREF_STATE_FILL_COLOR,
				STATE_FILL_COLOR_LABEL, composite);
		addField(stateFillColorEditor);

		stateLineColorEditor = new ColorFieldEditor(PREF_STATE_LINE_COLOR,
				STATE_LINE_COLOR_LABEL, composite);
		addField(stateLineColorEditor);

		refinedStateFillColorEditor = new ColorFieldEditor(
				PREF_REFINED_STATE_FILL_COLOR, REFINED_STATE_FILL_COLOR_LABEL,
				composite);
		addField(refinedStateFillColorEditor);

		refinedStateLineColorEditor = new ColorFieldEditor(
				PREF_REFINED_STATE_LINE_COLOR, REFINED_STATE_LINE_COLOR_LABEL,
				composite);
		addField(refinedStateLineColorEditor);

		initialFillColorEditor = new ColorFieldEditor(PREF_INITIAL_FILL_COLOR,
				INITIAL_FILL_COLOR_LABEL, composite);
		addField(initialFillColorEditor);

		initialLineColorEditor = new ColorFieldEditor(PREF_INITIAL_LINE_COLOR,
				INITIAL_LINE_COLOR_LABEL, composite);
		addField(initialLineColorEditor);

		finalFillColorEditor = new ColorFieldEditor(PREF_FINAL_FILL_COLOR,
				FINAL_FILL_COLOR_LABEL, composite);
		addField(finalFillColorEditor);

		finalLineColorEditor = new ColorFieldEditor(PREF_FINAL_LINE_COLOR,
				FINAL_LINE_COLOR_LABEL, composite);
		addField(finalLineColorEditor);

		anyFillColorEditor = new ColorFieldEditor(PREF_ANY_FILL_COLOR,
				ANY_FILL_COLOR_LABEL, composite);
		addField(anyFillColorEditor);

		anyLineColorEditor = new ColorFieldEditor(PREF_ANY_LINE_COLOR,
				ANY_LINE_COLOR_LABEL, composite);
		addField(anyLineColorEditor);

		junctionFillColorEditor = new ColorFieldEditor(
				PREF_JUNCTION_FILL_COLOR, JUNCTION_FILL_COLOR_LABEL, composite);
		addField(junctionFillColorEditor);

		junctionLineColorEditor = new ColorFieldEditor(
				PREF_JUNCTION_LINE_COLOR, JUNCTION_LINE_COLOR_LABEL, composite);
		addField(junctionLineColorEditor);

		forkFillColorEditor = new ColorFieldEditor(PREF_FORK_FILL_COLOR,
				FORK_FILL_COLOR_LABEL, composite);
		addField(forkFillColorEditor);

		forkLineColorEditor = new ColorFieldEditor(PREF_FORK_LINE_COLOR,
				FORK_LINE_COLOR_LABEL, composite);
		addField(forkLineColorEditor);

		transitionFillColorEditor = new ColorFieldEditor(
				PREF_TRANSITION_FILL_COLOR, TRANSITION_FILL_COLOR_LABEL,
				composite);
		addField(transitionFillColorEditor);

		transitionLineColorEditor = new ColorFieldEditor(
				PREF_TRANSITION_LINE_COLOR, TRANSITION_LINE_COLOR_LABEL,
				composite);
		addField(transitionLineColorEditor);
	}

	/**
	 * @generated NOT
	 */
	protected void initHelp() {

	}

	/**
	 * @generated
	 */
	public static void initDefaults(IPreferenceStore store) {
		store.setDefault(PREF_STATEMACHINE_FILL_COLOR, StringConverter
				.asString(DEFAULT_STATEMACHINE_FILL_COLOR.getRGB()));
		store.setDefault(PREF_REFINED_STATEMACHINE_FILL_COLOR, StringConverter
				.asString(DEFAULT_REFINED_STATEMACHINE_FILL_COLOR.getRGB()));
		store.setDefault(PREF_STATE_FILL_COLOR,
				StringConverter.asString(DEFAULT_STATE_FILL_COLOR.getRGB()));
		store.setDefault(PREF_REFINED_STATE_FILL_COLOR, StringConverter
				.asString(DEFAULT_REFINED_STATE_FILL_COLOR.getRGB()));
		store.setDefault(PREF_INITIAL_FILL_COLOR,
				StringConverter.asString(DEFAULT_INITIAL_FILL_COLOR.getRGB()));
		store.setDefault(PREF_FINAL_FILL_COLOR,
				StringConverter.asString(DEFAULT_FINAL_FILL_COLOR.getRGB()));
		store.setDefault(PREF_ANY_FILL_COLOR,
				StringConverter.asString(DEFAULT_ANY_FILL_COLOR.getRGB()));
		store.setDefault(PREF_JUNCTION_FILL_COLOR,
				StringConverter.asString(DEFAULT_JUNCTION_FILL_COLOR.getRGB()));
		store.setDefault(PREF_FORK_FILL_COLOR,
				StringConverter.asString(DEFAULT_FORK_FILL_COLOR.getRGB()));
		store.setDefault(PREF_TRANSITION_FILL_COLOR, StringConverter
				.asString(DEFAULT_TRANSITION_FILL_COLOR.getRGB()));
		store.setDefault(PREF_STATEMACHINE_LINE_COLOR, StringConverter
				.asString(DEFAULT_STATEMACHINE_LINE_COLOR.getRGB()));
		store.setDefault(PREF_REFINED_STATEMACHINE_LINE_COLOR, StringConverter
				.asString(DEFAULT_REFINED_STATEMACHINE_LINE_COLOR.getRGB()));
		store.setDefault(PREF_STATE_LINE_COLOR,
				StringConverter.asString(DEFAULT_STATE_LINE_COLOR.getRGB()));
		store.setDefault(PREF_REFINED_STATE_LINE_COLOR, StringConverter
				.asString(DEFAULT_REFINED_STATE_LINE_COLOR.getRGB()));
		store.setDefault(PREF_INITIAL_LINE_COLOR,
				StringConverter.asString(DEFAULT_INITIAL_LINE_COLOR.getRGB()));
		store.setDefault(PREF_FINAL_LINE_COLOR,
				StringConverter.asString(DEFAULT_FINAL_LINE_COLOR.getRGB()));
		store.setDefault(PREF_ANY_LINE_COLOR,
				StringConverter.asString(DEFAULT_ANY_LINE_COLOR.getRGB()));
		store.setDefault(PREF_JUNCTION_LINE_COLOR,
				StringConverter.asString(DEFAULT_JUNCTION_LINE_COLOR.getRGB()));
		store.setDefault(PREF_FORK_LINE_COLOR,
				StringConverter.asString(DEFAULT_FORK_LINE_COLOR.getRGB()));
		store.setDefault(PREF_TRANSITION_LINE_COLOR, StringConverter
				.asString(DEFAULT_TRANSITION_LINE_COLOR.getRGB()));
	}

	public static String getFillColorPreference(EClass clazz, boolean refined) {
		switch (clazz.getName()) {
		case "Statemachine":
			return refined ? PREF_REFINED_STATEMACHINE_FILL_COLOR
					: PREF_STATEMACHINE_FILL_COLOR;
		case "State":
			return refined ? PREF_REFINED_STATE_FILL_COLOR
					: PREF_STATE_FILL_COLOR;
		case "Initial":
			return PREF_INITIAL_FILL_COLOR;
		case "Final":
			return PREF_FINAL_FILL_COLOR;
		case "Any":
			return PREF_ANY_FILL_COLOR;
		case "Junction":
			return PREF_JUNCTION_FILL_COLOR;
		case "Fork":
			return PREF_FORK_FILL_COLOR;
		case "Transition":
			return PREF_TRANSITION_FILL_COLOR;
		default:
			return null;
		}
	}

	public static String getLineColorPreference(EClass clazz, boolean refined) {
		switch (clazz.getName()) {
		case "Statemachine":
			return refined ? PREF_REFINED_STATEMACHINE_LINE_COLOR
					: PREF_STATEMACHINE_LINE_COLOR;
		case "State":
			return refined ? PREF_REFINED_STATE_LINE_COLOR
					: PREF_STATE_LINE_COLOR;
		case "Initial":
			return PREF_INITIAL_LINE_COLOR;
		case "Final":
			return PREF_FINAL_LINE_COLOR;
		case "Any":
			return PREF_ANY_LINE_COLOR;
		case "Junction":
			return PREF_JUNCTION_LINE_COLOR;
		case "Fork":
			return PREF_FORK_LINE_COLOR;
		case "Transition":
			return PREF_TRANSITION_LINE_COLOR;
		default:
			return null;
		}
	}

}
