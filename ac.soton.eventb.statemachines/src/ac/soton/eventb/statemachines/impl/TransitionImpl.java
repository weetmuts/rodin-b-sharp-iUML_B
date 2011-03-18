/**
 * Copyright (c) 2010
 * University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package ac.soton.eventb.statemachines.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.impl.EventBCommentedElementImpl;
import org.eventb.emf.core.machine.Event;

import ac.soton.eventb.statemachines.AbstractNode;
import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.statemachines.impl.TransitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.TransitionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.TransitionImpl#getSource <em>Source</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.TransitionImpl#getElaborates <em>Elaborates</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.TransitionImpl#getSourceContainer <em>Source Container</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.TransitionImpl#getTargetContainer <em>Target Container</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.TransitionImpl#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionImpl extends EventBCommentedElementImpl implements Transition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2010\rUniversity of Southampton.\rAll rights reserved. This program and the accompanying materials  are made\ravailable under the terms of the Eclipse Public License v1.0 which accompanies this \rdistribution, and is available at http://www.eclipse.org/legal/epl-v10.html\n";

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
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected AbstractNode target;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected AbstractNode source;

	/**
	 * The cached value of the '{@link #getElaborates() <em>Elaborates</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElaborates()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> elaborates;

	/**
	 * The cached value of the '{@link #getSourceContainer() <em>Source Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceContainer()
	 * @generated
	 * @ordered
	 */
	protected EventBElement sourceContainer;

	/**
	 * The cached value of the '{@link #getTargetContainer() <em>Target Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetContainer()
	 * @generated
	 * @ordered
	 */
	protected EventBElement targetContainer;

	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> operations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatemachinesPackage.Literals.TRANSITION;
	}


	/**
	 * <!-- begin-user-doc -->
	 * Returns either a name or if not set a list of elaborated transitions.
	 * If neither name, nor elaboration is set returns a warning name.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {
		String name = doGetName();
		if (name.equals(NAME_EDEFAULT)) {
			EList<Event> events = getElaborates();
			if (events.isEmpty())
				return "<no name - fix elaborates>";
			ArrayList<String> result = new ArrayList<String>(getElaborates().size());
			for (Event event : getElaborates())
				result.add(event.getName());
			return result.toString().replaceAll("(^.)|(.$)", "");
		}
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractNode getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (AbstractNode)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StatemachinesPackage.TRANSITION__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractNode basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(AbstractNode newTarget, NotificationChain msgs) {
		AbstractNode oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatemachinesPackage.TRANSITION__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(AbstractNode newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, StatemachinesPackage.ABSTRACT_NODE__INCOMING, AbstractNode.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, StatemachinesPackage.ABSTRACT_NODE__INCOMING, AbstractNode.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.TRANSITION__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractNode getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (AbstractNode)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StatemachinesPackage.TRANSITION__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractNode basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(AbstractNode newSource, NotificationChain msgs) {
		AbstractNode oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatemachinesPackage.TRANSITION__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(AbstractNode newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, StatemachinesPackage.ABSTRACT_NODE__OUTGOING, AbstractNode.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, StatemachinesPackage.ABSTRACT_NODE__OUTGOING, AbstractNode.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.TRANSITION__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getElaborates() {
		if (elaborates == null) {
			elaborates = new EObjectResolvingEList<Event>(Event.class, this, StatemachinesPackage.TRANSITION__ELABORATES);
		}
		return elaborates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setName(String newName) {
		String oldName = getName();
		doSetName(newName);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.TRANSITION__NAME, oldName, newName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EventBElement getSourceContainer() {
		if (sourceContainer != null && sourceContainer.eIsProxy()) {
			InternalEObject oldSourceContainer = (InternalEObject)sourceContainer;
			sourceContainer = (EventBElement)eResolveProxy(oldSourceContainer);
			if (sourceContainer != oldSourceContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StatemachinesPackage.TRANSITION__SOURCE_CONTAINER, oldSourceContainer, sourceContainer));
			}
		} else if (sourceContainer == null) {
			return getSource();
		}
		return sourceContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventBElement basicGetSourceContainer() {
		return sourceContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceContainer(EventBElement newSourceContainer) {
		EventBElement oldSourceContainer = sourceContainer;
		sourceContainer = newSourceContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.TRANSITION__SOURCE_CONTAINER, oldSourceContainer, sourceContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EventBElement getTargetContainer() {
		if (targetContainer != null && targetContainer.eIsProxy()) {
			InternalEObject oldTargetContainer = (InternalEObject)targetContainer;
			targetContainer = (EventBElement)eResolveProxy(oldTargetContainer);
			if (targetContainer != oldTargetContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StatemachinesPackage.TRANSITION__TARGET_CONTAINER, oldTargetContainer, targetContainer));
			}
		} else if (targetContainer == null) {
			return getTarget();
		}
		return targetContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventBElement basicGetTargetContainer() {
		return targetContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetContainer(EventBElement newTargetContainer) {
		EventBElement oldTargetContainer = targetContainer;
		targetContainer = newTargetContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.TRANSITION__TARGET_CONTAINER, oldTargetContainer, targetContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getOperations() {
		if (operations == null) {
			operations = new EDataTypeUniqueEList<Object>(Object.class, this, StatemachinesPackage.TRANSITION__OPERATIONS);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String doGetName() {
		assert (this instanceof EventBElement);
		String reference = ((EventBElement)this).getReferenceWithoutResolving();
		return reference.length() > this.eStaticClass().getInstanceClassName().length() ?
			reference.substring(this.eStaticClass().getInstanceClassName().length()+1)
			: "";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void doSetName(String newName) {
		((EventBElement)this).setReference(this.eStaticClass().getInstanceClassName()+"."+newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatemachinesPackage.TRANSITION__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, StatemachinesPackage.ABSTRACT_NODE__INCOMING, AbstractNode.class, msgs);
				return basicSetTarget((AbstractNode)otherEnd, msgs);
			case StatemachinesPackage.TRANSITION__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, StatemachinesPackage.ABSTRACT_NODE__OUTGOING, AbstractNode.class, msgs);
				return basicSetSource((AbstractNode)otherEnd, msgs);
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
			case StatemachinesPackage.TRANSITION__TARGET:
				return basicSetTarget(null, msgs);
			case StatemachinesPackage.TRANSITION__SOURCE:
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
			case StatemachinesPackage.TRANSITION__NAME:
				return getName();
			case StatemachinesPackage.TRANSITION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case StatemachinesPackage.TRANSITION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case StatemachinesPackage.TRANSITION__ELABORATES:
				return getElaborates();
			case StatemachinesPackage.TRANSITION__SOURCE_CONTAINER:
				if (resolve) return getSourceContainer();
				return basicGetSourceContainer();
			case StatemachinesPackage.TRANSITION__TARGET_CONTAINER:
				if (resolve) return getTargetContainer();
				return basicGetTargetContainer();
			case StatemachinesPackage.TRANSITION__OPERATIONS:
				return getOperations();
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
			case StatemachinesPackage.TRANSITION__NAME:
				setName((String)newValue);
				return;
			case StatemachinesPackage.TRANSITION__TARGET:
				setTarget((AbstractNode)newValue);
				return;
			case StatemachinesPackage.TRANSITION__SOURCE:
				setSource((AbstractNode)newValue);
				return;
			case StatemachinesPackage.TRANSITION__ELABORATES:
				getElaborates().clear();
				getElaborates().addAll((Collection<? extends Event>)newValue);
				return;
			case StatemachinesPackage.TRANSITION__SOURCE_CONTAINER:
				setSourceContainer((EventBElement)newValue);
				return;
			case StatemachinesPackage.TRANSITION__TARGET_CONTAINER:
				setTargetContainer((EventBElement)newValue);
				return;
			case StatemachinesPackage.TRANSITION__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends Object>)newValue);
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
			case StatemachinesPackage.TRANSITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case StatemachinesPackage.TRANSITION__TARGET:
				setTarget((AbstractNode)null);
				return;
			case StatemachinesPackage.TRANSITION__SOURCE:
				setSource((AbstractNode)null);
				return;
			case StatemachinesPackage.TRANSITION__ELABORATES:
				getElaborates().clear();
				return;
			case StatemachinesPackage.TRANSITION__SOURCE_CONTAINER:
				setSourceContainer((EventBElement)null);
				return;
			case StatemachinesPackage.TRANSITION__TARGET_CONTAINER:
				setTargetContainer((EventBElement)null);
				return;
			case StatemachinesPackage.TRANSITION__OPERATIONS:
				getOperations().clear();
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
			case StatemachinesPackage.TRANSITION__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case StatemachinesPackage.TRANSITION__TARGET:
				return target != null;
			case StatemachinesPackage.TRANSITION__SOURCE:
				return source != null;
			case StatemachinesPackage.TRANSITION__ELABORATES:
				return elaborates != null && !elaborates.isEmpty();
			case StatemachinesPackage.TRANSITION__SOURCE_CONTAINER:
				return sourceContainer != null;
			case StatemachinesPackage.TRANSITION__TARGET_CONTAINER:
				return targetContainer != null;
			case StatemachinesPackage.TRANSITION__OPERATIONS:
				return operations != null && !operations.isEmpty();
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
				case StatemachinesPackage.TRANSITION__NAME: return CorePackage.EVENT_BNAMED__NAME;
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
				case CorePackage.EVENT_BNAMED__NAME: return StatemachinesPackage.TRANSITION__NAME;
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
		result.append(" (operations: ");
		result.append(operations);
		result.append(')');
		return result.toString();
	}

} //TransitionImpl
