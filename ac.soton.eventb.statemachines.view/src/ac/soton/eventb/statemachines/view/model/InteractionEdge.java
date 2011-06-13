/**
 * Copyright (c) 2011 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.view.model;

/**
 * @author vitaly
 *
 */
public class InteractionEdge {

	private InteractionNode source;
	private InteractionNode target;
	private String name;

	/**
	 * @param source
	 * @param target
	 */
	public InteractionEdge(String name, InteractionNode source, InteractionNode target) {
		setName(name);
		setSource(source);
		setTarget(target);
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
