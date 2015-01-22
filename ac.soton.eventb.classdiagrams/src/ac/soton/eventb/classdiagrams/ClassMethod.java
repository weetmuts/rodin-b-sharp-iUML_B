/**
 * Copyright (c) 2013 - University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams;

import ac.soton.eventb.emf.core.extension.coreextension.EventBCommentedLabeledEventGroupElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.ClassMethod#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getClassMethod()
 * @model
 * @generated
 */
public interface ClassMethod extends EventBCommentedLabeledEventGroupElement {

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The default value is <code>"normal"</code>.
	 * The literals are from the enumeration {@link ac.soton.eventb.classdiagrams.MethodKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see ac.soton.eventb.classdiagrams.MethodKind
	 * @see #setKind(MethodKind)
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getClassMethod_Kind()
	 * @model default="normal" required="true"
	 * @generated
	 */
	MethodKind getKind();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.classdiagrams.ClassMethod#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see ac.soton.eventb.classdiagrams.MethodKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(MethodKind value);
} // ClassMethod
