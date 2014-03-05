package ac.soton.eventb.statemachines.diagram.sheet.custom;

import org.eclipse.emf.ecore.EReference;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.util.NameUtils;
import ac.soton.eventb.emf.diagrams.Diagram;
import ac.soton.eventb.emf.diagrams.DiagramsPackage;

public abstract class AbstractEditTableWithDefaultNamingPropertySection extends
		AbstractEditTablePropertySection {

	@Override
	protected abstract EReference getFeature();

	/**
	 * Override the getNewValue method to add a default unique name to the DataPacket
	 */
	@Override
	protected Object getNewValue(){
		Object newVal = super.getNewValue();
		if (newVal instanceof EventBNamed && newVal instanceof EventBElement){
			String newName = NameUtils.getName((Diagram)owner.getContaining(DiagramsPackage.Literals.DIAGRAM))+"_"+getFeature().getName();
			((EventBNamed)newVal).setName(NameUtils.getSafeName((EventBElement)newVal, newName, owner, getFeature()));
		}
		return newVal;
	}

}
