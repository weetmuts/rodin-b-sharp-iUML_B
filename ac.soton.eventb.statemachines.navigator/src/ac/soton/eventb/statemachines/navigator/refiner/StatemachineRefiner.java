/*******************************************************************************
 * Copyright (c) 2011 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ac.soton.eventb.statemachines.navigator.refiner;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eventb.core.IMachineRoot;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.MachinePackage;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IRefinementParticipant;
import org.rodinp.core.RodinDBException;

import ac.soton.eventb.emf.core.extension.persistence.ISerialisedExtension;
import ac.soton.eventb.emf.core.extension.persistence.SerialisedExtensionSynchroniser;
import ac.soton.eventb.statemachines.AbstractNode;
import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachinesFactory;
import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.Transition;

/**
 * Statemachine refiner extension to a standard refinement process.
 * 
 * @author vitaly
 *
 */
public class StatemachineRefiner implements IRefinementParticipant {

	private SerialisedExtensionSynchroniser synchroniser;
	private URI absURI;
	private URI conURI;

	/**
	 * Constructor.
	 */
	public StatemachineRefiner() {
		synchroniser = new SerialisedExtensionSynchroniser();
	}

	@Override
	public void process(IInternalElement targetRoot,
			IInternalElement sourceRoot, IProgressMonitor monitor)
			throws RodinDBException {
		Map<String, EObject> refinementMap = new HashMap<String, EObject>();
		final IMachineRoot con = (IMachineRoot) targetRoot;
		final IMachineRoot abs = (IMachineRoot) sourceRoot;

		// machine URIs
		String projectName = abs.getRodinProject().getElementName();
		absURI = URI.createURI("platform:/resource/" + projectName + "/"
				+ abs.getComponentName() + ".bum");
		conURI = URI.createURI("platform:/resource/" + projectName + "/"
				+ con.getComponentName() + ".bum");

		refineStatemachineExtensions(con, abs, refinementMap, monitor);
	}

	/**
	 * Refines all statemachine extensions.
	 * 
	 * @param con concrete machine root
	 * @param abs abstract machine root
	 * @param map refinement map
	 * @param monitor progress monitor
	 * @throws RodinDBException 
	 */
	private void refineStatemachineExtensions(IMachineRoot con,
			IMachineRoot abs, Map<String, EObject> map, IProgressMonitor monitor)
			throws RodinDBException {
		for (ISerialisedExtension extension : abs.getChildrenOfType(ISerialisedExtension.ELEMENT_TYPE)) {
			if (extension.hasExtensionId() && extension.getExtensionId().startsWith(StatemachinesPackage.STATEMACHINES_EXTENSION_ID))
				refineStatemachineExtension(con, extension, map, monitor);
		}
	}

	/**
	 * Refines statemachine extension.
	 * 
	 * @param con concrete machine root
	 * @param absExt abstract extension which is statemachine serialised extension
	 * @param map refinement map
	 * @param monitor progress monitor
	 * @throws RodinDBException 
	 */
	private void refineStatemachineExtension(IMachineRoot con,
			ISerialisedExtension absExt, Map<String, EObject> map,
			IProgressMonitor monitor) throws RodinDBException {
		EventBElement extension = synchroniser.load(absExt, null, monitor);
		synchroniser.save(
				refineRootStatemachine((Statemachine) extension, map), con,
				monitor);
	}

	/**
	 * Returns refined statemachine from root statemachine.
	 * 
	 * @param absSM root statemachine
	 * @param map refinement map
	 * @return refined statemachine
	 */
	private Statemachine refineRootStatemachine(Statemachine absSM, Map<String, EObject> map) {
		// refine statemachines, states and substates
		Statemachine conSM = refineStatemachine(absSM, map);
		
		// remember refined statemachine mapping
		map.put(EcoreUtil.getID(absSM), conSM);
		
		// refine transitions
		refineTransitions(absSM, map);
		
		return conSM;
	}

	/**
	 * Returns refined statemachine from abstract statemachine.
	 * 
	 * @param absSM abstract statemachine
	 * @param map refinement map
	 * @return refined statemachine
	 */
	private Statemachine refineStatemachine(Statemachine absSM,
			Map<String, EObject> map) {
		// create refined statemachine
		Statemachine conSM = StatemachinesFactory.eINSTANCE.createStatemachine();
		conSM.setReference(absSM.getReference());
		conSM.setRefines((Statemachine) EMFCoreUtil.createProxy(
				StatemachinesPackage.eINSTANCE.getStatemachine(),
				absURI.appendFragment(EcoreUtil.getID(absSM))));

		// keep same extension id
		String extensionID = absSM.getExtensionId();
		if (extensionID != null)
			conSM.setExtensionId(extensionID);

		// create nodes
		for (AbstractNode node : absSM.getNodes()) {
			AbstractNode newNode = null;
			if (node instanceof State) {
				newNode = refineState((State) node, map);
			} else {
				newNode = (AbstractNode) StatemachinesFactory.eINSTANCE.create(node.eClass());
			}
			
			newNode.setReference(node.getReference());
			conSM.getNodes().add(newNode);
			
			// set transition references
			for (Transition inTransition : node.getIncoming())
				newNode.getIncoming().add((Transition) EMFCoreUtil.createProxy(
										StatemachinesPackage.eINSTANCE.getTransition(),
										conURI.appendFragment(EcoreUtil.getURI(inTransition).fragment())));
			for (Transition outTransition : node.getOutgoing())
				newNode.getOutgoing().add((Transition) EMFCoreUtil.createProxy(
										StatemachinesPackage.eINSTANCE.getTransition(),
										conURI.appendFragment(EcoreUtil.getURI(outTransition).fragment())));

			// remember node mapping
			map.put(EcoreUtil.getID(node), newNode);
		}

		return conSM;
	}

	/**
	 * Returns refined state from abstract state.
	 * 
	 * @param absState abstract state
	 * @param map refinement map
	 * @return refined state
	 */
	private State refineState(State absState, Map<String, EObject> map) {
		// create refined state
		State conState = StatemachinesFactory.eINSTANCE.createState();
		conState.setRefines((State) EMFCoreUtil.createProxy(
				StatemachinesPackage.eINSTANCE.getState(),
				absURI.appendFragment(EcoreUtil.getID(absState))));

		// create refined statemachines
		for (Statemachine absSM : absState.getStatemachines()) {
			Statemachine conSM = refineStatemachine(absSM, map);
			conState.getStatemachines().add(conSM);

			// remember refined statemachine mapping
			map.put(EcoreUtil.getID(absSM), conSM);
		}

		return conState;
	}
	
	/**
	 * Refines transitions in abstract statemachine.
	 * 
	 * @param absSM abstract statemachine
	 * @param map refinement map
	 */
	private void refineTransitions(Statemachine absSM, Map<String, EObject> map) {
		// get new transition owner from map
		Statemachine owner = (Statemachine) map.get(EcoreUtil.getID(absSM));
		if (owner != null) {
			// process transitions of current abstract statemachine
			for (Transition transition : absSM.getTransitions()) {
				Transition newTransition = StatemachinesFactory.eINSTANCE
						.createTransition();
				newTransition.setReference(transition.getReference());

				// set source and target
				// NOTE: transition source/target node is a proxy, so get its ID from a fragment of its URI
				EObject source = map.get(EcoreUtil.getURI(
						transition.getSource()).fragment());
				EObject target = map.get(EcoreUtil.getURI(
						transition.getTarget()).fragment());
				if (source != null && target != null) {
					newTransition.setSource((AbstractNode) EMFCoreUtil.createProxy(
							source.eClass(), 
							conURI.appendFragment(EcoreUtil.getID(source))));
					newTransition.setTarget((AbstractNode) EMFCoreUtil.createProxy(
							target.eClass(), 
							conURI.appendFragment(EcoreUtil.getID(target))));
				}

				// set elaborates
				for (Event absEvent : transition.getElaborates())
					newTransition.getElaborates().add((Event) EMFCoreUtil.createProxy(
									MachinePackage.eINSTANCE.getEvent(),
									conURI.appendFragment(EcoreUtil.getURI(absEvent).fragment())));

				// set owner
				owner.getTransitions().add(newTransition);

				// remember transition mapping
				map.put(EcoreUtil.getID(transition), newTransition);
			}
		}
		
		
		// process abstract statemachines in nodes
		for (AbstractNode node : absSM.getNodes())
			if (node instanceof State)
				for (Statemachine nodeAbsStatemachine : ((State) node).getStatemachines())
					refineTransitions(nodeAbsStatemachine, map);
	}
}
