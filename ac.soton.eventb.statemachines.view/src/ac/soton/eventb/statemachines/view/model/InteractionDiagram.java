/**
 * Copyright (c) 2011 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.view.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.statemachines.AbstractState;
import ac.soton.eventb.statemachines.AbstractStatemachine;
import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.Transition;

/**
 * @author vitaly
 *
 */
public class InteractionDiagram {

	private static final Object INIT_EVENT_NAME = "INITIALISATION";
	
	private ArrayList<InteractionNode> nodes = new ArrayList<InteractionNode>();
	private ArrayList<InteractionEdge> edges = new ArrayList<InteractionEdge>();

	/**
	 * @param element
	 */
	public InteractionDiagram(Machine element) {
		createNodes(element);
		createEdges();
	}

	/**
	 * @param element
	 */
	public InteractionDiagram(AbstractState element) {
		createNodes(element);
		createEdges();
	}

	/**
	 * @param machine
	 */
	private void createNodes(Machine machine) {
		nodes.clear();
		EList<AbstractExtension> extensions = machine.getExtensions();
		for (AbstractExtension e : extensions)
			if (e instanceof AbstractStatemachine)
				nodes.add(new InteractionNode((AbstractStatemachine) e));
	}

	/**
	 * @param state
	 */
	private void createNodes(AbstractState state) {
		nodes.clear();
		for (AbstractStatemachine statemachine : state.getStatemachines())
			nodes.add(new InteractionNode(statemachine));
	}

	/**
	 * @return
	 */
	public ArrayList<InteractionNode> getNodes() {
		return nodes;
	}

	/**
	 * 
	 */
	private void createEdges() {
		edges.clear();
		Stack<InteractionNode> remainingNodes = new Stack<InteractionNode>();
		remainingNodes.addAll(nodes);
		while (remainingNodes.size() > 1) {
			InteractionNode node1 = remainingNodes.pop();
			for (InteractionNode node2 : remainingNodes) {
				List<Event> commons = checkForInteraction(node1, node2);
				if (commons.isEmpty() == false)
					edges.add(new InteractionEdge(node1, node2, commons));
			}
		}
	}

	/**
	 * @return
	 */
	public ArrayList<InteractionEdge> getEdges() {
		return edges;
	}

	/**
	 * @param node1
	 * @param node2
	 * @return
	 */
	private List<Event> checkForInteraction(InteractionNode node1, InteractionNode node2) {
		EList<EObject> transitions1 = node1.getElement().getAllContained(StatemachinesPackage.Literals.TRANSITION, true);
		EList<EObject> transitions2 = node2.getElement().getAllContained(StatemachinesPackage.Literals.TRANSITION, true);
		
		// collect elaborated events from first state machine
		Set<Event> first = new HashSet<Event>();
		for (EObject transition : transitions1)
			if (transition != null)
				first.addAll(((Transition) transition).getElaborates());
		
		// collect elaborated events from second state machine
		Set<Event> second = new HashSet<Event>();
		for (EObject transition : transitions2)
			if (transition != null)
				second.addAll(((Transition) transition).getElaborates());
		
		// intersection of both
		first.retainAll(second);
		
		// remove INITIALISATION event from result
		for (Iterator<Event> it = first.iterator(); it.hasNext(); )
			if (INIT_EVENT_NAME.equals(it.next().getName()))
				it.remove();
		
		return new ArrayList<Event>(first);
	}

}
