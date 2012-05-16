package ac.soton.eventb.classdiagrams.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import ac.soton.eventb.classdiagrams.Classdiagram;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.AssociationEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.AssociationNameEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassAttributeEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassAttributeNameEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassNameEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassSupertypesEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassdiagramEditPart;
import ac.soton.eventb.classdiagrams.diagram.part.ClassdiagramsDiagramEditorPlugin;
import ac.soton.eventb.classdiagrams.diagram.part.ClassdiagramsVisualIDRegistry;
import ac.soton.eventb.classdiagrams.diagram.providers.ClassdiagramsElementTypes;
import ac.soton.eventb.classdiagrams.diagram.providers.ClassdiagramsParserProvider;

/**
 * @generated
 */
public class ClassdiagramsNavigatorLabelProvider extends LabelProvider
		implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		ClassdiagramsDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		ClassdiagramsDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof ClassdiagramsNavigatorItem
				&& !isOwnView(((ClassdiagramsNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof ClassdiagramsNavigatorGroup) {
			ClassdiagramsNavigatorGroup group = (ClassdiagramsNavigatorGroup) element;
			return ClassdiagramsDiagramEditorPlugin.getInstance()
					.getBundledImage(group.getIcon());
		}

		if (element instanceof ClassdiagramsNavigatorItem) {
			ClassdiagramsNavigatorItem navigatorItem = (ClassdiagramsNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (ClassdiagramsVisualIDRegistry.getVisualID(view)) {
		case ClassEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/classdiagrams?Class", ClassdiagramsElementTypes.Class_2002); //$NON-NLS-1$
		case ClassdiagramEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://soton.ac.uk/models/eventb/classdiagrams?Classdiagram", ClassdiagramsElementTypes.Classdiagram_1000); //$NON-NLS-1$
		case ClassSupertypesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/classdiagrams?Class?supertypes", ClassdiagramsElementTypes.ClassSupertypes_4004); //$NON-NLS-1$
		case ClassAttributeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/eventb/classdiagrams?ClassAttribute", ClassdiagramsElementTypes.ClassAttribute_3021); //$NON-NLS-1$
		case AssociationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/classdiagrams?Association", ClassdiagramsElementTypes.Association_4001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = ClassdiagramsDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& ClassdiagramsElementTypes.isKnownElementType(elementType)) {
			image = ClassdiagramsElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof ClassdiagramsNavigatorGroup) {
			ClassdiagramsNavigatorGroup group = (ClassdiagramsNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof ClassdiagramsNavigatorItem) {
			ClassdiagramsNavigatorItem navigatorItem = (ClassdiagramsNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (ClassdiagramsVisualIDRegistry.getVisualID(view)) {
		case ClassEditPart.VISUAL_ID:
			return getClass_2002Text(view);
		case ClassdiagramEditPart.VISUAL_ID:
			return getClassdiagram_1000Text(view);
		case ClassSupertypesEditPart.VISUAL_ID:
			return getClassSupertypes_4004Text(view);
		case ClassAttributeEditPart.VISUAL_ID:
			return getClassAttribute_3021Text(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_4001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getClass_2002Text(View view) {
		IParser parser = ClassdiagramsParserProvider.getParser(
				ClassdiagramsElementTypes.Class_2002,
				view.getElement() != null ? view.getElement() : view,
				ClassdiagramsVisualIDRegistry
						.getType(ClassNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ClassdiagramsDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getClassdiagram_1000Text(View view) {
		Classdiagram domainModelElement = (Classdiagram) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			ClassdiagramsDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getClassAttribute_3021Text(View view) {
		IParser parser = ClassdiagramsParserProvider.getParser(
				ClassdiagramsElementTypes.ClassAttribute_3021, view
						.getElement() != null ? view.getElement() : view,
				ClassdiagramsVisualIDRegistry
						.getType(ClassAttributeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ClassdiagramsDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5022); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getClassSupertypes_4004Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getAssociation_4001Text(View view) {
		IParser parser = ClassdiagramsParserProvider.getParser(
				ClassdiagramsElementTypes.Association_4001,
				view.getElement() != null ? view.getElement() : view,
				ClassdiagramsVisualIDRegistry
						.getType(AssociationNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ClassdiagramsDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return ClassdiagramEditPart.MODEL_ID
				.equals(ClassdiagramsVisualIDRegistry.getModelID(view));
	}

}
