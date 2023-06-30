/*
package hust.soict.dsai.aims.cart;
import java.util.*;

import hust.soict.dsai.aims.media.*;
public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public Media searchID(int ID){ 
		boolean searched = false;
		for (Media medium: itemsOrdered) {
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

*/

// CODE DI CHEP

package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.exception.*;
import hust.soict.dsai.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Cart {
	private static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	
	public void addMedia(Media medium) throws CartFullException {
		if (this.itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
			throw new CartFullException("The cart is full.");
		//In case the cart cannot carry duplicate items
//		} else if (this.itemsOrdered.contains(medium)) {
//			System.out.println(medium.getTitle() + " is already in the cart.");
//			return false;
		} else {
			this.itemsOrdered.add(medium);
			System.out.println(medium.getTitle() + " has beed added to the cart.");
		}
	}
	
	public void removeMedia(Media medium) throws NonExistingItemException {
		if (this.itemsOrdered.remove(medium)) {
			System.out.println(medium.getTitle() + " has been removed from the cart.");
		} else {
			throw new NonExistingItemException(medium.getTitle() + " is not in the cart.");
		}
	}
	
	public float totalCost() {
		float cost = 0.0f;
		for (Media medium: itemsOrdered) {
			cost += medium.getCost();
		}
		return cost;
	}
	
	public void print() {
		System.out.println("\n***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			System.out.println(Integer.toString(i+1) + "." + "\t" + this.itemsOrdered.get(i).getDetails() + "\n");
		}
		System.out.println("Total cost: " + "$" + this.totalCost());
		System.out.println("***************************************************");
		System.out.println("\n");
	}
	
	public boolean filterMedia(int id) {
		boolean found = false;
		int qty = 0;
		float cost = 0f;
		System.out.println("\n******************SEARCH RESULT********************");
		System.out.println("Product ID: " + id);
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (this.itemsOrdered.get(i).getID() == id) {
				System.out.println(Integer.toString(i+1) + "." + "\t" + this.itemsOrdered.get(i).getDetails() + "\n");
				qty += 1;
				cost = this.itemsOrdered.get(i).getCost();
				found = true;
			}
		}
		if (found) {
			System.out.println("Total number of product " + id + " found: " + qty);
			System.out.println("Total cost for these product: " + "$" + (cost*qty));
			System.out.println("***************************************************");
			System.out.println("\n");
			return true;
		} else {
			System.out.println("Such product is not in the cart");
			System.out.println("***************************************************");
			System.out.println("\n");
			return false;
		}
	}
	
	public boolean filterMedia(String title) {
		boolean found = false;
		int qty = 0;
		float cost = 0f;
		System.out.println("\n******************SEARCH RESULT********************");
		System.out.println("Product title: " + title);
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (this.itemsOrdered.get(i).search(title)) {
				System.out.println(Integer.toString(i+1) + "." + "\t" + this.itemsOrdered.get(i).getDetails() + "\n");
				qty += 1;
				cost = this.itemsOrdered.get(i).getCost();
				found = true;
			}
		}
		if (found) {
			System.out.println("Total number of product " + title + " found: " + qty);
			System.out.println("Total cost for these product: " + "$" + (cost*qty));
			System.out.println("***************************************************");
			System.out.println("\n");
			return true;
		} else {
			System.out.println("Such product is not in the cart");
			System.out.println("***************************************************");
			System.out.println("\n");
			return false;
		}
	}
	
	public Media searchMedia(String title) {
		for (Media medium: this.itemsOrdered) {
			if (medium.getTitle().toLowerCase().equals(title.toLowerCase())) {
				return medium;
			}
		}
		return null;
	}
	
	public void sortByTitle() {
		FXCollections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}
	
	public void sortByCost() {
		FXCollections.sort(this.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}
	
	public int getSize() {
		return this.itemsOrdered.size();
	}
	
	public ObservableList<Media> getItemsOrdered() {
		return this.itemsOrdered;
	}
	
	public void empty() {
		this.itemsOrdered.clear();
	}
}
 
 
 



