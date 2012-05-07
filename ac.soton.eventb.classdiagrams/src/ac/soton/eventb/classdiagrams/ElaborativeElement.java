/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams;

import org.eclipse.emf.ecore.EObject;

import org.eventb.emf.core.EventBNamed;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Elaborative Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.ElaborativeElement#getElaborates <em>Elaborates</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getElaborativeElement()
 * @model
 * @generated
 */
public interface ElaborativeElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Elaborates</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elaborates</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elaborates</em>' reference.
	 * @see #setElaborates(EventBNamed)
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getElaborativeElement_Elaborates()
	 * @model
	 * @generated
	 */
	EventBNamed getElaborates();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.classdiagrams.ElaborativeElement#getElaborates <em>Elaborates</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elaborates</em>' reference.
	 * @see #getElaborates()
	 * @generated
	 */
	void setElaborates(EventBNamed value);

} // ElaborativeElement
