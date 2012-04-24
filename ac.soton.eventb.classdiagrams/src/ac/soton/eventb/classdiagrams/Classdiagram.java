/**
 * <copyright>
 * </copyright>
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
 *   <li>{@link ac.soton.eventb.classdiagrams.Classdiagram#getClassAssociations <em>Class Associations</em>}</li>
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
	 * Returns the value of the '<em><b>Class Associations</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.eventb.classdiagrams.Association}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Associations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Associations</em>' containment reference list.
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getClassdiagram_ClassAssociations()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Association> getClassAssociations();

} // Classdiagram
