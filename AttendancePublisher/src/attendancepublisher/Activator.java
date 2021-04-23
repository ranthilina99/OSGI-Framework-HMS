package attendancepublisher;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	
	public void start(BundleContext Context) throws Exception {
		System.out.println("Attendance Publisher Start");
		AttendancePublish publisherService = new AttendancePublishImpl();
		
		publishServiceRegistration = Context.registerService(
				AttendancePublish.class.getName(), publisherService, null);
	}

	public void stop(BundleContext Context) throws Exception {
		System.out.println("Attendance Publisher Stop");
		publishServiceRegistration.unregister();
	}

}
