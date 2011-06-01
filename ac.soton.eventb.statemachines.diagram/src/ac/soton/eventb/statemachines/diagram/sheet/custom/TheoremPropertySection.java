/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.sheet.custom;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.machine.Invariant;

/**
 * Theorem property section for Invariant.
 * 
 * @author vitaly
 *
 */
public class TheoremPropertySection extends AbstractEnumerationPropertySection {
	private static final String[] theoremValues = new String[]{Boolean.toString(Boolean.TRUE), Boolean.toString(Boolean.FALSE)};

	@Override
	protected boolean isEqual(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String[] getEnumerationFeatureValues() {
		return theoremValues;
	}

	@Override
	protected String getFeatureAsText() {
		return Boolean.toString(((Invariant) eObject).isTheorem());
	}

	@Override
	protected Object getFeatureValue(int index) {
		return Boolean.valueOf(theoremValues[index]);
	}

	@Override
	protected String getLabelText() {
		return "Theorem:";
	}

	@Override
	protected EStructuralFeature getFeature() {
		return CorePackage.Literals.EVENT_BDERIVED__THEOREM;
	}

}
