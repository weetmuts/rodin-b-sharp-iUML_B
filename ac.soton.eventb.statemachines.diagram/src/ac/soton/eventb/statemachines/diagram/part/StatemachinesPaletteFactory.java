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
		paletteRoot.add(createFeatures2Group());
		paletteRoot.add(createConnections3Group());
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
		paletteContainer.add(createInitial2CreationTool());
		paletteContainer.add(createFinal3CreationTool());
		paletteContainer.add(createANY4CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Features" palette tool group
	 * @generated
	 */
	private PaletteContainer createFeatures2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Features2Group_title);
		paletteContainer.setId("createFeatures2Group"); //$NON-NLS-1$
		paletteContainer.add(createStatemachine1CreationTool());
		paletteContainer.add(createInvariant2CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Connections" palette tool group
	 * @generated
	 */
	private PaletteContainer createConnections3Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Connections3Group_title);
		paletteContainer.setId("createConnections3Group"); //$NON-NLS-1$
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
				.findImageDescriptor("/ac.soton.eventb.statemachines/icons/png/State.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInitial2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(StatemachinesElementTypes.Initial_2001);
		types.add(StatemachinesElementTypes.Initial_3002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Initial2CreationTool_title,
				Messages.Initial2CreationTool_desc, types);
		entry.setId("createInitial2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatemachinesDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.statemachines/icons/png/Initial.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFinal3CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(StatemachinesElementTypes.Final_2002);
		types.add(StatemachinesElementTypes.Final_3003);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Final3CreationTool_title,
				Messages.Final3CreationTool_desc, types);
		entry.setId("createFinal3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatemachinesDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.statemachines/icons/png/Final.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createANY4CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(StatemachinesElementTypes.ANY_2003);
		types.add(StatemachinesElementTypes.ANY_3004);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ANY4CreationTool_title,
				Messages.ANY4CreationTool_desc, types);
		entry.setId("createANY4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatemachinesDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.statemachines/icons/png/ANY.png")); //$NON-NLS-1$
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
				.findImageDescriptor("/ac.soton.eventb.statemachines/icons/png/Statemachine.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInvariant2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(StatemachinesElementTypes.Invariant_3006);
		types.add(StatemachinesElementTypes.Invariant_3010);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Invariant2CreationTool_title,
				Messages.Invariant2CreationTool_desc, types);
		entry.setId("createInvariant2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatemachinesDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.statemachines/icons/png/Invariant.png")); //$NON-NLS-1$
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
				.findImageDescriptor("/ac.soton.eventb.statemachines/icons/png/Transition.png")); //$NON-NLS-1$
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
