/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import ac.soton.eventb.statemachines.diagram.providers.StatemachinesElementTypes;
import ac.soton.eventb.statemachines.diagram.providers.StatemachinesModelingAssistantProvider;

/**
 * @generated
 */
public class StatemachinesModelingAssistantProviderOfRootStatemachineEditPart
		extends StatemachinesModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(6);
		types.add(StatemachinesElementTypes.Initial_2006);
		types.add(StatemachinesElementTypes.Final_2007);
		types.add(StatemachinesElementTypes.State_2008);
		types.add(StatemachinesElementTypes.Junction_2009);
		types.add(StatemachinesElementTypes.Any_2010);
		types.add(StatemachinesElementTypes.Fork_2011);
		return types;
	}

}
