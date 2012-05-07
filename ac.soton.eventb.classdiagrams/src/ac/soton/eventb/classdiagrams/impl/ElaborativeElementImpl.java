/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams.impl;

import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.ElaborativeElement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eventb.emf.core.EventBNamed;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Elaborative Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ElaborativeElementImpl#getElaborates <em>Elaborates</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ElaborativeElementImpl extends EObjectImpl implements ElaborativeElement {
	/**
	 * The cached value of the '{@link #getElaborates() <em>Elaborates</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElaborates()
	 * @generated
	 * @ordered
	 */
	protected EventBNamed elaborates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElaborativeElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassdiagramsPackage.Literals.ELABORATIVE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventBNamed getElaborates() {
		if (elaborates != null && elaborates.eIsProxy()) {
			InternalEObject oldElaborates = (InternalEObject)elaborates;
			elaborates = (EventBNamed)eResolveProxy(oldElaborates);
			if (elaborates != oldElaborates) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassdiagramsPackage.ELABORATIVE_ELEMENT__ELABORATES, oldElaborates, elaborates));
			}
		}
		return elaborates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventBNamed basicGetElaborates() {
		return elaborates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElaborates(EventBNamed newElaborates) {
		EventBNamed oldElaborates = elaborates;
		elaborates = newElaborates;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.ELABORATIVE_ELEMENT__ELABORATES, oldElaborates, elaborates));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassdiagramsPackage.ELABORATIVE_ELEMENT__ELABORATES:
				if (resolve) return getElaborates();
				return basicGetElaborates();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ClassdiagramsPackage.ELABORATIVE_ELEMENT__ELABORATES:
				setElaborates((EventBNamed)newValue);
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
			case ClassdiagramsPackage.ELABORATIVE_ELEMENT__ELABORATES:
				setElaborates((EventBNamed)null);
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
			case ClassdiagramsPackage.ELABORATIVE_ELEMENT__ELABORATES:
				return elaborates != null;
		}
		return super.eIsSet(featureID);
	}

} //ElaborativeElementImpl
