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

package ac.soton.eventb.statemachines.internal.persistence.tests;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eventb.emf.core.context.CarrierSet;
import org.eventb.emf.core.context.Constant;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Invariant;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.Variable;
import org.eventb.emf.persistence.EventBEMFUtils;
import org.eventb.emf.persistence.tests.AbstractEventBEMFTests;
import org.eventb.emf.persistence.tests.ChannelEMFSetup;
import org.junit.Test;

import ac.soton.eventb.statemachines.AbstractNode;
import ac.soton.eventb.statemachines.Any;
import ac.soton.eventb.statemachines.Final;
import ac.soton.eventb.statemachines.Fork;
import ac.soton.eventb.statemachines.Initial;
import ac.soton.eventb.statemachines.Junction;
import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachinesUtils;
import ac.soton.eventb.statemachines.Transition;
import ac.soton.eventb.statemachines.TranslationKind;
import ac.soton.eventb.statemachines.persistence.tests.AbstractStatemachinesTests;

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
public class StatemachinesPersistenceTests extends AbstractStatemachinesTests {

	/**
	 * This setup method performs the following actions:
	 * <ol>
	 * <li>Call the super method.</li>
	 * <li>Setup the <code>Channel</code> project.</li>
	 * </ol>
	 * 
	 * @see AbstractEventBEMFTests#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ChannelEMFSetup.setup();
	}

	/**
	 * 
	 */
	@Test
	public void testStatemachineNullName() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		URI channelURI = EcoreUtil.getURI(channelMch);
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();

		Statemachine sm = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "", null, null, "", TranslationKind.MULTIVAR);
		assertEquals("Incorrect created statemachine's name", "", sm.getName());
		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		testMachineStatemachines("Incorrect machine's statemachines",
				loadedChannelMch, ":null:null::MULTIVAR");
	}

	/**
	 * 
	 */
	@Test
	public void testStatemachineEmptyName() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		URI channelURI = EcoreUtil.getURI(channelMch);
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();

		Statemachine sm = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "", null, null, "", TranslationKind.MULTIVAR);
		assertEquals("Incorrect created statemachine's name", "", sm.getName());
		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		testMachineStatemachines("Incorrect machine's statemachines",
				loadedChannelMch, ":null:null::MULTIVAR");
	}

	@Test
	public void testStatemachineName() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		URI channelURI = EcoreUtil.getURI(channelMch);
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();

		Statemachine sm = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, null, "",
				TranslationKind.MULTIVAR);
		assertEquals("Incorrect created statemachine's name", "SM",
				sm.getName());
		EventBEMFUtils.save(emfRodinDB, channelMch);
		Machine loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		testMachineStatemachines("Incorrect machine' statemachines",
				loadedChannelMch, "SM:null:null::MULTIVAR");
	}

	@Test
	public void testStatemachineNullRefinesStatemachine() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		URI channelURI = EcoreUtil.getURI(channelMch);
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();

		// Test statemachine with empty string name
		Statemachine channelSM = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, null, "",
				TranslationKind.MULTIVAR);
		assertNull("There should be no Refines statemachine",
				channelSM.getRefines());
		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		testMachineStatemachines("Incorrect machine's statemachines",
				loadedChannelMch, "SM:null:null::MULTIVAR");
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(loadedChannelMch);

		Statemachine loadedSM = statemachines.get(0);
		assertNull("Incorrect statemachine's refines statemachine",
				loadedSM.getRefines());
	}

	@Test
	public void testStatemachineRefinesStatemachine() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine channelSM = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, null, "",
				TranslationKind.MULTIVAR);
		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine EOMch = ChannelEMFSetup.getEOMachine();
		Statemachine EOSM = StatemachinesUtils.createStatemachine(domain,
				EOMch, null, "SM", channelSM, null, "",
				TranslationKind.MULTIVAR);
		assertSameReferences(
				"Incorrect created statemachine's refines statemachine",
				EOSM.getRefines(), channelSM);
		EventBEMFUtils.save(emfRodinDB, EOMch);

		URI EOURI = EcoreUtil.getURI(EOMch);
		Machine loadedEOMch = (Machine) emfRodinDB.loadElement(EOURI);
		testMachineStatemachines("Incorrect machine's statemachines",
				loadedEOMch, "SM:SM:null::MULTIVAR");
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(loadedEOMch);
		Statemachine loadedSM = statemachines.get(0);
		assertSameReferences(
				"Incorrect created statemachine's refines statemachine",
				loadedSM.getRefines(), channelSM);
	}

	@Test
	public void testStatemachineNullInstances() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		URI channelURI = EcoreUtil.getURI(channelMch);
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();

		Statemachine channelSM = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, null, "",
				TranslationKind.MULTIVAR);
		assertNull("There should be no instances", channelSM.getInstances());
		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		testMachineStatemachines("Incorrect machine's statemachines",
				loadedChannelMch, "SM:null:null::MULTIVAR");
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(loadedChannelMch);

		Statemachine loadedSM = statemachines.get(0);
		assertNull("There should be no instances", loadedSM.getInstances());

	}

	@Test
	public void testStatemachineCarrierSetInstances() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		URI channelURI = EcoreUtil.getURI(channelMch);
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		CarrierSet MESSAGE = ChannelEMFSetup.getMessageCarrierSet();

		Statemachine channelSM = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, MESSAGE, "",
				TranslationKind.MULTIVAR);
		assertSameReferences("Incorrect statemachine's instances",
				channelSM.getInstances(), MESSAGE);
		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		testMachineStatemachines("Incorrect machine's statemachines",
				loadedChannelMch, "SM:null:MESSAGE::MULTIVAR");
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(loadedChannelMch);

		Statemachine loadedSM = statemachines.get(0);
		assertSameReferences("Incorrect statemachine's instances",
				loadedSM.getInstances(), MESSAGE);
	}

	@Test
	public void testStatemachineConstantInstances() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		URI channelURI = EcoreUtil.getURI(channelMch);
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Constant max_size = ChannelEMFSetup.getSizeConstant();

		Statemachine channelSM = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, max_size, "",
				TranslationKind.MULTIVAR);
		assertSameReferences("Incorrect statemachine's instances",
				channelSM.getInstances(), max_size);
		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		testMachineStatemachines("Incorrect machine's statemachines",
				loadedChannelMch, "SM:null:max_size::MULTIVAR");
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(loadedChannelMch);

		Statemachine loadedSM = statemachines.get(0);
		assertSameReferences("Incorrect statemachine's instances",
				loadedSM.getInstances(), max_size);

	}

	@Test
	public void testStatemachineVariableInstances() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		URI channelURI = EcoreUtil.getURI(channelMch);
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Variable EO_channel = ChannelEMFSetup.getEOChannelVariable();

		Statemachine channelSM = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, EO_channel, "",
				TranslationKind.MULTIVAR);
		assertSameReferences("Incorrect statemachine's instances",
				channelSM.getInstances(), EO_channel);
		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		testMachineStatemachines("Incorrect machine's statemachines",
				loadedChannelMch, "SM:null:channel::MULTIVAR");
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(loadedChannelMch);

		Statemachine loadedSM = statemachines.get(0);
		assertSameReferences("Incorrect statemachine's instances",
				loadedSM.getInstances(), EO_channel);
	}

	@Test
	public void testStatemachineNullSelfName() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		URI channelURI = EcoreUtil.getURI(channelMch);
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();

		Statemachine channelSM = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, null, null,
				TranslationKind.MULTIVAR);
		assertEquals("The selfname should be empty", "",
				channelSM.getSelfName());
		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		testMachineStatemachines("Incorrect machine's statemachines",
				loadedChannelMch, "SM:null:null::MULTIVAR");
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(loadedChannelMch);

		Statemachine loadedSM = statemachines.get(0);
		assertEquals("The selfname should be empty", "", loadedSM.getSelfName());
	}

	@Test
	public void testStatemachineEmptySelfName() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		URI channelURI = EcoreUtil.getURI(channelMch);
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();

		Statemachine channelSM = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, null, "",
				TranslationKind.MULTIVAR);
		assertEquals("The selfname should be empty", "",
				channelSM.getSelfName());
		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		testMachineStatemachines("Incorrect machine's statemachines",
				loadedChannelMch, "SM:null:null::MULTIVAR");
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(loadedChannelMch);

		Statemachine loadedSM = statemachines.get(0);
		assertEquals("The selfname should be empty", "", loadedSM.getSelfName());
	}

	@Test
	public void testStatemachineNullInstancesSelfName() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		URI channelURI = EcoreUtil.getURI(channelMch);
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();

		Statemachine channelSM = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, null, "sm",
				TranslationKind.MULTIVAR);
		assertEquals("The selfname should be empty", "",
				channelSM.getSelfName());
		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		testMachineStatemachines("Incorrect machine's statemachines",
				loadedChannelMch, "SM:null:null::MULTIVAR");
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(loadedChannelMch);

		Statemachine loadedSM = statemachines.get(0);
		assertEquals("The selfname should be empty", "", loadedSM.getSelfName());
	}

	@Test
	public void testStatemachineSelfName() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		URI channelURI = EcoreUtil.getURI(channelMch);
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		CarrierSet MESSAGE = ChannelEMFSetup.getMessageCarrierSet();

		Statemachine channelSM = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, MESSAGE, "sm",
				TranslationKind.MULTIVAR);
		assertEquals("Incorrect statemachine's selfname", "sm",
				channelSM.getSelfName());
		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		testMachineStatemachines("Incorrect machine's statemachines",
				loadedChannelMch, "SM:null:MESSAGE:sm:MULTIVAR");
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(loadedChannelMch);

		Statemachine loadedSM = statemachines.get(0);
		assertEquals("Incorrect statemachine's selfname", "sm",
				loadedSM.getSelfName());
	}

	@Test
	public void testStatemachineNullTranslation() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		URI channelURI = EcoreUtil.getURI(channelMch);
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();

		Statemachine channelSM = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, null, null, null);
		assertEquals("The translation should be MULTIVAR",
				TranslationKind.MULTIVAR, channelSM.getTranslation());
		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		testMachineStatemachines("Incorrect machine's statemachines",
				loadedChannelMch, "SM:null:null::MULTIVAR");
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(loadedChannelMch);

		Statemachine loadedSM = statemachines.get(0);
		assertEquals("The translation should be MULTIVAR",
				TranslationKind.MULTIVAR, loadedSM.getTranslation());
	}

	@Test
	public void testStatemachineSinglevarTranslation() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		URI channelURI = EcoreUtil.getURI(channelMch);
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();

		Statemachine channelSM = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, null, null,
				TranslationKind.SINGLEVAR);
		assertEquals("The translation should be SINGLEVAR",
				TranslationKind.SINGLEVAR, channelSM.getTranslation());
		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		testMachineStatemachines("Incorrect machine's statemachines",
				loadedChannelMch, "SM:null:null::SINGLEVAR");
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(loadedChannelMch);

		Statemachine loadedSM = statemachines.get(0);
		assertEquals("The translation should be SINGLEVAR",
				TranslationKind.SINGLEVAR, loadedSM.getTranslation());
	}

	@Test
	public void testStatemachineMultivarTranslation() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		URI channelURI = EcoreUtil.getURI(channelMch);
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();

		Statemachine channelSM = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, null, null,
				TranslationKind.MULTIVAR);
		assertEquals("The translation should be MULTIVAR",
				TranslationKind.MULTIVAR, channelSM.getTranslation());
		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		testMachineStatemachines("Incorrect machine's statemachines",
				loadedChannelMch, "SM:null:null::MULTIVAR");
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(loadedChannelMch);

		Statemachine loadedSM = statemachines.get(0);
		assertEquals("The translation should be MULTIVAR",
				TranslationKind.MULTIVAR, loadedSM.getTranslation());
	}

	@Test
	public void testStatemachineInitialState() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		URI channelURI = EcoreUtil.getURI(channelMch);
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine channelSM = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, null, null,
				TranslationKind.MULTIVAR);

		Initial initialState = StatemachinesUtils.createInitialState(domain,
				channelSM, "S");
		assertNotNull("Created initial state must not be null", initialState);
		testInitial("Incorrect created initial state", initialState, "(Init)S");
		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(loadedChannelMch);
		Statemachine loadedSM = statemachines.get(0);

		testStatemachineNodes("Test initial state", loadedSM, "(Init)S");
		EList<AbstractNode> nodes = loadedSM.getNodes();

		AbstractNode node = nodes.get(0);
		assertSameReferences("Test initial state", (Initial) node, initialState);
		testInitial("Incorrect created initial state", (Initial) node,
				"(Init)S");
	}

	@Test
	public void testStatemachineFinalState() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		URI channelURI = EcoreUtil.getURI(channelMch);
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine channelSM = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, null, null,
				TranslationKind.MULTIVAR);

		Final finalState = StatemachinesUtils.createFinalState(domain,
				channelSM, "S");
		assertNotNull("Created final state must not be null", finalState);
		testFinal("Incorrect created final state", finalState, "(Final)S");
		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(loadedChannelMch);
		Statemachine loadedSM = statemachines.get(0);

		testStatemachineNodes("Test final state", loadedSM, "(Final)S");
		EList<AbstractNode> nodes = loadedSM.getNodes();

		AbstractNode node = nodes.get(0);
		assertSameReferences("Test final state", (Final) node, finalState);
		testFinal("Incorrect created final state", (Final) node, "(Final)S");
	}

	@Test
	public void testStatemachineSimpleState() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		URI channelURI = EcoreUtil.getURI(channelMch);
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine channelSM = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, null, null,
				TranslationKind.MULTIVAR);

		State state = StatemachinesUtils.createState(domain, channelSM, "S",
				null);
		assertNotNull("Created simple state must not be null", state);
		testState("Incorrect created simple state", state, "S:null");
		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(loadedChannelMch);
		Statemachine loadedSM = statemachines.get(0);

		testStatemachineNodes("Test simple state", loadedSM, "S:null");
		EList<AbstractNode> nodes = loadedSM.getNodes();

		AbstractNode node = nodes.get(0);
		assertSameReferences("Test simple state", (State) node, state);
		testState("Incorrect created simple state", (State) node, "S:null");
	}

	@Test
	public void testStatemachineRefiningStateAutoCorrected() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine channelSM = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, null, null,
				TranslationKind.MULTIVAR);

		State absState = StatemachinesUtils.createState(domain, channelSM, "S",
				null);

		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine EOMch = ChannelEMFSetup.getEOMachine();
		Statemachine EOSM = StatemachinesUtils.createStatemachine(domain,
				EOMch, null, "SM", channelSM, null, "",
				TranslationKind.MULTIVAR);
		State state = StatemachinesUtils.createState(domain, EOSM, "T",
				absState);
		assertNotNull("Created refining state must not be null", state);
		testState("Incorrected created refining state", state, "S:S");
		EventBEMFUtils.save(emfRodinDB, EOMch);

		URI EOURI = EcoreUtil.getURI(EOMch);
		Machine loadedEOMch = (Machine) emfRodinDB.loadElement(EOURI);
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(loadedEOMch);
		Statemachine loadedSM = statemachines.get(0);
		testStatemachineNodes("Test refining state", loadedSM, "S:S");

		EList<AbstractNode> nodes = loadedSM.getNodes();
		AbstractNode node = nodes.get(0);
		assertSameReferences("Test refining state", (State) node, state);
		testState("Incorrected created refining state", (State) node, "S:S");
		assertSameReferences("Test refining state",
				((State) node).getRefines(), absState);

	}

	@Test
	public void testStatemachineRefiningState() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine channelSM = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, null, null,
				TranslationKind.MULTIVAR);

		State absState = StatemachinesUtils.createState(domain, channelSM, "T",
				null);

		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine EOMch = ChannelEMFSetup.getEOMachine();
		Statemachine EOSM = StatemachinesUtils.createStatemachine(domain,
				EOMch, null, "SM", channelSM, null, "",
				TranslationKind.MULTIVAR);
		State state = StatemachinesUtils.createState(domain, EOSM, "T",
				absState);
		assertNotNull("Created refining state must not be null", state);
		testState("Incorrected created refining state", state, "T:T");
		EventBEMFUtils.save(emfRodinDB, EOMch);

		URI EOURI = EcoreUtil.getURI(EOMch);
		Machine loadedEOMch = (Machine) emfRodinDB.loadElement(EOURI);
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(loadedEOMch);
		Statemachine loadedSM = statemachines.get(0);
		testStatemachineNodes("Test refining state", loadedSM, "T:T");

		EList<AbstractNode> nodes = loadedSM.getNodes();
		AbstractNode node = nodes.get(0);
		assertSameReferences("Test refining state", (State) node, state);
		testState("Incorrected created refining state", (State) node, "T:T");
		assertSameReferences("Test refining state",
				((State) node).getRefines(), absState);

	}

	@Test
	public void testStatemachineAnyState() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		URI channelURI = EcoreUtil.getURI(channelMch);
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine channelSM = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, null, null,
				TranslationKind.MULTIVAR);

		Any anyState = StatemachinesUtils.createAny(domain, channelSM, "S");
		assertNotNull("Created any state must not be null", anyState);
		testAny("Incorrect created any state", anyState, "(Any)S");
		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(loadedChannelMch);
		Statemachine loadedSM = statemachines.get(0);

		testStatemachineNodes("Test any state", loadedSM, "(Any)S");
		EList<AbstractNode> nodes = loadedSM.getNodes();

		AbstractNode node = nodes.get(0);
		assertSameReferences("Test any state", (Any) node, anyState);
		testAny("Incorrect created any state", (Any) node, "(Any)S");
	}

	@Test
	public void testStatemachineForkState() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		URI channelURI = EcoreUtil.getURI(channelMch);
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine channelSM = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, null, null,
				TranslationKind.MULTIVAR);

		Fork forkState = StatemachinesUtils.createFork(domain, channelSM, "S");
		assertNotNull("Created any state must not be null", forkState);
		testFork("Incorrect created any state", forkState, "(Fork)S");
		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(loadedChannelMch);
		Statemachine loadedSM = statemachines.get(0);

		testStatemachineNodes("Test any state", loadedSM, "(Fork)S");
		EList<AbstractNode> nodes = loadedSM.getNodes();

		AbstractNode node = nodes.get(0);
		assertSameReferences("Test any state", (Fork) node, forkState);
		testFork("Incorrect created any state", (Fork) node, "(Fork)S");
	}

	@Test
	public void testStatemachineJucntionState() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		URI channelURI = EcoreUtil.getURI(channelMch);
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine channelSM = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, null, null,
				TranslationKind.MULTIVAR);

		Junction junctionState = StatemachinesUtils.createJunction(domain,
				channelSM, "S");
		assertNotNull("Created any state must not be null", junctionState);
		testJunction("Incorrect created any state", junctionState,
				"(Junction)S");
		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(loadedChannelMch);
		Statemachine loadedSM = statemachines.get(0);

		testStatemachineNodes("Test any state", loadedSM, "(Junction)S");
		EList<AbstractNode> nodes = loadedSM.getNodes();

		AbstractNode node = nodes.get(0);
		assertSameReferences("Test any state", (Junction) node, junctionState);
		testJunction("Incorrect created any state", (Junction) node,
				"(Junction)S");
	}

	@Test
	public void testStateInvariant() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		URI channelURI = EcoreUtil.getURI(channelMch);
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine channelSM = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, null, null,
				TranslationKind.MULTIVAR);

		State state = StatemachinesUtils.createState(domain, channelSM, "S",
				null);
		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(loadedChannelMch);
		Statemachine loadedSM = statemachines.get(0);
		EList<AbstractNode> nodes = loadedSM.getNodes();
		State loadedState = (State) nodes.get(0);
		testStateInvariants("Incorrect state invariants", loadedState);

		// Test add invariant
		Invariant inv = StatemachinesUtils.createInvariant(domain, state,
				"inv1", "x ∈ ℕ", false);
		testInvariant("Incorrect created invariant", inv, "inv1:x ∈ ℕ:false");
		EventBEMFUtils.save(emfRodinDB, channelMch);

		loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		statemachines = StatemachinesUtils.getStatemachines(loadedChannelMch);
		loadedSM = statemachines.get(0);
		nodes = loadedSM.getNodes();
		loadedState = (State) nodes.get(0);
		testStateInvariants("Incorrect state invariants", loadedState,
				"inv1:x ∈ ℕ:false");

		// Test add invariant
		inv = StatemachinesUtils.createInvariant(domain, state, "thm2",
				"x ≥ 0", true);
		testInvariant("Incorrect created invariant", inv, "thm2:x ≥ 0:true");
		EventBEMFUtils.save(emfRodinDB, channelMch);

		loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		statemachines = StatemachinesUtils.getStatemachines(loadedChannelMch);
		loadedSM = statemachines.get(0);
		nodes = loadedSM.getNodes();
		loadedState = (State) nodes.get(0);
		testStateInvariants("Incorrect state invariants", loadedState,
				"inv1:x ∈ ℕ:false", "thm2:x ≥ 0:true");
	}

	@Test
	public void testStateNestedStatemachine() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		URI channelURI = EcoreUtil.getURI(channelMch);
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine channelSM = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, null, null,
				TranslationKind.MULTIVAR);
		State state = StatemachinesUtils.createState(domain, channelSM, "S",
				null);
		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(loadedChannelMch);
		Statemachine loadedSM = statemachines.get(0);
		EList<AbstractNode> nodes = loadedSM.getNodes();
		State loadedState = (State) nodes.get(0);
		testStateNestedStatemachine("Incorrect state's statemachine",
				loadedState);

		Statemachine statemachine = StatemachinesUtils.createStatemachine(
				domain, state, null, "T", null, null, "",
				TranslationKind.SINGLEVAR);
		testStatemachine("Incorrect created nested statemachine", statemachine,
				"T:null:null::SINGLEVAR");
		EventBEMFUtils.save(emfRodinDB, channelMch);
		loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		statemachines = StatemachinesUtils.getStatemachines(loadedChannelMch);
		loadedSM = statemachines.get(0);
		nodes = loadedSM.getNodes();
		loadedState = (State) nodes.get(0);
		testStateNestedStatemachine("Incorrect state's statemachine",
				loadedState, "T:null:null::SINGLEVAR");
	}

	@Test
	public void testStatemachineTransition() {
		Machine channelMch = ChannelEMFSetup.getChannelMachine();
		URI channelURI = EcoreUtil.getURI(channelMch);
		TransactionalEditingDomain domain = emfRodinDB.getEditingDomain();
		Statemachine channelSM = StatemachinesUtils.createStatemachine(domain,
				channelMch, null, "SM", null, null, null,
				TranslationKind.MULTIVAR);
		Initial initialState = StatemachinesUtils.createInitialState(domain,
				channelSM, "");
		State state = StatemachinesUtils.createState(domain, channelSM, "S",
				null);
		Transition transition = StatemachinesUtils.createTransition(domain,
				channelSM, initialState, state);
		testTransitionSourceAndTarget("Incorrect created transition",
				transition, initialState, state);
		testTransitionElaborates("Incorrect created transition", transition);
		EventBEMFUtils.save(emfRodinDB, channelMch);

		Machine loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(loadedChannelMch);
		Statemachine loadedSM = statemachines.get(0);
		EList<Transition> transitions = loadedSM.getTransitions();
		assertEquals("There should be 1 transition", 1, transitions.size());
		Transition loadedTransition = transitions.get(0);
		testTransitionSourceAndTarget("Incorrect created transition",
				loadedTransition, initialState, state);
		testTransitionElaborates("Incorrect created transition",
				loadedTransition);

		Event channel_init = ChannelEMFSetup.getChannelInitEvent();
		StatemachinesUtils.addElaboration(domain, transition, channel_init);
		testTransitionElaborates("Incorrect created transition", transition,
				channel_init);
		EventBEMFUtils.save(emfRodinDB, channelMch);
		loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		statemachines = StatemachinesUtils
				.getStatemachines(loadedChannelMch);
		loadedSM = statemachines.get(0);
		transitions = loadedSM.getTransitions();
		assertEquals("There should be 1 transition", 1, transitions.size());
		loadedTransition = transitions.get(0);
		testTransitionSourceAndTarget("Incorrect created transition",
				loadedTransition, initialState, state);
		testTransitionElaborates("Incorrect created transition",
				loadedTransition, channel_init);

		Event channel_sends = ChannelEMFSetup.getChannelSendsEvent();
		StatemachinesUtils.addElaboration(domain, transition, channel_sends);
		testTransitionElaborates("Incorrect created transition", transition,
				channel_init, channel_sends);
		EventBEMFUtils.save(emfRodinDB, channelMch);
		loadedChannelMch = (Machine) emfRodinDB.loadElement(channelURI);
		statemachines = StatemachinesUtils
				.getStatemachines(loadedChannelMch);
		loadedSM = statemachines.get(0);
		transitions = loadedSM.getTransitions();
		assertEquals("There should be 1 transition", 1, transitions.size());
		loadedTransition = transitions.get(0);
		testTransitionSourceAndTarget("Incorrect created transition",
				loadedTransition, initialState, state);
		testTransitionElaborates("Incorrect created transition",
				loadedTransition, channel_init, channel_sends);
	}

}