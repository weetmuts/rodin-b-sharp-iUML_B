/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams.impl;

import ac.soton.eventb.classdiagrams.AssociationType;
import ac.soton.eventb.classdiagrams.AssociativeElement;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Associative Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AssociativeElementImpl#isSurjective <em>Surjective</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AssociativeElementImpl#isInjective <em>Injective</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AssociativeElementImpl#isTotal <em>Total</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AssociativeElementImpl#isFunctional <em>Functional</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AssociativeElementImpl#getAssociationType <em>Association Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociativeElementImpl extends EObjectImpl implements AssociativeElement {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociativeElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassdiagramsPackage.Literals.ASSOCIATIVE_ELEMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__SURJECTIVE, oldSurjective, surjective));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__INJECTIVE, oldInjective, injective));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__TOTAL, oldTotal, total));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__FUNCTIONAL, oldFunctional, functional));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__ASSOCIATION_TYPE, oldAssociationType, associationType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__SURJECTIVE:
				return isSurjective();
			case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__INJECTIVE:
				return isInjective();
			case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__TOTAL:
				return isTotal();
			case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__FUNCTIONAL:
				return isFunctional();
			case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__ASSOCIATION_TYPE:
				return getAssociationType();
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
			case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__SURJECTIVE:
				setSurjective((Boolean)newValue);
				return;
			case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__INJECTIVE:
				setInjective((Boolean)newValue);
				return;
			case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__TOTAL:
				setTotal((Boolean)newValue);
				return;
			case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__FUNCTIONAL:
				setFunctional((Boolean)newValue);
				return;
			case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__ASSOCIATION_TYPE:
				setAssociationType((AssociationType)newValue);
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
			case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__SURJECTIVE:
				setSurjective(SURJECTIVE_EDEFAULT);
				return;
			case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__INJECTIVE:
				setInjective(INJECTIVE_EDEFAULT);
				return;
			case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__TOTAL:
				setTotal(TOTAL_EDEFAULT);
				return;
			case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__FUNCTIONAL:
				setFunctional(FUNCTIONAL_EDEFAULT);
				return;
			case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__ASSOCIATION_TYPE:
				setAssociationType(ASSOCIATION_TYPE_EDEFAULT);
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
			case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__SURJECTIVE:
				return surjective != SURJECTIVE_EDEFAULT;
			case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__INJECTIVE:
				return injective != INJECTIVE_EDEFAULT;
			case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__TOTAL:
				return total != TOTAL_EDEFAULT;
			case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__FUNCTIONAL:
				return functional != FUNCTIONAL_EDEFAULT;
			case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__ASSOCIATION_TYPE:
				return associationType != ASSOCIATION_TYPE_EDEFAULT;
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

} //AssociativeElementImpl
