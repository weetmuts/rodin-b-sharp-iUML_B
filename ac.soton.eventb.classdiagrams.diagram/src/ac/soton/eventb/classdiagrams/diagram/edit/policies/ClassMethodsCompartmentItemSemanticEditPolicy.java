/*
 * Copyright (c) 2012 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import ac.soton.eventb.classdiagrams.diagram.edit.commands.ClassMethodCreateCommand;
import ac.soton.eventb.classdiagrams.diagram.providers.ClassdiagramsElementTypes;

/**
 * @generated
 */
public class ClassMethodsCompartmentItemSemanticEditPolicy extends
		ClassdiagramsBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ClassMethodsCompartmentItemSemanticEditPolicy() {
		super(ClassdiagramsElementTypes.Class_2003);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (ClassdiagramsElementTypes.ClassMethod_3023 == req.getElementType()) {
			return getGEFWrapper(new ClassMethodCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
