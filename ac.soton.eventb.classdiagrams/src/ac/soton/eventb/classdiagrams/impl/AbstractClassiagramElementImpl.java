/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams.impl;

import ac.soton.eventb.classdiagrams.AbstractClassiagramElement;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eventb.emf.core.impl.EventBNamedCommentedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Classiagram Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AbstractClassiagramElementImpl#isConstant <em>Constant</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.AbstractClassiagramElementImpl#getTargetContext <em>Target Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbstractClassiagramElementImpl extends EventBNamedCommentedElementImpl implements AbstractClassiagramElement {
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
	 * The default value of the '{@link #getTargetContext() <em>Target Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetContext()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_CONTEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetContext() <em>Target Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetContext()
	 * @generated
	 * @ordered
	 */
	protected String targetContext = TARGET_CONTEXT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractClassiagramElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassdiagramsPackage.Literals.ABSTRACT_CLASSIAGRAM_ELEMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.ABSTRACT_CLASSIAGRAM_ELEMENT__CONSTANT, oldConstant, constant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetContext() {
		return targetContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetContext(String newTargetContext) {
		String oldTargetContext = targetContext;
		targetContext = newTargetContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.ABSTRACT_CLASSIAGRAM_ELEMENT__TARGET_CONTEXT, oldTargetContext, targetContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassdiagramsPackage.ABSTRACT_CLASSIAGRAM_ELEMENT__CONSTANT:
				return isConstant();
			case ClassdiagramsPackage.ABSTRACT_CLASSIAGRAM_ELEMENT__TARGET_CONTEXT:
				return getTargetContext();
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
			case ClassdiagramsPackage.ABSTRACT_CLASSIAGRAM_ELEMENT__CONSTANT:
				setConstant((Boolean)newValue);
				return;
			case ClassdiagramsPackage.ABSTRACT_CLASSIAGRAM_ELEMENT__TARGET_CONTEXT:
				setTargetContext((String)newValue);
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
			case ClassdiagramsPackage.ABSTRACT_CLASSIAGRAM_ELEMENT__CONSTANT:
				setConstant(CONSTANT_EDEFAULT);
				return;
			case ClassdiagramsPackage.ABSTRACT_CLASSIAGRAM_ELEMENT__TARGET_CONTEXT:
				setTargetContext(TARGET_CONTEXT_EDEFAULT);
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
			case ClassdiagramsPackage.ABSTRACT_CLASSIAGRAM_ELEMENT__CONSTANT:
				return constant != CONSTANT_EDEFAULT;
			case ClassdiagramsPackage.ABSTRACT_CLASSIAGRAM_ELEMENT__TARGET_CONTEXT:
				return TARGET_CONTEXT_EDEFAULT == null ? targetContext != null : !TARGET_CONTEXT_EDEFAULT.equals(targetContext);
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
		result.append(", targetContext: ");
		result.append(targetContext);
		result.append(')');
		return result.toString();
	}

} //AbstractClassiagramElementImpl
