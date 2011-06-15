/**
 * Copyright (c) 2011 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.view;

import org.eclipse.core.resources.IFile;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.FreeformGraphicalRootEditPart;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.eventb.core.IMachineRoot;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.statemachines.AbstractState;
import ac.soton.eventb.statemachines.diagram.navigator.StatemachinesDomainNavigatorItem;
import ac.soton.eventb.statemachines.view.factory.InteractionViewEditPartFactory;
import ac.soton.eventb.statemachines.view.model.InteractionDiagram;

/**
 * Interaction view.
 * Listens for selection in a workbench page and displays
 * interaction graph in a viewer for acceptable selection
 * input (either Machine or AbstractState).
 * 
 * @author vitaly
 *
 */
public class InteractionView extends ViewPart implements ISelectionListener {

	private GraphicalViewer graphicalViewer;
	private DefaultEditDomain editDomain;

	public InteractionView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		setEditDomain(new DefaultEditDomain(null));
		setGraphicalViewer(new ScrollingGraphicalViewer());
		getGraphicalViewer().createControl(parent);
		getGraphicalViewer().setRootEditPart(new FreeformGraphicalRootEditPart());
		getGraphicalViewer().setEditPartFactory(new InteractionViewEditPartFactory());
		getGraphicalViewer().getControl().setBackground(ColorConstants.listBackground);
		getViewSite().getPage().addSelectionListener(this);
	}

	/**
	 * @return
	 */
	private GraphicalViewer getGraphicalViewer() {
		return this.graphicalViewer;
	}

	/**
	 * @param viewer
	 */
	private void setGraphicalViewer(GraphicalViewer viewer) {
		getEditDomain().addViewer(viewer);
		graphicalViewer = viewer;
	}

	/**
	 * @return
	 */
	protected DefaultEditDomain getEditDomain() {
		return this.editDomain;
	}

	/**
	 * @param domain
	 */
	private void setEditDomain(DefaultEditDomain domain) {
		editDomain = domain;
	}

	@Override
	public void setFocus() {
		getGraphicalViewer().getControl().setFocus();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			Object first = ((IStructuredSelection) selection).getFirstElement();
			
			// navigator elements
			if (first instanceof IMachineRoot) {
				IFile file = ((IMachineRoot) first).getResource();
				URI uri = URI.createPlatformResourceURI(file.getFullPath().toOSString(), true);
				ResourceSet rs = new ResourceSetImpl();
				Resource res = rs.getResource(uri, true);
				if (res.isLoaded() && res.getContents().isEmpty() == false)
					first = res.getContents().get(0);
			} else if (first instanceof StatemachinesDomainNavigatorItem) {
				first = ((StatemachinesDomainNavigatorItem) first).getEObject();
			}
			
			// model elements
			if (first instanceof Machine) {
				getGraphicalViewer().setContents(new InteractionDiagram((Machine) first));
			} else if (first instanceof AbstractState) {
				getGraphicalViewer().setContents(new InteractionDiagram((AbstractState) first));
			}
		}
	}

}
