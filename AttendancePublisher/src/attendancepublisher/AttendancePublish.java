package attendancepublisher;

public interface AttendancePublish {
	
	public void printAll();
	public boolean checkID(String id);
	public void start(String id,double time);
	public void sLeave(String id,double stime,double etime);
	public void hDay(String id,double stime,double etime);
	public void printOne(String id);
	public void signOut(String id,double stime,double etime,boolean leave);
	

}
