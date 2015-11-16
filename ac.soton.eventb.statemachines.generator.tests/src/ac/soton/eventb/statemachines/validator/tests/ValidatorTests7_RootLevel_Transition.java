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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.core.IEvent;
import org.eventb.core.IEventBProject;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBObject;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachinePackage;
import org.eventb.emf.persistence.EMFRodinDB;
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
	 * The event <code>INITIALISATION</code> within <code>m0</code> (created in
	 * the {@link #setUp()} method).
	 */
	private Event m0_init;

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
		m0_init = EventBEMFUtils.createEvent(domain, m0, IEvent.INITIALISATION);
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
	// (BEGIN) Unit tests for transitions.
	// =========================================================================

	/**
	 * Unit test for validation on a root statemachine containing a transition
	 * with <code>null</code> source.
	 * 
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a state
	 * <code>S0</code>, and an incoming transition with a <code>null</code>
	 * source (without elaboration).</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> Required feature '<i>source</i>' must be set.</li>
	 * 
	 * <li><i>(WARNING)</i> Validation fails the constraint '<i>Transition
	 * should elaborate an event</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_FeatureMissing
	 * @see Warning_TransitionMissingElaboration
	 */
	@Test
	public void test_Transition_Source_Null() {
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				null, s0);
		EventBEMFUtils.save(emfRodinDB, m0);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_FeatureMissing(transition,
						StatemachinesPackage.Literals.TRANSITION__SOURCE),
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
	 * <li><i>(ERROR)</i> Feature '<i>source</i>' contains a dangling reference.
	 * </li>
	 * 
	 * <li><i>(WARNING)</i> Validation fails the constraint '<i>Transition
	 * should elaborate an event</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * 
	 * @see Error_FeatureDanglingReference
	 * @see Warning_TransitionMissingElaboration
	 */
	@Test
	public void test_Transition_Source_Dangling() {
		State s1 = StatemachinesFactory.eINSTANCE.createState();
		s1.setName("S1");
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				s1, s0);
		EventBEMFUtils.save(emfRodinDB, m0);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_FeatureDanglingReference(transition,
						StatemachinesPackage.Literals.TRANSITION__SOURCE, s1),
				new Warning_TransitionMissingElaboration(transition));
	}

	/**
	 * Unit test for validation on a root statemachine containing a transition
	 * with an invalid source.
	 * 
	 */
	@Test
	public void test_Transition_Source_Unresolved() {
		State s1 = StatemachinesUtils.createState(domain, SM, "S1", null);
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				s1, s0);
		EventBEMFUtils.save(emfRodinDB, m0);
		InternalEObject e = (InternalEObject) s1;
		URI uri = e.eProxyURI();
		InternalEObject newS1 = (InternalEObject) EcoreUtil.create(s1.eClass());
		newS1.eSetProxyURI(uri);
		EcoreUtil.replace(transition, StatemachinesPackage.Literals.TRANSITION__SOURCE, s1, newS1);
				
		// Remove S1 using another EMFRodinDB
		EMFRodinDB emfRodinDB2 = new EMFRodinDB();
		State loadedS1 = (State) emfRodinDB2.loadElement(EcoreUtil.getURI(s1));
		EventBElement loadedM0 = (EventBElement) loadedS1.getContaining(MachinePackage.Literals.MACHINE);
		StatemachinesUtils.delete(emfRodinDB2.getEditingDomain(), loadedS1);
		EventBEMFUtils.save(emfRodinDB2, loadedM0);

		
		// Reload SM from the original EMFRodinDB.
		SM = (Statemachine) emfRodinDB2.loadElement(EcoreUtil.getURI(SM));

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_FeatureMissing(transition,
						StatemachinesPackage.Literals.TRANSITION__SOURCE),
				new Warning_TransitionMissingElaboration(transition));
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
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				s0, null);
		EventBEMFUtils.save(emfRodinDB, m0);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_FeatureMissing(transition,
						StatemachinesPackage.Literals.TRANSITION__TARGET),
				new Warning_TransitionMissingElaboration(transition));
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
		State s1 = StatemachinesFactory.eINSTANCE.createState();
		s1.setName("S1");
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				s0, s1);
		EventBEMFUtils.save(emfRodinDB, m0);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_FeatureDanglingReference(transition,
						StatemachinesPackage.Literals.TRANSITION__TARGET, s1),
				new Warning_TransitionMissingElaboration(transition));
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
		State s1 = StatemachinesUtils.createState(domain, SM, "S1", null);
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				s0, s1);
		EventBEMFUtils.save(emfRodinDB, m0);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.WARNING);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Warning_TransitionMissingElaboration(transition));
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
		State s1 = StatemachinesUtils.createState(domain, SM, "S1", null);
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				s0, s1);
		StatemachinesUtils.addElaboration(domain, transition, m0_init);
		EventBEMFUtils.save(emfRodinDB, m0);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.ERROR);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic,
				new Error_TransitionElaboratingINITIALISATION(transition));
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
	 * <li><b>Expected result:</b> <i>(OK)</i>.</li>
	 * </ul>
	 */
	@Test
	public void test_Transition_Elaborates_Event() {
		State s1 = StatemachinesUtils.createState(domain, SM, "S1", null);
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				s0, s1);
		StatemachinesUtils.addElaboration(domain, transition, m0_e);
		EventBEMFUtils.save(emfRodinDB, m0);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticSeverity("Incorrect root diagnostic", diagnostic,
				Diagnostic.OK);
		assertDiagnostic("Incorrect sub-diagnostics", diagnostic);

	}

	// =========================================================================
	// (END) Unit tests for transitions.
	// =========================================================================

}
