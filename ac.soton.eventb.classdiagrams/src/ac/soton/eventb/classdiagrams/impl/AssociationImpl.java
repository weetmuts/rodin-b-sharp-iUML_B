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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eventb.emf.core.EventBNamed;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.EventBInitialisable;
import ac.soton.eventb.emf.core.extension.coreextension.impl.EventBNamedCommentedRelationDataElaborationElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AssociationImpl#getInitialValue <em>Initial Value</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AssociationImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AssociationImpl#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationImpl extends EventBNamedCommentedRelationDataElaborationElementImpl implements Association {
	/**
	 * The default value of the '{@link #getInitialValue() <em>Initial Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialValue()
	 * @generated
	 * @ordered
	 */
	protected static final String INITIAL_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInitialValue() <em>Initial Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialValue()
	 * @generated
	 * @ordered
	 */
	protected String initialValue = INITIAL_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected ac.soton.eventb.classdiagrams.Class target;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected ac.soton.eventb.classdiagrams.Class source;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassdiagramsPackage.Literals.ASSOCIATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInitialValue() {
		return initialValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialValue(String newInitialValue) {
		String oldInitialValue = initialValue;
		initialValue = newInitialValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.ASSOCIATION__INITIAL_VALUE, oldInitialValue, initialValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ac.soton.eventb.classdiagrams.Class getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (ac.soton.eventb.classdiagrams.Class)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassdiagramsPackage.ASSOCIATION__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ac.soton.eventb.classdiagrams.Class basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(ac.soton.eventb.classdiagrams.Class newTarget, NotificationChain msgs) {
		ac.soton.eventb.classdiagrams.Class oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.ASSOCIATION__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(ac.soton.eventb.classdiagrams.Class newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, ClassdiagramsPackage.CLASS__INCOMING, ac.soton.eventb.classdiagrams.Class.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, ClassdiagramsPackage.CLASS__INCOMING, ac.soton.eventb.classdiagrams.Class.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.ASSOCIATION__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ac.soton.eventb.classdiagrams.Class getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (ac.soton.eventb.classdiagrams.Class)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassdiagramsPackage.ASSOCIATION__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ac.soton.eventb.classdiagrams.Class basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(ac.soton.eventb.classdiagrams.Class newSource, NotificationChain msgs) {
		ac.soton.eventb.classdiagrams.Class oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.ASSOCIATION__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(ac.soton.eventb.classdiagrams.Class newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, ClassdiagramsPackage.CLASS__OUTGOING, ac.soton.eventb.classdiagrams.Class.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, ClassdiagramsPackage.CLASS__OUTGOING, ac.soton.eventb.classdiagrams.Class.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.ASSOCIATION__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClassdiagramsPackage.ASSOCIATION__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, ClassdiagramsPackage.CLASS__INCOMING, ac.soton.eventb.classdiagrams.Class.class, msgs);
				return basicSetTarget((ac.soton.eventb.classdiagrams.Class)otherEnd, msgs);
			case ClassdiagramsPackage.ASSOCIATION__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, ClassdiagramsPackage.CLASS__OUTGOING, ac.soton.eventb.classdiagrams.Class.class, msgs);
				return basicSetSource((ac.soton.eventb.classdiagrams.Class)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClassdiagramsPackage.ASSOCIATION__TARGET:
				return basicSetTarget(null, msgs);
			case ClassdiagramsPackage.ASSOCIATION__SOURCE:
				return basicSetSource(null, msgs);
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
			case ClassdiagramsPackage.ASSOCIATION__INITIAL_VALUE:
				return getInitialValue();
			case ClassdiagramsPackage.ASSOCIATION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case ClassdiagramsPackage.ASSOCIATION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
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
			case ClassdiagramsPackage.ASSOCIATION__INITIAL_VALUE:
				setInitialValue((String)newValue);
				return;
			case ClassdiagramsPackage.ASSOCIATION__TARGET:
				setTarget((ac.soton.eventb.classdiagrams.Class)newValue);
				return;
			case ClassdiagramsPackage.ASSOCIATION__SOURCE:
				setSource((ac.soton.eventb.classdiagrams.Class)newValue);
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
			case ClassdiagramsPackage.ASSOCIATION__INITIAL_VALUE:
				setInitialValue(INITIAL_VALUE_EDEFAULT);
				return;
			case ClassdiagramsPackage.ASSOCIATION__TARGET:
				setTarget((ac.soton.eventb.classdiagrams.Class)null);
				return;
			case ClassdiagramsPackage.ASSOCIATION__SOURCE:
				setSource((ac.soton.eventb.classdiagrams.Class)null);
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
			case ClassdiagramsPackage.ASSOCIATION__INITIAL_VALUE:
				return INITIAL_VALUE_EDEFAULT == null ? initialValue != null : !INITIAL_VALUE_EDEFAULT.equals(initialValue);
			case ClassdiagramsPackage.ASSOCIATION__TARGET:
				return target != null;
			case ClassdiagramsPackage.ASSOCIATION__SOURCE:
				return source != null;
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
		if (baseClass == EventBInitialisable.class) {
			switch (derivedFeatureID) {
				case ClassdiagramsPackage.ASSOCIATION__INITIAL_VALUE: return ClassdiagramsPackage.EVENT_BINITIALISABLE__INITIAL_VALUE;
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
		if (baseClass == EventBInitialisable.class) {
			switch (baseFeatureID) {
				case ClassdiagramsPackage.EVENT_BINITIALISABLE__INITIAL_VALUE: return ClassdiagramsPackage.ASSOCIATION__INITIAL_VALUE;
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
		result.append(" (initialValue: ");
		result.append(initialValue);
		result.append(')');
		return result.toString();
	}

	// Custom //
	
	/**
	 * checks whether this association is refining an attribute or association in the refined class
	 * i.e. if the refined class contains an attribute or association with the same name
	 * @custom
	 */
	public boolean isRefinedElement() {
		ac.soton.eventb.classdiagrams.Class refinedClass = this.getSource()==null? null : this.getSource().getRefines();
		String name = getName();
		if (refinedClass==null || name==null) return false;
		for (EventBNamed en : refinedClass.getClassAttributes()){
			if (en.getName().equals(name)) return true;
		}
		for (EventBNamed en : refinedClass.getOutgoing()){
			if (en.getName().equals(name)) return true;
		}
		return false;
	}

} //AssociationImpl
