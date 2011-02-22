/*******************************************************************************
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ac.soton.eventb.statemachines.navigator.providers;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;

import ac.soton.eventb.statemachines.navigator.actions.DeleteStatemachineAction;
import ac.soton.eventb.statemachines.navigator.actions.OpenStatemachineAction;

/**
 * Statemachines action provider class.
 * Provides open action for opening statemachine diagrams and delete action for deleting statemachines.
 * 
 * @author vitaly
 *
 */
public class StatemachinesActionProvider extends CommonActionProvider {
	
	private Action dblClickAction;
	private Action deleteAction;

	/* (non-Javadoc)
	 * @see org.eclipse.ui.navigator.CommonActionProvider#init(org.eclipse.ui.navigator.ICommonActionExtensionSite)
	 */
	@Override
	public void init(ICommonActionExtensionSite aSite) {
		super.init(aSite);
		dblClickAction = new OpenStatemachineAction(aSite);
		aSite.getStructuredViewer().addSelectionChangedListener((ISelectionChangedListener) dblClickAction);
		deleteAction = new DeleteStatemachineAction(aSite);
		aSite.getStructuredViewer().addSelectionChangedListener((ISelectionChangedListener) deleteAction);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.actions.ActionGroup#fillActionBars(org.eclipse.ui.IActionBars)
	 */
	@Override
	public void fillActionBars(IActionBars actionBars) {
		super.fillActionBars(actionBars);
		actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, dblClickAction);
        actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(), deleteAction);
		actionBars.updateActionBars();
	}

	@Override
	public void fillContextMenu(IMenuManager menu) {
		super.fillContextMenu(menu);
		menu.appendToGroup(ICommonMenuConstants.GROUP_OPEN, dblClickAction);
		menu.appendToGroup(ICommonMenuConstants.GROUP_EDIT, deleteAction);
	}

}
