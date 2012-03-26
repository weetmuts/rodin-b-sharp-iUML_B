/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eventb.emf.core.EventBNamedCommentedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Diagram Owner</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.ClassDiagramOwner#getClassDiagrams <em>Class Diagrams</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.ClassDiagramOwner#getDiagrams <em>Diagrams</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getClassDiagramOwner()
 * @model abstract="true"
 * @generated
 */
public interface ClassDiagramOwner extends EObject {
	/**
	 * Returns the value of the '<em><b>Class Diagrams</b></em>' containment reference list.
	 * The list contents are of type {@link org.eventb.emf.core.EventBNamedCommentedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Diagrams</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Diagrams</em>' containment reference list.
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getClassDiagramOwner_ClassDiagrams()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<EventBNamedCommentedElement> getClassDiagrams();

	/**
	 * Returns the value of the '<em><b>Diagrams</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.eventb.classdiagrams.ClassDiagram}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagrams</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagrams</em>' containment reference list.
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getClassDiagramOwner_Diagrams()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ClassDiagram> getDiagrams();

} // ClassDiagramOwner
