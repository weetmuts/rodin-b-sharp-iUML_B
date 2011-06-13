/**
 * Copyright (c) 2011 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.view.figure;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

/**
 * @author vitaly
 *
 */
public class InteractionNodeFigure extends Figure {

	private static final Color NODE_BACK = new Color(null, 240, 240, 255);
	private RectangleFigure rectangleFigure;
	private Label label;

	/**
	 * 
	 */
	public InteractionNodeFigure(String name) {
		setLayoutManager(new XYLayout());
		rectangleFigure = new RectangleFigure();
		rectangleFigure.setBackgroundColor(NODE_BACK);
		rectangleFigure.setLocation(new Point(50,50));
		rectangleFigure.setSize(new Dimension(55, 30));
		add(rectangleFigure);
		label = new Label();
		label.setText(name);
		add(this.label);
		
	}

	public RectangleFigure getRectangleFigure() {
		return rectangleFigure;
	}

	public Label getLabel() {
		return label;
	}

	@Override
	protected void paintFigure(Graphics graphics) {
		Rectangle r = getBounds().getCopy();
		setConstraint(getRectangleFigure(), new Rectangle(0, 0, r.width, r.height));
		setConstraint(getLabel(), new Rectangle(0, 0, r.width, r.height));
		getRectangleFigure().invalidate();
		getLabel().invalidate();
	}

}
