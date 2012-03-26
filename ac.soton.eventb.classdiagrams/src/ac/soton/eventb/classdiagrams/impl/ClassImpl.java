/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams.impl;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.classdiagrams.ClassAxiom;
import ac.soton.eventb.classdiagrams.ClassEvent;
import ac.soton.eventb.classdiagrams.ClassInvariant;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;

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

import org.eventb.emf.core.EventBNamedCommentedElement;

import org.eventb.emf.core.impl.EventBElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#isConstant <em>Constant</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getSupertypes <em>Supertypes</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getSource <em>Source</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getClassAttributes <em>Class Attributes</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getClassEvents <em>Class Events</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getClassInvariants <em>Class Invariants</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getClassAxioms <em>Class Axioms</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getInstances <em>Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassImpl extends EventBElementImpl implements ac.soton.eventb.classdiagrams.Class {
	/**
	 * The default value of the '{@link #isConstant() <em>Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConstant()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONSTANT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isConstant() <em>Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConstant()
	 * @generated
	 * @ordered
	 */
	protected boolean constant = CONSTANT_EDEFAULT;

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
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> source;

	/**
	 * The cached value of the '{@link #getClassAttributes() <em>Class Attributes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassAttributes()
	 * @generated
	 * @ordered
	 */
	protected ClassAttribute classAttributes;

	/**
	 * The cached value of the '{@link #getClassEvents() <em>Class Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassEvent> classEvents;

	/**
	 * The cached value of the '{@link #getClassInvariants() <em>Class Invariants</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassInvariants()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassInvariant> classInvariants;

	/**
	 * The cached value of the '{@link #getClassAxioms() <em>Class Axioms</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassAxioms()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassAxiom> classAxioms;

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
	public boolean isConstant() {
		return constant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstant(boolean newConstant) {
		boolean oldConstant = constant;
		constant = newConstant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS__CONSTANT, oldConstant, constant));
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
	public EList<Association> getSource() {
		if (source == null) {
			source = new EObjectWithInverseResolvingEList<Association>(Association.class, this, ClassdiagramsPackage.CLASS__SOURCE, ClassdiagramsPackage.ASSOCIATION__TARGET);
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassAttribute getClassAttributes() {
		if (classAttributes != null && classAttributes.eIsProxy()) {
			InternalEObject oldClassAttributes = (InternalEObject)classAttributes;
			classAttributes = (ClassAttribute)eResolveProxy(oldClassAttributes);
			if (classAttributes != oldClassAttributes) {
				InternalEObject newClassAttributes = (InternalEObject)classAttributes;
				NotificationChain msgs = oldClassAttributes.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES, null, null);
				if (newClassAttributes.eInternalContainer() == null) {
					msgs = newClassAttributes.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES, oldClassAttributes, classAttributes));
			}
		}
		return classAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassAttribute basicGetClassAttributes() {
		return classAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClassAttributes(ClassAttribute newClassAttributes, NotificationChain msgs) {
		ClassAttribute oldClassAttributes = classAttributes;
		classAttributes = newClassAttributes;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES, oldClassAttributes, newClassAttributes);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassAttributes(ClassAttribute newClassAttributes) {
		if (newClassAttributes != classAttributes) {
			NotificationChain msgs = null;
			if (classAttributes != null)
				msgs = ((InternalEObject)classAttributes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES, null, msgs);
			if (newClassAttributes != null)
				msgs = ((InternalEObject)newClassAttributes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES, null, msgs);
			msgs = basicSetClassAttributes(newClassAttributes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES, newClassAttributes, newClassAttributes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassEvent> getClassEvents() {
		if (classEvents == null) {
			classEvents = new EObjectContainmentEList.Resolving<ClassEvent>(ClassEvent.class, this, ClassdiagramsPackage.CLASS__CLASS_EVENTS);
		}
		return classEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassInvariant> getClassInvariants() {
		if (classInvariants == null) {
			classInvariants = new EObjectContainmentEList.Resolving<ClassInvariant>(ClassInvariant.class, this, ClassdiagramsPackage.CLASS__CLASS_INVARIANTS);
		}
		return classInvariants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassAxiom> getClassAxioms() {
		if (classAxioms == null) {
			classAxioms = new EObjectContainmentEList.Resolving<ClassAxiom>(ClassAxiom.class, this, ClassdiagramsPackage.CLASS__CLASS_AXIOMS);
		}
		return classAxioms;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassdiagramsPackage.CLASS__INSTANCES, oldInstances, instances));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS__INSTANCES, oldInstances, instances));
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
			case ClassdiagramsPackage.CLASS__SOURCE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSource()).basicAdd(otherEnd, msgs);
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
			case ClassdiagramsPackage.CLASS__SOURCE:
				return ((InternalEList<?>)getSource()).basicRemove(otherEnd, msgs);
			case ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES:
				return basicSetClassAttributes(null, msgs);
			case ClassdiagramsPackage.CLASS__CLASS_EVENTS:
				return ((InternalEList<?>)getClassEvents()).basicRemove(otherEnd, msgs);
			case ClassdiagramsPackage.CLASS__CLASS_INVARIANTS:
				return ((InternalEList<?>)getClassInvariants()).basicRemove(otherEnd, msgs);
			case ClassdiagramsPackage.CLASS__CLASS_AXIOMS:
				return ((InternalEList<?>)getClassAxioms()).basicRemove(otherEnd, msgs);
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
			case ClassdiagramsPackage.CLASS__CONSTANT:
				return isConstant();
			case ClassdiagramsPackage.CLASS__SUPERTYPES:
				return getSupertypes();
			case ClassdiagramsPackage.CLASS__SOURCE:
				return getSource();
			case ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES:
				if (resolve) return getClassAttributes();
				return basicGetClassAttributes();
			case ClassdiagramsPackage.CLASS__CLASS_EVENTS:
				return getClassEvents();
			case ClassdiagramsPackage.CLASS__CLASS_INVARIANTS:
				return getClassInvariants();
			case ClassdiagramsPackage.CLASS__CLASS_AXIOMS:
				return getClassAxioms();
			case ClassdiagramsPackage.CLASS__INSTANCES:
				if (resolve) return getInstances();
				return basicGetInstances();
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
			case ClassdiagramsPackage.CLASS__CONSTANT:
				setConstant((Boolean)newValue);
				return;
			case ClassdiagramsPackage.CLASS__SUPERTYPES:
				getSupertypes().clear();
				getSupertypes().addAll((Collection<? extends ac.soton.eventb.classdiagrams.Class>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__SOURCE:
				getSource().clear();
				getSource().addAll((Collection<? extends Association>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES:
				setClassAttributes((ClassAttribute)newValue);
				return;
			case ClassdiagramsPackage.CLASS__CLASS_EVENTS:
				getClassEvents().clear();
				getClassEvents().addAll((Collection<? extends ClassEvent>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__CLASS_INVARIANTS:
				getClassInvariants().clear();
				getClassInvariants().addAll((Collection<? extends ClassInvariant>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__CLASS_AXIOMS:
				getClassAxioms().clear();
				getClassAxioms().addAll((Collection<? extends ClassAxiom>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__INSTANCES:
				setInstances((EventBNamedCommentedElement)newValue);
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
			case ClassdiagramsPackage.CLASS__CONSTANT:
				setConstant(CONSTANT_EDEFAULT);
				return;
			case ClassdiagramsPackage.CLASS__SUPERTYPES:
				getSupertypes().clear();
				return;
			case ClassdiagramsPackage.CLASS__SOURCE:
				getSource().clear();
				return;
			case ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES:
				setClassAttributes((ClassAttribute)null);
				return;
			case ClassdiagramsPackage.CLASS__CLASS_EVENTS:
				getClassEvents().clear();
				return;
			case ClassdiagramsPackage.CLASS__CLASS_INVARIANTS:
				getClassInvariants().clear();
				return;
			case ClassdiagramsPackage.CLASS__CLASS_AXIOMS:
				getClassAxioms().clear();
				return;
			case ClassdiagramsPackage.CLASS__INSTANCES:
				setInstances((EventBNamedCommentedElement)null);
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
			case ClassdiagramsPackage.CLASS__CONSTANT:
				return constant != CONSTANT_EDEFAULT;
			case ClassdiagramsPackage.CLASS__SUPERTYPES:
				return supertypes != null && !supertypes.isEmpty();
			case ClassdiagramsPackage.CLASS__SOURCE:
				return source != null && !source.isEmpty();
			case ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES:
				return classAttributes != null;
			case ClassdiagramsPackage.CLASS__CLASS_EVENTS:
				return classEvents != null && !classEvents.isEmpty();
			case ClassdiagramsPackage.CLASS__CLASS_INVARIANTS:
				return classInvariants != null && !classInvariants.isEmpty();
			case ClassdiagramsPackage.CLASS__CLASS_AXIOMS:
				return classAxioms != null && !classAxioms.isEmpty();
			case ClassdiagramsPackage.CLASS__INSTANCES:
				return instances != null;
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
		result.append(" (constant: ");
		result.append(constant);
		result.append(')');
		return result.toString();
	}

} //ClassImpl
