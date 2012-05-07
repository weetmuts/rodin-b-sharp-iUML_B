package ac.soton.eventb.classdiagrams.parser;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;

public class TokenParser {
	
	private int tokenPosition;    			// position in source stream
	private EventBNamedCommentedComponentElement rootElement;
	
	public TokenParser(EventBNamedCommentedComponentElement pRootElement){
		tokenPosition = 0;
		rootElement = pRootElement;
	}
	
	
	public static Token parseToken(EventBNamedCommentedComponentElement pRootElement, String pToken){
		Token t = new Token(pToken, -1, getEventBElement(pRootElement, pToken));
		
		return t;
	}
	
	public Token parseToken(String pToken){
		Token t = new Token(pToken, tokenPosition, getEventBElement(rootElement, pToken));
		
		return t;
	}


	private static EventBNamed getEventBElement(EventBNamedCommentedComponentElement pRootElement, String pToken) {
		List<EventBNamed> valuesList = new LinkedList<EventBNamed>();
		
		if (pRootElement instanceof Machine){
			Machine machine = (Machine) pRootElement;
			
			valuesList.addAll(machine.getVariables());
			
			for (Context context : machine.getSees()){
				valuesList.addAll(context.getConstants());
				valuesList.addAll(context.getSets());
			}
			
		} else if (pRootElement instanceof Context){
			Context context = (Context)pRootElement;
			
			valuesList.addAll(context.getConstants());
			valuesList.addAll(context.getSets());
		}
		
		for (EventBNamed ebn : valuesList){
			if (ebn.getName() != null && ebn.getName().equals(pToken)){
				return ebn;
			}
		}
		
		return null;
	}
}
