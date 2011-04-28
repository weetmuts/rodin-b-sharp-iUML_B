/*******************************************************************************
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ac.soton.eventb.statemachines.navigator.refiner;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eventb.core.IEvent;
import org.eventb.core.IMachineRoot;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.MachinePackage;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IRefinementParticipant;
import org.rodinp.core.RodinDBException;

import ac.soton.eventb.statemachines.AbstractNode;
import ac.soton.eventb.statemachines.AbstractState;
import ac.soton.eventb.statemachines.AbstractStatemachine;
import ac.soton.eventb.statemachines.RefinedState;
import ac.soton.eventb.statemachines.RefinedStatemachine;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachinesFactory;
import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.Transition;
import ac.soton.eventb.statemachines.persistence.IRefinedStatemachine;
import ac.soton.eventb.statemachines.persistence.IStatemachine;

public class StatemachineRefiner implements IRefinementParticipant {

	private static ResourceSetImpl rSet;

	/**
	 * Constructor.
	 * Creates a resource set for serialising/deserialising statemachine string.
	 */
	public StatemachineRefiner() {
		rSet = new ResourceSetImpl();
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		rSet.getPackageRegistry().put(StatemachinesPackage.eNS_URI, StatemachinesPackage.eINSTANCE);
	}

	@Override
	public void process(IInternalElement targetRoot,
			IInternalElement sourceRoot, IProgressMonitor monitor)
			throws RodinDBException {
		Map<String, EObject> refinementMap = new HashMap<String, EObject>();
		final IMachineRoot con = (IMachineRoot) targetRoot;
		final IMachineRoot abs = (IMachineRoot) sourceRoot;
		mapRefinedEvents(con, abs, refinementMap, monitor);
		createRefinedStatemachines(con, abs, refinementMap, monitor);
	}

	/**
	 * @param con
	 * @param abs
	 * @param refinementMap
	 * @param monitor
	 * @throws RodinDBException 
	 */
	private void mapRefinedEvents(IMachineRoot con, IMachineRoot abs,
			Map<String, EObject> refinementMap, IProgressMonitor monitor) throws RodinDBException {
		IEvent[] absEvents = abs.getChildrenOfType(IEvent.ELEMENT_TYPE);
		for (IEvent absEvent : absEvents) {
			IEvent conEvent = con.getEvent(absEvent.getLabel());
			
			// create URI
			String machineName = con.getComponentName() + ".bum";
			String projectName = con.getRodinProject().getElementName();
			URI uri = URI.createURI("platform:/resource/" + projectName + "/" + machineName + "#" + "org.eventb.emf.core.machine.Event." + conEvent.getElementName());
			
			// use proxy instead of real EMF event
			EObject emfEvent = EMFCoreUtil.createProxy(MachinePackage.eINSTANCE.getEvent(), uri);
			refinementMap.put(absEvent.getLabel(), emfEvent);
		}
	}

	/**
	 * @param con
	 * @param abs
	 * @param refinementMap 
	 * @param monitor
	 * @throws RodinDBException 
	 */
	private void createRefinedStatemachines(IMachineRoot con, IMachineRoot abs,
			Map<String, EObject> refinementMap, IProgressMonitor monitor) throws RodinDBException {
		IStatemachine[] statemachines = abs.getChildrenOfType(IStatemachine.ELEMENT_TYPE);
//		IRefinedStatemachine[] refinedStatemachines = abs.getChildrenOfType(IRefinedStatemachine.ELEMENT_TYPE);
		
		for (IStatemachine statemachine : statemachines) {
			createRefinedStatemachine(con, statemachine, refinementMap, monitor);
		}
	}

	/**
	 * @param con
	 * @param refinementMap 
	 * @param statemachine
	 * @param monitor
	 * @throws RodinDBException 
	 */
	private void createRefinedStatemachine(IMachineRoot con,
			IStatemachine absStatemachine, Map<String, EObject> refinementMap, IProgressMonitor monitor) throws RodinDBException {
		IRefinedStatemachine conStatemachine = con.createChild(IRefinedStatemachine.ELEMENT_TYPE, null, monitor);
		conStatemachine.setSerialised(refineSerialised(absStatemachine.getSerialised(), refinementMap, monitor), monitor);
	}

	/**
	 * @param serialised serialised content string from abstract element
	 * @param refinementMap 
	 * @param monitor progress monitor
	 * @return refined serialised content
	 * @throws RodinDBException 
	 */
	private String refineSerialised(String serialised, Map<String, EObject> refinementMap, IProgressMonitor monitor) throws RodinDBException {
		// dummy resource for serialisation/deserialisation of string
		Resource resource = rSet.createResource(URI.createURI("http:///My.stm"));
		try {
			resource.load(new URIConverter.ReadableInputStream(serialised), null);
			AbstractStatemachine abstractStatemachine = (AbstractStatemachine) resource.getContents().get(0);
			RefinedStatemachine refinedStatemachine = refineStatemachinesExtension(abstractStatemachine, refinementMap);
			return XMIHelperImpl.saveString(Collections.emptyMap(), Collections.singletonList(refinedStatemachine), "UTF-8", null);
		} catch (Exception e) {
			throw new RodinDBException(e, IStatus.ERROR);
		}
	}

	/**
	 * Returns refined statemachine from abstract statemachine, which is a root extension.
	 * 
	 * @param rootAbstractStatemachine root abstract statemachine
	 * @param refinementMap map of refinements so far
	 * @return refined statemachine
	 */
	private RefinedStatemachine refineStatemachinesExtension(AbstractStatemachine rootAbstractStatemachine, Map<String, EObject> refinementMap) {
		// refine statemachines, states and substates
		RefinedStatemachine refinedStatemachine = refineAbstractStatemachine(rootAbstractStatemachine, refinementMap);
		
		// remember refined statemachine as it is used by transition refinement
		refinementMap.put(EcoreUtil.getIdentification(rootAbstractStatemachine), refinedStatemachine);
		
		// refine transitions
		refineTransitions(rootAbstractStatemachine, refinementMap);
		
		return refinedStatemachine;
	}

	/**
	 * Returns refined statemachine from abstract statemachine.
	 * 
	 * @param abstractStatemachine
	 * @param refinementMap map of refinements so far
	 * @return refined statemachine
	 */
	private RefinedStatemachine refineAbstractStatemachine(AbstractStatemachine abstractStatemachine, Map<String, EObject> refinementMap) {
		// create refined statemachine
		RefinedStatemachine refinedStatemachine = StatemachinesFactory.eINSTANCE.createRefinedStatemachine();
		refinedStatemachine.setRefines(abstractStatemachine);
		
		// keep same extension id
		String extensionID = abstractStatemachine instanceof Statemachine ? ((Statemachine) abstractStatemachine).getExtensionId() :
			abstractStatemachine instanceof RefinedStatemachine ? ((RefinedStatemachine) abstractStatemachine).getExtensionId() : null;
		if (extensionID != null)
			refinedStatemachine.setExtensionId(extensionID);
		
		// create nodes
		for (AbstractNode node : abstractStatemachine.getNodes()) {
			AbstractNode newNode = null;
			if (node instanceof AbstractState) {
				newNode = refineAbstractState((AbstractState) node, refinementMap);
			} else {
				newNode = (AbstractNode) StatemachinesFactory.eINSTANCE.create(node.eClass());
			}
			refinedStatemachine.getNodes().add(newNode);
			
			// remember node mapping
			refinementMap.put(EcoreUtil.getIdentification(node), newNode);
		}
		
		return refinedStatemachine;
	}

	/**
	 * Returns refined state from abstract state.
	 * 
	 * @param abstractState
	 * @param refinementMap map of refinements so far
	 * @return refined state
	 */
	private RefinedState refineAbstractState(AbstractState abstractState, Map<String, EObject> refinementMap) {
		// create refined state
		RefinedState refinedState = StatemachinesFactory.eINSTANCE.createRefinedState();
		refinedState.setRefines(abstractState);
		
		// create refined statemachines
		for (AbstractStatemachine abstractStatemachine : abstractState.getStatemachines()) {
			RefinedStatemachine refinedStatemachine = refineAbstractStatemachine(abstractStatemachine, refinementMap);
			refinedState.getStatemachines().add(refinedStatemachine);
			
			// remember refined statemachine mapping
			refinementMap.put(EcoreUtil.getIdentification(abstractStatemachine), refinedStatemachine);
		}
		
		return refinedState;
	}
	
	/**
	 * Refines transitions in abstract statemachine.
	 * 
	 * @param abstractStatemachine
	 * @param refinementMap map of refinements so far
	 */
	private void refineTransitions(AbstractStatemachine abstractStatemachine, Map<String, EObject> refinementMap) {
		// find owner in map
		AbstractStatemachine owner = (AbstractStatemachine) refinementMap.get(EcoreUtil.getIdentification(abstractStatemachine));
		
		// process transitions of current abstract statemachine
		for (Transition transition : abstractStatemachine.getTransitions()) {
			Transition newTransition = StatemachinesFactory.eINSTANCE.createTransition();
			
			// set source and target
			newTransition.setSource((AbstractNode) refinementMap.get(EcoreUtil.getIdentification(transition.getSource())));
			newTransition.setTarget((AbstractNode) refinementMap.get(EcoreUtil.getIdentification(transition.getTarget())));
			
			// set elaborates
			for (Event event : transition.getElaborates()) {
				EObject refinedEvent = refinementMap.get(event.getName());
				if (refinedEvent != null)
					newTransition.getElaborates().add((Event) refinedEvent);
			}
			
			// set owner
			if (owner != null) owner.getTransitions().add(newTransition);
			
			// remember transition mapping
			refinementMap.put(EcoreUtil.getIdentification(transition), newTransition);
		}
		
		
		// process abstract statemachines in nodes
		for (AbstractNode node : abstractStatemachine.getNodes())
			if (node instanceof AbstractState)
				for (AbstractStatemachine nodeAbstractStatemachine : ((AbstractState) node).getStatemachines())
					refineTransitions(nodeAbstractStatemachine, refinementMap);
	}
}
