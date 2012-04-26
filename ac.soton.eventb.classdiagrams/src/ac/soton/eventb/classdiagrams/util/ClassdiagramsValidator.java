/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams.util;

import ac.soton.eventb.classdiagrams.AbstractClassiagramElement;
import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.classdiagrams.ClassAxiom;
import ac.soton.eventb.classdiagrams.ClassEvent;
import ac.soton.eventb.classdiagrams.ClassInvariant;
import ac.soton.eventb.classdiagrams.Classdiagram;
import ac.soton.eventb.classdiagrams.ClassdiagramOwner;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage
 * @generated
 */
public class ClassdiagramsValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ClassdiagramsValidator INSTANCE = new ClassdiagramsValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "ac.soton.eventb.classdiagrams";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassdiagramsValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return ClassdiagramsPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case ClassdiagramsPackage.CLASSDIAGRAM_OWNER:
				return validateClassdiagramOwner((ClassdiagramOwner)value, diagnostics, context);
			case ClassdiagramsPackage.CLASSDIAGRAM:
				return validateClassdiagram((Classdiagram)value, diagnostics, context);
			case ClassdiagramsPackage.ASSOCIATION:
				return validateAssociation((Association)value, diagnostics, context);
			case ClassdiagramsPackage.CLASS_ATTRIBUTE:
				return validateClassAttribute((ClassAttribute)value, diagnostics, context);
			case ClassdiagramsPackage.CLASS_AXIOM:
				return validateClassAxiom((ClassAxiom)value, diagnostics, context);
			case ClassdiagramsPackage.CLASS_INVARIANT:
				return validateClassInvariant((ClassInvariant)value, diagnostics, context);
			case ClassdiagramsPackage.CLASS_EVENT:
				return validateClassEvent((ClassEvent)value, diagnostics, context);
			case ClassdiagramsPackage.CLASS:
				return validateClass((ac.soton.eventb.classdiagrams.Class)value, diagnostics, context);
			case ClassdiagramsPackage.ABSTRACT_CLASSIAGRAM_ELEMENT:
				return validateAbstractClassiagramElement((AbstractClassiagramElement)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassdiagramOwner(ClassdiagramOwner classdiagramOwner, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(classdiagramOwner, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassdiagram(Classdiagram classdiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(classdiagram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssociation(Association association, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_NoCircularContainment(association, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMultiplicityConforms(association, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(association, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(association, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(association, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(association, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(association, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(association, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(association, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssociation_isAsociationTypeRight(association, diagnostics, context);
		return result;
	}

	/**
	 * Validates the isAsociationTypeRight constraint of '<em>Association</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssociation_isAsociationTypeRight(Association association, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "isAsociationTypeRight", getObjectLabel(association, context) },
						 new Object[] { association },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassAttribute(ClassAttribute classAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(classAttribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassAxiom(ClassAxiom classAxiom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_NoCircularContainment(classAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMultiplicityConforms(classAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(classAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(classAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(classAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(classAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(classAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(classAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(classAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassAxiom_parentIsConstant(classAxiom, diagnostics, context);
		return result;
	}

	/**
	 * Validates the parentIsConstant constraint of '<em>Class Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassAxiom_parentIsConstant(ClassAxiom classAxiom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "parentIsConstant", getObjectLabel(classAxiom, context) },
						 new Object[] { classAxiom },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassInvariant(ClassInvariant classInvariant, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_NoCircularContainment(classInvariant, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMultiplicityConforms(classInvariant, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(classInvariant, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(classInvariant, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(classInvariant, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(classInvariant, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(classInvariant, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(classInvariant, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(classInvariant, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassInvariant_parentIsNotConstant(classInvariant, diagnostics, context);
		return result;
	}

	/**
	 * Validates the parentIsNotConstant constraint of '<em>Class Invariant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassInvariant_parentIsNotConstant(ClassInvariant classInvariant, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "parentIsNotConstant", getObjectLabel(classInvariant, context) },
						 new Object[] { classInvariant },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassEvent(ClassEvent classEvent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_NoCircularContainment(classEvent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMultiplicityConforms(classEvent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(classEvent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(classEvent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(classEvent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(classEvent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(classEvent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(classEvent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(classEvent, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassEvent_parentIsNotConstant(classEvent, diagnostics, context);
		return result;
	}

	/**
	 * Validates the parentIsNotConstant constraint of '<em>Class Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassEvent_parentIsNotConstant(ClassEvent classEvent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "parentIsNotConstant", getObjectLabel(classEvent, context) },
						 new Object[] { classEvent },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClass(ac.soton.eventb.classdiagrams.Class class_, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(class_, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractClassiagramElement(AbstractClassiagramElement abstractClassiagramElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(abstractClassiagramElement, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //ClassdiagramsValidator
