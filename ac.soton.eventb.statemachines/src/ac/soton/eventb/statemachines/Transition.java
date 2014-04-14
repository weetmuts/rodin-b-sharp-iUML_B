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
import org.eventb.emf.core.EventBElement;

import ac.soton.eventb.emf.core.extension.coreextension.EventBCommentedLabeledEventGroupElement;

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
 *   <li>{@link ac.soton.eventb.statemachines.Transition#getSourceContainer <em>Source Container</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.Transition#getTargetContainer <em>Target Container</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.Transition#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getTransition()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='notToAny\nnotToInitial\nnotFromFinal\nnotFromInitialToFinal\nelaborates\nguards'"
 * @generated
 */
public interface Transition extends EventBCommentedLabeledEventGroupElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2010-2013\rUniversity of Southampton.\rAll rights reserved. This program and the accompanying materials  are made\ravailable under the terms of the Eclipse Public License v1.0 which accompanies this \rdistribution, and is available at http://www.eclipse.org/legal/epl-v10.html\n";

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
	 * Returns the value of the '<em><b>Source Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Container</em>' reference.
	 * @see #setSourceContainer(EventBElement)
	 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getTransition_SourceContainer()
	 * @model transient="true"
	 * @generated
	 */
	EventBElement getSourceContainer();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.statemachines.Transition#getSourceContainer <em>Source Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Container</em>' reference.
	 * @see #getSourceContainer()
	 * @generated
	 */
	void setSourceContainer(EventBElement value);

	/**
	 * Returns the value of the '<em><b>Target Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Container</em>' reference.
	 * @see #setTargetContainer(EventBElement)
	 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getTransition_TargetContainer()
	 * @model
	 * @generated
	 */
	EventBElement getTargetContainer();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.statemachines.Transition#getTargetContainer <em>Target Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Container</em>' reference.
	 * @see #getTargetContainer()
	 * @generated
	 */
	void setTargetContainer(EventBElement value);

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' attribute.
	 * @see #setOperations(EList)
	 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getTransition_Operations()
	 * @model many="false" transient="true"
	 * @generated
	 */
	EList<?> getOperations();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.statemachines.Transition#getOperations <em>Operations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operations</em>' attribute.
	 * @see #getOperations()
	 * @generated
	 */
	void setOperations(EList<?> value);

} // Transition
