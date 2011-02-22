package ac.soton.eventb.statemachines.navigator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import ac.soton.eventb.statemachines.diagram.part.StatemachinesDiagramEditorPlugin;

/**
 * The activator class controls the plug-in life cycle
 */
public class StatemachinesNavigatorPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "ac.soton.eventb.statemachines.navigator"; //$NON-NLS-1$

	// The shared instance
	private static StatemachinesNavigatorPlugin plugin;
	
	/**
	 * The constructor
	 */
	public StatemachinesNavigatorPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static StatemachinesNavigatorPlugin getDefault() {
		return plugin;
	}

	/**
	 * Log an error.
	 * Copied from diagram generated code
	 * @param error
	 */
	public void logError(String error) {
		logError(error, null);
	}
	
	/**
	 * Log an error with throwable.
	 * Copied from diagram generated code
	 * @param error
	 * @param throwable
	 */
	public void logError(String error, Throwable throwable) {
		if (error == null && throwable != null) {
			error = throwable.getMessage();
		}
		getLog().log(
				new Status(IStatus.ERROR, StatemachinesDiagramEditorPlugin.ID,
						IStatus.OK, error, throwable));
		debug(error, throwable);
	}
	
	/**
	 * Debug an error.
	 * Copied from diagram generated code
	 * @param message
	 * @param throwable
	 */
	private void debug(String message, Throwable throwable) {
		if (!isDebugging()) {
			return;
		}
		if (message != null) {
			System.err.println(message);
		}
		if (throwable != null) {
			throwable.printStackTrace();
		}
	}
}
