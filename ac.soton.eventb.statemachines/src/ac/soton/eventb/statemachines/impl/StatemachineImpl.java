/**
 * Copyright (c) 2010
 * University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package ac.soton.eventb.statemachines.impl;

import ac.soton.eventb.emf.core.extension.coreextension.impl.EventBNamedCommentedDataElaborationElementImpl;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBNamedCommentedElement;

import ac.soton.eventb.emf.diagrams.Diagram;
import ac.soton.eventb.statemachines.AbstractNode;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.Transition;
import ac.soton.eventb.statemachines.TranslationKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statemachine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.statemachines.impl.StatemachineImpl#getExtensionId <em>Extension Id</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.StatemachineImpl#getRefines <em>Refines</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.StatemachineImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.StatemachineImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.StatemachineImpl#getInstances <em>Instances</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.StatemachineImpl#getSelfName <em>Self Name</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.StatemachineImpl#getTranslation <em>Translation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StatemachineImpl extends EventBNamedCommentedDataElaborationElementImpl implements Statemachine {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2010-2013\rUniversity of Southampton.\rAll rights reserved. This program and the accompanying materials  are made\ravailable under the terms of the Eclipse Public License v1.0 which accompanies this \rdistribution, and is available at http://www.eclipse.org/legal/epl-v10.html\n";

	/**
	 * The default value of the '{@link #getExtensionId() <em>Extension Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionId()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String EXTENSION_ID_EDEFAULT = StatemachinesPackage.STATEMACHINES_EXTENSION_ID;

	/**
	 * The cached value of the '{@link #getExtensionId() <em>Extension Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionId()
	 * @generated NOT
	 * @ordered
	 */
	protected String extensionId = EXTENSION_ID_EDEFAULT+"."+EcoreUtil.generateUUID();

	/**
	 * The cached value of the '{@link #getRefines() <em>Refines</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefines()
	 * @generated
	 * @ordered
	 */
	protected Statemachine refines;

	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractNode> nodes;

	/**
	 * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> transitions;

	/**
	 * The cached value of the '{@link #getInstances() <em>Instances</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstances()
	 * @generated
	 * @ordered
	 */
	protected EventBNamedCommentedElement instances;

	/**
	 * The default value of the '{@link #getSelfName() <em>Self Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelfName()
	 * @generated
	 * @ordered
	 */
	protected static final String SELF_NAME_EDEFAULT = "this";

	/**
	 * The cached value of the '{@link #getSelfName() <em>Self Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelfName()
	 * @generated
	 * @ordered
	 */
	protected String selfName = SELF_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTranslation() <em>Translation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranslation()
	 * @generated
	 * @ordered
	 */
	protected static final TranslationKind TRANSLATION_EDEFAULT = TranslationKind.MULTIVAR;

	/**
	 * The cached value of the '{@link #getTranslation() <em>Translation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranslation()
	 * @generated
	 * @ordered
	 */
	protected TranslationKind translation = TRANSLATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatemachineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatemachinesPackage.Literals.STATEMACHINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {
		Statemachine refines = getRefines();
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.STATEMACHINE__NAME, oldName, newName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.STATEMACHINE__EXTENSION_ID, oldExtensionId, extensionId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TranslationKind getTranslation() {
		return translation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTranslation(TranslationKind newTranslation) {
		TranslationKind oldTranslation = translation;
		translation = newTranslation == null ? TRANSLATION_EDEFAULT : newTranslation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.STATEMACHINE__TRANSLATION, oldTranslation, translation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statemachine getRefines() {
		if (refines != null && refines.eIsProxy()) {
			InternalEObject oldRefines = (InternalEObject)refines;
			refines = (Statemachine)eResolveProxy(oldRefines);
			if (refines != oldRefines) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StatemachinesPackage.STATEMACHINE__REFINES, oldRefines, refines));
			}
		}
		return refines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statemachine basicGetRefines() {
		return refines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * On refines change also notify about name change.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRefines(Statemachine newRefines) {
		Statemachine oldRefines = refines;
		String oldName = getName();
		refines = newRefines;
		String newName = getName();
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.STATEMACHINE__REFINES, oldRefines, refines));
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.STATEMACHINE__NAME, oldName, newName));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractNode> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList.Resolving<AbstractNode>(AbstractNode.class, this, StatemachinesPackage.STATEMACHINE__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getTransitions() {
		if (transitions == null) {
			transitions = new EObjectContainmentEList.Resolving<Transition>(Transition.class, this, StatemachinesPackage.STATEMACHINE__TRANSITIONS);
		}
		return transitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventBNamedCommentedElement getInstances() {
		if (instances != null && instances.eIsProxy()) {
			InternalEObject oldInstances = (InternalEObject)instances;
			instances = (EventBNamedCommentedElement)eResolveProxy(oldInstances);
			if (instances != oldInstances) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StatemachinesPackage.STATEMACHINE__INSTANCES, oldInstances, instances));
			}
		}
		return instances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventBNamedCommentedElement basicGetInstances() {
		return instances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstances(EventBNamedCommentedElement newInstances) {
		EventBNamedCommentedElement oldInstances = instances;
		instances = newInstances;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.STATEMACHINE__INSTANCES, oldInstances, instances));
	}

	/**
	 * <!-- begin-user-doc -->
	 * If selfName is still at the default (this), returns this_SMName
	 * Otherwise returns the value of selfName (trimmed of leading trailing whitespace)
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSelfName() {
		if (getInstances() ==null) return "";
		else return "this".equals(selfName)? "this_"+getInstances().getName() : selfName.trim();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelfName(String newSelfName) {
		String oldSelfName = selfName;
		selfName = newSelfName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.STATEMACHINE__SELF_NAME, oldSelfName, selfName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatemachinesPackage.STATEMACHINE__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case StatemachinesPackage.STATEMACHINE__TRANSITIONS:
				return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
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
			case StatemachinesPackage.STATEMACHINE__EXTENSION_ID:
				return getExtensionId();
			case StatemachinesPackage.STATEMACHINE__REFINES:
				if (resolve) return getRefines();
				return basicGetRefines();
			case StatemachinesPackage.STATEMACHINE__NODES:
				return getNodes();
			case StatemachinesPackage.STATEMACHINE__TRANSITIONS:
				return getTransitions();
			case StatemachinesPackage.STATEMACHINE__INSTANCES:
				if (resolve) return getInstances();
				return basicGetInstances();
			case StatemachinesPackage.STATEMACHINE__SELF_NAME:
				return getSelfName();
			case StatemachinesPackage.STATEMACHINE__TRANSLATION:
				return getTranslation();
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
			case StatemachinesPackage.STATEMACHINE__EXTENSION_ID:
				setExtensionId((String)newValue);
				return;
			case StatemachinesPackage.STATEMACHINE__REFINES:
				setRefines((Statemachine)newValue);
				return;
			case StatemachinesPackage.STATEMACHINE__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends AbstractNode>)newValue);
				return;
			case StatemachinesPackage.STATEMACHINE__TRANSITIONS:
				getTransitions().clear();
				getTransitions().addAll((Collection<? extends Transition>)newValue);
				return;
			case StatemachinesPackage.STATEMACHINE__INSTANCES:
				setInstances((EventBNamedCommentedElement)newValue);
				return;
			case StatemachinesPackage.STATEMACHINE__SELF_NAME:
				setSelfName((String)newValue);
				return;
			case StatemachinesPackage.STATEMACHINE__TRANSLATION:
				setTranslation((TranslationKind)newValue);
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
			case StatemachinesPackage.STATEMACHINE__EXTENSION_ID:
				setExtensionId(EXTENSION_ID_EDEFAULT);
				return;
			case StatemachinesPackage.STATEMACHINE__REFINES:
				setRefines((Statemachine)null);
				return;
			case StatemachinesPackage.STATEMACHINE__NODES:
				getNodes().clear();
				return;
			case StatemachinesPackage.STATEMACHINE__TRANSITIONS:
				getTransitions().clear();
				return;
			case StatemachinesPackage.STATEMACHINE__INSTANCES:
				setInstances((EventBNamedCommentedElement)null);
				return;
			case StatemachinesPackage.STATEMACHINE__SELF_NAME:
				setSelfName(SELF_NAME_EDEFAULT);
				return;
			case StatemachinesPackage.STATEMACHINE__TRANSLATION:
				setTranslation(TRANSLATION_EDEFAULT);
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
			case StatemachinesPackage.STATEMACHINE__EXTENSION_ID:
				return EXTENSION_ID_EDEFAULT == null ? extensionId != null : !EXTENSION_ID_EDEFAULT.equals(extensionId);
			case StatemachinesPackage.STATEMACHINE__REFINES:
				return refines != null;
			case StatemachinesPackage.STATEMACHINE__NODES:
				return nodes != null && !nodes.isEmpty();
			case StatemachinesPackage.STATEMACHINE__TRANSITIONS:
				return transitions != null && !transitions.isEmpty();
			case StatemachinesPackage.STATEMACHINE__INSTANCES:
				return instances != null;
			case StatemachinesPackage.STATEMACHINE__SELF_NAME:
				return SELF_NAME_EDEFAULT == null ? selfName != null : !SELF_NAME_EDEFAULT.equals(selfName);
			case StatemachinesPackage.STATEMACHINE__TRANSLATION:
				return translation != TRANSLATION_EDEFAULT;
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
		if (baseClass == AbstractExtension.class) {
			switch (derivedFeatureID) {
				case StatemachinesPackage.STATEMACHINE__EXTENSION_ID: return CorePackage.ABSTRACT_EXTENSION__EXTENSION_ID;
				default: return -1;
			}
		}
		if (baseClass == Diagram.class) {
			switch (derivedFeatureID) {
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
		if (baseClass == AbstractExtension.class) {
			switch (baseFeatureID) {
				case CorePackage.ABSTRACT_EXTENSION__EXTENSION_ID: return StatemachinesPackage.STATEMACHINE__EXTENSION_ID;
				default: return -1;
			}
		}
		if (baseClass == Diagram.class) {
			switch (baseFeatureID) {
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
		result.append(", selfName: ");
		result.append(selfName);
		result.append(", translation: ");
		result.append(translation);
		result.append(')');
		return result.toString();
	}

} //StatemachineImpl
