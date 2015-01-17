/*
 * Copyright (c) 2011 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import java.util.List;

import org.eclipse.jface.viewers.IFilter;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBObject;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.emf.core.extension.coreextension.DataKind;
import ac.soton.eventb.emf.core.extension.coreextension.EventBDataElaboration;
import ac.soton.eventb.emf.diagrams.sheet.DataKindPropertySection;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;
/**
 * property section for Data elaboration, DataKinds
 * where the options are filtered depending on the parent element.
 * 
 * @author cfs
 *
 */
public class FilteredDataKindPropertySection extends DataKindPropertySection {
	
	/**
	 * Element Filter for this property section.
	 */
	public static final class Filter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof EventBDataElaboration;
		}
	}
	
	@Override
	protected List<String> filterDataKinds(List<String> values) {
		EventBObject container =owner.getContaining(CorePackage.Literals.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT);
		if (container instanceof Context){
			values.remove(DataKind.VARIABLE.getLiteral());
		}else if (container instanceof Machine){
			//Sets and constants can be linked from a machine so nothing to remove
		}
		if (owner instanceof Class && !((Class) owner).getSupertypes().isEmpty() ||
			owner instanceof Association || owner instanceof ClassAttribute	){
			values.remove(DataKind.SET.getLiteral());
		}
		return values;
	}
	
	@Override
	protected boolean isReadOnly() {
		return super.isReadOnly() || (owner instanceof Class && ((Class) owner).getRefines() != null);
	}

}
