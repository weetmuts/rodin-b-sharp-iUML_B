/**
 * Copyright (c) 2012 - University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eventb.emf.core.CorePackage;

import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ac.soton.eventb.classdiagrams.ClassdiagramsFactory
 * @model kind="package"
 * @generated
 */
public interface ClassdiagramsPackage extends EPackage {
	
	/**
	 * Classdiagrams extension ID, assigned to classdiagrams extensions to Event-B,
	 * as well as used by transformation to Event-B.
	 * @custom
	 */
	String CLASSDIAGRAMS_EXTENSION_ID = "ac.soton.eventb.classdiagrams";
	
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "classdiagrams";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://soton.ac.uk/models/eventb/classdiagrams/0313";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "classdiagrams";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ClassdiagramsPackage eINSTANCE = ac.soton.eventb.classdiagrams.impl.ClassdiagramsPackageImpl.init();

	/**
	 * The meta object id for the '{@link ac.soton.eventb.classdiagrams.impl.ClassdiagramOwnerImpl <em>Classdiagram Owner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.classdiagrams.impl.ClassdiagramOwnerImpl
	 * @see ac.soton.eventb.classdiagrams.impl.ClassdiagramsPackageImpl#getClassdiagramOwner()
	 * @generated
	 */
	int CLASSDIAGRAM_OWNER = 0;

	/**
	 * The feature id for the '<em><b>Classdiagrams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSDIAGRAM_OWNER__CLASSDIAGRAMS = 0;

	/**
	 * The number of structural features of the '<em>Classdiagram Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSDIAGRAM_OWNER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.classdiagrams.impl.ClassdiagramImpl <em>Classdiagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.classdiagrams.impl.ClassdiagramImpl
	 * @see ac.soton.eventb.classdiagrams.impl.ClassdiagramsPackageImpl#getClassdiagram()
	 * @generated
	 */
	int CLASSDIAGRAM = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSDIAGRAM__ANNOTATIONS = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSDIAGRAM__EXTENSIONS = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSDIAGRAM__ATTRIBUTES = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSDIAGRAM__REFERENCE = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSDIAGRAM__GENERATED = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSDIAGRAM__LOCAL_GENERATED = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSDIAGRAM__INTERNAL_ID = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSDIAGRAM__COMMENT = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSDIAGRAM__NAME = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSDIAGRAM__EXTENSION_ID = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSDIAGRAM__CLASSES = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Associations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSDIAGRAM__ASSOCIATIONS = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSDIAGRAM__REFINES = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Classdiagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSDIAGRAM_FEATURE_COUNT = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.classdiagrams.impl.AssociationImpl <em>Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.classdiagrams.impl.AssociationImpl
	 * @see ac.soton.eventb.classdiagrams.impl.ClassdiagramsPackageImpl#getAssociation()
	 * @generated
	 */
	int ASSOCIATION = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__ANNOTATIONS = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__EXTENSIONS = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__ATTRIBUTES = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__REFERENCE = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__GENERATED = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__LOCAL_GENERATED = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__INTERNAL_ID = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__COMMENT = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__NAME = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Elaborates</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__ELABORATES = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__ELABORATES;

	/**
	 * The feature id for the '<em><b>Data Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__DATA_KIND = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__DATA_KIND;

	/**
	 * The feature id for the '<em><b>Surjective</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__SURJECTIVE = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__SURJECTIVE;

	/**
	 * The feature id for the '<em><b>Injective</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__INJECTIVE = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__INJECTIVE;

	/**
	 * The feature id for the '<em><b>Total</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__TOTAL = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__TOTAL;

	/**
	 * The feature id for the '<em><b>Functional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__FUNCTIONAL = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__FUNCTIONAL;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__TARGET = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__SOURCE = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_FEATURE_COUNT = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.classdiagrams.impl.ClassAttributeImpl <em>Class Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.classdiagrams.impl.ClassAttributeImpl
	 * @see ac.soton.eventb.classdiagrams.impl.ClassdiagramsPackageImpl#getClassAttribute()
	 * @generated
	 */
	int CLASS_ATTRIBUTE = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ATTRIBUTE__ANNOTATIONS = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ATTRIBUTE__EXTENSIONS = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ATTRIBUTE__ATTRIBUTES = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ATTRIBUTE__REFERENCE = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ATTRIBUTE__GENERATED = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ATTRIBUTE__LOCAL_GENERATED = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ATTRIBUTE__INTERNAL_ID = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ATTRIBUTE__COMMENT = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ATTRIBUTE__NAME = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Elaborates</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ATTRIBUTE__ELABORATES = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__ELABORATES;

	/**
	 * The feature id for the '<em><b>Data Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ATTRIBUTE__DATA_KIND = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__DATA_KIND;

	/**
	 * The feature id for the '<em><b>Surjective</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ATTRIBUTE__SURJECTIVE = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__SURJECTIVE;

	/**
	 * The feature id for the '<em><b>Injective</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ATTRIBUTE__INJECTIVE = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__INJECTIVE;

	/**
	 * The feature id for the '<em><b>Total</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ATTRIBUTE__TOTAL = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__TOTAL;

	/**
	 * The feature id for the '<em><b>Functional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ATTRIBUTE__FUNCTIONAL = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT__FUNCTIONAL;

	/**
	 * The feature id for the '<em><b>Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ATTRIBUTE__TARGET = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Class Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ATTRIBUTE_FEATURE_COUNT = CoreextensionPackage.EVENT_BNAMED_COMMENTED_RELATION_DATA_ELABORATION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.classdiagrams.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.classdiagrams.impl.ClassImpl
	 * @see ac.soton.eventb.classdiagrams.impl.ClassdiagramsPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ANNOTATIONS = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__EXTENSIONS = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ATTRIBUTES = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__REFERENCE = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__GENERATED = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__LOCAL_GENERATED = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__INTERNAL_ID = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__COMMENT = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Elaborates</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ELABORATES = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT__ELABORATES;

	/**
	 * The feature id for the '<em><b>Data Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__DATA_KIND = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT__DATA_KIND;

	/**
	 * The feature id for the '<em><b>Diagrams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__DIAGRAMS = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Supertypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__SUPERTYPES = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Class Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__CLASS_ATTRIBUTES = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__INCOMING = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OUTGOING = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__REFINES = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__CONSTRAINTS = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__METHODS = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Self Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__SELF_NAME = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT_FEATURE_COUNT + 9;


	/**
	 * The meta object id for the '{@link ac.soton.eventb.classdiagrams.impl.ClassMethodImpl <em>Class Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.classdiagrams.impl.ClassMethodImpl
	 * @see ac.soton.eventb.classdiagrams.impl.ClassdiagramsPackageImpl#getClassMethod()
	 * @generated
	 */
	int CLASS_METHOD = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_METHOD__ANNOTATIONS = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_METHOD__EXTENSIONS = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_METHOD__ATTRIBUTES = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_METHOD__REFERENCE = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_METHOD__GENERATED = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_METHOD__LOCAL_GENERATED = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_METHOD__INTERNAL_ID = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_METHOD__COMMENT = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_METHOD__LABEL = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__LABEL;

	/**
	 * The feature id for the '<em><b>Elaborates</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_METHOD__ELABORATES = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__ELABORATES;

	/**
	 * The feature id for the '<em><b>Extended</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_METHOD__EXTENDED = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__EXTENDED;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_METHOD__PARAMETERS = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Guards</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_METHOD__GUARDS = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__GUARDS;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_METHOD__ACTIONS = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__ACTIONS;

	/**
	 * The feature id for the '<em><b>Witnesses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_METHOD__WITNESSES = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__WITNESSES;

	/**
	 * The number of structural features of the '<em>Class Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_METHOD_FEATURE_COUNT = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.classdiagrams.impl.ClassConstraintImpl <em>Class Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.classdiagrams.impl.ClassConstraintImpl
	 * @see ac.soton.eventb.classdiagrams.impl.ClassdiagramsPackageImpl#getClassConstraint()
	 * @generated
	 */
	int CLASS_CONSTRAINT = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONSTRAINT__ANNOTATIONS = CorePackage.EVENT_BNAMED_COMMENTED_DERIVED_PREDICATE_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONSTRAINT__EXTENSIONS = CorePackage.EVENT_BNAMED_COMMENTED_DERIVED_PREDICATE_ELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONSTRAINT__ATTRIBUTES = CorePackage.EVENT_BNAMED_COMMENTED_DERIVED_PREDICATE_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONSTRAINT__REFERENCE = CorePackage.EVENT_BNAMED_COMMENTED_DERIVED_PREDICATE_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONSTRAINT__GENERATED = CorePackage.EVENT_BNAMED_COMMENTED_DERIVED_PREDICATE_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONSTRAINT__LOCAL_GENERATED = CorePackage.EVENT_BNAMED_COMMENTED_DERIVED_PREDICATE_ELEMENT__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONSTRAINT__INTERNAL_ID = CorePackage.EVENT_BNAMED_COMMENTED_DERIVED_PREDICATE_ELEMENT__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONSTRAINT__COMMENT = CorePackage.EVENT_BNAMED_COMMENTED_DERIVED_PREDICATE_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONSTRAINT__NAME = CorePackage.EVENT_BNAMED_COMMENTED_DERIVED_PREDICATE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONSTRAINT__PREDICATE = CorePackage.EVENT_BNAMED_COMMENTED_DERIVED_PREDICATE_ELEMENT__PREDICATE;

	/**
	 * The feature id for the '<em><b>Theorem</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONSTRAINT__THEOREM = CorePackage.EVENT_BNAMED_COMMENTED_DERIVED_PREDICATE_ELEMENT__THEOREM;

	/**
	 * The number of structural features of the '<em>Class Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONSTRAINT_FEATURE_COUNT = CorePackage.EVENT_BNAMED_COMMENTED_DERIVED_PREDICATE_ELEMENT_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.classdiagrams.ClassdiagramOwner <em>Classdiagram Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classdiagram Owner</em>'.
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramOwner
	 * @generated
	 */
	EClass getClassdiagramOwner();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.eventb.classdiagrams.ClassdiagramOwner#getClassdiagrams <em>Classdiagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classdiagrams</em>'.
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramOwner#getClassdiagrams()
	 * @see #getClassdiagramOwner()
	 * @generated
	 */
	EReference getClassdiagramOwner_Classdiagrams();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.classdiagrams.Classdiagram <em>Classdiagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classdiagram</em>'.
	 * @see ac.soton.eventb.classdiagrams.Classdiagram
	 * @generated
	 */
	EClass getClassdiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.eventb.classdiagrams.Classdiagram#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see ac.soton.eventb.classdiagrams.Classdiagram#getClasses()
	 * @see #getClassdiagram()
	 * @generated
	 */
	EReference getClassdiagram_Classes();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.eventb.classdiagrams.Classdiagram#getAssociations <em>Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Associations</em>'.
	 * @see ac.soton.eventb.classdiagrams.Classdiagram#getAssociations()
	 * @see #getClassdiagram()
	 * @generated
	 */
	EReference getClassdiagram_Associations();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.eventb.classdiagrams.Classdiagram#getRefines <em>Refines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Refines</em>'.
	 * @see ac.soton.eventb.classdiagrams.Classdiagram#getRefines()
	 * @see #getClassdiagram()
	 * @generated
	 */
	EReference getClassdiagram_Refines();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.classdiagrams.Association <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association</em>'.
	 * @see ac.soton.eventb.classdiagrams.Association
	 * @generated
	 */
	EClass getAssociation();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.eventb.classdiagrams.Association#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see ac.soton.eventb.classdiagrams.Association#getTarget()
	 * @see #getAssociation()
	 * @generated
	 */
	EReference getAssociation_Target();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.eventb.classdiagrams.Association#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see ac.soton.eventb.classdiagrams.Association#getSource()
	 * @see #getAssociation()
	 * @generated
	 */
	EReference getAssociation_Source();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.classdiagrams.ClassAttribute <em>Class Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Attribute</em>'.
	 * @see ac.soton.eventb.classdiagrams.ClassAttribute
	 * @generated
	 */
	EClass getClassAttribute();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.eventb.classdiagrams.ClassAttribute#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target</em>'.
	 * @see ac.soton.eventb.classdiagrams.ClassAttribute#getTarget()
	 * @see #getClassAttribute()
	 * @generated
	 */
	EAttribute getClassAttribute_Target();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.classdiagrams.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see ac.soton.eventb.classdiagrams.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the reference list '{@link ac.soton.eventb.classdiagrams.Class#getSupertypes <em>Supertypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Supertypes</em>'.
	 * @see ac.soton.eventb.classdiagrams.Class#getSupertypes()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Supertypes();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.eventb.classdiagrams.Class#getClassAttributes <em>Class Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Class Attributes</em>'.
	 * @see ac.soton.eventb.classdiagrams.Class#getClassAttributes()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_ClassAttributes();

	/**
	 * Returns the meta object for the reference list '{@link ac.soton.eventb.classdiagrams.Class#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming</em>'.
	 * @see ac.soton.eventb.classdiagrams.Class#getIncoming()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Incoming();

	/**
	 * Returns the meta object for the reference list '{@link ac.soton.eventb.classdiagrams.Class#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing</em>'.
	 * @see ac.soton.eventb.classdiagrams.Class#getOutgoing()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Outgoing();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.eventb.classdiagrams.Class#getRefines <em>Refines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Refines</em>'.
	 * @see ac.soton.eventb.classdiagrams.Class#getRefines()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Refines();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.eventb.classdiagrams.Class#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see ac.soton.eventb.classdiagrams.Class#getConstraints()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Constraints();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.eventb.classdiagrams.Class#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Methods</em>'.
	 * @see ac.soton.eventb.classdiagrams.Class#getMethods()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Methods();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.eventb.classdiagrams.Class#getSelfName <em>Self Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Self Name</em>'.
	 * @see ac.soton.eventb.classdiagrams.Class#getSelfName()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_SelfName();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.classdiagrams.ClassMethod <em>Class Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Method</em>'.
	 * @see ac.soton.eventb.classdiagrams.ClassMethod
	 * @generated
	 */
	EClass getClassMethod();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.classdiagrams.ClassConstraint <em>Class Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Constraint</em>'.
	 * @see ac.soton.eventb.classdiagrams.ClassConstraint
	 * @generated
	 */
	EClass getClassConstraint();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ClassdiagramsFactory getClassdiagramsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link ac.soton.eventb.classdiagrams.impl.ClassdiagramOwnerImpl <em>Classdiagram Owner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.classdiagrams.impl.ClassdiagramOwnerImpl
		 * @see ac.soton.eventb.classdiagrams.impl.ClassdiagramsPackageImpl#getClassdiagramOwner()
		 * @generated
		 */
		EClass CLASSDIAGRAM_OWNER = eINSTANCE.getClassdiagramOwner();

		/**
		 * The meta object literal for the '<em><b>Classdiagrams</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSDIAGRAM_OWNER__CLASSDIAGRAMS = eINSTANCE.getClassdiagramOwner_Classdiagrams();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.classdiagrams.impl.ClassdiagramImpl <em>Classdiagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.classdiagrams.impl.ClassdiagramImpl
		 * @see ac.soton.eventb.classdiagrams.impl.ClassdiagramsPackageImpl#getClassdiagram()
		 * @generated
		 */
		EClass CLASSDIAGRAM = eINSTANCE.getClassdiagram();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSDIAGRAM__CLASSES = eINSTANCE.getClassdiagram_Classes();

		/**
		 * The meta object literal for the '<em><b>Associations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSDIAGRAM__ASSOCIATIONS = eINSTANCE.getClassdiagram_Associations();

		/**
		 * The meta object literal for the '<em><b>Refines</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSDIAGRAM__REFINES = eINSTANCE.getClassdiagram_Refines();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.classdiagrams.impl.AssociationImpl <em>Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.classdiagrams.impl.AssociationImpl
		 * @see ac.soton.eventb.classdiagrams.impl.ClassdiagramsPackageImpl#getAssociation()
		 * @generated
		 */
		EClass ASSOCIATION = eINSTANCE.getAssociation();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION__TARGET = eINSTANCE.getAssociation_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION__SOURCE = eINSTANCE.getAssociation_Source();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.classdiagrams.impl.ClassAttributeImpl <em>Class Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.classdiagrams.impl.ClassAttributeImpl
		 * @see ac.soton.eventb.classdiagrams.impl.ClassdiagramsPackageImpl#getClassAttribute()
		 * @generated
		 */
		EClass CLASS_ATTRIBUTE = eINSTANCE.getClassAttribute();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_ATTRIBUTE__TARGET = eINSTANCE.getClassAttribute_Target();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.classdiagrams.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.classdiagrams.impl.ClassImpl
		 * @see ac.soton.eventb.classdiagrams.impl.ClassdiagramsPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Supertypes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__SUPERTYPES = eINSTANCE.getClass_Supertypes();

		/**
		 * The meta object literal for the '<em><b>Class Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__CLASS_ATTRIBUTES = eINSTANCE.getClass_ClassAttributes();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__INCOMING = eINSTANCE.getClass_Incoming();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__OUTGOING = eINSTANCE.getClass_Outgoing();

		/**
		 * The meta object literal for the '<em><b>Refines</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__REFINES = eINSTANCE.getClass_Refines();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__CONSTRAINTS = eINSTANCE.getClass_Constraints();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__METHODS = eINSTANCE.getClass_Methods();

		/**
		 * The meta object literal for the '<em><b>Self Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__SELF_NAME = eINSTANCE.getClass_SelfName();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.classdiagrams.impl.ClassMethodImpl <em>Class Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.classdiagrams.impl.ClassMethodImpl
		 * @see ac.soton.eventb.classdiagrams.impl.ClassdiagramsPackageImpl#getClassMethod()
		 * @generated
		 */
		EClass CLASS_METHOD = eINSTANCE.getClassMethod();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.classdiagrams.impl.ClassConstraintImpl <em>Class Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.classdiagrams.impl.ClassConstraintImpl
		 * @see ac.soton.eventb.classdiagrams.impl.ClassdiagramsPackageImpl#getClassConstraint()
		 * @generated
		 */
		EClass CLASS_CONSTRAINT = eINSTANCE.getClassConstraint();

	}

} //ClassdiagramsPackage
