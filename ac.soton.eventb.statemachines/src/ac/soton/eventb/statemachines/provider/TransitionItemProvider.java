/**
 * Copyright (c) 2010-2013
 * University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 *
 * $Id$
 */
package ac.soton.eventb.statemachines.provider;


import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionFactory;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;

import ac.soton.eventb.statemachines.StatemachinesFactory;
import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.Transition;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITableItemColorProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eventb.emf.core.CorePackage;

import org.eventb.emf.core.machine.MachineFactory;

import org.eventb.emf.core.provider.EventBCommentedElementItemProvider;

/**
 * This is the item provider adapter for a {@link ac.soton.eventb.statemachines.Transition} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TransitionItemProvider
	extends EventBCommentedElementItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource,
		ITableItemLabelProvider,
		ITableItemColorProvider,
		IItemColorProvider {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2010-2013\rUniversity of Southampton.\rAll rights reserved. This program and the accompanying materials  are made\ravailable under the terms of the Eclipse Public License v1.0 which accompanies this \rdistribution, and is available at http://www.eclipse.org/legal/epl-v10.html\n";

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addLabelPropertyDescriptor(object);
			addElaboratesPropertyDescriptor(object);
			addExtendedPropertyDescriptor(object);
			addTargetPropertyDescriptor(object);
			addSourcePropertyDescriptor(object);
			addSourceContainerPropertyDescriptor(object);
			addTargetContainerPropertyDescriptor(object);
			addOperationsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Label feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLabelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EventBLabeled_label_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EventBLabeled_label_feature", "_UI_EventBLabeled_type"),
				 CoreextensionPackage.Literals.EVENT_BLABELED__LABEL,
				 true,
				 true,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Elaborates feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addElaboratesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EventBEventGroup_elaborates_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EventBEventGroup_elaborates_feature", "_UI_EventBEventGroup_type"),
				 CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__ELABORATES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Extended feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExtendedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EventBEventGroup_extended_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EventBEventGroup_extended_feature", "_UI_EventBEventGroup_type"),
				 CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__EXTENDED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Transition_target_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Transition_target_feature", "_UI_Transition_type"),
				 StatemachinesPackage.Literals.TRANSITION__TARGET,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Source feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Transition_source_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Transition_source_feature", "_UI_Transition_type"),
				 StatemachinesPackage.Literals.TRANSITION__SOURCE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Source Container feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourceContainerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Transition_sourceContainer_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Transition_sourceContainer_feature", "_UI_Transition_type"),
				 StatemachinesPackage.Literals.TRANSITION__SOURCE_CONTAINER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Container feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetContainerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Transition_targetContainer_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Transition_targetContainer_feature", "_UI_Transition_type"),
				 StatemachinesPackage.Literals.TRANSITION__TARGET_CONTAINER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Operations feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOperationsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Transition_operations_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Transition_operations_feature", "_UI_Transition_type"),
				 StatemachinesPackage.Literals.TRANSITION__OPERATIONS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__PARAMETERS);
			childrenFeatures.add(CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__GUARDS);
			childrenFeatures.add(CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__ACTIONS);
			childrenFeatures.add(CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__WITNESSES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Transition.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Transition"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = crop(((Transition)object).getLabel());
		return label == null || label.length() == 0 ?
			getString("_UI_Transition_type") :
			getString("_UI_Transition_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Transition.class)) {
			case StatemachinesPackage.TRANSITION__LABEL:
			case StatemachinesPackage.TRANSITION__EXTENDED:
			case StatemachinesPackage.TRANSITION__TARGET:
			case StatemachinesPackage.TRANSITION__SOURCE:
			case StatemachinesPackage.TRANSITION__SOURCE_CONTAINER:
			case StatemachinesPackage.TRANSITION__TARGET_CONTAINER:
			case StatemachinesPackage.TRANSITION__OPERATIONS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case StatemachinesPackage.TRANSITION__PARAMETERS:
			case StatemachinesPackage.TRANSITION__GUARDS:
			case StatemachinesPackage.TRANSITION__ACTIONS:
			case StatemachinesPackage.TRANSITION__WITNESSES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
				 StatemachinesFactory.eINSTANCE.createStatemachine()));

		newChildDescriptors.add
			(createChildParameter
				(CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__PARAMETERS,
				 CoreextensionFactory.eINSTANCE.createTypedParameter()));

		newChildDescriptors.add
			(createChildParameter
				(CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__GUARDS,
				 MachineFactory.eINSTANCE.createGuard()));

		newChildDescriptors.add
			(createChildParameter
				(CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__ACTIONS,
				 MachineFactory.eINSTANCE.createAction()));

		newChildDescriptors.add
			(createChildParameter
				(CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__WITNESSES,
				 MachineFactory.eINSTANCE.createWitness()));
	}

}
