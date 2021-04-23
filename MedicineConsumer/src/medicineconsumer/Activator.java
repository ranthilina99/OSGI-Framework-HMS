package medicineconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import medicinepublisher.MedicinePublish;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Medicine consumer start");
		
		Scanner sc=new Scanner(System.in);
		
		serviceReference=bundleContext.getServiceReference(MedicinePublish.class.getName());
		MedicinePublish servicepublish=(MedicinePublish) bundleContext.getService(serviceReference);
		
		while(true) {
			
			System.out.println("-------------------------------------------------------------------------------------");
			servicepublish.medicineExpired();
			System.out.println();
			
			System.out.println("------------------------------Enter the Details--------------------------------------");
			System.out.println("To show all Medicine  info input       : '1'");
			System.out.println("To show all Quentity  Medicine input   : '2'");
			System.out.println("To show the amount of a Medicine  input: '3'");
			System.out.println("To show Expire Date Medicine info input: '4'");
			System.out.println("To Exit input '5'");
			System.out.println("--------------------------------------------------------------------------------------");
			
			System.out.println("Enter the Proceed");
			int response=sc.nextInt();
			
			if(response==1) {
				System.out.println("Do you want to know all Medicine Deatils?(yes/no)");
				String res=sc.next();
				
				if(res.equalsIgnoreCase("yes")){
					servicepublish.printAll();
					
				}else {
					System.out.println("Enter the type(Tablet/Liquid/Cream):");
					String type=sc.next();
					
					if(type.equalsIgnoreCase("Tablet")) {
						servicepublish.printAll(type);
						
					}else if(type.equalsIgnoreCase("Liquid")) {
						servicepublish.printAll(type);
						
					}else if(type.equalsIgnoreCase("Cream")) {
						servicepublish.printAll(type);
					}else {
						System.out.println("Invalid Input");
					}
				}
	
			}else if(response==2) {
				System.out.println("Do you want to know all Medicine count?(yes/no)");
				String res=sc.next();
				
				if(res.equalsIgnoreCase("yes")){
					servicepublish.printAllmedicineQuantity();
				}
				else {
					System.out.println("Enter the type(Tablet/Liquid/Cream):");
					String res1=sc.next();
					System.out.println();
					
					if(res1.equalsIgnoreCase("Tablet")) {
						
						servicepublish.findmedicineName("Tablet");
						
						System.out.println("Enter the Tablet Name:");
						String res2=sc.next();
						System.out.println();
						
						servicepublish.printMedicineQuantity("Tablet",res2);
					}
					else if(res1.equalsIgnoreCase("Liquid")) {
						
						servicepublish.findmedicineName("Liquid");
						
						System.out.println("Enter the Liquid Name:");
						String res2=sc.next();
						System.out.println();
						
						servicepublish.printMedicineQuantity("Liquid",res2);
					}
					else if(res1.equalsIgnoreCase("Cream")){
						
						servicepublish.findmedicineName("Cream");
						
						System.out.println("Enter the Cream Name:");
						String res2=sc.next();
						System.out.println();
						
						servicepublish.printMedicineQuantity("Cream",res2);
					}else {
						System.out.println("Invalid Input");
					}
				}
			}else if(response==3) {
				System.out.println("Enter the type(Tablet/Liquid/Cream):");
				String res1=sc.next();
				System.out.println();
				
				if(res1.equalsIgnoreCase("Tablet")) {
					
					servicepublish.findmedicineName("Tablet");
					
					System.out.println("Enter the Tablet Name:");
					String res2=sc.next();
					System.out.println();
					
					System.out.println("Enter the No of Tablets:");
					int res3=sc.nextInt();
					System.out.println();
					
					servicepublish.calculateAmount("Tablet",res2,res3);
				}
				else if(res1.equalsIgnoreCase("Liquid")) {
					
					servicepublish.findmedicineName("Liquid");
					
					System.out.println("Enter the Liquid Name:");
					String res2=sc.next();
					System.out.println();
					
					System.out.println("Enter the ml Liquid :");
					int res3=sc.nextInt();
					System.out.println();
					
					servicepublish.calculateAmount("Liquid",res2,res3);
				}
				else if(res1.equalsIgnoreCase("Cream")){
					
					servicepublish.findmedicineName("Cream");
					
					System.out.println("Enter the Cream Name:");
					String res2=sc.next();
					System.out.println();
					
					System.out.println("Enter the No of Cream Pack:");
					int res3=sc.nextInt();
					System.out.println();
					
					servicepublish.calculateAmount("Cream",res2,res3);
				}else {
					System.out.println("Invalid Input");
				}
			}else if(response==4) {				
				
				System.out.println("Do you want to know all Medicine expire details?(yes/no)");
				String res=sc.next();
				
				if(res.equalsIgnoreCase("yes")){
					servicepublish.medicineExpired();
				}else {
					System.out.println("Enter the Medicine Name:");
					String res2=sc.next();
					System.out.println();
					
					servicepublish.findmedicineNameExpired(res2);
				}			
			}else if(response==5) {
				break;
			}
				
		}
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Medicine Consumer Stop");
		context.ungetService(serviceReference);
	}

}
