package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		//Create a new store
		Store myStore = new Store();
		System.out.println("Number of dvd is: " + myStore.getQtyAvailableDVD());
			
		//Create new DVD objects and add them to the store
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		myStore.addDVD(dvd1);
		System.out.println("Number of dvd is: " +myStore.getQtyAvailableDVD());
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		myStore.addDVD(dvd2);
		System.out.println("Number of dvd is: " +myStore.getQtyAvailableDVD());
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		myStore.addDVD(dvd3);
		System.out.println("Number of dvd is: " +myStore.getQtyAvailableDVD());
		
		//delete DVD from the store
		myStore.removeDVD(dvd3);
		System.out.println("Number of dvd is: " +myStore.getQtyAvailableDVD());
				
		myStore.removeDVD(dvd2);
		System.out.println("Number of dvd is: " +myStore.getQtyAvailableDVD());
				
		myStore.removeDVD(dvd1);
		System.out.println("Number of dvd is: " +myStore.getQtyAvailableDVD());
	}
}
