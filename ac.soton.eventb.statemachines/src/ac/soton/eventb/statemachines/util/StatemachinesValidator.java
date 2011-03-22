/**
 * Copyright (c) 2010
 * University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 *
 * $Id$
 */
package ac.soton.eventb.statemachines.util;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.statemachines.ANY;
import ac.soton.eventb.statemachines.AbstractNode;
import ac.soton.eventb.statemachines.AbstractState;
import ac.soton.eventb.statemachines.AbstractStatemachine;
import ac.soton.eventb.statemachines.DiagramRoot;
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
import ac.soton.eventb.statemachines.TranslationKind;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see ac.soton.eventb.statemachines.StatemachinesPackage
 * @generated
 */
public class StatemachinesValidator extends EObjectValidator {
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
	public static final StatemachinesValidator INSTANCE = new StatemachinesValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "ac.soton.eventb.statemachines";

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
	public StatemachinesValidator() {
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
	  return StatemachinesPackage.eINSTANCE;
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
			case StatemachinesPackage.ABSTRACT_STATEMACHINE:
				return validateAbstractStatemachine((AbstractStatemachine)value, diagnostics, context);
			case StatemachinesPackage.ABSTRACT_NODE:
				return validateAbstractNode((AbstractNode)value, diagnostics, context);
			case StatemachinesPackage.TRANSITION:
				return validateTransition((Transition)value, diagnostics, context);
			case StatemachinesPackage.REFINED_STATEMACHINE:
				return validateRefinedStatemachine((RefinedStatemachine)value, diagnostics, context);
			case StatemachinesPackage.STATEMACHINE:
				return validateStatemachine((Statemachine)value, diagnostics, context);
			case StatemachinesPackage.EVENT_BLABELED:
				return validateEventBLabeled((EventBLabeled)value, diagnostics, context);
			case StatemachinesPackage.STATE:
				return validateState((State)value, diagnostics, context);
			case StatemachinesPackage.INITIAL:
				return validateInitial((Initial)value, diagnostics, context);
			case StatemachinesPackage.OR:
				return validateOR((OR)value, diagnostics, context);
			case StatemachinesPackage.ANY:
				return validateANY((ANY)value, diagnostics, context);
			case StatemachinesPackage.FINAL:
				return validateFinal((Final)value, diagnostics, context);
			case StatemachinesPackage.STATEMACHINE_OWNER:
				return validateStatemachineOwner((StatemachineOwner)value, diagnostics, context);
			case StatemachinesPackage.REFINED_STATE:
				return validateRefinedState((RefinedState)value, diagnostics, context);
			case StatemachinesPackage.ABSTRACT_STATE:
				return validateAbstractState((AbstractState)value, diagnostics, context);
			case StatemachinesPackage.DIAGRAM_ROOT:
				return validateDiagramRoot((DiagramRoot)value, diagnostics, context);
			case StatemachinesPackage.TRANSLATION_KIND:
				return validateTranslationKind((TranslationKind)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractStatemachine(AbstractStatemachine abstractStatemachine, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_NoCircularContainment(abstractStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMultiplicityConforms(abstractStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(abstractStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(abstractStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(abstractStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(abstractStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(abstractStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(abstractStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(abstractStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractStatemachine_rootHasInitial(abstractStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractStatemachine_hasAtMostOneInitial(abstractStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractStatemachine_hasInitialIfIncomingExternal(abstractStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractStatemachine_hasInitialIfOutgoingLocal(abstractStatemachine, diagnostics, context);
		return result;
	}

	/**
	 * Validates the rootHasInitial constraint of '<em>Abstract Statemachine</em>'.
	 * <!-- begin-user-doc -->
	 * Root statemachine has an initial state.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateAbstractStatemachine_rootHasInitial(AbstractStatemachine abstractStatemachine, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (abstractStatemachine.eContainer() instanceof Machine
				&& EcoreUtil.getObjectByType(abstractStatemachine.getNodes(), StatemachinesPackage.eINSTANCE.getInitial()) == null) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "Root statemachine must have one initial state", getObjectLabel(abstractStatemachine, context) },
						 new Object[] { abstractStatemachine },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the hasAtMostOneInitial constraint of '<em>Abstract Statemachine</em>'.
	 * <!-- begin-user-doc -->
	 * Abstract statemachine has at most one initial state.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateAbstractStatemachine_hasAtMostOneInitial(AbstractStatemachine abstractStatemachine, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (EcoreUtil.getObjectsByType(abstractStatemachine.getNodes(), StatemachinesPackage.eINSTANCE.getInitial()).size() > 1) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "Statemachine cannot have more than one initial state", getObjectLabel(abstractStatemachine, context) },
						 new Object[] { abstractStatemachine },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the hasInitialIfIncomingExternal constraint of '<em>Abstract Statemachine</em>'.
	 * <!-- begin-user-doc -->
	 * Has an initial state if incoming external transitions exist.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateAbstractStatemachine_hasInitialIfIncomingExternal(AbstractStatemachine abstractStatemachine, DiagnosticChain diagnostics, Map<Object, Object> context) {
		EObject container = abstractStatemachine.eContainer();
		if (container != null 
				&& container instanceof AbstractState
				&& ((AbstractState) container).getIncoming().size() > 0 
				&& EcoreUtil.getObjectByType(abstractStatemachine.getNodes(), StatemachinesPackage.eINSTANCE.getInitial()) == null) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "Statemachine must have initial state if parent state has incoming transition(s)", getObjectLabel(abstractStatemachine, context) },
						 new Object[] { abstractStatemachine },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the hasInitialIfOutgoingLocal constraint of '<em>Abstract Statemachine</em>'.
	 * <!-- begin-user-doc -->
	 * Has an initial state if outgoing local transitions exist.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateAbstractStatemachine_hasInitialIfOutgoingLocal(AbstractStatemachine abstractStatemachine, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (EcoreUtil.getObjectByType(abstractStatemachine.getNodes(), StatemachinesPackage.eINSTANCE.getInitial()) == null) {
			Collection<ANY> anyStates = EcoreUtil.getObjectsByType(abstractStatemachine.getNodes(), StatemachinesPackage.eINSTANCE.getANY());
			for (ANY anyState : anyStates) {
				if (anyState.getIncoming().size() > 0) {
					if (diagnostics != null) {
						diagnostics.add
							(createDiagnostic
								(Diagnostic.ERROR,
								 DIAGNOSTIC_SOURCE,
								 0,
								 "_UI_GenericConstraint_diagnostic",
								 new Object[] { "Statemachine must have initial state if parent state has incoming local transition(s)", getObjectLabel(abstractStatemachine, context) },
								 new Object[] { abstractStatemachine },
								 context));
					}
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractNode(AbstractNode abstractNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(abstractNode, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransition(Transition transition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_NoCircularContainment(transition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMultiplicityConforms(transition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(transition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(transition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(transition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(transition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(transition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(transition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(transition, diagnostics, context);
		if (result || diagnostics != null) result &= validateTransition_notToInitial(transition, diagnostics, context);
		if (result || diagnostics != null) result &= validateTransition_notFromFinal(transition, diagnostics, context);
		if (result || diagnostics != null) result &= validateTransition_notFromInitialToFinal(transition, diagnostics, context);
		if (result || diagnostics != null) result &= validateTransition_elaboratesIfNotInitial(transition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the notToInitial constraint of '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * Not an incoming transition to initial state.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateTransition_notToInitial(Transition transition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (transition.getTarget() instanceof Initial) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "Transition cannot go to initial state", getObjectLabel(transition, context) },
						 new Object[] { transition },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the notFromFinal constraint of '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * Not an outgoing transition from final state.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateTransition_notFromFinal(Transition transition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (transition.getSource() instanceof Final) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "Transition cannot go from final state", getObjectLabel(transition, context) },
						 new Object[] { transition },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the notFromInitialToFinal constraint of '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * Not from initial to final state.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateTransition_notFromInitialToFinal(Transition transition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (transition.getSource() instanceof Initial && transition.getTarget() instanceof Final) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "Transition cannot go directly from initial to final state", getObjectLabel(transition, context) },
						 new Object[] { transition },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the elaboratesIfNotInitial constraint of '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * Elaborates property is set if transition is not from initial state.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateTransition_elaboratesIfNotInitial(Transition transition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (transition.getSource() instanceof Initial == false && transition.getElaborates().isEmpty()) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.WARNING,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "Transition should elaborate event(s) when it is not initial", getObjectLabel(transition, context) },
						 new Object[] { transition },
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
	public boolean validateRefinedStatemachine(RefinedStatemachine refinedStatemachine, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_NoCircularContainment(refinedStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMultiplicityConforms(refinedStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(refinedStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(refinedStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(refinedStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(refinedStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(refinedStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(refinedStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(refinedStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractStatemachine_rootHasInitial(refinedStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractStatemachine_hasAtMostOneInitial(refinedStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractStatemachine_hasInitialIfIncomingExternal(refinedStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractStatemachine_hasInitialIfOutgoingLocal(refinedStatemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validateRefinedStatemachine_hasNoStates(refinedStatemachine, diagnostics, context);
		return result;
	}

	/**
	 * Validates the hasNoStates constraint of '<em>Refined Statemachine</em>'.
	 * <!-- begin-user-doc -->
	 * Refined statemachine has no States.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateRefinedStatemachine_hasNoStates(RefinedStatemachine refinedStatemachine, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (EcoreUtil.getObjectByType(refinedStatemachine.eContents(), StatemachinesPackage.eINSTANCE.getState()) != null) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "Refined statemachine cannot contain concrete states", getObjectLabel(refinedStatemachine, context) },
						 new Object[] { refinedStatemachine },
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
	public boolean validateStatemachine(Statemachine statemachine, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_NoCircularContainment(statemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMultiplicityConforms(statemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(statemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(statemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(statemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(statemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(statemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(statemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(statemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractStatemachine_rootHasInitial(statemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractStatemachine_hasAtMostOneInitial(statemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractStatemachine_hasInitialIfIncomingExternal(statemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractStatemachine_hasInitialIfOutgoingLocal(statemachine, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatemachine_hasNoRefinedStates(statemachine, diagnostics, context);
		return result;
	}

	/**
	 * Validates the hasNoRefinedStates constraint of '<em>Statemachine</em>'.
	 * <!-- begin-user-doc -->
	 * Statemachine has no refined states.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateStatemachine_hasNoRefinedStates(Statemachine statemachine, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (EcoreUtil.getObjectByType(statemachine.eContents(), StatemachinesPackage.eINSTANCE.getRefinedState()) != null) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "Concrete statemachine cannot have refined states", getObjectLabel(statemachine, context) },
						 new Object[] { statemachine },
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
	public boolean validateEventBLabeled(EventBLabeled eventBLabeled, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(eventBLabeled, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateState(State state, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_NoCircularContainment(state, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMultiplicityConforms(state, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(state, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(state, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(state, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(state, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(state, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(state, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(state, diagnostics, context);
		if (result || diagnostics != null) result &= validateState_hasNoRefinedStatemachines(state, diagnostics, context);
		return result;
	}

	/**
	 * Validates the hasNoRefinedStatemachines constraint of '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * State has no refined statemachines.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateState_hasNoRefinedStatemachines(State state, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (EcoreUtil.getObjectByType(state.eContents(), StatemachinesPackage.eINSTANCE.getRefinedStatemachine()) != null) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "Concrete state cannot have refined statemachines", getObjectLabel(state, context) },
						 new Object[] { state },
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
	public boolean validateInitial(Initial initial, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_NoCircularContainment(initial, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMultiplicityConforms(initial, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(initial, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(initial, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(initial, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(initial, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(initial, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(initial, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(initial, diagnostics, context);
		if (result || diagnostics != null) result &= validateInitial_hasAtMostOneOutgoing(initial, diagnostics, context);
		if (result || diagnostics != null) result &= validateInitial_hasOutgoingOnRoot(initial, diagnostics, context);
		if (result || diagnostics != null) result &= validateInitial_hasOutgoingOnNestedIfExternalIncoming(initial, diagnostics, context);
		return result;
	}

	/**
	 * Validates the hasAtMostOneOutgoing constraint of '<em>Initial</em>'.
	 * <!-- begin-user-doc -->
	 * Initial state has at most one outgoing transition.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateInitial_hasAtMostOneOutgoing(Initial initial, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (initial.getOutgoing().size() > 1) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "Initial state cannot have more than one outgoing transition", getObjectLabel(initial, context) },
						 new Object[] { initial },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the hasOutgoingOnRoot constraint of '<em>Initial</em>'.
	 * <!-- begin-user-doc -->
	 * Initial state of root statemachine has an outgoing transition.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateInitial_hasOutgoingOnRoot(Initial initial, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (initial.eContainer().eContainer() instanceof Machine && initial.getOutgoing().isEmpty()) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "Initial state of root statemachine must have one outgoing transition", getObjectLabel(initial, context) },
						 new Object[] { initial },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the hasOutgoingOnNestedIfExternalIncoming constraint of '<em>Initial</em>'.
	 * <!-- begin-user-doc -->
	 * Initial state of nested level statemachine has an outgoing transition if external incoming transitions to parent state exist.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateInitial_hasOutgoingOnNestedIfExternalIncoming(Initial initial, DiagnosticChain diagnostics, Map<Object, Object> context) {
		EObject container = initial.eContainer().eContainer();
		if (container instanceof AbstractState 
				&& ((AbstractState) container).getIncoming().size() > 0 
				&& initial.getOutgoing().isEmpty()) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "Initial state must have one outgoing transition if parent state has incoming transition(s)", getObjectLabel(initial, context) },
						 new Object[] { initial },
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
	public boolean validateOR(OR or, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(or, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateANY(ANY any, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(any, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFinal(Final final_, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(final_, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStatemachineOwner(StatemachineOwner statemachineOwner, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(statemachineOwner, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRefinedState(RefinedState refinedState, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(refinedState, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractState(AbstractState abstractState, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(abstractState, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDiagramRoot(DiagramRoot diagramRoot, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_NoCircularContainment(diagramRoot, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMultiplicityConforms(diagramRoot, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(diagramRoot, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(diagramRoot, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(diagramRoot, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(diagramRoot, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(diagramRoot, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(diagramRoot, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(diagramRoot, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractStatemachine_rootHasInitial(diagramRoot, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractStatemachine_hasAtMostOneInitial(diagramRoot, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractStatemachine_hasInitialIfIncomingExternal(diagramRoot, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractStatemachine_hasInitialIfOutgoingLocal(diagramRoot, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTranslationKind(TranslationKind translationKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
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

} //StatemachinesValidator
