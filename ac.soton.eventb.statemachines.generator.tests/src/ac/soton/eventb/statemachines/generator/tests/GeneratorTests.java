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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eventb.core.IEvent;
import org.eventb.core.IEventBProject;
import org.eventb.emf.core.context.CarrierSet;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.persistence.EMFRodinDB;
import org.eventb.emf.persistence.EventBEMFUtils;
import org.eventb.emf.persistence.tests.AbstractEventBEMFTests;
import org.junit.Test;
import org.rodinp.core.IRodinFile;
import org.rodinp.core.RodinDBException;

import ac.soton.eventb.emf.diagrams.generator.command.GenerateCommand;
import ac.soton.eventb.statemachines.Initial;
import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachinesUtils;
import ac.soton.eventb.statemachines.Transition;
import ac.soton.eventb.statemachines.TranslationKind;
import ch.ethz.eventb.utils.EventBUtils;

/**
 * <p>
 *
 * </p>
 *
 * @author htson
 * @version
 * @see
 * @since
 */
public class GeneratorTests extends AbstractEventBEMFTests {

	private Machine m0;

	private IEventBProject prj;

	private Event m0_init;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.ethz.eventb.utils.tests.AbstractEventBTests#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		emfRodinDB = new EMFRodinDB();
		prj = EventBUtils.createEventBProject("P", nullMonitor);
		m0 = EventBEMFUtils.createMachine(emfRodinDB, prj, "m0");
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		m0_init = EventBEMFUtils.createEvent(domain, m0, IEvent.INITIALISATION);
		EventBEMFUtils.save(emfRodinDB, m0);
	}

	@Test
	public void testGeneratorSinglevarInitTransitionInitialisation() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, null, "", TranslationKind.SINGLEVAR);
		Initial initialState = StatemachinesUtils.createInitialState(domain,
				SM, "");
		State s0 = StatemachinesUtils.createState(domain, SM, "S0", null);
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				initialState, s0);
		StatemachinesUtils.addElaboration(domain, transition, m0_init);
		EventBEMFUtils.save(emfRodinDB, m0);

		GenerateCommand generateCommand = new GenerateCommand(domain, SM);
		assertTrue("Generate command must be executable",
				generateCommand.canExecute());
		try {
			IStatus status = generateCommand.execute(new NullProgressMonitor(),
					null);
			assertTrue("The status should be OK", status.isOK());

			// Test the generated context.
			IRodinFile contextFile = prj.getContextFile("m0_implicitContext");
			assertTrue("Context should not exist", contextFile.exists());
			Context m0ImplicitContext = (Context) emfRodinDB
					.loadElement(contextFile.getRoot());
			testContextExtendsClauses(
					"m0_implictContext should not extend any contexts",
					m0ImplicitContext);
			testContextCarrierSets("Incorrect m0_implictContext carrier sets",
					m0ImplicitContext, "SM_STATES");
			testContextConstants("Incorrect m0_implictContext constants",
					m0ImplicitContext, "S0");
			testContextAxioms(
					"m0_implictContext should not contain any axioms",
					m0ImplicitContext, "typeof_S0:S0 ∈ SM_STATES:false",
					"distinct_states_in_SM_STATES: partition(SM_STATES, {S0}):false");

			// Test the generated machine.
			testMachineRefinesClauses("m0 should not refine any machines", m0);
			testMachineSeesClauses("Incorrect m0's sees contexts", m0,
					"m0_implicitContext");
			testMachineVariables("Incorrect m0's variables", m0, "SM");
			testMachineInvariants("Incorrect m0's invariants", m0,
					"typeof_SM:SM ∈ SM_STATES:false");
			testMachineVariants("m0 should not contain any variants", m0);

			testMachineEvents("Incorrect events", m0,
					"INITIALISATION:ordinary:false");
			testEventParameters("Incorrect event's parameters", m0_init);
			testEventGuards("Incorrect event's guards", m0_init);
			testEventWitnesses("Incorrect event's witnesses", m0_init);
			testEventActions("Incorrect event's actions", m0_init,
					"init_SM:SM ≔ S0");
		} catch (ExecutionException e) {
			failUnexpectedException(e);
		}
	}

	@Test
	public void testGeneratorMultivarInitTransitionInitialisation() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, null, "", TranslationKind.MULTIVAR);
		Initial initialState = StatemachinesUtils.createInitialState(domain,
				SM, "");
		State s0 = StatemachinesUtils.createState(domain, SM, "S0", null);
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				initialState, s0);
		StatemachinesUtils.addElaboration(domain, transition, m0_init);
		EventBEMFUtils.save(emfRodinDB, m0);

		GenerateCommand generateCommand = new GenerateCommand(domain, SM);
		assertTrue("Generate command must be executable",
				generateCommand.canExecute());
		try {
			IStatus status = generateCommand.execute(new NullProgressMonitor(),
					null);
			assertTrue("The status should be OK", status.isOK());

			// There should not be any generated context.
			IRodinFile contextFile = prj.getContextFile("m0_implicitContext");
			assertFalse("Context should not exist", contextFile.exists());

			// Test the generated machine.
			testMachineRefinesClauses("m0 should not refine any machines", m0);
			testMachineSeesClauses("m0 should not see any contexts", m0);
			testMachineVariables("Incorrect variables", m0, "S0");
			testMachineInvariants("Incorrect m0's invariants", m0,
					"typeof_S0:S0 ∈ BOOL:false");
			testMachineVariants("m0 should not contain any variants", m0);

			testMachineEvents("Incorrect events", m0,
					"INITIALISATION:ordinary:false");
			testEventParameters("Incorrect event's parameters", m0_init);
			testEventGuards("Incorrect event's guards", m0_init);
			testEventWitnesses("Incorrect event's witnesses", m0_init);
			testEventActions("Incorrect event's actions", m0_init,
					"init_S0:S0 ≔ TRUE");
		} catch (ExecutionException e) {
			failUnexpectedException(e);
		}
	}

	@Test
	public void testGeneratorSinglevarInstancesInitTransitionInitialisation() {
		Context ctx;
		try {
			ctx = EventBEMFUtils.createContext(emfRodinDB, prj, "c0");
		} catch (RodinDBException e) {
			failUnexpectedException(e);
			return;
		}
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		CarrierSet setINSTANCE = EventBEMFUtils.createCarrierSet(domain, ctx,
				"INSTANCE");
		EventBEMFUtils.save(emfRodinDB, ctx);
		EventBEMFUtils.createSeesContextClause(domain, m0, "c0");

		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, setINSTANCE, "i", TranslationKind.SINGLEVAR);
		Initial initialState = StatemachinesUtils.createInitialState(domain,
				SM, "");
		State s0 = StatemachinesUtils.createState(domain, SM, "S0", null);
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				initialState, s0);
		StatemachinesUtils.addElaboration(domain, transition, m0_init);
		EventBEMFUtils.save(emfRodinDB, m0);

		GenerateCommand generateCommand = new GenerateCommand(domain, SM);
		assertTrue("Generate command must be executable",
				generateCommand.canExecute());
		try {
			IStatus status = generateCommand.execute(new NullProgressMonitor(),
					null);
			assertTrue("The status should be OK", status.isOK());

			// Test the generated context.
			IRodinFile contextFile = prj.getContextFile("m0_implicitContext");
			assertTrue("Context should not exist", contextFile.exists());
			Context m0ImplicitContext = (Context) emfRodinDB
					.loadElement(contextFile.getRoot());
			testContextExtendsClauses(
					"m0_implictContext should not extend any contexts",
					m0ImplicitContext);
			testContextCarrierSets("Incorrect m0_implictContext carrier sets",
					m0ImplicitContext, "SM_STATES");
			testContextConstants("Incorrect m0_implictContext constants",
					m0ImplicitContext, "S0");
			testContextAxioms(
					"m0_implictContext should not contain any axioms",
					m0ImplicitContext, "typeof_S0:S0 ∈ SM_STATES:false",
					"distinct_states_in_SM_STATES: partition(SM_STATES, {S0}):false");

			// Test the generated machine.
			testMachineRefinesClauses("m0 should not refine any machines", m0);
			testMachineSeesClauses("Incorrect m0's sees contexts", m0,
					"m0_implicitContext", "c0");
			testMachineVariables("Incorrect m0's variables", m0, "SM");
			testMachineInvariants("Incorrect m0's invariants", m0,
					"typeof_SM:SM ∈ INSTANCE → SM_STATES:false");
			testMachineVariants("m0 should not contain any variants", m0);

			testMachineEvents("Incorrect events", m0,
					"INITIALISATION:ordinary:false");
			testEventParameters("Incorrect event's parameters", m0_init);
			testEventGuards("Incorrect event's guards", m0_init);
			testEventWitnesses("Incorrect event's witnesses", m0_init);
			testEventActions("Incorrect event's actions", m0_init,
					"init_SM:SM ≔ INSTANCE × {S0}");
		} catch (ExecutionException e) {
			failUnexpectedException(e);
		}
	}

	@Test
	public void testGeneratorMultivarInstancesInitTransitionInitialisation() {
		Context ctx;
		try {
			ctx = EventBEMFUtils.createContext(emfRodinDB, prj, "c0");
		} catch (RodinDBException e) {
			failUnexpectedException(e);
			return;
		}
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		CarrierSet setINSTANCE = EventBEMFUtils.createCarrierSet(domain, ctx,
				"INSTANCE");
		EventBEMFUtils.save(emfRodinDB, ctx);
		EventBEMFUtils.createSeesContextClause(domain, m0, "c0");

		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, setINSTANCE, "i", TranslationKind.MULTIVAR);
		Initial initialState = StatemachinesUtils.createInitialState(domain,
				SM, "");
		State s0 = StatemachinesUtils.createState(domain, SM, "S0", null);
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				initialState, s0);
		StatemachinesUtils.addElaboration(domain, transition, m0_init);
		EventBEMFUtils.save(emfRodinDB, m0);

		GenerateCommand generateCommand = new GenerateCommand(domain, SM);
		assertTrue("Generate command must be executable",
				generateCommand.canExecute());
		try {
			IStatus status = generateCommand.execute(new NullProgressMonitor(),
					null);
			assertTrue("The status should be OK", status.isOK());

			// There should not be any generated context.
			IRodinFile contextFile = prj.getContextFile("m0_implicitContext");
			assertFalse("Context should not exist", contextFile.exists());

			// Test the generated machine.
			testMachineRefinesClauses("m0 should not refine any machines", m0);
			testMachineSeesClauses("Incorrect m0's sees contexts", m0, "c0");
			testMachineVariables("Incorrect variables", m0, "S0");
			testMachineInvariants("Incorrect m0's invariants", m0,
					"typeof_S0:S0 ⊆ INSTANCE:false");
			testMachineVariants("m0 should not contain any variants", m0);

			testMachineEvents("Incorrect events", m0,
					"INITIALISATION:ordinary:false");
			testEventParameters("Incorrect event's parameters", m0_init);
			testEventGuards("Incorrect event's guards", m0_init);
			testEventWitnesses("Incorrect event's witnesses", m0_init);
			testEventActions("Incorrect event's actions", m0_init,
					"init_S0:S0 ≔ INSTANCE");
		} catch (ExecutionException e) {
			failUnexpectedException(e);
		}
	}

	// @Test
	// public void testGeneratorSinglevarInitTransitionEvent() {
	// TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
	// Event m0_e = EventBEMFUtils.createEvent(domain, m0, "e");
	// EventBEMFUtils.save(emfRodinDB, m0);
	//
	// Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
	// null, "SM", null, null, "", TranslationKind.SINGLEVAR);
	// Initial initialState = StatemachinesUtils.createInitialState(domain,
	// SM, "");
	// State s0 = StatemachinesUtils.createState(domain, SM, "S0", null);
	// Transition transition = StatemachinesUtils.createTransition(domain, SM,
	// initialState, s0);
	// StatemachinesUtils.addElaboration(domain, transition, m0_e);
	// EventBEMFUtils.save(emfRodinDB, m0);
	//
	// GenerateCommand generateCommand = new GenerateCommand(domain, SM);
	// assertTrue("Generate command must be executable",
	// generateCommand.canExecute());
	// try {
	// IStatus status = generateCommand.execute(new NullProgressMonitor(),
	// null);
	// assertTrue("The status should be OK", status.isOK());
	//
	// // Test the generated context.
	// IRodinFile contextFile = prj.getContextFile("m0_implicitContext");
	// assertTrue("Context should not exist", contextFile.exists());
	// Context m0ImplicitContext = (Context) emfRodinDB
	// .loadElement(contextFile.getRoot());
	// testContextExtendsClauses(
	// "m0_implictContext should not extend any contexts",
	// m0ImplicitContext);
	// testContextCarrierSets("Incorrect m0_implictContext carrier sets",
	// m0ImplicitContext, "SM_STATES");
	// testContextConstants("Incorrect m0_implictContext constants",
	// m0ImplicitContext, "S0");
	// testContextAxioms(
	// "m0_implictContext should not contain any axioms",
	// m0ImplicitContext, "typeof_S0:S0 ∈ SM_STATES:false",
	// "typeof_SM_NULL:SM_NULL ∈ SM_STATES:false",
	// "distinct_states_in_SM_STATES: partition(SM_STATES, {SM_NULL}, {S0}):false");
	//
	// // Test the generated machine.
	// testMachineRefinesClauses("m0 should not refine any machines", m0);
	// testMachineSeesClauses("Incorrect m0's sees contexts", m0,
	// "m0_implicitContext");
	// testMachineVariables("Incorrect m0's variables", m0, "SM");
	// testMachineInvariants("Incorrect m0's invariants", m0,
	// "typeof_SM:SM ∈ SM_STATES:false");
	// testMachineVariants("m0 should not contain any variants", m0);
	//
	// testMachineEvents("Incorrect events", m0,
	// "INITIALISATION:ordinary:false", "e:ordinary:false");
	//
	// testEventParameters("Incorrect event's parameters", m0_init);
	// testEventGuards("Incorrect event's guards", m0_init);
	// testEventWitnesses("Incorrect event's witnesses", m0_init);
	// testEventActions("Incorrect event's actions", m0_init,
	// "init_SM:SM ≔ SM_NULL");
	//
	// testEventParameters("Incorrect event's parameters", m0_e);
	// testEventGuards("Incorrect event's guards", m0_e,
	// "at_SM_NULL:SM = SM_NULL:false");
	// testEventWitnesses("Incorrect event's witnesses", m0_e);
	// testEventActions("Incorrect event's actions", m0_e,
	// "enter_S0:SM ≔ S0");
	// } catch (ExecutionException e) {
	// failUnexpectedException(e);
	// }
	// }
	//
	// @Test
	// public void testGeneratorMultivarInitTransitionEvent() {
	// TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
	// Event m0_e = EventBEMFUtils.createEvent(domain, m0, "e");
	// EventBEMFUtils.save(emfRodinDB, m0);
	//
	// Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
	// null, "SM", null, null, "", TranslationKind.MULTIVAR);
	// Initial initialState = StatemachinesUtils.createInitialState(domain,
	// SM, "");
	// State s0 = StatemachinesUtils.createState(domain, SM, "S0", null);
	// Transition transition = StatemachinesUtils.createTransition(domain, SM,
	// initialState, s0);
	// StatemachinesUtils.addElaboration(domain, transition, m0_e);
	// EventBEMFUtils.save(emfRodinDB, m0);
	//
	// GenerateCommand generateCommand = new GenerateCommand(domain, SM);
	// assertTrue("Generate command must be executable",
	// generateCommand.canExecute());
	// try {
	// IStatus status = generateCommand.execute(new NullProgressMonitor(),
	// null);
	// assertTrue("The status should be OK", status.isOK());
	//
	// // There should not be any generated context.
	// IRodinFile contextFile = prj.getContextFile("m0_implicitContext");
	// assertFalse("Context should not exist", contextFile.exists());
	//
	// // Test the generated machine.
	// testMachineRefinesClauses("m0 should not refine any machines", m0);
	// testMachineSeesClauses("m0 should not see any contexts", m0);
	// testMachineVariables("Incorrect variables", m0, "S0");
	// testMachineInvariants("Incorrect m0's invariants", m0,
	// "typeof_S0:S0 ∈ BOOL:false");
	// testMachineVariants("m0 should not contain any variants", m0);
	//
	// testMachineEvents("Incorrect events", m0,
	// "INITIALISATION:ordinary:false", "e:ordinary:false");
	//
	// testEventParameters("Incorrect event's parameters", m0_init);
	// testEventGuards("Incorrect event's guards", m0_init);
	// testEventWitnesses("Incorrect event's witnesses", m0_init);
	// testEventActions("Incorrect event's actions", m0_init,
	// "init_S0:S0 ≔ FALSE");
	//
	// testEventParameters("Incorrect event's parameters", m0_e);
	// testEventGuards("Incorrect event's guards", m0_e,
	// "grd1:S0 = FALSE:false");
	// testEventWitnesses("Incorrect event's witnesses", m0_e);
	// testEventActions("Incorrect event's actions", m0_e,
	// "enter_S0:S0 ≔ TRUE");
	// } catch (ExecutionException e) {
	// failUnexpectedException(e);
	// }
	// }
	//
	// @Test
	// public void testGeneratorSinglevarInitTransitionEventInstances() {
	// Context ctx;
	// try {
	// ctx = EventBEMFUtils.createContext(emfRodinDB, prj, "c0");
	// } catch (RodinDBException e) {
	// failUnexpectedException(e);
	// return;
	// }
	// TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
	// CarrierSet setINSTANCE = EventBEMFUtils.createCarrierSet(domain, ctx,
	// "INSTANCE");
	// EventBEMFUtils.save(emfRodinDB, ctx);
	//
	// Event m0_e = EventBEMFUtils.createEvent(domain, m0, "e");
	// EventBEMFUtils.createSeesContextClause(domain, m0, "c0");
	// EventBEMFUtils.save(emfRodinDB, m0);
	//
	// Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
	// null, "SM", null, setINSTANCE, "i", TranslationKind.SINGLEVAR);
	// Initial initialState = StatemachinesUtils.createInitialState(domain,
	// SM, "");
	// State s0 = StatemachinesUtils.createState(domain, SM, "S0", null);
	// Transition transition = StatemachinesUtils.createTransition(domain, SM,
	// initialState, s0);
	// StatemachinesUtils.addElaboration(domain, transition, m0_e);
	// EventBEMFUtils.save(emfRodinDB, m0);
	//
	// GenerateCommand generateCommand = new GenerateCommand(domain, SM);
	// assertTrue("Generate command must be executable",
	// generateCommand.canExecute());
	// try {
	// IStatus status = generateCommand.execute(new NullProgressMonitor(),
	// null);
	// assertTrue("The status should be OK", status.isOK());
	//
	// // Test the generated context.
	// IRodinFile contextFile = prj.getContextFile("m0_implicitContext");
	// assertTrue("Context should not exist", contextFile.exists());
	// Context m0ImplicitContext = (Context) emfRodinDB
	// .loadElement(contextFile.getRoot());
	// testContextExtendsClauses(
	// "m0_implictContext should not extend any contexts",
	// m0ImplicitContext);
	// testContextCarrierSets("Incorrect m0_implictContext carrier sets",
	// m0ImplicitContext, "SM_STATES");
	// testContextConstants("Incorrect m0_implictContext constants",
	// m0ImplicitContext, "SM_NULL", "S0");
	// testContextAxioms(
	// "m0_implictContext should not contain any axioms",
	// m0ImplicitContext, "typeof_S0:S0 ∈ SM_STATES:false",
	// "typeof_SM_NULL:SM_NULL ∈ SM_STATES:false",
	// "distinct_states_in_SM_STATES: partition(SM_STATES, {SM_NULL}, {S0}):false");
	//
	// // Test the generated machine.
	// testMachineRefinesClauses("m0 should not refine any machines", m0);
	// testMachineSeesClauses("Incorrect m0's sees contexts", m0,
	// "m0_implicitContext", "c0");
	// testMachineVariables("Incorrect m0's variables", m0, "SM");
	// testMachineInvariants("Incorrect m0's invariants", m0,
	// "typeof_SM:SM ∈ INSTANCE → SM_STATES:false");
	// testMachineVariants("m0 should not contain any variants", m0);
	//
	// testMachineEvents("Incorrect events", m0,
	// "INITIALISATION:ordinary:false", "e:ordinary:false");
	//
	// testEventParameters("Incorrect event's parameters", m0_init);
	// testEventGuards("Incorrect event's guards", m0_init);
	// testEventWitnesses("Incorrect event's witnesses", m0_init);
	// testEventActions("Incorrect event's actions", m0_init,
	// "init_SM:SM ≔ INSTANCE × {SM_NULL}");
	//
	// testEventParameters("Incorrect event's parameters", m0_e, "i");
	// testEventGuards("Incorrect event's guards", m0_e,
	// "at_SM_NULL:SM(i) = SM_NULL:false");
	// testEventWitnesses("Incorrect event's witnesses", m0_e);
	// testEventActions("Incorrect event's actions", m0_e,
	// "enter_S0:SM(i) ≔ S0");
	// } catch (ExecutionException e) {
	// failUnexpectedException(e);
	// }
	// }
	//
	// @Test
	// public void testGeneratorMultivarInitTransitionEventInstances() {
	// Context ctx;
	// try {
	// ctx = EventBEMFUtils.createContext(emfRodinDB, prj, "c0");
	// } catch (RodinDBException e) {
	// failUnexpectedException(e);
	// return;
	// }
	// TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
	// CarrierSet setINSTANCE = EventBEMFUtils.createCarrierSet(domain, ctx,
	// "INSTANCE");
	// EventBEMFUtils.save(emfRodinDB, ctx);
	// Event m0_e = EventBEMFUtils.createEvent(domain, m0, "e");
	// EventBEMFUtils.createSeesContextClause(domain, m0, "c0");
	// EventBEMFUtils.save(emfRodinDB, m0);
	//
	// Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
	// null, "SM", null, setINSTANCE, "i", TranslationKind.MULTIVAR);
	// Initial initialState = StatemachinesUtils.createInitialState(domain,
	// SM, "");
	// State s0 = StatemachinesUtils.createState(domain, SM, "S0", null);
	// Transition transition = StatemachinesUtils.createTransition(domain, SM,
	// initialState, s0);
	// StatemachinesUtils.addElaboration(domain, transition, m0_e);
	// EventBEMFUtils.save(emfRodinDB, m0);
	//
	// GenerateCommand generateCommand = new GenerateCommand(domain, SM);
	// assertTrue("Generate command must be executable",
	// generateCommand.canExecute());
	// try {
	// IStatus status = generateCommand.execute(new NullProgressMonitor(),
	// null);
	// assertTrue("The status should be OK", status.isOK());
	//
	// // There should not be any generated context.
	// IRodinFile contextFile = prj.getContextFile("m0_implicitContext");
	// assertFalse("Context should not exist", contextFile.exists());
	//
	// // Test the generated machine.
	// testMachineRefinesClauses("m0 should not refine any machines", m0);
	// testMachineSeesClauses("Incorrect m0's sees contexts", m0, "c0");
	// testMachineVariables("Incorrect variables", m0, "S0");
	// testMachineInvariants("Incorrect m0's invariants", m0,
	// "typeof_S0:S0 ⊆ INSTANCE:false");
	// testMachineVariants("m0 should not contain any variants", m0);
	//
	// testMachineEvents("Incorrect events", m0,
	// "INITIALISATION:ordinary:false");
	// testEventParameters("Incorrect event's parameters", m0_init);
	// testEventGuards("Incorrect event's guards", m0_init);
	// testEventWitnesses("Incorrect event's witnesses", m0_init);
	// testEventActions("Incorrect event's actions", m0_init,
	// "init_S0:S0 ≔ ∅");
	//
	// testEventParameters("Incorrect event's parameters", m0_e, "i");
	// testEventGuards("Incorrect event's guards", m0_e,
	// "not_at_S0:i ∉ S0:false");
	// testEventWitnesses("Incorrect event's witnesses", m0_e);
	// testEventActions("Incorrect event's actions", m0_e,
	// "enter_S0:S0 ≔ S0 ∪ {i}");
	// } catch (ExecutionException e) {
	// failUnexpectedException(e);
	// }
	// }

	@Test
	public void testGeneratorSinglevarTransitionEvent() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Event m0_e = EventBEMFUtils.createEvent(domain, m0, "e");

		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, null, "", TranslationKind.SINGLEVAR);
		Initial initialState = StatemachinesUtils.createInitialState(domain,
				SM, "");
		State s0 = StatemachinesUtils.createState(domain, SM, "S0", null);
		State s1 = StatemachinesUtils.createState(domain, SM, "S1", null);
		Transition initTransition = StatemachinesUtils.createTransition(domain,
				SM, initialState, s0);
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				s0, s1);
		StatemachinesUtils.addElaboration(domain, initTransition, m0_init);
		StatemachinesUtils.addElaboration(domain, transition, m0_e);
		EventBEMFUtils.save(emfRodinDB, m0);

		GenerateCommand generateCommand = new GenerateCommand(domain, SM);
		assertTrue("Generate command must be executable",
				generateCommand.canExecute());
		try {
			IStatus status = generateCommand.execute(new NullProgressMonitor(),
					null);
			assertTrue("The status should be OK", status.isOK());

			// Test the generated context.
			IRodinFile contextFile = prj.getContextFile("m0_implicitContext");
			assertTrue("Context should not exist", contextFile.exists());
			Context m0ImplicitContext = (Context) emfRodinDB
					.loadElement(contextFile.getRoot());
			testContextExtendsClauses(
					"m0_implictContext should not extend any contexts",
					m0ImplicitContext);
			testContextCarrierSets("Incorrect m0_implictContext carrier sets",
					m0ImplicitContext, "SM_STATES");
			testContextConstants("Incorrect m0_implictContext constants",
					m0ImplicitContext, "S1", "S0");
			testContextAxioms("Incorrect m0_implictContext's axioms",
					m0ImplicitContext, "typeof_S1:S1 ∈ SM_STATES:false",
					"typeof_S0:S0 ∈ SM_STATES:false",
					"distinct_states_in_SM_STATES: partition(SM_STATES, {S0}, {S1}):false");

			// Test the generated machine.
			testMachineRefinesClauses("m0 should not refine any machines", m0);
			testMachineSeesClauses("Incorrect m0's sees contexts", m0,
					"m0_implicitContext");
			testMachineVariables("Incorrect m0's variables", m0, "SM");
			testMachineInvariants("Incorrect m0's invariants", m0,
					"typeof_SM:SM ∈ SM_STATES:false");
			testMachineVariants("m0 should not contain any variants", m0);

			testMachineEvents("Incorrect events", m0,
					"INITIALISATION:ordinary:false", "e:ordinary:false");

			testEventParameters("Incorrect event's parameters", m0_init);
			testEventGuards("Incorrect event's guards", m0_init);
			testEventWitnesses("Incorrect event's witnesses", m0_init);
			testEventActions("Incorrect event's actions", m0_init,
					"init_SM:SM ≔ S0");

			testEventParameters("Incorrect event's parameters", m0_e);
			testEventGuards("Incorrect event's guards", m0_e,
					"isin_S0:SM = S0:false");
			testEventWitnesses("Incorrect event's witnesses", m0_e);
			testEventActions("Incorrect event's actions", m0_e,
					"enter_S1:SM ≔ S1");

		} catch (ExecutionException e) {
			failUnexpectedException(e);
		}
	}

	@Test
	public void testGeneratorMultivarTransitionEvent() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Event m0_e = EventBEMFUtils.createEvent(domain, m0, "e");
		EventBEMFUtils.save(emfRodinDB, m0);

		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, null, "", TranslationKind.MULTIVAR);
		Initial initialState = StatemachinesUtils.createInitialState(domain,
				SM, "");
		State s0 = StatemachinesUtils.createState(domain, SM, "S0", null);
		State s1 = StatemachinesUtils.createState(domain, SM, "S1", null);
		Transition initTransition = StatemachinesUtils.createTransition(domain,
				SM, initialState, s0);
		StatemachinesUtils.addElaboration(domain, initTransition, m0_init);
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				s0, s1);
		StatemachinesUtils.addElaboration(domain, transition, m0_e);
		EventBEMFUtils.save(emfRodinDB, m0);

		GenerateCommand generateCommand = new GenerateCommand(domain, SM);
		assertTrue("Generate command must be executable",
				generateCommand.canExecute());
		try {
			IStatus status = generateCommand.execute(new NullProgressMonitor(),
					null);
			assertTrue("The status should be OK", status.isOK());

			// There should not be any generated context.
			IRodinFile contextFile = prj.getContextFile("m0_implicitContext");
			assertFalse("Context should not exist", contextFile.exists());

			// Test the generated machine.
			testMachineRefinesClauses("m0 should not refine any machines", m0);
			testMachineSeesClauses("m0 should not see any contexts", m0);
			testMachineVariables("Incorrect variables", m0, "S1", "S0");
			testMachineInvariants("Incorrect m0's invariants", m0,
					"typeof_S1:S1 ∈ BOOL:false", "typeof_S0:S0 ∈ BOOL:false",
					"distinct_states_in_SM:partition({TRUE}, {S0} ∩ {TRUE}, {S1} ∩ {TRUE}):false");
			testMachineVariants("m0 should not contain any variants", m0);

			testMachineEvents("Incorrect events", m0,
					"INITIALISATION:ordinary:false", "e:ordinary:false");

			testEventParameters("Incorrect event's parameters", m0_init);
			testEventGuards("Incorrect event's guards", m0_init);
			testEventWitnesses("Incorrect event's witnesses", m0_init);
			testEventActions("Incorrect event's actions", m0_init,
					"init_S0:S0 ≔ TRUE", "init_S1:S1 ≔ FALSE");

			testEventParameters("Incorrect event's parameters", m0_e);
			testEventGuards("Incorrect event's guards", m0_e,
					"isin_S0:S0 = TRUE:false");
			testEventWitnesses("Incorrect event's witnesses", m0_e);
			testEventActions("Incorrect event's actions", m0_e,
					"leave_S0:S0 ≔ FALSE", "enter_S1:S1 ≔ TRUE");
		} catch (ExecutionException e) {
			failUnexpectedException(e);
		}
	}

	@Test
	public void testGeneratorSinglevarInstancesTransitionEvent() {
		Context ctx;
		try {
			ctx = EventBEMFUtils.createContext(emfRodinDB, prj, "c0");
		} catch (RodinDBException e) {
			failUnexpectedException(e);
			return;
		}
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		CarrierSet setINSTANCE = EventBEMFUtils.createCarrierSet(domain, ctx,
				"INSTANCE");
		EventBEMFUtils.save(emfRodinDB, ctx);

		Event m0_e = EventBEMFUtils.createEvent(domain, m0, "e");
		EventBEMFUtils.createSeesContextClause(domain, m0, "c0");
		EventBEMFUtils.save(emfRodinDB, m0);

		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, setINSTANCE, "i", TranslationKind.SINGLEVAR);
		Initial initialState = StatemachinesUtils.createInitialState(domain,
				SM, "");
		State s0 = StatemachinesUtils.createState(domain, SM, "S0", null);
		State s1 = StatemachinesUtils.createState(domain, SM, "S1", null);
		Transition initTransition = StatemachinesUtils.createTransition(domain,
				SM, initialState, s0);
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				s0, s1);
		StatemachinesUtils.addElaboration(domain, initTransition, m0_init);
		StatemachinesUtils.addElaboration(domain, transition, m0_e);
		EventBEMFUtils.save(emfRodinDB, m0);

		GenerateCommand generateCommand = new GenerateCommand(domain, SM);
		assertTrue("Generate command must be executable",
				generateCommand.canExecute());
		try {
			IStatus status = generateCommand.execute(new NullProgressMonitor(),
					null);
			assertTrue("The status should be OK", status.isOK());

			// Test the generated context.
			IRodinFile contextFile = prj.getContextFile("m0_implicitContext");
			assertTrue("Context should not exist", contextFile.exists());
			Context m0ImplicitContext = (Context) emfRodinDB
					.loadElement(contextFile.getRoot());
			testContextExtendsClauses(
					"m0_implictContext should not extend any contexts",
					m0ImplicitContext);
			testContextCarrierSets("Incorrect m0_implictContext carrier sets",
					m0ImplicitContext, "SM_STATES");
			testContextConstants("Incorrect m0_implictContext constants",
					m0ImplicitContext, "S1", "S0");
			testContextAxioms(
					"m0_implictContext should not contain any axioms",
					m0ImplicitContext, "typeof_S1:S1 ∈ SM_STATES:false",
					"typeof_S0:S0 ∈ SM_STATES:false",
					"distinct_states_in_SM_STATES: partition(SM_STATES, {S0}, {S1}):false");

			// Test the generated machine.
			testMachineRefinesClauses("m0 should not refine any machines", m0);
			testMachineSeesClauses("Incorrect m0's sees contexts", m0,
					"m0_implicitContext", "c0");
			testMachineVariables("Incorrect m0's variables", m0, "SM");
			testMachineInvariants("Incorrect m0's invariants", m0,
					"typeof_SM:SM ∈ INSTANCE → SM_STATES:false");
			testMachineVariants("m0 should not contain any variants", m0);

			testMachineEvents("Incorrect events", m0,
					"INITIALISATION:ordinary:false", "e:ordinary:false");

			testEventParameters("Incorrect event's parameters", m0_init);
			testEventGuards("Incorrect event's guards", m0_init);
			testEventWitnesses("Incorrect event's witnesses", m0_init);
			testEventActions("Incorrect event's actions", m0_init,
					"init_SM:SM ≔ INSTANCE × {S0}");

			testEventParameters("Incorrect event's parameters", m0_e, "i");
			testEventGuards("Incorrect event's guards", m0_e,
					"isin_S0:SM(i) = S0:false");
			testEventWitnesses("Incorrect event's witnesses", m0_e);
			testEventActions("Incorrect event's actions", m0_e,
					"enter_S1:SM(i) ≔ S1");
		} catch (ExecutionException e) {
			failUnexpectedException(e);
		}
	}

	@Test
	public void testGeneratorMultivarInstancesTransitionEvent() {
		Context ctx;
		try {
			ctx = EventBEMFUtils.createContext(emfRodinDB, prj, "c0");
		} catch (RodinDBException e) {
			failUnexpectedException(e);
			return;
		}
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		CarrierSet setINSTANCE = EventBEMFUtils.createCarrierSet(domain, ctx,
				"INSTANCE");
		EventBEMFUtils.save(emfRodinDB, ctx);
		Event m0_e = EventBEMFUtils.createEvent(domain, m0, "e");
		EventBEMFUtils.createSeesContextClause(domain, m0, "c0");
		EventBEMFUtils.save(emfRodinDB, m0);

		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, setINSTANCE, "i", TranslationKind.MULTIVAR);
		Initial initialState = StatemachinesUtils.createInitialState(domain,
				SM, "");
		State s0 = StatemachinesUtils.createState(domain, SM, "S0", null);
		State s1 = StatemachinesUtils.createState(domain, SM, "S1", null);
		Transition initTransition = StatemachinesUtils.createTransition(domain,
				SM, initialState, s0);
		Transition transition = StatemachinesUtils.createTransition(domain, SM,
				s0, s1);
		StatemachinesUtils.addElaboration(domain, initTransition, m0_init);
		StatemachinesUtils.addElaboration(domain, transition, m0_e);
		EventBEMFUtils.save(emfRodinDB, m0);

		GenerateCommand generateCommand = new GenerateCommand(domain, SM);
		assertTrue("Generate command must be executable",
				generateCommand.canExecute());
		try {
			IStatus status = generateCommand.execute(new NullProgressMonitor(),
					null);
			assertTrue("The status should be OK", status.isOK());

			// There should not be any generated context.
			IRodinFile contextFile = prj.getContextFile("m0_implicitContext");
			assertFalse("Context should not exist", contextFile.exists());

			// Test the generated machine.
			testMachineRefinesClauses("m0 should not refine any machines", m0);
			testMachineSeesClauses("Incorrect m0's sees contexts", m0, "c0");
			testMachineVariables("Incorrect variables", m0, "S1", "S0");
			testMachineInvariants("Incorrect m0's invariants", m0,
					"typeof_S1:S1 ⊆ INSTANCE:false",
					"typeof_S0:S0 ⊆ INSTANCE:false",
					"distinct_states_in_SM:partition(INSTANCE, S0, S1):false");
			testMachineVariants("m0 should not contain any variants", m0);

			testMachineEvents("Incorrect events", m0,
					"INITIALISATION:ordinary:false", "e:ordinary:false");
			testEventParameters("Incorrect event's parameters", m0_init);
			testEventGuards("Incorrect event's guards", m0_init);
			testEventWitnesses("Incorrect event's witnesses", m0_init);
			testEventActions("Incorrect event's actions", m0_init,
					"init_S0:S0 ≔ INSTANCE", "init_S1:S1 ≔  ∅ ");

			testEventParameters("Incorrect event's parameters", m0_e, "i");
			testEventGuards("Incorrect event's guards", m0_e,
					"isin_S0:i ∈ S0:false");
			testEventWitnesses("Incorrect event's witnesses", m0_e);
			testEventActions("Incorrect event's actions", m0_e,
					"leave_S0:S0 ≔ S0 ∖ {i}", "enter_S1:S1 ≔ S1 ∪ {i}");
		} catch (ExecutionException e) {
			failUnexpectedException(e);
		}
	}

}
