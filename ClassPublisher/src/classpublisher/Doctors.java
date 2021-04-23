package classpublisher;

import java.time.LocalTime;

public class Doctors {
	
	
	private String dId;
	private String dName;
	private LocalTime dStartingHour;
	private LocalTime dEndingHour;
	private String dSpecialization;
	private double dAppoinmantCharge;
	
	
	
	
	
	public Doctors(String dId, String dName, LocalTime dStartingHour, LocalTime dEndingHour, String dSpecialization,
			double dAppoinmantCharge) {
		super();
		this.dId = dId;
		this.dName = dName;
		this.dStartingHour = dStartingHour;
		this.dEndingHour = dEndingHour;
		this.dSpecialization = dSpecialization;
		this.dAppoinmantCharge = dAppoinmantCharge;
	}


	
	
	public String getdId() {
		return dId;
	}


	public void setdId(String dId) {
		this.dId = dId;
	}


	public String getdName() {
		return dName;
	}


	public void setdName(String dName) {
		this.dName = dName;
	}


	public LocalTime getdStartingHour() {
		return dStartingHour;
	}


	public void setdStartingHour(LocalTime dStartingHour) {
		this.dStartingHour = dStartingHour;
	}


	public LocalTime getdEndingHour() {
		return dEndingHour;
	}


	public void setdEndingHour(LocalTime dEndingHour) {
		this.dEndingHour = dEndingHour;
	}


	public String getdSpecialization() {
		return dSpecialization;
	}


	public void setdSpecialization(String dSpecialization) {
		this.dSpecialization = dSpecialization;
	}


	public double getdAppoinmantCharge() {
		return dAppoinmantCharge;
	}


	public void setdAppoinmantCharge(double dAppoinmantCharge) {
		this.dAppoinmantCharge = dAppoinmantCharge;
	}



	
	

	
}