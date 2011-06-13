/**
 * Copyright (c) 2011 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.view.figure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MidpointLocator;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.swt.SWT;

/**
 * @author vitaly
 *
 */
public class InteractionConnectionFigure extends PolylineConnection {

	private Label label;

	/**
	 * 
	 */
	public InteractionConnectionFigure(String name) {
		super();
		
		MidpointLocator relationshipLocator = new MidpointLocator(this, 0);
		relationshipLocator.setRelativePosition(PositionConstants.NORTH_EAST);
		label = new Label(name);
		add(label, relationshipLocator);
	}

	@Override
	protected void outlineShape(Graphics g) {
		g.setAntialias(SWT.ON);
		super.outlineShape(g);
	}

}
