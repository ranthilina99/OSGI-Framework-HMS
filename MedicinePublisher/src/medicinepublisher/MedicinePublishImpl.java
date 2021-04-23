package medicinepublisher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import classpublisher.Medicine;

public class MedicinePublishImpl implements MedicinePublish {

	Medicine M1 = new Medicine(1, "Ativan", "Tablet", 50.00, LocalDate.of(2021, 12, 5), 120);
	Medicine M2 = new Medicine(2, "Lotion", "Liquid", 150.00, LocalDate.of(2022, 4, 15), 350);
	Medicine M3 = new Medicine(3, "Abbott", "Liquid", 300.00, LocalDate.of(2021, 5, 12), 500);
	Medicine M4 = new Medicine(4, "Melamet", "Cream", 320.00, LocalDate.of(2021, 8, 17), 200);
	Medicine M5 = new Medicine(5, "Lyrica", "Tablet", 75.00, LocalDate.of(2021, 9, 4), 100);
	Medicine M6 = new Medicine(6, "Roop", "Cream", 450.00, LocalDate.of(2022, 12, 5), 120);
	Medicine M7 = new Medicine(7, "Pfizer", "Liquid", 55.00, LocalDate.of(2021, 4, 18), 350);
	Medicine M8 = new Medicine(8, "Lupin", "Liquid", 190.00, LocalDate.of(2021, 4, 12), 500);
	Medicine M9 = new Medicine(9, "Medisa", "Cream", 250.00, LocalDate.of(2022, 8, 17), 200);
	Medicine M10 = new Medicine(10, "Otezla", "Tablet", 25.00, LocalDate.of(2021, 6, 15), 100);

	ArrayList<Medicine> medicine = new ArrayList<Medicine>();

	public MedicinePublishImpl() {
		medicine.add(M1);
		medicine.add(M2);
		medicine.add(M3);
		medicine.add(M4);
		medicine.add(M5);
		medicine.add(M6);
		medicine.add(M7);
		medicine.add(M8);
		medicine.add(M9);
		medicine.add(M10);

	}

	@Override
	public void printAll() {
		System.out.println(
				"MID" + "\t" + "Medicine Name" + "\t" + "Medicine Amount" + "\t" + "Expire Date" + "\t" + "Quentity");
		for (Medicine i : medicine) {
			System.out.println(i.getMID() + " \t" + i.getMName() + "\t\t\t" + i.getMAmount() + "\t" + i.getExDate()
					+ "\t" + i.getCount());
		}
	}

	@Override
	public void printAll(String Type) {

		System.out.println(
				"MID" + "\t" + "Medicine Name" + "\t" + "Medicine Amount" + "\t" + "Expire Date" + "\t" + "Quentity");

		for (Medicine i : medicine) {
			if (i.getMType().equalsIgnoreCase(Type.toString())) {
				if (Type.equals("Tablet")) {
					System.out.println(i.getMID() + " \t" + i.getMName() + "\t\t\t" + i.getMAmount() + "\t"
							+ i.getExDate() + "\t" + i.getCount());

				} else if (Type.equals("Liquid")) {
					System.out.println(i.getMID() + " \t" + i.getMName() + "\t\t\t" + i.getMAmount() + "\t"
							+ i.getExDate() + "\t" + i.getCount());

				} else if (Type.equals("Cream")) {
					System.out.println(i.getMID() + " \t" + i.getMName() + "\t\t\t" + i.getMAmount() + "\t"
							+ i.getExDate() + "\t" + i.getCount());
				}
			}
		}
	}

	@Override
	public void printAllmedicineQuantity() {

		for (Medicine i : medicine) {
			System.out.println(i.getMName() + "\t" + i.getCount());
		}

	}

	@Override
	public void findmedicineName(String Type) {
		for (Medicine i : medicine) {

			if (i.getMType().equals(Type.toString())) {
				if (Type.equals("Tablet")) {

					System.out.println(i.getMName());

				} else if (Type.equals("Liquid")) {

					System.out.println(i.getMName());

				} else if (Type.equals("Cream")) {

					System.out.println(i.getMName());

				}
			}
		}
	}

	@Override
	public void printMedicineQuantity(String Mtype, String MName) {

		for (Medicine i : medicine) {
			if (i.getMType().equals(Mtype.toString())) {
				if (Mtype.equals("Tablet")) {

					if (i.getMName().equals(MName.toString())) {

						System.out.println("Tablet Name : " + i.getMName() + "\t" + " count is " + i.getCount());
					}
				} else if (Mtype.equals("Liquid")) {

					if (i.getMName().equals(MName.toString())) {

						System.out.println("Liquid Name : " + i.getMName() + "\t" + " ml is " + i.getCount());
					}

				} else if (Mtype.equals("Cream")) {

					if (i.getMName().equals(MName.toString())) {

						System.out.println("Cream Name : " + i.getMName() + "\t" + " count is " + i.getCount());
					}
				}
			}
		}
	}

	@Override
	public void calculateAmount(String type, String name, int no) {

		double total = 0;
		for (Medicine i : medicine) {
			if (i.getMType().equals(type.toString())) {
				if (type.equals("Tablet")) {

					if (i.getMName().equals(name.toString())) {

						total = i.getMAmount() * no;

						System.out.println("Total price of tablet is :" + total);
					}
				} else if (type.equals("Liquid")) {

					if (i.getMName().equals(name.toString())) {

						total = i.getMAmount() * no;

						System.out.println("Total price of liquid is :" + total);
					}

				} else if (type.equals("Cream")) {

					if (i.getMName().equals(name.toString())) {

						total = i.getMAmount() * no;

						System.out.println("Total price of cream pack is :" + total);
					}
				}
			}
		}
	}

	@Override
	public void medicineExpired() {
		System.out.println("Expire details of medicine");
		System.out.println();
		LocalDate today = LocalDate.now();

		for (Medicine i : medicine) {
			if (today.getYear() == i.getExDate().getYear() && today.getMonth() == i.getExDate().getMonth()) {
				int result = i.getExDate().compareTo(today);

				if (result > 0 && result <= 10) {
					System.out.println(
							"WARNING :" + i.getMName() + " Medicine product is " + result + " days expired !!!");
				} else if (result <= 0) {
					System.out.println("WARNING :" + i.getMName() + " Medicine product is expired !!!");
				}
			}
		}
	}

	@Override
	public void findmedicineNameExpired(String MName) {
		LocalDate today = LocalDate.now();

		for (Medicine i : medicine) {
			if (i.getMName().equals(MName.toString())) {
				if (today.getYear() == i.getExDate().getYear()) {

					int result = i.getExDate().compareTo(today);
					int month = i.getExDate().getMonth().compareTo(today.getMonth());
					System.out.println(i.getMName() + " Medicine product is " + month + " months and " + result
							+ " days expired !!!");

				} else if (today.getYear() >= i.getExDate().getYear()) {
					System.out.println("WARNING :" + i.getMName() + " Medicine product is expired !!!");
				} else {
					System.out.println("This product is not available this year ");

				}
			}
		}
	}
}