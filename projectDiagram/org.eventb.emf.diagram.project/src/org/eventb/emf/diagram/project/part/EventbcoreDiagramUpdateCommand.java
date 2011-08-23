package org.eventb.emf.diagram.project.part;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;
import org.eventb.emf.diagram.project.edit.policies.ProjectCanonicalEditPolicy;

/**
 * @generated
 */
public class EventbcoreDiagramUpdateCommand implements IHandler {

	/**
	 * @generated
	 */
	public void addHandlerListener(IHandlerListener handlerListener) {
	}

	/**
	 * @generated
	 */
	public void dispose() {
	}

	/**
	 * @generated NOT
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getSelectionService()
				.getSelection();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.size() != 1) {
				return null;
			}
			if (structuredSelection.getFirstElement() instanceof EditPart
					&& ((EditPart) structuredSelection.getFirstElement())
							.getModel() instanceof View) {
				EObject modelElement = ((View) ((EditPart) structuredSelection
						.getFirstElement()).getModel()).getElement();
				Resource resource = modelElement.eResource();
				if (resource == null)
					return null;
				
				// reload a project resource
				try {
					resource.unload();
					resource.load(EventbcoreDiagramEditorUtil.getLoadOptions());
				} catch (IOException e) {
					EventbcoreDiagramEditorPlugin.getInstance().logError("Error reloading a project resource on refresh", e);
					return null;
				}
				
				// make sure a canonical edit policy is present
				EditPart part = (EditPart) structuredSelection.getFirstElement();
				CanonicalEditPolicy policy = (CanonicalEditPolicy) part.getEditPolicy(EditPolicyRoles.CANONICAL_ROLE);
				if (policy == null) {
					policy = new ProjectCanonicalEditPolicy();
					part.installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, policy);
				}
				policy.refresh();
				
				List editPolicies = CanonicalEditPolicy
						.getRegisteredEditPolicies(modelElement);
				for (Iterator it = editPolicies.iterator(); it.hasNext();) {
					CanonicalEditPolicy nextEditPolicy = (CanonicalEditPolicy) it
							.next();
					nextEditPolicy.refresh();
				}

			}
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean isEnabled() {
		return true;
	}

	/**
	 * @generated
	 */
	public boolean isHandled() {
		return true;
	}

	/**
	 * @generated
	 */
	public void removeHandlerListener(IHandlerListener handlerListener) {
	}

}
