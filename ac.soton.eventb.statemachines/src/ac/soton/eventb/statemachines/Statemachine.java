/**
 * Copyright (c) 2010
 * University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package ac.soton.eventb.statemachines;

import ac.soton.eventb.emf.core.extension.coreextension.EventBNamedCommentedDataElaborationElement;
import org.eclipse.emf.common.util.EList;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.EventBNamedCommentedElement;

import ac.soton.eventb.emf.diagrams.Diagram;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statemachine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.statemachines.Statemachine#getRefines <em>Refines</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.Statemachine#getNodes <em>Nodes</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.Statemachine#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.Statemachine#getInstances <em>Instances</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.Statemachine#getSelfName <em>Self Name</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.Statemachine#getTranslation <em>Translation</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getStatemachine()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='hasValidName\nconcreteHasNoRefinedStates\nrefinedHasNoConcreteStates\nhasOneInitial\nhasOneFinal\nrootHasInitial\nhasInitialIfIncoming\ninstancesIsData\nhasValidSelfName'"
 * @generated
 */
public interface Statemachine extends EventBNamedCommentedDataElaborationElement, AbstractExtension, Diagram {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2010-2013\rUniversity of Southampton.\rAll rights reserved. This program and the accompanying materials  are made\ravailable under the terms of the Eclipse Public License v1.0 which accompanies this \rdistribution, and is available at http://www.eclipse.org/legal/epl-v10.html\n";

	/**
	 * Returns the value of the '<em><b>Translation</b></em>' attribute.
	 * The literals are from the enumeration {@link ac.soton.eventb.statemachines.TranslationKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Translation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Translation</em>' attribute.
	 * @see ac.soton.eventb.statemachines.TranslationKind
	 * @see #setTranslation(TranslationKind)
	 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getStatemachine_Translation()
	 * @model
	 * @generated
	 */
	TranslationKind getTranslation();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.statemachines.Statemachine#getTranslation <em>Translation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Translation</em>' attribute.
	 * @see ac.soton.eventb.statemachines.TranslationKind
	 * @see #getTranslation()
	 * @generated
	 */
	void setTranslation(TranslationKind value);

	/**
	 * Returns the value of the '<em><b>Refines</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refines</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refines</em>' reference.
	 * @see #setRefines(Statemachine)
	 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getStatemachine_Refines()
	 * @model
	 * @generated
	 */
	Statemachine getRefines();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.statemachines.Statemachine#getRefines <em>Refines</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refines</em>' reference.
	 * @see #getRefines()
	 * @generated
	 */
	void setRefines(Statemachine value);

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
	 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getStatemachine_Nodes()
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
	 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getStatemachine_Transitions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Transition> getTransitions();

	/**
	 * Returns the value of the '<em><b>Instances</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instances</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instances</em>' reference.
	 * @see #setInstances(EventBNamedCommentedElement)
	 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getStatemachine_Instances()
	 * @model
	 * @generated
	 */
	EventBNamedCommentedElement getInstances();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.statemachines.Statemachine#getInstances <em>Instances</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instances</em>' reference.
	 * @see #getInstances()
	 * @generated
	 */
	void setInstances(EventBNamedCommentedElement value);

	/**
	 * Returns the value of the '<em><b>Self Name</b></em>' attribute.
	 * The default value is <code>"this"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Self Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Self Name</em>' attribute.
	 * @see #setSelfName(String)
	 * @see ac.soton.eventb.statemachines.StatemachinesPackage#getStatemachine_SelfName()
	 * @model default="this"
	 * @generated
	 */
	String getSelfName();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.statemachines.Statemachine#getSelfName <em>Self Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Self Name</em>' attribute.
	 * @see #getSelfName()
	 * @generated
	 */
	void setSelfName(String value);

} // Statemachine
