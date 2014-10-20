package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IFilter;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;

public class ClassdiagramsSheetPropertyFilter {


	/**
	 * Filter for properties of class element.
	 */
	public static final class ClassFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof Class;
		}
	}

	/**
	 * Filter for properties of association element.
	 */
	public static final class AssociationFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof Association;
		}
	}
	
	/**
	 * Filter for properties of association element.
	 */
	public static final class ClassAttributeFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof ClassAttribute;
		}
	}
	
	/**
	 * Filter for properties of class element.
	 */
	public static final class ElaborativeElement implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof Class;
		}
	}
	
	/**
	 * Filter for properties of class element residing in the Context.
	 */
	public static final class ContextClassFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			if (( DiagramUtils.unwrap(toTest) instanceof Class) &&
					(EcoreUtil.getRootContainer( DiagramUtils.unwrap(toTest)) instanceof Context ) ) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	/**
	 * Filter for properties of class element residing in the Machine.
	 */
	public static final class MachineClassFilter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			if (( DiagramUtils.unwrap(toTest) instanceof Class) &&
					(EcoreUtil.getRootContainer( DiagramUtils.unwrap(toTest)) instanceof Machine ) ) {
				return true;
			} else {
				return false;
			}
		}
	}

}
