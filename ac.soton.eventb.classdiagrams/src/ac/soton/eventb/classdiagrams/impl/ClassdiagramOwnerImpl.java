/**
 * Copyright (c) 2012 - University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams.impl;

import ac.soton.eventb.classdiagrams.Classdiagram;
import ac.soton.eventb.classdiagrams.ClassdiagramOwner;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classdiagram Owner</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassdiagramOwnerImpl#getClassdiagrams <em>Classdiagrams</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ClassdiagramOwnerImpl extends EObjectImpl implements ClassdiagramOwner {
	/**
	 * The cached value of the '{@link #getClassdiagrams() <em>Classdiagrams</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassdiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList<Classdiagram> classdiagrams;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassdiagramOwnerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassdiagramsPackage.Literals.CLASSDIAGRAM_OWNER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Classdiagram> getClassdiagrams() {
		if (classdiagrams == null) {
			classdiagrams = new EObjectContainmentEList.Resolving<Classdiagram>(Classdiagram.class, this, ClassdiagramsPackage.CLASSDIAGRAM_OWNER__CLASSDIAGRAMS);
		}
		return classdiagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClassdiagramsPackage.CLASSDIAGRAM_OWNER__CLASSDIAGRAMS:
				return ((InternalEList<?>)getClassdiagrams()).basicRemove(otherEnd, msgs);
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
			case ClassdiagramsPackage.CLASSDIAGRAM_OWNER__CLASSDIAGRAMS:
				return getClassdiagrams();
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
			case ClassdiagramsPackage.CLASSDIAGRAM_OWNER__CLASSDIAGRAMS:
				getClassdiagrams().clear();
				getClassdiagrams().addAll((Collection<? extends Classdiagram>)newValue);
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
			case ClassdiagramsPackage.CLASSDIAGRAM_OWNER__CLASSDIAGRAMS:
				getClassdiagrams().clear();
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
			case ClassdiagramsPackage.CLASSDIAGRAM_OWNER__CLASSDIAGRAMS:
				return classdiagrams != null && !classdiagrams.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ClassdiagramOwnerImpl
