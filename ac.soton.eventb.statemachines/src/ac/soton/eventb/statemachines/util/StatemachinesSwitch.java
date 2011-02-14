/**
 * Copyright (c) 2010
 * University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package ac.soton.eventb.statemachines.util;

import ac.soton.eventb.statemachines.*;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.EventBCommented;
import org.eventb.emf.core.EventBCommentedElement;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.EventBObject;

import ac.soton.eventb.statemachines.ANY;
import ac.soton.eventb.statemachines.AbstractNode;
import ac.soton.eventb.statemachines.AbstractState;
import ac.soton.eventb.statemachines.AbstractStatemachine;
import ac.soton.eventb.statemachines.EventBLabeled;
import ac.soton.eventb.statemachines.Final;
import ac.soton.eventb.statemachines.Initial;
import ac.soton.eventb.statemachines.OR;
import ac.soton.eventb.statemachines.RefinedState;
import ac.soton.eventb.statemachines.RefinedStatemachine;
import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachineOwner;
import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.Transition;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see ac.soton.eventb.statemachines.StatemachinesPackage
 * @generated
 */
public class StatemachinesSwitch<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2010\rUniversity of Southampton.\rAll rights reserved. This program and the accompanying materials  are made\ravailable under the terms of the Eclipse Public License v1.0 which accompanies this \rdistribution, and is available at http://www.eclipse.org/legal/epl-v10.html\n";

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StatemachinesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatemachinesSwitch() {
		if (modelPackage == null) {
			modelPackage = StatemachinesPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case StatemachinesPackage.ABSTRACT_STATEMACHINE: {
				AbstractStatemachine abstractStatemachine = (AbstractStatemachine)theEObject;
				T result = caseAbstractStatemachine(abstractStatemachine);
				if (result == null) result = caseEventBCommentedElement(abstractStatemachine);
				if (result == null) result = caseEventBElement(abstractStatemachine);
				if (result == null) result = caseEventBCommented(abstractStatemachine);
				if (result == null) result = caseEventBObject(abstractStatemachine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatemachinesPackage.ABSTRACT_NODE: {
				AbstractNode abstractNode = (AbstractNode)theEObject;
				T result = caseAbstractNode(abstractNode);
				if (result == null) result = caseEventBElement(abstractNode);
				if (result == null) result = caseEventBObject(abstractNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatemachinesPackage.TRANSITION: {
				Transition transition = (Transition)theEObject;
				T result = caseTransition(transition);
				if (result == null) result = caseEventBCommentedElement(transition);
				if (result == null) result = caseEventBNamed(transition);
				if (result == null) result = caseEventBElement(transition);
				if (result == null) result = caseEventBCommented(transition);
				if (result == null) result = caseEventBObject(transition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatemachinesPackage.REFINED_STATEMACHINE: {
				RefinedStatemachine refinedStatemachine = (RefinedStatemachine)theEObject;
				T result = caseRefinedStatemachine(refinedStatemachine);
				if (result == null) result = caseDiagramRoot(refinedStatemachine);
				if (result == null) result = caseEventBLabeled(refinedStatemachine);
				if (result == null) result = caseAbstractExtension(refinedStatemachine);
				if (result == null) result = caseAbstractStatemachine(refinedStatemachine);
				if (result == null) result = caseEventBCommentedElement(refinedStatemachine);
				if (result == null) result = caseEventBElement(refinedStatemachine);
				if (result == null) result = caseEventBCommented(refinedStatemachine);
				if (result == null) result = caseEventBObject(refinedStatemachine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatemachinesPackage.STATEMACHINE: {
				Statemachine statemachine = (Statemachine)theEObject;
				T result = caseStatemachine(statemachine);
				if (result == null) result = caseDiagramRoot(statemachine);
				if (result == null) result = caseEventBNamed(statemachine);
				if (result == null) result = caseAbstractExtension(statemachine);
				if (result == null) result = caseAbstractStatemachine(statemachine);
				if (result == null) result = caseEventBCommentedElement(statemachine);
				if (result == null) result = caseEventBElement(statemachine);
				if (result == null) result = caseEventBCommented(statemachine);
				if (result == null) result = caseEventBObject(statemachine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatemachinesPackage.EVENT_BLABELED: {
				EventBLabeled eventBLabeled = (EventBLabeled)theEObject;
				T result = caseEventBLabeled(eventBLabeled);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatemachinesPackage.STATE: {
				State state = (State)theEObject;
				T result = caseState(state);
				if (result == null) result = caseAbstractState(state);
				if (result == null) result = caseEventBNamed(state);
				if (result == null) result = caseAbstractNode(state);
				if (result == null) result = caseStatemachineOwner(state);
				if (result == null) result = caseEventBElement(state);
				if (result == null) result = caseEventBObject(state);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatemachinesPackage.INITIAL: {
				Initial initial = (Initial)theEObject;
				T result = caseInitial(initial);
				if (result == null) result = caseAbstractNode(initial);
				if (result == null) result = caseEventBElement(initial);
				if (result == null) result = caseEventBObject(initial);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatemachinesPackage.OR: {
				OR or = (OR)theEObject;
				T result = caseOR(or);
				if (result == null) result = caseAbstractNode(or);
				if (result == null) result = caseEventBElement(or);
				if (result == null) result = caseEventBObject(or);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatemachinesPackage.ANY: {
				ANY any = (ANY)theEObject;
				T result = caseANY(any);
				if (result == null) result = caseAbstractNode(any);
				if (result == null) result = caseEventBElement(any);
				if (result == null) result = caseEventBObject(any);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatemachinesPackage.FINAL: {
				Final final_ = (Final)theEObject;
				T result = caseFinal(final_);
				if (result == null) result = caseAbstractNode(final_);
				if (result == null) result = caseEventBElement(final_);
				if (result == null) result = caseEventBObject(final_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatemachinesPackage.STATEMACHINE_OWNER: {
				StatemachineOwner statemachineOwner = (StatemachineOwner)theEObject;
				T result = caseStatemachineOwner(statemachineOwner);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatemachinesPackage.REFINED_STATE: {
				RefinedState refinedState = (RefinedState)theEObject;
				T result = caseRefinedState(refinedState);
				if (result == null) result = caseAbstractState(refinedState);
				if (result == null) result = caseEventBLabeled(refinedState);
				if (result == null) result = caseAbstractNode(refinedState);
				if (result == null) result = caseStatemachineOwner(refinedState);
				if (result == null) result = caseEventBElement(refinedState);
				if (result == null) result = caseEventBObject(refinedState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatemachinesPackage.ABSTRACT_STATE: {
				AbstractState abstractState = (AbstractState)theEObject;
				T result = caseAbstractState(abstractState);
				if (result == null) result = caseAbstractNode(abstractState);
				if (result == null) result = caseStatemachineOwner(abstractState);
				if (result == null) result = caseEventBElement(abstractState);
				if (result == null) result = caseEventBObject(abstractState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatemachinesPackage.DIAGRAM_ROOT: {
				DiagramRoot diagramRoot = (DiagramRoot)theEObject;
				T result = caseDiagramRoot(diagramRoot);
				if (result == null) result = caseAbstractStatemachine(diagramRoot);
				if (result == null) result = caseEventBCommentedElement(diagramRoot);
				if (result == null) result = caseEventBElement(diagramRoot);
				if (result == null) result = caseEventBCommented(diagramRoot);
				if (result == null) result = caseEventBObject(diagramRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Statemachine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Statemachine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractStatemachine(AbstractStatemachine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractNode(AbstractNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransition(Transition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Refined Statemachine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Refined Statemachine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRefinedStatemachine(RefinedStatemachine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statemachine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statemachine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatemachine(Statemachine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event BLabeled</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event BLabeled</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventBLabeled(EventBLabeled object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseState(State object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Initial</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Initial</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInitial(Initial object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OR</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OR</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOR(OR object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ANY</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ANY</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseANY(ANY object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Final</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Final</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFinal(Final object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statemachine Owner</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statemachine Owner</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatemachineOwner(StatemachineOwner object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Refined State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Refined State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRefinedState(RefinedState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractState(AbstractState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diagram Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagram Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiagramRoot(DiagramRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event BObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event BObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventBObject(EventBObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event BElement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event BElement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventBElement(EventBElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event BCommented</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event BCommented</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventBCommented(EventBCommented object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event BCommented Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event BCommented Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventBCommentedElement(EventBCommentedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractExtension(AbstractExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event BNamed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event BNamed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventBNamed(EventBNamed object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //StatemachinesSwitch
