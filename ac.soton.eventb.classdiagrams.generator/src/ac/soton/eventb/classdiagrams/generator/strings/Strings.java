package ac.soton.eventb.classdiagrams.generator.strings;

import java.text.MessageFormat;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.NLS;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.AssociativeElement;
import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassAttribute;

public class Strings {

	private static final String BUNDLE_NAME = "ac.soton.eventb.classdiagrams.generator.strings.Strings"; //$NON-NLS-1$

	private Strings() {
		// Do not instantiate
	}
	
	// //////////////////////////////////////////////////////////
	// ADMIN and HELPER methods
	// /////////////////////////////////////////////////////////
	static {
		NLS.initializeMessages(BUNDLE_NAME, Strings.class);
	}

	/**
	 * Bind the given message's substitution locations with the given string
	 * values.
	 * 
	 * @param message
	 *            the message to be manipulated
	 * @param bindings
	 *            An array of objects to be inserted into the message
	 * @return the manipulated String
	 */
	private static String bind(String message, Object... bindings) {
		if (message == null) {
			return "NULL STRING!!!";
		}
		return MessageFormat.format(message, bindings);
	}

	/**
	 * Returns the given components name if it is on of several root components
	 * in a machine otherwise returns an empty string
	 * 
	 * @param cp
	 * @return
	 */
	private static String rootComponentPrefix(Class cp) {
		for (EObject el : cp.eContainer().eContents()) {
			if (el instanceof Class && el != cp) {
				return cp.getName();
			}
		}
		return "";
	}

	private static String getUnionConnectorNames(Association pw) {
		String connectorUnion = "";
//		for (Association dp : pw.get()) {
//			if (connectorUnion.equals("")) {
//				connectorUnion = CN_NAME(dp.getConnector());
//			} else {
//				connectorUnion = connectorUnion + " \u222a "
//						+ CN_NAME(dp.getConnector());
//			}
//		}
		return connectorUnion;
	}

	public static String CLASS_SUPERTYPE_PRED;

	public static String CLASS_SUPERTYPE_PRED(Class cp, EList<Class> cp2) {
		Iterator<Class> i = cp2.iterator();
		String superTypeUnion;
		
		superTypeUnion = (i.hasNext()) ? i.next().getName() : "";
		
		while (i.hasNext()){
			superTypeUnion = CLASS_SUPERTYPE_UNION(superTypeUnion, i.next().getName());
		}
		
		return bind(CLASS_SUPERTYPE_PRED, rootComponentPrefix(cp), superTypeUnion);
	}
	
	public static String CLASS_SUPERTYPE_UNION;
	
	public static String CLASS_SUPERTYPE_UNION(Class cp, Class cp2) {
		return bind(CLASS_SUPERTYPE_UNION, rootComponentPrefix(cp), rootComponentPrefix(cp2));
	}
	
	public static String CLASS_SUPERTYPE_UNION(String cp, String cp2) {
		return bind(CLASS_SUPERTYPE_UNION, cp, cp2);
	}
	
	public static String CLASS_SUPERTYPE_NAME;
	
	public static String CLASS_SUPERTYPE_NAME(Class cp) {
		return bind(CLASS_SUPERTYPE_NAME, rootComponentPrefix(cp));
	}
	
	public static String CLASS_INSTANCE_NAME;
	
	public static String CLASS_INSTANCE_NAME(Class cp) {
		return bind(CLASS_INSTANCE_NAME, rootComponentPrefix(cp));
	}
	
	public static String CLASS_INSTANCE;
	
	public static String CLASS_INITIALIZATION_NAME;

	public static String CLASS_INITIALIZATION_NAME(Class cp) {
		return bind(CLASS_INSTANCE_NAME, rootComponentPrefix(cp));
	}
	
	public static String DYNAMIC_CLASS_VALUE;

	public static String DYNAMIC_CLASS_VALUE(Class cp) {
		return bind(DYNAMIC_CLASS_VALUE, rootComponentPrefix(cp));
	}

	public static String CLASS_INITIALIZATION_EXPR;
	
	public static String ASSOCIATION_PRED;

	public static String ASSOCIATION_PRED(Association element) {
		return bind(ASSOCIATION_PRED, 
				element.getName(), 
				element.getSource().getName(), 
				getRelationType(element), 
				element.getTarget().getName());
	}

	public static String REL_TOTAL_BIJECTION;				
	public static String REL_TOTAL_SURJECTION;									
	public static String REL_TOTAL_INJECTION;
	public static String REL_TOTAL_FUNCTION;
	public static String REL_PARTIAL_SURJECTION;
	public static String REL_PARTIAL_INJECTION;
	public static String REL_PARTIAL_FUNCTION;
	public static String REL_TOTAL_SURJECTIVE_REL;
	public static String REL_TOTAL_RELATION;
	public static String REL_PARTIAL_SURJECTIVE_RELATION;
	public static String REL_PARTIAL_RELATION;
	
	private static String getRelationType(AssociativeElement element) {
		if (element.isFunctional()){
			if (element.isTotal()) {
				if (element.isSurjective()){
					if (element.isInjective()){
						return REL_TOTAL_BIJECTION;				//total bijection
					}else{
						return REL_TOTAL_SURJECTION;				//total surjection						
					}
				}else{
					if (element.isInjective()){
						return REL_TOTAL_INJECTION;				//total injection
					}else{
						return REL_TOTAL_FUNCTION;				//total function
					}				
				}
			}else{
				if (element.isSurjective()){
					return REL_PARTIAL_SURJECTION;				//partial surjection
				}else{
					if (element.isInjective()){
						return REL_PARTIAL_INJECTION;				//partial injection	
					}else{
						return REL_PARTIAL_FUNCTION;				//partial function		
					}					
				}				
			}
		}else{
			if (element.isTotal()) {
				if (element.isSurjective()){
					return REL_TOTAL_SURJECTIVE_REL;			//total surjective relation
				}else{
					return REL_TOTAL_RELATION;				//total relation		
				}					
			}else{
				if (element.isSurjective()){
					return REL_PARTIAL_SURJECTIVE_RELATION;				//partial surjective relation
				}else{
					return REL_PARTIAL_RELATION;				//partial relation		
				}					
			}
		}
	}
	
	public static String ASSOCIATION_INJECTIVE_PRED;

	public static String ASSOCIATION_PRED_INJECTIVE(Association element) {
		return bind(ASSOCIATION_INJECTIVE_PRED, 
				element.getName(), 
				element.getTarget().getName(),
				element.getSource().getName());
	}
	
	public static String ASSOCIATION_PRED_NAME;

	public static String ASSOCIATION_PRED_NAME(String name) {
		return bind(ASSOCIATION_PRED_NAME, name);
	}

	public static String ASSOCIATION_PRED_INJECTIVE_NAME;
	
	public static String ASSOCIATION_PRED_INJECTIVE_NAME(String name) {
		return bind(ASSOCIATION_PRED_INJECTIVE_NAME, name);
	}
	
	
	//CLASS ATTRIBUTE
	public static String CLASS_ATTRIBUTE_PRED;

	public static String CLASS_ATTRIBUTE_PRED(ClassAttribute element) {
		return bind(CLASS_ATTRIBUTE_PRED, 
				element.getName(), 
				((Class)element.eContainer()).getName(), 
				getRelationType(element), 
				element.getTarget());
	}
	
	public static String CLASS_ATTRIBUTE_INJECTIVE_PRED;

	public static String CLASS_ATTRIBUTE_PRED_INJECTIVE(ClassAttribute element) {
		return bind(CLASS_ATTRIBUTE_INJECTIVE_PRED, 
				element.getName(), 
				element.getTarget(),
				((Class)element.eContainer()).getName());
	}
	
	public static String CLASS_ATTRIBUTE_PRED_NAME;

	public static String CLASS_ATTRIBUTE_PRED_NAME(String name) {
		return bind(CLASS_ATTRIBUTE_PRED_NAME, name);
	}

	public static String CLASS_ATTRIBUTE_PRED_INJECTIVE_NAME;
	
	public static String CLASS_ATTRIBUTE_PRED_INJECTIVE_NAME(String name) {
		return bind(CLASS_ATTRIBUTE_PRED_INJECTIVE_NAME, name);
	}
	
}
