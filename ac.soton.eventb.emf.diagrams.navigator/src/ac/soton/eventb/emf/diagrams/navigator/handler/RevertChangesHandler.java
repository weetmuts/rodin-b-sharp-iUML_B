/**
 * Copyright (c) 2012 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package ac.soton.eventb.emf.diagrams.navigator.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eventb.core.IMachineRoot;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.persistence.EMFRodinDB;

import ac.soton.eventb.emf.diagrams.generator.actions.GenerateAllHandler;
import ac.soton.eventb.emf.diagrams.navigator.DiagramsNavigatorExtensionPlugin;
import ac.soton.eventb.emf.diagrams.navigator.refactor.RevertAssistant;

/**
 * Revert changes handler.
 * This handler reverts the recorded changes made to the selected machine.
 * This consists of:
 * a) applying the reversed changes made in the current selected component
 * b) delete the change record for the current selected component
 * c) generate all diagrams in the current selected component
 * 
 * Reverting is NOT enabled if 
 * There is no change record for this refinement level OR
 * refactoring is disabled in the system preferences.
 * 
 * @author cfs 
 *
 */
public class RevertChangesHandler extends AbstractHandler {
	
	/**
	 * Create an EMFRodinDB for loading extensions into EMF
	 */
	private final static EMFRodinDB emfRodinDB = new EMFRodinDB();
	
	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {	
		Shell shell = HandlerUtil.getActiveShell(event);
		
		//check refactoring preference is enabled
		Boolean refactoringEnabled =  DiagramsNavigatorExtensionPlugin.getDefault().getPreferenceStore().getBoolean(DiagramsNavigatorExtensionPlugin.PREFERENCES_REFACTORING_ENABLED);
		if (!refactoringEnabled) {
			MessageDialog.open(MessageDialog.INFORMATION, shell,
		    		  "Refactoring is switched off", 
		    		  "Changes are not being recorded because refactoring is disabled in preferences. "+
		    		  " Therefore there are no changes to revert. "+
		    		  " To switch refactoring on, go to Rodin Platform - Preferences and select iUML-B.", SWT.NONE 
		    			);
			return null;
		}
		
		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
		if (selection instanceof IStructuredSelection) {
			Object element = ((IStructuredSelection) selection).getFirstElement();
			if (element instanceof IMachineRoot) {
				EventBElement machine = emfRodinDB.loadEventBComponent((IMachineRoot)element);

				RevertAssistant assistant = new RevertAssistant((Machine)machine);		
				
				// Check that there is a change record for this refinement level
				if (assistant.hasChanges()){
				
					boolean ok = MessageDialog.openConfirm(shell,
				    		  "Revert Changes", 
				    		  "WARNING!: This will roll back all the changes accumulated for this refinement level and delete the change record.\n"
				    			  );
					if (ok){
						 //roll back the accumulated changes
						assistant.revertChangeRecords();
						
						 //delete the change record for the current selected component
						assistant.deleteChangeRecords();
						
						//tidyup
						assistant.disposeChangeRecords();
					}
				}else
					MessageDialog.openError(shell,
				    		  "Revert Changes", 
				    		  "There are no changes to revert on this refinement.\n"
				    			  );
				
				GenerateAllHandler genAll = new GenerateAllHandler();
				genAll.generateAllDiagrams(machine, shell, emfRodinDB.getEditingDomain(), null);
			}
		}
		return null;
	}
}
