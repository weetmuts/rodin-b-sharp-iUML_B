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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event BInitialisable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.EventBInitialisable#getInitialValue <em>Initial Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getEventBInitialisable()
 * @model abstract="true"
 * @generated
 */
public interface EventBInitialisable extends EObject {
	/**
	 * Returns the value of the '<em><b>Initial Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Value</em>' attribute.
	 * @see #setInitialValue(String)
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getEventBInitialisable_InitialValue()
	 * @model
	 * @generated
	 */
	String getInitialValue();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.classdiagrams.EventBInitialisable#getInitialValue <em>Initial Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Value</em>' attribute.
	 * @see #getInitialValue()
	 * @generated
	 */
	void setInitialValue(String value);

} // EventBInitialisable
