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

import ac.soton.eventb.statemachines.Any;
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
 * state machines' ANY node.
 * </p>
 *
 * @author htson
 * @version 0.1
 * @see Any
 * @since 0.1
 */
public class ValidatorTests4_RootLevel_Any extends AbstractValidatorTests {

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
		init = StatemachinesUtils.createInitialState(domain, SM, "Init");
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
	 * Unit test for validation on a root statemachine with an ANY node having a
	 * <code>null</code> name.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> containing (1) an
	 * initial state <code>Init</code>, (2) a state <code>S0</code>, (3) a
	 * transition elaborating <code>INITIALISATION</code> from <code>Init</code>
	 * to <code>S0</code>, (4) an ANY node having a <code>null</code> name.</li>
	 * 
	 * <li><b>Expected result:</b> <i>OK</i>.</li>
	 * </ul>
	 */
	@Test
	public void test_Any_Name_Null() {
		StatemachinesUtils.createAny(domain, SM, null);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.OK);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic);
	}

	/**
	 * Unit test for validation on a root statemachine with an ANY node having
	 * an empty string name.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> containing (1) an
	 * initial state <code>Init</code>, (2) a state <code>S0</code>, (3) a
	 * transition elaborating <code>INITIALISATION</code> from <code>Init</code>
	 * to <code>S0</code>, (4) an ANY node having an empty string name.</li>
	 * 
	 * <li><b>Expected result:</b> <i>OK</i>.</li>
	 * </ul>
	 */
	@Test
	public void test_Any_Name_Empty() {
		StatemachinesUtils.createAny(domain, SM, "");

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.OK);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic);
	}

	/**
	 * Unit test for validation on a root statemachine with an ANY node having
	 * an non-empty string name.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> containing (1) an
	 * initial state <code>Init</code>, (2) a state <code>S0</code>, (3) a
	 * transition elaborating <code>INITIALISATION</code> from <code>Init</code>
	 * to <code>S0</code>, (4) an ANY node <code>Any name</code>.</li>
	 * 
	 * <li><b>Expected result:</b> <i>OK</i>.</li>
	 * </ul>
	 */
	@Test
	public void test_Any_Name_NoneEmpty() {
		StatemachinesUtils.createAny(domain, SM, "Any name");

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.OK);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic);
	}

	/**
	 * Unit test for validation on a root statemachine with two ANY nodes having
	 * the same name.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> containing (1) an
	 * initial state <code>Init</code>, (2) a state <code>S0</code>, (3) a
	 * transition elaborating <code>INITIALISATION</code> from <code>Init</code>
	 * to <code>S0</code>, (4) two ANY nodes <code>Any</code>.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i>: ID Collision for the two ANY nodes<code>Any</code>.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_IDCollision
	 */
	@Test
	public void test_Any_Name_Collision() {
		Any any1 = StatemachinesUtils.createAny(domain, SM, "Any");
		Any any2 = StatemachinesUtils.createAny(domain, SM, "Any");

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_IDCollision(any1, any2, any1.getReference()));
	}

	/**
	 * Unit test for validation on a root statemachine with an ANY node having
	 * no incoming transitions.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> containing (1) an
	 * initial state <code>Init</code>, (2) a state <code>S0</code>, (3) a
	 * transition elaborating <code>INITIALISATION</code> from <code>Init</code>
	 * to <code>S0</code>, (4) an ANY node <code>Any</code>.</li>
	 * 
	 * <li><b>Expected result:</b> <i>OK</i>.</li>
	 * </ul>
	 */
	@Test
	public void test_Any_IncomingTransition_None() {
		StatemachinesUtils.createAny(domain, SM, "Any");

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.OK);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic);
	}

	/**
	 * Unit test for validation on a root statemachine with an ANY node having
	 * an incoming transition with no elaboration.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> containing (1) an
	 * initial state <code>Init</code>, (2) a state <code>S0</code>, (3) a
	 * transition elaborating <code>INITIALISATION</code> from <code>Init</code>
	 * to <code>S0</code>, (4) an ANY node <code>Any</code>, (5) a transition
	 * without elaboration from <code>S0</code> to <code>Any</code> .</li>
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Transition
	 * should not target an Any state</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_Any_IncomingTransition_Single_Elaboration_None() {
		Any any = StatemachinesUtils.createAny(domain, SM, "Any");
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				s0, any);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_TransitionTargetAnyState(transition));
	}

	/**
	 * Unit test for validation on a root statemachine with an ANY node having
	 * an incoming transition with an elaboration.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> containing (1) an
	 * initial state <code>Init</code>, (2) a state <code>S0</code>, (3) a
	 * transition elaborating <code>INITIALISATION</code> from <code>Init</code>
	 * to <code>S0</code>, (4) an ANY node <code>Any</code>, (5) a transition
	 * without elaboration from <code>S0</code> to <code>Any</code> .</li>
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Transition
	 * should not target an Any state</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_Any_IncomingTransition_Single_Elaboration_Single() {
		Any any = StatemachinesUtils.createAny(domain, SM, "Any");
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				s0, any);
		StatemachinesUtils.addElaboration(domain, transition, m0_e);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_TransitionTargetAnyState(transition));
	}

	/**
	 * Unit test for validation on a root statemachine with an ANY node having
	 * an incoming transition with 2 elaborations.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> containing (1) an
	 * initial state <code>Init</code>, (2) a state <code>S0</code>, (3) a
	 * transition elaborating <code>INITIALISATION</code> from <code>Init</code>
	 * to <code>S0</code>, (4) an ANY node <code>Any</code>, (5) a transition
	 * elaborates <code>e</code> and <code>f</code> from <code>S0</code> to
	 * <code>Any</code> .</li>
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Transition
	 * should not target an Any state</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_Any_IncomingTransition_Single_Elaboration_Multiple() {
		Any any = StatemachinesUtils.createAny(domain, SM, "Any");
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				s0, any);
		StatemachinesUtils.addElaboration(domain, transition, m0_e);
		StatemachinesUtils.addElaboration(domain, transition, m0_f);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_TransitionTargetAnyState(transition));
	}

	/**
	 * Unit test for validation on a root statemachine with an ANY node having
	 * multiple incoming transitions.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> containing (1) an
	 * initial state <code>Init</code>, (2) a state <code>S0</code>, (3) a
	 * transition elaborating <code>INITIALISATION</code> from <code>Init</code>
	 * to <code>S0</code>, (4) an ANY node <code>Any</code>, (5) two transitions
	 * elaborating event <code>e</code> from <code>S0</code> to <code>Any</code>
	 * .</li>
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Transition
	 * should not target an Any state</i>'.</li>
	 * 
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Transition
	 * should not target an Any state</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_Any_IncomingTransition_Multiple() {
		Any any = StatemachinesUtils.createAny(domain, SM, "Any");
		Transition transition1 = StatemachinesUtils.createTransition(domain,
				SM, s0, any);
		StatemachinesUtils.addElaboration(domain, transition1, m0_e);

		Transition transition2 = StatemachinesUtils.createTransition(domain,
				SM, s0, any);
		StatemachinesUtils.addElaboration(domain, transition2, m0_e);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_TransitionTargetAnyState(transition1),
				new Error_TransitionTargetAnyState(transition2));
	}

	/**
	 * Unit test for validation on a root statemachine with an ANY node having
	 * no outgoing transition.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> containing (1) an
	 * initial state <code>Init</code>, (2) a state <code>S0</code>, (3) a
	 * transition elaborating <code>INITIALISATION</code> from <code>Init</code>
	 * to <code>S0</code>, (4) an ANY node <code>Any</code>.</li>
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Transition
	 * should not target an Any state</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_Any_OutgoingTransition_None() {
		StatemachinesUtils.createAny(domain, SM, "Any name");

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.OK);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic);
	}

	/**
	 * Unit test for validation on a root statemachine with an ANY node having
	 * an outgoing transition with no elaboration.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> containing (1) an
	 * initial state <code>Init</code>, (2) a state <code>S0</code>, (3) a
	 * transition elaborating <code>INITIALISATION</code> from <code>Init</code>
	 * to <code>S0</code>, (4) an ANY node <code>Any</code>, (5) a transition
	 * with no elaboration from <code>Any</code> to <code>S0</code>.</li>
	 * 
	 * <li><b>Expected result: </b>
	 * <ol>
	 * <li><i>(WARNING)</i> --- Validation fails the constraint '<i>Transition
	 * should elaborate an event</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_Any_OutgoingTransition_Single_Elaboration_None() {
		Any any = StatemachinesUtils.createAny(domain, SM, "Any");
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				any, s0);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.WARNING);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Warning_TransitionMissingElaboration(transition));
	}

	/**
	 * Unit test for validation on a root statemachine with an ANY node having
	 * an outgoing transition with an elaboration.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> containing (1) an
	 * initial state <code>Init</code>, (2) a state <code>S0</code>, (3) a
	 * transition elaborating <code>INITIALISATION</code> from <code>Init</code>
	 * to <code>S0</code>, (4) an ANY node <code>Any</code>, (5) a transition
	 * elaborating <code>e</code> from <code>Any</code> to <code>S0</code>.</li>
	 * 
	 * <li><b>Expected result:</b><i>OK</i>.</li>
	 * </ul>
	 */
	@Test
	public void test_Any_OutgoingTransition_Single_Elaboration_Single() {
		Any any = StatemachinesUtils.createAny(domain, SM, "Any");
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				any, s0);
		StatemachinesUtils.addElaboration(domain, transition, m0_e);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.OK);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic);
	}

	/**
	 * Unit test for validation on a root statemachine with an ANY node having
	 * an outgoing transition with 2 elaborations.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> containing (1) an
	 * initial state <code>Init</code>, (2) a state <code>S0</code>, (3) a
	 * transition elaborating <code>INITIALISATION</code> from <code>Init</code>
	 * to <code>S0</code>, (4) an ANY node <code>Any</code>, (5) a transition
	 * elaborating <code>e</code> and <code>f</code> from <code>Any</code> to
	 * <code>S0</code>.</li>
	 * 
	 * <li><b>Expected result:</b><i>OK</i>.</li>
	 * </ul>
	 */
	@Test
	public void test_Any_OutgoingTransition_Single_Elaboration_Multiple() {
		Any any = StatemachinesUtils.createAny(domain, SM, "Any");
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				any, s0);
		StatemachinesUtils.addElaboration(domain, transition, m0_e);
		StatemachinesUtils.addElaboration(domain, transition, m0_f);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.OK);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic);
	}

	/**
	 * Unit test for validation on a root statemachine with an ANY node having
	 * an outgoing transition with elaboration.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> containing (1) an
	 * initial state <code>Init</code>, (2) a state <code>S0</code>, (3) a
	 * transition elaborating <code>INITIALISATION</code> from <code>Init</code>
	 * to <code>S0</code>, (4) an ANY node <code>Any</code>, (5) a transition
	 * elaborating <code>e</code> from <code>Any</code> to <code>S0</code>.</li>
	 * 
	 * <li><b>Expected result:</b><i>OK</i>.</li>
	 * </ul>
	 */
	@Test
	public void test_Any_OutgoingTransition_Multiple() {
		Any any = StatemachinesUtils.createAny(domain, SM, "Any");
		Transition transition1 = StatemachinesUtils.createTransition(domain,
				SM, any, s0);
		StatemachinesUtils.addElaboration(domain, transition1, m0_e);

		Transition transition2 = StatemachinesUtils.createTransition(domain,
				SM, any, s0);
		StatemachinesUtils.addElaboration(domain, transition2, m0_f);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.OK);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic);
	}

	// =========================================================================
	// (END) Unit tests for ANY node.
	// =========================================================================

}
