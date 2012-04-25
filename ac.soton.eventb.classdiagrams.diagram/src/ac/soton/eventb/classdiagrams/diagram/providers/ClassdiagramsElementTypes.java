package ac.soton.eventb.classdiagrams.diagram.providers;

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

import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.AssociationEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassAttributeEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassAxiomEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassEventEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassInvariantEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassSupertypesEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassdiagramEditPart;
import ac.soton.eventb.classdiagrams.diagram.part.ClassdiagramsDiagramEditorPlugin;

/**
 * @generated
 */
public class ClassdiagramsElementTypes {

	/**
	 * @generated
	 */
	private ClassdiagramsElementTypes() {
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
	public static final IElementType Classdiagram_1000 = getElementType("ac.soton.eventb.classdiagrams.diagram.Classdiagram_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Class_2002 = getElementType("ac.soton.eventb.classdiagrams.diagram.Class_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ClassAttribute_3004 = getElementType("ac.soton.eventb.classdiagrams.diagram.ClassAttribute_3004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ClassEvent_3003 = getElementType("ac.soton.eventb.classdiagrams.diagram.ClassEvent_3003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ClassInvariant_3005 = getElementType("ac.soton.eventb.classdiagrams.diagram.ClassInvariant_3005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ClassAxiom_3006 = getElementType("ac.soton.eventb.classdiagrams.diagram.ClassAxiom_3006"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Association_4001 = getElementType("ac.soton.eventb.classdiagrams.diagram.Association_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ClassSupertypes_4002 = getElementType("ac.soton.eventb.classdiagrams.diagram.ClassSupertypes_4002"); //$NON-NLS-1$

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
				return ClassdiagramsDiagramEditorPlugin.getInstance()
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

			elements.put(Classdiagram_1000,
					ClassdiagramsPackage.eINSTANCE.getClassdiagram());

			elements.put(Class_2002, ClassdiagramsPackage.eINSTANCE.getClass_());

			elements.put(ClassAttribute_3004,
					ClassdiagramsPackage.eINSTANCE.getClassAttribute());

			elements.put(ClassEvent_3003,
					ClassdiagramsPackage.eINSTANCE.getClassEvent());

			elements.put(ClassInvariant_3005,
					ClassdiagramsPackage.eINSTANCE.getClassInvariant());

			elements.put(ClassAxiom_3006,
					ClassdiagramsPackage.eINSTANCE.getClassAxiom());

			elements.put(Association_4001,
					ClassdiagramsPackage.eINSTANCE.getAssociation());

			elements.put(ClassSupertypes_4002,
					ClassdiagramsPackage.eINSTANCE.getClass_Supertypes());
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
			KNOWN_ELEMENT_TYPES.add(Classdiagram_1000);
			KNOWN_ELEMENT_TYPES.add(Class_2002);
			KNOWN_ELEMENT_TYPES.add(ClassAttribute_3004);
			KNOWN_ELEMENT_TYPES.add(ClassEvent_3003);
			KNOWN_ELEMENT_TYPES.add(ClassInvariant_3005);
			KNOWN_ELEMENT_TYPES.add(ClassAxiom_3006);
			KNOWN_ELEMENT_TYPES.add(Association_4001);
			KNOWN_ELEMENT_TYPES.add(ClassSupertypes_4002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case ClassdiagramEditPart.VISUAL_ID:
			return Classdiagram_1000;
		case ClassEditPart.VISUAL_ID:
			return Class_2002;
		case ClassAttributeEditPart.VISUAL_ID:
			return ClassAttribute_3004;
		case ClassEventEditPart.VISUAL_ID:
			return ClassEvent_3003;
		case ClassInvariantEditPart.VISUAL_ID:
			return ClassInvariant_3005;
		case ClassAxiomEditPart.VISUAL_ID:
			return ClassAxiom_3006;
		case AssociationEditPart.VISUAL_ID:
			return Association_4001;
		case ClassSupertypesEditPart.VISUAL_ID:
			return ClassSupertypes_4002;
		}
		return null;
	}

}
