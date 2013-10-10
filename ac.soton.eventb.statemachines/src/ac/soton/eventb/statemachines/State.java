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
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.machine.Invariant;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.statemachines.State#getRefines <em>Refines</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.State#getInvariants <em>Invariants</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.State#isActive <em>Active</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getState()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='hasValidName\nconcreteHasNoRefinedStatemachines\nvalidInvariants\n'"
 * @generated
 */
public interface State extends AbstractNode, EventBNamed, StatemachineOwner {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2010-2013\rUniversity of Southampton.\rAll rights reserved. This program and the accompanying materials  are made\ravailable under the terms of the Eclipse Public License v1.0 which accompanies this \rdistribution, and is available at http://www.eclipse.org/legal/epl-v10.html\n";

	/**
	 * Returns the value of the '<em><b>Refines</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refines</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refines</em>' reference.
	 * @see #setRefines(State)
	 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getState_Refines()
	 * @model
	 * @generated
	 */
	State getRefines();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.statemachines.State#getRefines <em>Refines</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refines</em>' reference.
	 * @see #getRefines()
	 * @generated
	 */
	void setRefines(State value);

	/**
	 * Returns the value of the '<em><b>Invariants</b></em>' containment reference list.
	 * The list contents are of type {@link org.eventb.emf.core.machine.Invariant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invariants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invariants</em>' containment reference list.
	 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getState_Invariants()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Invariant> getInvariants();

	/**
	 * Returns the value of the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active</em>' attribute.
	 * @see #setActive(boolean)
	 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getState_Active()
	 * @model transient="true"
	 * @generated
	 */
	boolean isActive();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.statemachines.State#isActive <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active</em>' attribute.
	 * @see #isActive()
	 * @generated
	 */
	void setActive(boolean value);

} // State
