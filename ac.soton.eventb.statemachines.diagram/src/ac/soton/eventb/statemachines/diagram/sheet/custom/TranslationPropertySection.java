/*
 * Copyright (c) 2011 University of Southampton.
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

import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.TranslationKind;

/**
 * Translation property section for Statemachine.
 * 
 * @author vitaly
 *
 */
public class TranslationPropertySection extends AbstractEnumerationPropertySection {
	
	private static final Map<String, String> translationNameMap = new HashMap<String, String>();
	static {
		translationNameMap.put(TranslationKind.SINGLEVAR.getName(), "Enumeration");
		translationNameMap.put(TranslationKind.MULTIVAR.getName(), "Variables");
		//translationNameMap.put(TranslationKind.REFINEDVAR.getName(), "Refined Enumeration (EXPERIMENTAL)");
	}

	@Override
	protected boolean isEqual(int index) {
		return TranslationKind.VALUES.get(index).equals(((Statemachine) eObject).getTranslation());
	}

	@Override
	protected String[] getEnumerationFeatureValues() {
		List<TranslationKind> values = TranslationKind.VALUES;
		String[] ret = new String[values.size() - 1];			// - 1 is due to refined enumeration not being presented in UI 
		for (int i = 0; i < values.size()-1; i++) {				// "
			ret[i] = translationNameMap.get(values.get(i).getName());
		}
		return ret;
	}

	@Override
	protected String getFeatureAsText() {
		return translationNameMap.get(((Statemachine) eObject).getTranslation().getName());
	}

	@Override
	protected Object getFeatureValue(int index) {
		return TranslationKind.VALUES.get(index);
	}

	@Override
	protected String getLabelText() {
		return "Translation:";
	}

	@Override
	protected EStructuralFeature getFeature() {
		return StatemachinesPackage.Literals.STATEMACHINE__TRANSLATION;
	}

}
