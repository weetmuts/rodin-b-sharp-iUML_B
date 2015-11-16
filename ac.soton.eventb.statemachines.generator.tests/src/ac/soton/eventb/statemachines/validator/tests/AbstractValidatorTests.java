/*******************************************************************************
 * Copyright (c) 2015 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     University of Southampton - initial API and implementation
 *******************************************************************************/

package ac.soton.eventb.statemachines.validator.tests;

import static org.junit.Assert.assertThat;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.persistence.tests.AbstractEventBEMFTests;
import org.hamcrest.CoreMatchers;

import ac.soton.eventb.statemachines.Statemachine;

/**
 * <p>
 *
 * </p>
 *
 * @author htson
 * @version
 * @see
 * @since
 */
public abstract class AbstractValidatorTests extends AbstractEventBEMFTests {

	/**
	 * The diagnostician used to validate the statemachines. This is initialised
	 * in the {@link #setUp()} method.
	 */
	private Diagnostician diagnostician;

	/**
	 * This setup method performs the following.
	 * <ol>
	 * <li>Calls the super method.</li>
	 * <li>Create the diagnostician for validation of statemachines.</li>
	 * </ol>
	 * 
	 * @see AbstractValidatorTests#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();

		diagnostician = new Diagnostician() {

			public String getObjectLabel(EObject eObject) {
				return EMFCoreUtil.getQualifiedName(eObject, true);
			}
		};
	}

	/**
	 * @param sM
	 * @return
	 */
	protected Diagnostic validate(Statemachine statemachine) {
		return diagnostician.validate(statemachine);
	}

	// =========================================================================
	// (BEGIN) Utility methods for asserting the diagnostic results.
	// =========================================================================

	protected void assertDiagnosticSeverity(String msg, Diagnostic diagnostic,
			int expected) {
		assertEquals(msg + ": Incorrect severity", expected,
				diagnostic.getSeverity());
	}

	/**
	 * @param msg
	 * @param diagnostic
	 * @param signature
	 */
	protected void assertDiagnosticSignature(String msg, Diagnostic diagnostic,
			String signature) {
		assertThat(msg, diagnostic.getMessage(),
				CoreMatchers.containsString(signature));
	}

	/**
	 * @param string
	 * @param diagnostic
	 * @param string2
	 */
	protected void assertDiagnosticReferences(String msg,
			Diagnostic diagnostic, Object... expected) {
		List<?> data = diagnostic.getData();
		assertEquals(msg + ": Incorrect number data objects", expected.length,
				data.size());
		Iterator<?> dataIterator = data.iterator();
		for (int i = 0; i < expected.length; i++) {
			Object obj = dataIterator.next();
			Object expectedObj = expected[i];
			if (expectedObj instanceof EventBElement) {
				assertTrue(msg + "object must be an EventBElement",
						obj instanceof EventBElement);
				assertEquals(msg + ": Incorrect reference",
						((EventBElement) expectedObj).getReference(),
						((EventBElement) obj).getReference());
			} else if (expectedObj instanceof EReference) {
				assertEquals(msg + ": Incorrect reference", expectedObj, obj);
			} else {
				assertEquals(msg + ": Incorrect reference", expectedObj, obj);
			}
		}

	}

	protected void assertDiagnostic(String msg, Diagnostic diagnostic,
			IDiagnosticCause... expected) {
		List<Diagnostic> children = diagnostic.getChildren();
		assertEquals(msg + ": Incorrect number of causes", expected.length,
				children.size());
		Iterator<Diagnostic> iterator = children.iterator();
		for (int i = 0; i < expected.length; i++) {
			Diagnostic child = iterator.next();
			IDiagnosticCause expectedCause = expected[i];
			assertDiagnosticSeverity(msg + ": Sub-diagnostic", child,
					expectedCause.getSeverity());
			String signature = expectedCause.getSignature();
			assertDiagnosticSignature(msg, child, signature);
			Object[] expectedObjects = expectedCause.getObjects();
			assertDiagnosticReferences(msg, child, expectedObjects);
		}
	}

	// =========================================================================
	// (END) Utility methods for asserting the diagnostic results.
	// =========================================================================

}
