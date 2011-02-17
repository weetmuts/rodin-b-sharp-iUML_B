/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.edit.policies.custom;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Canonical listener edit policy, which listens for changes in semantic and notation elements.
 * Basically a simplified copy of {@link org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy}
 */
public abstract class CanonicalListenerEditPolicy extends AbstractEditPolicy implements
		NotificationListener {

	private static final String SEMANTIC_FILTER_ID = "SemanticFilterID";
	private Map<String, Object[]> _listenerFilters;
	
	protected abstract void handleNotificationEvent(Notification notification);

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged(Notification notification) {
		if ( isHostStillValid()) {
			Object element = notification.getNotifier();
			if ( element == null  ) {
				return;
			}
			
			handleNotificationEvent(notification);
		}
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#isHostStillValid()
	 */
	private boolean isHostStillValid() {
		if (!getHost().isActive()) {
			return false;
		}

		// is it detached?
		EObject eObject = (EObject) getHost().getModel();
		if (eObject != null && eObject.eResource() == null
			&& !eObject.eIsProxy()) {
			return false;
		}
		return true;
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#activate()
	 */
	@Override
	public void activate() {
		EObject semanticHost = getSemanticHost();
		if (semanticHost != null) {
			addListenerFilter(SEMANTIC_FILTER_ID, this, semanticHost);
			addListenerFilter("NotationListener_Visibility", //$NON-NLS-1$
							  this,
							  (View)getHost().getModel(),
							  NotationPackage.eINSTANCE.getView_Visible());
			
			Style style = ((View) getHost().getModel()).getStyle(NotationPackage.eINSTANCE.getDrawerStyle());
			if ( style != null ) {
				addListenerFilter("NotationListener_DrawerStyle", this, style); //$NON-NLS-1$
			}
			style = ((View) getHost().getModel()).getStyle(NotationPackage.eINSTANCE.getCanonicalStyle());
			if ( style != null ) {
				addListenerFilter("NotationListener_CanonicalStyle", this, style);  //$NON-NLS-1$
			}
		}
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#deactivate()
	 */
	@Override
	public void deactivate() {
		if (_listenerFilters != null) {
    		Map<String, Object[]> listeners = new HashMap<String, Object[]>(_listenerFilters);
    		
    		for(String id: listeners.keySet()) {
    			removeListenerFilter(id);
    		}
    	}
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#getSemanticHost()
	 */
	public EObject getSemanticHost() {
		return ViewUtil.resolveSemanticElement((View) getHost().getModel()); 
	}

	/**
	 * Copied from org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#addListenerFilter(String filterId, NotificationListener listener, EObject element)
	 */
	protected boolean addListenerFilter(
		String filterId,
		NotificationListener listener,
		EObject element) {
		if ( filterId == null || listener == null ) {
			throw new NullPointerException();
		}

		if (element != null) {
			if (_listenerFilters == null)
				_listenerFilters = new HashMap<String, Object[]>();
			
			if ( !_listenerFilters.containsKey(filterId)) {
				getDiagramEventBroker().addNotificationListener(element,listener);
				_listenerFilters.put(filterId, new Object[] { element, listener });
				return true;
			}
		}
		return false;
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#addListenerFilter(String filterId, NotificationListener listener, EObject element, EStructuralFeature feature)
	 */
	protected boolean addListenerFilter(
		String filterId,
		NotificationListener listener,
		EObject element,
		EStructuralFeature feature) {
		if ( filterId == null || listener == null ) {
			throw new NullPointerException();
		}

		if (element != null) {
			if (_listenerFilters == null)
				_listenerFilters = new HashMap<String, Object[]>();
			
			if ( !_listenerFilters.containsKey(filterId)) {
				getDiagramEventBroker().addNotificationListener(element,feature,listener);
				_listenerFilters.put(filterId, new Object[] { element,feature, listener });
				return true;
			}
		}
		return false;
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#removeListenerFilter(String filterId)
	 */
	protected void removeListenerFilter(String filterId) {
		if (_listenerFilters == null) {
			return;
		}
		Object[] objects = (Object[]) _listenerFilters.remove(filterId);
		if (objects == null) {
			return;
		}
		if (objects.length > 2) {
			getDiagramEventBroker().removeNotificationListener(
				(EObject) objects[0], (EStructuralFeature) objects[1],
				(NotificationListener) objects[2]);
		} else {
			getDiagramEventBroker().removeNotificationListener(
				(EObject) objects[0], (NotificationListener) objects[1]);
		}
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#getDiagramEventBroker()
	 */
	private DiagramEventBroker getDiagramEventBroker() {
        TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart) getHost())
            .getEditingDomain();
        if (theEditingDomain != null) {
            return DiagramEventBroker.getInstance(theEditingDomain);
        }
        return null;
    }

}
