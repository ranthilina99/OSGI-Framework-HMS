package classpublisher;

import java.time.LocalTime;

public class ParkingSlots {
	
	int pNo;
	String pType;
	String pStatus;
	double pAmount;
	LocalTime start;
	LocalTime end;
	LocalTime end2;
	Boolean book;
	
	public ParkingSlots(int pNo, String pType, String pStatus,double amount) {
		super();
		this.pNo = pNo;
		this.pType = pType;
		this.pStatus = pStatus;
		this.pAmount = amount;
				
		
	}
	
	public ParkingSlots(int pNo, String pType, String pStatus,LocalTime st,LocalTime ed) {
		super();
		this.pNo = pNo;
		this.pType = pType;
		this.pStatus = pStatus;
		this.start = st;
		this.end = ed;
		this.book = false;
	}

	public Boolean getBook() {
		return book;
	}

	public void setBook(Boolean book) {
		this.book = book;
	}

	public LocalTime getStart() {
		return start;
	}

	public void setStart(LocalTime start) {
		this.start = start;
	}

	public LocalTime getEnd() {
		return end;
	}

	public void setEnd(LocalTime end) {
		this.end = end;
	}
	
	public LocalTime getEnd2() {
		return end2;
	}

	public void setEnd2(LocalTime end) {
		this.end2 = end;
	}


	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public String getpType() {
		return pType;
	}

	public void setpType(String pType) {
		this.pType = pType;
	}

	public String getpStatus() {
		return pStatus;
	}

	public void setpStatus(String pStatus) {
		this.pStatus = pStatus;
	}

	public double getpAmount() {
		return pAmount;
	}

	public void setpAmount(double pAmount) {
		this.pAmount = pAmount;
	}
	
	

}
