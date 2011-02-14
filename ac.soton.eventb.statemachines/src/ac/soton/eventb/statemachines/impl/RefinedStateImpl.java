/**
 * Copyright (c) 2010
 * University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 *
 * $Id$
 */
package ac.soton.eventb.statemachines.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eventb.emf.core.EventBNamed;

import ac.soton.eventb.statemachines.AbstractState;
import ac.soton.eventb.statemachines.EventBLabeled;
import ac.soton.eventb.statemachines.RefinedState;
import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.StatemachinesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Refined State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.statemachines.impl.RefinedStateImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.RefinedStateImpl#getRefines <em>Refines</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RefinedStateImpl extends AbstractStateImpl implements RefinedState {
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
	 * The cached value of the '{@link #getRefines() <em>Refines</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefines()
	 * @generated
	 * @ordered
	 */
	protected AbstractState refines;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RefinedStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatemachinesPackage.Literals.REFINED_STATE;
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
	 * Added adapter to refined state to get notified about its label change.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AbstractState getRefines() {
		if (refines != null && refines.eIsProxy()) {
			InternalEObject oldRefines = (InternalEObject)refines;
			refines = (AbstractState)eResolveProxy(oldRefines);
			if (refines != oldRefines) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StatemachinesPackage.REFINED_STATE__REFINES, oldRefines, refines));
			}
		}
		if (refines != refinedStateAdapter.getTarget()) {
			if (refinedStateAdapter.getTarget() != null) {
				refinedStateAdapter.getTarget().eAdapters().remove(refinedStateAdapter);
			}
			if (refines != null) {
				refines.eAdapters().add(refinedStateAdapter);
			}
		}
		return refines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractState basicGetRefines() {
		return refines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Added label notification.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRefines(AbstractState newRefines) {
		AbstractState oldRefines = refines;
		refines = newRefines;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.REFINED_STATE__REFINES, oldRefines, refines));
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.REFINED_STATE__LABEL, oldRefines, refines));
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
			case StatemachinesPackage.REFINED_STATE__LABEL:
				return getLabel();
			case StatemachinesPackage.REFINED_STATE__REFINES:
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
			case StatemachinesPackage.REFINED_STATE__LABEL:
				setLabel((String)newValue);
				return;
			case StatemachinesPackage.REFINED_STATE__REFINES:
				setRefines((AbstractState)newValue);
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
			case StatemachinesPackage.REFINED_STATE__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case StatemachinesPackage.REFINED_STATE__REFINES:
				setRefines((AbstractState)null);
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
			case StatemachinesPackage.REFINED_STATE__LABEL:
				return LABEL_EDEFAULT == null ? getLabel() != null : !LABEL_EDEFAULT.equals(getLabel());
			case StatemachinesPackage.REFINED_STATE__REFINES:
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
				case StatemachinesPackage.REFINED_STATE__LABEL: return StatemachinesPackage.EVENT_BLABELED__LABEL;
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
				case StatemachinesPackage.EVENT_BLABELED__LABEL: return StatemachinesPackage.REFINED_STATE__LABEL;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}
	
	/**
	 * An adapter for a state refined by this state to get notified about the referenced state's name/label changes
	 * and update this state's label.
	 */
	protected Adapter refinedStateAdapter = new AdapterImpl() {
		public void notifyChanged(Notification notification) {
			if (notification.getFeatureID(State.class) == StatemachinesPackage.STATE__NAME
					|| notification.getFeatureID(RefinedState.class) == StatemachinesPackage.REFINED_STATE__LABEL)
				eNotify(new ENotificationImpl(RefinedStateImpl.this, Notification.SET, StatemachinesPackage.REFINED_STATE__LABEL, notification.getOldValue(), notification.getNewValue()));
		}
	};

} //RefinedStateImpl
