package classpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {

	//ServiceRegistration publishServiceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		
		System.out.println("Class Publisher Start");
		//ParkingSlots publisherService = null ;
		//publishServiceRegistration = bundleContext.registerService(
				//ParkingSlots.class.getName(), publisherService, null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Publisher Stop");
		//publishServiceRegistration.unregister();
	}

}
