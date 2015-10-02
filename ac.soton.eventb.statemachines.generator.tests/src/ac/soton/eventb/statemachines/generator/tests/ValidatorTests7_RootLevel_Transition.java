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

package ac.soton.eventb.statemachines.generator.tests;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eventb.core.IEvent;
import org.eventb.core.IEventBProject;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.persistence.EventBEMFUtils;
import org.junit.Test;

import ac.soton.eventb.statemachines.Initial;
import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachinesFactory;
import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.StatemachinesUtils;
import ac.soton.eventb.statemachines.Transition;
import ac.soton.eventb.statemachines.TranslationKind;
import ch.ethz.eventb.utils.EventBUtils;

/**
 * <p>
 * This class contains unit tests for Statemachines validator at the root-level
 * state machines' transitions.
 * </p>
 *
 * @author htson
 * @version 0.1
 * @see Transition
 * @since 0.1
 */
public class ValidatorTests7_RootLevel_Transition extends
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
	 * The event <code>INITIALISATION</code> within machine <code>m0</code>.
	 */
	private Event m0_init;

	/**
	 * The state machine <code>SM</code> within <code>m0</code>.
	 */
	private Statemachine SM;

	/**
	 * The state <code>S0</code> within <code>SM</code>.
	 */
	private State s0;

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
	 * <li>Create an initial state within <code>SM</code>.</li>
	 * 
	 * <li>Create the state <code>S0</code> within <code>SM</code>.</li>
	 * 
	 * <li>Create a transition elaborating the INITIALISATION from the initial
	 * state to <code>S0</code>.</li>
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
		Initial initialState = StatemachinesUtils.createInitialState(domain,
				SM, "");
		s0 = StatemachinesUtils.createState(domain, SM, "S0", null);
		Transition initTransition = StatemachinesUtils.createTransition(domain,
				SM, initialState, s0);
		StatemachinesUtils.addElaboration(domain, initTransition, m0_init);
		EventBEMFUtils.save(emfRodinDB, m0);
	}

	// =========================================================================
	// (BEGIN) Unit tests for transitions.
	// =========================================================================

	/**
	 * Unit test for validation on a root statemachine containing a transition
	 * with <code>null</code> source.
	 * 
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a state
	 * <code>S0</code>, and an incoming transition (without elaboration).</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Root statemachine
	 * should have initial state</i>'.</li>
	 * 
	 * <li><i>(ERROR)</i> Required feature '<i>source</i>' must be set.</li>
	 * 
	 * <li><i>(WARNING)</i> Validation fails the constraint '<i>Transition
	 * should elaborate an event</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_Transition_Source_Null() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, null, "", TranslationKind.SINGLEVAR);
		State s0 = StatemachinesUtils.createState(domain, SM, "S0", null);
		Transition transition = StatemachinesUtils.createTransition(domain, SM, null, s0);
		EventBEMFUtils.save(emfRodinDB, m0);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic, Diagnostic.ERROR);
		assertDiagnostic(
				"Incorrect sub-diagnostics",
				diagnostic,
				new Error_SMMissingInitialState(SM),
				new Error_FeatureMissing(transition, StatemachinesPackage.Literals.TRANSITION__SOURCE),
				new Warning_TransitionMissingElaboration(transition));
	}

	/**
	 * Unit test for validation on a root statemachine containing a transition
	 * with a dangling source.
	 * 
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a state
	 * <code>S0</code>, and an incoming transition (without elaboration) from a
	 * dangling state <code>S1</code>.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Root statemachine
	 * should have initial state</i>'.</li>
	 * 
	 * <li><i>(ERROR)</i> Feature '<i>source</i>' contains a dangling reference.
	 * </li>
	 * 
	 * <li><i>(WARNING)</i> Validation fails the constraint '<i>Transition
	 * should elaborate an event</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_Transition_Source_Dangling() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, null, "", TranslationKind.SINGLEVAR);
		State s0 = StatemachinesUtils.createState(domain, SM, "S0", null);
		State s1 = StatemachinesFactory.eINSTANCE.createState();
		s1.setName("S1");
		StatemachinesUtils.createTransition(domain, SM, s1, s0);
		EventBEMFUtils.save(emfRodinDB, m0);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticError("Incorrect root diagnostic", diagnostic);
		assertDiagnosticSeverities("Incorrect sub-diagnostics' severities",
				diagnostic, Diagnostic.ERROR, Diagnostic.ERROR,
				Diagnostic.WARNING);
		assertDiagnosticCauses(
				"Incorrect sub-diagnostics",
				diagnostic,
				"The 'Root statemachine should have initial state' constraint is violated on 'm0::SM'",
				"The feature 'source' of 'm0::SM::<Transition>' contains a dangling reference 'S1'",
				"The 'Transition should elaborate an event' constraint is violated on 'm0::SM::<Transition>'");
	}

	/**
	 * Unit test for validation on a root statemachine containing a transition
	 * with an invalid source.
	 * 
	 */
	@Test
	public void test_Transition_Source_Invalid() {
		// TODO Create an invalid reference for source.
		fail("Not yet implemented");
	}

	/**
	 * Unit test for validation on a root statemachine containing a transition
	 * with <code>null</code> target.
	 * 
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a state
	 * <code>S0</code>, and an outgoing transition (without elaboration).</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Root statemachine
	 * should have initial state</i>'.</li>
	 * 
	 * <li><i>(ERROR)</i> Feature '<i>target</i>' contains a dangling reference.
	 * </li>
	 * 
	 * <li><i>(WARNING)</i> Validation fails the constraint '<i>Transition
	 * should elaborate an event</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_Transition_Target_Null() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, null, "", TranslationKind.SINGLEVAR);
		State s0 = StatemachinesUtils.createState(domain, SM, "S0", null);
		State s1 = StatemachinesFactory.eINSTANCE.createState();
		s1.setName("S1");
		StatemachinesUtils.createTransition(domain, SM, s0, s1);
		EventBEMFUtils.save(emfRodinDB, m0);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticError("Incorrect root diagnostic", diagnostic);
		assertDiagnosticSeverities("Incorrect sub-diagnostics' severities",
				diagnostic, Diagnostic.ERROR, Diagnostic.ERROR,
				Diagnostic.WARNING);
		assertDiagnosticCauses(
				"Incorrect sub-diagnostics",
				diagnostic,
				"The 'Root statemachine should have initial state' constraint is violated on 'm0::SM'",
				"The feature 'target' of 'm0::SM::<Transition>' contains a dangling reference 'S1'",
				"The 'Transition should elaborate an event' constraint is violated on 'm0::SM::<Transition>'");
	}

	/**
	 * Unit test for validation on a root statemachine containing a transition
	 * with a dangling target.
	 * 
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a state
	 * <code>S0</code>, and an outgoing transition (without elaboration) to a
	 * dangling state <code>S1</code>.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Root statemachine
	 * should have initial state</i>'.</li>
	 * 
	 * <li><i>(ERROR)</i> Required feature '<i>target</i>' must be set.</li>
	 * 
	 * <li><i>(WARNING)</i> Validation fails the constraint '<i>Transition
	 * should elaborate an event</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_Transition_Target_Dangling() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, null, "", TranslationKind.SINGLEVAR);
		State s0 = StatemachinesUtils.createState(domain, SM, "S0", null);
		StatemachinesUtils.createTransition(domain, SM, s0, null);
		EventBEMFUtils.save(emfRodinDB, m0);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticError("Incorrect root diagnostic", diagnostic);
		assertDiagnosticSeverities("Incorrect sub-diagnostics' severities",
				diagnostic, Diagnostic.ERROR, Diagnostic.ERROR,
				Diagnostic.WARNING);
		assertDiagnosticCauses(
				"Incorrect sub-diagnostics",
				diagnostic,
				"The 'Root statemachine should have initial state' constraint is violated on 'm0::SM'",
				"The required feature 'target' of 'm0::SM::<Transition>' must be set",
				"The 'Transition should elaborate an event' constraint is violated on 'm0::SM::<Transition>'");
	}

	/**
	 * Unit test for validation on a root statemachine containing a transition
	 * with an invalid target.
	 * 
	 */
	@Test
	public void test_Transition_Target_Invalid() {
		// TODO Create an invalid reference for source.
		fail("Not yet implemented");
	}

	/**
	 * Unit test for validation on a root statemachine containing a transition
	 * without elaboration.
	 * 
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with states
	 * <code>S0</code> and <code>S1</code>, and a transition (without
	 * elaboration) from <code>S0</code> to <code></S1>.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Root statemachine
	 * should have initial state</i>'.</li>
	 * <li><i>(WARNING)</i> Validation fails the constraint '<i>Transition
	 * should elaborate an event</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_Transition_Elaborates_None() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, null, "", TranslationKind.SINGLEVAR);
		State s0 = StatemachinesUtils.createState(domain, SM, "S0", null);
		State s1 = StatemachinesUtils.createState(domain, SM, "S1", null);
		StatemachinesUtils.createTransition(domain, SM, s0, s1);
		EventBEMFUtils.save(emfRodinDB, m0);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticError("Incorrect root diagnostic", diagnostic);
		assertDiagnosticSeverities("Incorrect sub-diagnostics' severities",
				diagnostic, Diagnostic.ERROR, Diagnostic.WARNING);
		assertDiagnosticCauses(
				"Incorrect sub-diagnostics",
				diagnostic,
				"The 'Root statemachine should have initial state' constraint is violated on 'm0::SM'",
				"The 'Transition should elaborate an event' constraint is violated on 'm0::SM::<Transition>'");
	}

	/**
	 * Unit test for validation on a root statemachine containing a transition
	 * without elaboration.
	 * 
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with states
	 * <code>S0</code> and <code>S1</code>, and a transition from
	 * <code>S0</code> to <code>S1</code> elaborates the INITIALISATION event.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Root statemachine
	 * should have initial state</i>'.</li>
	 * <li><i>(WARNING)</i> Validation fails the constraint '<i>Only transition
	 * going out initial state can elaborate INITIALISATION</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_Transition_Elaborates_INITIALISATION() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, null, "", TranslationKind.SINGLEVAR);
		State s0 = StatemachinesUtils.createState(domain, SM, "S0", null);
		State s1 = StatemachinesUtils.createState(domain, SM, "S1", null);
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				s0, s1);
		StatemachinesUtils.addElaboration(domain, transition, m0_init);
		EventBEMFUtils.save(emfRodinDB, m0);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticError("Incorrect root diagnostic", diagnostic);
		assertDiagnosticSeverities("Incorrect sub-diagnostics' severities",
				diagnostic, Diagnostic.ERROR, Diagnostic.WARNING);
		assertDiagnosticCauses(
				"Incorrect sub-diagnostics",
				diagnostic,
				"The 'Root statemachine should have initial state' constraint is violated on 'm0::SM'",
				"The 'Only transition going out initial state can elaborate INITIALISATION' constraint is violated on 'm0::SM::INITIALISATION'");
	}

	/**
	 * Unit test for validation on a root statemachine containing a transition
	 * without elaboration.
	 * 
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with states
	 * <code>S0</code> and <code>S1</code>, and a transition from
	 * <code>S0</code> to <code>S1</code> elaborates the INITIALISATION event.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Root statemachine
	 * should have initial state</i>'.</li>
	 * <li><i>(WARNING)</i> Validation fails the constraint '<i>Only transition
	 * going out initial state can elaborate INITIALISATION</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_Transition_Elaborates_Event() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Event m0_e = EventBEMFUtils.createEvent(domain, m0, "e");
		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, null, "", TranslationKind.SINGLEVAR);
		State s0 = StatemachinesUtils.createState(domain, SM, "S0", null);
		State s1 = StatemachinesUtils.createState(domain, SM, "S1", null);
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				s0, s1);
		StatemachinesUtils.addElaboration(domain, transition, m0_e);
		EventBEMFUtils.save(emfRodinDB, m0);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticError("Incorrect root diagnostic", diagnostic);
		assertDiagnosticSeverities("Incorrect sub-diagnostics' severities",
				diagnostic, Diagnostic.ERROR);
		assertDiagnostic(
				"Incorrect sub-diagnostics",
				diagnostic,
				"The 'Root statemachine should have initial state' constraint is violated on 'm0::SM'");
	}

	// =========================================================================
	// (END) Unit tests for transitions.
	// =========================================================================

}
