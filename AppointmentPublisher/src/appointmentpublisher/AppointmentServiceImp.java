package appointmentpublisher;

import java.time.LocalTime;
import java.util.ArrayList;

import classpublisher.Doctors;

public class AppointmentServiceImp implements AppointmentService {


	Doctors d1 = new Doctors("1","Kamal Gunawardhana",LocalTime.of(7, 30, 45),LocalTime.of(10, 30, 45),"Neurologists",10500.00);
	Doctors d2 = new Doctors("2","Shamali deSilva",LocalTime.of(4, 30, 45),LocalTime.of(8, 30, 45),"Hematologists",5500.00);
	Doctors d3 = new Doctors("3","Wikum Fernando",LocalTime.of(1, 30, 45),LocalTime.of(8, 30, 45),"Dermatologists",9500.00);
	Doctors d4 = new Doctors("4","Umesh Kariyawasam",LocalTime.of(10, 30, 45),LocalTime.of(10, 30, 45),"Neurologists",10500.00);
	Doctors d5 = new Doctors("5","Yasoja Withethunga",LocalTime.of(8, 30, 45),LocalTime.of(15, 30, 45),"Hematologists",5500.00);
	Doctors d6 = new Doctors("6","Binuka Fernando",LocalTime.of(6, 30, 45),LocalTime.of(12, 30, 45),"Dermatologists",9500.00);


	ArrayList<Doctors> arrayList =new ArrayList<Doctors>();



	public AppointmentServiceImp() {
		arrayList.add(d1);
		arrayList.add(d2);
		arrayList.add(d3);
		arrayList.add(d4);
		arrayList.add(d5);
		arrayList.add(d6);
	}



	@Override
	public void printAll() {


		System.out.println("ID"+" \t "+"Name"+" \t\t\t\t "+"Specialization"+"\t\t "+"Starting time"+" \t "+"Ending Time"); 
		System.out.println("");
		for (Doctors i : arrayList) {
			System.out.println(i.getdId()+" \t "+i.getdName()+" \t\t "+ i.getdSpecialization()+"\t\t "+i.getdStartingHour()+" \t "+i.getdEndingHour());
		}




	}



	@Override
	public void printDoctorAmount(String Id) {

		System.out.println("ID"+" \t "+"Name"+" \t\t\t "+"Appoinment Charge");
		for (Doctors i : arrayList) {

			if(Id.equals(i.getdId())) {
				
                System.out.println("");
				System.out.println(i.getdId()+" \t "+i.getdName()+" \t "+i.getdAppoinmantCharge());
			}

		}


	}



	@Override
	public void FindBySpecialization(String Special) {

		System.out.println("Availabel Realevent Docotrs.... ");
		System.out.println("");
		System.out.println("ID"+" \t "+"Name"+" \t\t\t\t "+"Specialization"+"\t\t "+"Starting time"+" \t "+"Ending Time"); 
		System.out.println("");
		for (Doctors i : arrayList) {

			if(Special.equals(i.getdSpecialization())) {
				
				
				
				System.out.println(i.getdId()+" \t "+i.getdName()+" \t\t "+ i.getdSpecialization()+"\t\t "+i.getdStartingHour()+" \t "+i.getdEndingHour());
			}


		}

	}




	@Override
	public void BookAppoinment(String Id, LocalTime time) {

		for (Doctors i : arrayList) {

			if(Id.equals(i.getdId())) {



				if(time.isAfter(i.getdStartingHour()) && time.isBefore(i.getdEndingHour())) {

					System.out.println("!!!Appoinmant Booked!!!");
					System.out.println("");

				}else {

					System.out.println("!!!Appoinmant Unavailable at that time!!!");
					System.out.println("");
				}

			}


		}


	}	 

}
