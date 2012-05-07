/*
 * Created on 03-may-2005
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package ac.soton.eventb.classdiagrams.parser;

import java.util.Enumeration;
import java.util.StringTokenizer;

import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;

public class Scanner implements Enumeration<Token> {
	private StringTokenizer st;
	private TokenParser tp;

	/**
	 * Creates a new scanner that takes its input from <code>str</code>.
	 * 
	 * @param str the string to read from.

	 */
	public Scanner(EventBNamedCommentedComponentElement pRootElement, String pString) {
		st = new StringTokenizer(pString);
		tp = new TokenParser(pRootElement);
	}

	@Override
	public boolean hasMoreElements() {
		return st.hasMoreElements();
	}

	@Override
	public Token nextElement() {
		return tp.parseToken(st.nextToken());
	}

}