/*******************************************************************************
 * Copyright (c) 2015 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     University of Southampton - initial API and implementation
 *******************************************************************************/

package ac.soton.eventb.statemachines.validator.tests;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eventb.emf.core.EventBElement;

/**
 * <p>
 *
 * </p>
 *
 * @author htson
 * @version
 * @see
 * @since
 */
public class Error_FeatureMissing extends AbstractErrorDiagnostic implements
		IDiagnosticCause {

	/**
	 * @param eventBpredicatePredicate
	 * @param inv
	 */
	public Error_FeatureMissing(EventBElement element, EAttribute feature) {
		super("required feature", element, feature);
	}

	/**
	 * @param eventBpredicatePredicate
	 * @param inv
	 */
	public Error_FeatureMissing(EventBElement element, EReference feature) {
		super("required feature", element, feature);
	}

}
