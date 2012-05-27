/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams.impl;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.AssociationType;
import ac.soton.eventb.classdiagrams.AssociativeElement;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;

import ac.soton.eventb.classdiagrams.ElaborativeElement;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eventb.emf.core.impl.EventBNamedCommentedElementImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.Annotation;
import org.eventb.emf.core.Attribute;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBCommented;
import org.eventb.emf.core.EventBCommentedElement;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.EventBNamedCommentedElement;
import org.eventb.emf.core.EventBObject;

import org.eventb.emf.core.impl.StringToAttributeMapEntryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AssociationImpl#getElaborates <em>Elaborates</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AssociationImpl#isSurjective <em>Surjective</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AssociationImpl#isInjective <em>Injective</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AssociationImpl#isTotal <em>Total</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AssociationImpl#isFunctional <em>Functional</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AssociationImpl#getAssociationType <em>Association Type</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AssociationImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AssociationImpl#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationImpl extends EventBNamedCommentedElementImpl implements Association {
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
	 * The default value of the '{@link #isSurjective() <em>Surjective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSurjective()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SURJECTIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSurjective() <em>Surjective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSurjective()
	 * @generated
	 * @ordered
	 */
	protected boolean surjective = SURJECTIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isInjective() <em>Injective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInjective()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INJECTIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInjective() <em>Injective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInjective()
	 * @generated
	 * @ordered
	 */
	protected boolean injective = INJECTIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isTotal() <em>Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTotal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TOTAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTotal() <em>Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTotal()
	 * @generated
	 * @ordered
	 */
	protected boolean total = TOTAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isFunctional() <em>Functional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFunctional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FUNCTIONAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFunctional() <em>Functional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFunctional()
	 * @generated
	 * @ordered
	 */
	protected boolean functional = FUNCTIONAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getAssociationType() <em>Association Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociationType()
	 * @generated
	 * @ordered
	 */
	protected static final AssociationType ASSOCIATION_TYPE_EDEFAULT = AssociationType.CONSTANT;

	/**
	 * The cached value of the '{@link #getAssociationType() <em>Association Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociationType()
	 * @generated
	 * @ordered
	 */
	protected AssociationType associationType = ASSOCIATION_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected ac.soton.eventb.classdiagrams.Class target;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected ac.soton.eventb.classdiagrams.Class source;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassdiagramsPackage.Literals.ASSOCIATION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassdiagramsPackage.ASSOCIATION__ELABORATES, oldElaborates, elaborates));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.ASSOCIATION__ELABORATES, oldElaborates, elaborates));
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
	public ac.soton.eventb.classdiagrams.Class getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (ac.soton.eventb.classdiagrams.Class)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassdiagramsPackage.ASSOCIATION__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ac.soton.eventb.classdiagrams.Class basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(ac.soton.eventb.classdiagrams.Class newTarget, NotificationChain msgs) {
		ac.soton.eventb.classdiagrams.Class oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.ASSOCIATION__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(ac.soton.eventb.classdiagrams.Class newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, ClassdiagramsPackage.CLASS__INCOMING, ac.soton.eventb.classdiagrams.Class.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, ClassdiagramsPackage.CLASS__INCOMING, ac.soton.eventb.classdiagrams.Class.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.ASSOCIATION__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ac.soton.eventb.classdiagrams.Class getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (ac.soton.eventb.classdiagrams.Class)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassdiagramsPackage.ASSOCIATION__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ac.soton.eventb.classdiagrams.Class basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(ac.soton.eventb.classdiagrams.Class newSource, NotificationChain msgs) {
		ac.soton.eventb.classdiagrams.Class oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.ASSOCIATION__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(ac.soton.eventb.classdiagrams.Class newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, ClassdiagramsPackage.CLASS__OUTGOING, ac.soton.eventb.classdiagrams.Class.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, ClassdiagramsPackage.CLASS__OUTGOING, ac.soton.eventb.classdiagrams.Class.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.ASSOCIATION__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSurjective() {
		return surjective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSurjective(boolean newSurjective) {
		boolean oldSurjective = surjective;
		surjective = newSurjective;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.ASSOCIATION__SURJECTIVE, oldSurjective, surjective));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInjective() {
		return injective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInjective(boolean newInjective) {
		boolean oldInjective = injective;
		injective = newInjective;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.ASSOCIATION__INJECTIVE, oldInjective, injective));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTotal() {
		return total;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotal(boolean newTotal) {
		boolean oldTotal = total;
		total = newTotal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.ASSOCIATION__TOTAL, oldTotal, total));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFunctional() {
		return functional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctional(boolean newFunctional) {
		boolean oldFunctional = functional;
		functional = newFunctional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.ASSOCIATION__FUNCTIONAL, oldFunctional, functional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationType getAssociationType() {
		return associationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociationType(AssociationType newAssociationType) {
		AssociationType oldAssociationType = associationType;
		associationType = newAssociationType == null ? ASSOCIATION_TYPE_EDEFAULT : newAssociationType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.ASSOCIATION__ASSOCIATION_TYPE, oldAssociationType, associationType));
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
			case ClassdiagramsPackage.ASSOCIATION__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, ClassdiagramsPackage.CLASS__INCOMING, ac.soton.eventb.classdiagrams.Class.class, msgs);
				return basicSetTarget((ac.soton.eventb.classdiagrams.Class)otherEnd, msgs);
			case ClassdiagramsPackage.ASSOCIATION__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, ClassdiagramsPackage.CLASS__OUTGOING, ac.soton.eventb.classdiagrams.Class.class, msgs);
				return basicSetSource((ac.soton.eventb.classdiagrams.Class)otherEnd, msgs);
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
			case ClassdiagramsPackage.ASSOCIATION__TARGET:
				return basicSetTarget(null, msgs);
			case ClassdiagramsPackage.ASSOCIATION__SOURCE:
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
			case ClassdiagramsPackage.ASSOCIATION__ELABORATES:
				if (resolve) return getElaborates();
				return basicGetElaborates();
			case ClassdiagramsPackage.ASSOCIATION__SURJECTIVE:
				return isSurjective();
			case ClassdiagramsPackage.ASSOCIATION__INJECTIVE:
				return isInjective();
			case ClassdiagramsPackage.ASSOCIATION__TOTAL:
				return isTotal();
			case ClassdiagramsPackage.ASSOCIATION__FUNCTIONAL:
				return isFunctional();
			case ClassdiagramsPackage.ASSOCIATION__ASSOCIATION_TYPE:
				return getAssociationType();
			case ClassdiagramsPackage.ASSOCIATION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case ClassdiagramsPackage.ASSOCIATION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
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
			case ClassdiagramsPackage.ASSOCIATION__ELABORATES:
				setElaborates((EventBNamed)newValue);
				return;
			case ClassdiagramsPackage.ASSOCIATION__SURJECTIVE:
				setSurjective((Boolean)newValue);
				return;
			case ClassdiagramsPackage.ASSOCIATION__INJECTIVE:
				setInjective((Boolean)newValue);
				return;
			case ClassdiagramsPackage.ASSOCIATION__TOTAL:
				setTotal((Boolean)newValue);
				return;
			case ClassdiagramsPackage.ASSOCIATION__FUNCTIONAL:
				setFunctional((Boolean)newValue);
				return;
			case ClassdiagramsPackage.ASSOCIATION__ASSOCIATION_TYPE:
				setAssociationType((AssociationType)newValue);
				return;
			case ClassdiagramsPackage.ASSOCIATION__TARGET:
				setTarget((ac.soton.eventb.classdiagrams.Class)newValue);
				return;
			case ClassdiagramsPackage.ASSOCIATION__SOURCE:
				setSource((ac.soton.eventb.classdiagrams.Class)newValue);
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
			case ClassdiagramsPackage.ASSOCIATION__ELABORATES:
				setElaborates((EventBNamed)null);
				return;
			case ClassdiagramsPackage.ASSOCIATION__SURJECTIVE:
				setSurjective(SURJECTIVE_EDEFAULT);
				return;
			case ClassdiagramsPackage.ASSOCIATION__INJECTIVE:
				setInjective(INJECTIVE_EDEFAULT);
				return;
			case ClassdiagramsPackage.ASSOCIATION__TOTAL:
				setTotal(TOTAL_EDEFAULT);
				return;
			case ClassdiagramsPackage.ASSOCIATION__FUNCTIONAL:
				setFunctional(FUNCTIONAL_EDEFAULT);
				return;
			case ClassdiagramsPackage.ASSOCIATION__ASSOCIATION_TYPE:
				setAssociationType(ASSOCIATION_TYPE_EDEFAULT);
				return;
			case ClassdiagramsPackage.ASSOCIATION__TARGET:
				setTarget((ac.soton.eventb.classdiagrams.Class)null);
				return;
			case ClassdiagramsPackage.ASSOCIATION__SOURCE:
				setSource((ac.soton.eventb.classdiagrams.Class)null);
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
			case ClassdiagramsPackage.ASSOCIATION__ELABORATES:
				return elaborates != null;
			case ClassdiagramsPackage.ASSOCIATION__SURJECTIVE:
				return surjective != SURJECTIVE_EDEFAULT;
			case ClassdiagramsPackage.ASSOCIATION__INJECTIVE:
				return injective != INJECTIVE_EDEFAULT;
			case ClassdiagramsPackage.ASSOCIATION__TOTAL:
				return total != TOTAL_EDEFAULT;
			case ClassdiagramsPackage.ASSOCIATION__FUNCTIONAL:
				return functional != FUNCTIONAL_EDEFAULT;
			case ClassdiagramsPackage.ASSOCIATION__ASSOCIATION_TYPE:
				return associationType != ASSOCIATION_TYPE_EDEFAULT;
			case ClassdiagramsPackage.ASSOCIATION__TARGET:
				return target != null;
			case ClassdiagramsPackage.ASSOCIATION__SOURCE:
				return source != null;
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
				case ClassdiagramsPackage.ASSOCIATION__ELABORATES: return ClassdiagramsPackage.ELABORATIVE_ELEMENT__ELABORATES;
				default: return -1;
			}
		}
		if (baseClass == AssociativeElement.class) {
			switch (derivedFeatureID) {
				case ClassdiagramsPackage.ASSOCIATION__SURJECTIVE: return ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__SURJECTIVE;
				case ClassdiagramsPackage.ASSOCIATION__INJECTIVE: return ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__INJECTIVE;
				case ClassdiagramsPackage.ASSOCIATION__TOTAL: return ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__TOTAL;
				case ClassdiagramsPackage.ASSOCIATION__FUNCTIONAL: return ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__FUNCTIONAL;
				case ClassdiagramsPackage.ASSOCIATION__ASSOCIATION_TYPE: return ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__ASSOCIATION_TYPE;
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
				case ClassdiagramsPackage.ELABORATIVE_ELEMENT__ELABORATES: return ClassdiagramsPackage.ASSOCIATION__ELABORATES;
				default: return -1;
			}
		}
		if (baseClass == AssociativeElement.class) {
			switch (baseFeatureID) {
				case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__SURJECTIVE: return ClassdiagramsPackage.ASSOCIATION__SURJECTIVE;
				case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__INJECTIVE: return ClassdiagramsPackage.ASSOCIATION__INJECTIVE;
				case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__TOTAL: return ClassdiagramsPackage.ASSOCIATION__TOTAL;
				case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__FUNCTIONAL: return ClassdiagramsPackage.ASSOCIATION__FUNCTIONAL;
				case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__ASSOCIATION_TYPE: return ClassdiagramsPackage.ASSOCIATION__ASSOCIATION_TYPE;
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
		result.append(" (surjective: ");
		result.append(surjective);
		result.append(", injective: ");
		result.append(injective);
		result.append(", total: ");
		result.append(total);
		result.append(", functional: ");
		result.append(functional);
		result.append(", AssociationType: ");
		result.append(associationType);
		result.append(')');
		return result.toString();
	}

} //AssociationImpl
