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
public abstract class AbstractDiagnosticCause implements IDiagnosticCause {

	private String signature;

	private int severity;

	private Object[] objects;

	/**
	 * @param string
	 */
	public AbstractDiagnosticCause(int severity, String signature, Object... objects) {
		this.severity = severity;
		this.signature = signature;
		this.objects = objects;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ac.soton.eventb.statemachines.generator.tests.IDiagnosticCause#getSeverity
	 * ()
	 */
	@Override
	public int getSeverity() {
		return severity;
	}

	/* (non-Javadoc)
	 * @see ac.soton.eventb.statemachines.generator.tests.IDiagnosticCause#getObjects()
	 */
	@Override
	public Object[] getObjects() {
		return objects;
	}

	/* (non-Javadoc)
	 * @see ac.soton.eventb.statemachines.generator.tests.IDiagnosticCause#getSignature()
	 */
	@Override
	public String getSignature() {
		return signature;
	}

}
