package ac.soton.eventb.classdiagrams.diagram.part;

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

import ac.soton.eventb.classdiagrams.diagram.providers.ClassdiagramsElementTypes;

/**
 * @generated
 */
public class ClassdiagramsPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createClasses1Group());
		paletteRoot.add(createConnections2Group());
		paletteRoot.add(createElementfeatures3Group());
	}

	/**
	 * Creates "Classes" palette tool group
	 * @generated
	 */
	private PaletteContainer createClasses1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Classes1Group_title);
		paletteContainer.setId("createClasses1Group"); //$NON-NLS-1$
		paletteContainer.add(createClass1CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Connections" palette tool group
	 * @generated
	 */
	private PaletteContainer createConnections2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Connections2Group_title);
		paletteContainer.setId("createConnections2Group"); //$NON-NLS-1$
		paletteContainer.add(createAssociation1CreationTool());
		paletteContainer.add(createSupertype2CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Element features" palette tool group
	 * @generated
	 */
	private PaletteContainer createElementfeatures3Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Elementfeatures3Group_title);
		paletteContainer.setId("createElementfeatures3Group"); //$NON-NLS-1$
		paletteContainer.add(createAttribute1CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createClass1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Class1CreationTool_title,
				Messages.Class1CreationTool_desc,
				Collections.singletonList(ClassdiagramsElementTypes.Class_2002));
		entry.setId("createClass1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ClassdiagramsElementTypes
				.getImageDescriptor(ClassdiagramsElementTypes.Class_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociation1CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Association1CreationTool_title,
				null,
				Collections
						.singletonList(ClassdiagramsElementTypes.Association_4001));
		entry.setId("createAssociation1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ClassdiagramsElementTypes
				.getImageDescriptor(ClassdiagramsElementTypes.Association_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSupertype2CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Supertype2CreationTool_title,
				Messages.Supertype2CreationTool_desc,
				Collections
						.singletonList(ClassdiagramsElementTypes.ClassSupertypes_4004));
		entry.setId("createSupertype2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ClassdiagramsElementTypes
				.getImageDescriptor(ClassdiagramsElementTypes.ClassSupertypes_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAttribute1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Attribute1CreationTool_title,
				Messages.Attribute1CreationTool_desc,
				Collections
						.singletonList(ClassdiagramsElementTypes.ClassAttribute_3021));
		entry.setId("createAttribute1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ClassdiagramsElementTypes
				.getImageDescriptor(ClassdiagramsElementTypes.ClassAttribute_3021));
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
