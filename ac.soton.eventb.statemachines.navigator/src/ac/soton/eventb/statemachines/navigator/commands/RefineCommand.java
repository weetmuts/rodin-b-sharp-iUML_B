/*******************************************************************************
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ac.soton.eventb.statemachines.navigator.commands;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eventb.core.EventBPlugin;
import org.eventb.core.IEventBProject;
import org.eventb.core.IMachineRoot;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.machine.Convergence;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachineFactory;
import org.eventb.emf.core.machine.Variable;
import org.rodinp.core.IRodinFile;
import org.rodinp.core.IRodinProject;

import ac.soton.eventb.statemachines.AbstractNode;
import ac.soton.eventb.statemachines.AbstractState;
import ac.soton.eventb.statemachines.AbstractStatemachine;
import ac.soton.eventb.statemachines.RefinedState;
import ac.soton.eventb.statemachines.RefinedStatemachine;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachinesFactory;
import ac.soton.eventb.statemachines.Transition;
import ac.soton.eventb.statemachines.navigator.StatemachinesNavigatorPlugin;

public class RefineCommand extends AbstractHandler {

	/**
	 * Transactional command that does the refinement.
	 * 
	 * @author vitaly
	 *
	 */
	public class CreateRefinementCommand extends AbstractTransactionalCommand {
		
		/**
		 * Statemachines extension ID.
		 */
		private static final String STATEMACHINES_EXTENSION_ID = "ac.soton.eventb.statemachines";
		private URI sourceURI;
		private URI targetURI;

		/**
		 * @param sourceURI source machine
		 * @param targetURI target machine
		 */
		public CreateRefinementCommand(URI sourceURI, URI targetURI) {
			super(TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(), "Create machine refinement", null);
			this.sourceURI = sourceURI;
			this.targetURI = targetURI;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			TransactionalEditingDomain editingDomain = getEditingDomain();
			
			try {
				Resource resource = editingDomain.getResourceSet().getResource(sourceURI, true);
				
				if (resource != null && resource.isLoaded()) {
					Machine machine = (Machine) resource.getContents().get(0);
					Machine newMachine = refineMachine(machine);
	
					Resource newResource = editingDomain.getResourceSet().createResource(targetURI);
					initialiseMachineResource(newResource, newMachine);
				}
			} catch (Exception e) {
				return CommandResult.newErrorCommandResult(e);
			}
			
			return CommandResult.newOKCommandResult();
		}

		/**
		 * Returns refined machine from machine.
		 * 
		 * @param machine
		 * @return refined machine
		 */
		private Machine refineMachine(Machine machine) {
			Map<String, EObject> refinementMap = new HashMap<String, EObject>();
			
			// create new machine
			Machine newMachine = MachineFactory.eINSTANCE.createMachine();
			newMachine.getRefines().add(machine);
			newMachine.getSees().addAll(machine.getSees());
			
			// create variables
			for (Variable variable : machine.getVariables()) {
				newMachine.getVariables().add(EcoreUtil.copy(variable));
			}
			
			// create events
			for (Event event : machine.getEvents()) {
				Event newEvent = MachineFactory.eINSTANCE.createEvent();
				newEvent.setName(event.getName());
				newEvent.setExtended(true);
				newEvent.getRefines().add(event);
				
				//TODO: check that this convergence calculation is correct (taken from org.eventb.internal.ui.projectexplorer.actions.Refines.CreateRefinement.computeRefinementConvergence(Convergence absCvg))
				Convergence convergence = Convergence.CONVERGENT == event.getConvergence() ? Convergence.ORDINARY : event.getConvergence();
				newEvent.setConvergence(convergence);
				newMachine.getEvents().add(newEvent);
				
				// remember event mapping
				refinementMap.put(EcoreUtil.getIdentification(event), newEvent);
			}
			
			// create extensions
			for (AbstractExtension extension : machine.getExtensions()) {
				if (Pattern.matches(STATEMACHINES_EXTENSION_ID + ".*", extension.getExtensionId())) {
					if (extension instanceof AbstractStatemachine)
						newMachine.getExtensions().add(refineStatemachinesExtension((AbstractStatemachine) extension, refinementMap));
				} else {
					newMachine.getExtensions().add(EcoreUtil.copy(extension));
				}
			}
			
			return newMachine;
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
					newTransition.getElaborates().add((Event) refinementMap.get(EcoreUtil.getIdentification(event)));
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

		/**
		 * Initialises resource with machine and saves it.
		 * Resource doesn't have to exists.
		 * 
		 * @param resource
		 * @param machine
		 * @throws ExecutionException
		 */
		private void initialiseMachineResource(final Resource resource, Machine machine) throws ExecutionException {
			resource.getContents().add(machine);
			try {
				new WorkspaceModifyOperation() {
					
					@Override
					protected void execute(IProgressMonitor monitor) throws CoreException,
							InvocationTargetException, InterruptedException {
						try {
							resource.save(Collections.emptyMap());
						} catch (IOException e) {
							throw new InvocationTargetException(e, "Failed to save resource: " + resource.getURI().toFileString());
						}
					}
				}.run(null);
			} catch (InvocationTargetException e) {
				throw new ExecutionException("Failed to create resource: " + resource.getURI().toFileString(), e);
			} catch (InterruptedException e) {
				throw new ExecutionException("Failed to create resource: " + resource.getURI().toFileString(), e);
			}
		}

	}

	/**
	 * Copied from org.eventb.internal.ui.projectexplorer.actions.RodinFileInputValidator for that is unaccessible.
	 * 
	 * @author vitaly
	 *
	 */
	private final class RodinFileNameValidator implements IInputValidator {
		
		private IEventBProject project;

		/**
		 * @param project
		 */
		private RodinFileNameValidator(IRodinProject project) {
			this.project = (IEventBProject) project.getAdapter(IEventBProject.class);
		}

		@Override
		public String isValid(String newText) {
			if (newText.equals(""))
				return "Name must not be empty.";
			IRodinFile file = project.getMachineFile(newText);
			if (file != null && file.exists())
				return "File name " + newText + " already exists.";
			file = project.getContextFile(newText);
			if (file != null && file.exists())
				return "File name " + newText + " already exists.";
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
		if (selection instanceof IStructuredSelection) {
			Object element = ((IStructuredSelection) selection).getFirstElement();
			if (element instanceof IMachineRoot) {
				IMachineRoot machineRoot = (IMachineRoot) element;
				
				IRodinFile refinedFile = getRefinedFile(machineRoot);
				if (refinedFile != null) {
					IFile newFile = refinedFile.getResource();
					IFile file = machineRoot.getResource();
					
					if (file != null && file.exists()) {
						URI machineURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
						URI refinedURI = URI.createPlatformResourceURI(newFile.getFullPath().toString(), true);
						
						try {
							Command command = new ICommandProxy(new CreateRefinementCommand(machineURI, refinedURI));
							if (command.canExecute())
								command.execute();
						} catch (Exception e) {
							StatemachinesNavigatorPlugin.getDefault().logError("Refinement failed", e);
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Returns refined file from original machine root.
	 * 
	 * @param machineRoot
	 * @return refined rodin file
	 */
	private IRodinFile getRefinedFile(IMachineRoot machineRoot) {
		IRodinProject prj = machineRoot.getRodinProject();
		
		InputDialog dialog = new InputDialog(null,
				"New REFINES Clause",
				"Please enter the name of the new machine", machineRoot.getElementName(),
				new RodinFileNameValidator(prj));
		dialog.open();

		final String name = dialog.getValue();
		if (name == null) {
			return null;
		}
		final String fileName = EventBPlugin.getMachineFileName(name);
		return prj.getRodinFile(fileName);
	}

}
