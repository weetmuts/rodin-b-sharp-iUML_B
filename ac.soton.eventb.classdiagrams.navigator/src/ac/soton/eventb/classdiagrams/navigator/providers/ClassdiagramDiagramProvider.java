package ac.soton.eventb.classdiagrams.navigator.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.classdiagrams.Classdiagram;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassdiagramEditPart;
import ac.soton.eventb.classdiagrams.diagram.part.ClassdiagramsDiagramEditor;
import ac.soton.eventb.classdiagrams.diagram.part.ClassdiagramsDiagramEditorPlugin;
import ac.soton.eventb.emf.diagrams.navigator.provider.IDiagramProvider;


/**
 * Diagram provider for classdiagrams.
 * 
 * @author vitaly
 *
 */
public class ClassdiagramDiagramProvider implements IDiagramProvider {

	private static final String fileExtension = "cd";
	
	@Override
	public String getDiagramFileName(EObject element) {
		if (element instanceof Classdiagram) {
			String filename = "";
			Classdiagram rootClassdiagram = (Classdiagram) element;
			
			// find a root classdiagram
			while (rootClassdiagram.eContainer() instanceof Classdiagram
					&& rootClassdiagram.eContainer().eContainer() instanceof Classdiagram)
				rootClassdiagram = (Classdiagram) rootClassdiagram.eContainer().eContainer();
			filename = rootClassdiagram.getName() + "."+fileExtension;
			
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
		return ClassdiagramsDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

	@Override
	public String getDiagramKind() {
		return ClassdiagramEditPart.MODEL_ID;
	}

	@Override
	public String getEditorId() {
		return ClassdiagramsDiagramEditor.ID;
	}
	
	@Override
	public String getFileExtension() {
		return fileExtension;
	}
	
}
