package hust.soict.dsai.aims.store;
import java.util.*;

import hust.soict.dsai.aims.media.*;
public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
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
			if (medium.getId() == ID) {
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
