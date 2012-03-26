/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams;

import org.eventb.emf.core.EventBNamedCommentedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.Association#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getAssociation()
 * @model
 * @generated
 */
public interface Association extends EventBNamedCommentedElement {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link ac.soton.eventb.classdiagrams.Class#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ac.soton.eventb.classdiagrams.Class)
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getAssociation_Target()
	 * @see ac.soton.eventb.classdiagrams.Class#getSource
	 * @model opposite="source"
	 * @generated
	 */
	ac.soton.eventb.classdiagrams.Class getTarget();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.classdiagrams.Association#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ac.soton.eventb.classdiagrams.Class value);

} // Association
