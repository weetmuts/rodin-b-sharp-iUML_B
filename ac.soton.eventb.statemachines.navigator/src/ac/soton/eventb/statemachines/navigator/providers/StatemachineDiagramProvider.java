/**
 * Copyright (c) 2011 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.navigator.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.emf.diagrams.navigator.provider.IDiagramProvider;
import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.diagram.edit.parts.RootStatemachineEditPart;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesDiagramEditor;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesDiagramEditorPlugin;

/**
 * Diagram provider for statemachines.
 * 
 * @author vitaly
 *
 */
public class StatemachineDiagramProvider implements IDiagramProvider {

	private static final String fileExtension = "smd";
	
	@Override
	public String getDiagramFileName(EObject element) {
		if (element instanceof Statemachine) {
			String filename = "";
			Statemachine rootStatemachine = (Statemachine) element;
			
			// find a root statemachine
			while (rootStatemachine.eContainer() instanceof State
					&& rootStatemachine.eContainer().eContainer() instanceof Statemachine)
				rootStatemachine = (Statemachine) rootStatemachine.eContainer().eContainer();
			//construct filename
			filename = rootStatemachine.getName() + "."+fileExtension;
			// prefix with machine name
			EObject root = EcoreUtil.getRootContainer(element);
			if (root != null && root instanceof Machine)
				filename = ((Machine) root).getName() + "." + filename;
			
			return filename;
		}
		return null;
	}

	@Override
	public PreferencesHint getPreferencesHint() {
		return StatemachinesDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

	@Override
	public String getDiagramKind() {
		return RootStatemachineEditPart.MODEL_ID;
	}

	@Override
	public String getEditorId() {
		return StatemachinesDiagramEditor.ID;
	}


	@Override
	public String getFileExtension() {
		return fileExtension;
	}
}
