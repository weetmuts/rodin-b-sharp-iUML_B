/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import org.eclipse.emf.ecore.EObject;
import org.eventb.emf.core.EventBCommented;

/**
 * Comment property section for EventBCommented.
 * 
 * @author vitaly
 *
 */
public class CommentPropertySection extends AbstractTextPropertySection {

	@Override
	protected String getPropertyNameLabel() {
		return "Comment:";
	}

	@Override
	protected void setPropertyValue(EObject object, Object value) {
		assert object instanceof EventBCommented;
		((EventBCommented) object).setComment((String) value);
	}

	@Override
	protected String getPropertyValueString() {
		String comment = ((EventBCommented) getEObject()).getComment();
		return comment == null ? "" : comment;
	}

	@Override
	protected String getPropertyChangeCommandName() {
		return "change comment";
	}

}
