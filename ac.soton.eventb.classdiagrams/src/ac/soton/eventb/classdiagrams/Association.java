/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams;

import org.eventb.emf.core.EventBNamedCommentedElement;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.Association#getTarget <em>Target</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.Association#getSource <em>Source</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.Association#isConstant <em>Constant</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getAssociation()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='isAsociationTypeRight'"
 * @generated
 */
public interface Association extends EventBNamedCommentedElement {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link ac.soton.eventb.classdiagrams.Class#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ac.soton.eventb.classdiagrams.Class)
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getAssociation_Target()
	 * @see ac.soton.eventb.classdiagrams.Class#getIncoming
	 * @model opposite="incoming" required="true"
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

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link ac.soton.eventb.classdiagrams.Class#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(ac.soton.eventb.classdiagrams.Class)
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getAssociation_Source()
	 * @see ac.soton.eventb.classdiagrams.Class#getOutgoing
	 * @model opposite="outgoing" required="true"
	 * @generated
	 */
	ac.soton.eventb.classdiagrams.Class getSource();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.classdiagrams.Association#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ac.soton.eventb.classdiagrams.Class value);

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
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getAssociation_Constant()
	 * @model default="false"
	 * @generated
	 */
	boolean isConstant();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.classdiagrams.Association#isConstant <em>Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant</em>' attribute.
	 * @see #isConstant()
	 * @generated
	 */
	void setConstant(boolean value);

} // Association
