/*******************************************************************************
 * Copyright (c) 2015 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     University of Southampton - initial API and implementation
 *******************************************************************************/

package ac.soton.eventb.statemachines.validator.tests;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eventb.core.IEvent;
import org.eventb.core.IEventBProject;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.persistence.EventBEMFUtils;
import org.junit.Test;

import ac.soton.eventb.statemachines.Final;
import ac.soton.eventb.statemachines.Initial;
import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachinesUtils;
import ac.soton.eventb.statemachines.Transition;
import ac.soton.eventb.statemachines.TranslationKind;
import ch.ethz.eventb.utils.EventBUtils;

/**
 * <p>
 * This class contains unit tests for Statemachines validator at the root-level
 * state machines' initial states.
 * </p>
 *
 * @author htson
 * @version 0.1
 * @see Initial
 * @since 0.1
 */
public final class ValidatorTests1_RootLevel_InitialState extends
		AbstractValidatorTests {

	/**
	 * The Event-B project <code>P</code> (created in the {@link #setUp()}
	 * method).
	 */
	private IEventBProject prj;

	/**
	 * The machine <code>m0</code> within <code>P</code> (created in the
	 * {@link #setUp()} method).
	 */
	private Machine m0;

	/**
	 * The event <code>INITIALISATION</code> within <code>m0</code> (created in
	 * the {@link #setUp()} method).
	 */
	private Event m0_init;

	/**
	 * The state machine <code>SM</code> within <code>m0</code> (created in the
	 * {@link #setUp()} method).
	 */
	private Statemachine SM;

	/**
	 * This setup method performs the following.
	 * <ol>
	 * <li>Calls the super method (i.e., {@link AbstractValidatorTests#setUp()}
	 * ).</li>
	 * 
	 * <li>Create the Event-B project <code>P</code>.</li>
	 * 
	 * <li>Create the machine <code>m0</code> within <code>P</code>.</li>
	 * 
	 * <li>Create the event <code>INITIALISATION</code> within <code>m0</code>.</li>
	 * 
	 * <li>Create the statemachine <code>SM</code> within <code>m0</code>.</li>
	 * 
	 * <li>Save <code>m0</code>.</li>
	 * 
	 * </ol>
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		prj = EventBUtils.createEventBProject("P", nullMonitor);
		m0 = EventBEMFUtils.createMachine(emfRodinDB, prj, "m0");
		m0_init = EventBEMFUtils.createEvent(domain, m0, IEvent.INITIALISATION);
		SM = StatemachinesUtils.createStatemachine(domain, m0, null, "SM",
				null, null, "", TranslationKind.SINGLEVAR);
		EventBEMFUtils.save(emfRodinDB, m0);
	}

	// =========================================================================
	// (BEGIN) Unit tests for initial states and initial transitions.
	// =========================================================================

	/**
	 * Unit test for validation on a root statemachine containing initial state
	 * without outgoing transition.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with an initial
	 * state <code>Init</code>.</li>
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(WARNING)</i> --- Validation fails the constraint '<i>Root
	 * statemachine should have initial state</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Warning_InitStateMissingOutgoingTransition
	 */
	@Test
	public void test_InitState_NoOutgoingTransition() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Initial initState = StatemachinesUtils.createInitialState(domain, SM,
				"Init");

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.WARNING);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Warning_InitStateMissingOutgoingTransition(initState));
	}

	/**
	 * Unit test for validation on a root statemachine containing initial state
	 * with an incoming transition.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with an initial
	 * state <code>Init</code>, a state <code>S0</code> and a transition from
	 * <code>S0</code> to <code>Init</code>.</li>
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(WARNING)</i> --- Validation fails the constraint '<i>Initial
	 * state should have an outgoing transition</i>'.</li>
	 * 
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Transition
	 * cannot go to initial state</i>'.</li>
	 * 
	 * <li><i>(WARNING)</i> --- Validation fails the constraint '<i>Transition
	 * should elaborate an event</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Warning_InitStateMissingOutgoingTransition
	 * @see Error_TransitionTargetInitialState
	 * @see Warning_TransitionMissingElaboration
	 */
	@Test
	public void test_InitState_IncomingTransition() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Initial initState = StatemachinesUtils.createInitialState(domain, SM,
				"Init");
		State s0 = StatemachinesUtils.createState(domain, SM, "S0", null);
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				s0, initState);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Warning_InitStateMissingOutgoingTransition(initState),
				new Error_TransitionTargetInitialState(transition),
				new Warning_TransitionMissingElaboration(transition));
	}

	/**
	 * Unit test for validation on a root statemachine containing transition
	 * from an initial state to a final state.
	 * 
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with an inital
	 * state <code>Init</code>, a final state <code>Final</code>, and a
	 * transition from <code>Init</code> to <code>Final</code> elaborates the
	 * INITIALISATION event.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Transition
	 * cannot go directly from initial to final state</i>'.</li>
	 * </ol>
	 * <li>
	 * </ul>
	 * 
	 * @see Error_TransitionFromInitialToFinal
	 */
	@Test
	public void test_InitTransition_FinalStateTarget() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Initial initialState = StatemachinesUtils.createInitialState(domain,
				SM, "");
		Final finalState = StatemachinesUtils.createFinalState(domain, SM,
				"Final");
		Transition initTransition = StatemachinesUtils.createTransition(domain,
				SM, initialState, finalState);
		StatemachinesUtils.addElaboration(domain, initTransition, m0_init);
		EventBEMFUtils.save(emfRodinDB, m0);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_TransitionFromInitialToFinal(initTransition));
	}

	/**
	 * Unit test for validation on a root statemachine containing initial state
	 * with an outgoing transition elaborating the INITIALISATION event.
	 * 
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with an inital
	 * state <code>Init</code>, a state <code>S0</code>, and a transition
	 * elaborates the INITIALISATION event.</li>
	 * 
	 * <li><b>Expected result:</b> <i>(OK)</i>.</li>
	 * </ul>
	 */
	@Test
	public void test_InitTransition_Elaborates_INITIALISATION() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Initial initialState = StatemachinesUtils.createInitialState(domain,
				SM, "");
		State s0 = StatemachinesUtils.createState(domain, SM, "S0", null);
		Transition initTransition = StatemachinesUtils.createTransition(domain,
				SM, initialState, s0);
		StatemachinesUtils.addElaboration(domain, initTransition, m0_init);
		EventBEMFUtils.save(emfRodinDB, m0);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.OK);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic);
	}

	/**
	 * Unit test for validation on a root statemachine containing initial state
	 * with an outgoing transition elaborating a normal event.
	 * 
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with an inital
	 * state <code>Init</code>, a state <code>S0</code>, and a transition
	 * elaborates an existing event "e".</li>
	 * 
	 * <li><b>Expected result:</b> <i>(OK)</i>.</li>
	 * </ul>
	 */
	@Test
	public void test_InitTransition_Elaborates_Event() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Event m0_e = EventBEMFUtils.createEvent(domain, m0, "e");
		Initial initialState = StatemachinesUtils.createInitialState(domain,
				SM, "");
		State s0 = StatemachinesUtils.createState(domain, SM, "S0", null);
		Transition initTransition = StatemachinesUtils.createTransition(domain,
				SM, initialState, s0);
		StatemachinesUtils.addElaboration(domain, initTransition, m0_e);
		EventBEMFUtils.save(emfRodinDB, m0);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.OK);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic);
	}

	// =========================================================================
	// (END) Unit tests for initial states and transitions.
	// =========================================================================
}
