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
 * A representation of the model object '<em><b>Abstract Classiagram Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.AbstractClassiagramElement#isConstant <em>Constant</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.AbstractClassiagramElement#getTargetContext <em>Target Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getAbstractClassiagramElement()
 * @model
 * @generated
 */
public interface AbstractClassiagramElement extends EventBNamedCommentedElement {
	/**
	 * Returns the value of the '<em><b>Constant</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant</em>' attribute.
	 * @see #setConstant(boolean)
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getAbstractClassiagramElement_Constant()
	 * @model default="false"
	 * @generated
	 */
	boolean isConstant();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.classdiagrams.AbstractClassiagramElement#isConstant <em>Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant</em>' attribute.
	 * @see #isConstant()
	 * @generated
	 */
	void setConstant(boolean value);

	/**
	 * Returns the value of the '<em><b>Target Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Context</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Context</em>' attribute.
	 * @see #setTargetContext(String)
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getAbstractClassiagramElement_TargetContext()
	 * @model
	 * @generated
	 */
	String getTargetContext();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.classdiagrams.AbstractClassiagramElement#getTargetContext <em>Target Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Context</em>' attribute.
	 * @see #getTargetContext()
	 * @generated
	 */
	void setTargetContext(String value);

} // AbstractClassiagramElement
