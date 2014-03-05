/**
 * Copyright (c) 2010
 * University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package ac.soton.eventb.statemachines;

import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eventb.emf.core.CorePackage;

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
 * @see ac.soton.eventb.statemachines.StatemachinesFactory
 * @model kind="package"
 * @generated
 */
public interface StatemachinesPackage extends EPackage {
	/**
	 * Statemachines extension ID, assigned to statemachines extensions to Event-B,
	 * as well as used by transformation to Event-B.
	 */
	String STATEMACHINES_EXTENSION_ID = "ac.soton.eventb.statemachines";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2010-2013\rUniversity of Southampton.\rAll rights reserved. This program and the accompanying materials  are made\ravailable under the terms of the Eclipse Public License v1.0 which accompanies this \rdistribution, and is available at http://www.eclipse.org/legal/epl-v10.html\n";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "statemachines";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://soton.ac.uk/models/eventb/statemachines/2014";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "statemachines";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StatemachinesPackage eINSTANCE = ac.soton.eventb.statemachines.impl.StatemachinesPackageImpl.init();

	/**
	 * The meta object id for the '{@link ac.soton.eventb.statemachines.impl.AbstractNodeImpl <em>Abstract Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.statemachines.impl.AbstractNodeImpl
	 * @see ac.soton.eventb.statemachines.impl.StatemachinesPackageImpl#getAbstractNode()
	 * @generated
	 */
	int ABSTRACT_NODE = 3;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.statemachines.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.statemachines.impl.TransitionImpl
	 * @see ac.soton.eventb.statemachines.impl.StatemachinesPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 2;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.statemachines.impl.StatemachineImpl <em>Statemachine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.statemachines.impl.StatemachineImpl
	 * @see ac.soton.eventb.statemachines.impl.StatemachinesPackageImpl#getStatemachine()
	 * @generated
	 */
	int STATEMACHINE = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMACHINE__ANNOTATIONS = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMACHINE__EXTENSIONS = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMACHINE__ATTRIBUTES = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMACHINE__REFERENCE = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMACHINE__GENERATED = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMACHINE__LOCAL_GENERATED = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMACHINE__INTERNAL_ID = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMACHINE__COMMENT = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMACHINE__NAME = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Elaborates</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMACHINE__ELABORATES = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT__ELABORATES;

	/**
	 * The feature id for the '<em><b>Data Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMACHINE__DATA_KIND = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT__DATA_KIND;

	/**
	 * The feature id for the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMACHINE__EXTENSION_ID = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMACHINE__REFINES = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMACHINE__NODES = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMACHINE__TRANSITIONS = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMACHINE__INSTANCES = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Self Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMACHINE__SELF_NAME = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Translation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMACHINE__TRANSLATION = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Statemachine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMACHINE_FEATURE_COUNT = CoreextensionPackage.EVENT_BNAMED_COMMENTED_DATA_ELABORATION_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.statemachines.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.statemachines.impl.StateImpl
	 * @see ac.soton.eventb.statemachines.impl.StatemachinesPackageImpl#getState()
	 * @generated
	 */
	int STATE = 4;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.statemachines.impl.InitialImpl <em>Initial</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.statemachines.impl.InitialImpl
	 * @see ac.soton.eventb.statemachines.impl.StatemachinesPackageImpl#getInitial()
	 * @generated
	 */
	int INITIAL = 5;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.statemachines.impl.FinalImpl <em>Final</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.statemachines.impl.FinalImpl
	 * @see ac.soton.eventb.statemachines.impl.StatemachinesPackageImpl#getFinal()
	 * @generated
	 */
	int FINAL = 6;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.statemachines.impl.StatemachineOwnerImpl <em>Statemachine Owner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.statemachines.impl.StatemachineOwnerImpl
	 * @see ac.soton.eventb.statemachines.impl.StatemachinesPackageImpl#getStatemachineOwner()
	 * @generated
	 */
	int STATEMACHINE_OWNER = 1;

	/**
	 * The feature id for the '<em><b>Statemachines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMACHINE_OWNER__STATEMACHINES = 0;

	/**
	 * The number of structural features of the '<em>Statemachine Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMACHINE_OWNER_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__ANNOTATIONS = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__EXTENSIONS = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__ATTRIBUTES = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__REFERENCE = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__GENERATED = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__LOCAL_GENERATED = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__INTERNAL_ID = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__COMMENT = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__LABEL = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__LABEL;

	/**
	 * The feature id for the '<em><b>Elaborates</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__ELABORATES = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__ELABORATES;

	/**
	 * The feature id for the '<em><b>Extended</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__EXTENDED = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__EXTENDED;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__PARAMETERS = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Guards</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__GUARDS = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__GUARDS;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__ACTIONS = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__ACTIONS;

	/**
	 * The feature id for the '<em><b>Witnesses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__WITNESSES = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT__WITNESSES;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TARGET = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__SOURCE = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__SOURCE_CONTAINER = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TARGET_CONTAINER = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__OPERATIONS = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = CoreextensionPackage.EVENT_BCOMMENTED_LABELED_EVENT_GROUP_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NODE__ANNOTATIONS = CorePackage.EVENT_BELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NODE__EXTENSIONS = CorePackage.EVENT_BELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NODE__ATTRIBUTES = CorePackage.EVENT_BELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NODE__REFERENCE = CorePackage.EVENT_BELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NODE__GENERATED = CorePackage.EVENT_BELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NODE__LOCAL_GENERATED = CorePackage.EVENT_BELEMENT__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NODE__INTERNAL_ID = CorePackage.EVENT_BELEMENT__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NODE__INCOMING = CorePackage.EVENT_BELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NODE__OUTGOING = CorePackage.EVENT_BELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NODE_FEATURE_COUNT = CorePackage.EVENT_BELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__ANNOTATIONS = ABSTRACT_NODE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__EXTENSIONS = ABSTRACT_NODE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__ATTRIBUTES = ABSTRACT_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__REFERENCE = ABSTRACT_NODE__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__GENERATED = ABSTRACT_NODE__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__LOCAL_GENERATED = ABSTRACT_NODE__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__INTERNAL_ID = ABSTRACT_NODE__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__INCOMING = ABSTRACT_NODE__INCOMING;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OUTGOING = ABSTRACT_NODE__OUTGOING;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = ABSTRACT_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Statemachines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__STATEMACHINES = ABSTRACT_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__REFINES = ABSTRACT_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Invariants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__INVARIANTS = ABSTRACT_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__ACTIVE = ABSTRACT_NODE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = ABSTRACT_NODE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL__ANNOTATIONS = ABSTRACT_NODE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL__EXTENSIONS = ABSTRACT_NODE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL__ATTRIBUTES = ABSTRACT_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL__REFERENCE = ABSTRACT_NODE__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL__GENERATED = ABSTRACT_NODE__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL__LOCAL_GENERATED = ABSTRACT_NODE__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL__INTERNAL_ID = ABSTRACT_NODE__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL__INCOMING = ABSTRACT_NODE__INCOMING;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL__OUTGOING = ABSTRACT_NODE__OUTGOING;

	/**
	 * The number of structural features of the '<em>Initial</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_FEATURE_COUNT = ABSTRACT_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL__ANNOTATIONS = ABSTRACT_NODE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL__EXTENSIONS = ABSTRACT_NODE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL__ATTRIBUTES = ABSTRACT_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL__REFERENCE = ABSTRACT_NODE__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL__GENERATED = ABSTRACT_NODE__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL__LOCAL_GENERATED = ABSTRACT_NODE__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL__INTERNAL_ID = ABSTRACT_NODE__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL__INCOMING = ABSTRACT_NODE__INCOMING;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL__OUTGOING = ABSTRACT_NODE__OUTGOING;

	/**
	 * The number of structural features of the '<em>Final</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_FEATURE_COUNT = ABSTRACT_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.statemachines.impl.AnyImpl <em>Any</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.statemachines.impl.AnyImpl
	 * @see ac.soton.eventb.statemachines.impl.StatemachinesPackageImpl#getAny()
	 * @generated
	 */
	int ANY = 7;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY__ANNOTATIONS = ABSTRACT_NODE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY__EXTENSIONS = ABSTRACT_NODE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY__ATTRIBUTES = ABSTRACT_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY__REFERENCE = ABSTRACT_NODE__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY__GENERATED = ABSTRACT_NODE__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY__LOCAL_GENERATED = ABSTRACT_NODE__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY__INTERNAL_ID = ABSTRACT_NODE__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY__INCOMING = ABSTRACT_NODE__INCOMING;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY__OUTGOING = ABSTRACT_NODE__OUTGOING;

	/**
	 * The number of structural features of the '<em>Any</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_FEATURE_COUNT = ABSTRACT_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.statemachines.impl.JunctionImpl <em>Junction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.statemachines.impl.JunctionImpl
	 * @see ac.soton.eventb.statemachines.impl.StatemachinesPackageImpl#getJunction()
	 * @generated
	 */
	int JUNCTION = 8;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__ANNOTATIONS = ABSTRACT_NODE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__EXTENSIONS = ABSTRACT_NODE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__ATTRIBUTES = ABSTRACT_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__REFERENCE = ABSTRACT_NODE__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__GENERATED = ABSTRACT_NODE__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__LOCAL_GENERATED = ABSTRACT_NODE__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__INTERNAL_ID = ABSTRACT_NODE__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__INCOMING = ABSTRACT_NODE__INCOMING;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__OUTGOING = ABSTRACT_NODE__OUTGOING;

	/**
	 * The number of structural features of the '<em>Junction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION_FEATURE_COUNT = ABSTRACT_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.statemachines.impl.ForkImpl <em>Fork</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.statemachines.impl.ForkImpl
	 * @see ac.soton.eventb.statemachines.impl.StatemachinesPackageImpl#getFork()
	 * @generated
	 */
	int FORK = 9;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK__ANNOTATIONS = ABSTRACT_NODE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK__EXTENSIONS = ABSTRACT_NODE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK__ATTRIBUTES = ABSTRACT_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK__REFERENCE = ABSTRACT_NODE__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK__GENERATED = ABSTRACT_NODE__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK__LOCAL_GENERATED = ABSTRACT_NODE__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK__INTERNAL_ID = ABSTRACT_NODE__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK__INCOMING = ABSTRACT_NODE__INCOMING;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK__OUTGOING = ABSTRACT_NODE__OUTGOING;

	/**
	 * The number of structural features of the '<em>Fork</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_FEATURE_COUNT = ABSTRACT_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.statemachines.TranslationKind <em>Translation Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.statemachines.TranslationKind
	 * @see ac.soton.eventb.statemachines.impl.StatemachinesPackageImpl#getTranslationKind()
	 * @generated
	 */
	int TRANSLATION_KIND = 10;


	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.statemachines.AbstractNode <em>Abstract Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Node</em>'.
	 * @see ac.soton.eventb.statemachines.AbstractNode
	 * @generated
	 */
	EClass getAbstractNode();

	/**
	 * Returns the meta object for the reference list '{@link ac.soton.eventb.statemachines.AbstractNode#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming</em>'.
	 * @see ac.soton.eventb.statemachines.AbstractNode#getIncoming()
	 * @see #getAbstractNode()
	 * @generated
	 */
	EReference getAbstractNode_Incoming();

	/**
	 * Returns the meta object for the reference list '{@link ac.soton.eventb.statemachines.AbstractNode#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing</em>'.
	 * @see ac.soton.eventb.statemachines.AbstractNode#getOutgoing()
	 * @see #getAbstractNode()
	 * @generated
	 */
	EReference getAbstractNode_Outgoing();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.statemachines.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see ac.soton.eventb.statemachines.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.eventb.statemachines.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see ac.soton.eventb.statemachines.Transition#getTarget()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Target();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.eventb.statemachines.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see ac.soton.eventb.statemachines.Transition#getSource()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Source();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.eventb.statemachines.Transition#getSourceContainer <em>Source Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Container</em>'.
	 * @see ac.soton.eventb.statemachines.Transition#getSourceContainer()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_SourceContainer();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.eventb.statemachines.Transition#getTargetContainer <em>Target Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Container</em>'.
	 * @see ac.soton.eventb.statemachines.Transition#getTargetContainer()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_TargetContainer();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.eventb.statemachines.Transition#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operations</em>'.
	 * @see ac.soton.eventb.statemachines.Transition#getOperations()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Operations();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.statemachines.Statemachine <em>Statemachine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statemachine</em>'.
	 * @see ac.soton.eventb.statemachines.Statemachine
	 * @generated
	 */
	EClass getStatemachine();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.eventb.statemachines.Statemachine#getTranslation <em>Translation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Translation</em>'.
	 * @see ac.soton.eventb.statemachines.Statemachine#getTranslation()
	 * @see #getStatemachine()
	 * @generated
	 */
	EAttribute getStatemachine_Translation();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.eventb.statemachines.Statemachine#getRefines <em>Refines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Refines</em>'.
	 * @see ac.soton.eventb.statemachines.Statemachine#getRefines()
	 * @see #getStatemachine()
	 * @generated
	 */
	EReference getStatemachine_Refines();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.eventb.statemachines.Statemachine#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see ac.soton.eventb.statemachines.Statemachine#getNodes()
	 * @see #getStatemachine()
	 * @generated
	 */
	EReference getStatemachine_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.eventb.statemachines.Statemachine#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see ac.soton.eventb.statemachines.Statemachine#getTransitions()
	 * @see #getStatemachine()
	 * @generated
	 */
	EReference getStatemachine_Transitions();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.eventb.statemachines.Statemachine#getInstances <em>Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instances</em>'.
	 * @see ac.soton.eventb.statemachines.Statemachine#getInstances()
	 * @see #getStatemachine()
	 * @generated
	 */
	EReference getStatemachine_Instances();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.eventb.statemachines.Statemachine#getSelfName <em>Self Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Self Name</em>'.
	 * @see ac.soton.eventb.statemachines.Statemachine#getSelfName()
	 * @see #getStatemachine()
	 * @generated
	 */
	EAttribute getStatemachine_SelfName();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.statemachines.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see ac.soton.eventb.statemachines.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.eventb.statemachines.State#getRefines <em>Refines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Refines</em>'.
	 * @see ac.soton.eventb.statemachines.State#getRefines()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Refines();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.eventb.statemachines.State#getInvariants <em>Invariants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Invariants</em>'.
	 * @see ac.soton.eventb.statemachines.State#getInvariants()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Invariants();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.eventb.statemachines.State#isActive <em>Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active</em>'.
	 * @see ac.soton.eventb.statemachines.State#isActive()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Active();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.statemachines.Initial <em>Initial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Initial</em>'.
	 * @see ac.soton.eventb.statemachines.Initial
	 * @generated
	 */
	EClass getInitial();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.statemachines.Final <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Final</em>'.
	 * @see ac.soton.eventb.statemachines.Final
	 * @generated
	 */
	EClass getFinal();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.statemachines.Any <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Any</em>'.
	 * @see ac.soton.eventb.statemachines.Any
	 * @generated
	 */
	EClass getAny();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.statemachines.Junction <em>Junction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Junction</em>'.
	 * @see ac.soton.eventb.statemachines.Junction
	 * @generated
	 */
	EClass getJunction();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.statemachines.Fork <em>Fork</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fork</em>'.
	 * @see ac.soton.eventb.statemachines.Fork
	 * @generated
	 */
	EClass getFork();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.statemachines.StatemachineOwner <em>Statemachine Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statemachine Owner</em>'.
	 * @see ac.soton.eventb.statemachines.StatemachineOwner
	 * @generated
	 */
	EClass getStatemachineOwner();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.eventb.statemachines.StatemachineOwner#getStatemachines <em>Statemachines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statemachines</em>'.
	 * @see ac.soton.eventb.statemachines.StatemachineOwner#getStatemachines()
	 * @see #getStatemachineOwner()
	 * @generated
	 */
	EReference getStatemachineOwner_Statemachines();

	/**
	 * Returns the meta object for enum '{@link ac.soton.eventb.statemachines.TranslationKind <em>Translation Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Translation Kind</em>'.
	 * @see ac.soton.eventb.statemachines.TranslationKind
	 * @generated
	 */
	EEnum getTranslationKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StatemachinesFactory getStatemachinesFactory();

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
		 * The meta object literal for the '{@link ac.soton.eventb.statemachines.impl.AbstractNodeImpl <em>Abstract Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.statemachines.impl.AbstractNodeImpl
		 * @see ac.soton.eventb.statemachines.impl.StatemachinesPackageImpl#getAbstractNode()
		 * @generated
		 */
		EClass ABSTRACT_NODE = eINSTANCE.getAbstractNode();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_NODE__INCOMING = eINSTANCE.getAbstractNode_Incoming();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_NODE__OUTGOING = eINSTANCE.getAbstractNode_Outgoing();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.statemachines.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.statemachines.impl.TransitionImpl
		 * @see ac.soton.eventb.statemachines.impl.StatemachinesPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TARGET = eINSTANCE.getTransition_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__SOURCE = eINSTANCE.getTransition_Source();

		/**
		 * The meta object literal for the '<em><b>Source Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__SOURCE_CONTAINER = eINSTANCE.getTransition_SourceContainer();

		/**
		 * The meta object literal for the '<em><b>Target Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TARGET_CONTAINER = eINSTANCE.getTransition_TargetContainer();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__OPERATIONS = eINSTANCE.getTransition_Operations();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.statemachines.impl.StatemachineImpl <em>Statemachine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.statemachines.impl.StatemachineImpl
		 * @see ac.soton.eventb.statemachines.impl.StatemachinesPackageImpl#getStatemachine()
		 * @generated
		 */
		EClass STATEMACHINE = eINSTANCE.getStatemachine();

		/**
		 * The meta object literal for the '<em><b>Translation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATEMACHINE__TRANSLATION = eINSTANCE.getStatemachine_Translation();

		/**
		 * The meta object literal for the '<em><b>Refines</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATEMACHINE__REFINES = eINSTANCE.getStatemachine_Refines();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATEMACHINE__NODES = eINSTANCE.getStatemachine_Nodes();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATEMACHINE__TRANSITIONS = eINSTANCE.getStatemachine_Transitions();

		/**
		 * The meta object literal for the '<em><b>Instances</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATEMACHINE__INSTANCES = eINSTANCE.getStatemachine_Instances();

		/**
		 * The meta object literal for the '<em><b>Self Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATEMACHINE__SELF_NAME = eINSTANCE.getStatemachine_SelfName();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.statemachines.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.statemachines.impl.StateImpl
		 * @see ac.soton.eventb.statemachines.impl.StatemachinesPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Refines</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__REFINES = eINSTANCE.getState_Refines();

		/**
		 * The meta object literal for the '<em><b>Invariants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__INVARIANTS = eINSTANCE.getState_Invariants();

		/**
		 * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__ACTIVE = eINSTANCE.getState_Active();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.statemachines.impl.InitialImpl <em>Initial</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.statemachines.impl.InitialImpl
		 * @see ac.soton.eventb.statemachines.impl.StatemachinesPackageImpl#getInitial()
		 * @generated
		 */
		EClass INITIAL = eINSTANCE.getInitial();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.statemachines.impl.FinalImpl <em>Final</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.statemachines.impl.FinalImpl
		 * @see ac.soton.eventb.statemachines.impl.StatemachinesPackageImpl#getFinal()
		 * @generated
		 */
		EClass FINAL = eINSTANCE.getFinal();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.statemachines.impl.AnyImpl <em>Any</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.statemachines.impl.AnyImpl
		 * @see ac.soton.eventb.statemachines.impl.StatemachinesPackageImpl#getAny()
		 * @generated
		 */
		EClass ANY = eINSTANCE.getAny();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.statemachines.impl.JunctionImpl <em>Junction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.statemachines.impl.JunctionImpl
		 * @see ac.soton.eventb.statemachines.impl.StatemachinesPackageImpl#getJunction()
		 * @generated
		 */
		EClass JUNCTION = eINSTANCE.getJunction();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.statemachines.impl.ForkImpl <em>Fork</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.statemachines.impl.ForkImpl
		 * @see ac.soton.eventb.statemachines.impl.StatemachinesPackageImpl#getFork()
		 * @generated
		 */
		EClass FORK = eINSTANCE.getFork();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.statemachines.impl.StatemachineOwnerImpl <em>Statemachine Owner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.statemachines.impl.StatemachineOwnerImpl
		 * @see ac.soton.eventb.statemachines.impl.StatemachinesPackageImpl#getStatemachineOwner()
		 * @generated
		 */
		EClass STATEMACHINE_OWNER = eINSTANCE.getStatemachineOwner();

		/**
		 * The meta object literal for the '<em><b>Statemachines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATEMACHINE_OWNER__STATEMACHINES = eINSTANCE.getStatemachineOwner_Statemachines();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.statemachines.TranslationKind <em>Translation Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.statemachines.TranslationKind
		 * @see ac.soton.eventb.statemachines.impl.StatemachinesPackageImpl#getTranslationKind()
		 * @generated
		 */
		EEnum TRANSLATION_KIND = eINSTANCE.getTranslationKind();

	}

} //StatemachinesPackage
