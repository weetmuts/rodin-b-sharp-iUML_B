/**
 * Copyright (c) 2010
 * University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package ac.soton.eventb.statemachines.transformation;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eventb.emf.core.context.ContextPackage;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachinePackage;

import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.TranslationKind;
import ac.soton.eventb.statemachines.diagram.part.ValidateAction;

/**
 * Translate action handler.
 * Translates iUML-B to Event-B using QVT transformation script.
 * 
 * cfs (04/01/12) : Use editing domain from diagram editor instead of creating a new one.
 * 
 * @author vitaly
 *
 */
public class TranslateAction extends AbstractHandler {

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editor = HandlerUtil.getActiveEditorChecked(event);
		if (editor instanceof IDiagramWorkbenchPart) {
			IDiagramWorkbenchPart diagramEditor = (IDiagramWorkbenchPart) editor;
			if (diagramEditor.getDiagram() == null || false == diagramEditor.getDiagram().getElement() instanceof Statemachine)
				throw new ExecutionException("Failed statemachine transformation: cannot read model element from diagram editor.");
			
			// save before transformation
			if (editor.isDirty())
				editor.doSave(new NullProgressMonitor());
			
			// first validate, then transform
			if (IStatus.OK == validate(diagramEditor.getDiagramEditPart(), diagramEditor.getDiagram())) {
				TransactionalEditingDomain modelEditingDomain = diagramEditor.getDiagramEditPart().getEditingDomain(); //this is the EMF.edit editing domain for the model
				StatemachineTransformationCommand transfCommand = new StatemachineTransformationCommand(modelEditingDomain, (Statemachine) diagramEditor.getDiagram().getElement());
				final Command command = new ICommandProxy(transfCommand);
				if (command.canExecute()) {
					
					// run with progress
					ProgressMonitorDialog dialog = new ProgressMonitorDialog(diagramEditor.getSite().getShell());    
					try {
						dialog.run(true, true, new IRunnableWithProgress(){
						     public void run(IProgressMonitor monitor) {
						         monitor.beginTask("Translating to Event-B ...", IProgressMonitor.UNKNOWN);
						         command.execute();
						         monitor.done();
						     }
						 });
					} catch (InvocationTargetException e) {
						TransformationPlugin.getDefault().logError("Transformation failed", e);
						return null;
					} catch (InterruptedException e) {
						TransformationPlugin.getDefault().logError("Transformation interrupted", e);
						return null;
					} 

					// error feedback
					if (false == transfCommand.getCommandResult().getStatus().isOK())
						MessageDialog
								.openError(editor.getSite().getShell(),
										"Translation Information",
										"Translation encountered problems.\n\nSee log for details.");
				}
			}
		}
		return null;
	}

	/**
	 * Validates diagram and shows errors found;
	 * return IStatus constant as validation result.
	 * 
	 * @return IStatus constant
	 */
	private int validate(DiagramEditPart diagramEditPart, View view) {
		// first validate the diagram
		try {
			ValidateAction.runValidation(diagramEditPart, view);
		} catch (Exception e) {
			TransformationPlugin.getDefault().logError("Validation action failed for: " + diagramEditPart.toString(), e);
			return IStatus.ERROR;
		}
		
		IFile file = WorkspaceSynchronizer.getFile(view.eResource());
		if (file != null) {
			try {
				// get errors
				String errors = ValidateAction.getValidationErrors(file);
				
				if (errors.isEmpty()) {
					return IStatus.OK;
				} else {
					MessageDialog.openError(null, "Translation interrupted", "Validation has found problems in your model:\n" + errors);
				}
			} catch (CoreException e) {
				TransformationPlugin.getDefault().logError("Cannot read markers from file: " + file.getFullPath().toString(), e);
			}
		}
		
		return IStatus.ERROR;
	}

	/**
	 * Transformation command class.
	 * 
	 * @author vitaly
	 *
	 */
	private static class StatemachineTransformationCommand extends AbstractTransactionalCommand {

		/**
		 * Specialised exception class for no EClass found situation.
		 * 
		 * @author vitaly
		 *
		 */
		public class NoEClassException extends Exception {

			/**
			 * 
			 */
			private static final long serialVersionUID = -6910179434320404735L;

			/**
			 * @param string
			 */
			public NoEClassException(String string) {
				super(string);
			}

		}

		private Statemachine statemachine;

		/**
		 * @param modelEditingDomain 
		 * @param statemachine
		 */
		public StatemachineTransformationCommand(TransactionalEditingDomain modelEditingDomain, Statemachine statemachine) {
			super(modelEditingDomain, "Transformation Command", null);
			this.statemachine = statemachine;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			monitor.beginTask("Translating statemachine", IProgressMonitor.UNKNOWN);
			
			// find topmost container statemachine
			Statemachine rootSM = statemachine;
			for (; 
				rootSM.eContainer() instanceof State && rootSM.eContainer().eContainer() instanceof Statemachine; 
				rootSM = (Statemachine) rootSM.eContainer().eContainer());
			
			// translation kind
			TranslationKind kind = rootSM.getTranslation();
			
			EObject container = EcoreUtil.getRootContainer(statemachine);
			Machine machine = (Machine) container;
			
			// URIs of input resources
			List<URI> inResourceURIs = new ArrayList<URI>(2);
			inResourceURIs.add(machine.getURI());
			if (TranslationKind.SINGLEVAR.equals(kind))
				inResourceURIs.add(getImplicitCtxURIForMachine(machine));
			
			try {
				TransactionalEditingDomain editingDomain = getEditingDomain();
				List<Resource> inResources = loadResources(inResourceURIs, editingDomain);
				List<ModelExtent> input = new ArrayList<ModelExtent>(inResources.size() + 1);
				
				// Refer to an existing transformation via URI
				URI transformationURI = getScriptURI(kind);
				
				// create executor for the given transformation
				final TransformationExecutor executor = new TransformationExecutor(transformationURI);
	
				// define transformation resource inputs
				for (Resource inRes : inResources)
					input.add(new BasicModelExtent(inRes.getContents()));
				
				// define transformation statemachine extension input
				//FIXME: assumption on first resource as a statemachine container presumably is weak or error prone
				Resource mchResource = inResources.get(0);
				input.add(new BasicModelExtent(Collections.singletonList(mchResource.getEObject(rootSM.eResource().getURIFragment(rootSM)))));
	
				// setup the execution environment details -> 
				// configuration properties, logger, monitor object etc.
				final ExecutionContextImpl context = new ExecutionContextImpl();
				context.setConfigProperty("keepModeling", true);
	
				// run the transformation assigned to the executor with the given 
				// input and output and execution context -> ChangeTheWorld(in, out)
				// Remark: variable arguments count is supported
				ExecutionDiagnostic result = executor.execute(context, input.toArray(new ModelExtent[]{}));
				
				// check the result for success
				if(result.getSeverity() == Diagnostic.OK) {
					// let's persist using a resource 
					try {
						for (Resource res : inResources) {
							res.save(Collections.emptyMap());
							res.unload();
						}
						return CommandResult.newOKCommandResult();
					} catch (IOException e) {
						TransformationPlugin.getDefault().logError("Save operation failed after transformation", e);
						return CommandResult.newErrorCommandResult(e);
					}
				} else {
					// turn the result diagnostic into status and send it to error log			
					IStatus status = BasicDiagnostic.toIStatus(result);
					TransformationPlugin.getDefault().getLog().log(status);
					return CommandResult.newErrorCommandResult(status.getMessage());
				}
			} catch (WrappedException e) {
				TransformationPlugin.getDefault().logError("Unable to load resource for transformation", e);
				return CommandResult.newErrorCommandResult(e);
			} finally {
				monitor.done();
			}
		}

		/**
		 * Load resources from URIs.
		 * 
		 * @param inResourceURIs
		 * @param editingDomain 
		 * @return array of loaded resources
		 */
		private List<Resource> loadResources(List<URI> inResourceURIs, TransactionalEditingDomain editingDomain) {
			List<Resource> resources = new ArrayList<Resource>(inResourceURIs.size());
			try {
				for (URI uri : inResourceURIs) {
					Resource resource = editingDomain.getResourceSet().createResource(uri);
					IFile file = WorkspaceSynchronizer.getFile(resource);
					if (!file.exists()) {
						createResourceContent(resource);
						resource.save(getSaveOptions());
					}
					resource.load(getLoadOptions());
					resources.add(resource);
				}
			} catch (IOException e) {
				throw new WrappedException("Loading a resource failed: " + e.getMessage(), e);
			} catch (NoEClassException e) {
				throw new WrappedException("Creating a resource failed: " + e.getMessage(), e);
			}
			return resources;
		}

		/**
		 * Creates basic content in a resource i.e. a root container.
		 * 
		 * @param resource
		 * @throws NoEClassException if required EClass to create a root element cannot be derived from resource URI
		 */
		private void createResourceContent(Resource resource) throws NoEClassException {
			EClass clazz = getRootClass(resource);
			if (clazz == null)
				throw new NoEClassException("Cannot find root class of a resource " + resource.getURI());
			EObject element = EcoreUtil.create(clazz);
			if (clazz.getEStructuralFeature("name") != null)
				EMFCoreUtil.setName(element, resource.getURI().trimFileExtension().lastSegment());
			resource.getContents().add(element);
		}

		/**
		 * Returns a root EClass for a resource.
		 * 
		 * @param resource
		 * @return root EClass
		 */
		private EClass getRootClass(Resource resource) {
			if (resource.getURI() != null) {
				if ("bum".equals(resource.getURI().fileExtension()))
					return MachinePackage.eINSTANCE.getMachine();
				if ("buc".equals(resource.getURI().fileExtension()))
					return ContextPackage.eINSTANCE.getContext();
			}
			return null;
		}

		/**
		 * Returns save options for Resource save operation.
		 * 
		 * @return
		 */
		private Map<?, ?> getSaveOptions() {
			HashMap<String, Object> saveOptions = new HashMap<String, Object>();
			saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
			return saveOptions;
		}

		/**
		 * Returns load options for Resource load operation.
		 * 
		 * @return
		 */
		private Map<?, ?> getLoadOptions() {
			HashMap<String, Object> loadOptions = new HashMap<String, Object>();
			loadOptions.put(XMLResource.OPTION_USE_PARSER_POOL, "org.eclipse.emf.ecore.xmi.XMLParserPool");
			return loadOptions;
		}

		/**
		 * Returns transformation script URI depending on translation kind provided.
		 * 
		 * @param kind translation kind
		 * @return script URI
		 */
		private URI getScriptURI(TranslationKind kind) {
			String scriptPath = TranslationKind.SINGLEVAR.equals(kind) ? "/transforms/set_statemachines2eventb.qvto" : "/transforms/statemachines2eventb.qvto";
			URL url = Platform.getBundle(TransformationPlugin.PLUGIN_ID).getEntry(scriptPath);
			return URI.createURI(url.toString());
		}
		
		/**
		 * Returns implicit context name for a machine.
		 * 
		 * @param machine
		 * @return context name
		 */
		private String getImplicitCtxNameForMachine(Machine machine) {
			return machine.getName() + "_implicitContext";
		}

		/**
		 * Returns implicit context URI for machine.
		 * 
		 * @param machine
		 * @return URI
		 */
		private URI getImplicitCtxURIForMachine(Machine machine) {
			return machine.getURI().trimSegments(1).appendSegment(getImplicitCtxNameForMachine(machine)).appendFileExtension("buc");
		}
	}
}
