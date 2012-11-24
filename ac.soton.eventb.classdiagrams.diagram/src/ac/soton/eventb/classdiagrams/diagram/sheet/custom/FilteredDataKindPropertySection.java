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
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBObject;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.emf.core.extension.coreextension.DataKind;
import ac.soton.eventb.emf.core.extension.coreextension.EventBDataElaboration;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;
import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassAttribute;
/**
 * property section for Data elaboration, DataKinds
 * where the options are filtered depending on the parent element.
 * 
 * @author colin
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
		EventBObject container =((EventBElement)eObject).getContaining(CorePackage.Literals.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT);
		if (container instanceof Context){
			values.remove(DataKind.VARIABLE.getLiteral());
		}else if (container instanceof Machine){
			values.remove(DataKind.SET.getLiteral());
			values.remove(DataKind.CONSTANT.getLiteral());
		}
		if (eObject instanceof Class && !((Class)eObject).getSupertypes().isEmpty() ||
			eObject instanceof Association || eObject instanceof ClassAttribute	){
			values.remove(DataKind.SET.getLiteral());
		}
		return values;
	}

}
