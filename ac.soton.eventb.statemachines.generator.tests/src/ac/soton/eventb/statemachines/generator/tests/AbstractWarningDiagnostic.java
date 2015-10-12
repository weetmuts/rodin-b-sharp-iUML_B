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

package ac.soton.eventb.statemachines.generator.tests;

import org.eclipse.emf.common.util.Diagnostic;

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
public class AbstractWarningDiagnostic extends AbstractDiagnosticCause
		implements IDiagnosticCause {

	/**
	 * @param signature
	 * @param objects
	 */
	public AbstractWarningDiagnostic(String signature, Object... objects) {
		super(Diagnostic.WARNING, signature, objects);
	}

}
