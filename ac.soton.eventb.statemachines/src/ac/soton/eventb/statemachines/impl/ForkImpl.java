/**
 * Copyright (c) 2010-2013
 * University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 *
 * $Id$
 */
package ac.soton.eventb.statemachines.impl;

import org.eclipse.emf.ecore.EClass;

import ac.soton.eventb.statemachines.Fork;
import ac.soton.eventb.statemachines.StatemachinesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fork</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ForkImpl extends AbstractNodeImpl implements Fork {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2010-2013\rUniversity of Southampton.\rAll rights reserved. This program and the accompanying materials  are made\ravailable under the terms of the Eclipse Public License v1.0 which accompanies this \rdistribution, and is available at http://www.eclipse.org/legal/epl-v10.html\n";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatemachinesPackage.Literals.FORK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * A fork is only a true fork if it has multiple outgoing transitions and one incoming transition)
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isFork() {
		return this.getIncoming().size() == 1 && this.getOutgoing().size() > 1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * A fork is actually a join if it has multiple incoming transitions and one outgoing transitions
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isJoin() {
		return this.getIncoming().size() > 1 && this.getOutgoing().size() == 1;
	}

} //ForkImpl
