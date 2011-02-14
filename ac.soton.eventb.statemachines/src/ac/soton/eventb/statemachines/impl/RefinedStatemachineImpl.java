/**
 * Copyright (c) 2010
 * University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package ac.soton.eventb.statemachines.impl;

import ac.soton.eventb.statemachines.AbstractStatemachine;
import ac.soton.eventb.statemachines.EventBLabeled;
import ac.soton.eventb.statemachines.RefinedState;
import ac.soton.eventb.statemachines.RefinedStatemachine;
import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.StatemachinesPackage;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBNamed;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Refined Statemachine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.statemachines.impl.RefinedStatemachineImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.RefinedStatemachineImpl#getExtensionId <em>Extension Id</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.RefinedStatemachineImpl#getRefines <em>Refines</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RefinedStatemachineImpl extends DiagramRootImpl implements RefinedStatemachine {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2010\rUniversity of Southampton.\rAll rights reserved. This program and the accompanying materials  are made\ravailable under the terms of the Eclipse Public License v1.0 which accompanies this \rdistribution, and is available at http://www.eclipse.org/legal/epl-v10.html\n";

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getExtensionId() <em>Extension Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionId()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTENSION_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExtensionId() <em>Extension Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionId()
	 * @generated
	 * @ordered
	 */
	protected String extensionId = EXTENSION_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRefines() <em>Refines</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefines()
	 * @generated
	 * @ordered
	 */
	protected AbstractStatemachine refines;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RefinedStatemachineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatemachinesPackage.Literals.REFINED_STATEMACHINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getLabel() {
		if (getRefines() instanceof EventBNamed){
			return ((EventBNamed) getRefines()).getName();
		}else if (getRefines() instanceof EventBLabeled){
			return ((EventBLabeled) getRefines()).getLabel();
		}else return "<no label - fix refines>";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		// TODO: implement this method to set the 'Label' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExtensionId() {
		return extensionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtensionId(String newExtensionId) {
		String oldExtensionId = extensionId;
		extensionId = newExtensionId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.REFINED_STATEMACHINE__EXTENSION_ID, oldExtensionId, extensionId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * Added adapter to refined statemachine to get notified about its label change.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AbstractStatemachine getRefines() {
		if (refines != null && refines.eIsProxy()) {
			InternalEObject oldRefines = (InternalEObject)refines;
			refines = (AbstractStatemachine)eResolveProxy(oldRefines);
			if (refines != oldRefines) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StatemachinesPackage.REFINED_STATEMACHINE__REFINES, oldRefines, refines));
			}
		}

		if (refines != refinedStatemachineAdapter.getTarget()) {
			if (refinedStatemachineAdapter.getTarget() != null) {
				refinedStatemachineAdapter.getTarget().eAdapters().remove(refinedStatemachineAdapter);
			}
			if (refines != null) {
				refines.eAdapters().add(refinedStatemachineAdapter);
			}
		}
		return refines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractStatemachine basicGetRefines() {
		return refines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Added label notification.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRefines(AbstractStatemachine newRefines) {
		AbstractStatemachine oldRefines = refines;
		refines = newRefines;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.REFINED_STATEMACHINE__REFINES, oldRefines, refines));
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.REFINED_STATEMACHINE__LABEL, oldRefines, refines));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StatemachinesPackage.REFINED_STATEMACHINE__LABEL:
				return getLabel();
			case StatemachinesPackage.REFINED_STATEMACHINE__EXTENSION_ID:
				return getExtensionId();
			case StatemachinesPackage.REFINED_STATEMACHINE__REFINES:
				if (resolve) return getRefines();
				return basicGetRefines();
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
			case StatemachinesPackage.REFINED_STATEMACHINE__LABEL:
				setLabel((String)newValue);
				return;
			case StatemachinesPackage.REFINED_STATEMACHINE__EXTENSION_ID:
				setExtensionId((String)newValue);
				return;
			case StatemachinesPackage.REFINED_STATEMACHINE__REFINES:
				setRefines((AbstractStatemachine)newValue);
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
			case StatemachinesPackage.REFINED_STATEMACHINE__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case StatemachinesPackage.REFINED_STATEMACHINE__EXTENSION_ID:
				setExtensionId(EXTENSION_ID_EDEFAULT);
				return;
			case StatemachinesPackage.REFINED_STATEMACHINE__REFINES:
				setRefines((AbstractStatemachine)null);
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
			case StatemachinesPackage.REFINED_STATEMACHINE__LABEL:
				return LABEL_EDEFAULT == null ? getLabel() != null : !LABEL_EDEFAULT.equals(getLabel());
			case StatemachinesPackage.REFINED_STATEMACHINE__EXTENSION_ID:
				return EXTENSION_ID_EDEFAULT == null ? extensionId != null : !EXTENSION_ID_EDEFAULT.equals(extensionId);
			case StatemachinesPackage.REFINED_STATEMACHINE__REFINES:
				return refines != null;
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
		if (baseClass == EventBLabeled.class) {
			switch (derivedFeatureID) {
				case StatemachinesPackage.REFINED_STATEMACHINE__LABEL: return StatemachinesPackage.EVENT_BLABELED__LABEL;
				default: return -1;
			}
		}
		if (baseClass == AbstractExtension.class) {
			switch (derivedFeatureID) {
				case StatemachinesPackage.REFINED_STATEMACHINE__EXTENSION_ID: return CorePackage.ABSTRACT_EXTENSION__EXTENSION_ID;
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
		if (baseClass == EventBLabeled.class) {
			switch (baseFeatureID) {
				case StatemachinesPackage.EVENT_BLABELED__LABEL: return StatemachinesPackage.REFINED_STATEMACHINE__LABEL;
				default: return -1;
			}
		}
		if (baseClass == AbstractExtension.class) {
			switch (baseFeatureID) {
				case CorePackage.ABSTRACT_EXTENSION__EXTENSION_ID: return StatemachinesPackage.REFINED_STATEMACHINE__EXTENSION_ID;
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
		result.append(" (extensionId: ");
		result.append(extensionId);
		result.append(')');
		return result.toString();
	}

	/**
	 * An adapter for a statemachine refined by this statemachine to get notified about the referenced statemachines's name/label changes
	 * and update this statemachine's label.
	 */
	protected Adapter refinedStatemachineAdapter = new AdapterImpl() {
		public void notifyChanged(Notification notification) {
			if (notification.getFeatureID(State.class) == StatemachinesPackage.STATEMACHINE__NAME
					|| notification.getFeatureID(RefinedState.class) == StatemachinesPackage.REFINED_STATEMACHINE__LABEL)
				eNotify(new ENotificationImpl(RefinedStatemachineImpl.this, Notification.SET, StatemachinesPackage.REFINED_STATEMACHINE__LABEL, notification.getOldValue(), notification.getNewValue()));
		}
	};

} //RefinedStatemachineImpl
