/**
 * Copyright (c) 2010
 * University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package ac.soton.eventb.statemachines;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statemachine Owner</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.statemachines.StatemachineOwner#getStatemachines <em>Statemachines</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getStatemachineOwner()
 * @model abstract="true"
 * @generated
 */
public interface StatemachineOwner extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2010-2013\rUniversity of Southampton.\rAll rights reserved. This program and the accompanying materials  are made\ravailable under the terms of the Eclipse Public License v1.0 which accompanies this \rdistribution, and is available at http://www.eclipse.org/legal/epl-v10.html\n";

	/**
	 * Returns the value of the '<em><b>Statemachines</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.eventb.statemachines.Statemachine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statemachines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statemachines</em>' containment reference list.
	 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getStatemachineOwner_Statemachines()
	 * @model containment="true"
	 * @generated
	 */
	EList<Statemachine> getStatemachines();

} // StatemachineOwner
