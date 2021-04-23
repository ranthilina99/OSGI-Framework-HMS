package attendanceconsumer;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import attendancepublisher.AttendancePublish;
import java.util.*;;

public class Activator implements BundleActivator {
	
	ServiceReference serviceReference;
	boolean s;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting Attendance Subscriber Service");
		
		Scanner sc = new Scanner(System.in);

		serviceReference = bundleContext.getServiceReference(AttendancePublish.class.getName());
		AttendancePublish servicePublish = (AttendancePublish) bundleContext.getService(serviceReference);
		
		System.out.println("--------------------Login System---------------------");
		System.out.println("");

		while (true) {

			System.out.println("Enter yor Employee ID (Exxx)");
			System.out.println("----------------------------");
			
			String id = sc.next();
			
			s = servicePublish.checkID(id);
			
			if(s == true) {
				
				System.out.println("Add your Start-up Time (24 hours-13.00)");
				System.out.println("---------------------------------------");
				double sTime = sc.nextDouble();
				
				servicePublish.start(id,sTime);
				
				System.out.println("-----------------------------------");
				System.out.println("If you want to see your profile '1'");
				System.out.println("If you want to take a Leave     '2'");
				System.out.println("End your Day                    '3'");
				System.out.println("To Exit input                   '4'");
				System.out.println("-----------------------------------");
				int responce = sc.nextInt();
				
				if(responce == 1) {
					servicePublish.printOne(id);
				}
				else if(responce == 2) {
					System.out.println("If you want to take short Leave     '1'");
					System.out.println("If you want to take Half Day Leave  '2'");
					System.out.println("---------------------------------------");
					
					int leave = sc.nextInt();
					if(leave == 1) {
						System.out.println("Enter leave time (24 hours-13.00)");
						double lTime = sc.nextDouble();
						
						servicePublish.sLeave(id,sTime,lTime);
					}
					else if(leave == 2) {
						System.out.println("Enter leave time (24 hours-13.00)");
						double lTime = sc.nextDouble();
						
						servicePublish.hDay(id,sTime,lTime);
					}
				}
				else if(responce == 3) {
					System.out.println("Enter Day-Off time (24 hours-13.00)");
					double lTime = sc.nextDouble();
					
					boolean leave = false;
					
					servicePublish.signOut(id,sTime,lTime,leave);
				}
				else if(responce == 4) {
					break;
				}
				
			}
			else {
				System.out.println("To Retry        '1'");
				System.out.println("To Exit input   '2'");
				System.out.println("-------------------");
				int res = sc.nextInt();
				if(res == 1) {
					System.out.println("Enter yor Employee ID (Exxx)");
					System.out.println("----------------------------");
					
					String idd = sc.next();
					
					s = servicePublish.checkID(idd);
					
					if(s == true) {
						
						System.out.println("Add your Start-up Time (24 hours-13.00)");
						System.out.println("---------------------------------------");
						double sTime = sc.nextDouble();
						
						servicePublish.start(idd,sTime);
						
						System.out.println("-----------------------------------");
						System.out.println("If you want to see your profile '1'");
						System.out.println("If you want to take a Leave     '2'");
						System.out.println("End your Day                    '3'");
						System.out.println("To Exit input                   '4'");
						System.out.println("-----------------------------------");
						int responce = sc.nextInt();
						
						if(responce == 1) {
							servicePublish.printOne(idd);
						}
						else if(responce == 2) {
							System.out.println("If you want to take short Leave     '1'");
							System.out.println("If you want to take Half Day Leave  '2'");
							System.out.println("---------------------------------------");
							
							int leave = sc.nextInt();
							if(leave == 1) {
								System.out.println("Enter leave time (24 hours-13.00)");
								double lTime = sc.nextDouble();
								
								servicePublish.sLeave(idd,sTime,lTime);
							}
							else if(leave == 2) {
								System.out.println("Enter leave time (24 hours-13.00)");
								double lTime = sc.nextDouble();
								
								servicePublish.hDay(idd,sTime,lTime);
							}
						}
						else if(responce == 3) {
							System.out.println("Enter Day-Off time (24 hours-13.00)");
							double lTime = sc.nextDouble();
							
							boolean leave = false;
							
							servicePublish.signOut(idd,sTime,lTime,leave);
						}
						else if(responce == 4) {
							break;
						}
						
					}
					
					else {
						System.out.println("No more chances!");
						break;
					}
				}
				else {
					break;
				}
			}
			
		}	

		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Good Bye !!!");
		bundleContext.ungetService(serviceReference);
	}

}
