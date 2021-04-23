package attendancepublisher;

import java.util.ArrayList;
import java.util.Scanner;

import classpublisher.Attendance;

public class AttendancePublishImpl implements AttendancePublish {
	
	Scanner sc = new Scanner(System.in);
	
	Attendance a1 = new Attendance("E001","Kasuni","Nurse",08.00,16.00,50000,0,5);
	Attendance a2 = new Attendance("E002","Dulan","Accountant",08.00,16.00,45000,10,0);
	Attendance a3 = new Attendance("E003","Dasuni","Pharmacist",08.00,16.00,25000,7,5);
	Attendance a4 = new Attendance("E004","Asela","HR Manager",08.00,16.00,30000,0,4);
	Attendance a5 = new Attendance("E005","Pushpa","Cleaning Service",08.00,16.00,10000,2,0);
	
	ArrayList<Attendance> list = new ArrayList<Attendance>();
	
	public AttendancePublishImpl() {
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		list.add(a5);
	}
	
	

	@Override
	public void printAll() {
		// TODO Auto-generated method stub
		for (Attendance i : list) {
	        System.out.println(i.getEmpID()+"\t"+i.getEmpName()+"\t"+ i.getPossition()+"\t"+i.getStartTime()+"\t"+i.getEndTime()+"\t"+i.getBasicsalary()+"\t"+i.getHalfDays()+"\t"+i.getShortLeaves());
		}

	}



	@Override
	public boolean checkID(String id) {
		// TODO Auto-generated method stub
		boolean status = false;
		for (Attendance i : list) {
			if(i.getEmpID().equals(id)) {
				status = true;
				System.out.println("Welcome " + i.getEmpName());
				break;
			}
		}
		
		if(status == false) {
			System.out.println("Invalid Login ID");
		}
		
		return status;
		
		
	}



	@Override
	public void start(String id,double time) {
		// TODO Auto-generated method stub
		double start;
		int hours;
		int noSL;
		double fine;
		double tot;
		for (Attendance i : list) {
			if(i.getEmpID().equals(id)) {
				start = i.getStartTime();
				if(start < time) {
					hours = (int) (time - start);
					if(hours == 1) {
						fine = i.getBasicsalary() - 200;
						System.out.println("You are " + hours + " hour late");
						System.out.println("RS.200 has been deducted from your Salary");
						System.out.println("Total Salary : " + fine);
						System.out.println("Day Started!");
						
					}
					else if(hours == 2) {
						System.out.println("You are " + hours + " hours late");
						System.out.println("Considered as a Short leave");
						noSL = i.getShortLeaves();
						if(noSL == 0) {
							tot = i.getBasicsalary() - 250;
							System.out.println("Rs.250 has been charged for the leave");
							System.out.println("Total Salary : " + tot);
							System.out.println("Day Started!");
						}
						else {
							noSL--;
							System.out.println("Num of Short Leaves Remaining : " + noSL);
							System.out.println("Day Started!");
						}
						
					}
					else if(hours == 3) {
						fine = i.getBasicsalary() - 500;
						System.out.println("You are " + hours + " hours late");
						System.out.println("Considered as a Short leave + RS.500 has been deducted from your Salary for the extra our");
						noSL = i.getShortLeaves();
						if(noSL == 0) {
							tot = i.getBasicsalary() - 250 + 500;
							System.out.println("Rs.750 has been charged for the leave");
							System.out.println("Total Salary : " + tot);
							System.out.println("Day Started!");
						}
						else {
							tot = i.getBasicsalary() - 500;
							noSL--;
							System.out.println("Rs.250 has been charged for the leave");
							System.out.println("Num of Short Leaves Remaining : " + noSL);
							System.out.println("Total Salary : " + tot);
							System.out.println("Day Started!");
							
						}
					}
					else {
						System.out.println("You are " + hours + " hours late");
						System.out.println("Considered as a half day leave");
						noSL = i.getHalfDays();
						if(noSL == 0) {
							tot = i.getBasicsalary() - 500;
							System.out.println("Rs.500 has been charged for the leave");
							System.out.println("Total Salary : " + tot);
						}
						else {
							noSL--;
							System.out.println("Num of Half Day Leaves Remaining : " + noSL);
						}
						
					}
					break;
					
				}
				else
				{
					System.out.println("Day Started!");
				}
			}
			
		}
		
	}



	@Override
	public void sLeave(String id,double stime,double etime) {
		// TODO Auto-generated method stub
		int noSL;
		double Etime;
		boolean leave = true;
		int hours;
		double tot;
		for (Attendance i : list) {
			if(i.getEmpID().equals(id)) {
				noSL = i.getShortLeaves();
				if(noSL == 0) {
					System.out.println("No Short Leaves are available!");
					System.out.println("If you still want to take the Leave '1'");
					System.out.println("To exit '2'");
					int aa = sc.nextInt();
					if(aa == 1) {
						Etime = i.getEndTime();
						hours = (int) (Etime - etime);
						if(hours <= 2) {
							System.out.println("Your Leave has been Approved");
							tot = i.getBasicsalary() - 250;
							System.out.println("Rs.250 has been charged for the leave");
							System.out.println("Total Salary : " + tot);
							System.out.println("Since your Daytime is about to over");
							System.out.println("You will be singed off from the system as well");
							signOut(id,stime,etime,leave);
						}
						else {
							System.out.println("Your Leave has been Approved");
							tot = i.getBasicsalary() - 250;
							System.out.println("Rs.250 has been charged for the leave");
							System.out.println("Total Salary : " + tot);
						}
						
					}
					else {
						break;
					}
					
				}
				else {
					Etime = i.getEndTime();
					hours = (int) (Etime - etime);
					if(hours <= 2) {
						System.out.println("Your Leave has been Approved");
						System.out.println("Since your Daytime is about to over");
						System.out.println("You will be singed off from the system as well");
						noSL--;
						System.out.println("Num of Short Leaves Remaining : " + noSL);
						signOut(id,stime,etime,leave);
					}
					else {
						System.out.println("Your Leave has been Approved");
						noSL--;
						System.out.println("Num of Short Leaves Remaining : " + noSL);
					}
				}
			}
		}
		
		
	}



	@Override
	public void hDay(String id, double stime,double etime) {
		// TODO Auto-generated method stub
		int noSL;
		double Etime;
		boolean leave = true;
		int hours;
		double tot;
		for (Attendance i : list) {
			if(i.getEmpID().equals(id)) {
				noSL = i.getHalfDays();
				if(noSL == 0) {
					System.out.println("No Half Day Leaves are available!");
					System.out.println("If you still want to take the Leave '1'");
					System.out.println("To exit '2'");
					int aa = sc.nextInt();
					if(aa == 1) {
						Etime = i.getEndTime();
						hours = (int) (Etime - etime);
						if(hours <= 4) {
							System.out.println("Your Leave has been Approved");
							tot = i.getBasicsalary() - 500;
							System.out.println("Rs.500 has been charged for the leave");
							System.out.println("Total Salary : " + tot);
							System.out.println("Since your Daytime is about to over");
							System.out.println("Num of Half Day Leaves Remaining : " + noSL);
							signOut(id,stime,etime,leave);
						}
						else {
							System.out.println("Your Leave has been Approved");
							tot = i.getBasicsalary() - 500;
							System.out.println("Rs.500 has been charged for the leave");
							System.out.println("Total Salary : " + tot);
						}
						
					}
					else {
						break;
					}
				}
				else {
					Etime = i.getEndTime();
					hours = (int) (Etime - etime);
					if(hours <= 4) {
						System.out.println("Your Leave has been Approved");
						System.out.println("Since your Daytime is about to over");
						System.out.println("You will be singed off from the system as well");
						noSL--;
						System.out.println("Num of Half Day Leaves Remaining : " + noSL);
						signOut(id,stime,etime,leave);
					}
					else {
						System.out.println("Your Leave has been Approved");
						noSL--;
						System.out.println("Num of Half Day Leaves Remaining : " + noSL);
					}
				}
			}
		}
		
	}



	@Override
	public void printOne(String id) {
		// TODO Auto-generated method stub
		for (Attendance i : list) {
			if(i.getEmpID().equals(id)) {
				System.out.println("ID"+"\t"+"Name"+"\t"+"Possition"+"\t"+"Start Time"+"\t"+"End Time"+"\t"+"Basic Salary"+"\t"+"Half Days"+"\t"+"Short Leaves");
				System.out.println(i.getEmpID()+"\t"+i.getEmpName()+"\t"+ i.getPossition()+"\t"+"\t"+i.getStartTime()+"\t"+"\t"+i.getEndTime()+"\t"+"\t"+i.getBasicsalary()+"\t"+"\t"+i.getHalfDays()+"\t"+"\t"+i.getShortLeaves());
			}
		}
		
	}



	@Override
	public void signOut(String id,double stime,double etime,boolean leave) {
		// TODO Auto-generated method stub
		double Etime;
		int hours;
		int extra;
		int OT;
		double tot;
		for (Attendance i : list) {
			if(i.getEmpID().equals(id)) {
				if(leave == true) {
					System.out.println("Singed-Offed Succesfully!");
				}
				else {
					hours =(int)(etime - stime);
					if(hours > 8) {
						extra = hours - 8;
						OT = extra * 100;
						tot = i.getBasicsalary() + OT;
						System.out.println("Since you worked " + extra + " extra hours");
						System.out.println("RS."+ OT +" increment has beeen added to your"
								           + " salary");
						System.out.println("Total Salary : " + tot);
						System.out.println("Singed-Offed Succesfully!");
					}
					else {
						System.out.println("Singed-Offed Succesfully!");
					}
				}
					
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
