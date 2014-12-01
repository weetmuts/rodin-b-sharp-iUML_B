/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.sheet.custom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;

import ac.soton.eventb.emf.diagrams.sheet.AbstractEnumerationPropertySection;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.TranslationKind;

/**
 * Translation property section for Statemachine.
 * 
 *
 */
public class TranslationPropertySection extends AbstractEnumerationPropertySection {
	
	private static final Map<String, String> translationNameMap = new HashMap<String, String>();
	static {
		translationNameMap.put(TranslationKind.SINGLEVAR.getName(), "Enumeration");
		translationNameMap.put(TranslationKind.MULTIVAR.getName(), "Variables");
		//translationNameMap.put(TranslationKind.REFINEDVAR.getName(), "Refined Enumeration (EXPERIMENTAL)");
	}
	private static final String[] stringValues = {"Enumeration","Variables"};

	@Override
	protected String[] getEnumerationFeatureValues() {
		return  stringValues;
	}

	@Override
	protected String getFeatureAsText() {
		return translationNameMap.get(((Statemachine) eObject).getTranslation().getName());
	}

	@Override
	protected Object getFeatureValue(String selection) {
		for (TranslationKind tk : TranslationKind.values()){
			if (translationNameMap.get(tk.getName()).equals(selection))
				return tk;
		}
		return null;		
	}

	@Override
	protected String getLabelText() {
		return "Translation:";
	}

	@Override
	protected EStructuralFeature getFeature() {
		return StatemachinesPackage.Literals.STATEMACHINE__TRANSLATION;
	}

	@Override
	protected List<TranslationKind> getAvailableDataElements() {
		return TranslationKind.VALUES;
	}

}
