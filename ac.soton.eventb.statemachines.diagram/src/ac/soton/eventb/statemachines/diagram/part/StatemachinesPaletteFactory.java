/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.part;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import ac.soton.eventb.statemachines.diagram.providers.StatemachinesElementTypes;

/**
 * @generated
 */
public class StatemachinesPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createStates1Group());
		paletteRoot.add(createStateFeatures2Group());
		paletteRoot.add(createStateLinks3Group());
	}

	/**
	 * Creates "States" palette tool group
	 * @generated
	 */
	private PaletteContainer createStates1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.States1Group_title);
		paletteContainer.setId("createStates1Group"); //$NON-NLS-1$
		paletteContainer.add(createState1CreationTool());
		paletteContainer.add(createRefinedState2CreationTool());
		paletteContainer.add(createInitial3CreationTool());
		paletteContainer.add(createFinal4CreationTool());
		paletteContainer.add(createANY5CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "State Features" palette tool group
	 * @generated
	 */
	private PaletteContainer createStateFeatures2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.StateFeatures2Group_title);
		paletteContainer.setId("createStateFeatures2Group"); //$NON-NLS-1$
		paletteContainer.add(createStatemachine1CreationTool());
		paletteContainer.add(createRefinedStatemachine2CreationTool());
		paletteContainer.add(createInvariant3CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "State Links" palette tool group
	 * @generated
	 */
	private PaletteContainer createStateLinks3Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.StateLinks3Group_title);
		paletteContainer.setId("createStateLinks3Group"); //$NON-NLS-1$
		paletteContainer.add(createTransition1CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createState1CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(StatemachinesElementTypes.State_2004);
		types.add(StatemachinesElementTypes.State_3005);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.State1CreationTool_title,
				Messages.State1CreationTool_desc, types);
		entry.setId("createState1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatemachinesDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.statemachines/icons/State.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRefinedState2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(StatemachinesElementTypes.RefinedState_2005);
		types.add(StatemachinesElementTypes.RefinedState_3008);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.RefinedState2CreationTool_title,
				Messages.RefinedState2CreationTool_desc, types);
		entry.setId("createRefinedState2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatemachinesDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.statemachines/icons/RefinedState.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInitial3CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(StatemachinesElementTypes.Initial_2001);
		types.add(StatemachinesElementTypes.Initial_3002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Initial3CreationTool_title,
				Messages.Initial3CreationTool_desc, types);
		entry.setId("createInitial3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatemachinesDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.statemachines/icons/Initial.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFinal4CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(StatemachinesElementTypes.Final_2002);
		types.add(StatemachinesElementTypes.Final_3003);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Final4CreationTool_title,
				Messages.Final4CreationTool_desc, types);
		entry.setId("createFinal4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatemachinesDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.statemachines/icons/Final.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createANY5CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(StatemachinesElementTypes.ANY_2003);
		types.add(StatemachinesElementTypes.ANY_3004);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ANY5CreationTool_title,
				Messages.ANY5CreationTool_desc, types);
		entry.setId("createANY5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatemachinesDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.statemachines/icons/Any.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStatemachine1CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(StatemachinesElementTypes.Statemachine_3001);
		types.add(StatemachinesElementTypes.Statemachine_3009);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Statemachine1CreationTool_title,
				Messages.Statemachine1CreationTool_desc, types);
		entry.setId("createStatemachine1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatemachinesDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.statemachines/icons/Statemachine.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRefinedStatemachine2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.RefinedStatemachine2CreationTool_title,
				Messages.RefinedStatemachine2CreationTool_desc,
				Collections
						.singletonList(StatemachinesElementTypes.RefinedStatemachine_3007));
		entry.setId("createRefinedStatemachine2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatemachinesDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.statemachines/icons/RefinedStatemachine.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInvariant3CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(StatemachinesElementTypes.Invariant_3006);
		types.add(StatemachinesElementTypes.Invariant_3010);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Invariant3CreationTool_title,
				Messages.Invariant3CreationTool_desc, types);
		entry.setId("createInvariant3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatemachinesDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.statemachines/icons/Invariant.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTransition1CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Transition1CreationTool_title,
				Messages.Transition1CreationTool_desc,
				Collections
						.singletonList(StatemachinesElementTypes.Transition_4001));
		entry.setId("createTransition1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatemachinesDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.statemachines/icons/Transition.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List<IElementType> elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List<IElementType> relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
