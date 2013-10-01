/**
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.sheet.custom;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eventb.emf.core.EventBNamedCommentedDerivedPredicateElement;

/**
 * Predicate property section for EventBNamedCommentedDerivedPredicateElement.
 * 
 * @author vitaly
 *
 */
public class PredicatePropertySection extends AbstractTextPropertySection {

	@Override
	protected String getPropertyNameLabel() {
		return "Predicate:";
	}

	@Override
	protected void setPropertyValue(EObject object, Object value) {
		((EventBNamedCommentedDerivedPredicateElement) object).setPredicate((String) value);
	}

	@Override
	protected String getPropertyValueString() {
		return ((EventBNamedCommentedDerivedPredicateElement) getEObject()).getPredicate();
	}

	@Override
	protected String getPropertyChangeCommandName() {
		return "change predicate";
	}

	@Override
	protected Text createTextWidget(Composite parent) {
		Text text = super.createTextWidget(parent);
		text.addModifyListener(PropertySectionUtil.eventBListener);
		text.setFont(PropertySectionUtil.rodinFont);
		return text;
	}

	@Override
	protected int numberOfRows() { return 3;}
}
