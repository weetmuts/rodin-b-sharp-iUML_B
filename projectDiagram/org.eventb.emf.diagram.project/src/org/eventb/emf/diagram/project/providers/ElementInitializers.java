package org.eventb.emf.diagram.project.providers;

import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.context.ContextPackage;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachinePackage;
import org.eventb.emf.diagram.project.expressions.EventbcoreOCLFactory;
import org.eventb.emf.diagram.project.part.EventbcoreDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public void init_Machine_2001(Machine instance) {
		try {
			Object value_0 = EventbcoreOCLFactory.getExpression(0,
					MachinePackage.eINSTANCE.getMachine(), null).evaluate(
					instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			EventbcoreDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Context_2002(Context instance) {
		try {
			Object value_0 = EventbcoreOCLFactory.getExpression(1,
					ContextPackage.eINSTANCE.getContext(), null).evaluate(
					instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			EventbcoreDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = EventbcoreDiagramEditorPlugin
				.getInstance().getElementInitializers();
		if (cached == null) {
			EventbcoreDiagramEditorPlugin.getInstance().setElementInitializers(
					cached = new ElementInitializers());
		}
		return cached;
	}
}
