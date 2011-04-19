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
import org.eventb.emf.core.EventBCommentedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Statemachine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.statemachines.AbstractStatemachine#getNodes <em>Nodes</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.AbstractStatemachine#getTransitions <em>Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getAbstractStatemachine()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='rootHasInitial\nhasAtMostOneInitial\nhasInitialIfIncomingExternal\nhasInitialIfOutgoingLocal'"
 * @generated
 */
public interface AbstractStatemachine extends EventBCommentedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2010\rUniversity of Southampton.\rAll rights reserved. This program and the accompanying materials  are made\ravailable under the terms of the Eclipse Public License v1.0 which accompanies this \rdistribution, and is available at http://www.eclipse.org/legal/epl-v10.html\n";

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.eventb.statemachines.AbstractNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getAbstractStatemachine_Nodes()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<AbstractNode> getNodes();

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.eventb.statemachines.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getAbstractStatemachine_Transitions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Transition> getTransitions();

} // AbstractStatemachine
