/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams.impl;

import ac.soton.eventb.classdiagrams.ClassDiagram;
import ac.soton.eventb.classdiagrams.ClassDiagramOwner;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eventb.emf.core.EventBNamedCommentedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Diagram Owner</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassDiagramOwnerImpl#getClassDiagrams <em>Class Diagrams</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassDiagramOwnerImpl#getDiagrams <em>Diagrams</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ClassDiagramOwnerImpl extends EObjectImpl implements ClassDiagramOwner {
	/**
	 * The cached value of the '{@link #getClassDiagrams() <em>Class Diagrams</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassDiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList<EventBNamedCommentedElement> classDiagrams;

	/**
	 * The cached value of the '{@link #getDiagrams() <em>Diagrams</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassDiagram> diagrams;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassDiagramOwnerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassdiagramsPackage.Literals.CLASS_DIAGRAM_OWNER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventBNamedCommentedElement> getClassDiagrams() {
		if (classDiagrams == null) {
			classDiagrams = new EObjectContainmentEList.Resolving<EventBNamedCommentedElement>(EventBNamedCommentedElement.class, this, ClassdiagramsPackage.CLASS_DIAGRAM_OWNER__CLASS_DIAGRAMS);
		}
		return classDiagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassDiagram> getDiagrams() {
		if (diagrams == null) {
			diagrams = new EObjectContainmentEList.Resolving<ClassDiagram>(ClassDiagram.class, this, ClassdiagramsPackage.CLASS_DIAGRAM_OWNER__DIAGRAMS);
		}
		return diagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClassdiagramsPackage.CLASS_DIAGRAM_OWNER__CLASS_DIAGRAMS:
				return ((InternalEList<?>)getClassDiagrams()).basicRemove(otherEnd, msgs);
			case ClassdiagramsPackage.CLASS_DIAGRAM_OWNER__DIAGRAMS:
				return ((InternalEList<?>)getDiagrams()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassdiagramsPackage.CLASS_DIAGRAM_OWNER__CLASS_DIAGRAMS:
				return getClassDiagrams();
			case ClassdiagramsPackage.CLASS_DIAGRAM_OWNER__DIAGRAMS:
				return getDiagrams();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ClassdiagramsPackage.CLASS_DIAGRAM_OWNER__CLASS_DIAGRAMS:
				getClassDiagrams().clear();
				getClassDiagrams().addAll((Collection<? extends EventBNamedCommentedElement>)newValue);
				return;
			case ClassdiagramsPackage.CLASS_DIAGRAM_OWNER__DIAGRAMS:
				getDiagrams().clear();
				getDiagrams().addAll((Collection<? extends ClassDiagram>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ClassdiagramsPackage.CLASS_DIAGRAM_OWNER__CLASS_DIAGRAMS:
				getClassDiagrams().clear();
				return;
			case ClassdiagramsPackage.CLASS_DIAGRAM_OWNER__DIAGRAMS:
				getDiagrams().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ClassdiagramsPackage.CLASS_DIAGRAM_OWNER__CLASS_DIAGRAMS:
				return classDiagrams != null && !classDiagrams.isEmpty();
			case ClassdiagramsPackage.CLASS_DIAGRAM_OWNER__DIAGRAMS:
				return diagrams != null && !diagrams.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ClassDiagramOwnerImpl
