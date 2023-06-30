/*
package hust.soict.dsai.aims.store;
import java.util.*;

import hust.soict.dsai.aims.media.*;
public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public ArrayList<Media> getItemsInStore(){
		return itemsInStore;
	}
	
	public void addMedia(Media media) {
		if (itemsInStore.contains(media) == true) {
			System.out.println("The item has been already in store");
		}else {
			itemsInStore.add(media);
			System.out.println("The item has been added");
		}
	}
	
	public void addMedia(ArrayList<Media> media) {
		for (Media medium: media) {
			if (itemsInStore.contains(medium) == true) {
				System.out.println("The item has been already in store");
			}else {
				itemsInStore.add(medium);
				System.out.println("The item has been added to store");
			}
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsInStore.size() == 0) {
			System.out.println("The store is empty");
		}else if(itemsInStore.contains(media) == false){
			System.out.println("The item isn't in the store");
		}else {
			itemsInStore.remove(media);
			System.out.println("The item has been removed");
		}
	}
	
	public void removeMedia(ArrayList<Media> media) {
		for (Media medium: media) {
			if (itemsInStore.size() == 0) {
				System.out.println("The store is empty");
				break;
			}else if(itemsInStore.contains(medium) == false){
				System.out.println("The item isn't in the store");
			}else {
				itemsInStore.remove(medium);
				System.out.println("The item has been removed");
			}
		}
	}
	
	 public boolean removeMedia(String mediaName) {
		    for (Media item: itemsInStore) {
		        if (item.getTitle().equalsIgnoreCase(mediaName)) {
		            itemsInStore.remove(item);
		            System.out.println("The media item has been removed from the store.");
//		            return true;
		        }
		    }
		    System.out.println("This media item does not exist.");
		    return false;
		}
	 
	public Media searchID(int ID){ 
		boolean searched = false;
		for (Media medium: itemsInStore) {
			if (medium.getID() == ID) {
				System.out.println(medium.toString());
				searched = true;
				return medium;
			} 
		}if (searched == false) {
			System.out.println("There is no matching item!");
		}
		return null;
	}
	public Media searchTitle(String title) {
		boolean searched = false;
		for (Media medium: itemsInStore) {
			if (medium.getTitle().equals(title)) {
				System.out.println(medium.toString());
				searched = true;
				return medium;
			} 
		} if (searched == false) {
			System.out.println("There is no matching item!");
		}
		return null;
	}
	
	public int getQtyAvailableDVD() {
		return itemsInStore.size();
	}
	public void view() {
		System.out.println("***********************STORE***********************");
		System.out.println("Items in store:");
		int item_no = 0;
		for (Media media : itemsInStore) {
			item_no++;
			System.out.println(item_no + ". " + media.toString());;
		}
		System.out.println("***************************************************");
	}

}
*/

// CODE DI CHEP

package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.*;
import hust.soict.dsai.aims.media.*;
import java.time.LocalDate;

public class Store {
	private List<Media> itemsInStore = new ArrayList<Media>();

	public void addMedia(Media medium) throws DuplicatedItemException {
		if (this.itemsInStore.contains(medium) || medium.getTitle() == null) {
			throw new DuplicatedItemException();
		} else {
			medium.setDateAdded(LocalDate.now());
			this.itemsInStore.add(medium);
			System.out.println(medium.getTitle() + " has been added to the store.");
		}
	}
	
	public void removeMedia(Media medium) throws NonExistingItemException {
		if (this.itemsInStore.remove(medium)) {
			System.out.println(medium.getTitle() + " has been removed from the store.");
		} else {
			throw new NonExistingItemException(medium.getTitle() + " is not available at the store.");
		}
	}
	
	public Media searchMedia(String title) {
		for (Media medium: this.itemsInStore) {
			if (medium.getTitle().toLowerCase().equals(title.toLowerCase())) {
				return medium;
			}
		}
		return null;
	}
	
	public void print() {
		System.out.println("\n");
		System.out.println("*************AVAILABLE MEDIA IN STORE**************");
		for (int i = 0; i < itemsInStore.size(); i++) {
			System.out.println(Integer.toString(i+1) + "." + "\t" + this.itemsInStore.get(i).getTitle() + "\t-\t" + this.itemsInStore.get(i).getType());
		}
		System.out.println("***************************************************");
		System.out.println("\n");
	}
	
	public ArrayList<Media> getItemsInStore() {
		return (ArrayList<Media>) this.itemsInStore;
	}
}
