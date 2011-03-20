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
import java.net.URL;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.statemachines.diagram.part.ValidateAction;
import ac.soton.eventb.statemachines.diagram.providers.StatemachinesMarkerNavigationProvider;

/**
 * Translate action handler.
 * Translates iUML-B to Event-B using QVT transformation script.
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
			
			// first validate, then transformate
			if (IStatus.OK == validate(diagramEditor.getDiagramEditPart(), 
					diagramEditor.getDiagram())) {
				Command command = new ICommandProxy(new TransformationCommand(diagramEditor.getDiagram().getElement()));
				if (command.canExecute())
					command.execute();
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
				// find error markers and get errors
				IMarker[] markers = file.findMarkers(StatemachinesMarkerNavigationProvider.MARKER_TYPE, true, IResource.DEPTH_ZERO);
				StringBuilder errors = new StringBuilder();
				for (IMarker marker : markers) {
					int severity = marker.getAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
					if (severity == IMarker.SEVERITY_ERROR)
						errors.append("\n" + marker.getAttribute(IMarker.MESSAGE, "unknown error") +
								" \n\t@ " + marker.getAttribute(IMarker.LOCATION, "unknown location"));
				}
				
				if (errors.length() == 0) {
					return IStatus.OK;
				} else {
					MessageDialog.openError(null, "Translation interrupted", "Validation has found problems in your model:\n" + errors.toString());
				}
			} catch (CoreException e) {
				TransformationPlugin.getDefault().logError("Cannot read markers from file: " + file.getFullPath().toString(), e);
			}
		}
		
		return IStatus.ERROR;
	}

	private static class TransformationCommand extends AbstractTransactionalCommand {

		private EObject element;

		/**
		 * @param domain
		 * @param label
		 * @param affectedFiles
		 */
		public TransformationCommand(EObject element) {
			super(GMFEditingDomainFactory.INSTANCE.createEditingDomain(), "Trasformation Command", null);
			this.element = element;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			monitor.beginTask("Translating statemachine", IProgressMonitor.UNKNOWN);
			
//			// find topmost container statemachine
//			EObject root = element;
//			for (; false == root.eContainer() instanceof Machine; root = root.eContainer());
			EObject container = EcoreUtil.getRootContainer(element);
			Machine machine = (Machine) container;
			IFile file = WorkspaceSynchronizer.getFile(machine.eResource());
			
			try {
				TransactionalEditingDomain editingDomain = getEditingDomain();
				URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
				Resource resource = editingDomain.getResourceSet().getResource(fileURI, true);
				
				// find transformation script
				URL scriptUrl = TransformationPlugin.getDefault().getBundle().getEntry("/transforms/statemachines2eventb_2.qvto");
				
				// Refer to an existing transformation via URI
				URI transformationURI = URI.createURI(scriptUrl.toString());
				// create executor for the given transformation
				final TransformationExecutor executor = new TransformationExecutor(transformationURI);
	
				// define the transformation input
				// Remark: we take the objects from a resource, however
				// a list of arbitrary in-memory EObjects may be passed
				final Resource inResource = resource;
				EList<EObject> inObjects = inResource.getContents();
	
				// create the input extent with its initial contents
				final ModelExtent input = new BasicModelExtent(inObjects);
	
				// setup the execution environment details -> 
				// configuration properties, logger, monitor object etc.
				final ExecutionContextImpl context = new ExecutionContextImpl();
				context.setConfigProperty("keepModeling", true);
	
				// run the transformation assigned to the executor with the given 
				// input and output and execution context -> ChangeTheWorld(in, out)
				// Remark: variable arguments count is supported
				ExecutionDiagnostic result = executor.execute(context, input);
				
				// check the result for success
				if(result.getSeverity() == Diagnostic.OK) {
					// let's persist using a resource 
					try {
						inResource.save(Collections.emptyMap());
						return CommandResult.newOKCommandResult();
					} catch (IOException e) {
						TransformationPlugin.getDefault().logError("Save operation failed after transformation for: " + inResource.getURI().toFileString(), e);
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
	}
}
