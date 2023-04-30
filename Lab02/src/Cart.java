import java.util.ArrayList;
import java.util.List;
public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private List<DigitalVideoDisc> itemsOrdered = new ArrayList<DigitalVideoDisc>();
	private int qtyOrdered = 0;
	
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
	
	
	
}
