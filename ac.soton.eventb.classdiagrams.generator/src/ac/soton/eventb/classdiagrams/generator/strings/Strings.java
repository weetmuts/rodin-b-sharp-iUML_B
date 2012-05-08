package ac.soton.eventb.classdiagrams.generator.strings;

import java.text.MessageFormat;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.NLS;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.Class;

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
			superTypeUnion = superTypeUnion + CLASS_SUPERTYPE_UNION(superTypeUnion, i.next().getName());
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

//	public static String CLASS_INSTANCE(Class cp) {
//		return bind(CLASS_INSTANCE, rootComponentPrefix(cp), cp.getInstance());
//	}
	
	public static String CLASS_INITIALIZATION_NAME;

	public static String CLASS_INITIALIZATION_NAME(Class cp) {
		return bind(CLASS_INSTANCE_NAME, rootComponentPrefix(cp));
	}
	
	public static String DYNAMIC_CLASS_VALUE;

	public static String DYNAMIC_CLASS_VALUE(Class cp) {
		return bind(DYNAMIC_CLASS_VALUE, rootComponentPrefix(cp));
	}

	public static String CLASS_INITIALIZATION_EXPR;
	
//	public static String CLASS_INITIALIZATION_EXPR(Class cp) {
//		return bind(CLASS_INITIALIZATION_EXPR, cp.getName(), cp.getInstance());
//	}
	
}
