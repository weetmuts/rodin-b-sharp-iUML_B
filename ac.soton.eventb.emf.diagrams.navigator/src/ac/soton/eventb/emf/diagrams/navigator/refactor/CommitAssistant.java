package ac.soton.eventb.emf.diagrams.navigator.refactor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.change.ChangeKind;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.change.ListChange;
import org.eclipse.emf.ecore.util.EContentsEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.EventBObject;

import ac.soton.eventb.emf.core.extension.navigator.refiner.AbstractElementRefiner;
import ac.soton.eventb.emf.core.extension.navigator.refiner.ElementRefinerRegistry;
import ac.soton.eventb.emf.diagrams.navigator.refactor.persistence.RefactorPersistence;
import ac.soton.eventb.emf.diagrams.navigator.refactor.persistence.TextFile;


public class CommitAssistant extends RefactorAssistant {
	
	private final static String[] reportsFolder = {"iumlb","reports"};
	
	private Map<EObject,URI> oldNameMap = new HashMap<EObject,URI>();
	private TextFile report = new TextFile();;
	public CommitAssistant(EventBNamedCommentedComponentElement component) {
		super(component);
	}
	
	/**
	 * Apply the recorded changes to the given (refined) component where appropriate
	 * 
	 * Note that the recorded changes are in reverse (i.e. undo) format and therefore need to be reversed as they are applied.
	 * 
	 * Changes are only applied where an equivalent element is still present in the refinement 
	 * and the corresponding feature has an equivalent value in the refinement.
	 * 
	 */
	public void applyChangesTo(EventBNamedCommentedComponentElement newComponent){
		
		String timeStamp = getTimeStamp();
		oldNameMap.clear();

		report.setText("");
		report.addLine("Propagation report for "+newComponent.eResource().getURI().toPlatformString(true)+" :: "+timeStamp+"\n");
		
		try {
			//ChangeDescriptionImpl cdi = (ChangeDescriptionImpl) changes;
				//((ChangeDescriptionImpl)changes). ;
				if (changes==null || newComponent.eResource().getResourceSet() != rs) return;
				CompoundCommand cc = new CompoundCommand();

				preApply();
				
//				EList<EObject> detaches = changes.getObjectsToDetach();
//				EList<EObject> attaches = changes.getObjectsToAttach();

				//first check for name changes which will break vertical references as well as the equivalence map used later
				for (Entry<EObject, EList<FeatureChange>> change : changes.getObjectChanges()){
					EObject abstractObject = change.getKey();
					if (abstractObject==null) continue;
					EList<FeatureChange> abstractFeatureChanges = change.getValue();
					// check for name changes 
					for (FeatureChange reverseFeatureChange : abstractFeatureChanges){
						EStructuralFeature feature = reverseFeatureChange.getFeature();
						if (feature instanceof EAttribute && ((EAttribute)feature).getName().equals("name")){
							Object v = reverseFeatureChange.getValue();
							if (v instanceof String){
								URI uri = EcoreUtil.getURI(abstractObject);
								String fragment = uri.fragment();
								fragment=fragment.substring(0,fragment.lastIndexOf((String)abstractObject.eGet(feature)));
								fragment=fragment+v;
								uri = uri.trimFragment().appendFragment(fragment);
								oldNameMap.put(abstractObject, uri);
							}
						}
					}		
				}
				
				//fix vertical references to account for name changes
				//cc.append(
				updateVerticalReferences(cc, newComponent); //);
				ed.getCommandStack().execute(cc);
				cc.dispose();
				cc = new CompoundCommand();
				
				//now do containments so that references to new elements will work
				for (Entry<EObject, EList<FeatureChange>> change : changes.getObjectChanges()){

					EObject abstractObject = change.getKey();
					if (abstractObject==null) continue;
					EList<FeatureChange> abstractFeatureChanges = change.getValue();
					
					// get a refiner for the ePackage containing this abstract object
//					EClass ec = abstractObject.eClass();
//					EPackage ep = ec==null ? null : ec.getEPackage();
//					if (ec==null||ep==null){
//						int i = 0;
//					}
					
					String nsURI = abstractObject.eClass().getEPackage().getNsURI();
					AbstractElementRefiner refiner = ElementRefinerRegistry.getRegistry().getRefiner(nsURI);
					if (refiner==null) continue;
					
					// get the equivalent refined object
					EventBObject refinedObject = getEquivalentObjectInRefinement(newComponent, abstractObject, refiner);
					if (refinedObject==null) continue;
					
					// create commands to make corresponding changes to the refined object 
					for (FeatureChange reverseFeatureChange : abstractFeatureChanges){
						EStructuralFeature feature = reverseFeatureChange.getFeature();
						//FeatureChange reverseFeatureChange = findReverseFeatureChange(reverseFeatureChanges,featureChange);
						if (feature instanceof EReference && ((EReference)feature).isContainment() &&
							canApplyFeatureChange(newComponent, refinedObject, reverseFeatureChange, refiner)){
							makeFeatureChangeCommand(cc, abstractObject, refinedObject, reverseFeatureChange, refiner);	
						}
					}
					
					ed.getCommandStack().execute(cc);
					cc.dispose();
					cc = new CompoundCommand();
				}
				
				//now do references and attributes etc
				for (Entry<EObject, EList<FeatureChange>> change : changes.getObjectChanges()){
					
					EObject abstractObject = change.getKey();
					if (abstractObject==null) continue;

					// get a refiner for the ePackage containing this abstract object
					String nsURI = abstractObject.eClass().getEPackage().getNsURI();
					AbstractElementRefiner refiner = ElementRefinerRegistry.getRegistry().getRefiner(nsURI);
					if (refiner==null) continue;

					EventBObject refinedObject = getEquivalentObjectInRefinement(newComponent, abstractObject, refiner);
					if (refinedObject==null) {
						continue;
					}
					// create commands to make corresponding changes to the refined object 
					for (FeatureChange reverseFeatureChange : change.getValue()){
						//FeatureChange reverseFeatureChange = findReverseFeatureChange(reverseFeatureChanges,featureChange);
						EStructuralFeature feature = (EStructuralFeature)reverseFeatureChange.getFeature();
						if (!(feature instanceof EReference && ((EReference)feature).isContainment()) &&
								!(feature instanceof EReference && ((EReference)feature).getEOpposite()!=null && ((EReference)feature).isMany()) &&
							canApplyFeatureChange(newComponent, refinedObject, reverseFeatureChange, refiner)){
							makeFeatureChangeCommand(cc, abstractObject, refinedObject, reverseFeatureChange, refiner);	
						}
					}
				}

				ed.getCommandStack().execute(cc);
				cc.dispose();

//				TransactionalEditingDomain ed2 = EMFRodinDB.INSTANCE.getEditingDomain();
//				Map<String, ?> atts = rs.getURIConverter().getAttributes(refinedRes.getURI(), null);
//				if (ed.isReadOnly(refinedRes)){
//					Map<Resource, Boolean> r2romap = ((AdapterFactoryEditingDomain)ed).getResourceToReadOnlyMap();
//					r2romap.remove(refinedRes);
//				}
			
		} finally{
			IProject project = WorkspaceSynchronizer.getFile(res).getProject();
			URI commitReportURI = RefactorPersistence.INSTANCE.getRelatedURI(newComponent.eResource(), reportsFolder, timeStamp, "report");
			report.save(project, commitReportURI, null);
		}
		return;
	}

	private void updateVerticalReferences(CompoundCommand cc, EObject parent) {
		for (@SuppressWarnings("rawtypes")
		EContentsEList.FeatureIterator featureIterator =  (EContentsEList.FeatureIterator)parent.eCrossReferences().iterator(); featureIterator.hasNext(); )
		{
			EObject target = (EObject)featureIterator.next();
			EReference feature = (EReference)featureIterator.feature();
			if (target.eIsProxy() &&
				oldNameMap.containsValue(((InternalEObject)target).eProxyURI())) {
				//command to set feature to the renamed abstract object corresponding to the old reference URI
				Object newValue = getKeyByValue(oldNameMap, ((InternalEObject)target).eProxyURI());
				if (newValue!=null){
					report.addLine("\nSet "+feature.getName()+" of "+EcoreUtil.getURI(parent).fragment()+" to \""+newValue.toString()+"\"");
					cc.append(SetCommand.create(ed, parent, feature, newValue));
				}
			}
		}
		for (EObject child : parent.eContents()){
			updateVerticalReferences(cc, child);
		}
	}

	private static <T, E> T getKeyByValue(Map<T, E> map, E value) {
	    for (Entry<T, E> entry : map.entrySet()) {
	        if (value.equals(entry.getValue())) {
	            return entry.getKey();
	        }
	    }
	    return null;
	}
	
	/**
	 * @param newComponent
	 * @param abstractObject
	 * @param refiner
	 * @return
	 */
	private EventBObject getEquivalentObjectInRefinement(
			EventBNamedCommentedComponentElement newComponent,
			EObject abstractObject, AbstractElementRefiner refiner) {
		// get the equivalent refined object
		EventBObject refinedObject = refiner.getEquivalentObject(newComponent, abstractObject);
		if (refinedObject==null) {
			EObject oldObj = getOldObject(abstractObject);
			refinedObject = oldObj instanceof EObject? refiner.getEquivalentObject(newComponent, oldObj) : null;
		}
		return refinedObject;
	}
	
	/**
	 * 	list changes of type REMOVE (i.e. for items that have been added) refer to the element to be
	 *  removed by index into the original list rather than by caching the element in the lc. 
	 *  Unfortunately the index assumes and previous removal lc on the same feature have been applied.
	 *  Hence we need to calculate the real index into the current abstract list by counting how many 
	 *  lc remove from the same feature.
	 * 
	 */
	 protected Map<ListChange, Integer> listChangeIndex = new HashMap<ListChange,Integer>();
	/**
	 *	populate list change index map 
	 *	
	 */
	private void preApply() {
		Map<EObject, Map<EStructuralFeature,Integer>> indexMap = new HashMap<EObject, Map<EStructuralFeature,Integer>>();
		for (Entry<EObject, EList<FeatureChange>> change : changes.getObjectChanges()){
			EObject eObject = change.getKey();
			for (FeatureChange fc : change.getValue()){
				EStructuralFeature feature = fc.getFeature();
				EList<ListChange> listChanges = fc.getListChanges();
				for (ListChange lc : listChanges){
					if (lc.getKind()==ChangeKind.REMOVE_LITERAL){
						int indexOffset=0;
						if (indexMap.containsKey(eObject) && 
								indexMap.get(eObject).containsKey(feature)) {
							 indexOffset = indexMap.get(eObject).get(feature);
							 int newIndex = lc.getIndex()+indexOffset;
							 //lc.setIndex(newIndex); //changing the index can cause problems
							 listChangeIndex.put(lc,newIndex);
						}
						if (!indexMap.containsKey(eObject)){
							indexMap.put(eObject,new HashMap<EStructuralFeature,Integer>());
						}
						indexMap.get(eObject).put(feature, new Integer(indexOffset+1));
					}
				}
			}
		}
	}
	
	/**
	 * Generates a command to apply a (reversed) feature change to the refined parent
	 * 
	 * Note that the feature change is in reversed (i.e. undo) format. Hence the value it contains is the original old value. 
	 * The current (new) valaue must be obtained by reading the feature in the abstract Parent. 
	 * The given refiner is used to generate new refined elements for additions aas well as to find corresponding elements 
	 * to be changed.
	 * @param cc2 
	 * 
	 * @param abstractParent
	 * @param refinedParent
	 * @param reverseFeatureChange
	 * @param refiner
	 * @return
	 */
	private Command makeFeatureChangeCommand(CompoundCommand cc, EObject abstractParent, EventBObject refinedParent, FeatureChange reverseFeatureChange, AbstractElementRefiner refiner) {
		EventBNamedCommentedComponentElement concreteComponent = (EventBNamedCommentedComponentElement) refinedParent.getContaining(CorePackage.Literals.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT);
		EStructuralFeature feature = reverseFeatureChange.getFeature();
		Object value = reverseFeatureChange.getValue();
		if (feature.isMany()){
			if (value instanceof EList<?>){
				//in some cases undo is specified as a resulting value even for a list feature
				// in this case we need to add the equivalent of everything in the current model except 
				// the items in this final value.

				@SuppressWarnings("unchecked")
				EList<Object> newList =  (EList<Object>)abstractParent.eGet(feature);	//get the referenced target/value from the current model
				List<Object> addValues = new ArrayList<Object>();
				for (Object abstractItem : newList){
					if (feature instanceof EReference &&
							abstractItem instanceof EObject &&
							!((EList<?>)value).contains(abstractItem)
							){
						Object newValue = null;
						if (((EReference)feature).isContainment()){
							newValue = makeRefinedElement(
									abstractParent, refiner,
									concreteComponent, (EObject)abstractItem);
						}else if (isIn(component,(EObject)abstractItem)){	//for now we only support intra-component references here
							newValue = getEquivalentObjectInRefinement(concreteComponent, (EObject)abstractItem, refiner);
						}else{
							newValue = abstractItem;
						}
						if (newValue instanceof EObject){
							addValues.add(newValue);
						}
					}
				}
				if (!addValues.isEmpty()) {
					report.addLine("Add "+getURIsAsCSL(addValues)+" to "+feature.getName()+" of "+EcoreUtil.getURI(refinedParent).fragment());
					cc.append(AddCommand.create(ed, refinedParent, feature, addValues));
				}
				List<Object> remValues = new ArrayList<Object>();
				for (Object abstractItem : (EList<?>)value){
					if (feature instanceof EReference &&
							abstractItem instanceof EObject &&
							!newList.contains(abstractItem) &&
							isIn(component,(EObject)abstractItem)){
						Object newValue = getEquivalentObjectInRefinement(concreteComponent, (EObject)abstractItem, refiner);
						if (newValue instanceof EObject){
							remValues.add(newValue);
						}
					}
				}
				if (!remValues.isEmpty()) {
					report.addLine("Remove "+getURIsAsCSL(remValues)+" from "+feature.getName()+" of "+EcoreUtil.getURI(refinedParent).fragment());
					cc.append(RemoveCommand.create(ed, refinedParent, feature, remValues));
				}
				
			}else{
				//when undo is specified as a collection of list changes we need to iterate through the changes 
				// and reverse each individual change
				EList<ListChange> listChanges = reverseFeatureChange.getListChanges();
				for (ListChange lc : listChanges){
					ChangeKind kind = lc.getKind();
	//				EList<Object> values = lc.getValues();
	//				EList<?> abstractList = ((EList<?>)abstractParent.eGet(feature));
	//				
	//				@SuppressWarnings("unchecked")
	//				EList<Object> refinedList = ((EList<Object>)refinedParent.eGet(feature));			
	//				EObject dummyParent = EcoreUtil.copy(abstractParent);
	//				@SuppressWarnings("unchecked")
	//				EList<Object> dummyList = ((EList<Object>)dummyParent.eGet(feature));
	//				
	//				lc.reverse(dummyList);
	//				lc.apply(refinedList);
	//				int i=0;
					switch (kind){
					case REMOVE_LITERAL:	//I.E. ADD values to the list in the refinement
						List<Object> newValues = new ArrayList<Object>();
						List<Object> rawValues = new ArrayList<Object>();
						if (lc.getValues()!=null && lc.getValues().size()>0){
							rawValues.addAll(lc.getValues());
						} else if (lc.getReferenceValues()!=null && lc.getReferenceValues().size()>0) {
							rawValues.addAll(lc.getReferenceValues());
						} else {
							//Single Value to be added - get it from current model using index
							// (note lc index assumes that other changes to this feature have been applied
							int i = listChangeIndex.containsKey(lc) ? listChangeIndex.get(lc) : lc.getIndex();
							Object v = ((EList<?>)abstractParent.eGet(feature)).get(i);
							if (v!=null){
								rawValues.add(v);							
							}
						}
						for (Object v : rawValues){
							if (v instanceof EObject){

								EObject refinedObject;
								if (feature instanceof EReference && ((EReference)feature).isContainment()){
									refinedObject = makeRefinedElement(
											abstractParent, refiner,
											concreteComponent, (EObject)v);
								}else{
									refinedObject = getEquivalentObjectInRefinement(concreteComponent, (EventBObject) v, refiner);
								}
								if (refinedObject!=null){
									newValues.add(refinedObject);
								}
							}else{
								newValues.add(v);
							}
						}
	
//						int index = lc.getIndex();
//						int max = ((List<?>)refinedParent.eGet(feature)).size(); 
						report.addLine("Add "+getURIsAsCSL(newValues)+" to "+feature.getName()+" of "+EcoreUtil.getURI(refinedParent).fragment());
						cc.append(AddCommand.create(ed, refinedParent, feature, newValues)); //, index>max? max : index ));
						break;
					case MOVE_LITERAL:
						break;
					case ADD_LITERAL:	//I.E. REMOVE Values from the list in the refinement
						List<Object> removeValues = new ArrayList<Object>();
						if (lc.getDataValues()!=null && lc.getDataValues().size()>0){
							removeValues.addAll(lc.getValues());
						}else if (lc.getReferenceValues()!=null && lc.getReferenceValues().size()>0){
							for (Object v : lc.getValues()){
								Object refinedObject = getEquivalentObjectInRefinement(concreteComponent, (EventBObject) v, refiner);
								if (refinedObject!=null){
									removeValues.add(refinedObject);
								}
							}
						}else {
							//EList<Object> v = lc.getValues();
							//SHOULD NOT GET HERE AS ADD ALWAYS SETS VALUES 
						}
						if (removeValues.size()>0){
							report.addLine("Remove "+getURIsAsCSL(removeValues)+" from "+feature.getName()+" of "+EcoreUtil.getURI(refinedParent).fragment());
							cc.append(RemoveCommand.create(ed, refinedParent, feature, removeValues));
						}
						break;
					default:
						break;
					}
				}

			}
		}else {
			Object newValue =  abstractParent.eGet(feature);	//get the referenced target/value from the current model
			if (feature instanceof EReference && isIn(component,(EObject)newValue)){
				newValue = getEquivalentObjectInRefinement(concreteComponent, (EventBObject)newValue, refiner);
			}
			if (newValue == null && refinedParent.eGet(feature)!= null) newValue = SetCommand.UNSET_VALUE;
			if (newValue!= null){
				report.addLine("Set "+feature.getName()+" of "+EcoreUtil.getURI(refinedParent).fragment()+" to \""+newValue.toString()+"\"");
				cc.append(SetCommand.create(ed, refinedParent, feature, newValue));
			}
		}
		return cc;
	}

	/**
	 * @param abstractParent
	 * @param refiner
	 * @param concreteComponent
	 * @param v
	 * @return
	 */
	private EObject makeRefinedElement(EObject abstractParent,
			AbstractElementRefiner refiner,
			EventBNamedCommentedComponentElement concreteComponent, EObject abstractElement) {
		
		EObject refinedObject;
		
		if (abstractElement instanceof EventBObject) {
			
			//not sure what this was trying to do!
//			URI uri = EcoreUtil.getURI(abstractParent);
//			URI uri2 = EcoreUtil.getURI(abstractElement);
//			String fragment = EcoreUtil.getID(abstractElement);
//			int i = fragment.lastIndexOf("::")+2;
//			String tail = fragment.substring(i);
//			fragment=fragment.substring(0,i);
//			//fragment=fragment+ //uri.fragment().substring(i);
//			fragment=fragment+"."+tail;
//			uri = uri.trimFragment().appendFragment(fragment); int k=0;
			
			
			URI uri = EcoreUtil.getURI(abstractElement);
			refinedObject =  refiner.refine(uri, (EventBObject)abstractElement, concreteComponent);
		} else {
			// for non-Event-B elements the best we can do is to return a copy
			refinedObject = EcoreUtil.copy(abstractElement);
		}
		return refinedObject;
	}

	
	EObject oldComponent;
	Map<EObject, EObject> equivMap;
	
	/**
	 * gets the old (pre-changes) eObject that is equivalent to the given one.
	 * however, where names have been changed this would fail because the proxy URI is changed by the new name,
	 * therefore it checks the prepared name changes map and updates the equivalence map with a similar old but renamed eObject
	 * before retrieving it. Once the equivalence map has been updated for the name change the name change entry is removed from the 
	 * name changes map so that next time this key object is retrieved, the equivalence map is used directly.
	 **/
	private EObject getOldObject(EObject v)  {
		try {
			if (oldComponent == null){
					oldComponent = RefactorPersistence.INSTANCE.getPreComponent(res);
			}
			if (equivMap == null){
				equivMap = RefactorPersistence.INSTANCE.getEquivalenceMap(res);
			}
			if (oldNameMap.containsKey(v)){
				EObject value = null;
				for (Entry<EObject, EObject> en : equivMap.entrySet()){
					EObject k = en.getKey();
					String uri1 = EcoreUtil.getURI(k).toString();
					String uri2 = oldNameMap.get(v).toString();
					if (uri1.equals(uri2)){
						value = (EObject)en.getValue();
						continue;
					}
				}
				if (value != null) {
					equivMap.put(v, value);
					oldNameMap.remove(v);
				}
			}
			return (EObject) equivMap.get(v);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Returns true if the child EObject is directly or indirectly contained in the container EObject
	 * @param container
	 * @param child
	 * @return
	 */
	private boolean isIn(EObject container,EObject child) {
		if (child==null || container==null) return false;
		if (container==child) return true;
		return isIn(container,child.eContainer());
	}
	
	/**
	 * Converts a list of objects into a comma separated list of identifiers
	 * For EventBObjects the identifiers come from their uri fragments
	 * 
	 * @param newValues
	 * @return
	 */
	private String getURIsAsCSL(List<Object> newValues) {
		String ret = "";
		for (Object o : newValues){
			if (ret.length()>0) ret=ret+",";
			if (o instanceof EventBObject){
				ret = ret + EcoreUtil.getURI((EventBObject)o).fragment();
			}else{
				ret = ret + o.toString();
			}
		}
		return ret.length()>0? ret : "FAILED";
	}
	
	/**
	 * tests whether the (reverse) FeatureChange can be applied to the EObject
	 * this is true if the corresponding feature value in the target object is
	 * equivalent to the old value from the feature change
	 * 
	 *
	 * @param refinedObject
	 * @param reverseFeatureChange
	 * @return
	 */
	private boolean canApplyFeatureChange(EventBNamedCommentedComponentElement concreteComponent, EObject refinedObject, FeatureChange reverseFeatureChange, AbstractElementRefiner refiner) {
		EStructuralFeature feature = reverseFeatureChange.getFeature();
		if (feature.isMany()) return true; //for now, all lists can apply changes
		if (refinedObject.eClass().getEAllStructuralFeatures().contains(feature)){
			Object refinedFeatureValue = refinedObject.eGet(feature);
			Object oldAbstractFeatureValue = reverseFeatureChange.getValue();
			return isEquivalent(concreteComponent, feature, refinedFeatureValue, oldAbstractFeatureValue, refiner);
		}	
		return false;
	}
	
	/**
	 * returns true if the two value instances, fv1 and fv2, of feature, are equivalent
	 * (where equivalence depends on type)
	 * 
	 * for now lists always return true
	 * 
	 * @param feature
	 * @param fv1	refined value
	 * @param fv2	abstract value
	 * @return
	 */
	private boolean isEquivalent(EventBNamedCommentedComponentElement concreteComponent, EStructuralFeature feature, Object fv1, Object fv2, AbstractElementRefiner refiner){
		if (fv1==fv2) return true;
		if (feature.getEType().equals(EcorePackage.Literals.ESTRING)){
			return isStringEquivalent((String)fv1,(String)fv2);
		}else if (feature.getEType().equals(EcorePackage.Literals.EDATA_TYPE)){
			return fv1.equals(fv2);
//		}else  if (feature.getEType().equals(EcorePackage.Literals.EOBJECT)){
//			return fv1.equals(fv2);
		}else if (feature.isMany()){
			return true;
		}else if (fv1==null){
			return fv2==null;
		}else if (fv1 instanceof EObject && fv2 instanceof EObject){
			return fv1.equals(getEquivalentObjectInRefinement(
					concreteComponent, 
					(EObject)fv2, refiner));
		}else return false;
	}

	/**
	 * returns true iff s1 and s2 are equal after removal of whitespace or both null
	 * @param s1
	 * @param s2
	 * @return
	 */
	private boolean isStringEquivalent(String s1, String s2) {
		if (s1==null) return s2==null;
		if (s2==null) return false;
		String s1r = s1.replaceAll("\\s", "");
		String s2r = s2.replaceAll("\\s", "");
		return s1r.equals(s2r);
	}
	


	/**
	 * generates a string from the current time
	 * @return
	 */
	private String getTimeStamp() {
		Calendar cal = Calendar.getInstance();
		String m = ""+(cal.get(Calendar.MONTH)+1);
		m=m.length()<2? "0"+m : m;
		String d = ""+(cal.get(Calendar.DAY_OF_MONTH));
		d=d.length()<2? "0"+d : d;
		String h = ""+(cal.get(Calendar.HOUR_OF_DAY));
		h=h.length()<2? "0"+h : h;
		String n = ""+(cal.get(Calendar.MINUTE));
		n=n.length()<2? "0"+n : n;
		return ""+cal.get(Calendar.YEAR)+m+d+h+n;
	}

}
