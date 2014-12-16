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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classdiagram Owner</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.ClassdiagramOwner#getClassdiagrams <em>Classdiagrams</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getClassdiagramOwner()
 * @model abstract="true"
 * @generated
 */
public interface ClassdiagramOwner extends EObject {
	/**
	 * Returns the value of the '<em><b>Classdiagrams</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.eventb.classdiagrams.Classdiagram}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classdiagrams</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classdiagrams</em>' containment reference list.
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getClassdiagramOwner_Classdiagrams()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Classdiagram> getClassdiagrams();

} // ClassdiagramOwner
