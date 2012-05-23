package ac.soton.eventb.classdiagrams.parser;

import org.eclipse.osgi.util.NLS;

import ac.soton.eventb.classdiagrams.Association;

public class SymbolUtil {
	
	private static final String BUNDLE_NAME = "ac.soton.eventb.classdiagrams.parser.SymbolUtil"; //$NON-NLS-1$
	
	// //////////////////////////////////////////////////////////
	// ADMIN and HELPER methods
	// /////////////////////////////////////////////////////////
	static {
		NLS.initializeMessages(BUNDLE_NAME, SymbolUtil.class);
	}
	
	//TODO make enumeration of all symbols
	//relation symbols
	public enum Relation {
		
	}
	
	public static String REL_TOTAL_BIJECTION;				
	public static String REL_TOTAL_SURJECTION;									
	public static String REL_TOTAL_INJECTION;
	public static String REL_TOTAL_FUNCTION;
	public static String REL_PARTIAL_SURJECTION;
	public static String REL_PARTIAL_INJECTION;
	public static String REL_PARTIAL_FUNCTION;
	public static String REL_TOTAL_SURJECTIVE_REL;
	public static String REL_TOTAL_RELATION;
	public static String REL_PARTIAL_SURJECTIVE_RELATION;
	public static String REL_PARTIAL_RELATION;
	
	public class RelationType {
		
		boolean functional;
	    boolean total;
	    boolean surjective;
	    boolean injective;
	    
		public boolean isFunctional() {
			return functional;
		}
		public void setFunctional(boolean functional) {
			this.functional = functional;
		}
		public boolean isTotal() {
			return total;
		}
		public void setTotal(boolean relational) {
			this.total = relational;
		}
		public boolean isSurjective() {
			return surjective;
		}
		public void setSurjective(boolean surjective) {
			this.surjective = surjective;
		}
		public boolean isInjective() {
			return injective;
		}
		public void setInjective(boolean injective) {
			this.injective = injective;
		}
	    
	}
	
	public static boolean isRelation(String pRelation){
		if (pRelation != null && 
			   (pRelation.equals(REL_TOTAL_BIJECTION) ||
				pRelation.equals(REL_TOTAL_SURJECTION) ||
				pRelation.equals(REL_TOTAL_INJECTION) ||
				pRelation.equals(REL_TOTAL_FUNCTION) ||
				pRelation.equals(REL_PARTIAL_SURJECTION) ||
				pRelation.equals(REL_PARTIAL_INJECTION) ||
				pRelation.equals(REL_PARTIAL_FUNCTION) ||
				pRelation.equals(REL_TOTAL_SURJECTIVE_REL) ||
				pRelation.equals(REL_TOTAL_RELATION) ||
				pRelation.equals(REL_PARTIAL_SURJECTIVE_RELATION) ||
				pRelation.equals(REL_PARTIAL_RELATION))
			){
			return true;				
		} else {
			return false;
		}
	}
	
	public static String getRelationType(Association element) {
		if (element.isFunctional()){
			if (element.isTotal()) {
				if (element.isSurjective()){
					if (element.isInjective()){
						return REL_TOTAL_BIJECTION;				//total bijection
					}else{
						return REL_TOTAL_SURJECTION;				//total surjection						
					}
				}else{
					if (element.isInjective()){
						return REL_TOTAL_INJECTION;				//total injection
					}else{
						return REL_TOTAL_FUNCTION;				//total function
					}				
				}
			}else{
				if (element.isSurjective()){
					return REL_PARTIAL_SURJECTION;				//partial surjection
				}else{
					if (element.isInjective()){
						return REL_PARTIAL_INJECTION;				//partial injection	
					}else{
						return REL_PARTIAL_FUNCTION;				//partial function		
					}					
				}				
			}
		}else{
			if (element.isTotal()) {
				if (element.isSurjective()){
					return REL_TOTAL_SURJECTIVE_REL;			//total surjective relation
				}else{
					return REL_TOTAL_RELATION;				//total relation		
				}					
			}else{
				if (element.isSurjective()){
					return REL_PARTIAL_SURJECTIVE_RELATION;				//partial surjective relation
				}else{
					return REL_PARTIAL_RELATION;				//partial relation		
				}					
			}
		}
	}
	
	public static RelationType getRelationPorperties(String relation) {
		if (relation == null){
			return null;
		}
		
		RelationType rt =  new SymbolUtil().new RelationType();
		
		if (relation.equals(REL_TOTAL_BIJECTION)){
			rt.setFunctional(true);
			rt.setTotal(true);
			rt.setSurjective(true);
			rt.setInjective(true);
		} else if (relation.equals(REL_TOTAL_SURJECTION)){
			rt.setFunctional(true);
			rt.setTotal(true);
			rt.setSurjective(true);
			rt.setInjective(false);
		} else if (relation.equals(REL_TOTAL_INJECTION)){
			rt.setFunctional(true);
			rt.setTotal(true);
			rt.setSurjective(false);
			rt.setInjective(true);
		} else if (relation.equals(REL_TOTAL_FUNCTION)){
			rt.setFunctional(true);
			rt.setTotal(true);
			rt.setSurjective(false);
			rt.setInjective(false);
		} else if (relation.equals(REL_PARTIAL_SURJECTION)){
			rt.setFunctional(true);
			rt.setTotal(false);
			rt.setSurjective(true);
			rt.setInjective(false); //TODO really???
		} else if (relation.equals(REL_PARTIAL_INJECTION)){
			rt.setFunctional(true);
			rt.setTotal(false);
			rt.setSurjective(false);
			rt.setInjective(true);
		} else if (relation.equals(REL_PARTIAL_FUNCTION)){
			rt.setFunctional(true);
			rt.setTotal(false);
			rt.setSurjective(false);
			rt.setInjective(false);
		} else if (relation.equals(REL_TOTAL_SURJECTIVE_REL)){
			rt.setFunctional(false);
			rt.setTotal(true);
			rt.setSurjective(true);
			rt.setInjective(false); //TODO really?
		} else if (relation.equals(REL_TOTAL_RELATION)){
			rt.setFunctional(false);
			rt.setTotal(true);
			rt.setSurjective(false);
			rt.setInjective(false); //TODO???
		} else if (relation.equals(REL_PARTIAL_SURJECTIVE_RELATION)){
			rt.setFunctional(false);
			rt.setTotal(false);
			rt.setSurjective(true);
			rt.setInjective(false); //TODO ???
		} else if (relation.equals(REL_PARTIAL_RELATION)){
			rt.setFunctional(false);
			rt.setTotal(false);
			rt.setSurjective(false);
			rt.setInjective(false); //TODO ???
		}
		
		return rt;
	}

}
