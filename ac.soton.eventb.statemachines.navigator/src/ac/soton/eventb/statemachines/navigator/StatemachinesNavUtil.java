/*******************************************************************************
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ac.soton.eventb.statemachines.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachinePackage;
import org.eventb.ui.EventBUIPlugin;

import ac.soton.eventb.statemachines.AbstractStatemachine;
import ac.soton.eventb.statemachines.RefinedStatemachine;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesDiagramEditorUtil;

/**
 * Some commonly used methods.
 * 
 * @author vitaly
 *
 */
public class StatemachinesNavUtil {
	
	/**
	 * Returns a statemachine diagram file name for the corresponding statemachine element.
	 * 
	 * @param containerFullPath container path if exists or null
	 * @param abstractStatemachine statemachine domain element
	 * @return statemachine diagram file name string
	 */
	public static String getDiagramFileName(IPath containerFullPath, AbstractStatemachine abstractStatemachine) {
		Machine machine = (Machine) abstractStatemachine.getContaining(MachinePackage.eINSTANCE.getMachine());
		String machineName = machine != null ? machine.getName() : "";
		
		String smName = abstractStatemachine instanceof Statemachine ? ((Statemachine) abstractStatemachine).getName() : ((RefinedStatemachine) abstractStatemachine).getLabel();
		if (smName == null || smName.trim().isEmpty())
			return StatemachinesDiagramEditorUtil.getUniqueFileName(containerFullPath, machineName, "smd");
		return machineName + "." + smName + "." + "smd";
	}

	/**
	 * Returns whether resource is opened by any editor which has unsaved state.
	 * 
	 * @param resource a resource used as input for possible editors
	 * @return true if unsaved editor found to be opened on resource
	 * @throws PartInitException if restoring an input from discovered editor has failed
	 */
	public static boolean isUnsavedEditorOpenFor(Resource resource) throws PartInitException {
		IEditorReference[] editorReferences = EventBUIPlugin.getActivePage().getEditorReferences();
		for (int j = 0; j < editorReferences.length; j++) {
			IFile inputFile = (IFile) editorReferences[j].getEditorInput()
					.getAdapter(IFile.class);
			if (inputFile.equals(WorkspaceSynchronizer.getFile(resource))) {
				IEditorPart editor = editorReferences[j].getEditor(true);
				if (editor.isDirty())
					return true;
			}
		}
		return false;
	}
}
