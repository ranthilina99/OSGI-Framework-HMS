package appointmentpublisher;

import java.time.LocalTime;

public interface AppointmentService {

	public void printAll();
	public void printDoctorAmount(String Id);
	public void FindBySpecialization(String Special);
	public void BookAppoinment(String Id,LocalTime time);
	
	
	
}
