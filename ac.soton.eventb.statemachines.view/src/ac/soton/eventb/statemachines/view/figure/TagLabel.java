/**
 * Copyright (c) 2011 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.view.figure;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

/**
 * @author vitaly
 *
 */
public class TagLabel extends Label {
	
	static final Border BORDER = new MarginBorder(2, 8, 2, 2);

	/**
	 * @param name
	 */
	public TagLabel(String name) {
		setText(name);
		setBorder(BORDER);
		setOpaque(true);
	}

	@Override
	protected void paintFigure(Graphics g) {
		super.paintFigure(g);
		g.setAntialias(SWT.ON);
		Rectangle r = getTextBounds();

		r.resize(0, -1).expand(1, 1);
		g.drawLine(r.x, r.y, r.right(), r.y); // Top line
		g.drawLine(r.x, r.bottom(), r.right(), r.bottom()); // Bottom line
		g.drawLine(r.right(), r.bottom(), r.right(), r.y); // Right line

		g.drawLine(r.x - 7, r.y + r.height / 2, r.x, r.y);
		g.drawLine(r.x - 7, r.y + r.height / 2, r.x, r.bottom());
	}
}
