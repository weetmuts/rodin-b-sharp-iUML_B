/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams;

import org.eclipse.emf.common.util.EList;

import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamedCommentedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.Class#isConstant <em>Constant</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.Class#getSupertypes <em>Supertypes</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.Class#getSource <em>Source</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.Class#getClassAttributes <em>Class Attributes</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.Class#getClassEvents <em>Class Events</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.Class#getClassInvariants <em>Class Invariants</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.Class#getClassAxioms <em>Class Axioms</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.Class#getInstances <em>Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends EventBElement {
	/**
	 * Returns the value of the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant</em>' attribute.
	 * @see #setConstant(boolean)
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getClass_Constant()
	 * @model
	 * @generated
	 */
	boolean isConstant();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.classdiagrams.Class#isConstant <em>Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant</em>' attribute.
	 * @see #isConstant()
	 * @generated
	 */
	void setConstant(boolean value);

	/**
	 * Returns the value of the '<em><b>Supertypes</b></em>' reference list.
	 * The list contents are of type {@link ac.soton.eventb.classdiagrams.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supertypes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supertypes</em>' reference list.
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getClass_Supertypes()
	 * @model
	 * @generated
	 */
	EList<Class> getSupertypes();

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference list.
	 * The list contents are of type {@link ac.soton.eventb.classdiagrams.Association}.
	 * It is bidirectional and its opposite is '{@link ac.soton.eventb.classdiagrams.Association#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference list.
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getClass_Source()
	 * @see ac.soton.eventb.classdiagrams.Association#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Association> getSource();

	/**
	 * Returns the value of the '<em><b>Class Attributes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Attributes</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Attributes</em>' containment reference.
	 * @see #setClassAttributes(ClassAttribute)
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getClass_ClassAttributes()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ClassAttribute getClassAttributes();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.classdiagrams.Class#getClassAttributes <em>Class Attributes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Attributes</em>' containment reference.
	 * @see #getClassAttributes()
	 * @generated
	 */
	void setClassAttributes(ClassAttribute value);

	/**
	 * Returns the value of the '<em><b>Class Events</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.eventb.classdiagrams.ClassEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Events</em>' containment reference list.
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getClass_ClassEvents()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ClassEvent> getClassEvents();

	/**
	 * Returns the value of the '<em><b>Class Invariants</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.eventb.classdiagrams.ClassInvariant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Invariants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Invariants</em>' containment reference list.
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getClass_ClassInvariants()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ClassInvariant> getClassInvariants();

	/**
	 * Returns the value of the '<em><b>Class Axioms</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.eventb.classdiagrams.ClassAxiom}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Axioms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Axioms</em>' containment reference list.
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getClass_ClassAxioms()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ClassAxiom> getClassAxioms();

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
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getClass_Instances()
	 * @model
	 * @generated
	 */
	EventBNamedCommentedElement getInstances();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.classdiagrams.Class#getInstances <em>Instances</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instances</em>' reference.
	 * @see #getInstances()
	 * @generated
	 */
	void setInstances(EventBNamedCommentedElement value);

} // Class
