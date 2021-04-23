package classpublisher;

import java.time.LocalDate;

public class Medicine {
	
	int MID;
	String MName;
	String MType;
	double MAmount;
	LocalDate ExDate;
	int quentity;
	
	public Medicine(int mID, String mName, String mType, double mAmount, LocalDate exDate, int quentity) {
		super();
		MID = mID;
		MName = mName;
		MType = mType;
		MAmount = mAmount;
		ExDate = exDate;
		this.quentity = quentity;
	}
	

	public int getMID() {
		return MID;
	}
	public void setMID(int mID) {
		MID = mID;
	}
	public String getMName() {
		return MName;
	}

	public void setMName(String mName) {
		MName = mName;
	}
	public String getMType() {
		return MType;
	}
	public void setMType(String mType) {
		MType = mType;
	}
	public double getMAmount() {
		return MAmount;
	}
	public void setMAmount(double mAmount) {
		MAmount = mAmount;
	}

	public LocalDate getExDate() {
		return ExDate;
	}

	public void setExDate(LocalDate exDate) {
		ExDate = exDate;
	}

	public int getCount() {
		return quentity;
	}

	public void setCount(int quentity) {
		this.quentity = quentity;
	}
	
	
	
	
	
}