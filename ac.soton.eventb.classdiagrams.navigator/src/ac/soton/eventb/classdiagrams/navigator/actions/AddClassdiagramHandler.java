package ac.soton.eventb.classdiagrams.navigator.actions;

import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eventb.core.IEventBRoot;
import org.eventb.core.IMachineRoot;
import org.eventb.core.basis.EventBRoot;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.classdiagrams.Classdiagram;
import ac.soton.eventb.classdiagrams.ClassdiagramsFactory;
import ac.soton.eventb.classdiagrams.navigator.ClassdiagramsNavigatorPlugin;


public class AddClassdiagramHandler extends AbstractHandler {

	// name validator
	static final IInputValidator nameValidator = new IInputValidator(){

		@Override
		public String isValid(String name) {
			if (name.trim().isEmpty())
				return "";
			return null;
		}
	};
	
	/**
	 * EMF command for adding a classdiagram to a machine.
	 * 
	 * @author vitaly
	 *
	 */
	public class AddClassdiagramCommand extends AbstractEMFOperation {

		private URI eventBRootURI;
		private Classdiagram classdiagram;

		public AddClassdiagramCommand(URI pEventBRootURI, Classdiagram classdiagram) {
			super(TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(), "Add Classdiagram");
			this.eventBRootURI = pEventBRootURI;
			this.classdiagram = classdiagram;
		}

		@Override
		protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
				throws ExecutionException {
			monitor.beginTask("Creating classdiagram", IProgressMonitor.UNKNOWN);
			
			TransactionalEditingDomain editingDomain = getEditingDomain();
			
			try {
				Resource resource = editingDomain.getResourceSet().getResource(eventBRootURI, true);
				
				if (resource != null && resource.isLoaded()) {
					EventBElement eventBElement = (EventBElement) resource.getContents().get(0);
					eventBElement.getExtensions().add(classdiagram);
					resource.save(Collections.emptyMap());
				}
			} catch (Exception e) {
				return new Status(Status.ERROR, ClassdiagramsNavigatorPlugin.PLUGIN_ID, "Failed to add classdiagram", e);
			} finally {
				monitor.done();
			}
			return Status.OK_STATUS;
		}

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
		if (selection instanceof IStructuredSelection) {
			Object element = ((IStructuredSelection) selection).getFirstElement();
			if (element instanceof IEventBRoot) {
				IEventBRoot machineRoot = (IEventBRoot) element; 
				IFile file = machineRoot.getResource();
					
				if (file != null && file.exists()) {
					InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), 
							"New Classdiagram", 
							"Enter classdiargam name: ",
							null, nameValidator);
					if (dialog.open() == InputDialog.CANCEL)
						return null;
					String name = dialog.getValue().trim();
					
					URI eventBElementURI = URI.createPlatformResourceURI(file.getFullPath().toOSString(), true);
					Classdiagram classdiargam = ClassdiagramsFactory.eINSTANCE.createClassdiagram();
					classdiargam.setName(name);
					try {
						AddClassdiagramCommand command = new AddClassdiagramCommand(eventBElementURI, classdiargam);
						if (command.canExecute())
							command.execute(new NullProgressMonitor(), null);
					} catch (Exception e) {
						ClassdiagramsNavigatorPlugin.getDefault().logError("Creating classdiargam failed", e);
					}
				}
			}
		}
		return null;
	}
	
}
