/**
 * Copyright (c) 2010-2015
 * University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 *
 * $Id$
 */
package ac.soton.eventb.statemachines;

import ac.soton.eventb.emf.core.extension.coreextension.EventBDataElaboration;

import org.eclipse.emf.common.util.EList;

import org.eventb.emf.core.machine.Action;
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
 *   <li>{@link ac.soton.eventb.statemachines.State#getActiveInstances <em>Active Instances</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.State#getEntryActions <em>Entry Actions</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.State#getExitActions <em>Exit Actions</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.State#getTimeout <em>Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getState()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='hasValidName\nconcreteHasNoRefinedStatemachines\nvalidInvariants\n'"
 * @generated
 */
public interface State extends AbstractNode, EventBDataElaboration, StatemachineOwner {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2010-2015\rUniversity of Southampton.\rAll rights reserved. This program and the accompanying materials  are made\ravailable under the terms of the Eclipse Public License v1.0 which accompanies this \rdistribution, and is available at http://www.eclipse.org/legal/epl-v10.html\n";

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

	/**
	 * Returns the value of the '<em><b>Active Instances</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Instances</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Instances</em>' attribute.
	 * @see #setActiveInstances(EList)
	 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getState_ActiveInstances()
	 * @model many="false" transient="true"
	 * @generated
	 */
	EList<?> getActiveInstances();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.statemachines.State#getActiveInstances <em>Active Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active Instances</em>' attribute.
	 * @see #getActiveInstances()
	 * @generated
	 */
	void setActiveInstances(EList<?> value);

	/**
	 * Returns the value of the '<em><b>Entry Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eventb.emf.core.machine.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Actions</em>' containment reference list.
	 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getState_EntryActions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Action> getEntryActions();

	/**
	 * Returns the value of the '<em><b>Exit Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eventb.emf.core.machine.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exit Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit Actions</em>' containment reference list.
	 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getState_ExitActions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Action> getExitActions();

	/**
	 * Returns the value of the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timeout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timeout</em>' attribute.
	 * @see #setTimeout(Integer)
	 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getState_Timeout()
	 * @model
	 * @generated
	 */
	Integer getTimeout();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.statemachines.State#getTimeout <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timeout</em>' attribute.
	 * @see #getTimeout()
	 * @generated
	 */
	void setTimeout(Integer value);

} // State
