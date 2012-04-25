/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>classdiagrams</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassdiagramsTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new ClassdiagramsTests("classdiagrams Tests");
		suite.addTestSuite(ClassdiagramTest.class);
		suite.addTestSuite(AssociationTest.class);
		suite.addTestSuite(ClassAttributeTest.class);
		suite.addTestSuite(ClassAxiomTest.class);
		suite.addTestSuite(ClassInvariantTest.class);
		suite.addTestSuite(ClassEventTest.class);
		suite.addTestSuite(ClassTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassdiagramsTests(String name) {
		super(name);
	}

} //ClassdiagramsTests
