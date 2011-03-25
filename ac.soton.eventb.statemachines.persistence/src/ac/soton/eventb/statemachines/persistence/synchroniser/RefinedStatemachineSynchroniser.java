/**
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.persistence.synchroniser;

import java.io.IOException;
import java.io.StringReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter.ReadableInputStream;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.persistence.synchroniser.AbstractSynchroniser;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

import ac.soton.eventb.statemachines.RefinedStatemachine;
import ac.soton.eventb.statemachines.StatemachinesFactory;
import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.persistence.IAbstractStatemachine;
import ac.soton.eventb.statemachines.persistence.IRefinedStatemachine;
import ac.soton.eventb.statemachines.persistence.StatemachinesPersistencePlugin;

/**
 * RefinedStatemachine synchroniser.
 * Serialises refined statemachine to a string attribute and deserialises it back to EMF object.
 * 
 * @author vitaly
 *
 */
public class RefinedStatemachineSynchroniser extends AbstractSynchroniser {

	private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();

	static {
		handledAttributes.add(IAbstractStatemachine.SERIALISED_ATTRIBUTE);
	}

	@Override
	protected IInternalElementType<?> getRodinType() {
		return IRefinedStatemachine.ELEMENT_TYPE;
	}

	@Override
	protected EStructuralFeature getFeature() {
		return CorePackage.eINSTANCE.getEventBElement_Extensions();
	}

	@Override
	protected Set<IAttributeType> getHandledAttributeTypes() {
		return handledAttributes;
	}

	@Override
	protected EventBElement createEventBElement() {
		return StatemachinesFactory.eINSTANCE.createRefinedStatemachine();
	}

	@Override
	public <T extends EventBElement> EventBElement load(
			IRodinElement rodinElement, EventBElement emfParent,
			IProgressMonitor monitor) throws RodinDBException {
		
		assert rodinElement instanceof IRefinedStatemachine;
		IRefinedStatemachine statemachine = (IRefinedStatemachine) rodinElement;
		
		// create EMF node
		RefinedStatemachine eventBElement = (RefinedStatemachine) super.load(rodinElement, emfParent, monitor);
		
		if (statemachine.hasSerialised() && !statemachine.getSerialised().isEmpty()) {
			String loadString = statemachine.getSerialised();
			
			// use a resource to deserialise an attribute string
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
			resourceSet.getPackageRegistry().put(StatemachinesPackage.eNS_URI, StatemachinesPackage.eINSTANCE);
			try {
				
				// dummy resource that loads from input stream to desired EMF object
				Resource resource = resourceSet.createResource(URI.createURI("http:///My.stm"));
				ReadableInputStream in = new ReadableInputStream(new StringReader(loadString));
				resource.load(in, null);
				if (!resource.getContents().isEmpty()) {
					RefinedStatemachine rsm = (RefinedStatemachine) resource.getContents().get(0);
					eventBElement.getNodes().addAll(rsm.getNodes());
					eventBElement.getTransitions().addAll(rsm.getTransitions());
					eventBElement.setRefines(rsm.getRefines());
					eventBElement.setExtensionId(rsm.getExtensionId());
				}
			}
			catch (IOException e) {
				RodinCore.getPlugin().getLog().log(
						new Status(IStatus.ERROR, StatemachinesPersistencePlugin.PLUGIN_ID, "Error when trying to deserialise a Refined Statemachine.", e));
				return null;
			}
		}
		
		return eventBElement;
	}

	@Override
	public IRodinElement save(EventBElement emfElement,
			IRodinElement rodinParent, IProgressMonitor monitor)
			throws RodinDBException {
		
		// create Rodin element
		IRodinElement rodinElement = super.save(emfElement, rodinParent, monitor);
		if (rodinElement instanceof IRefinedStatemachine && emfElement instanceof RefinedStatemachine) {
			String saveString;
			try {
				saveString = XMIHelperImpl.saveString(Collections.emptyMap(), Collections.singletonList(emfElement), "UTF-8", null);
				((IRefinedStatemachine) rodinElement).setSerialised(saveString, monitor);
			} catch (Exception e) {
				RodinCore.getPlugin().getLog().log(
						new Status(IStatus.ERROR, StatemachinesPersistencePlugin.PLUGIN_ID, "Error when trying to serialise a Refined Statemachine.", e));
				return null;
			}
		}
		return rodinElement;
	}

}
