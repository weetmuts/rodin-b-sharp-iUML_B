/**
 * Copyright (c) 2010
 * University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package ac.soton.eventb.statemachines;

import org.eventb.emf.core.EventBCommentedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.statemachines.Transition#getTarget <em>Target</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.Transition#getSource <em>Source</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.Transition#getElaborates <em>Elaborates</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends EventBCommentedElement, EventBLabeled {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2010\rUniversity of Southampton.\rAll rights reserved. This program and the accompanying materials  are made\ravailable under the terms of the Eclipse Public License v1.0 which accompanies this \rdistribution, and is available at http://www.eclipse.org/legal/epl-v10.html\n";

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link ac.soton.eventb.statemachines.AbstractNode#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(AbstractNode)
	 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getTransition_Target()
	 * @see ac.soton.eventb.statemachines.AbstractNode#getIncoming
	 * @model opposite="incoming" required="true"
	 * @generated
	 */
	AbstractNode getTarget();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.statemachines.Transition#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(AbstractNode value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link ac.soton.eventb.statemachines.AbstractNode#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(AbstractNode)
	 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getTransition_Source()
	 * @see ac.soton.eventb.statemachines.AbstractNode#getOutgoing
	 * @model opposite="outgoing" required="true"
	 * @generated
	 */
	AbstractNode getSource();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.statemachines.Transition#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(AbstractNode value);

	/**
	 * Returns the value of the '<em><b>Elaborates</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elaborates</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elaborates</em>' reference.
	 * @see #setElaborates(EventBCommentedElement)
	 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getTransition_Elaborates()
	 * @model
	 * @generated
	 */
	EventBCommentedElement getElaborates();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.statemachines.Transition#getElaborates <em>Elaborates</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elaborates</em>' reference.
	 * @see #getElaborates()
	 * @generated
	 */
	void setElaborates(EventBCommentedElement value);

} // Transition
