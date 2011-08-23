package org.eventb.emf.diagram.project.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.context.ContextPackage;
import org.eventb.emf.core.machine.MachinePackage;
import org.eventb.emf.diagram.project.edit.parts.ContextEditPart;
import org.eventb.emf.diagram.project.edit.parts.ContextExtendsEditPart;
import org.eventb.emf.diagram.project.edit.parts.MachineEditPart;
import org.eventb.emf.diagram.project.edit.parts.MachineRefinesEditPart;
import org.eventb.emf.diagram.project.edit.parts.MachineSeesEditPart;
import org.eventb.emf.diagram.project.edit.parts.ProjectEditPart;
import org.eventb.emf.diagram.project.part.EventbcoreDiagramEditorPlugin;

/**
 * @generated
 */
public class EventbcoreElementTypes {

	/**
	 * @generated
	 */
	private EventbcoreElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Project_1000 = getElementType("org.eventb.emf.diagram.project.Project_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Machine_2001 = getElementType("org.eventb.emf.diagram.project.Machine_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Context_2002 = getElementType("org.eventb.emf.diagram.project.Context_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ContextExtends_4001 = getElementType("org.eventb.emf.diagram.project.ContextExtends_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MachineSees_4002 = getElementType("org.eventb.emf.diagram.project.MachineSees_4002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MachineRefines_4003 = getElementType("org.eventb.emf.diagram.project.MachineRefines_4003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return EventbcoreDiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(Project_1000, CorePackage.eINSTANCE.getProject());

			elements.put(Machine_2001, MachinePackage.eINSTANCE.getMachine());

			elements.put(Context_2002, ContextPackage.eINSTANCE.getContext());

			elements.put(ContextExtends_4001,
					ContextPackage.eINSTANCE.getContext_Extends());

			elements.put(MachineSees_4002,
					MachinePackage.eINSTANCE.getMachine_Sees());

			elements.put(MachineRefines_4003,
					MachinePackage.eINSTANCE.getMachine_Refines());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Project_1000);
			KNOWN_ELEMENT_TYPES.add(Machine_2001);
			KNOWN_ELEMENT_TYPES.add(Context_2002);
			KNOWN_ELEMENT_TYPES.add(ContextExtends_4001);
			KNOWN_ELEMENT_TYPES.add(MachineSees_4002);
			KNOWN_ELEMENT_TYPES.add(MachineRefines_4003);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case ProjectEditPart.VISUAL_ID:
			return Project_1000;
		case MachineEditPart.VISUAL_ID:
			return Machine_2001;
		case ContextEditPart.VISUAL_ID:
			return Context_2002;
		case ContextExtendsEditPart.VISUAL_ID:
			return ContextExtends_4001;
		case MachineSeesEditPart.VISUAL_ID:
			return MachineSees_4002;
		case MachineRefinesEditPart.VISUAL_ID:
			return MachineRefines_4003;
		}
		return null;
	}

}
