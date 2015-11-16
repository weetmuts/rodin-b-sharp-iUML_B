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
import org.eventb.core.IEvent;
import org.eventb.core.IEventBProject;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.persistence.EventBEMFUtils;
import org.junit.Test;

import ac.soton.eventb.statemachines.Initial;
import ac.soton.eventb.statemachines.Junction;
import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachinesUtils;
import ac.soton.eventb.statemachines.Transition;
import ac.soton.eventb.statemachines.TranslationKind;
import ch.ethz.eventb.utils.EventBUtils;

/**
 * <p>
 * This class contains unit tests for Statemachines validator at the root-level
 * state machines' Junction node.
 * </p>
 *
 * @author htson
 * @version 0.1
 * @see Junction
 * @since 0.1
 */
public class ValidatorTests5_RootLevel_Junction extends AbstractValidatorTests {

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
	 * The event <code>e</code> within <code>m0</code> (created in the
	 * {@link #setUp()} method).
	 */
	private Event m0_e;

	/**
	 * The event <code>f</code> within <code>m0</code> (created in the
	 * {@link #setUp()} method).
	 */
	private Event m0_f;

	/**
	 * The state machine <code>SM</code> within <code>m0</code> (created in the
	 * {@link #setUp()} method).
	 */
	private Statemachine SM;

	/**
	 * The inital state within <code>SM</code> (created in the {@link #setUp()}
	 * method).
	 */
	private Initial init;

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
	 * <li>Create the event <code>e</code> within <code>m0</code>.</li>
	 * 
	 * <li>Create the event <code>f</code> within <code>m0</code>.</li>
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
		m0_e = EventBEMFUtils.createEvent(domain, m0, "e");
		m0_f = EventBEMFUtils.createEvent(domain, m0, "f");
		SM = StatemachinesUtils.createStatemachine(domain, m0, null, "SM",
				null, null, "", TranslationKind.SINGLEVAR);
		init = StatemachinesUtils.createInitialState(domain, SM, "");
		s0 = StatemachinesUtils.createState(domain, SM, "S0", null);
		Transition initTransition = StatemachinesUtils.createTransition(domain,
				SM, init, s0);
		StatemachinesUtils.addElaboration(domain, initTransition, m0_init);
		EventBEMFUtils.save(emfRodinDB, m0);
	}

	// =========================================================================
	// (BEGIN) Unit tests for Junction node.
	// =========================================================================

	/**
	 * Unit test for validation on a root statemachine with a junction having a
	 * <code>null</code> name.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a junction
	 * having a <code>null</code> name.</li>
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Junction
	 * should have at least one incoming transition</i>'.</li>
	 * 
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Junction
	 * should have at least one outgoing transition</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_JunctionMissingIncomingTransition
	 * @see Error_JunctionMissingOutgoingTransition
	 */
	@Test
	public void test_Junction_Name_Null() {
		Junction junction = StatemachinesUtils.createJunction(domain, SM, null);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_JunctionMissingIncomingTransition(junction),
				new Error_JunctionMissingOutgoingTransition(junction));
	}

	/**
	 * Unit test for validation on a root statemachine with a junction having an
	 * empty string name.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a junction
	 * having an empty string name.</li>
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Junction
	 * should have at least one incoming transition</i>'.</li>
	 * 
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Junction
	 * should have at least one outgoing transition</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_JunctionMissingIncomingTransition
	 * @see Error_JunctionMissingOutgoingTransition
	 */
	@Test
	public void test_Junction_Name_Empty() {
		Junction junction = StatemachinesUtils.createJunction(domain, SM, "");

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_JunctionMissingIncomingTransition(junction),
				new Error_JunctionMissingOutgoingTransition(junction));
	}

	/**
	 * Unit test for validation on a root statemachine with a junction having a
	 * <code>null</code> name.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a junction
	 * having a <code>null</code> name.</li>
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Junction
	 * should have at least one incoming transition</i>'.</li>
	 * 
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Junction
	 * should have at least one outgoing transition</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_JunctionMissingIncomingTransition
	 * @see Error_JunctionMissingOutgoingTransition
	 */
	@Test
	public void test_Junction_Name_NoneEmpty() {
		Junction junction = StatemachinesUtils.createJunction(domain, SM,
				"Junction name");

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_JunctionMissingIncomingTransition(junction),
				new Error_JunctionMissingOutgoingTransition(junction));
	}

	/**
	 * Unit test for validation on a root statemachine with two junctions having
	 * the same name.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with two junction
	 * having the same <code>Junction</code> name
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Junction
	 * should have at least one incoming transition</i>'.</li>
	 * 
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Junction
	 * should have at least one incoming transition</i>'.</li>
	 * 
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Junction
	 * should have at least one outgoing transition</i>'.</li>
	 * 
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Junction
	 * should have at least one outgoing transition</i>'.</li>
	 * 
	 * <li><i>(ERROR)</i>: ID Collision for the two junctions
	 * <code>Junction</code>.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_JunctionMissingIncomingTransition
	 * @see Error_JunctionMissingOutgoingTransition
	 * @see Error_IDCollision
	 */
	@Test
	public void test_Junction_Name_Collision() {
		Junction junction1 = StatemachinesUtils.createJunction(domain, SM,
				"Junction");
		Junction junction2 = StatemachinesUtils.createJunction(domain, SM,
				"Junction");

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic(
				"Incorrect sub-diagnostics",
				diagnostic,
				new Error_JunctionMissingIncomingTransition(junction1),
				new Error_JunctionMissingOutgoingTransition(junction1),
				new Error_IDCollision(junction1, junction2, junction1
						.getReference()),
				new Error_JunctionMissingIncomingTransition(junction2),
				new Error_JunctionMissingOutgoingTransition(junction2));
	}

	/**
	 * Unit test for validation on a root statemachine with a junction having no
	 * incoming transitions.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a junction
	 * having no incoming transitions.</li>
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Junction
	 * should have at least one incoming transition</i>'.</li>
	 * 
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Junction
	 * should have at least one outgoing transition</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_JunctionMissingIncomingTransition
	 * @see Error_JunctionMissingOutgoingTransition
	 */
	@Test
	public void test_Junction_IncomingTransition_None() {
		Junction junction = StatemachinesUtils.createJunction(domain, SM, null);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_JunctionMissingIncomingTransition(junction),
				new Error_JunctionMissingOutgoingTransition(junction));
	}

	/**
	 * Unit test for validation on a root statemachine with a junction having a
	 * single incoming transition with no elaboration.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a junction
	 * having an incoming transition from <code>S0</code> with no elaboration.</li>
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Junction
	 * should have at least one outgoing transition</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_JunctionMissingOutgoingTransition
	 */
	@Test
	public void test_Junction_IncomingTransition_Single_Elaboration_None() {
		Junction junction = StatemachinesUtils.createJunction(domain, SM, null);
		StatemachinesUtils.createTransition(domain, SM, s0, junction);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_JunctionMissingOutgoingTransition(junction));
	}

	/**
	 * Unit test for validation on a root statemachine with a junction having a
	 * single incoming transition elaborating a single event.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a junction
	 * having an incoming transition from <code>S0</code> elaborating
	 * <code>e</code>.</li>
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Junction
	 * should have at least one outgoing transition</i>'.</li>
	 * 
	 * <li><i>(WARNING)</i> --- Validation fails the constraint '<i>Transition
	 * should NOT elaborate an event or have actions</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_JunctionMissingOutgoingtransition
	 * @see Warning_TransitionHasElaboration
	 */
	@Test
	public void test_Junction_IncomingTransition_Single_Elaboration_Single() {
		Junction junction = StatemachinesUtils.createJunction(domain, SM, null);
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				s0, junction);
		StatemachinesUtils.addElaboration(domain, transition, m0_e);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_JunctionMissingOutgoingTransition(junction),
				new Warning_TransitionHasElaboration(transition));
	}

	/**
	 * Unit test for validation on a root statemachine with a junction having a
	 * single incoming transition elaborating multiple single events.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a junction
	 * having an incoming transition from <code>S0</code> elaborating
	 * <code>e</code> and <code>f</code>.</li>
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Junction
	 * should have at least one outgoing transition</i>'.</li>
	 * 
	 * <li><i>(WARNING)</i> --- Validation fails the constraint '<i>Transition
	 * should NOT elaborate an event or have actions</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_JunctionMissingOutgoingtransition
	 * @see Warning_TransitionHasElaboration
	 */
	@Test
	public void test_Junction_IncomingTransition_Single_Elaboration_Multiple() {
		Junction junction = StatemachinesUtils.createJunction(domain, SM, null);
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				s0, junction);
		StatemachinesUtils.addElaboration(domain, transition, m0_e);
		StatemachinesUtils.addElaboration(domain, transition, m0_f);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_JunctionMissingOutgoingTransition(junction),
				new Warning_TransitionHasElaboration(transition));
	}

	/**
	 * Unit test for validation on a root statemachine with a junction having
	 * multiple incoming transitions.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a junction
	 * having two incoming transitions.</li>
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Junction
	 * should have at least one outgoing transition</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_JunctionMissingOutgoingTransition
	 */
	@Test
	public void test_Junction_IncomingTransition_Multiple() {
		Junction junction = StatemachinesUtils.createJunction(domain, SM, null);

		StatemachinesUtils.createTransition(domain, SM, init, junction);
		StatemachinesUtils.createTransition(domain, SM, s0, junction);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_JunctionMissingOutgoingTransition(junction));

	}

	/**
	 * Unit test for validation on a root statemachine with a junction having no
	 * outgoing transitions.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a junction
	 * with an incoming transition and no outgoing transitions.</li>
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(WARNING)</i> --- Validation fails the constraint '<i>Junction
	 * should have at least one outgoing transition</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 *
	 * @see Error_JunctionMissingOutgoingTransition
	 */
	@Test
	public void test_Junction_OutgoingTransition_None() {
		Junction junction = StatemachinesUtils.createJunction(domain, SM, null);
		StatemachinesUtils.createTransition(domain, SM, s0, junction);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_JunctionMissingOutgoingTransition(junction));
	}

	/**
	 * Unit test for validation on a root statemachine with a junction having an
	 * outgoing transition with no elaborations.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a junction
	 * with an incoming transition and an outgoing transition having no
	 * elaborations.</li>
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Junction
	 * should have at least one outgoing transition</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 *
	 * @see Error_JunctionMissingOutgoingTransition
	 */
	@Test
	public void test_Junction_OutgoingTransition_Single_Elaboration_None() {
		Junction junction = StatemachinesUtils.createJunction(domain, SM, null);
		// The incoming transition
		StatemachinesUtils.createTransition(domain, SM, s0, junction);

		// The outgoing transition
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				junction, s0);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.WARNING);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Warning_TransitionMissingElaboration(transition));
	}

	/**
	 * Unit test for validation on a root statemachine with a junction having
	 * with an outgoing transition elaborating a single event.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a junction
	 * with an incoming transition and an outgoing transition having elaborating
	 * <code>e</code>.</li>
	 * 
	 * <li><b>Expected result: </b><i>(OK)</i></li>
	 * </ul>
	 */
	@Test
	public void test_Junction_OutgoingTransition_Single_Elaboration_Single() {
		Junction junction = StatemachinesUtils.createJunction(domain, SM, null);
		// The incoming transition
		StatemachinesUtils.createTransition(domain, SM, s0, junction);

		// The outgoing transition
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				junction, s0);
		StatemachinesUtils.addElaboration(domain, transition, m0_e);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.OK);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic);
	}

	/**
	 * Unit test for validation on a root statemachine with a junction having
	 * with an outgoing transition elaborating multiple events.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a junction
	 * with an incoming transition and an outgoing transition having elaborating
	 * <code>e</code> and <code>f</code>.</li>
	 * 
	 * <li><b>Expected result: </b><i>(OK)</i></li>
	 * </ul>
	 */
	@Test
	public void test_Junction_OutgoingTransition_Single_Elaboration_Multiple() {
		Junction junction = StatemachinesUtils.createJunction(domain, SM, null);
		// The incoming transition
		StatemachinesUtils.createTransition(domain, SM, s0, junction);

		// The outgoing transition
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				junction, s0);
		StatemachinesUtils.addElaboration(domain, transition, m0_e);
		StatemachinesUtils.addElaboration(domain, transition, m0_f);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.OK);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic);
	}

	/**
	 * Unit test for validation on a root statemachine with a junction having
	 * with an outgoing transition elaborating multiple events.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a junction
	 * with an incoming transition and an outgoing transition having elaborating
	 * <code>e</code> and <code>f</code>.</li>
	 * 
	 * <li><b>Expected result: </b><i>(OK)</i></li>
	 * </ul>
	 */
	@Test
	public void test_Junction_OutgoingTransition_Multiple() {
		Junction junction = StatemachinesUtils.createJunction(domain, SM, null);
		// The incoming transition
		StatemachinesUtils.createTransition(domain, SM, s0, junction);

		// The outgoing transitions
		Transition transition1 = StatemachinesUtils.createTransition(domain,
				SM, junction, s0);
		StatemachinesUtils.addElaboration(domain, transition1, m0_e);
		Transition transition2 = StatemachinesUtils.createTransition(domain,
				SM, junction, s0);
		StatemachinesUtils.addElaboration(domain, transition2, m0_f);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.OK);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic);
	}

	// =========================================================================
	// (END) Unit tests for Junction node.
	// =========================================================================

}
