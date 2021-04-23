package parkingpublisher;


public interface ParkingPublish {
	
	public void printAll();
	public void printFreeSlots();
	public void printFreeSlots(String type);
	public void calculateAmount(int no,int hours);
	public void reserveSpot(int no,int hours);
	public void StatusUpdate();
	public void WhenFree(int id);

}
