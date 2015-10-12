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
import org.eventb.core.IEvent;
import org.eventb.core.IEventBProject;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Invariant;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.persistence.EventBEMFUtils;
import org.junit.Test;

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
 * state machines' states.
 * </p>
 *
 * @author htson
 * @version 0.1
 * @see State
 * @since 0.1
 */
public class ValidatorTests2_RootLevel_State extends AbstractValidatorTests {

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
	 * The state machine <code>SM</code> within <code>m0</code> (created in the
	 * {@link #setUp()} method).
	 */
	private Statemachine SM;

	/**
	 * The state <code>S0</code> within <code>SM</code> (created in the
	 * {@link #setUp()} method).
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
		Event m0_init = EventBEMFUtils.createEvent(domain, m0,
				IEvent.INITIALISATION);
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
	// (BEGIN) Unit tests for states.
	// =========================================================================

	/**
	 * Unit test for validation on a root statemachine with a state having a
	 * <code>null</code> name.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a state
	 * having <code>null</code> name.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>State must
	 * have a valid name</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_StateMissingName
	 */
	@Test
	public void test_Name_Null() {
		State state = StatemachinesUtils.createState(domain, SM, null, null);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_StateMissingName(state));

	}

	/**
	 * Unit test for validation on a root statemachine with a state having an
	 * empty name.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a state
	 * having an empty name.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>State must
	 * have a valid name</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_StateMissingName
	 */
	@Test
	public void test_Name_Empty() {
		State state = StatemachinesUtils.createState(domain, SM, "", null);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_StateMissingName(state));
	}

	/**
	 * Unit test for validation on a root statemachine with a state having an
	 * invalid name.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a state
	 * having name with name <code>Invalid name</code>.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>State must
	 * have a valid name</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_StateInvalidName
	 */
	@Test
	public void test_Name_Invalid() {
		State state = StatemachinesUtils.createState(domain, SM,
				"Invalid name", null);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_StateInvalidName(state));
	}

	/**
	 * Unit test for validation on a root statemachine with a state having a
	 * valid name.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a state
	 * <code>S0</code>.</li>
	 * 
	 * <li><b>Expected result:</b> <i>(OK)</i>.</li>
	 * </ul>
	 */
	@Test
	public void test_Name_Valid() {
		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.OK);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic);
	}

	/**
	 * Unit test for validation on a root statemachine with a state having a
	 * valid name.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with two states
	 * <code>S0</code>.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i>: ID Collision for the two states <code>S0</code>.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_Name_Collision() {
		State s0prime = StatemachinesUtils.createState(domain, SM, "S0", null);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic(
				"Incorrect sub-diagnostics",
				diagnostic,
				new Error_IDCollision(s0, s0prime,
						"http://soton.ac.uk/models/eventb/statemachines/2014::State::m0.SM.S0"));
	}

	/**
	 * Unit test for validation on a root statemachine with a state having an
	 * invariant with a <code>null</code> name.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a state
	 * <code>S0</code> having an invariant with <code>null</code> name.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Invariant must
	 * have a name</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_InvariantMissingName
	 */
	@Test
	public void test_Invariant_Name_Null() {
		Invariant inv = StatemachinesUtils.createInvariant(domain, s0, null,
				"", false);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_InvariantMissingName(inv));

	}

	/**
	 * Unit test for validation on a root statemachine with a state having an
	 * invariant with an empty name.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a state
	 * <code>S0</code> having an invariant with an empty name.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Invariant must
	 * have a name</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_InvariantMissingName
	 */
	@Test
	public void test_Invariant_Name_Empty() {
		Invariant inv = StatemachinesUtils.createInvariant(domain, s0, "", "",
				false);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_InvariantMissingName(inv));

	}

	/**
	 * Unit test for validation on a root statemachine with a state having an
	 * invariant with an empty name.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a state
	 * <code>S0</code> having an invariant <code>inv1</code>.</li>
	 * 
	 * <li><b>Expected result:</b> <i>(OK)</i>.</li>
	 * </ul>
	 */
	@Test
	public void test_Invariant_Name_Valid() {
		StatemachinesUtils.createInvariant(domain, s0, "inv1", "", false);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.OK);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic);

	}

	/**
	 * Unit test for validation on a root statemachine with a state having
	 * invariants with the same name.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a state
	 * <code>S0</code> having two invariants with the same name
	 * <code>inv1</code>.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- The ID collides.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_IDCollision
	 */
	@Test
	public void test_Invariant_Name_Collision() {
		Invariant inv1 = StatemachinesUtils.createInvariant(domain, s0, "inv1",
				"", false);
		Invariant inv2 = StatemachinesUtils.createInvariant(domain, s0, "inv1",
				"", true);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_IDCollision(inv1, inv2, inv1.getReference()));
	}

	/**
	 * Unit test for validation on a root statemachine with a state having
	 * invariants with a <code>null</code> predicate string.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a state
	 * <code>S0</code> having an invariant <code>inv1</code> with a
	 * <code>null</code> predicate string.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- The required 'predicate' feature must be set.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_FeatureMissing
	 */
	public void test_Invariant_Predicate_Null() {
		Invariant inv = StatemachinesUtils.createInvariant(domain, s0, "inv1",
				null, false);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_FeatureMissing(inv,
						CorePackage.Literals.EVENT_BPREDICATE__PREDICATE));
	}

	/**
	 * Unit test for validation on a root statemachine with a state having
	 * invariants with a empty predicate string.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a state
	 * <code>S0</code> having an invariant <code>inv1</code> with a
	 * <code>null</code> predicate string.</li>
	 * 
	 * <li><b>Expected result:</b> <i>OK</i>.</li>
	 * </ul>
	 */
	public void test_Invariant_Predicate_Empty() {
		StatemachinesUtils.createInvariant(domain, s0, "inv1", "", false);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.OK);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic);
	}

	/**
	 * Unit test for validation on a root statemachine with a state having
	 * invariants with a non-empty predicate string.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a state
	 * <code>S0</code> having an invariant <code>inv1</code> with a
	 * <code>null</code> predicate string.</li>
	 * 
	 * <li><b>Expected result:</b> <i>OK</i>.</li>
	 * </ul>
	 */
	public void test_Invariant_Predicate_NonEmpty() {
		StatemachinesUtils.createInvariant(domain, s0, "inv1",
				"Some predicate", false);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.OK);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic);
	}

	/**
	 * Unit test for validation on a root statemachine with a state having no
	 * invariants.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a state
	 * <code>S0</code> having an invariant <code>inv1</code>.</li>
	 * 
	 * <li><b>Expected result:</b> <i>(OK)</i>.</li>
	 * </ul>
	 */
	@Test
	public void test_Invariant_None() {
		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.OK);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic);
	}

	/**
	 * Unit test for validation on a root statemachine with a state having one
	 * invariant.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a state
	 * <code>S0</code> having an invariant <code>inv1</code>.</li>
	 * 
	 * <li><b>Expected result:</b> <i>(OK)</i>.</li>
	 * </ul>
	 */
	@Test
	public void test_Invariant_Single() {
		StatemachinesUtils.createInvariant(domain, s0, "inv1", "", false);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.OK);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic);

	}

	/**
	 * Unit test for validation on a root statemachine with a state having
	 * multiple invariants.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a state
	 * <code>S0</code> having invariants <code>inv1</code> and <code>inv2</code>
	 * .</li>
	 * 
	 * <li><b>Expected result:</b> <i>(OK)</i>.</li>
	 * </ul>
	 */
	@Test
	public void test_Invariant_Multiple() {
		StatemachinesUtils.createInvariant(domain, s0, "inv1", "", false);
		StatemachinesUtils.createInvariant(domain, s0, "inv2", "", true);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.OK);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic);

	}

	// =========================================================================
	// (END) Unit tests for states.
	// =========================================================================

}
