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

import org.eclipse.gmf.tooling.runtime.part.DefaultLinkToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;
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
		paletteContainer.add(createAny4CreationTool());
		paletteContainer.add(createJunction5CreationTool());
		paletteContainer.add(createForkJoin6CreationTool());
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
		types.add(StatemachinesElementTypes.State_2008);
		types.add(StatemachinesElementTypes.State_3013);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.State1CreationTool_title,
				Messages.State1CreationTool_desc, types);
		entry.setId("createState1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatemachinesDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.statemachines.edit/icons/png/State.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInitial2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(StatemachinesElementTypes.Initial_2006);
		types.add(StatemachinesElementTypes.Initial_3011);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.Initial2CreationTool_title,
				Messages.Initial2CreationTool_desc, types);
		entry.setId("createInitial2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatemachinesDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.statemachines.edit/icons/png/Initial.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFinal3CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(StatemachinesElementTypes.Final_2007);
		types.add(StatemachinesElementTypes.Final_3012);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.Final3CreationTool_title,
				Messages.Final3CreationTool_desc, types);
		entry.setId("createFinal3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatemachinesDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.statemachines.edit/icons/png/Final.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAny4CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(StatemachinesElementTypes.Any_3016);
		types.add(StatemachinesElementTypes.Any_2010);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.Any4CreationTool_title,
				Messages.Any4CreationTool_desc, types);
		entry.setId("createAny4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatemachinesDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.statemachines.edit/icons/png/Any.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createJunction5CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(StatemachinesElementTypes.Junction_3015);
		types.add(StatemachinesElementTypes.Junction_2009);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.Junction5CreationTool_title,
				Messages.Junction5CreationTool_desc, types);
		entry.setId("createJunction5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatemachinesDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.statemachines.edit/icons/png/Junction.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createForkJoin6CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(StatemachinesElementTypes.Fork_3017);
		types.add(StatemachinesElementTypes.Fork_2011);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.ForkJoin6CreationTool_title,
				Messages.ForkJoin6CreationTool_desc, types);
		entry.setId("createForkJoin6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatemachinesDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.statemachines.edit/icons/png/Fork.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStatemachine1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.Statemachine1CreationTool_title,
				Messages.Statemachine1CreationTool_desc,
				Collections
						.singletonList(StatemachinesElementTypes.Statemachine_3001));
		entry.setId("createStatemachine1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatemachinesDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.statemachines.edit/icons/png/Statemachine.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInvariant2CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.Invariant2CreationTool_title,
				Messages.Invariant2CreationTool_desc,
				Collections
						.singletonList(StatemachinesElementTypes.Invariant_3014));
		entry.setId("createInvariant2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatemachinesDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.statemachines.edit/icons/png/Invariant.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTransition1CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				Messages.Transition1CreationTool_title,
				Messages.Transition1CreationTool_desc,
				Collections
						.singletonList(StatemachinesElementTypes.Transition_4001));
		entry.setId("createTransition1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatemachinesDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.statemachines.edit/icons/png/Transition.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}
}
