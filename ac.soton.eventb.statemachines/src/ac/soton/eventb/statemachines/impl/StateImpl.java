/**
 * Copyright (c) 2010
 * University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package ac.soton.eventb.statemachines.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.machine.Invariant;

import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachineOwner;
import ac.soton.eventb.statemachines.StatemachinesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.statemachines.impl.StateImpl#getName <em>Name</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.StateImpl#getStatemachines <em>Statemachines</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.StateImpl#getRefines <em>Refines</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.StateImpl#getInvariants <em>Invariants</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.StateImpl#isActive <em>Active</em>}</li>
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
	public static final String copyright = "Copyright (c) 2010-2013\rUniversity of Southampton.\rAll rights reserved. This program and the accompanying materials  are made\ravailable under the terms of the Eclipse Public License v1.0 which accompanies this \rdistribution, and is available at http://www.eclipse.org/legal/epl-v10.html\n";

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	public String doGetName() {
		if (this.eIsProxy()){
			String fragment = ((InternalEObject)this).eProxyURI().fragment();
			int ind = fragment.lastIndexOf("::");
			if (ind>-1) fragment = fragment.substring(ind+2);
			fragment = fragment.substring(fragment.lastIndexOf('.')+1);
			return fragment;
		}else{
			return name;
		}
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
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {
		State refines = getRefines();
		if (refines != null){
			return refines.getName();
		} else return doGetName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * Set the name attribute.
	 * Since : and . are used as delimiters in references which are formed from name, 
	 * these characters are not permitted and are changed automatically
	 * to ; and , respectively.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setName(String newName) {
		if (newName == null) return;		
		String oldName = getName();
		name = newName.replaceAll("\\.", ",").replaceAll(":", ";");
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.STATE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StatemachinesPackage.STATE__NAME:
				return getName();
			case StatemachinesPackage.STATE__STATEMACHINES:
				return getStatemachines();
			case StatemachinesPackage.STATE__REFINES:
				if (resolve) return getRefines();
				return basicGetRefines();
			case StatemachinesPackage.STATE__INVARIANTS:
				return getInvariants();
			case StatemachinesPackage.STATE__ACTIVE:
				return isActive();
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
			case StatemachinesPackage.STATE__NAME:
				setName((String)newValue);
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
			case StatemachinesPackage.STATE__NAME:
				setName(NAME_EDEFAULT);
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
			case StatemachinesPackage.STATE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case StatemachinesPackage.STATE__STATEMACHINES:
				return statemachines != null && !statemachines.isEmpty();
			case StatemachinesPackage.STATE__REFINES:
				return refines != null;
			case StatemachinesPackage.STATE__INVARIANTS:
				return invariants != null && !invariants.isEmpty();
			case StatemachinesPackage.STATE__ACTIVE:
				return active != ACTIVE_EDEFAULT;
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
		if (baseClass == EventBNamed.class) {
			switch (derivedFeatureID) {
				case StatemachinesPackage.STATE__NAME: return CorePackage.EVENT_BNAMED__NAME;
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
		if (baseClass == EventBNamed.class) {
			switch (baseFeatureID) {
				case CorePackage.EVENT_BNAMED__NAME: return StatemachinesPackage.STATE__NAME;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", active: ");
		result.append(active);
		result.append(')');
		return result.toString();
	}

} //StateImpl
