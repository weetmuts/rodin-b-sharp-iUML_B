package ac.soton.eventb.emf.diagrams.navigator.refactor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.edit.command.DeleteCommand;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;

public class RevertAssistant extends RefactorAssistant {

	public RevertAssistant(EventBNamedCommentedComponentElement component) {
		super(component);
	}
		
	/**
	 * Reverts the Change Records from the file system by applying them in reverse to the recorded resource
	 * Then saves the resource and deletes the change records so that they cannot be used again
	 * 
	 * 
	 */
	public void revertChangeRecords() {
		if (!hasChanges()) return;
		ApplyReverseCommand command = new ApplyReverseCommand(chRes, changes);
		ed.getCommandStack().execute(command);
		command.dispose();
		try {
			res.save(Collections.EMPTY_MAP);
			//chRes.eSetDeliver(false);
			List<Object> dels = new ArrayList<Object>();
			dels.add(chRes);
			DeleteCommand del = new DeleteCommand(ed, dels); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
