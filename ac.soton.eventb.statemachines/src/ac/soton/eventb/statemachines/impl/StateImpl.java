/**
 * Copyright (c) 2010-2015
 * University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 *
 * $Id$
 */
package ac.soton.eventb.statemachines.impl;

import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.core.extension.coreextension.DataKind;
import ac.soton.eventb.emf.core.extension.coreextension.EventBDataElaboration;

import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachineOwner;
import ac.soton.eventb.statemachines.StatemachinesPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eventb.emf.core.EventBNamed;

import org.eventb.emf.core.machine.Action;
import org.eventb.emf.core.machine.Invariant;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.statemachines.impl.StateImpl#getElaborates <em>Elaborates</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.StateImpl#getDataKind <em>Data Kind</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.StateImpl#getStatemachines <em>Statemachines</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.StateImpl#getRefines <em>Refines</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.StateImpl#getInvariants <em>Invariants</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.StateImpl#isActive <em>Active</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.StateImpl#getActiveInstances <em>Active Instances</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.StateImpl#getEntryActions <em>Entry Actions</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.StateImpl#getExitActions <em>Exit Actions</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.StateImpl#getTimeout <em>Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateImpl extends AbstractNodeImpl implements State {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2010-2015\rUniversity of Southampton.\rAll rights reserved. This program and the accompanying materials  are made\ravailable under the terms of the Eclipse Public License v1.0 which accompanies this \rdistribution, and is available at http://www.eclipse.org/legal/epl-v10.html\n";

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
	protected static final DataKind DATA_KIND_EDEFAULT = DataKind.VARIABLE;

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
	 * The cached value of the '{@link #getStatemachines() <em>Statemachines</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatemachines()
	 * @generated
	 * @ordered
	 */
	protected EList<Statemachine> statemachines;

	/**
	 * The cached value of the '{@link #getRefines() <em>Refines</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefines()
	 * @generated
	 * @ordered
	 */
	protected State refines;

	/**
	 * The cached value of the '{@link #getInvariants() <em>Invariants</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvariants()
	 * @generated
	 * @ordered
	 */
	protected EList<Invariant> invariants;

	/**
	 * The default value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ACTIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected boolean active = ACTIVE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getActiveInstances() <em>Active Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActiveInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<?> activeInstances;

	/**
	 * The cached value of the '{@link #getEntryActions() <em>Entry Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> entryActions;

	/**
	 * The cached value of the '{@link #getExitActions() <em>Exit Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExitActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> exitActions;

	/**
	 * The default value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final Integer TIMEOUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected Integer timeout = TIMEOUT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatemachinesPackage.Literals.STATE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StatemachinesPackage.STATE__ELABORATES, oldElaborates, elaborates));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.STATE__ELABORATES, oldElaborates, elaborates));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.STATE__DATA_KIND, oldDataKind, dataKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Statemachine> getStatemachines() {
		if (statemachines == null) {
			statemachines = new EObjectContainmentEList<Statemachine>(Statemachine.class, this, StatemachinesPackage.STATE__STATEMACHINES);
		}
		return statemachines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getRefines() {
		if (refines != null && refines.eIsProxy()) {
			InternalEObject oldRefines = (InternalEObject)refines;
			refines = (State)eResolveProxy(oldRefines);
			if (refines != oldRefines) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StatemachinesPackage.STATE__REFINES, oldRefines, refines));
			}
		}
		return refines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetRefines() {
		return refines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * On refines change also notify about name change.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRefines(State newRefines) {
		State oldRefines = refines;
		String oldName = getName();
		refines = newRefines;
		String newName = getName();
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.STATE__REFINES, oldRefines, refines));
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.STATE__NAME,  oldName, newName));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Invariant> getInvariants() {
		if (invariants == null) {
			invariants = new EObjectContainmentEList.Resolving<Invariant>(Invariant.class, this, StatemachinesPackage.STATE__INVARIANTS);
		}
		return invariants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActive(boolean newActive) {
		boolean oldActive = active;
		active = newActive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.STATE__ACTIVE, oldActive, active));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<?> getActiveInstances() {
		return activeInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActiveInstances(EList<?> newActiveInstances) {
		EList<?> oldActiveInstances = activeInstances;
		activeInstances = newActiveInstances;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.STATE__ACTIVE_INSTANCES, oldActiveInstances, activeInstances));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getEntryActions() {
		if (entryActions == null) {
			entryActions = new EObjectContainmentEList.Resolving<Action>(Action.class, this, StatemachinesPackage.STATE__ENTRY_ACTIONS);
		}
		return entryActions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getExitActions() {
		if (exitActions == null) {
			exitActions = new EObjectContainmentEList.Resolving<Action>(Action.class, this, StatemachinesPackage.STATE__EXIT_ACTIONS);
		}
		return exitActions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getTimeout() {
		return timeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeout(Integer newTimeout) {
		Integer oldTimeout = timeout;
		timeout = newTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.STATE__TIMEOUT, oldTimeout, timeout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatemachinesPackage.STATE__STATEMACHINES:
				return ((InternalEList<?>)getStatemachines()).basicRemove(otherEnd, msgs);
			case StatemachinesPackage.STATE__INVARIANTS:
				return ((InternalEList<?>)getInvariants()).basicRemove(otherEnd, msgs);
			case StatemachinesPackage.STATE__ENTRY_ACTIONS:
				return ((InternalEList<?>)getEntryActions()).basicRemove(otherEnd, msgs);
			case StatemachinesPackage.STATE__EXIT_ACTIONS:
				return ((InternalEList<?>)getExitActions()).basicRemove(otherEnd, msgs);
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
			case StatemachinesPackage.STATE__ELABORATES:
				if (resolve) return getElaborates();
				return basicGetElaborates();
			case StatemachinesPackage.STATE__DATA_KIND:
				return getDataKind();
			case StatemachinesPackage.STATE__STATEMACHINES:
				return getStatemachines();
			case StatemachinesPackage.STATE__REFINES:
				if (resolve) return getRefines();
				return basicGetRefines();
			case StatemachinesPackage.STATE__INVARIANTS:
				return getInvariants();
			case StatemachinesPackage.STATE__ACTIVE:
				return isActive();
			case StatemachinesPackage.STATE__ACTIVE_INSTANCES:
				return getActiveInstances();
			case StatemachinesPackage.STATE__ENTRY_ACTIONS:
				return getEntryActions();
			case StatemachinesPackage.STATE__EXIT_ACTIONS:
				return getExitActions();
			case StatemachinesPackage.STATE__TIMEOUT:
				return getTimeout();
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
			case StatemachinesPackage.STATE__ELABORATES:
				setElaborates((EventBNamed)newValue);
				return;
			case StatemachinesPackage.STATE__DATA_KIND:
				setDataKind((DataKind)newValue);
				return;
			case StatemachinesPackage.STATE__STATEMACHINES:
				getStatemachines().clear();
				getStatemachines().addAll((Collection<? extends Statemachine>)newValue);
				return;
			case StatemachinesPackage.STATE__REFINES:
				setRefines((State)newValue);
				return;
			case StatemachinesPackage.STATE__INVARIANTS:
				getInvariants().clear();
				getInvariants().addAll((Collection<? extends Invariant>)newValue);
				return;
			case StatemachinesPackage.STATE__ACTIVE:
				setActive((Boolean)newValue);
				return;
			case StatemachinesPackage.STATE__ACTIVE_INSTANCES:
				setActiveInstances((EList<?>)newValue);
				return;
			case StatemachinesPackage.STATE__ENTRY_ACTIONS:
				getEntryActions().clear();
				getEntryActions().addAll((Collection<? extends Action>)newValue);
				return;
			case StatemachinesPackage.STATE__EXIT_ACTIONS:
				getExitActions().clear();
				getExitActions().addAll((Collection<? extends Action>)newValue);
				return;
			case StatemachinesPackage.STATE__TIMEOUT:
				setTimeout((Integer)newValue);
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
			case StatemachinesPackage.STATE__ELABORATES:
				setElaborates((EventBNamed)null);
				return;
			case StatemachinesPackage.STATE__DATA_KIND:
				setDataKind(DATA_KIND_EDEFAULT);
				return;
			case StatemachinesPackage.STATE__STATEMACHINES:
				getStatemachines().clear();
				return;
			case StatemachinesPackage.STATE__REFINES:
				setRefines((State)null);
				return;
			case StatemachinesPackage.STATE__INVARIANTS:
				getInvariants().clear();
				return;
			case StatemachinesPackage.STATE__ACTIVE:
				setActive(ACTIVE_EDEFAULT);
				return;
			case StatemachinesPackage.STATE__ACTIVE_INSTANCES:
				setActiveInstances((EList<?>)null);
				return;
			case StatemachinesPackage.STATE__ENTRY_ACTIONS:
				getEntryActions().clear();
				return;
			case StatemachinesPackage.STATE__EXIT_ACTIONS:
				getExitActions().clear();
				return;
			case StatemachinesPackage.STATE__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
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
			case StatemachinesPackage.STATE__ELABORATES:
				return elaborates != null;
			case StatemachinesPackage.STATE__DATA_KIND:
				return dataKind != DATA_KIND_EDEFAULT;
			case StatemachinesPackage.STATE__STATEMACHINES:
				return statemachines != null && !statemachines.isEmpty();
			case StatemachinesPackage.STATE__REFINES:
				return refines != null;
			case StatemachinesPackage.STATE__INVARIANTS:
				return invariants != null && !invariants.isEmpty();
			case StatemachinesPackage.STATE__ACTIVE:
				return active != ACTIVE_EDEFAULT;
			case StatemachinesPackage.STATE__ACTIVE_INSTANCES:
				return activeInstances != null;
			case StatemachinesPackage.STATE__ENTRY_ACTIONS:
				return entryActions != null && !entryActions.isEmpty();
			case StatemachinesPackage.STATE__EXIT_ACTIONS:
				return exitActions != null && !exitActions.isEmpty();
			case StatemachinesPackage.STATE__TIMEOUT:
				return TIMEOUT_EDEFAULT == null ? timeout != null : !TIMEOUT_EDEFAULT.equals(timeout);
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
				case StatemachinesPackage.STATE__ELABORATES: return CoreextensionPackage.EVENT_BDATA_ELABORATION__ELABORATES;
				case StatemachinesPackage.STATE__DATA_KIND: return CoreextensionPackage.EVENT_BDATA_ELABORATION__DATA_KIND;
				default: return -1;
			}
		}
		if (baseClass == StatemachineOwner.class) {
			switch (derivedFeatureID) {
				case StatemachinesPackage.STATE__STATEMACHINES: return StatemachinesPackage.STATEMACHINE_OWNER__STATEMACHINES;
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
				case CoreextensionPackage.EVENT_BDATA_ELABORATION__ELABORATES: return StatemachinesPackage.STATE__ELABORATES;
				case CoreextensionPackage.EVENT_BDATA_ELABORATION__DATA_KIND: return StatemachinesPackage.STATE__DATA_KIND;
				default: return -1;
			}
		}
		if (baseClass == StatemachineOwner.class) {
			switch (baseFeatureID) {
				case StatemachinesPackage.STATEMACHINE_OWNER__STATEMACHINES: return StatemachinesPackage.STATE__STATEMACHINES;
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
		result.append(", active: ");
		result.append(active);
		result.append(", activeInstances: ");
		result.append(activeInstances);
		result.append(", timeout: ");
		result.append(timeout);
		result.append(')');
		return result.toString();
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * if refines is set the name of this state is the name of the refined state
	 * otherwise return the local name of this state
	 * <!-- end-user-doc -->
	 * @custom
	 */
	@Override
	public String getName() {
		State refines = getRefines();
		if (refines != null){
			return refines.getName();
		} else return doGetName();
	}

	
} //StateImpl
