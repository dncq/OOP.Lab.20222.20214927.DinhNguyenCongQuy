package hust.soict.dsai.aims.cart;
import java.util.*;

import hust.soict.dsai.aims.media.*;
public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public Media searchID(int ID){ 
		boolean searched = false;
		for (Media medium: itemsOrdered) {
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
		for (Media medium: itemsOrdered) {
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
	
    public void sortByTitle() {
//    	Following code sort the items in itemOrdered in the order with respect to custom logic defined in compare_by_title_cost.
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Media sorted by title and cost:");

    }

    public void sortByCost() {
//    	Following code sort the items in itemOrdered in the order with respect to custom logic defined in compare_by_cost_title.
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Media sorted by cost and title:");

    }
    
    public ArrayList<Media> filterByID(int id) {
        ArrayList<Media> filteredItems = new ArrayList<Media>();
        for (Media media : itemsOrdered) {
            if (media.isMatch(id)) {
                filteredItems.add(media);
            }
        }
        for (Media media: filteredItems) {
        	System.out.println(media.toString());
        }
        return filteredItems;
    }

    public ArrayList<Media> filterByTitle(String title) {
        ArrayList<Media> filteredItems = new ArrayList<Media>();
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                filteredItems.add(media);
            }
        }
        for (Media media: filteredItems) {
        	System.out.println(media.toString());
        }
        return filteredItems;
    }

	public void addMedia(Media media) {
		if(itemsOrdered.contains(media)) {
			System.out.println("Media is already in cart");
		}
		else if(itemsOrdered.size() < MAX_NUMBER_ORDERED) {
			itemsOrdered.add(media);
			System.out.println("Media is added to cart");
		} else System.out.println("Full already");
	}
	public void addMedia(ArrayList<Media> media) {
		for(Media medium: media) {
			if(itemsOrdered.contains(medium)) {
				System.out.println("Media is already in cart");
			}
			else if(itemsOrdered.size() < MAX_NUMBER_ORDERED) {
				itemsOrdered.add(medium);
				System.out.println("Media is added in cart");
			} else System.out.println("Full already");		
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsOrdered.isEmpty()) {
			System.out.println("The cart is empty");
		}
		if(itemsOrdered.contains(media) == false) {
			System.out.println("Media is not in the cart");
		}
		else {
			itemsOrdered.remove(media);
			System.out.println("Media is removed from cart");
		}
	}
	
	 public boolean removeMedia(String mediaName) {
		    for (Media item: itemsOrdered) {
		        if (item.getTitle().equalsIgnoreCase(mediaName)) {
		            itemsOrdered.remove(item);
		            System.out.println("The media item has been removed from the store.");
//		            return true;
		        }
		    }
		    System.out.println("This media item does not exist.");
		    return false;
		}
	public void removeMedia(ArrayList<Media> media) {
		for(Media medium: media) {
			if (itemsOrdered.isEmpty()) {
				System.out.println("The cart is empty");
				break;
			}
			if (itemsOrdered.contains(medium) == false) {
				System.out.println("Media is not in the cart");
			}
			else {
				itemsOrdered.remove(medium);
				System.out.println("Media is removed from cart");
			}
		}
	}
	

	public float totalCost() {
		float totalcost = 0;
		for (Media media: itemsOrdered) {
			totalcost += media.getCost();
		}
		return totalcost;
	}
	
	public int getQtyOrdered() {
		return itemsOrdered.size();
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		int item_no = 0;
		for (Media media: itemsOrdered) {
			item_no++;
			System.out.println(item_no + ". " + media.toString());
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("***************************************************");
	}
	
	
}
