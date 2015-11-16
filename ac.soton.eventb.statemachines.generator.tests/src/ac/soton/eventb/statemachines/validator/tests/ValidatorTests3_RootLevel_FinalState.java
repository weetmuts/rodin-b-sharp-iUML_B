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
 * state machines' final states.
 * </p>
 *
 * @author htson
 * @version 0.1
 * @see Final
 * @since 0.1
 */
public class ValidatorTests3_RootLevel_FinalState extends
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
	// (BEGIN) Unit tests for final states and final transitions.
	// =========================================================================

	/**
	 * Unit test for validation on a root statemachine containing a final state
	 * with an outgoing transition.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with an final
	 * state <code>Final</code>.</li>
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Root
	 * statemachine should have initial state</i>'.</li>
	 * <li><i>(WARNING)</i> --- Validation fails the constraint '<i>Final state
	 * should have an incoming transition</i>'.</li>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Transition
	 * cannot go from final state</i>'.</li>
	 * <li><i>(WARNING)</i> --- Validation fails the constraint '<i>Transition
	 * should elaborate an event</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Warning_FinalStateMandatoryIncomingTransition
	 */
	@Test
	public void test_finalState_NoIncomingTransition() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Final finalState = StatemachinesUtils.createFinalState(domain, SM,
				"Final");

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.WARNING);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Warning_FinalStateMissingIncomingTransition(finalState));
	}

	/**
	 * Unit test for validation on a root statemachine containing a final state
	 * with an outgoing transition.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with an final
	 * state <code>Final</code> and an outgoing transition (no elaboration).</li>
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Root
	 * statemachine should have initial state</i>'.</li>
	 * <li><i>(WARNING)</i> --- Validation fails the constraint '<i>Final state
	 * should have an incoming transition</i>'.</li>
	 * <li><i>(ERROR)</i> --- Validation fails the constraint '<i>Transition
	 * cannot go from final state</i>'.</li>
	 * <li><i>(WARNING)</i> --- Validation fails the constraint '<i>Transition
	 * should elaborate an event</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_finalState_OutgoingTransition() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Final finalState = StatemachinesUtils.createFinalState(domain, SM,
				"Final");

		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				finalState, s0);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Warning_FinalStateMissingIncomingTransition(finalState),
				new Error_TransitionOriginFinalState(transition),
				new Warning_TransitionMissingElaboration(transition));
	}

	// =========================================================================
	// (END) Unit tests for final states and final transitions.
	// =========================================================================

}
