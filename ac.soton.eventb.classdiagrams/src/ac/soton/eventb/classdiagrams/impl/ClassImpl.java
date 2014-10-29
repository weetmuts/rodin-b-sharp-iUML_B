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

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.classdiagrams.ClassConstraint;
import ac.soton.eventb.classdiagrams.ClassMethod;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;

import ac.soton.eventb.emf.core.extension.coreextension.impl.EventBNamedCommentedDataElaborationElementImpl;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.core.extension.coreextension.DataKind;
import ac.soton.eventb.emf.core.extension.coreextension.EventBDataElaboration;

import ac.soton.eventb.emf.diagrams.Diagram;
import ac.soton.eventb.emf.diagrams.DiagramOwner;
import ac.soton.eventb.emf.diagrams.DiagramsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eventb.emf.core.EventBNamed;

import org.eventb.emf.core.impl.EventBNamedCommentedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getSupertypes <em>Supertypes</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getClassAttributes <em>Class Attributes</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getRefines <em>Refines</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getMethods <em>Methods</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getSelfName <em>Self Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassImpl extends EventBNamedCommentedDataElaborationElementImpl implements ac.soton.eventb.classdiagrams.Class {
	/**
	 * The cached value of the '{@link #getDiagrams() <em>Diagrams</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList<Diagram> diagrams;

	/**
	 * The cached value of the '{@link #getSupertypes() <em>Supertypes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupertypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ac.soton.eventb.classdiagrams.Class> supertypes;

	/**
	 * The cached value of the '{@link #getClassAttributes() <em>Class Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassAttribute> classAttributes;

	/**
	 * The cached value of the '{@link #getIncoming() <em>Incoming</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncoming()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> incoming;

	/**
	 * The cached value of the '{@link #getOutgoing() <em>Outgoing</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoing()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> outgoing;

	/**
	 * The cached value of the '{@link #getRefines() <em>Refines</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefines()
	 * @generated
	 * @ordered
	 */
	protected ac.soton.eventb.classdiagrams.Class refines;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassConstraint> constraints;

	/**
	 * The cached value of the '{@link #getMethods() <em>Methods</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassMethod> methods;

	/**
	 * The default value of the '{@link #getSelfName() <em>Self Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelfName()
	 * @generated
	 * @ordered
	 */
	protected static final String SELF_NAME_EDEFAULT = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassdiagramsPackage.Literals.CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Diagram> getDiagrams() {
		if (diagrams == null) {
			diagrams = new EObjectContainmentEList.Resolving<Diagram>(Diagram.class, this, ClassdiagramsPackage.CLASS__DIAGRAMS);
		}
		return diagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ac.soton.eventb.classdiagrams.Class> getSupertypes() {
		if (supertypes == null) {
			supertypes = new EObjectResolvingEList<ac.soton.eventb.classdiagrams.Class>(ac.soton.eventb.classdiagrams.Class.class, this, ClassdiagramsPackage.CLASS__SUPERTYPES);
		}
		return supertypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassAttribute> getClassAttributes() {
		if (classAttributes == null) {
			classAttributes = new EObjectContainmentEList.Resolving<ClassAttribute>(ClassAttribute.class, this, ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES);
		}
		return classAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getIncoming() {
		if (incoming == null) {
			incoming = new EObjectWithInverseResolvingEList<Association>(Association.class, this, ClassdiagramsPackage.CLASS__INCOMING, ClassdiagramsPackage.ASSOCIATION__TARGET);
		}
		return incoming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getOutgoing() {
		if (outgoing == null) {
			outgoing = new EObjectWithInverseResolvingEList<Association>(Association.class, this, ClassdiagramsPackage.CLASS__OUTGOING, ClassdiagramsPackage.ASSOCIATION__SOURCE);
		}
		return outgoing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ac.soton.eventb.classdiagrams.Class getRefines() {
		if (refines != null && refines.eIsProxy()) {
			InternalEObject oldRefines = (InternalEObject)refines;
			refines = (ac.soton.eventb.classdiagrams.Class)eResolveProxy(oldRefines);
			if (refines != oldRefines) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassdiagramsPackage.CLASS__REFINES, oldRefines, refines));
			}
		}
		return refines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ac.soton.eventb.classdiagrams.Class basicGetRefines() {
		return refines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefines(ac.soton.eventb.classdiagrams.Class newRefines) {
		ac.soton.eventb.classdiagrams.Class oldRefines = refines;
		refines = newRefines;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS__REFINES, oldRefines, refines));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassConstraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList.Resolving<ClassConstraint>(ClassConstraint.class, this, ClassdiagramsPackage.CLASS__CONSTRAINTS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassMethod> getMethods() {
		if (methods == null) {
			methods = new EObjectContainmentEList.Resolving<ClassMethod>(ClassMethod.class, this, ClassdiagramsPackage.CLASS__METHODS);
		}
		return methods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * gets the name to be used for the contextual instance of the class
	 * defaults to "this<ClassName>" if null or empty
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSelfName() {
		if (selfName ==null || selfName.trim().equals("")){
			selfName = "this_"+ this.getName();
		}
		return selfName;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS__SELF_NAME, oldSelfName, selfName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClassdiagramsPackage.CLASS__INCOMING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncoming()).basicAdd(otherEnd, msgs);
			case ClassdiagramsPackage.CLASS__OUTGOING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoing()).basicAdd(otherEnd, msgs);
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
			case ClassdiagramsPackage.CLASS__DIAGRAMS:
				return ((InternalEList<?>)getDiagrams()).basicRemove(otherEnd, msgs);
			case ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES:
				return ((InternalEList<?>)getClassAttributes()).basicRemove(otherEnd, msgs);
			case ClassdiagramsPackage.CLASS__INCOMING:
				return ((InternalEList<?>)getIncoming()).basicRemove(otherEnd, msgs);
			case ClassdiagramsPackage.CLASS__OUTGOING:
				return ((InternalEList<?>)getOutgoing()).basicRemove(otherEnd, msgs);
			case ClassdiagramsPackage.CLASS__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
			case ClassdiagramsPackage.CLASS__METHODS:
				return ((InternalEList<?>)getMethods()).basicRemove(otherEnd, msgs);
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
			case ClassdiagramsPackage.CLASS__DIAGRAMS:
				return getDiagrams();
			case ClassdiagramsPackage.CLASS__SUPERTYPES:
				return getSupertypes();
			case ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES:
				return getClassAttributes();
			case ClassdiagramsPackage.CLASS__INCOMING:
				return getIncoming();
			case ClassdiagramsPackage.CLASS__OUTGOING:
				return getOutgoing();
			case ClassdiagramsPackage.CLASS__REFINES:
				if (resolve) return getRefines();
				return basicGetRefines();
			case ClassdiagramsPackage.CLASS__CONSTRAINTS:
				return getConstraints();
			case ClassdiagramsPackage.CLASS__METHODS:
				return getMethods();
			case ClassdiagramsPackage.CLASS__SELF_NAME:
				return getSelfName();
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
			case ClassdiagramsPackage.CLASS__DIAGRAMS:
				getDiagrams().clear();
				getDiagrams().addAll((Collection<? extends Diagram>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__SUPERTYPES:
				getSupertypes().clear();
				getSupertypes().addAll((Collection<? extends ac.soton.eventb.classdiagrams.Class>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES:
				getClassAttributes().clear();
				getClassAttributes().addAll((Collection<? extends ClassAttribute>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__INCOMING:
				getIncoming().clear();
				getIncoming().addAll((Collection<? extends Association>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__OUTGOING:
				getOutgoing().clear();
				getOutgoing().addAll((Collection<? extends Association>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__REFINES:
				setRefines((ac.soton.eventb.classdiagrams.Class)newValue);
				return;
			case ClassdiagramsPackage.CLASS__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends ClassConstraint>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__METHODS:
				getMethods().clear();
				getMethods().addAll((Collection<? extends ClassMethod>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__SELF_NAME:
				setSelfName((String)newValue);
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
			case ClassdiagramsPackage.CLASS__DIAGRAMS:
				getDiagrams().clear();
				return;
			case ClassdiagramsPackage.CLASS__SUPERTYPES:
				getSupertypes().clear();
				return;
			case ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES:
				getClassAttributes().clear();
				return;
			case ClassdiagramsPackage.CLASS__INCOMING:
				getIncoming().clear();
				return;
			case ClassdiagramsPackage.CLASS__OUTGOING:
				getOutgoing().clear();
				return;
			case ClassdiagramsPackage.CLASS__REFINES:
				setRefines((ac.soton.eventb.classdiagrams.Class)null);
				return;
			case ClassdiagramsPackage.CLASS__CONSTRAINTS:
				getConstraints().clear();
				return;
			case ClassdiagramsPackage.CLASS__METHODS:
				getMethods().clear();
				return;
			case ClassdiagramsPackage.CLASS__SELF_NAME:
				setSelfName(SELF_NAME_EDEFAULT);
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
			case ClassdiagramsPackage.CLASS__DIAGRAMS:
				return diagrams != null && !diagrams.isEmpty();
			case ClassdiagramsPackage.CLASS__SUPERTYPES:
				return supertypes != null && !supertypes.isEmpty();
			case ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES:
				return classAttributes != null && !classAttributes.isEmpty();
			case ClassdiagramsPackage.CLASS__INCOMING:
				return incoming != null && !incoming.isEmpty();
			case ClassdiagramsPackage.CLASS__OUTGOING:
				return outgoing != null && !outgoing.isEmpty();
			case ClassdiagramsPackage.CLASS__REFINES:
				return refines != null;
			case ClassdiagramsPackage.CLASS__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
			case ClassdiagramsPackage.CLASS__METHODS:
				return methods != null && !methods.isEmpty();
			case ClassdiagramsPackage.CLASS__SELF_NAME:
				return SELF_NAME_EDEFAULT == null ? selfName != null : !SELF_NAME_EDEFAULT.equals(selfName);
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
		if (baseClass == DiagramOwner.class) {
			switch (derivedFeatureID) {
				case ClassdiagramsPackage.CLASS__DIAGRAMS: return DiagramsPackage.DIAGRAM_OWNER__DIAGRAMS;
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
		if (baseClass == DiagramOwner.class) {
			switch (baseFeatureID) {
				case DiagramsPackage.DIAGRAM_OWNER__DIAGRAMS: return ClassdiagramsPackage.CLASS__DIAGRAMS;
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
		result.append(" (selfName: ");
		result.append(selfName);
		result.append(')');
		return result.toString();
	}

} //ClassImpl
