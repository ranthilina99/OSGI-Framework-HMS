package classpublisher;

public class Attendance {
	
	private String empID;
	private String empName;
	private String possition;
	private double  startTime;
	private double  endTime;
	private double basicsalary;
	private double totSalary;
	private int halfDays;
	private int shortLeaves;
	
	public Attendance(String empID, String empName,String possition, double  startTime, double  endTime, double basicsalary, int halfDays, int shortLeaves) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.possition = possition;
		this.startTime = startTime;
		this.endTime = endTime;
		this.basicsalary = basicsalary;
 		this.halfDays = halfDays;
		this.shortLeaves = shortLeaves;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	

	public String getPossition() {
		return possition;
	}

	public void setPossition(String possition) {
		this.possition = possition;
	}

	public double  getStartTime() {
		return startTime;
	}

	public void setStartTime(double  startTime) {
		this.startTime = startTime;
	}

	public double  getEndTime() {
		return endTime;
	}

	public void setEndTime(double  endTime) {
		this.endTime = endTime;
	}

	public double getBasicsalary() {
		return basicsalary;
	}

	public void setBasicsalary(double basicsalary) {
		this.basicsalary = basicsalary;
	}

	public double getTotSalary() {
		return totSalary;
	}

	public void setTotSalary(double totSalary) {
		this.totSalary = totSalary;
	}

	public int getHalfDays() {
		return halfDays;
	}

	public void setHalfDays(int halfDays) {
		this.halfDays = halfDays;
	}

	public int getShortLeaves() {
		return shortLeaves;
	}

	public void setShortLeaves(int shortLeaves) {
		this.shortLeaves = shortLeaves;
	}

}
