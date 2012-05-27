/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams.impl;

import ac.soton.eventb.classdiagrams.AssociationType;
import ac.soton.eventb.classdiagrams.AssociativeElement;
import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;

import java.util.Collection;
import ac.soton.eventb.classdiagrams.ElaborativeElement;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.Annotation;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.EventBNamedCommentedElement;
import org.eventb.emf.core.EventBObject;
import org.eventb.emf.core.impl.StringToAttributeMapEntryImpl;
import org.eventb.emf.core.Attribute;
import org.eventb.emf.core.AttributeType;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBCommented;
import org.eventb.emf.core.EventBCommentedElement;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.impl.EventBNamedCommentedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassAttributeImpl#getElaborates <em>Elaborates</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassAttributeImpl#isSurjective <em>Surjective</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassAttributeImpl#isInjective <em>Injective</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassAttributeImpl#isTotal <em>Total</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassAttributeImpl#isFunctional <em>Functional</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassAttributeImpl#getAssociationType <em>Association Type</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassAttributeImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassAttributeImpl extends EventBNamedCommentedElementImpl implements ClassAttribute{
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
	 * The default value of the '{@link #getTarget() <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected String target = TARGET_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassdiagramsPackage.Literals.CLASS_ATTRIBUTE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassdiagramsPackage.CLASS_ATTRIBUTE__ELABORATES, oldElaborates, elaborates));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS_ATTRIBUTE__ELABORATES, oldElaborates, elaborates));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(String newTarget) {
		String oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS_ATTRIBUTE__TARGET, oldTarget, target));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS_ATTRIBUTE__SURJECTIVE, oldSurjective, surjective));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS_ATTRIBUTE__INJECTIVE, oldInjective, injective));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS_ATTRIBUTE__TOTAL, oldTotal, total));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS_ATTRIBUTE__FUNCTIONAL, oldFunctional, functional));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS_ATTRIBUTE__ASSOCIATION_TYPE, oldAssociationType, associationType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__ELABORATES:
				if (resolve) return getElaborates();
				return basicGetElaborates();
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__SURJECTIVE:
				return isSurjective();
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__INJECTIVE:
				return isInjective();
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__TOTAL:
				return isTotal();
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__FUNCTIONAL:
				return isFunctional();
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__ASSOCIATION_TYPE:
				return getAssociationType();
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__TARGET:
				return getTarget();
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
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__ELABORATES:
				setElaborates((EventBNamed)newValue);
				return;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__SURJECTIVE:
				setSurjective((Boolean)newValue);
				return;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__INJECTIVE:
				setInjective((Boolean)newValue);
				return;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__TOTAL:
				setTotal((Boolean)newValue);
				return;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__FUNCTIONAL:
				setFunctional((Boolean)newValue);
				return;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__ASSOCIATION_TYPE:
				setAssociationType((AssociationType)newValue);
				return;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__TARGET:
				setTarget((String)newValue);
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
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__ELABORATES:
				setElaborates((EventBNamed)null);
				return;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__SURJECTIVE:
				setSurjective(SURJECTIVE_EDEFAULT);
				return;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__INJECTIVE:
				setInjective(INJECTIVE_EDEFAULT);
				return;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__TOTAL:
				setTotal(TOTAL_EDEFAULT);
				return;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__FUNCTIONAL:
				setFunctional(FUNCTIONAL_EDEFAULT);
				return;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__ASSOCIATION_TYPE:
				setAssociationType(ASSOCIATION_TYPE_EDEFAULT);
				return;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__TARGET:
				setTarget(TARGET_EDEFAULT);
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
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__ELABORATES:
				return elaborates != null;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__SURJECTIVE:
				return surjective != SURJECTIVE_EDEFAULT;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__INJECTIVE:
				return injective != INJECTIVE_EDEFAULT;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__TOTAL:
				return total != TOTAL_EDEFAULT;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__FUNCTIONAL:
				return functional != FUNCTIONAL_EDEFAULT;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__ASSOCIATION_TYPE:
				return associationType != ASSOCIATION_TYPE_EDEFAULT;
			case ClassdiagramsPackage.CLASS_ATTRIBUTE__TARGET:
				return TARGET_EDEFAULT == null ? target != null : !TARGET_EDEFAULT.equals(target);
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
				case ClassdiagramsPackage.CLASS_ATTRIBUTE__ELABORATES: return ClassdiagramsPackage.ELABORATIVE_ELEMENT__ELABORATES;
				default: return -1;
			}
		}
		if (baseClass == AssociativeElement.class) {
			switch (derivedFeatureID) {
				case ClassdiagramsPackage.CLASS_ATTRIBUTE__SURJECTIVE: return ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__SURJECTIVE;
				case ClassdiagramsPackage.CLASS_ATTRIBUTE__INJECTIVE: return ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__INJECTIVE;
				case ClassdiagramsPackage.CLASS_ATTRIBUTE__TOTAL: return ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__TOTAL;
				case ClassdiagramsPackage.CLASS_ATTRIBUTE__FUNCTIONAL: return ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__FUNCTIONAL;
				case ClassdiagramsPackage.CLASS_ATTRIBUTE__ASSOCIATION_TYPE: return ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__ASSOCIATION_TYPE;
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
				case ClassdiagramsPackage.ELABORATIVE_ELEMENT__ELABORATES: return ClassdiagramsPackage.CLASS_ATTRIBUTE__ELABORATES;
				default: return -1;
			}
		}
		if (baseClass == AssociativeElement.class) {
			switch (baseFeatureID) {
				case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__SURJECTIVE: return ClassdiagramsPackage.CLASS_ATTRIBUTE__SURJECTIVE;
				case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__INJECTIVE: return ClassdiagramsPackage.CLASS_ATTRIBUTE__INJECTIVE;
				case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__TOTAL: return ClassdiagramsPackage.CLASS_ATTRIBUTE__TOTAL;
				case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__FUNCTIONAL: return ClassdiagramsPackage.CLASS_ATTRIBUTE__FUNCTIONAL;
				case ClassdiagramsPackage.ASSOCIATIVE_ELEMENT__ASSOCIATION_TYPE: return ClassdiagramsPackage.CLASS_ATTRIBUTE__ASSOCIATION_TYPE;
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
		result.append(", target: ");
		result.append(target);
		result.append(')');
		return result.toString();
	}

	@Override
	public URI getURI() {
		// TODO Auto-generated method stub
		return null;
	}

} //ClassAttributeImpl
