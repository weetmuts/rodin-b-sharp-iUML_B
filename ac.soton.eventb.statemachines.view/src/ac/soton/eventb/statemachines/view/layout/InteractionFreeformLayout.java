/**
 * Copyright (c) 2011 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.view.layout;

import java.util.List;

import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author vitaly
 *
 */
public class InteractionFreeformLayout extends FreeformLayout {

	@Override
	public void layout(IFigure parent) {
		super.layout(parent);
		List<?> children = parent.getChildren();
		Point offset = getOrigin(parent);
		IFigure f;
		int n = 0;
		for (Object child : children) {
			f = (IFigure) child;
			Rectangle bounds = (Rectangle) getConstraint(f);
			if (bounds == null)
				continue;

			bounds.x = 50 + 100 * (n % 2);
			bounds.y = 50 + 70 * (n / 2);
			bounds = bounds.getTranslated(offset);
			f.setLocation(bounds.getLocation());
			f.validate();
			n++;
		}
	}

}
