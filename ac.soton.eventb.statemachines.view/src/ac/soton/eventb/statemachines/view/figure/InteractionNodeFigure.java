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
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;

/**
 * @author vitaly
 *
 */
public class InteractionNodeFigure extends Figure {

	private static final Color NODE_BACK = new Color(null, 240, 240, 255);
	private static final Color NODE_BACK2 = new Color(null, 196, 204, 255);
	private static final int STANDARD_LABEL_WIDTH = 85;
	
	private RectangleFigure rectangleFigure;
	private Label label;

	/**
	 * 
	 */
	public InteractionNodeFigure(String name) {
		int width = getLabelWidth(name);
		setLayoutManager(new XYLayout());
		rectangleFigure = new RectangleFigure();
		rectangleFigure.setBackgroundColor(NODE_BACK2);
		rectangleFigure.setSize(new Dimension(width, 30));
		add(rectangleFigure);
		label = new Label();
		label.setText(name);
		add(label);
	}

	/**
	 * @param text
	 * @return
	 */
	private int getLabelWidth(String text) {
		int standardLabelWidth = STANDARD_LABEL_WIDTH;
		GC gc = new GC(Display.getCurrent());
		int indent = gc.textExtent("XXX").x;
		int width = gc.textExtent(text).x;
		if (width + indent > standardLabelWidth)
			standardLabelWidth = width + indent;
		gc.dispose();
		return standardLabelWidth;
	}

	/**
	 * @return
	 */
	public RectangleFigure getRectangleFigure() {
		return rectangleFigure;
	}

	/**
	 * @return
	 */
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
