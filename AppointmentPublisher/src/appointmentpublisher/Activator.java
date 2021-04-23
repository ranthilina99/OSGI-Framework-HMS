package appointmentpublisher;

import java.time.LocalTime;
import java.util.ArrayList;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;



	public void start(BundleContext bundleContext) throws Exception {

		System.out.println("Doctor Appoinment Publisher Start");
		AppointmentService appointmentService = new AppointmentServiceImp();
		publishServiceRegistration = bundleContext.registerService(
				AppointmentService.class.getName(), appointmentService, null);



	}

	public void stop(BundleContext bundleContext) throws Exception {

		System.out.println("Publisher Stop");
		publishServiceRegistration.unregister();

	}

}
