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

package ac.soton.eventb.statemachines.persistence.tests;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamedCommentedElement;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Invariant;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.persistence.tests.AbstractEventBEMFTests;

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
public class AbstractStatemachinesTests extends AbstractEventBEMFTests {

	/**
	 * @param msg
	 * @param mch
	 * @param string
	 */
	public void testMachineStatemachines(String msg, Machine mch,
			String... expected) {
		List<Statemachine> statemachines = StatemachinesUtils
				.getStatemachines(mch);
		testStatemachines(msg, statemachines.iterator(), expected);
	}

	/**
	 * @param msg
	 * @param statemachines
	 * @param expected
	 */
	public void testStatemachines(String msg, Iterator<Statemachine> iterator,
			String... expected) {
		for (String expectSM : expected) {
			if (!iterator.hasNext())
				fail(msg + ": Expect to have " + expected.length
						+ " state machines");
			Statemachine statemachine = iterator.next();
			testStatemachine(msg, statemachine, expectSM);
		}
		if (iterator.hasNext())
			fail(msg + ": Expect to have " + expected.length
					+ " state machines");
	}

	/**
	 * @param msg
	 * @param statemachine
	 * @param expectSM
	 */
	public void testStatemachine(String msg, Statemachine statemachine,
			String expected) {
		Statemachine refinesStatemachine = statemachine.getRefines();
		EventBNamedCommentedElement instances = statemachine.getInstances();
		StringBuilder actual = new StringBuilder();
		actual.append(statemachine.getName());
		actual.append(":");
		actual.append(refinesStatemachine != null ? refinesStatemachine
				.getName() : "null");
		actual.append(":");
		actual.append(instances != null ? instances.getName() : "null");
		actual.append(":");
		actual.append(statemachine.getSelfName());
		actual.append(":");
		actual.append(statemachine.getTranslation());
		assertEquals(msg + ": Incorrect statemachine", expected,
				actual.toString());
	}

	public void assertSameReferences(String msg, EventBElement actual,
			EventBElement expected) {
		assertEquals(msg, expected.getReference(), actual.getReference());
	}

	/**
	 * @param string
	 * @param loadedSM
	 */
	public void testStatemachineNodes(String msg, Statemachine statemachine,
			String... expected) {
		EList<AbstractNode> nodes = statemachine.getNodes();
		assertEquals(msg, expected.length, nodes.size());

		Iterator<AbstractNode> iterator = nodes.iterator();
		for (String expectedNode : expected) {
			testNode(msg, iterator.next(), expectedNode);
		}
	}

	/**
	 * @param msg
	 * @param next
	 * @param expectedNode
	 */
	public void testNode(String msg, AbstractNode node, String expected) {
		if (node instanceof Initial) {
			testInitial(msg, (Initial) node, expected);
			return;
		}
		if (node instanceof Final) {
			testFinal(msg, (Final) node, expected);
			return;
		}
		if (node instanceof State) {
			testState(msg, (State) node, expected);
			return;
		}
		if (node instanceof Any) {
			testAny(msg, (Any) node, expected);
			return;
		}
		if (node instanceof Fork) {
			testFork(msg, (Fork) node, expected);
			return;
		}
		if (node instanceof Junction) {
			testJunction(msg, (Junction) node, expected);
			return;
		}
	}

	/**
	 * @param msg
	 * @param node
	 * @param expected
	 */
	public void testInitial(String msg, Initial node, String expected) {
		String name = node.getName();
		assertEquals(msg, expected, "(Init)" + name);
	}

	/**
	 * @param msg
	 * @param node
	 * @param expected
	 */
	public void testFinal(String msg, Final node, String expected) {
		String name = node.getName();
		assertEquals(msg, expected, "(Final)" + name);
	}

	/**
	 * @param msg
	 * @param node
	 * @param expected
	 */
	protected void testState(String msg, State node, String expected) {
		StringBuilder actual = new StringBuilder();
		actual.append(node.getName());
		actual.append(":");
		State refinesNode = node.getRefines();
		actual.append(refinesNode != null ? refinesNode.getName() : "null");
		assertEquals(msg, expected, actual.toString());
	}

	/**
	 * @param msg
	 * @param node
	 * @param expected
	 */
	public void testAny(String msg, Any node, String expected) {
		String name = node.getName();
		assertEquals(msg, expected, "(Any)" + name);
	}

	/**
	 * @param msg
	 * @param node
	 * @param expected
	 */
	public void testFork(String msg, Fork node, String expected) {
		String name = node.getName();
		assertEquals(msg, expected, "(Fork)" + name);

	}

	/**
	 * @param msg
	 * @param node
	 * @param expected
	 */
	public void testJunction(String msg, Junction node, String expected) {
		String name = node.getName();
		assertEquals(msg, expected, "(Junction)" + name);

	}

	/**
	 * @param msg
	 * @param state
	 * @param expected
	 */
	public void testStateInvariants(String msg, State state, String... expected) {
		EList<Invariant> invs = state.getInvariants();
		assertEquals(msg + ": Incorrect number of invariants", expected.length,
				invs.size());
		Iterator<Invariant> iterator = invs.iterator();
		for (String expectedInv : expected) {
			testInvariant(msg, iterator.next(), expectedInv);
		}
	}

	/**
	 * @param string
	 * @param state
	 */
	public void testStateNestedStatemachine(String msg, State state,
			String... expected) {
		EList<Statemachine> statemachines = state.getStatemachines();
		Iterator<Statemachine> iterator = statemachines.iterator();
		testStatemachines(msg, iterator, expected);
	}

	/**
	 * @param string
	 * @param transition
	 * @param string2
	 */
	public void testTransitionSourceAndTarget(String msg,
			Transition transition, AbstractNode expectedSource,
			AbstractNode expectedTarget) {
		AbstractNode source = transition.getSource();
		AbstractNode target = transition.getTarget();
		assertSameReferences(msg + ": Incorrect source", source, expectedSource);
		assertSameReferences(msg + ": Incorrect target", target, expectedTarget);
	}

	/**
	 * @param string
	 * @param transition
	 */
	public void testTransitionElaborates(String msg, Transition transition,
			Event... expected) {
		EList<Event> elaborates = transition.getElaborates();
		assertEquals(msg + ": Incorrect number of elaborations",
				expected.length, elaborates.size());
		Iterator<Event> iterator = elaborates.iterator();
		for (Event expectedEvt : expected) {
			assertSameReferences(msg, iterator.next(), expectedEvt);
		}
	}

}