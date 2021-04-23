package medicinepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegistration;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Medicine Publisher Start");
		MedicinePublish medicinePublish=new MedicinePublishImpl();
		serviceRegistration=context.registerService(MedicinePublish.class.getName(), medicinePublish, null);
	}

	public void stop(BundleContext Context) throws Exception {
		System.out.println("Medicine Publish stop");
		serviceRegistration.unregister();
	}

}