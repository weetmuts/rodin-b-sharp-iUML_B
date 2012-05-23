package ac.soton.eventb.classdiagrams.util;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import ac.soton.eventb.classdiagrams.Class;

import ac.soton.eventb.classdiagrams.ElaborativeElement;

public class ClassdiagramUtil {
	
	public static boolean isElaborated(EventBNamed pEventBNamed){
		
		EObject e = EcoreUtil.getRootContainer(pEventBNamed);
		
		if (e instanceof EventBNamedCommentedComponentElement){
			Iterator<EObject> iter = ((EventBNamedCommentedComponentElement)e).eAllContents(); 
			EObject o;
			EventBNamed ebn;
			
			while (iter.hasNext()){
				o = iter.next();
				
				if (o instanceof ElaborativeElement && ((ElaborativeElement)o).getElaborates() != null){
					ebn = ((ElaborativeElement)o).getElaborates();
					
					if ((ebn.getClass() == pEventBNamed.getClass()) &&
						(ebn.getName() != null) &&	
						(ebn.getName().equals(pEventBNamed.getName()))){
						
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public static boolean isRefined(EventBNamedCommentedComponentElement pContainer, EventBNamed pEventBNamed){
		
			Iterator<EObject> iter = pContainer.eAllContents(); 
			EObject o;
			Class ebn;
			
			while (iter.hasNext()){
				o = iter.next();
				
				if (o instanceof Class && ((Class)o).getRefines() != null){
					ebn = ((Class)o).getRefines();
					
					if ((ebn.getClass() == pEventBNamed.getClass()) &&
						(ebn.getName() != null) &&	
						(ebn.getName().equals(pEventBNamed.getName()))){
						
						return true;
					}
				}
			}
		
		return false;
	}
	
}
