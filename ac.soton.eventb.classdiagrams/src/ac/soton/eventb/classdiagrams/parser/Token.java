/*
 * Created on 22-abr-2005
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package ac.soton.eventb.classdiagrams.parser;

import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;




/**
 * Tokens of Event-B mathematical language.
 * 
 * These tokens are produced by the scanner and consumed by the parser.
 * 
 * @author François Terrier
 */
public class Token {
	
	public final String stringValue; 		    // token value
	protected int tokenPosition;    			// position in source stream
	public  EventBNamed eventBElement;		//associated eventB model object

	protected Token(String pStringValue, int pTokenPosition, EventBNamed pEventBelement) {
		this.stringValue = pStringValue;
		this.tokenPosition = pTokenPosition;
		this.eventBElement = pEventBelement;
	}
	
}
