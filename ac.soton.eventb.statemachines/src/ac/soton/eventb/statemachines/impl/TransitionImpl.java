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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Event;

import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.core.extension.coreextension.impl.EventBCommentedLabeledEventGroupElementImpl;
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
 *   <li>{@link ac.soton.eventb.statemachines.impl.TransitionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.TransitionImpl#getSource <em>Source</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.TransitionImpl#getSourceContainer <em>Source Container</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.TransitionImpl#getTargetContainer <em>Target Container</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.TransitionImpl#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionImpl extends EventBCommentedLabeledEventGroupElementImpl implements Transition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2010-2013\rUniversity of Southampton.\rAll rights reserved. This program and the accompanying materials  are made\ravailable under the terms of the Eclipse Public License v1.0 which accompanies this \rdistribution, and is available at http://www.eclipse.org/legal/epl-v10.html\n";

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
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<?> operations;

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
	 * Returns a label constructed from a list of names of the elaborated events.
	 * The label is wrapped (i.e. a \n inserted) after the next comma after every 50 chars.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getLabel() {
		EList<Event> events = getElaborates();
		if (events.isEmpty())
			return "";//"<no name - fix elaborates>";
		ArrayList<String> result = new ArrayList<String>(getElaborates().size());
		for (Event event : getElaborates())
			result.add(event.getName());
		String rawLabel = result.toString().replaceAll("(^.)|(.$)", "");
		String formattedLabel = "";
		int j=0;
		for (int i=0; i<rawLabel.length();i++){
			if (j>=50 && ','==rawLabel.charAt(i-1)){
				formattedLabel = formattedLabel+"\n";
				j=-1;
			}else{
				formattedLabel = formattedLabel + rawLabel.charAt(i);
			}
			j++;
		}
		return formattedLabel;
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
	public EList<?> getOperations() {
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperations(EList<?> newOperations) {
		EList<?> oldOperations = operations;
		operations = newOperations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.TRANSITION__OPERATIONS, oldOperations, operations));
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
			case StatemachinesPackage.TRANSITION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case StatemachinesPackage.TRANSITION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
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
	//@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StatemachinesPackage.TRANSITION__TARGET:
				setTarget((AbstractNode)newValue);
				return;
			case StatemachinesPackage.TRANSITION__SOURCE:
				setSource((AbstractNode)newValue);
				return;
			case StatemachinesPackage.TRANSITION__SOURCE_CONTAINER:
				setSourceContainer((EventBElement)newValue);
				return;
			case StatemachinesPackage.TRANSITION__TARGET_CONTAINER:
				setTargetContainer((EventBElement)newValue);
				return;
			case StatemachinesPackage.TRANSITION__OPERATIONS:
				setOperations((EList<?>)newValue);
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
			case StatemachinesPackage.TRANSITION__TARGET:
				setTarget((AbstractNode)null);
				return;
			case StatemachinesPackage.TRANSITION__SOURCE:
				setSource((AbstractNode)null);
				return;
			case StatemachinesPackage.TRANSITION__SOURCE_CONTAINER:
				setSourceContainer((EventBElement)null);
				return;
			case StatemachinesPackage.TRANSITION__TARGET_CONTAINER:
				setTargetContainer((EventBElement)null);
				return;
			case StatemachinesPackage.TRANSITION__OPERATIONS:
				setOperations((EList<?>)null);
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
			case StatemachinesPackage.TRANSITION__TARGET:
				return target != null;
			case StatemachinesPackage.TRANSITION__SOURCE:
				return source != null;
			case StatemachinesPackage.TRANSITION__SOURCE_CONTAINER:
				return sourceContainer != null;
			case StatemachinesPackage.TRANSITION__TARGET_CONTAINER:
				return targetContainer != null;
			case StatemachinesPackage.TRANSITION__OPERATIONS:
				return operations != null;
		}
		return super.eIsSet(featureID);
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

	/* 
	 * Customised to fix problem with notification of label change on EReference 'elaborates' change.
	 */
	@Override
	public void eNotify(Notification notification) {
		super.eNotify(notification);
		
		int type = notification.getEventType();
		Object feature = notification.getFeature();
		if (CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__ELABORATES.equals(feature)
				&& (type == Notification.ADD || type == Notification.ADD_MANY
						|| type == Notification.REMOVE || type == Notification.REMOVE_MANY))
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.TRANSITION__LABEL, notification.getOldValue(), notification.getNewValue()));
			
	}

} //TransitionImpl
