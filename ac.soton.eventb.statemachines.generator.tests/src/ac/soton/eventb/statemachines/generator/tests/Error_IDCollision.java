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
public class Error_IDCollision extends AbstractErrorDiagnostic implements
		IDiagnosticCause {

	/**
	 * @param stateInvariants
	 * @param inv1
	 * @param inv2
	 */
	public Error_IDCollision(EventBElement element1, EventBElement element2,
			String ID) {
		super("collides with that of", element1, element2, ID);
	}

}
