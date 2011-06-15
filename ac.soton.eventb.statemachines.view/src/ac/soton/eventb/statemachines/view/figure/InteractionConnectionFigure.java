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
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.swt.SWT;

/**
 * Interaction view connection figure.
 * Draws polyline connection with a tag label attached to a midpoint.
 * 
 * @author vitaly
 *
 */
public class InteractionConnectionFigure extends PolylineConnection {

	private Label label;

	/**
	 * Constructs interaction connection figure.
	 * 
	 * @param name connection label
	 */
	public InteractionConnectionFigure(String name) {
		super();
		setAntialias(SWT.ON);
		setLineStyle(SWT.LINE_DASH);
		setLineWidth(2);
		
		// standard midpoint locator for connection label,
		// but overridden to return first point from the middle of a list of bend points if there are more than two points in connection
		MidpointLocator relationshipLocator = new MidpointLocator(this, 0) {

			@Override
			protected int getIndex() {
				PointList points = getConnection().getPoints();
				if (points != null) {
					return points.size() / 2 - 1;
				}
				return super.getIndex();
			}
		};
		relationshipLocator.setRelativePosition(PositionConstants.NORTH_EAST);
		relationshipLocator.setGap(2);
		label = new TagLabel(name);
		add(label, relationshipLocator);
	}

	@Override
	protected void outlineShape(Graphics g) {
		g.setAntialias(SWT.ON);
		super.outlineShape(g);
	}

	/* NOTE:
	 * Overridden to prevent revalidation of connection and consequently the whole layout as constraints are set.
	 * Only sets constraints if they are different from current constraints.
	 */
	@Override
	public void setRoutingConstraint(Object cons) {
		Object current = getRoutingConstraint();
		boolean modified = cons != null && cons.equals(current) == false;
		if (modified)
			super.setRoutingConstraint(cons);
	}

}
