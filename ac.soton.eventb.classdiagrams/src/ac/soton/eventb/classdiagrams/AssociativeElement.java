/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Associative Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.AssociativeElement#isSurjective <em>Surjective</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.AssociativeElement#isInjective <em>Injective</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.AssociativeElement#isTotal <em>Total</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.AssociativeElement#isFunctional <em>Functional</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.AssociativeElement#getAssociationType <em>Association Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getAssociativeElement()
 * @model
 * @generated
 */
public interface AssociativeElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Surjective</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Surjective</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Surjective</em>' attribute.
	 * @see #setSurjective(boolean)
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getAssociativeElement_Surjective()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isSurjective();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.classdiagrams.AssociativeElement#isSurjective <em>Surjective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Surjective</em>' attribute.
	 * @see #isSurjective()
	 * @generated
	 */
	void setSurjective(boolean value);

	/**
	 * Returns the value of the '<em><b>Injective</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Injective</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Injective</em>' attribute.
	 * @see #setInjective(boolean)
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getAssociativeElement_Injective()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isInjective();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.classdiagrams.AssociativeElement#isInjective <em>Injective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Injective</em>' attribute.
	 * @see #isInjective()
	 * @generated
	 */
	void setInjective(boolean value);

	/**
	 * Returns the value of the '<em><b>Total</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total</em>' attribute.
	 * @see #setTotal(boolean)
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getAssociativeElement_Total()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isTotal();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.classdiagrams.AssociativeElement#isTotal <em>Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total</em>' attribute.
	 * @see #isTotal()
	 * @generated
	 */
	void setTotal(boolean value);

	/**
	 * Returns the value of the '<em><b>Functional</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Functional</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functional</em>' attribute.
	 * @see #setFunctional(boolean)
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getAssociativeElement_Functional()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isFunctional();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.classdiagrams.AssociativeElement#isFunctional <em>Functional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Functional</em>' attribute.
	 * @see #isFunctional()
	 * @generated
	 */
	void setFunctional(boolean value);

	/**
	 * Returns the value of the '<em><b>Association Type</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link ac.soton.eventb.classdiagrams.AssociationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association Type</em>' attribute.
	 * @see ac.soton.eventb.classdiagrams.AssociationType
	 * @see #setAssociationType(AssociationType)
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getAssociativeElement_AssociationType()
	 * @model default=""
	 * @generated
	 */
	AssociationType getAssociationType();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.classdiagrams.AssociativeElement#getAssociationType <em>Association Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Association Type</em>' attribute.
	 * @see ac.soton.eventb.classdiagrams.AssociationType
	 * @see #getAssociationType()
	 * @generated
	 */
	void setAssociationType(AssociationType value);

} // AssociativeElement
