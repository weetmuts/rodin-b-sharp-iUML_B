/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams.impl;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.classdiagrams.ClassType;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;

import ac.soton.eventb.classdiagrams.ElaborativeElement;
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
import org.eventb.emf.core.machine.Variable;
import org.eventb.emf.core.impl.EventBElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getElaborates <em>Elaborates</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getSupertypes <em>Supertypes</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getClassAttributes <em>Class Attributes</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getRefines <em>Refines</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getClassType <em>Class Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassImpl extends EventBNamedCommentedElementImpl implements ac.soton.eventb.classdiagrams.Class {
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
	 * The default value of the '{@link #getClassType() <em>Class Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassType()
	 * @generated
	 * @ordered
	 */
	protected static final ClassType CLASS_TYPE_EDEFAULT = ClassType.SET;
	/**
	 * The cached value of the '{@link #getClassType() <em>Class Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassType()
	 * @generated
	 * @ordered
	 */
	protected ClassType classType = CLASS_TYPE_EDEFAULT;

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
	public EventBNamed getElaborates() {
		if (elaborates != null && elaborates.eIsProxy()) {
			InternalEObject oldElaborates = (InternalEObject)elaborates;
			elaborates = (EventBNamed)eResolveProxy(oldElaborates);
			if (elaborates != oldElaborates) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassdiagramsPackage.CLASS__ELABORATES, oldElaborates, elaborates));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS__ELABORATES, oldElaborates, elaborates));
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
	public ClassType getClassType() {
		return classType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassType(ClassType newClassType) {
		ClassType oldClassType = classType;
		classType = newClassType == null ? CLASS_TYPE_EDEFAULT : newClassType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS__CLASS_TYPE, oldClassType, classType));
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
			case ClassdiagramsPackage.CLASS__INCOMING:
				return ((InternalEList<?>)getIncoming()).basicRemove(otherEnd, msgs);
			case ClassdiagramsPackage.CLASS__OUTGOING:
				return ((InternalEList<?>)getOutgoing()).basicRemove(otherEnd, msgs);
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
			case ClassdiagramsPackage.CLASS__ELABORATES:
				if (resolve) return getElaborates();
				return basicGetElaborates();
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
			case ClassdiagramsPackage.CLASS__CLASS_TYPE:
				return getClassType();
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
			case ClassdiagramsPackage.CLASS__ELABORATES:
				setElaborates((EventBNamed)newValue);
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
			case ClassdiagramsPackage.CLASS__CLASS_TYPE:
				setClassType((ClassType)newValue);
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
			case ClassdiagramsPackage.CLASS__ELABORATES:
				setElaborates((EventBNamed)null);
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
			case ClassdiagramsPackage.CLASS__CLASS_TYPE:
				setClassType(CLASS_TYPE_EDEFAULT);
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
			case ClassdiagramsPackage.CLASS__ELABORATES:
				return elaborates != null;
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
			case ClassdiagramsPackage.CLASS__CLASS_TYPE:
				return classType != CLASS_TYPE_EDEFAULT;
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
		if (baseClass == ElaborativeElement.class) {
			switch (derivedFeatureID) {
				case ClassdiagramsPackage.CLASS__ELABORATES: return ClassdiagramsPackage.ELABORATIVE_ELEMENT__ELABORATES;
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
		if (baseClass == ElaborativeElement.class) {
			switch (baseFeatureID) {
				case ClassdiagramsPackage.ELABORATIVE_ELEMENT__ELABORATES: return ClassdiagramsPackage.CLASS__ELABORATES;
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
		result.append(" (classType: ");
		result.append(classType);
		result.append(')');
		return result.toString();
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

} //ClassImpl
