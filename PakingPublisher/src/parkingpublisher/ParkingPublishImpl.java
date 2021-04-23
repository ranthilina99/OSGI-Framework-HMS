package parkingpublisher;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

import classpublisher.ParkingSlots;

public class ParkingPublishImpl implements ParkingPublish {

	ParkingSlots ps1 = new ParkingSlots(1, "Doctor", "Free", LocalTime.of(8, 0), LocalTime.of(13, 0));
	ParkingSlots ps2 = new ParkingSlots(2, "Doctor", "Free", LocalTime.of(8, 0), LocalTime.of(15, 0));
	ParkingSlots ps3 = new ParkingSlots(3, "Doctor", "Free", LocalTime.of(8, 0), LocalTime.of(10, 0));
	ParkingSlots ps4 = new ParkingSlots(4, "Doctor", "Free", LocalTime.of(8, 0), LocalTime.of(10, 0));
	ParkingSlots ps5 = new ParkingSlots(5, "Patient", "Free", 100.0);
	ParkingSlots ps6 = new ParkingSlots(6, "Patient", "Free", 100.0);
	ParkingSlots ps7 = new ParkingSlots(7, "Patient", "Free", 100.0);
	ParkingSlots ps8 = new ParkingSlots(8, "Patient", "Free", 100.0);

	ArrayList<ParkingSlots> list = new ArrayList<ParkingSlots>();

	public ParkingPublishImpl() {
		list.add(ps1);
		list.add(ps2);
		list.add(ps3);
		list.add(ps4);
		list.add(ps5);
		list.add(ps6);
		list.add(ps7);
		list.add(ps8);
	}

	@Override
	public void printAll() {
		
		System.out.println("ID" + "\t\t" + "Type" + "\t\t" + "Status");
		System.out.println();
		for (ParkingSlots i : list) {		
			System.out.println(i.getpNo() + "\t\t" + i.getpType() + "\t\t" + i.getpStatus());
		}

	}

	@Override
	public void printFreeSlots() {

		System.out.println("ID" + "\t\t" + "Type" );
		System.out.println();
		for (ParkingSlots i : list) {
			if (i.getpStatus().equalsIgnoreCase("Free")) {			
				System.out.println(i.getpNo() + "\t\t" + i.getpType());
			}
		}
	}

	@Override
	public void printFreeSlots(String type) {
		
		System.out.println("ID");
		System.out.println();
		for (ParkingSlots i : list) {
			if (i.getpType().equalsIgnoreCase(type.toString())) {
				if (i.getpStatus().equalsIgnoreCase("Free")) {
					
					System.out.println(i.getpNo());
				}
			}
		}

	}

	@Override
	public void calculateAmount(int no, int hours) {
		double total = 0;

		for (ParkingSlots i : list) {

			if (i.getpNo() == no) {

				if (i.getpType().equalsIgnoreCase("Doctor")) {
					System.out.println("Doctor parking is free!!!");
					break;
				} else {

					double amount = i.getpAmount();

					if (hours <= 1) {
						total = amount + (amount * 10);
					} else if (hours <= 2) {
						total = amount + (amount * 20);
					} else {
						total = amount + (amount * 30);
					}
				}

				System.out.println("Total amount will be: " + total);
			}
		}

	}

	@Override
	public void reserveSpot(int no, int hours) {

		Scanner sc = new Scanner(System.in);

		for (ParkingSlots i : list) {

			if (i.getpNo() == no) {

				if (i.getpStatus().equalsIgnoreCase("Occupied")) {

					System.out.println("The spot is allready occupied!!!");
				} else {

					if (i.getpType().equalsIgnoreCase("Doctor")) {

						System.out.println("Enter Password:");
						String pass = sc.next();

						if (pass.equals("1234")) {
							i.setpStatus("Occupied");
							i.setEnd2(LocalTime.now().plus(hours, ChronoUnit.HOURS));
							i.setBook(true);
							System.out.println("Slot no: " + i.getpNo() + " is now occupied for: " + hours + " hours");

						} else {
							System.out.println("Invalid password!!!");
						}
					} else {

						i.setpStatus("Occupied");
						System.out.println("Slot no:" + i.getpNo() + " is now occupied for:" + hours + " hours");
						i.setEnd2(LocalTime.now().plus(hours, ChronoUnit.HOURS));
						calculateAmount(no, hours);
					}

				}

			}
		}

	}

	@Override
	public void StatusUpdate() {

		LocalTime nowTime = LocalTime.now();

		for (ParkingSlots i : list) {

			if (i.getpType().equalsIgnoreCase("Doctor")) {
				
				if (nowTime.isAfter(i.getStart()) && nowTime.isBefore(i.getEnd())) {
					
					i.setpStatus("Occupied");
					i.setEnd2(i.getEnd());

				}else if(i.getBook() == false) {
					i.setpStatus("Free");
				}
			}

		}

	}

	@Override
	public void WhenFree(int id) {
		
		for (ParkingSlots i : list) {
			if(i.getpNo() == id) {
				if(i.getpStatus().equalsIgnoreCase("Occupied")) {
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
					System.out.println("This slot will be free at: "+ i.getEnd2().format(dtf));
				}else {
					System.out.println("This slot is already free!!!");
				}
					
			}
		}
		
	}

}









