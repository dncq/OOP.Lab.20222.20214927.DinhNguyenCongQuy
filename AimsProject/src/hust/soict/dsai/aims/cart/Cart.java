package hust.soict.dsai.aims.cart;
import java.util.*;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private List<DigitalVideoDisc> itemsOrdered = new ArrayList<DigitalVideoDisc>();
	private int qtyOrdered = 0;
	
	public void searchID(int ID){ 
		boolean searched = false;
		for (DigitalVideoDisc dvd: itemsOrdered) {
			if (dvd.getId() == ID) {
				System.out.println("DVD - " + dvd.getDetail());
				searched = true;
				break;
			} 
		} if (searched == false) {
			System.out.println("There is no matching item!");
		}
	}
	public void searchTitle(String title) {
		boolean searched = false;
		for (DigitalVideoDisc dvd: itemsOrdered) {
			if (dvd.getTitle().equals(title)) {
				System.out.println("DVD - " + dvd.getDetail());
				searched = true;
				break;
			} 
		} if (searched == false) {
			System.out.println("There is no matching item!");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (itemsOrdered.contains(disc)) {
			System.out.println("This disc is already in your cart");
		} else if (qtyOrdered >= MAX_NUMBER_ORDERED) {
			System.out.println("The cart is full");
		} else {
			itemsOrdered.add(disc);
			qtyOrdered++;
			System.out.println("The disc has been added");
		}
	}
	
	// Method Overloading with list
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdlist) {
		for (DigitalVideoDisc dvd: dvdlist) {
			if (itemsOrdered.contains(dvd)) {
				System.out.println("The item " + dvd.getTitle() + "has is already in the cart");
			} else if (qtyOrdered >= MAX_NUMBER_ORDERED) {
				System.out.println("The cart is full");
				break;
			} else {
				itemsOrdered.add(dvd);
				qtyOrdered++;
				System.out.println("The item " + dvd.getTitle() + "has been successfully added");
			}
		}
	}
	// Method overloading with arbitrary number of parameters
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc ... dvdlist ) {
		dvdlist[dvdlist.length - 1] = dvd1;
		for (DigitalVideoDisc dvd: dvdlist) {
			if (itemsOrdered.contains(dvd)) {
				System.out.println("The item " + dvd.getTitle() + "has is already in the cart");
			} else if (qtyOrdered >= MAX_NUMBER_ORDERED) {
				System.out.println("The cart is full");
				break;
			} else {
				itemsOrdered.add(dvd);
				qtyOrdered++;
				System.out.println("The item " + dvd.getTitle() + "has been successfully added");
			}
		}
	}
	// Method Overloading with different number of parameters
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		DigitalVideoDisc[] dvdlist = new DigitalVideoDisc[2];
		dvdlist[0] = dvd1;
		dvdlist[1] = dvd2;
		for (int i = 0; i < 2; i++) {
			if (itemsOrdered.contains(dvdlist[i])) {
				System.out.println("The item " + dvdlist[i].getTitle() + " is already in cart!");
			} else if(qtyOrdered >= MAX_NUMBER_ORDERED) {
				System.out.println("The cart is full");
				break;
			} else {
				itemsOrdered.add(dvdlist[i]);
				qtyOrdered++;
				System.out.println("The item " + dvdlist[i].getTitle() + "has been successfully added");
			}
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if (itemsOrdered.contains(disc) == false) {
			System.out.println("This disc is not in your cart");
		} else if (qtyOrdered == 0) {
			System.out.println("The cart is empty");
		} else {
			itemsOrdered.remove(disc);
			qtyOrdered--;
			System.out.println("The disc has been removed");
		}
	}
	public float totalCost() {
		float totalcost = 0;
		for (DigitalVideoDisc disc: itemsOrdered) {
			totalcost += disc.getCost();
		}
		return totalcost;
	}
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		int item_no = 0;
		for (DigitalVideoDisc dvd: itemsOrdered) {
			item_no++;
			System.out.println(item_no + "." + " " + "DVD - " + dvd.getDetail());
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("***************************************************");
	}
	
	
}
