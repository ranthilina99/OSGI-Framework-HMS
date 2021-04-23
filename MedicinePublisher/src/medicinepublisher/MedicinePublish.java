package medicinepublisher;

import java.time.LocalDate;

public interface MedicinePublish {
	
	public void printAll();
	public void printAll(String type);
	public void printAllmedicineQuantity();
	public void findmedicineName(String Type);
	public void printMedicineQuantity(String Mtype,String MName);
	public void calculateAmount(String type,String name,int no);
	public void medicineExpired();
	public void findmedicineNameExpired(String MName);
	
}

