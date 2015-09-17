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

package ac.soton.eventb.statemachines;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.EventBNamedCommentedElement;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Invariant;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachineFactory;
import org.eventb.emf.core.machine.MachinePackage;

import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;

/**
 * <p>
 * Utility class for manipulating Statemachines
 * </p>
 *
 * @author htson
 * @version
 * @see
 * @since
 */
public class StatemachinesUtils {

	/**
	 * Utility class has private default constructor.
	 */
	private StatemachinesUtils() {
		// Do nothing
	}

	public static Statemachine createStatemachine(
			TransactionalEditingDomain domain, Machine mch,
			AbstractExtension sibling, String name, Statemachine refinesSM,
			EventBNamedCommentedElement instances, String selfName,
			TranslationKind translation) {
		Statemachine statemachine = createStatemachine(name, refinesSM,
				instances, selfName, translation);

		Command cmd = AddCommand.create(domain, mch,
				MachinePackage.MACHINE__EXTENSIONS, statemachine);
		cmd.execute();

		return statemachine;

	}

	/**
	 * @param domain
	 * @param state
	 * @param sibling
	 * @param name
	 * @param refinesSM
	 * @param instances
	 * @param selfName
	 * @param singlevar
	 */
	public static Statemachine createStatemachine(
			TransactionalEditingDomain domain, State state,
			Statemachine sibling, String name, Statemachine refinesSM,
			EventBNamedCommentedElement instances, String selfName,
			TranslationKind translation) {
		Statemachine statemachine = createStatemachine(name, refinesSM,
				instances, selfName, translation);

		Command cmd = AddCommand
				.create(domain,
						state,
						StatemachinesPackage.Literals.STATEMACHINE_OWNER__STATEMACHINES,
						statemachine);
		cmd.execute();

		return statemachine;
	}

	/**
	 * @param name
	 * @param refinesSM
	 * @param instances
	 * @param selfName
	 * @param translation
	 * @return
	 */
	private static Statemachine createStatemachine(String name,
			Statemachine refinesSM, EventBNamedCommentedElement instances,
			String selfName, TranslationKind translation) {
		Statemachine statemachine = StatemachinesFactory.eINSTANCE
				.createStatemachine();
		statemachine.setName(name);
		statemachine.setRefines(refinesSM);
		statemachine.setInstances(instances);
		statemachine.setSelfName(selfName);
		statemachine.setTranslation(translation);

		return statemachine;
	}

	/**
	 * @param mch
	 * @return
	 */
	public static List<Statemachine> getStatemachines(Machine mch) {
		List<Statemachine> statemachines = new ArrayList<Statemachine>();
		EList<AbstractExtension> extensions = mch.getExtensions();
		for (AbstractExtension extension : extensions) {
			if (extension instanceof Statemachine)
				statemachines.add((Statemachine) extension);
		}
		return statemachines;
	}

	/**
	 * @param domain
	 * @param statemachine
	 * @return
	 */
	public static Initial createInitialState(TransactionalEditingDomain domain,
			Statemachine statemachine, String name) {
		Initial initialState = StatemachinesFactory.eINSTANCE.createInitial();
		initialState.setName(name);

		Command cmd = AddCommand.create(domain, statemachine,
				StatemachinesPackage.Literals.INITIAL, initialState);
		cmd.execute();
		return initialState;
	}

	/**
	 * @param domain
	 * @param statemachine
	 * @return
	 */
	public static Final createFinalState(TransactionalEditingDomain domain,
			Statemachine statemachine, String name) {
		Final finalState = StatemachinesFactory.eINSTANCE.createFinal();
		finalState.setName(name);

		Command cmd = AddCommand.create(domain, statemachine,
				StatemachinesPackage.Literals.FINAL, finalState);
		cmd.execute();
		return finalState;
	}

	/**
	 * @param domain
	 * @param statemachine
	 * @return
	 */
	public static State createState(TransactionalEditingDomain domain,
			Statemachine statemachine, String name, State absState) {
		State state = StatemachinesFactory.eINSTANCE.createState();
		state.setName(name);
		state.setRefines(absState);

		Command cmd = AddCommand.create(domain, statemachine,
				StatemachinesPackage.Literals.STATE, state);
		cmd.execute();
		return state;
	}

	/**
	 * @param domain
	 * @param channelSM
	 * @param string
	 * @return
	 */
	public static Any createAny(TransactionalEditingDomain domain,
			Statemachine statemachine, String name) {
		Any anyState = StatemachinesFactory.eINSTANCE.createAny();
		anyState.setName(name);

		Command cmd = AddCommand.create(domain, statemachine,
				StatemachinesPackage.Literals.ANY, anyState);
		cmd.execute();
		return anyState;
	}

	/**
	 * @param domain
	 * @param statemachine
	 * @param name
	 * @return
	 */
	public static Fork createFork(TransactionalEditingDomain domain,
			Statemachine statemachine, String name) {
		Fork forkState = StatemachinesFactory.eINSTANCE.createFork();
		forkState.setName(name);

		Command cmd = AddCommand.create(domain, statemachine,
				StatemachinesPackage.Literals.FORK, forkState);
		cmd.execute();
		return forkState;
	}

	/**
	 * @param domain
	 * @param statemachine
	 * @param name
	 * @return
	 */
	public static Junction createJunction(TransactionalEditingDomain domain,
			Statemachine statemachine, String name) {
		Junction junctionState = StatemachinesFactory.eINSTANCE
				.createJunction();
		junctionState.setName(name);

		Command cmd = AddCommand.create(domain, statemachine,
				StatemachinesPackage.Literals.JUNCTION, junctionState);
		cmd.execute();
		return junctionState;
	}

	/**
	 * @param domain
	 * @param state
	 * @param name
	 * @param predicate
	 * @param isTheorem
	 */
	public static Invariant createInvariant(TransactionalEditingDomain domain,
			State state, String name, String predicate, boolean isTheorem) {
		Invariant inv = MachineFactory.eINSTANCE.createInvariant();
		inv.setName(name);
		inv.setPredicate(predicate);
		inv.setTheorem(isTheorem);

		Command cmd = AddCommand.create(domain, state,
				MachinePackage.Literals.INVARIANT, inv);
		cmd.execute();

		return inv;
	}

	/**
	 * @param domain
	 * @param initialState
	 * @param state
	 */
	public static Transition createTransition(
			TransactionalEditingDomain domain, Statemachine statemachine,
			AbstractNode source, AbstractNode target) {
		Transition transition = StatemachinesFactory.eINSTANCE
				.createTransition();
		transition.setSource(source);
		transition.setTarget(target);

		Command cmd = AddCommand.create(domain, statemachine,
				StatemachinesPackage.Literals.STATEMACHINE__TRANSITIONS,
				transition);
		cmd.execute();
		return transition;
	}

	/**
	 * @param domain
	 * @param transition
	 * @param channel_init
	 */
	public static void addElaboration(TransactionalEditingDomain domain,
			Transition transition, Event channel_init) {
		Command cmd = AddCommand.create(domain, transition,
				CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__ELABORATES,
				channel_init);
		cmd.execute();
	}


}