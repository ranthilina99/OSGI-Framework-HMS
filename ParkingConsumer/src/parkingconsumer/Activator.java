package parkingconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import parkingpublisher.ParkingPublish;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting Parking Subscriber Service");
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("------------Welcome to Parking Service---------------");

		Scanner sc = new Scanner(System.in);

		serviceReference = bundleContext.getServiceReference(ParkingPublish.class.getName());
		ParkingPublish servicePublish = (ParkingPublish) bundleContext.getService(serviceReference);


		while (true) {
						
			servicePublish.StatusUpdate();
			
			System.out.println();
			System.out.println("To show all parking slot info     : '1'");
			System.out.println("To show all free parking slots    : '2'");
			System.out.println("To show the fee of a parking slot : '3'");
			System.out.println("To show when a slot will be free  : '4'");
			System.out.println("To reserve a parking slot         : '5'");
			System.out.println("To Exit                           : '6'");
			System.out.println();

			System.out.println("Enter to proceed:");
			int responce = sc.nextInt();
			System.out.println();

			if (responce == 1) {
				servicePublish.printAll();
			} else if (responce == 2) {
				System.out.println("Do you want to know all free slots?(yes/no): ");
				String responce2 = sc.next();

				if (responce2.equalsIgnoreCase("yes")) {
					System.out.println();
					servicePublish.printFreeSlots();
				} else if(responce2.equalsIgnoreCase("no")){
					System.out.println("Enter type(Doctor/Patient): ");
					String responce3 = sc.next();

					if (responce3.equalsIgnoreCase("Doctor")) {
						System.out.println();
						servicePublish.printFreeSlots("Doctor");
					} else if(responce3.equalsIgnoreCase("Patient")){
						System.out.println();
						servicePublish.printFreeSlots("Patient");
					}else {
						System.out.println("Invalid Input!!!");
					}
				}else {
					System.out.println("Invalid Input!!!");
				}
			} else if (responce == 3) {
				System.out.println();
				System.out.println("Enter slot no: ");
				int responce4 = sc.nextInt();

				System.out.println("Enter no of hours: ");
				int responce5 = sc.nextInt();

				servicePublish.calculateAmount(responce4, responce5);
			} else if (responce == 5) {
				System.out.println();
				System.out.println("Enter slot no: ");
				int responce6 = sc.nextInt();

				System.out.println("Enter no of hours: ");
				int responce7 = sc.nextInt();

				servicePublish.reserveSpot(responce6, responce7);
				
			}else if(responce == 4){
				
				System.out.println("Enter slot no: ");
				int no = sc.nextInt();
				
				servicePublish.WhenFree(no);
			
			}else if (responce == 6) {

				break;
			}else {
				System.out.println("Invalid Input!!!");
			}
		}

	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Good Bye !!!");
		bundleContext.ungetService(serviceReference);
	}

}
