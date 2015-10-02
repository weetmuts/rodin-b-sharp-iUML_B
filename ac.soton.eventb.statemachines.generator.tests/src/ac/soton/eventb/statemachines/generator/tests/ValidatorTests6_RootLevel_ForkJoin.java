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
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.persistence.EventBEMFUtils;
import org.junit.Test;

import ac.soton.eventb.statemachines.Fork;
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
 * state machines' Fork/Join node.
 * </p>
 *
 * @author htson
 * @version 0.1
 * @see Fork
 * @since 0.1
 */
public class ValidatorTests6_RootLevel_ForkJoin extends AbstractValidatorTests {

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
	// (BEGIN) Unit tests for ANY node.ValidatorTests4_RootLevel_Any.java
	// =========================================================================

	/**
	 * Unit test for validation on a root statemachine with a fork/join node
	 * having a <code>null</code> name.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a fork/join
	 * node having a <code>null</code> name.</li>
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Fork/Join node
	 * is neither forking nor joining transitions</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_ForkJoinNeitherForkingNorJoining
	 */
	@Test
	public void test_ForkJoin_Name_Null() {
		Fork fork = StatemachinesUtils.createFork(domain, SM, null);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_ForkJoinNeitherForkingNorJoining(fork));
	}

	/**
	 * Unit test for validation on a root statemachine with a fork/join node
	 * having an empty name.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a fork/join
	 * node having an empty name.</li>
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Fork/Join node
	 * is neither forking nor joining transitions</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_ForkJoinNeitherForkingNorJoining
	 */
	@Test
	public void test_ForkJoin_Name_Empty() {
		Fork fork = StatemachinesUtils.createFork(domain, SM, "");

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_ForkJoinNeitherForkingNorJoining(fork));
	}

	/**
	 * Unit test for validation on a root statemachine with a fork/join node
	 * having a non-empty name.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a fork/join
	 * node having a non-empty name.</li>
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Fork/Join node
	 * is neither forking nor joining transitions</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_ForkJoinNeitherForkingNorJoining
	 */
	@Test
	public void test_ForkJoin_Name_NonEmpty() {
		Fork fork = StatemachinesUtils.createFork(domain, SM, "Fork name");

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_ForkJoinNeitherForkingNorJoining(fork));
	}

	/**
	 * Unit test for validation on a root statemachine with two fork/join nodes
	 * having the same name.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with two
	 * fork/join nodes having the same name <code>Fork</code>.</li>
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Fork/Join node
	 * is neither forking nor joining transitions</i>'.</li>
	 * 
	 * <li><i>(ERROR)</i>: ID Collision for the two fork/join nodes
	 * <code>Fork</code>.</li>
	 * 
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Fork/Join node
	 * is neither forking nor joining transitions</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_ForkJoinNeitherForkingNorJoining
	 * @see Error_IDCollision
	 */
	@Test
	public void test_ForkJoin_Name_Collision() {
		Fork fork1 = StatemachinesUtils.createFork(domain, SM, "Fork");
		Fork fork2 = StatemachinesUtils.createFork(domain, SM, "Fork");

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_ForkJoinNeitherForkingNorJoining(fork1),
				new Error_IDCollision(fork1, fork2, fork1.getReference()),
				new Error_ForkJoinNeitherForkingNorJoining(fork2));
	}

	/**
	 * Unit test for validation on a root statemachine with a fork/join node
	 * having no incoming nor outgoing transitions.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a fork/join
	 * node having no incoming nor outgoing transitions.</li>
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Fork/Join node
	 * is neither forking nor joining transitions</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_ForkJoinNeitherForkingNorJoining
	 */
	@Test
	public void test_ForkJoin_NoTransitions() {
		Fork fork = StatemachinesUtils.createFork(domain, SM, "Fork/Join");

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_ForkJoinNeitherForkingNorJoining(fork));
	}

	/**
	 * Unit test for validation on a root statemachine with a fork node (having
	 * exactly one outgoing transition) having no incoming transitions.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a fork node
	 * having no incoming transitions.</li>
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Fork/Join node
	 * is neither forking nor joining transitions</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_ForkJoinNeitherForkingNorJoining
	 */
	@Test
	public void test_Fork_IncomingTransitions_None() {
		Fork fork = StatemachinesUtils.createFork(domain, SM, "Fork/Join");

		// The outgoing transitions
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				fork, s0);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_ForkJoinNeitherForkingNorJoining(fork),
				new Warning_TransitionMissingElaboration(transition));
	}

	/**
	 * Unit test for validation on a root statemachine with a fork node (having
	 * exactly one outgoing transition) having one incoming transition.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a fork node
	 * having one incoming transition from <code>S0</code>.</li>
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Fork/Join node
	 * is neither forking nor joining transitions</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_ForkJoinNeitherForkingNorJoining
	 */
	@Test
	public void test_Fork_IncomingTransitions_Single() {
		Fork fork = StatemachinesUtils.createFork(domain, SM, "Fork/Join");

		// The outgoing transitions
		Transition outgoingTransition = StatemachinesUtils.createTransition(
				domain, SM, fork, s0);

		StatemachinesUtils.createTransition(domain, SM,
				s0, fork);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_ForkJoinNeitherForkingNorJoining(fork),
				new Warning_TransitionMissingElaboration(outgoingTransition)
		// new Warning_TransitionMissingElaboration(transition)
		);
	}

	/**
	 * Unit test for validation on a root statemachine with a fork node (having
	 * exactly one outgoing transition) having two incoming transitions.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a fork node
	 * having two incoming transitions from <code>S0</code>.</li>
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Fork/Join node
	 * is neither forking nor joining transitions</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_ForkJoinNeitherForkingNorJoining
	 */
	@Test
	public void test_Fork_IncomingTransitions_Two() {
		Fork fork = StatemachinesUtils.createFork(domain, SM, "Fork/Join");

		// The outgoing transitions
		Transition outgoingTransition = StatemachinesUtils.createTransition(
				domain, SM, fork, s0);

		StatemachinesUtils.createTransition(domain, SM, s0, fork);
		StatemachinesUtils.createTransition(domain, SM, s0, fork);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_ForkJoinNotInParalleSM(fork),
				new Warning_TransitionMissingElaboration(outgoingTransition));
	}

	// =========================================================================
	// (END) Unit tests for ANY node.
	// =========================================================================

}
