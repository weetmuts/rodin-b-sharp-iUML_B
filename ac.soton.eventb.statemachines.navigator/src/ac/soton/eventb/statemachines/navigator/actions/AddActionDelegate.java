/*******************************************************************************
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ac.soton.eventb.statemachines.navigator.actions;

import java.net.URL;
import java.util.ArrayList;

import org.eclipse.emf.edit.provider.ChildCreationExtenderManager;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;

import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.provider.StatemachinesEditPlugin;

/**
 * Add action delegate.
 * A pulldown navigator toolbar action with a menu of items to add to a machine.
 * 
 * @author vitaly
 *
 */
public class AddActionDelegate implements IViewActionDelegate, IMenuCreator {
	
	private static ChildCreationExtenderManager childCreationExtender = new ChildCreationExtenderManager(StatemachinesEditPlugin.INSTANCE, StatemachinesPackage.eNS_URI);

	private IAction action;
	private ArrayList<IAction> subactions = new ArrayList<IAction>();
	private Menu menu;


	@Override
	public void run(IAction action) {
		if (!subactions.isEmpty())
			subactions.get(0).run();
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		if (action != this.action) {
			action.setMenuCreator(this);
			action.setToolTipText("Create new statemachine");
			action.setImageDescriptor(ImageDescriptor.createFromURL((URL) childCreationExtender.getImage("full/ctool16/CreateStatemachineOwner_statemachines_Statemachine")));
			this.action = action;
		}
	}

	@Override
	public void dispose() {
		if (menu != null)
			menu.dispose();
	}

	@Override
	public Menu getMenu(Control parent) {
		if (menu == null || parent == null || menu.getParent() != parent.getShell()) {
			dispose();
			menu = new Menu(parent);
			for (IAction action : subactions)
				addActionToMenu(menu, action);
		}
		return menu;
	}

	private void addActionToMenu(Menu menu, IAction action) {
		ActionContributionItem item = new ActionContributionItem(action);
		item.fill(menu, -1);
	}

	@Override
	public Menu getMenu(Menu parent) {
		return null;
	}

	@Override
	public void init(IViewPart view) {
		Action statemachineAction = new AddStatemachineAction("Statemachine", view);
		statemachineAction.setId("statemachine");
		statemachineAction.setImageDescriptor(ImageDescriptor.createFromURL((URL) childCreationExtender.getImage("full/ctool16/CreateStatemachineOwner_statemachines_Statemachine")));
		statemachineAction.setToolTipText("Create new statemachine");
		subactions.add(statemachineAction);

		//TODO: implement action to create a refined statemachine
//		Action refinedStatemachineAction = new Action("Refined Statemachine") {};
//		refinedStatemachineAction.setId("refinedStatemachine");
//		refinedStatemachineAction.setImageDescriptor(ImageDescriptor.createFromURL((URL) childCreationExtender.getImage("full/ctool16/CreateStatemachineOwner_statemachines_RefinedStatemachine")));
//		refinedStatemachineAction.setToolTipText("Create new refined statemachine");
//		subactions.add(refinedStatemachineAction);
	}

}
