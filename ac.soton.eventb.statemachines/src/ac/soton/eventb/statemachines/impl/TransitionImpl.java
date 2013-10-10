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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.impl.EventBCommentedElementImpl;
import org.eventb.emf.core.machine.Action;
import org.eventb.emf.core.machine.Event;

import org.eventb.emf.core.machine.Guard;
import org.eventb.emf.core.machine.Witness;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.core.extension.coreextension.EventBEventGroup;
import ac.soton.eventb.emf.core.extension.coreextension.EventBLabeled;
import ac.soton.eventb.emf.core.extension.coreextension.TypedParameter;
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
 *   <li>{@link ac.soton.eventb.statemachines.impl.TransitionImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.TransitionImpl#getElaborates <em>Elaborates</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.TransitionImpl#isExtended <em>Extended</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.TransitionImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.TransitionImpl#getGuards <em>Guards</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.TransitionImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link ac.soton.eventb.statemachines.impl.TransitionImpl#getWitnesses <em>Witnesses</em>}</li>
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
public class TransitionImpl extends EventBCommentedElementImpl implements Transition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2010-2013\rUniversity of Southampton.\rAll rights reserved. This program and the accompanying materials  are made\ravailable under the terms of the Eclipse Public License v1.0 which accompanies this \rdistribution, and is available at http://www.eclipse.org/legal/epl-v10.html\n";

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = "";

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
	 * The default value of the '{@link #isExtended() <em>Extended</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtended()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXTENDED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExtended() <em>Extended</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtended()
	 * @generated
	 * @ordered
	 */
	protected boolean extended = EXTENDED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedParameter> parameters;

	/**
	 * The cached value of the '{@link #getGuards() <em>Guards</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuards()
	 * @generated
	 * @ordered
	 */
	protected EList<Guard> guards;

	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> actions;

	/**
	 * The cached value of the '{@link #getWitnesses() <em>Witnesses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWitnesses()
	 * @generated
	 * @ordered
	 */
	protected EList<Witness> witnesses;

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
	 * @generated
	 */
	public boolean isExtended() {
		return extended;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtended(boolean newExtended) {
		boolean oldExtended = extended;
		extended = newExtended;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.TRANSITION__EXTENDED, oldExtended, extended));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList.Resolving<TypedParameter>(TypedParameter.class, this, StatemachinesPackage.TRANSITION__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Guard> getGuards() {
		if (guards == null) {
			guards = new EObjectContainmentEList.Resolving<Guard>(Guard.class, this, StatemachinesPackage.TRANSITION__GUARDS);
		}
		return guards;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getActions() {
		if (actions == null) {
			actions = new EObjectContainmentEList.Resolving<Action>(Action.class, this, StatemachinesPackage.TRANSITION__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Witness> getWitnesses() {
		if (witnesses == null) {
			witnesses = new EObjectContainmentEList.Resolving<Witness>(Witness.class, this, StatemachinesPackage.TRANSITION__WITNESSES);
		}
		return witnesses;
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
			case StatemachinesPackage.TRANSITION__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case StatemachinesPackage.TRANSITION__GUARDS:
				return ((InternalEList<?>)getGuards()).basicRemove(otherEnd, msgs);
			case StatemachinesPackage.TRANSITION__ACTIONS:
				return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
			case StatemachinesPackage.TRANSITION__WITNESSES:
				return ((InternalEList<?>)getWitnesses()).basicRemove(otherEnd, msgs);
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
			case StatemachinesPackage.TRANSITION__LABEL:
				return getLabel();
			case StatemachinesPackage.TRANSITION__ELABORATES:
				return getElaborates();
			case StatemachinesPackage.TRANSITION__EXTENDED:
				return isExtended();
			case StatemachinesPackage.TRANSITION__PARAMETERS:
				return getParameters();
			case StatemachinesPackage.TRANSITION__GUARDS:
				return getGuards();
			case StatemachinesPackage.TRANSITION__ACTIONS:
				return getActions();
			case StatemachinesPackage.TRANSITION__WITNESSES:
				return getWitnesses();
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StatemachinesPackage.TRANSITION__ELABORATES:
				getElaborates().clear();
				getElaborates().addAll((Collection<? extends Event>)newValue);
				return;
			case StatemachinesPackage.TRANSITION__EXTENDED:
				setExtended((Boolean)newValue);
				return;
			case StatemachinesPackage.TRANSITION__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends TypedParameter>)newValue);
				return;
			case StatemachinesPackage.TRANSITION__GUARDS:
				getGuards().clear();
				getGuards().addAll((Collection<? extends Guard>)newValue);
				return;
			case StatemachinesPackage.TRANSITION__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends Action>)newValue);
				return;
			case StatemachinesPackage.TRANSITION__WITNESSES:
				getWitnesses().clear();
				getWitnesses().addAll((Collection<? extends Witness>)newValue);
				return;
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
			case StatemachinesPackage.TRANSITION__ELABORATES:
				getElaborates().clear();
				return;
			case StatemachinesPackage.TRANSITION__EXTENDED:
				setExtended(EXTENDED_EDEFAULT);
				return;
			case StatemachinesPackage.TRANSITION__PARAMETERS:
				getParameters().clear();
				return;
			case StatemachinesPackage.TRANSITION__GUARDS:
				getGuards().clear();
				return;
			case StatemachinesPackage.TRANSITION__ACTIONS:
				getActions().clear();
				return;
			case StatemachinesPackage.TRANSITION__WITNESSES:
				getWitnesses().clear();
				return;
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
			case StatemachinesPackage.TRANSITION__LABEL:
				return LABEL_EDEFAULT == null ? getLabel() != null : !LABEL_EDEFAULT.equals(getLabel());
			case StatemachinesPackage.TRANSITION__ELABORATES:
				return elaborates != null && !elaborates.isEmpty();
			case StatemachinesPackage.TRANSITION__EXTENDED:
				return extended != EXTENDED_EDEFAULT;
			case StatemachinesPackage.TRANSITION__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case StatemachinesPackage.TRANSITION__GUARDS:
				return guards != null && !guards.isEmpty();
			case StatemachinesPackage.TRANSITION__ACTIONS:
				return actions != null && !actions.isEmpty();
			case StatemachinesPackage.TRANSITION__WITNESSES:
				return witnesses != null && !witnesses.isEmpty();
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == EventBLabeled.class) {
			switch (derivedFeatureID) {
				case StatemachinesPackage.TRANSITION__LABEL: return CoreextensionPackage.EVENT_BLABELED__LABEL;
				default: return -1;
			}
		}
		if (baseClass == EventBEventGroup.class) {
			switch (derivedFeatureID) {
				case StatemachinesPackage.TRANSITION__ELABORATES: return CoreextensionPackage.EVENT_BEVENT_GROUP__ELABORATES;
				case StatemachinesPackage.TRANSITION__EXTENDED: return CoreextensionPackage.EVENT_BEVENT_GROUP__EXTENDED;
				case StatemachinesPackage.TRANSITION__PARAMETERS: return CoreextensionPackage.EVENT_BEVENT_GROUP__PARAMETERS;
				case StatemachinesPackage.TRANSITION__GUARDS: return CoreextensionPackage.EVENT_BEVENT_GROUP__GUARDS;
				case StatemachinesPackage.TRANSITION__ACTIONS: return CoreextensionPackage.EVENT_BEVENT_GROUP__ACTIONS;
				case StatemachinesPackage.TRANSITION__WITNESSES: return CoreextensionPackage.EVENT_BEVENT_GROUP__WITNESSES;
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
				case CoreextensionPackage.EVENT_BLABELED__LABEL: return StatemachinesPackage.TRANSITION__LABEL;
				default: return -1;
			}
		}
		if (baseClass == EventBEventGroup.class) {
			switch (baseFeatureID) {
				case CoreextensionPackage.EVENT_BEVENT_GROUP__ELABORATES: return StatemachinesPackage.TRANSITION__ELABORATES;
				case CoreextensionPackage.EVENT_BEVENT_GROUP__EXTENDED: return StatemachinesPackage.TRANSITION__EXTENDED;
				case CoreextensionPackage.EVENT_BEVENT_GROUP__PARAMETERS: return StatemachinesPackage.TRANSITION__PARAMETERS;
				case CoreextensionPackage.EVENT_BEVENT_GROUP__GUARDS: return StatemachinesPackage.TRANSITION__GUARDS;
				case CoreextensionPackage.EVENT_BEVENT_GROUP__ACTIONS: return StatemachinesPackage.TRANSITION__ACTIONS;
				case CoreextensionPackage.EVENT_BEVENT_GROUP__WITNESSES: return StatemachinesPackage.TRANSITION__WITNESSES;
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
		result.append(" (extended: ");
		result.append(extended);
		result.append(", operations: ");
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
