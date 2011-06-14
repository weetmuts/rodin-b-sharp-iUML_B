/**
 * Copyright (c) 2011 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.view.model;

import java.util.Iterator;
import java.util.List;

import org.eventb.emf.core.machine.Event;

/**
 * @author vitaly
 *
 */
public class InteractionEdge {

	private static final String DEFAULT_NAME = "";
	private static final Object NAME_SEPARATOR = ", ";
	
	private InteractionNode source;
	private InteractionNode target;
	private String name;

	/**
	 * @param source
	 * @param target
	 * @param events
	 */
	public InteractionEdge(InteractionNode source, InteractionNode target, List<Event> events) {
		setSource(source);
		setTarget(target);
		setName(events);
	}

	/**
	 * @return
	 */
	public InteractionNode getSource() {
		return source;
	}

	/**
	 * @return
	 */
	public InteractionNode getTarget() {
		return target;
	}

	/**
	 * @param newSource
	 */
	public void setSource(InteractionNode newSource) {
		if (source != null)
			source.removeSourceEdge(this);
		
		source = newSource;
		if (source != null)
			source.addSourceEdge(this);
	}

	/**
	 * @param newTarget
	 */
	public void setTarget(InteractionNode newTarget) {
		if (target != null)
			target.removeTargetEdge(this);
		
		target = newTarget;
		if (target != null)
			target.addTargetEdge(this);
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param events
	 */
	private void setName(List<Event> events) {
		StringBuilder result = new StringBuilder(DEFAULT_NAME);
		if (events.isEmpty() == false) {
			Iterator<Event> it = events.iterator();
			result.append(it.next().getName());
			while (it.hasNext()) {
				result.append(NAME_SEPARATOR);
				result.append(it.next().getName());
			}
		}
		name = result.toString();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
