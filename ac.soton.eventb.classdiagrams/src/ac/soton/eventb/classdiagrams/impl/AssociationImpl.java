/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams.impl;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eventb.emf.core.impl.EventBNamedCommentedElementImpl;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;

import org.eventb.emf.core.impl.EventBElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AssociationImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AssociationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AssociationImpl#isConstant <em>Constant</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AssociationImpl#isSurjective <em>Surjective</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AssociationImpl#isInjective <em>Injective</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AssociationImpl#isTotal <em>Total</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AssociationImpl#isFunctional <em>Functional</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationImpl extends EventBNamedCommentedElementImpl implements Association {
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.ASSOCIATION__CONSTANT, oldConstant, constant));
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
			case ClassdiagramsPackage.ASSOCIATION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case ClassdiagramsPackage.ASSOCIATION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case ClassdiagramsPackage.ASSOCIATION__CONSTANT:
				return isConstant();
			case ClassdiagramsPackage.ASSOCIATION__SURJECTIVE:
				return isSurjective();
			case ClassdiagramsPackage.ASSOCIATION__INJECTIVE:
				return isInjective();
			case ClassdiagramsPackage.ASSOCIATION__TOTAL:
				return isTotal();
			case ClassdiagramsPackage.ASSOCIATION__FUNCTIONAL:
				return isFunctional();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ClassdiagramsPackage.ASSOCIATION__TARGET:
				setTarget((ac.soton.eventb.classdiagrams.Class)newValue);
				return;
			case ClassdiagramsPackage.ASSOCIATION__SOURCE:
				setSource((ac.soton.eventb.classdiagrams.Class)newValue);
				return;
			case ClassdiagramsPackage.ASSOCIATION__CONSTANT:
				setConstant((Boolean)newValue);
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
			case ClassdiagramsPackage.ASSOCIATION__TARGET:
				setTarget((ac.soton.eventb.classdiagrams.Class)null);
				return;
			case ClassdiagramsPackage.ASSOCIATION__SOURCE:
				setSource((ac.soton.eventb.classdiagrams.Class)null);
				return;
			case ClassdiagramsPackage.ASSOCIATION__CONSTANT:
				setConstant(CONSTANT_EDEFAULT);
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
			case ClassdiagramsPackage.ASSOCIATION__TARGET:
				return target != null;
			case ClassdiagramsPackage.ASSOCIATION__SOURCE:
				return source != null;
			case ClassdiagramsPackage.ASSOCIATION__CONSTANT:
				return constant != CONSTANT_EDEFAULT;
			case ClassdiagramsPackage.ASSOCIATION__SURJECTIVE:
				return surjective != SURJECTIVE_EDEFAULT;
			case ClassdiagramsPackage.ASSOCIATION__INJECTIVE:
				return injective != INJECTIVE_EDEFAULT;
			case ClassdiagramsPackage.ASSOCIATION__TOTAL:
				return total != TOTAL_EDEFAULT;
			case ClassdiagramsPackage.ASSOCIATION__FUNCTIONAL:
				return functional != FUNCTIONAL_EDEFAULT;
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
		result.append(", surjective: ");
		result.append(surjective);
		result.append(", injective: ");
		result.append(injective);
		result.append(", total: ");
		result.append(total);
		result.append(", functional: ");
		result.append(functional);
		result.append(')');
		return result.toString();
	}

} //AssociationImpl
