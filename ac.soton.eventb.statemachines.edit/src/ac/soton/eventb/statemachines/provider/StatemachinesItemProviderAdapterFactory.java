/**
 * Copyright (c) 2010
 * University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package ac.soton.eventb.statemachines.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ChildCreationExtenderManager;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eventb.emf.core.Annotation;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.util.CoreSwitch;

import ac.soton.eventb.statemachines.StatemachinesFactory;
import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.util.StatemachinesAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StatemachinesItemProviderAdapterFactory extends StatemachinesAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable, IChildCreationExtender {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2010\rUniversity of Southampton.\rAll rights reserved. This program and the accompanying materials  are made\ravailable under the terms of the Eclipse Public License v1.0 which accompanies this \rdistribution, and is available at http://www.eclipse.org/legal/epl-v10.html\n";

	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This helps manage the child creation extenders.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChildCreationExtenderManager childCreationExtenderManager = new ChildCreationExtenderManager(StatemachinesEditPlugin.INSTANCE, StatemachinesPackage.eNS_URI);

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatemachinesItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link ac.soton.eventb.statemachines.Transition} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionItemProvider transitionItemProvider;

	/**
	 * This creates an adapter for a {@link ac.soton.eventb.statemachines.Transition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTransitionAdapter() {
		if (transitionItemProvider == null) {
			transitionItemProvider = new TransitionItemProvider(this);
		}

		return transitionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ac.soton.eventb.statemachines.RefinedStatemachine} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RefinedStatemachineItemProvider refinedStatemachineItemProvider;

	/**
	 * This creates an adapter for a {@link ac.soton.eventb.statemachines.RefinedStatemachine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRefinedStatemachineAdapter() {
		if (refinedStatemachineItemProvider == null) {
			refinedStatemachineItemProvider = new RefinedStatemachineItemProvider(this);
		}

		return refinedStatemachineItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ac.soton.eventb.statemachines.Statemachine} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatemachineItemProvider statemachineItemProvider;

	/**
	 * This creates an adapter for a {@link ac.soton.eventb.statemachines.Statemachine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStatemachineAdapter() {
		if (statemachineItemProvider == null) {
			statemachineItemProvider = new StatemachineItemProvider(this);
		}

		return statemachineItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ac.soton.eventb.statemachines.State} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateItemProvider stateItemProvider;

	/**
	 * This creates an adapter for a {@link ac.soton.eventb.statemachines.State}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStateAdapter() {
		if (stateItemProvider == null) {
			stateItemProvider = new StateItemProvider(this);
		}

		return stateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ac.soton.eventb.statemachines.Initial} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InitialItemProvider initialItemProvider;

	/**
	 * This creates an adapter for a {@link ac.soton.eventb.statemachines.Initial}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInitialAdapter() {
		if (initialItemProvider == null) {
			initialItemProvider = new InitialItemProvider(this);
		}

		return initialItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ac.soton.eventb.statemachines.OR} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ORItemProvider orItemProvider;

	/**
	 * This creates an adapter for a {@link ac.soton.eventb.statemachines.OR}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createORAdapter() {
		if (orItemProvider == null) {
			orItemProvider = new ORItemProvider(this);
		}

		return orItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ac.soton.eventb.statemachines.ANY} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ANYItemProvider anyItemProvider;

	/**
	 * This creates an adapter for a {@link ac.soton.eventb.statemachines.ANY}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createANYAdapter() {
		if (anyItemProvider == null) {
			anyItemProvider = new ANYItemProvider(this);
		}

		return anyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ac.soton.eventb.statemachines.Final} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FinalItemProvider finalItemProvider;

	/**
	 * This creates an adapter for a {@link ac.soton.eventb.statemachines.Final}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFinalAdapter() {
		if (finalItemProvider == null) {
			finalItemProvider = new FinalItemProvider(this);
		}

		return finalItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ac.soton.eventb.statemachines.RefinedState} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RefinedStateItemProvider refinedStateItemProvider;

	/**
	 * This creates an adapter for a {@link ac.soton.eventb.statemachines.RefinedState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRefinedStateAdapter() {
		if (refinedStateItemProvider == null) {
			refinedStateItemProvider = new RefinedStateItemProvider(this);
		}

		return refinedStateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ac.soton.eventb.statemachines.DiagramRoot} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramRootItemProvider diagramRootItemProvider;

	/**
	 * This creates an adapter for a {@link ac.soton.eventb.statemachines.DiagramRoot}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDiagramRootAdapter() {
		if (diagramRootItemProvider == null) {
			diagramRootItemProvider = new DiagramRootItemProvider(this);
		}

		return diagramRootItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<IChildCreationExtender> getChildCreationExtenders() {
		return childCreationExtenderManager.getChildCreationExtenders();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection<?> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
		return childCreationExtenderManager.getNewChildDescriptors(object, editingDomain);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return childCreationExtenderManager;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (transitionItemProvider != null) transitionItemProvider.dispose();
		if (refinedStatemachineItemProvider != null) refinedStatemachineItemProvider.dispose();
		if (statemachineItemProvider != null) statemachineItemProvider.dispose();
		if (stateItemProvider != null) stateItemProvider.dispose();
		if (initialItemProvider != null) initialItemProvider.dispose();
		if (orItemProvider != null) orItemProvider.dispose();
		if (anyItemProvider != null) anyItemProvider.dispose();
		if (finalItemProvider != null) finalItemProvider.dispose();
		if (refinedStateItemProvider != null) refinedStateItemProvider.dispose();
		if (diagramRootItemProvider != null) diagramRootItemProvider.dispose();
	}

	/**
	 * A child creation extender for the {@link CorePackage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class CoreChildCreationExtender implements IChildCreationExtender {
		/**
		 * The switch for creating child descriptors specific to each extended class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected static class CreationSwitch extends CoreSwitch<Object> {
			/**
			 * The child descriptors being populated.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected List<Object> newChildDescriptors;

			/**
			 * The domain in which to create the children.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected EditingDomain editingDomain;

			/**
			 * Creates the switch for populating child descriptors in the given domain.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			CreationSwitch(List<Object> newChildDescriptors, EditingDomain editingDomain) {
				this.newChildDescriptors = newChildDescriptors;
				this.editingDomain = editingDomain;
			}
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			@Override
			public Object caseEventBElement(EventBElement object) {
			
			EAnnotation annotation = null;
				
				annotation = StatemachinesPackage.Literals.REFINED_STATEMACHINE.getEAnnotation("org.eventb.emf.core.extendedMetaClasses");
				if (annotation == null  || annotation.getReferences().contains(object.eClass()))
					newChildDescriptors.add
						(createChildParameter
							(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
							 StatemachinesFactory.eINSTANCE.createRefinedStatemachine()));

				
				annotation = StatemachinesPackage.Literals.STATEMACHINE.getEAnnotation("org.eventb.emf.core.extendedMetaClasses");
				if (annotation == null  || annotation.getReferences().contains(object.eClass()))
					newChildDescriptors.add
						(createChildParameter
							(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
							 StatemachinesFactory.eINSTANCE.createStatemachine()));

				return null;
			}
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			@Override
			public Object caseAnnotation(Annotation object) {
			
			EAnnotation annotation = null;
				
				annotation = StatemachinesPackage.Literals.TRANSITION.getEAnnotation("org.eventb.emf.core.extendedMetaClasses");
				if (annotation == null  || annotation.getReferences().contains(object.eClass()))
					newChildDescriptors.add
						(createChildParameter
							(CorePackage.Literals.ANNOTATION__CONTENTS,
							 StatemachinesFactory.eINSTANCE.createTransition()));

				
				annotation = StatemachinesPackage.Literals.DIAGRAM_ROOT.getEAnnotation("org.eventb.emf.core.extendedMetaClasses");
				if (annotation == null  || annotation.getReferences().contains(object.eClass()))
					newChildDescriptors.add
						(createChildParameter
							(CorePackage.Literals.ANNOTATION__CONTENTS,
							 StatemachinesFactory.eINSTANCE.createDiagramRoot()));

				
				annotation = StatemachinesPackage.Literals.REFINED_STATEMACHINE.getEAnnotation("org.eventb.emf.core.extendedMetaClasses");
				if (annotation == null  || annotation.getReferences().contains(object.eClass()))
					newChildDescriptors.add
						(createChildParameter
							(CorePackage.Literals.ANNOTATION__CONTENTS,
							 StatemachinesFactory.eINSTANCE.createRefinedStatemachine()));

				
				annotation = StatemachinesPackage.Literals.STATEMACHINE.getEAnnotation("org.eventb.emf.core.extendedMetaClasses");
				if (annotation == null  || annotation.getReferences().contains(object.eClass()))
					newChildDescriptors.add
						(createChildParameter
							(CorePackage.Literals.ANNOTATION__CONTENTS,
							 StatemachinesFactory.eINSTANCE.createStatemachine()));

				
				annotation = StatemachinesPackage.Literals.STATE.getEAnnotation("org.eventb.emf.core.extendedMetaClasses");
				if (annotation == null  || annotation.getReferences().contains(object.eClass()))
					newChildDescriptors.add
						(createChildParameter
							(CorePackage.Literals.ANNOTATION__CONTENTS,
							 StatemachinesFactory.eINSTANCE.createState()));

				
				annotation = StatemachinesPackage.Literals.INITIAL.getEAnnotation("org.eventb.emf.core.extendedMetaClasses");
				if (annotation == null  || annotation.getReferences().contains(object.eClass()))
					newChildDescriptors.add
						(createChildParameter
							(CorePackage.Literals.ANNOTATION__CONTENTS,
							 StatemachinesFactory.eINSTANCE.createInitial()));

				
				annotation = StatemachinesPackage.Literals.OR.getEAnnotation("org.eventb.emf.core.extendedMetaClasses");
				if (annotation == null  || annotation.getReferences().contains(object.eClass()))
					newChildDescriptors.add
						(createChildParameter
							(CorePackage.Literals.ANNOTATION__CONTENTS,
							 StatemachinesFactory.eINSTANCE.createOR()));

				
				annotation = StatemachinesPackage.Literals.ANY.getEAnnotation("org.eventb.emf.core.extendedMetaClasses");
				if (annotation == null  || annotation.getReferences().contains(object.eClass()))
					newChildDescriptors.add
						(createChildParameter
							(CorePackage.Literals.ANNOTATION__CONTENTS,
							 StatemachinesFactory.eINSTANCE.createANY()));

				
				annotation = StatemachinesPackage.Literals.FINAL.getEAnnotation("org.eventb.emf.core.extendedMetaClasses");
				if (annotation == null  || annotation.getReferences().contains(object.eClass()))
					newChildDescriptors.add
						(createChildParameter
							(CorePackage.Literals.ANNOTATION__CONTENTS,
							 StatemachinesFactory.eINSTANCE.createFinal()));

				
				annotation = StatemachinesPackage.Literals.REFINED_STATE.getEAnnotation("org.eventb.emf.core.extendedMetaClasses");
				if (annotation == null  || annotation.getReferences().contains(object.eClass()))
					newChildDescriptors.add
						(createChildParameter
							(CorePackage.Literals.ANNOTATION__CONTENTS,
							 StatemachinesFactory.eINSTANCE.createRefinedState()));

				return null;
			}
 
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected CommandParameter createChildParameter(Object feature, Object child) {
				return new CommandParameter(null, feature, child);
			}

		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
			ArrayList<Object> result = new ArrayList<Object>();
		   new CreationSwitch(result, editingDomain).doSwitch((EObject)object);
		   return result;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public ResourceLocator getResourceLocator() {
			return StatemachinesEditPlugin.INSTANCE;
		}
	}

}
