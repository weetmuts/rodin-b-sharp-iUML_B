/**
 * Copyright (c) 2012 - University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.EventBCommented;
import org.eventb.emf.core.EventBCommentedElement;
import org.eventb.emf.core.EventBDerived;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.EventBNamedCommentedDerivedPredicateElement;
import org.eventb.emf.core.EventBNamedCommentedElement;
import org.eventb.emf.core.EventBNamedCommentedPredicateElement;
import org.eventb.emf.core.EventBObject;
import org.eventb.emf.core.EventBPredicate;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.classdiagrams.ClassConstraint;
import ac.soton.eventb.classdiagrams.ClassMethod;
import ac.soton.eventb.classdiagrams.Classdiagram;
import ac.soton.eventb.classdiagrams.ClassdiagramOwner;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.emf.core.extension.coreextension.EventBCommentedLabeledElement;
import ac.soton.eventb.emf.core.extension.coreextension.EventBCommentedLabeledEventGroupElement;
import ac.soton.eventb.emf.core.extension.coreextension.EventBDataElaboration;
import ac.soton.eventb.emf.core.extension.coreextension.EventBEventGroup;
import ac.soton.eventb.emf.core.extension.coreextension.EventBLabeled;
import ac.soton.eventb.emf.core.extension.coreextension.EventBNamedCommentedDataElaborationElement;
import ac.soton.eventb.emf.core.extension.coreextension.EventBNamedCommentedRelationDataElaborationElement;
import ac.soton.eventb.emf.core.extension.coreextension.EventBRelationKind;
import ac.soton.eventb.emf.diagrams.Diagram;
import ac.soton.eventb.emf.diagrams.DiagramOwner;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage
 * @generated
 */
public class ClassdiagramsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ClassdiagramsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassdiagramsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ClassdiagramsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassdiagramsSwitch<Adapter> modelSwitch =
		new ClassdiagramsSwitch<Adapter>() {
			@Override
			public Adapter caseClassdiagramOwner(ClassdiagramOwner object) {
				return createClassdiagramOwnerAdapter();
			}
			@Override
			public Adapter caseClassdiagram(Classdiagram object) {
				return createClassdiagramAdapter();
			}
			@Override
			public Adapter caseAssociation(Association object) {
				return createAssociationAdapter();
			}
			@Override
			public Adapter caseClassAttribute(ClassAttribute object) {
				return createClassAttributeAdapter();
			}
			@Override
			public Adapter caseClass(ac.soton.eventb.classdiagrams.Class object) {
				return createClassAdapter();
			}
			@Override
			public Adapter caseClassMethod(ClassMethod object) {
				return createClassMethodAdapter();
			}
			@Override
			public Adapter caseClassConstraint(ClassConstraint object) {
				return createClassConstraintAdapter();
			}
			@Override
			public Adapter caseEventBObject(EventBObject object) {
				return createEventBObjectAdapter();
			}
			@Override
			public Adapter caseEventBElement(EventBElement object) {
				return createEventBElementAdapter();
			}
			@Override
			public Adapter caseEventBCommented(EventBCommented object) {
				return createEventBCommentedAdapter();
			}
			@Override
			public Adapter caseEventBCommentedElement(EventBCommentedElement object) {
				return createEventBCommentedElementAdapter();
			}
			@Override
			public Adapter caseEventBNamed(EventBNamed object) {
				return createEventBNamedAdapter();
			}
			@Override
			public Adapter caseEventBNamedCommentedElement(EventBNamedCommentedElement object) {
				return createEventBNamedCommentedElementAdapter();
			}
			@Override
			public Adapter caseAbstractExtension(AbstractExtension object) {
				return createAbstractExtensionAdapter();
			}
			@Override
			public Adapter caseDiagram(Diagram object) {
				return createDiagramAdapter();
			}
			@Override
			public Adapter caseEventBDataElaboration(EventBDataElaboration object) {
				return createEventBDataElaborationAdapter();
			}
			@Override
			public Adapter caseEventBNamedCommentedDataElaborationElement(EventBNamedCommentedDataElaborationElement object) {
				return createEventBNamedCommentedDataElaborationElementAdapter();
			}
			@Override
			public Adapter caseEventBRelationKind(EventBRelationKind object) {
				return createEventBRelationKindAdapter();
			}
			@Override
			public Adapter caseEventBNamedCommentedRelationDataElaborationElement(EventBNamedCommentedRelationDataElaborationElement object) {
				return createEventBNamedCommentedRelationDataElaborationElementAdapter();
			}
			@Override
			public Adapter caseDiagramOwner(DiagramOwner object) {
				return createDiagramOwnerAdapter();
			}
			@Override
			public Adapter caseEventBLabeled(EventBLabeled object) {
				return createEventBLabeledAdapter();
			}
			@Override
			public Adapter caseEventBCommentedLabeledElement(EventBCommentedLabeledElement object) {
				return createEventBCommentedLabeledElementAdapter();
			}
			@Override
			public Adapter caseEventBEventGroup(EventBEventGroup object) {
				return createEventBEventGroupAdapter();
			}
			@Override
			public Adapter caseEventBCommentedLabeledEventGroupElement(EventBCommentedLabeledEventGroupElement object) {
				return createEventBCommentedLabeledEventGroupElementAdapter();
			}
			@Override
			public Adapter caseEventBPredicate(EventBPredicate object) {
				return createEventBPredicateAdapter();
			}
			@Override
			public Adapter caseEventBNamedCommentedPredicateElement(EventBNamedCommentedPredicateElement object) {
				return createEventBNamedCommentedPredicateElementAdapter();
			}
			@Override
			public Adapter caseEventBDerived(EventBDerived object) {
				return createEventBDerivedAdapter();
			}
			@Override
			public Adapter caseEventBNamedCommentedDerivedPredicateElement(EventBNamedCommentedDerivedPredicateElement object) {
				return createEventBNamedCommentedDerivedPredicateElementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link ac.soton.eventb.classdiagrams.ClassdiagramOwner <em>Classdiagram Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramOwner
	 * @generated
	 */
	public Adapter createClassdiagramOwnerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ac.soton.eventb.classdiagrams.Classdiagram <em>Classdiagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ac.soton.eventb.classdiagrams.Classdiagram
	 * @generated
	 */
	public Adapter createClassdiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ac.soton.eventb.classdiagrams.Association <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ac.soton.eventb.classdiagrams.Association
	 * @generated
	 */
	public Adapter createAssociationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ac.soton.eventb.classdiagrams.ClassAttribute <em>Class Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ac.soton.eventb.classdiagrams.ClassAttribute
	 * @generated
	 */
	public Adapter createClassAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ac.soton.eventb.classdiagrams.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ac.soton.eventb.classdiagrams.Class
	 * @generated
	 */
	public Adapter createClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ac.soton.eventb.classdiagrams.ClassMethod <em>Class Method</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ac.soton.eventb.classdiagrams.ClassMethod
	 * @generated
	 */
	public Adapter createClassMethodAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ac.soton.eventb.classdiagrams.ClassConstraint <em>Class Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ac.soton.eventb.classdiagrams.ClassConstraint
	 * @generated
	 */
	public Adapter createClassConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.EventBObject <em>Event BObject</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.EventBObject
	 * @generated
	 */
	public Adapter createEventBObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.EventBElement <em>Event BElement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.EventBElement
	 * @generated
	 */
	public Adapter createEventBElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.EventBCommented <em>Event BCommented</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.EventBCommented
	 * @generated
	 */
	public Adapter createEventBCommentedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.EventBCommentedElement <em>Event BCommented Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.EventBCommentedElement
	 * @generated
	 */
	public Adapter createEventBCommentedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.EventBNamed <em>Event BNamed</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.EventBNamed
	 * @generated
	 */
	public Adapter createEventBNamedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.EventBNamedCommentedElement <em>Event BNamed Commented Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.EventBNamedCommentedElement
	 * @generated
	 */
	public Adapter createEventBNamedCommentedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.AbstractExtension <em>Abstract Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.AbstractExtension
	 * @generated
	 */
	public Adapter createAbstractExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ac.soton.eventb.emf.diagrams.Diagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ac.soton.eventb.emf.diagrams.Diagram
	 * @generated
	 */
	public Adapter createDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ac.soton.eventb.emf.core.extension.coreextension.EventBDataElaboration <em>Event BData Elaboration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ac.soton.eventb.emf.core.extension.coreextension.EventBDataElaboration
	 * @generated
	 */
	public Adapter createEventBDataElaborationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ac.soton.eventb.emf.core.extension.coreextension.EventBNamedCommentedDataElaborationElement <em>Event BNamed Commented Data Elaboration Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ac.soton.eventb.emf.core.extension.coreextension.EventBNamedCommentedDataElaborationElement
	 * @generated
	 */
	public Adapter createEventBNamedCommentedDataElaborationElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ac.soton.eventb.emf.core.extension.coreextension.EventBRelationKind <em>Event BRelation Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ac.soton.eventb.emf.core.extension.coreextension.EventBRelationKind
	 * @generated
	 */
	public Adapter createEventBRelationKindAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ac.soton.eventb.emf.core.extension.coreextension.EventBNamedCommentedRelationDataElaborationElement <em>Event BNamed Commented Relation Data Elaboration Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ac.soton.eventb.emf.core.extension.coreextension.EventBNamedCommentedRelationDataElaborationElement
	 * @generated
	 */
	public Adapter createEventBNamedCommentedRelationDataElaborationElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ac.soton.eventb.emf.diagrams.DiagramOwner <em>Diagram Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ac.soton.eventb.emf.diagrams.DiagramOwner
	 * @generated
	 */
	public Adapter createDiagramOwnerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ac.soton.eventb.emf.core.extension.coreextension.EventBLabeled <em>Event BLabeled</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ac.soton.eventb.emf.core.extension.coreextension.EventBLabeled
	 * @generated
	 */
	public Adapter createEventBLabeledAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ac.soton.eventb.emf.core.extension.coreextension.EventBCommentedLabeledElement <em>Event BCommented Labeled Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ac.soton.eventb.emf.core.extension.coreextension.EventBCommentedLabeledElement
	 * @generated
	 */
	public Adapter createEventBCommentedLabeledElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ac.soton.eventb.emf.core.extension.coreextension.EventBEventGroup <em>Event BEvent Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ac.soton.eventb.emf.core.extension.coreextension.EventBEventGroup
	 * @generated
	 */
	public Adapter createEventBEventGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ac.soton.eventb.emf.core.extension.coreextension.EventBCommentedLabeledEventGroupElement <em>Event BCommented Labeled Event Group Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ac.soton.eventb.emf.core.extension.coreextension.EventBCommentedLabeledEventGroupElement
	 * @generated
	 */
	public Adapter createEventBCommentedLabeledEventGroupElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.EventBPredicate <em>Event BPredicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.EventBPredicate
	 * @generated
	 */
	public Adapter createEventBPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.EventBNamedCommentedPredicateElement <em>Event BNamed Commented Predicate Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.EventBNamedCommentedPredicateElement
	 * @generated
	 */
	public Adapter createEventBNamedCommentedPredicateElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.EventBDerived <em>Event BDerived</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.EventBDerived
	 * @generated
	 */
	public Adapter createEventBDerivedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.EventBNamedCommentedDerivedPredicateElement <em>Event BNamed Commented Derived Predicate Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.EventBNamedCommentedDerivedPredicateElement
	 * @generated
	 */
	public Adapter createEventBNamedCommentedDerivedPredicateElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ClassdiagramsAdapterFactory
