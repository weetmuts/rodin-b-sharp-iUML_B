/*******************************************************************************
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ac.soton.eventb.statemachines.diagram;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.EventBObject;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachinePackage;
import org.eventb.ui.EventBUIPlugin;

import ac.soton.eventb.statemachines.AbstractStatemachine;
import ac.soton.eventb.statemachines.EventBLabeled;
import ac.soton.eventb.statemachines.RefinedStatemachine;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesDiagramEditorUtil;

/**
 * Some commonly used methods.
 * 
 * @author vitaly
 *
 */
public class StatemachinesEditorUtil {
	
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
		return (machineName.isEmpty() ? "" : machineName + ".") + smName + "." + "smd";
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
	
	/**
	 * Returns diagram editor name for diagram element.
	 * 
	 * @param diagram diagram element
	 * @return editor name
	 */
	public static String getEditorName(Diagram diagram) {
		EObject element = diagram.getElement();
		String name = element instanceof EventBNamed ? ((EventBNamed) element).getName()
				: element instanceof EventBLabeled ? ((EventBLabeled) element).getLabel() : "";
				
		Machine machine = (Machine) ((EventBObject) element).getContaining(MachinePackage.eINSTANCE.getMachine());
		name = (machine != null ? machine.getName() + "." : "") + name;
		
// full name including states				
//		element = element.eContainer();
//		for (; element != null && element instanceof Resource == false; element = element.eContainer())
//			name = (element instanceof EventBNamed ? ((EventBNamed) element).getName()
//					: element instanceof EventBLabeled ? ((EventBLabeled) element).getLabel() : "") + "." + name;
		return name;
	}
}
