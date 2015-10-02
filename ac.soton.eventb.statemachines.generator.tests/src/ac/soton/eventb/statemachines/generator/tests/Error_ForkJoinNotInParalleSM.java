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

import ac.soton.eventb.statemachines.Fork;

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
public class Error_ForkJoinNotInParalleSM extends AbstractErrorDiagnostic
		implements IDiagnosticCause {

	/**
	 * @param fork
	 */
	public Error_ForkJoinNotInParalleSM(Fork fork) {
		super("forked/joined nodes should be in parallel statemachines", fork);
	}

}
