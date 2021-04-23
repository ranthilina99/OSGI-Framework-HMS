package parkingpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;


	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Parking Publisher Start");
		ParkingPublish publisherService = new ParkingPublishImpl();
		publishServiceRegistration = context.registerService(
				ParkingPublish.class.getName(), publisherService, null);

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Parking Publisher Stop");
		publishServiceRegistration.unregister();
	}

}
