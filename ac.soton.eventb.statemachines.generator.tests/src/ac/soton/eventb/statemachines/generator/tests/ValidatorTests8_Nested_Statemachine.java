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
import org.eventb.core.IEventBProject;
import org.eventb.emf.core.context.CarrierSet;
import org.eventb.emf.core.context.Constant;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.Variable;
import org.eventb.emf.persistence.EventBEMFUtils;
import org.junit.Test;

import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachinesUtils;
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
public final class ValidatorTests8_Nested_Statemachine extends
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
	 * The context <code>c0</code> within <code>P</code> (created in the
	 * {@link #setUp()} method).
	 */
	private Context c0;

	/**
	 * Carrier set <code>INSTANCE</code> within <code>c0</code> (created in the
	 * {@link #setUp()} method).
	 */
	private CarrierSet setINSTANCE;

	/**
	 * Constant <code>Instances</code> within <code>c0</code> (created in the
	 * {@link #setUp()} method).
	 */
	private Constant cstINSTANCE;

	/**
	 * Constant <code>Instances</code> within <code>c0</code> (created in the
	 * {@link #setUp()} method).
	 */
	private Variable varINSTANCE;

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
	 * <li>Create the variable<code>instances</code> within <codem0P</code>.</li>
	 * 
	 * <li>Save <code>m0</code>.</li>
	 * 
	 * <li>Create the context <code>c0</code> within <code>P</code>.</li>
	 * 
	 * <li>Create the carrier set <code>INSTANCE</code> within <code>c0</code>.</li>
	 * 
	 * <li>Create the constant<code>Instances</code> within <code>c0</code>.</li>
	 * 
	 * <li>Save <code>c0</code>.</li>
	 * </ol>
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		prj = EventBUtils.createEventBProject("P", nullMonitor);
		m0 = EventBEMFUtils.createMachine(emfRodinDB, prj, "m0");
		varINSTANCE = EventBEMFUtils.createVariable(domain, m0, "instances");
		
		
		EventBEMFUtils.save(emfRodinDB, m0);
		c0 = EventBEMFUtils.createContext(emfRodinDB, prj, "c0");
		setINSTANCE = EventBEMFUtils.createCarrierSet(domain, c0, "INSTANCE");
		cstINSTANCE = EventBEMFUtils.createConstant(domain, c0, "Instances");
		EventBEMFUtils.save(emfRodinDB, c0);
	}

	// =========================================================================
	// (BEGIN) Unit tests for root statemachine.
	// =========================================================================

	/**
	 * Unit test for validation on a root statemachine with a <code>null</code>
	 * name.
	 * <ul>
	 * <li><b>Setting:</b> A empty root statemachine with a <code>null</code>
	 * name.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(WARNING)</i> Validation fails the constraint '<i>Statemachine
	 * should have a valid name</i>'.</li>
	 * 
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Root statemachine
	 * should have initial state</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_Name_Null() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, null, null, null, "", TranslationKind.SINGLEVAR);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticError("Incorrect root diagnostic", diagnostic);
		assertDiagnosticSeverities("Incorrect sub-diagnostics' severities",
				diagnostic, Diagnostic.WARNING, Diagnostic.ERROR);
		assertDiagnosticCauses(
				"Incoorect sub-diagnostics",
				diagnostic,
				"The 'Statemachine should have a valid name' constraint is violated on 'm0::<Statemachine>'",
				"The 'Root statemachine should have initial state' constraint is violated on 'm0::<Statemachine>'");
	}

	/**
	 * Unit test for validation on a root statemachine with an empty name.
	 * <ul>
	 * <li><b>Setting:</b> A empty root statemachine with an empty name.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(WARNING)</i> Validation fails the constraint '<i>Statemachine
	 * should have a valid name</i>'.</li>
	 * 
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Root statemachine
	 * should have initial state</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_Name_Empty() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "", null, null, "", TranslationKind.SINGLEVAR);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticError("Incorrect root diagnostic", diagnostic);
		assertDiagnosticSeverities("Incorrect sub-diagnostics' severities",
				diagnostic, Diagnostic.WARNING, Diagnostic.ERROR);
		assertDiagnosticCauses(
				"Incoorect sub-diagnostics",
				diagnostic,
				"The 'Statemachine should have a valid name' constraint is violated on 'm0::<Statemachine>'",
				"The 'Root statemachine should have initial state' constraint is violated on 'm0::<Statemachine>'");
	}

	/**
	 * Unit test for validation on a root statemachine with an invalid name.
	 * <ul>
	 * <li><b>Setting:</b> A empty root statemachine <code>Invalid Name</code>.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(WARNING)</i> Validation fails the constraint '<i>Statemachine
	 * should have a valid name</i>'.</li>
	 * 
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Root statemachine
	 * should have initial state</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_Name_Invalid() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine SM = StatemachinesUtils
				.createStatemachine(domain, m0, null, "Invalid Name", null,
						null, "", TranslationKind.SINGLEVAR);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticError("Incorrect root diagnostic", diagnostic);
		assertDiagnosticSeverities("Incorrect sub-diagnostics' severities",
				diagnostic, Diagnostic.WARNING, Diagnostic.ERROR);
		assertDiagnosticCauses(
				"Incorrect sub-diagnostics",
				diagnostic,
				"The 'Statemachine should have a valid name' constraint is violated on 'm0::Invalid Name'",
				"The 'Root statemachine should have initial state' constraint is violated on 'm0::Invalid Name'");
	}

	/**
	 * Unit test for validation on an empty root statemachine.
	 * <ul>
	 * <li><b>Setting:</b> An empty root statemachine <code>SM</code>.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Root statemachine
	 * should have initial state</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_Name_Valid() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, null, "", TranslationKind.SINGLEVAR);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticError("Incorrect root diagnostic", diagnostic);
		assertDiagnosticSeverities("Incorrect sub-diagnostics' severities",
				diagnostic, Diagnostic.ERROR);
		assertDiagnostic(
				"Incorrect sub-diagnostics",
				diagnostic,
				"The 'Root statemachine should have initial state' constraint is violated on 'm0::SM'");
	}

	/**
	 * Unit test for validation on a root statemachine with <code>null</code>
	 * instances.
	 * <ul>
	 * <li><b>Setting:</b> An empty root statemachine <code>SM</code> with
	 * <code>null</code> instances.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Root statemachine
	 * should have initial state</i>'.</li>
	 * </ol>
	 * (i.e., there are no additional errors regarding the <code>null</code>
	 * instances).</li>
	 * </ul>
	 */
	@Test
	public void test_Instances_Null() {
		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, null, "", TranslationKind.SINGLEVAR);
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

	/**
	 * Unit test for validation on a root statemachine with a carrier set
	 * instances.
	 * <ul>
	 * <li><b>Setting:</b> An empty root statemachine <code>SM</code> with
	 * carrier sets <code>INSTANCE</code> for instances and a valid self-name.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Root statemachine
	 * should have initial state</i>'.</li>
	 * </ol>
	 * (i.e., there are no additional errors regarding the <code>null</code>
	 * instances).</li>
	 * </ul>
	 */
	@Test
	public void test_Instances_CarrierSet() {
		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, setINSTANCE, "Selfname",
				TranslationKind.SINGLEVAR);
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

	/**
	 * Unit test for validation on a root statemachine with a constant
	 * instances.
	 * <ul>
	 * <li><b>Setting:</b> An empty root statemachine <code>SM</code> with
	 * constant <code>Instances</code> for instances and a valid self-name.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Root statemachine
	 * should have initial state</i>'.</li>
	 * </ol>
	 * (i.e., there are no additional errors regarding the constant instances).</li>
	 * </ul>
	 */
	@Test
	public void test_Instances_Constant() {
		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, cstINSTANCE, "Selfname",
				TranslationKind.SINGLEVAR);
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

	/**
	 * Unit test for validation on a root statemachine with variable instances.
	 * <ul>
	 * <li><b>Setting:</b> An empty root statemachine <code>SM</code> with
	 * variable <code>instances</code> for instances and a valid self-name.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Root statemachine
	 * should have initial state</i>'.</li>
	 * 
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Variable Instances
	 * Statemachine Lifting is not yet supported</i>'.</li>
	 * </ol>
	 * (i.e., there are no additional errors regarding the variable instances).</li>
	 * </ul>
	 */
	@Test
	public void test_Instances_Variable() {
		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, varINSTANCE, "Selfname",
				TranslationKind.SINGLEVAR);
		EventBEMFUtils.save(emfRodinDB, m0);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticError("Incorrect root diagnostic", diagnostic);
		assertDiagnosticSeverities("Incorrect sub-diagnostics' severities",
				diagnostic, Diagnostic.ERROR, Diagnostic.ERROR);
		assertDiagnosticCauses(
				"Incorrect sub-diagnostics",
				diagnostic,
				"The 'Root statemachine should have initial state' constraint is violated on 'm0::SM'",
				"The 'Variable Instances Statemachine Lifting is not yet supported' constraint is violated on 'm0::SM'");
	}

	/**
	 * Unit test for validation on a root statemachine with an invalid
	 * self-name.
	 * <ul>
	 * <li><b>Setting:</b> An empty root statemachine <code>SM</code> with
	 * <code>INSTANCE</code> and empty string self-name.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Root statemachine
	 * should have initial state</i>'.</li>
	 * 
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Statemachine self
	 * name is not valid</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_SelfName_Empty() {
		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, setINSTANCE, "", TranslationKind.SINGLEVAR);
		EventBEMFUtils.save(emfRodinDB, m0);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticError("Incorrect root diagnostic", diagnostic);
		assertDiagnosticSeverities("Incorrect sub-diagnostics' severities",
				diagnostic, Diagnostic.ERROR, Diagnostic.ERROR);
		assertDiagnosticCauses(
				"Incorrect sub-diagnostics",
				diagnostic,
				"The 'Root statemachine should have initial state' constraint is violated on 'm0::SM'",
				"The 'Statemachine self name is not valid' constraint is violated on 'm0::SM'");
	}

	/**
	 * Unit test for validation on a root statemachine with an invalid
	 * self-name.
	 * <ul>
	 * <li><b>Setting:</b> An empty root statemachine <code>SM</code> with
	 * <code>INSTANCE</code> and self-name <code>Selfname</code>.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Statemachine self
	 * name is not valid</i>'.</li>
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Root statemachine
	 * should have initial state</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_SelfName_Valid() {
		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, setINSTANCE, "Selfname",
				TranslationKind.SINGLEVAR);
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

	/**
	 * Unit test for validation on a statemachine with <code>null</code>
	 * translation.
	 * <ul>
	 * <li><b>Setting:</b> An empty root statemachine <code>SM</code> with
	 * <code>null</code> translation.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Root statemachine
	 * should have initial state</i>'.</li>
	 * </ol>
	 * There is no specific error related to the translation since the default
	 * value can be used.</li>
	 * </ul>
	 */
	@Test
	public void test_Translation_Null() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, null, "", null);
		Diagnostic diagnostic = validate(SM);
		assertDiagnosticError("Incorrect root diagnostic", diagnostic);
		assertDiagnosticSeverities("Incorrect sub-diagnostics' severities",
				diagnostic, Diagnostic.ERROR);
		assertDiagnostic(
				"Incorrect sub-diagnostics",
				diagnostic,
				"The 'Root statemachine should have initial state' constraint is violated on 'm0::SM'");
	}

	/**
	 * Unit test for validation on a statemachine with <code>SINGlEVAR</code>
	 * translation.
	 * <ul>
	 * <li><b>Setting:</b> An empty root statemachine <code>SM</code> with
	 * <code>SINGLEVAR</code> translation.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Root statemachine
	 * should have initial state</i>'.</li>
	 * </ol>
	 * There is no specific error related to the translation.</li>
	 * </ul>
	 */
	@Test
	public void test_Translation_SINGLEVAR() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, null, "", TranslationKind.SINGLEVAR);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticError("Incorrect root diagnostic", diagnostic);
		assertDiagnosticSeverities("Incorrect sub-diagnostics' severities",
				diagnostic, Diagnostic.ERROR);
		assertDiagnostic(
				"Incorrect sub-diagnostics",
				diagnostic,
				"The 'Root statemachine should have initial state' constraint is violated on 'm0::SM'");
	}

	/**
	 * Unit test for validation on a statemachine with <code>SINGlEVAR</code>
	 * translation.
	 * <ul>
	 * <li><b>Setting:</b> An empty root statemachine <code>SM</code> with
	 * <code>SINGLEVAR</code> translation.</li>
	 * 
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Root statemachine
	 * should have initial state</i>'.</li>
	 * </ol>
	 * There is no specific error related to the translation.</li>
	 * </ul>
	 */
	@Test
	public void test_Translation_MULTIVAR() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, null, "", TranslationKind.MULTIVAR);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticError("Incorrect root diagnostic", diagnostic);
		assertDiagnosticSeverities("Incorrect sub-diagnostics' severities",
				diagnostic, Diagnostic.ERROR);
		assertDiagnostic(
				"Incorrect sub-diagnostics",
				diagnostic,
				"The 'Root statemachine should have initial state' constraint is violated on 'm0::SM'");
	}

	/**
	 * Unit test for validation on a root statemachine without initial states.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with a single
	 * state <code>S0</code>.</li>
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Root statemachine
	 * should have initial state</i>'.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_InitialState_None() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, null, "", TranslationKind.SINGLEVAR);
		StatemachinesUtils.createState(domain, SM, "S0", null);

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticError("Incorrect root diagnostic", diagnostic);
		assertDiagnosticSeverities("Incorrect sub-diagnostics' severities",
				diagnostic, Diagnostic.ERROR);
		assertDiagnostic(
				"Incorrect sub-diagnostics",
				diagnostic,
				"The 'Root statemachine should have initial state' constraint is violated on 'm0::SM'");
	}

	/**
	 * Unit test for validation on a root statemachine without multiple initial
	 * states.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with initial
	 * states <code>Init1</code> and <code>Init2</code>.</li>
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Statemachine can
	 * have only one initial state</i>'.</li>
	 * <li><i>(WARNING)</i> Validation fails the constraint '<i>Initial state
	 * should have an outgoing transition</i>' for Init1.</li>
	 * <li><i>(WARNING)</i> Validation fails the constraint '<i>Initial state
	 * should have an outgoing transition</i>' for Init2.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_InitialState_Multiple() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, null, "", TranslationKind.SINGLEVAR);
		StatemachinesUtils.createInitialState(domain, SM, "Init1");
		StatemachinesUtils.createInitialState(domain, SM, "Init2");

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticError("Incorrect root diagnostic", diagnostic);
		assertDiagnosticSeverities("Incorrect sub-diagnostics' severities",
				diagnostic, Diagnostic.ERROR, Diagnostic.WARNING,
				Diagnostic.WARNING);
		assertDiagnosticCauses(
				"Incorrect sub-diagnostics",
				diagnostic,
				"The 'Statemachine can have only one initial state' constraint is violated on 'm0::SM'",
				"The 'Initial state should have an outgoing transition' constraint is violated on 'm0::SM::Init1'",
				"The 'Initial state should have an outgoing transition' constraint is violated on 'm0::SM::Init2'");
	}

	/**
	 * Unit test for validation on a root statemachine without multiple final
	 * states.
	 * <ul>
	 * <li><b>Setting:</b> A root statemachine <code>SM</code> with final states
	 * <code>Final1</code> and <code>Final2</code>.</li>
	 * <li><b>Expected result:</b>
	 * <ol>
	 * <li><i>(ERROR)</i> Validation fails the constraint '<i>Statemachine can
	 * have only one final state</i>'.</li>
	 * <li><i>(WARNING)</i> Validation fails the constraint '<i>Final state
	 * should have an incoming transition</i>' for Final1.</li>
	 * <li><i>(WARNING)</i> Validation fails the constraint '<i>Final state
	 * should have an incoming transition</i>' for Final2.</li>
	 * </ol>
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_FinalState_Multiple() {
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine SM = StatemachinesUtils.createStatemachine(domain, m0,
				null, "SM", null, null, "", TranslationKind.SINGLEVAR);
		StatemachinesUtils.createFinalState(domain, SM, "Final1");
		StatemachinesUtils.createFinalState(domain, SM, "Final2");

		Diagnostic diagnostic = validate(SM);
		assertDiagnosticError("Incorrect root diagnostic", diagnostic);
		assertDiagnosticSeverities("Incorrect sub-diagnostics' severities",
				diagnostic, Diagnostic.ERROR, Diagnostic.ERROR,
				Diagnostic.WARNING, Diagnostic.WARNING);
		assertDiagnosticCauses(
				"Incorrect sub-diagnostics",
				diagnostic,
				"The 'Statemachine can have only one final state' constraint is violated on 'm0::SM'",
				"The 'Root statemachine should have initial state' constraint is violated on 'm0::SM'",
				"The 'Final state should have an incoming transition' constraint is violated on 'm0::SM::Final1'",
				"The 'Final state should have an incoming transition' constraint is violated on 'm0::SM::Final2'");
	}

	// =========================================================================
	// (END) Unit tests for root statemachine.
	// =========================================================================

}
