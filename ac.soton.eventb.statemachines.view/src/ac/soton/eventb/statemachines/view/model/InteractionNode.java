/**
 * Copyright (c) 2011 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.view.model;

import java.util.LinkedList;
import java.util.List;

import ac.soton.eventb.statemachines.AbstractStatemachine;

/**
 * @author vitaly
 *
 */
public class InteractionNode {

	private AbstractStatemachine element;
	private List<InteractionEdge> sourceEdges;
	private List<InteractionEdge> targetEdges;

	/**
	 * @param element
	 */
	public InteractionNode(AbstractStatemachine element) {
		this.element = element;
		sourceEdges = new LinkedList<InteractionEdge>();
		targetEdges = new LinkedList<InteractionEdge>();
	}

	public AbstractStatemachine getElement() {
		return element;
	}

	public List<InteractionEdge> getSourceEdges() {
		return sourceEdges;
	}

	public List<InteractionEdge> getTargetEdges() {
		return targetEdges;
	}

	/**
	 * @param edge
	 */
	public void addSourceEdge(InteractionEdge edge) {
		sourceEdges.add(edge);
	}

	/**
	 * @param edge
	 */
	public void addTargetEdge(InteractionEdge edge) {
		targetEdges.add(edge);
	}

	/**
	 * @param edge
	 */
	public void removeSourceEdge(InteractionEdge edge) {
		sourceEdges.remove(edge);
	}

	/**
	 * @param edge
	 */
	public void removeTargetEdge(InteractionEdge edge) {
		targetEdges.remove(edge);
	}

}
