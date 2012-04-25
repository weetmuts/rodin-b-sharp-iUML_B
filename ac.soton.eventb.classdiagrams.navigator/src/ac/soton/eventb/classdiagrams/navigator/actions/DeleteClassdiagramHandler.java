package ac.soton.eventb.classdiagrams.navigator.actions;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import ac.soton.eventb.classdiagrams.navigator.ClassdiagramsNavigatorPlugin;

/**
 * Command handler for deleting a classdiagram of a root component.
 * 
 * @author vitaly
 *
 */
public class DeleteClassdiagramHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
		if (selection instanceof IStructuredSelection) {
			Object element = ((IStructuredSelection) selection).getFirstElement();
			if (element instanceof IAdaptable) {
				final EObject eobject = (EObject) ((IAdaptable) element).getAdapter(EObject.class);
				final Resource resource = eobject.eResource();
				
				if (resource != null && resource.isLoaded()) {
					TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(resource);
					if (editingDomain != null) {
						// execute as command
						Command cmd = new RecordingCommand(editingDomain, "Delete Classdiagram") {
							protected void doExecute() {
								EcoreUtil.delete(eobject, true);
							}
						};
		
						try {
							editingDomain.getCommandStack().execute(cmd);
							resource.save(Collections.emptyMap());
						} catch (IOException e) {
							ClassdiagramsNavigatorPlugin
									.getDefault().logError("Save operation failed for: "
													+ resource.getURI(), e);
						}
					}
				}
			}
		}
		return null;
	}
	
}
