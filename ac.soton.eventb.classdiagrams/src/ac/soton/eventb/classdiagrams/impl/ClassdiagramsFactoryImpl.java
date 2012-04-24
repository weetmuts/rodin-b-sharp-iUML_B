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
import ac.soton.eventb.classdiagrams.Classdiagram;
import ac.soton.eventb.classdiagrams.ClassdiagramsFactory;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassdiagramsFactoryImpl extends EFactoryImpl implements ClassdiagramsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ClassdiagramsFactory init() {
		try {
			ClassdiagramsFactory theClassdiagramsFactory = (ClassdiagramsFactory)EPackage.Registry.INSTANCE.getEFactory("http://soton.ac.uk/models/eventb/classdiagrams"); 
			if (theClassdiagramsFactory != null) {
				return theClassdiagramsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ClassdiagramsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassdiagramsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ClassdiagramsPackage.CLASSDIAGRAM: return createClassdiagram();
			case ClassdiagramsPackage.ASSOCIATION: return createAssociation();
			case ClassdiagramsPackage.CLASS_ATTRIBUTE: return createClassAttribute();
			case ClassdiagramsPackage.CLASS_AXIOM: return createClassAxiom();
			case ClassdiagramsPackage.CLASS_INVARIANT: return createClassInvariant();
			case ClassdiagramsPackage.CLASS_EVENT: return createClassEvent();
			case ClassdiagramsPackage.CLASS: return createClass();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classdiagram createClassdiagram() {
		ClassdiagramImpl classdiagram = new ClassdiagramImpl();
		return classdiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Association createAssociation() {
		AssociationImpl association = new AssociationImpl();
		return association;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassAttribute createClassAttribute() {
		ClassAttributeImpl classAttribute = new ClassAttributeImpl();
		return classAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassAxiom createClassAxiom() {
		ClassAxiomImpl classAxiom = new ClassAxiomImpl();
		return classAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassInvariant createClassInvariant() {
		ClassInvariantImpl classInvariant = new ClassInvariantImpl();
		return classInvariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassEvent createClassEvent() {
		ClassEventImpl classEvent = new ClassEventImpl();
		return classEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ac.soton.eventb.classdiagrams.Class createClass() {
		ClassImpl class_ = new ClassImpl();
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassdiagramsPackage getClassdiagramsPackage() {
		return (ClassdiagramsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ClassdiagramsPackage getPackage() {
		return ClassdiagramsPackage.eINSTANCE;
	}

} //ClassdiagramsFactoryImpl
