/**
 * Copyright (c) 2012 - University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams;

import ac.soton.eventb.emf.diagrams.Diagram;

import org.eclipse.emf.common.util.EList;

import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.EventBNamedCommentedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classdiagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.Classdiagram#getClasses <em>Classes</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.Classdiagram#getAssociations <em>Associations</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.Classdiagram#getRefines <em>Refines</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getClassdiagram()
 * @model
 * @generated
 */
public interface Classdiagram extends EventBNamedCommentedElement, AbstractExtension, Diagram {
	/**
	 * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.eventb.classdiagrams.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' containment reference list.
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getClassdiagram_Classes()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ac.soton.eventb.classdiagrams.Class> getClasses();

	/**
	 * Returns the value of the '<em><b>Associations</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.eventb.classdiagrams.Association}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associations</em>' containment reference list.
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getClassdiagram_Associations()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Association> getAssociations();

	/**
	 * Returns the value of the '<em><b>Refines</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refines</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refines</em>' reference.
	 * @see #setRefines(Classdiagram)
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getClassdiagram_Refines()
	 * @model
	 * @generated
	 */
	Classdiagram getRefines();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.classdiagrams.Classdiagram#getRefines <em>Refines</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refines</em>' reference.
	 * @see #getRefines()
	 * @generated
	 */
	void setRefines(Classdiagram value);

} // Classdiagram
