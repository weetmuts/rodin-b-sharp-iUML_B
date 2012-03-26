/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams.impl;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.ClassDiagram;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBCommented;
import org.eventb.emf.core.EventBCommentedElement;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.EventBNamedCommentedElement;

import org.eventb.emf.core.impl.AbstractExtensionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassDiagramImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassDiagramImpl#getName <em>Name</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassDiagramImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassDiagramImpl#getClassAssociations <em>Class Associations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassDiagramImpl extends AbstractExtensionImpl implements ClassDiagram {
	/**
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected String comment = COMMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<ac.soton.eventb.classdiagrams.Class> classes;

	/**
	 * The cached value of the '{@link #getClassAssociations() <em>Class Associations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> classAssociations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassdiagramsPackage.Literals.CLASS_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment) {
		String oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS_DIAGRAM__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return "bla";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		// TODO: implement this method to set the 'Name' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ac.soton.eventb.classdiagrams.Class> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentEList.Resolving<ac.soton.eventb.classdiagrams.Class>(ac.soton.eventb.classdiagrams.Class.class, this, ClassdiagramsPackage.CLASS_DIAGRAM__CLASSES);
		}
		return classes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getClassAssociations() {
		if (classAssociations == null) {
			classAssociations = new EObjectContainmentEList.Resolving<Association>(Association.class, this, ClassdiagramsPackage.CLASS_DIAGRAM__CLASS_ASSOCIATIONS);
		}
		return classAssociations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String doGetName() {
		assert (this instanceof EventBElement);
		String reference = ((EventBElement)this).getReferenceWithoutResolving();
		return reference.length() > this.eStaticClass().getInstanceClassName().length() ?
			reference.substring(this.eStaticClass().getInstanceClassName().length()+1)
			: "";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void doSetName(String newName) {
		((EventBElement)this).setReference(this.eStaticClass().getInstanceClassName()+"."+newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClassdiagramsPackage.CLASS_DIAGRAM__CLASSES:
				return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
			case ClassdiagramsPackage.CLASS_DIAGRAM__CLASS_ASSOCIATIONS:
				return ((InternalEList<?>)getClassAssociations()).basicRemove(otherEnd, msgs);
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
			case ClassdiagramsPackage.CLASS_DIAGRAM__COMMENT:
				return getComment();
			case ClassdiagramsPackage.CLASS_DIAGRAM__NAME:
				return getName();
			case ClassdiagramsPackage.CLASS_DIAGRAM__CLASSES:
				return getClasses();
			case ClassdiagramsPackage.CLASS_DIAGRAM__CLASS_ASSOCIATIONS:
				return getClassAssociations();
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
			case ClassdiagramsPackage.CLASS_DIAGRAM__COMMENT:
				setComment((String)newValue);
				return;
			case ClassdiagramsPackage.CLASS_DIAGRAM__NAME:
				setName((String)newValue);
				return;
			case ClassdiagramsPackage.CLASS_DIAGRAM__CLASSES:
				getClasses().clear();
				getClasses().addAll((Collection<? extends ac.soton.eventb.classdiagrams.Class>)newValue);
				return;
			case ClassdiagramsPackage.CLASS_DIAGRAM__CLASS_ASSOCIATIONS:
				getClassAssociations().clear();
				getClassAssociations().addAll((Collection<? extends Association>)newValue);
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
			case ClassdiagramsPackage.CLASS_DIAGRAM__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case ClassdiagramsPackage.CLASS_DIAGRAM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ClassdiagramsPackage.CLASS_DIAGRAM__CLASSES:
				getClasses().clear();
				return;
			case ClassdiagramsPackage.CLASS_DIAGRAM__CLASS_ASSOCIATIONS:
				getClassAssociations().clear();
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
			case ClassdiagramsPackage.CLASS_DIAGRAM__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case ClassdiagramsPackage.CLASS_DIAGRAM__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case ClassdiagramsPackage.CLASS_DIAGRAM__CLASSES:
				return classes != null && !classes.isEmpty();
			case ClassdiagramsPackage.CLASS_DIAGRAM__CLASS_ASSOCIATIONS:
				return classAssociations != null && !classAssociations.isEmpty();
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
		if (baseClass == EventBCommented.class) {
			switch (derivedFeatureID) {
				case ClassdiagramsPackage.CLASS_DIAGRAM__COMMENT: return CorePackage.EVENT_BCOMMENTED__COMMENT;
				default: return -1;
			}
		}
		if (baseClass == EventBCommentedElement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == EventBNamed.class) {
			switch (derivedFeatureID) {
				case ClassdiagramsPackage.CLASS_DIAGRAM__NAME: return CorePackage.EVENT_BNAMED__NAME;
				default: return -1;
			}
		}
		if (baseClass == EventBNamedCommentedElement.class) {
			switch (derivedFeatureID) {
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
		if (baseClass == EventBCommented.class) {
			switch (baseFeatureID) {
				case CorePackage.EVENT_BCOMMENTED__COMMENT: return ClassdiagramsPackage.CLASS_DIAGRAM__COMMENT;
				default: return -1;
			}
		}
		if (baseClass == EventBCommentedElement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == EventBNamed.class) {
			switch (baseFeatureID) {
				case CorePackage.EVENT_BNAMED__NAME: return ClassdiagramsPackage.CLASS_DIAGRAM__NAME;
				default: return -1;
			}
		}
		if (baseClass == EventBNamedCommentedElement.class) {
			switch (baseFeatureID) {
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
		result.append(" (comment: ");
		result.append(comment);
		result.append(')');
		return result.toString();
	}

} //ClassDiagramImpl
