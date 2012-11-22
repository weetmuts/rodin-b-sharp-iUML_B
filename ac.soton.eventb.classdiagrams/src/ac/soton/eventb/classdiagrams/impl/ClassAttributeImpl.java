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

import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;

import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.core.extension.coreextension.DataKind;
import ac.soton.eventb.emf.core.extension.coreextension.EventBDataElaboration;
import ac.soton.eventb.emf.core.extension.coreextension.EventBRelationKind;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eventb.emf.core.EventBNamed;

import org.eventb.emf.core.impl.EventBNamedCommentedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassAttributeImpl#getElaborates <em>Elaborates</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassAttributeImpl#getDataKind <em>Data Kind</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassAttributeImpl#isSurjective <em>Surjective</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassAttributeImpl#isInjective <em>Injective</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassAttributeImpl#isTotal <em>Total</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassAttributeImpl#isFunctional <em>Functional</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassAttributeImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassAttributeImpl extends EventBNamedCommentedElementImpl implements ClassAttribute {
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
	 * The default value of the '{@link #getDataKind() <em>Data Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataKind()
	 * @generated
	 * @ordered
	 */
	protected static final DataKind DATA_KIND_EDEFAULT = DataKind.SET;

	/**
	 * The cached value of the '{@link #getDataKind() <em>Data Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataKind()
	 * @generated
	 * @ordered
	 */
	protected DataKind dataKind = DATA_KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #isSurjective() <em>Surjective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSurjective()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SURJECTIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSurjective() <em>Surjective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSurjective()
	 * @generated
	 * @ordered
	 */
	protected boolean surjective = SURJECTIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isInjective() <em>Injective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInjective()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INJECTIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInjective() <em>Injective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInjective()
	 * @generated
	 * @ordered
	 */
	protected boolean injective = INJECTIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isTotal() <em>Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTotal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TOTAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTotal() <em>Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTotal()
	 * @generated
	 * @ordered
	 */
	protected boolean total = TOTAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isFunctional() <em>Functional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFunctional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FUNCTIONAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFunctional() <em>Functional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFunctional()
	 * @generated
	 * @ordered
	 */
	protected boolean functional = FUNCTIONAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getTarget() <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected String target = TARGET_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassdiagramsPackage.Literals.CLASS_ATTRIBUTE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassdiagramsPackage.CLASS_ATTRIBUTE__ELABORATES, oldElaborates, elaborates));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS_ATTRIBUTE__ELABORATES, oldElaborates, elaborates));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataKind getDataKind() {
		return dataKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataKind(DataKind newDataKind) {
		DataKind oldDataKind = dataKind;
		dataKind = newDataKind == null ? DATA_KIND_EDEFAULT : newDataKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS_ATTRIBUTE__DATA_KIND, oldDataKind, dataKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSurjective() {
		return surjective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSurjective(boolean newSurjective) {
		boolean oldSurjective = surjective;
		surjective = newSurjective;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS_ATTRIBUTE__SURJECTIVE, oldSurjective, surjective));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInjective() {
		return injective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInjective(boolean newInjective) {
		boolean oldInjective = injective;
		injective = newInjective;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS_ATTRIBUTE__INJECTIVE, oldInjective, injective));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTotal() {
		return total;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotal(boolean newTotal) {
		boolean oldTotal = total;
		total = newTotal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS_ATTRIBUTE__TOTAL, oldTotal, total));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFunctional() {
		return functional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctional(boolean newFunctional) {
		boolean oldFunctional = functional;
		functional = newFunctional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS_ATTRIBUTE__FUNCTIONAL, oldFunctional, functional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(String newTarget) {
		String oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS_ATTRIBUTE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__ELABORATES:
				if (resolve) return getElaborates();
				return basicGetElaborates();
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__DATA_KIND:
				return getDataKind();
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__SURJECTIVE:
				return isSurjective();
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__INJECTIVE:
				return isInjective();
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__TOTAL:
				return isTotal();
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__FUNCTIONAL:
				return isFunctional();
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__TARGET:
				return getTarget();
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
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__ELABORATES:
				setElaborates((EventBNamed)newValue);
				return;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__DATA_KIND:
				setDataKind((DataKind)newValue);
				return;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__SURJECTIVE:
				setSurjective((Boolean)newValue);
				return;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__INJECTIVE:
				setInjective((Boolean)newValue);
				return;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__TOTAL:
				setTotal((Boolean)newValue);
				return;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__FUNCTIONAL:
				setFunctional((Boolean)newValue);
				return;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__TARGET:
				setTarget((String)newValue);
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
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__ELABORATES:
				setElaborates((EventBNamed)null);
				return;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__DATA_KIND:
				setDataKind(DATA_KIND_EDEFAULT);
				return;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__SURJECTIVE:
				setSurjective(SURJECTIVE_EDEFAULT);
				return;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__INJECTIVE:
				setInjective(INJECTIVE_EDEFAULT);
				return;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__TOTAL:
				setTotal(TOTAL_EDEFAULT);
				return;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__FUNCTIONAL:
				setFunctional(FUNCTIONAL_EDEFAULT);
				return;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__TARGET:
				setTarget(TARGET_EDEFAULT);
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
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__ELABORATES:
				return elaborates != null;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__DATA_KIND:
				return dataKind != DATA_KIND_EDEFAULT;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__SURJECTIVE:
				return surjective != SURJECTIVE_EDEFAULT;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__INJECTIVE:
				return injective != INJECTIVE_EDEFAULT;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__TOTAL:
				return total != TOTAL_EDEFAULT;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__FUNCTIONAL:
				return functional != FUNCTIONAL_EDEFAULT;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__TARGET:
				return TARGET_EDEFAULT == null ? target != null : !TARGET_EDEFAULT.equals(target);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == EventBDataElaboration.class) {
			switch (derivedFeatureID) {
				case ClassdiagramsPackage.CLASS_ATTRIBUTE__ELABORATES: return CoreextensionPackage.EVENT_BDATA_ELABORATION__ELABORATES;
				case ClassdiagramsPackage.CLASS_ATTRIBUTE__DATA_KIND: return CoreextensionPackage.EVENT_BDATA_ELABORATION__DATA_KIND;
				default: return -1;
			}
		}
		if (baseClass == EventBRelationKind.class) {
			switch (derivedFeatureID) {
				case ClassdiagramsPackage.CLASS_ATTRIBUTE__SURJECTIVE: return CoreextensionPackage.EVENT_BRELATION_KIND__SURJECTIVE;
				case ClassdiagramsPackage.CLASS_ATTRIBUTE__INJECTIVE: return CoreextensionPackage.EVENT_BRELATION_KIND__INJECTIVE;
				case ClassdiagramsPackage.CLASS_ATTRIBUTE__TOTAL: return CoreextensionPackage.EVENT_BRELATION_KIND__TOTAL;
				case ClassdiagramsPackage.CLASS_ATTRIBUTE__FUNCTIONAL: return CoreextensionPackage.EVENT_BRELATION_KIND__FUNCTIONAL;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == EventBDataElaboration.class) {
			switch (baseFeatureID) {
				case CoreextensionPackage.EVENT_BDATA_ELABORATION__ELABORATES: return ClassdiagramsPackage.CLASS_ATTRIBUTE__ELABORATES;
				case CoreextensionPackage.EVENT_BDATA_ELABORATION__DATA_KIND: return ClassdiagramsPackage.CLASS_ATTRIBUTE__DATA_KIND;
				default: return -1;
			}
		}
		if (baseClass == EventBRelationKind.class) {
			switch (baseFeatureID) {
				case CoreextensionPackage.EVENT_BRELATION_KIND__SURJECTIVE: return ClassdiagramsPackage.CLASS_ATTRIBUTE__SURJECTIVE;
				case CoreextensionPackage.EVENT_BRELATION_KIND__INJECTIVE: return ClassdiagramsPackage.CLASS_ATTRIBUTE__INJECTIVE;
				case CoreextensionPackage.EVENT_BRELATION_KIND__TOTAL: return ClassdiagramsPackage.CLASS_ATTRIBUTE__TOTAL;
				case CoreextensionPackage.EVENT_BRELATION_KIND__FUNCTIONAL: return ClassdiagramsPackage.CLASS_ATTRIBUTE__FUNCTIONAL;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (dataKind: ");
		result.append(dataKind);
		result.append(", surjective: ");
		result.append(surjective);
		result.append(", injective: ");
		result.append(injective);
		result.append(", total: ");
		result.append(total);
		result.append(", functional: ");
		result.append(functional);
		result.append(", target: ");
		result.append(target);
		result.append(')');
		return result.toString();
	}

} //ClassAttributeImpl
