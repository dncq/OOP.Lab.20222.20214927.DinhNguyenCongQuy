import java.util.ArrayList;
import java.util.List;
public class Store {
	private List<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();
	public void addDVD(DigitalVideoDisc item) {
		if (itemsInStore.contains(item) == true) {
			System.out.println("The item has been already in store ");
		}else {
			itemsInStore.add(item);
			System.out.println("The item has been added");
		}
	}
	
	public void removeDVD(DigitalVideoDisc item) {
		if (itemsInStore.size() == 0) {
			System.out.println("Don't have item in list");
		}else if(itemsInStore.contains(item) == false){
			System.out.println("The item hasn't been in list");
		}else {
			itemsInStore.remove(item);
			System.out.println("The item has been removed");
		}
	}
	
	public int getQtyAvailableDVD() {
		return itemsInStore.size();
	}
	public void viewStore() {
		for (DigitalVideoDisc dvd : itemsInStore) {
			System.out.println(dvd.toString());;
		}
	}

	public List<DigitalVideoDisc> getItemsInStore() {
		return itemsInStore;
	}
}
