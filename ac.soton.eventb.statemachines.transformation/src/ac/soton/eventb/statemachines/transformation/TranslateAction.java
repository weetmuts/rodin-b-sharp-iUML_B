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
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
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
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

import ac.soton.eventb.emf.diagrams.generator.Activator;
import ac.soton.eventb.emf.diagrams.generator.actions.ValidateAction;
import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.TranslationKind;

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
		if (editor instanceof DiagramDocumentEditor) {
			final DiagramDocumentEditor diagramDocumentEditor = (DiagramDocumentEditor)editor;
			
			if (diagramDocumentEditor.getDiagram().getElement() instanceof Statemachine){
				final Statemachine statemachine = (Statemachine) diagramDocumentEditor.getDiagram().getElement();
				
				// save before transformation
				if (editor.isDirty())
					editor.doSave(new NullProgressMonitor());
				
				// first validate, then transform
				if (ValidateAction.validate(diagramDocumentEditor)){
					
					final StatemachineTransformationCommand generateCommand = new StatemachineTransformationCommand(
							diagramDocumentEditor.getDiagramEditPart().getEditingDomain(), 
							statemachine);

					if (generateCommand.canExecute()) {
						// run with progress
						ProgressMonitorDialog dialog = new ProgressMonitorDialog(diagramDocumentEditor.getSite().getShell());    
						try {
							dialog.run(true, true, new IRunnableWithProgress(){
							     public void run(IProgressMonitor monitor) {
							         monitor.beginTask("Translating to Event-B ...", IProgressMonitor.UNKNOWN);
							         try {
							        	 generateCommand.execute(monitor, diagramDocumentEditor);
							         } catch (ExecutionException e) {
										Activator.logError("Statemachine transformation failed", e);
							         }
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
						if (false == generateCommand.getCommandResult().getStatus().isOK())
							MessageDialog
									.openError(editor.getSite().getShell(),
											"Translation Information",
											"Translation encountered problems.\n\nSee log for details.");
					}
				}
			}
		}
		return null;
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
			setOptions(Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE));
			this.statemachine = statemachine;
		}

		@Override
		public boolean canRedo(){
			return false;
		}

		@Override
		public boolean canUndo(){
			return false;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			
			try {
				
				RodinCore.run(new IWorkspaceRunnable() {
					public void run(final IProgressMonitor monitor) throws CoreException{	
						TransactionalEditingDomain editingDomain = getEditingDomain();
						
						monitor.beginTask("Running Event-B Transformation for statemachine : "+statemachine.getName(),10);	
						monitor.setTaskName("Running Event-B Transformation for statemachine : "+statemachine.getName()); 
						
						// flush the command stack as this is unprotected and has no undo/redo
						editingDomain.getCommandStack().flush();

						////
						// find topmost container statemachine
						Statemachine rootSM = statemachine;
						for (; 
							rootSM.eContainer() instanceof State && rootSM.eContainer().eContainer() instanceof Statemachine; 
							rootSM = (Statemachine) rootSM.eContainer().eContainer());
						
						EObject container = EcoreUtil.getRootContainer(statemachine);
						final Machine machine = (Machine) container;
			

						// URIs of input resources
						final List<URI> inResourceURIs = new ArrayList<URI>(2);
						inResourceURIs.add(machine.getURI());
						if (TranslationKind.SINGLEVAR.equals(rootSM.getTranslation()) || TranslationKind.REFINEDVAR.equals(rootSM.getTranslation()))
							inResourceURIs.add(getImplicitCtxURIForMachine(machine));
						
						List<Resource> inResources = loadResources(inResourceURIs, editingDomain);
						List<ModelExtent> input = new ArrayList<ModelExtent>(inResources.size() + 1);
						
						// Refer to an existing transformation via URI
						URI transformationURI = getScriptURI(rootSM.getTranslation());
						
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
						//context.setConfigProperty("keepModeling", true);
						monitor.worked(4);
						// run the transformation assigned to the executor with the given 
						// input and output and execution context -> ChangeTheWorld(in, out)
						// Remark: variable arguments count is supported
						ExecutionDiagnostic result = executor.execute(context, input.toArray(new ModelExtent[]{}));
						monitor.worked(4);
						// check the result for success
						if(result.getSeverity() == Diagnostic.OK) {
							// let's persist using a resource 
								for (Resource res : inResources) {
									try {
										res.save(Collections.emptyMap());
									} catch (IOException e) {
										//throw this as a CoreException
										throw new CoreException(
												new Status(Status.ERROR, TransformationPlugin.PLUGIN_ID, "IO exception while saving "+res.getURI(), e));
									}
								}
						} else {
							// turn the result diagnostic into status and send it to error log			
							IStatus status = BasicDiagnostic.toIStatus(result);
							TransformationPlugin.getDefault().getLog().log(status);
							throw new CoreException(
									new Status(Status.ERROR, TransformationPlugin.PLUGIN_ID, "Error while executing transformation: "+status.getMessage(), null));

						}
						monitor.done();
					}
				},monitor);
				return CommandResult.newOKCommandResult();
//			} catch (WrappedException e) {
//				TransformationPlugin.getDefault().logError("Unable to load resource for transformation", e);
//				return CommandResult.newErrorCommandResult(e);
			} catch (RodinDBException e) {
				TransformationPlugin.getDefault().logError("Rodin DB exception", e);
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
					Resource resource = null;
					try {
						resource = editingDomain.getResourceSet().getResource(uri,true);
					}catch(Exception e){
						resource = editingDomain.getResourceSet().createResource(uri);
						createResourceContent(resource);
						resource.save(Collections.EMPTY_MAP);
						resource.load(Collections.EMPTY_MAP);
					}
					resources.add(resource);
				}
			} catch (Exception e) {
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
//		private Map<?, ?> getSaveOptions() {
//			HashMap<String, Object> saveOptions = new HashMap<String, Object>();
//			saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
//			return saveOptions;
//		}

		/**
		 * Returns load options for Resource load operation.
		 * 
		 * @return
		 */
//		private Map<?, ?> getLoadOptions() {
//			HashMap<String, Object> loadOptions = new HashMap<String, Object>();
//			loadOptions.put(XMLResource.OPTION_USE_PARSER_POOL, "org.eclipse.emf.ecore.xmi.XMLParserPool");
//			return loadOptions;
//		}

		/**
		 * Returns transformation script URI depending on translation kind provided.
		 * 
		 * @param kind translation kind
		 * @return script URI
		 */
		private URI getScriptURI(TranslationKind kind) {
			String scriptPath = null;
			
			if(TranslationKind.SINGLEVAR.equals(kind))
				scriptPath = "/transforms/enum_statemachines2eventb.qvto";
			else if(TranslationKind.MULTIVAR.equals(kind))
				scriptPath = "/transforms/vars_statemachines2eventb.qvto";
			else if (TranslationKind.REFINEDVAR.equals(kind))
				TransformationPlugin.getDefault().logError("Statemachine translation kind 'Refined' is no longer supported");
				//scriptPath = "/transforms/ref_statemachines2eventb.qvto";
			else 
				return null;
			
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
