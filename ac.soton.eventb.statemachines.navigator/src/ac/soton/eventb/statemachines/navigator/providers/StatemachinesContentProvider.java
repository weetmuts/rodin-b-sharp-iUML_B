/*******************************************************************************
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package ac.soton.eventb.statemachines.navigator.providers;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eventb.core.IMachineRoot;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.statemachines.diagram.navigator.StatemachinesDomainNavigatorContentProvider;
import ac.soton.eventb.statemachines.diagram.navigator.StatemachinesDomainNavigatorItem;

/**
 * Content provider for statemachine items in the navigator.
 * Extends generated content provider for statemachine diagrams and shows statemachine elements within a Rodin machine.
 * 
 * @author vitaly
 *
 */
public class StatemachinesContentProvider extends StatemachinesDomainNavigatorContentProvider {

	/* (non-Javadoc)
	 * @see ac.soton.eventb.statemachines.diagram.navigator.StatemachinesDomainNavigatorContentProvider#getChildren(java.lang.Object)
	 */
	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IMachineRoot) {
			IMachineRoot root = (IMachineRoot) parentElement;
			URI fileURI = URI.createPlatformResourceURI(root.getResource().getFullPath().toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(fileURI, true);
			if (resource.isLoaded()) {
				Machine machine = (Machine) resource.getContents().get(0);
				return wrapEObjects(
						machine.getExtensions().toArray(),
						parentElement);
			}
		}
		
		if (parentElement instanceof StatemachinesDomainNavigatorItem) {
			return wrapEObjects(
					myAdapterFctoryContentProvier.getChildren(((StatemachinesDomainNavigatorItem) parentElement)
							.getEObject()), parentElement);
		}
		return EMPTY_ARRAY;
	}

	/* (non-Javadoc)
	 * @see ac.soton.eventb.statemachines.diagram.navigator.StatemachinesDomainNavigatorContentProvider#hasChildren(java.lang.Object)
	 */
	@Override
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}
}
