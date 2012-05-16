package ac.soton.eventb.classdiagrams.navigator.refiner;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eventb.core.IContextRoot;
import org.eventb.emf.core.EventBElement;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IRefinementParticipant;
import org.rodinp.core.RodinDBException;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.Classdiagram;
import ac.soton.eventb.classdiagrams.ClassdiagramsFactory;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.emf.core.extension.persistence.ISerialisedExtension;
import ac.soton.eventb.emf.core.extension.persistence.SerialisedExtensionSynchroniser;


public class ClassdiagramContextExtender implements IRefinementParticipant {

	private SerialisedExtensionSynchroniser synchroniser;
	private URI sourceURI;
	private URI targetURI;

	/**
	 * Constructor.
	 */
	public ClassdiagramContextExtender() {
		synchroniser = new SerialisedExtensionSynchroniser();
	}

	@Override
	public void process(IInternalElement targetRoot,
			IInternalElement sourceRoot, IProgressMonitor monitor)
			throws RodinDBException {

		final IContextRoot target = (IContextRoot) targetRoot;
		final IContextRoot source = (IContextRoot) sourceRoot;

		// machine URIs
		String projectName = source.getRodinProject().getElementName();
		sourceURI = URI.createURI("platform:/resource/" + projectName + "/"
				+ source.getComponentName() + ".buc");
		targetURI = URI.createURI("platform:/resource/" + projectName + "/"
				+ target.getComponentName() + ".buc");

		refineClassdiagramExtensions(target, source, monitor);
	}

	/**
	 * Refines all classdiagram extensions.
	 * 
	 * @param target concrete machine root
	 * @param source abstract machine root
	 * @param map refinement map
	 * @param monitor progress monitor
	 * @throws RodinDBException 
	 */
	private void refineClassdiagramExtensions(IContextRoot target,
			IContextRoot source, IProgressMonitor monitor)
			throws RodinDBException {
		for (ISerialisedExtension extension : source.getChildrenOfType(ISerialisedExtension.ELEMENT_TYPE)) {
			if (extension.hasExtensionId() && extension.getExtensionId().startsWith(ClassdiagramsPackage.CLASSDIAGRAMS_EXTENSION_ID)){
				EventBElement eventBElement = synchroniser.load(extension, null, monitor);
				synchroniser.save(
						refineClassdiagram((Classdiagram) eventBElement), 
						target,
						monitor);
			}
		}
	}

	/**
	 * Returns refined classdiagram from root classdiagram.
	 * 
	 * @param absSM root classdiagram
	 * @param map refinement map
	 * @return refined classdiagram
	 */
	private Classdiagram refineClassdiagram(Classdiagram source) {
		// refine classdiagram, classes and associations
		// create refined classdiagram
		Classdiagram conSM = ClassdiagramsFactory.eINSTANCE.createClassdiagram();
		conSM.setReference(source.getReference());
		conSM.setRefines((Classdiagram) EMFCoreUtil.createProxy(
				ClassdiagramsPackage.eINSTANCE.getClassdiagram(),
				sourceURI.appendFragment(EcoreUtil.getID(source))));

		// keep same extension id
		String extensionID = source.getExtensionId();
		if (extensionID != null)
			conSM.setExtensionId(extensionID);

		// create classes
		for (Class c : source.getClasses()){
			conSM.getClasses().add(ClassdiagramCommonRefiner.refineClass(sourceURI, targetURI, c));	
		}
		
		// refine transitions
//		for (Association c : source.getClassAssociations()){
//			conSM.getClassAssociations().add(ClassdiagramCommonRefiner.refineAssociation(sourceURI, targetURI, c));	
//		}
		
		return conSM;
	}

}
