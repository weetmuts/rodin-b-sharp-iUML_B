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
import ac.soton.eventb.classdiagrams.ClassdiagramOwner;
import ac.soton.eventb.classdiagrams.ClassdiagramsFactory;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.util.ClassdiagramsValidator;
import ac.soton.eventb.emf.diagrams.DiagramsPackage;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eventb.emf.core.CorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassdiagramsPackageImpl extends EPackageImpl implements ClassdiagramsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classdiagramOwnerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classdiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classInvariantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ClassdiagramsPackageImpl() {
		super(eNS_URI, ClassdiagramsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ClassdiagramsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ClassdiagramsPackage init() {
		if (isInited) return (ClassdiagramsPackage)EPackage.Registry.INSTANCE.getEPackage(ClassdiagramsPackage.eNS_URI);

		// Obtain or create and register package
		ClassdiagramsPackageImpl theClassdiagramsPackage = (ClassdiagramsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ClassdiagramsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ClassdiagramsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DiagramsPackage.eINSTANCE.eClass();
		CorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theClassdiagramsPackage.createPackageContents();

		// Initialize created meta-data
		theClassdiagramsPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theClassdiagramsPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return ClassdiagramsValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theClassdiagramsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ClassdiagramsPackage.eNS_URI, theClassdiagramsPackage);
		return theClassdiagramsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassdiagramOwner() {
		return classdiagramOwnerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassdiagramOwner_Classdiagrams() {
		return (EReference)classdiagramOwnerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassdiagram() {
		return classdiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassdiagram_Classes() {
		return (EReference)classdiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassdiagram_ClassAssociations() {
		return (EReference)classdiagramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociation() {
		return associationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociation_Target() {
		return (EReference)associationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociation_Source() {
		return (EReference)associationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssociation_Constant() {
		return (EAttribute)associationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssociation_Surjective() {
		return (EAttribute)associationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssociation_Injective() {
		return (EAttribute)associationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssociation_Total() {
		return (EAttribute)associationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssociation_Functional() {
		return (EAttribute)associationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassAttribute() {
		return classAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassAxiom() {
		return classAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassInvariant() {
		return classInvariantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassEvent() {
		return classEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClass_() {
		return classEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Supertypes() {
		return (EReference)classEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_ClassAttributes() {
		return (EReference)classEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_ClassInvariants() {
		return (EReference)classEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_ClassAxioms() {
		return (EReference)classEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Extends() {
		return (EReference)classEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Incoming() {
		return (EReference)classEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Outgoing() {
		return (EReference)classEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClass_Constant() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClass_TargetFile() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Refines() {
		return (EReference)classEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_ClassEvents() {
		return (EReference)classEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClass_Instance() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassdiagramsFactory getClassdiagramsFactory() {
		return (ClassdiagramsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		classdiagramOwnerEClass = createEClass(CLASSDIAGRAM_OWNER);
		createEReference(classdiagramOwnerEClass, CLASSDIAGRAM_OWNER__CLASSDIAGRAMS);

		classdiagramEClass = createEClass(CLASSDIAGRAM);
		createEReference(classdiagramEClass, CLASSDIAGRAM__CLASSES);
		createEReference(classdiagramEClass, CLASSDIAGRAM__CLASS_ASSOCIATIONS);

		associationEClass = createEClass(ASSOCIATION);
		createEReference(associationEClass, ASSOCIATION__TARGET);
		createEReference(associationEClass, ASSOCIATION__SOURCE);
		createEAttribute(associationEClass, ASSOCIATION__CONSTANT);
		createEAttribute(associationEClass, ASSOCIATION__SURJECTIVE);
		createEAttribute(associationEClass, ASSOCIATION__INJECTIVE);
		createEAttribute(associationEClass, ASSOCIATION__TOTAL);
		createEAttribute(associationEClass, ASSOCIATION__FUNCTIONAL);

		classAttributeEClass = createEClass(CLASS_ATTRIBUTE);

		classAxiomEClass = createEClass(CLASS_AXIOM);

		classInvariantEClass = createEClass(CLASS_INVARIANT);

		classEventEClass = createEClass(CLASS_EVENT);

		classEClass = createEClass(CLASS);
		createEReference(classEClass, CLASS__SUPERTYPES);
		createEReference(classEClass, CLASS__CLASS_ATTRIBUTES);
		createEReference(classEClass, CLASS__CLASS_INVARIANTS);
		createEReference(classEClass, CLASS__CLASS_AXIOMS);
		createEReference(classEClass, CLASS__EXTENDS);
		createEReference(classEClass, CLASS__INCOMING);
		createEReference(classEClass, CLASS__OUTGOING);
		createEAttribute(classEClass, CLASS__CONSTANT);
		createEAttribute(classEClass, CLASS__TARGET_FILE);
		createEReference(classEClass, CLASS__REFINES);
		createEReference(classEClass, CLASS__CLASS_EVENTS);
		createEAttribute(classEClass, CLASS__INSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		DiagramsPackage theDiagramsPackage = (DiagramsPackage)EPackage.Registry.INSTANCE.getEPackage(DiagramsPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		classdiagramEClass.getESuperTypes().add(theCorePackage.getEventBNamedCommentedElement());
		classdiagramEClass.getESuperTypes().add(theCorePackage.getAbstractExtension());
		classdiagramEClass.getESuperTypes().add(theDiagramsPackage.getDiagram());
		associationEClass.getESuperTypes().add(theCorePackage.getEventBNamedCommentedElement());
		classAttributeEClass.getESuperTypes().add(theCorePackage.getEventBNamedCommentedElement());
		classAxiomEClass.getESuperTypes().add(theCorePackage.getEventBNamedCommentedDerivedPredicateElement());
		classInvariantEClass.getESuperTypes().add(theCorePackage.getEventBNamedCommentedDerivedPredicateElement());
		classEventEClass.getESuperTypes().add(theCorePackage.getEventBNamedCommentedElement());
		classEClass.getESuperTypes().add(theCorePackage.getEventBNamedCommentedElement());

		// Initialize classes and features; add operations and parameters
		initEClass(classdiagramOwnerEClass, ClassdiagramOwner.class, "ClassdiagramOwner", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassdiagramOwner_Classdiagrams(), this.getClassdiagram(), null, "classdiagrams", null, 0, -1, ClassdiagramOwner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classdiagramEClass, Classdiagram.class, "Classdiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassdiagram_Classes(), this.getClass_(), null, "classes", null, 0, -1, Classdiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassdiagram_ClassAssociations(), this.getAssociation(), null, "classAssociations", null, 0, -1, Classdiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(associationEClass, Association.class, "Association", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssociation_Target(), this.getClass_(), this.getClass_Incoming(), "target", null, 1, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssociation_Source(), this.getClass_(), this.getClass_Outgoing(), "source", null, 1, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssociation_Constant(), ecorePackage.getEBoolean(), "constant", "false", 0, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssociation_Surjective(), ecorePackage.getEBoolean(), "surjective", "false", 1, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssociation_Injective(), ecorePackage.getEBoolean(), "injective", "false", 1, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssociation_Total(), ecorePackage.getEBoolean(), "total", "false", 1, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssociation_Functional(), ecorePackage.getEBoolean(), "functional", "false", 1, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classAttributeEClass, ClassAttribute.class, "ClassAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classAxiomEClass, ClassAxiom.class, "ClassAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classInvariantEClass, ClassInvariant.class, "ClassInvariant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classEventEClass, ClassEvent.class, "ClassEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classEClass, ac.soton.eventb.classdiagrams.Class.class, "Class", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClass_Supertypes(), this.getClass_(), null, "supertypes", null, 0, -1, ac.soton.eventb.classdiagrams.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_ClassAttributes(), this.getClassAttribute(), null, "classAttributes", null, 0, -1, ac.soton.eventb.classdiagrams.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_ClassInvariants(), this.getClassInvariant(), null, "classInvariants", null, 0, -1, ac.soton.eventb.classdiagrams.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_ClassAxioms(), this.getClassAxiom(), null, "classAxioms", null, 0, -1, ac.soton.eventb.classdiagrams.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_Extends(), this.getClass_(), null, "extends", null, 0, 1, ac.soton.eventb.classdiagrams.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_Incoming(), this.getAssociation(), this.getAssociation_Target(), "incoming", null, 0, -1, ac.soton.eventb.classdiagrams.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_Outgoing(), this.getAssociation(), this.getAssociation_Source(), "outgoing", null, 0, -1, ac.soton.eventb.classdiagrams.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClass_Constant(), ecorePackage.getEBoolean(), "constant", "false", 0, 1, ac.soton.eventb.classdiagrams.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(theEcorePackage.getEEList());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEAttribute(getClass_TargetFile(), g1, "targetFile", "none", 0, 1, ac.soton.eventb.classdiagrams.Class.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_Refines(), this.getClass_(), null, "refines", null, 0, -1, ac.soton.eventb.classdiagrams.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_ClassEvents(), this.getClassEvent(), null, "classEvents", null, 0, -1, ac.soton.eventb.classdiagrams.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClass_Instance(), ecorePackage.getEString(), "instance", null, 0, 1, ac.soton.eventb.classdiagrams.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// org.eventb.emf.core.extendedMetaClasses
		createOrgAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
	}

	/**
	 * Initializes the annotations for <b>org.eventb.emf.core.extendedMetaClasses</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOrgAnnotations() {
		String source = "org.eventb.emf.core.extendedMetaClasses";		
		addAnnotation
		  (classdiagramEClass, 
		   source, 
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(CorePackage.eNS_URI).appendFragment("//machine/Machine")
		   });						
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";			
		addAnnotation
		  (associationEClass, 
		   source, 
		   new String[] {
			 "constraints", "isAsociationTypeRight"
		   });		
		addAnnotation
		  (classAxiomEClass, 
		   source, 
		   new String[] {
			 "constraints", "parentIsConstant\n"
		   });		
		addAnnotation
		  (classInvariantEClass, 
		   source, 
		   new String[] {
			 "constraints", "parentIsNotConstant"
		   });		
		addAnnotation
		  (classEventEClass, 
		   source, 
		   new String[] {
			 "constraints", "parentIsNotConstant"
		   });		
		addAnnotation
		  (getClass_Extends(), 
		   source, 
		   new String[] {
			 "constraints", "parentIsConstant\n"
		   });		
		addAnnotation
		  (getClass_Refines(), 
		   source, 
		   new String[] {
			 "constraints", "parentIsNotConstant"
		   });
	}

} //ClassdiagramsPackageImpl
