package appointmentconsumer;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import appointmentpublisher.AppointmentService;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;



	public void start(BundleContext bundleContext) throws Exception {


		System.out.println("Starting Appoinment  Subscriber Service");

		Scanner sc = new Scanner(System.in);

		serviceReference = bundleContext.getServiceReference(AppointmentService.class.getName());
		AppointmentService servicePublish = (AppointmentService) bundleContext.getService(serviceReference);

		// System.out.println(servicePublish.publishService());

		while (true) {

			System.out.println("");
			System.out.println("To show all Doctor Info  : '1'");
			System.out.println("To show Doctor Charges   : '2'");
			System.out.println("To  the Appoinment hh:mm : '3'");
			System.out.println("To Specialization List   : '4'");
			System.out.println("To Exit input            : '5'");
			System.out.println(" ");

			System.out.println("Enter to proceed: ");
			int responce = sc.nextInt();
			System.out.println(" ");

			if (responce == 1) {
				servicePublish.printAll();



			} else if (responce == 2) {

				System.out.println("Enter Doctor Id :");
				String responce2 =  sc.next();			   
				servicePublish.printDoctorAmount(responce2);



			}
			else if(responce==3) {
				System.out.println("Enter Doctor Id :");
				String id= sc.next();				   
				System.out.println("Enter Appoinement Time :");				   
				String responce3= sc.next();


				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
				LocalTime dateTime = LocalTime.parse(responce3, formatter);				    
				servicePublish.BookAppoinment(id,dateTime);		



			}else if(responce==4) {

				System.out.println("Enter Specilization Type:");
				String response4=sc.next();
				System.out.println("");

				servicePublish.FindBySpecialization(response4);

			}



			else if (responce == 5) {

				break;
			}else {
				
				System.out.println("Invalid Input ");
			}

		}

	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Good Bye !!!");

	}

}


