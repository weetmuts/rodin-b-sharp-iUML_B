package ac.soton.eventb.classdiagrams.persistance;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ClassdiagramsPersistancePlugin implements BundleActivator {

	public static final String PLUGIN_ID = "ac.soton.eventb.classdiagrams.persistence";
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		ClassdiagramsPersistancePlugin.context = bundleContext;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		ClassdiagramsPersistancePlugin.context = null;
	}

}
