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

import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBCommented;
import org.eventb.emf.core.EventBCommentedElement;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.EventBNamedCommentedElement;

import org.eventb.emf.core.impl.EventBNamedCommentedElementImpl;
import org.eventb.emf.core.impl.EventBElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getSupertypes <em>Supertypes</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getClassAttributes <em>Class Attributes</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getClassInvariants <em>Class Invariants</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getClassAxioms <em>Class Axioms</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getInstances <em>Instances</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#isConstant <em>Constant</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getTargetFile <em>Target File</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getRefines <em>Refines</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getClassEvents <em>Class Events</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassImpl extends EventBNamedCommentedElementImpl implements ac.soton.eventb.classdiagrams.Class {
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
	 * The cached value of the '{@link #getExtends() <em>Extends</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected ac.soton.eventb.classdiagrams.Class extends_;

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
	 * The cached value of the '{@link #getTargetFile() <em>Target File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetFile()
	 * @generated
	 * @ordered
	 */
	protected EList<?> targetFile;

	/**
	 * The cached value of the '{@link #getRefines() <em>Refines</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefines()
	 * @generated
	 * @ordered
	 */
	protected EList<ac.soton.eventb.classdiagrams.Class> refines;

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
	 * @generated NOT
	 */
	public String getName() {
		return doGetName();
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS__NAME, oldName, newName));
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
	public ac.soton.eventb.classdiagrams.Class getExtends() {
		if (extends_ != null && extends_.eIsProxy()) {
			InternalEObject oldExtends = (InternalEObject)extends_;
			extends_ = (ac.soton.eventb.classdiagrams.Class)eResolveProxy(oldExtends);
			if (extends_ != oldExtends) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassdiagramsPackage.CLASS__EXTENDS, oldExtends, extends_));
			}
		}
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ac.soton.eventb.classdiagrams.Class basicGetExtends() {
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtends(ac.soton.eventb.classdiagrams.Class newExtends) {
		ac.soton.eventb.classdiagrams.Class oldExtends = extends_;
		extends_ = newExtends;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS__EXTENDS, oldExtends, extends_));
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
	public EList<?> getTargetFile() {
		return targetFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetFile(EList<?> newTargetFile) {
		EList<?> oldTargetFile = targetFile;
		targetFile = newTargetFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS__TARGET_FILE, oldTargetFile, targetFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ac.soton.eventb.classdiagrams.Class> getRefines() {
		if (refines == null) {
			refines = new EObjectResolvingEList<ac.soton.eventb.classdiagrams.Class>(ac.soton.eventb.classdiagrams.Class.class, this, ClassdiagramsPackage.CLASS__REFINES);
		}
		return refines;
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
			case ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES:
				return ((InternalEList<?>)getClassAttributes()).basicRemove(otherEnd, msgs);
			case ClassdiagramsPackage.CLASS__CLASS_INVARIANTS:
				return ((InternalEList<?>)getClassInvariants()).basicRemove(otherEnd, msgs);
			case ClassdiagramsPackage.CLASS__CLASS_AXIOMS:
				return ((InternalEList<?>)getClassAxioms()).basicRemove(otherEnd, msgs);
			case ClassdiagramsPackage.CLASS__INCOMING:
				return ((InternalEList<?>)getIncoming()).basicRemove(otherEnd, msgs);
			case ClassdiagramsPackage.CLASS__OUTGOING:
				return ((InternalEList<?>)getOutgoing()).basicRemove(otherEnd, msgs);
			case ClassdiagramsPackage.CLASS__CLASS_EVENTS:
				return ((InternalEList<?>)getClassEvents()).basicRemove(otherEnd, msgs);
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
			case ClassdiagramsPackage.CLASS__SUPERTYPES:
				return getSupertypes();
			case ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES:
				return getClassAttributes();
			case ClassdiagramsPackage.CLASS__CLASS_INVARIANTS:
				return getClassInvariants();
			case ClassdiagramsPackage.CLASS__CLASS_AXIOMS:
				return getClassAxioms();
			case ClassdiagramsPackage.CLASS__INSTANCES:
				if (resolve) return getInstances();
				return basicGetInstances();
			case ClassdiagramsPackage.CLASS__EXTENDS:
				if (resolve) return getExtends();
				return basicGetExtends();
			case ClassdiagramsPackage.CLASS__INCOMING:
				return getIncoming();
			case ClassdiagramsPackage.CLASS__OUTGOING:
				return getOutgoing();
			case ClassdiagramsPackage.CLASS__CONSTANT:
				return isConstant();
			case ClassdiagramsPackage.CLASS__TARGET_FILE:
				return getTargetFile();
			case ClassdiagramsPackage.CLASS__REFINES:
				return getRefines();
			case ClassdiagramsPackage.CLASS__CLASS_EVENTS:
				return getClassEvents();
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
			case ClassdiagramsPackage.CLASS__SUPERTYPES:
				getSupertypes().clear();
				getSupertypes().addAll((Collection<? extends ac.soton.eventb.classdiagrams.Class>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES:
				getClassAttributes().clear();
				getClassAttributes().addAll((Collection<? extends ClassAttribute>)newValue);
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
			case ClassdiagramsPackage.CLASS__EXTENDS:
				setExtends((ac.soton.eventb.classdiagrams.Class)newValue);
				return;
			case ClassdiagramsPackage.CLASS__INCOMING:
				getIncoming().clear();
				getIncoming().addAll((Collection<? extends Association>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__OUTGOING:
				getOutgoing().clear();
				getOutgoing().addAll((Collection<? extends Association>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__CONSTANT:
				setConstant((Boolean)newValue);
				return;
			case ClassdiagramsPackage.CLASS__TARGET_FILE:
				setTargetFile((EList<?>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__REFINES:
				getRefines().clear();
				getRefines().addAll((Collection<? extends ac.soton.eventb.classdiagrams.Class>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__CLASS_EVENTS:
				getClassEvents().clear();
				getClassEvents().addAll((Collection<? extends ClassEvent>)newValue);
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
			case ClassdiagramsPackage.CLASS__SUPERTYPES:
				getSupertypes().clear();
				return;
			case ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES:
				getClassAttributes().clear();
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
			case ClassdiagramsPackage.CLASS__EXTENDS:
				setExtends((ac.soton.eventb.classdiagrams.Class)null);
				return;
			case ClassdiagramsPackage.CLASS__INCOMING:
				getIncoming().clear();
				return;
			case ClassdiagramsPackage.CLASS__OUTGOING:
				getOutgoing().clear();
				return;
			case ClassdiagramsPackage.CLASS__CONSTANT:
				setConstant(CONSTANT_EDEFAULT);
				return;
			case ClassdiagramsPackage.CLASS__TARGET_FILE:
				setTargetFile((EList<?>)null);
				return;
			case ClassdiagramsPackage.CLASS__REFINES:
				getRefines().clear();
				return;
			case ClassdiagramsPackage.CLASS__CLASS_EVENTS:
				getClassEvents().clear();
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
			case ClassdiagramsPackage.CLASS__SUPERTYPES:
				return supertypes != null && !supertypes.isEmpty();
			case ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES:
				return classAttributes != null && !classAttributes.isEmpty();
			case ClassdiagramsPackage.CLASS__CLASS_INVARIANTS:
				return classInvariants != null && !classInvariants.isEmpty();
			case ClassdiagramsPackage.CLASS__CLASS_AXIOMS:
				return classAxioms != null && !classAxioms.isEmpty();
			case ClassdiagramsPackage.CLASS__INSTANCES:
				return instances != null;
			case ClassdiagramsPackage.CLASS__EXTENDS:
				return extends_ != null;
			case ClassdiagramsPackage.CLASS__INCOMING:
				return incoming != null && !incoming.isEmpty();
			case ClassdiagramsPackage.CLASS__OUTGOING:
				return outgoing != null && !outgoing.isEmpty();
			case ClassdiagramsPackage.CLASS__CONSTANT:
				return constant != CONSTANT_EDEFAULT;
			case ClassdiagramsPackage.CLASS__TARGET_FILE:
				return targetFile != null;
			case ClassdiagramsPackage.CLASS__REFINES:
				return refines != null && !refines.isEmpty();
			case ClassdiagramsPackage.CLASS__CLASS_EVENTS:
				return classEvents != null && !classEvents.isEmpty();
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
		result.append(", targetFile: ");
		result.append(targetFile);
		result.append(')');
		return result.toString();
	}

} //ClassImpl
