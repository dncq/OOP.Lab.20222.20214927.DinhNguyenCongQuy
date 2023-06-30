package hust.soict.dsai.aims;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
/*
public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    
    public static void main(String[] args) {
        showMenu();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
// If user chooses option 0, they will not enter switch case but process to the next code
// If user chooses option not 0 and not valid, they will enter default case of switch case
// If user choose an option not 0 and valid, they will get to the code of corresponding method.
// All while and switch case methods in this Aims project are designed this structure.
        while (choice != 0) {
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    viewCart();
                    break;
 
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        }
        
        System.out.println("Goodbye!");
        scanner.close();
    }
    
    public static void showMenu() {
        System.out.println("AIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
 
 
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }
    
    public static void viewStore() {
    	store.view();
        storeMenu();
        
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        while (choice != 0) {
            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    viewCart();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        }
    }
    
    public static void storeMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }
    
    public static void seeMediaDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        
        Media media = store.searchTitle(title);;
        if (media != null) {
            System.out.println(media.toString());
            mediaDetailsMenu();
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            while (choice != 0) {
                switch (choice) {
                    case 1:
                        cart.addMedia(media);
                        System.out.println("The media has been added to the cart.");
                        break;
                    case 2:
                        if (media instanceof Playable) {
                            ((Playable) media).play();
                        } else {
                            System.out.println("This media is not playable.");
                        }
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
                
                mediaDetailsMenu();
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
            }
        } else {
            System.out.println("Media not found.");
        }
    }
    
    public static void mediaDetailsMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }
    
    public static void addMediaToCart() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        
        Media media = store.searchTitle(title);
        if (media != null) {
            cart.addMedia(media);


            System.out.println("The media has been added to the cart.");

        } else {
            System.out.println("Media not found.");
        }
    }
    
    public static void playMedia() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        
        Media media = store.searchTitle(title);
        if (media != null) {
            if (media instanceof Playable) {
                ((Playable) media).play();
            } else {
                System.out.println("This media is not playable.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }
    
    public static void updateStore() {
        updateStoreMenu();
        
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        while (choice != 0) {
            switch (choice) {
                case 1:
                    addMedia();
                    break;
                case 2:
                    removeMedia();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            
            updateStoreMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        }
    }
    
    public static void updateStoreMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media");
        System.out.println("2. Remove a media");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }
    
    public static void addMedia() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of media:");
        System.out.println("1. Book");
        System.out.println("2. CD");
        System.out.println("3. DVD");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        System.out.print("Enter the category of the media: ");
        String category = scanner.nextLine();
        System.out.print("Enter the cost of the media: ");
        float cost = scanner.nextFloat();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter the ID of the media: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Media media = null;
        switch (choice) {
        	case 1:
            // Add book
            System.out.print("Enter the author of the book (separated by commas): ");
            String authorInput = scanner.nextLine();
            
            List<String> authors = Arrays.asList(authorInput.split(","));

            media = new Book(title, category, cost, authors);
            break;
            case 2:
                // Add CD
                System.out.print("Enter the artist of the CD: ");
                String artist = scanner.nextLine();
                System.out.print("Enter the number of tracks on the CD: ");
                int numberOfTracks = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                media = new CompactDisc(title, category, cost);
                break;
            case 3:
                // Add DVD
                System.out.print("Enter the director of the DVD: ");
                String director = scanner.nextLine();
                System.out.print("Enter the length of the DVD in minutes: ");
                int length = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                media = new DigitalVideoDisc(title, category, cost, length, director);
                break;
            default:
                System.out.println("Invalid choice. Media not added to the store.");
                return;
        }
        
        store.addMedia(media);

    }
    
    public static void removeMedia() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        
        boolean removed = store.removeMedia(title);
        if (removed) {
            System.out.println("The media has been removed from the store.");
        } else {
            System.out.println("Media not found in the store.");
        }
    }
    
    public static void viewCart() {
    	cart.print();
        cartMenu();
        
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        while (choice != 0) {
            switch (choice) {
                case 1:
                    filterMedias();
                    break;
                case 2:
                    sortMedias();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMediaFromCart();
                    break;
                case 5:
                    placeOrder();
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        }
    }
    
    public static void cartMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }
    
    public static void filterMedias() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a filtering option:");
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by title");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        if (choice == 1) {
            System.out.print("Enter the ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            cart.filterByID(id);
        } else if (choice == 2) {
            System.out.print("Enter the title: ");
            String title = scanner.nextLine();
            cart.filterByTitle(title);
        } else {
            System.out.println("Invalid choice.");
        }
    }
    
    public static void sortMedias() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a sorting option:");
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        if (choice == 1) {
            cart.sortByTitle();
        } else if (choice == 2) {
            cart.sortByCost();
        } else {
            System.out.println("Invalid choice.");
        }
        cart.print();
    }
    
    public static void removeMediaFromCart() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        
        boolean removed = cart.removeMedia(title);
        if (removed) {
            System.out.println("The media has been removed from the cart.");
        } else {
            System.out.println("Media not found in the cart.");
        }
    }

    
    public static void playMediaFromCart() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        
        Media media = cart.searchTitle(title);
        if (media != null) {
            if (media instanceof Playable) {
                ((Playable) media).play();
            } else {
                System.out.println("This media is not playable.");
            }
        } else {
            System.out.println("Media not found in the cart.");
        }
    }
    
    public static void placeOrder() {
        System.out.println("Order created.");
    }
}
*/


// COde di chep
/*
package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.*;
import java.util.Scanner;

//Note: You will notice that I put a scan.nextLine() after every scan.nextInt()
//  		that is because scan.nextInt() doesn't read the newline in your input by
//  		hitting "Enter". So the next scan.nextLine() will read that newline imediately
//  		without you inputing anything, which is unfortunenate.
// 

public class Aims {
	private static Store store = new Store();
	private static Cart cart = new Cart();
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		
		//Add stuff to the store
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		Track track1 = new Track("Bruh1", 13);
		Track track2 = new Track("Bruh2", 21);
		CompactDisc cd1 = new CompactDisc("Allstars", "Yes", "Smash Mouth", "Dunno", 69.420f);
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		Book book1 = new Book("Sherlock Holmes", "Detective", 420, 5f);
		book1.addAuthor("Conan Doyle");
		book1.addAuthor("JK Rolling");
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		store.addMedia(cd1);
		store.addMedia(book1);
		
		//The program starts here
		fakeClearScreen();
		showMenu();
		//The program ends here I suppose
	}
	
	
	public static void showMenu() throws Exception {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		
		int choice = scan.nextInt();
		scan.nextLine();
		
		//Invalid input
		while (choice != 0 && choice != 1 && choice != 2 && choice != 3) {
			System.out.println("Please choose a valid number.");
			choice = scan.nextInt();
			scan.nextLine();
		}
		
		//View store
		if (choice == 1) {
			fakeClearScreen();
			storeMenu();
		}
		
		//Update store
		else if (choice == 2) {
			fakeClearScreen();
			updateStoreMenu();
		} 
		
		//See current cart
		else if (choice == 3) {
			fakeClearScreen();
			cartMenu();
		} 
		
		//Exit
		else if (choice == 0) {
			fakeClearScreen();
			System.out.println("Thank you for using our service. We hope to see you again.");
			System.exit(0);
		}
	}
	
	
	public static void storeMenu() throws Exception {
		store.print();
		
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media�s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		
		int choice = scan.nextInt();
		scan.nextLine();
		
		//Invalid input
		while (choice != 0 && choice != 1 && choice != 2 && choice != 3 && choice != 4) {
			System.out.println("Please choose a valid number.");
			choice = scan.nextInt();
			scan.nextLine();
		}
		
		//Exit
		if (choice == 0) {
			fakeClearScreen();
			showMenu();
		} 
		
		//See a media�s details
		else if (choice == 1) {
			System.out.println("Please enter the title of the media you want to see details of: ");
			String title = scan.nextLine();
			Media medium = store.searchMedia(title);
			//Invalid name
			while (medium == null) {
				System.out.println("Please enter a valid product name.");
				title = scan.nextLine();
				medium = store.searchMedia(title);
			}
			fakeClearScreen();
			seeMediaMenu(medium);
		}
		
		//Add a media to cart
		else if (choice == 2) {
			System.out.println("Please enter the title of the media you want to add to cart: ");
			String title = scan.nextLine();
			Media medium = store.searchMedia(title);
			
			//Invalid name
			while (medium == null) {
				System.out.println("Please enter a valid product name.");
				title = scan.nextLine();
				medium = store.searchMedia(title);
			}
			
			cart.addMedia(medium);
			System.out.println("Total number of media in cart: " + cart.getSize());	//DVDs?
			System.out.println("Enter any key to continue");
			scan.nextLine();
			fakeClearScreen();
			storeMenu();
		}
		
		//Play a media
		else if (choice == 3) {
			System.out.println("Please enter the title of the media you want to play: ");
			String title = scan.nextLine();
			Media medium = store.searchMedia(title);
			
			//Invalid name
			while (!(medium instanceof Disc)) {
				System.out.println("Please enter a valid product name.");
				title = scan.nextLine();
				medium = store.searchMedia(title);
			}
			Disc med = (Disc) medium;
			med.play();
			System.out.println("Enter any key to continue");
			scan.nextLine();
			fakeClearScreen();
			storeMenu();
		}
		
		//See current cart
		else if (choice == 4) {
			fakeClearScreen();
			cartMenu();
		}
	}
	
	
	public static void cartMenu() throws Exception {
		cart.print();
		
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
		
		int choice = scan.nextInt();
		scan.nextLine();
		
		//Invalid input
		while (choice != 0 && choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
			System.out.println("Please choose a valid number.");
			choice = scan.nextInt();
			scan.nextLine();
		}
		
		//Exit
		if (choice == 0) {
			fakeClearScreen();
			showMenu();
		}
		
		//Filter media
		else if (choice == 1) {
			fakeClearScreen();
			filterCartMenu();
		}
		
		//Sort media
		else if (choice == 2) {
			fakeClearScreen();
			sortCartMenu();
		}
		
		//Remove media from cart
		else if (choice == 3) {
			System.out.println("Please enter the title of the media you want to remove: ");
			String title = scan.nextLine();
			Media medium = store.searchMedia(title);
			//Invalid name
			while (medium == null) {
				System.out.println("Please enter a valid product name.");
				title = scan.nextLine();
				medium = cart.searchMedia(title);
			}
			cart.removeMedia(medium);
			System.out.println("Media removed. Enter any key to continue");
			scan.nextLine();
			fakeClearScreen();
			cartMenu();
		}
		
		//Play media
		else if (choice == 4) {
			System.out.println("Please enter the title of the media you want to play: ");
			String title = scan.nextLine();
			Media medium = store.searchMedia(title);
			
			//Invalid name
			while (!(medium instanceof Disc)) {
				System.out.println("Please enter a valid product name.");
				title = scan.nextLine();
				medium = cart.searchMedia(title);
			}
			Disc med = (Disc) medium;
			med.play();
			System.out.println("Enter any key to continue");
			scan.nextLine();
			fakeClearScreen();
			cartMenu();
		}
		
		//Place order
		else if (choice == 5) {
			if (cart.getSize() == 0) {
				fakeClearScreen();
				System.out.println("You cannot place an empty order\n");
				cartMenu();
			} else {
				cart = new Cart();
				fakeClearScreen();
				System.out.println("Your order has been placed\n");
				showMenu();
			}
		}
	}

	
	public static void updateStoreMenu() throws Exception {
		store.print();
		
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add media to the store");
		System.out.println("2. Remove media from the store");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		
		int choice = scan.nextInt();
		scan.nextLine();
		
		//Invalid input
		while (choice != 0 && choice != 1 && choice != 2) {
			System.out.println("Please choose a valid number.");
			choice = scan.nextInt();
			scan.nextLine();
		}
		
		//Exit
		if (choice == 0) {
			fakeClearScreen();
			showMenu();
		}
		
		//Add media
		else if (choice == 1) {
			fakeClearScreen();
			addToStoreMenu();
		}
		
		//Remove media
		else if (choice == 2) {
			fakeClearScreen();
			removeFromStoreMenu();
		}
	}
	
	
	public static void filterCartMenu() throws Exception {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter by ID");
		System.out.println("2. Filter by title");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		
		int choice = scan.nextInt();
		scan.nextLine();
		
		//Invalid input
		while (choice != 0 && choice != 1 && choice != 2) {
			System.out.println("Please choose a valid number.");
			choice = scan.nextInt();
			scan.nextLine();
		}
		
		//Exit
		if (choice == 0) {
			fakeClearScreen();
			cartMenu();
		}
		
		//ID
		else if (choice == 1) {
			System.out.println("Please enter ID number");
			choice = scan.nextInt();
			scan.nextLine();
			fakeClearScreen();
			cart.filterMedia(choice);
			System.out.println("Enter any key to continue");
			scan.nextLine();
			fakeClearScreen();
			cartMenu();
		}
		
		else if (choice == 2) {
			System.out.println("Please enter keyword");
			String keyword = scan.nextLine();
			fakeClearScreen();
			cart.filterMedia(keyword);
			System.out.println("Enter any key to continue");
			scan.nextLine();
			fakeClearScreen();
			cartMenu();
		}
	}
	
	
	public static void sortCartMenu() throws Exception {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Sort by title");
		System.out.println("2. Sort by cost");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		
		int choice = scan.nextInt();
		scan.nextLine();
		
		//Invalid input
		while (choice != 0 && choice != 1 && choice != 2) {
			System.out.println("Please choose a valid number.");
			choice = scan.nextInt();
			scan.nextLine();
		}
		
		//Exit
		if (choice == 0) {
			fakeClearScreen();
			cartMenu();
		}
		
		//By title
		else if (choice == 1) {
			fakeClearScreen();
			cart.sortByTitle();
			System.out.println("Your cart has been sorted by title\n");
			cart.print();
			System.out.println("Enter any key to continue");
			scan.nextLine();
			fakeClearScreen();
			cartMenu();
		}
		
		//By cost
		else if (choice == 1) {
			fakeClearScreen();
			cart.sortByCost();
			System.out.println("Your cart has been sorted by cost\n");
			cart.print();
			System.out.println("Enter any key to continue");
			scan.nextLine();
			fakeClearScreen();
			cartMenu();
		}
	}
	
	
	public static void seeMediaMenu(Media medium) throws Exception {
		//Book
		if (medium instanceof Book) {
			fakeClearScreen();
			System.out.println("\t" + medium.getDetails());
			System.out.println("\tDate added: " + medium.getDateAdded());
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add this product to cart");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1");
			int choice = scan.nextInt();
			scan.nextLine();
			while (choice != 0 && choice != 1) {
				System.out.println("Please enter a valid number.");
				choice = scan.nextInt();
				scan.nextLine();
			}
			if (choice == 1) {
				cart.addMedia((Book) medium);
				System.out.println("Enter any key to continue");
				scan.nextLine();
				fakeClearScreen();
				storeMenu();
			} else if (choice == 0) {
				fakeClearScreen();
				storeMenu();
			}
		}
		
		//CD or DVD
		else if (medium instanceof Disc) {
			fakeClearScreen();
			System.out.println("\t" + medium.getDetails());
			System.out.println("\tDate added: " + medium.getDateAdded());
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add this product to cart");
			System.out.println("2. Play this media");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
			int choice = scan.nextInt();
			scan.nextLine();
			while (choice != 0 && choice != 1 && choice != 2) {
				System.out.println("Please enter a valid number.");
				choice = scan.nextInt();
				scan.nextLine();
			}
			if (choice == 1) {
				cart.addMedia((Disc) medium);
				System.out.println("Enter any key to continue");
				scan.nextLine();
				fakeClearScreen();
				storeMenu();
			} else if (choice == 2) {
				fakeClearScreen();
				System.out.println("\t" + medium.getDetails());
				System.out.println("\tDate added: " + medium.getDateAdded());
				Disc med = (Disc) medium;
				System.out.println();
				med.play();
				System.out.println();
				System.out.println("Options: ");
				System.out.println("--------------------------------");
				System.out.println("1. Add this product to cart");
				System.out.println("0. Exit");
				System.out.println("--------------------------------");
				System.out.println("Please choose a number: 0-1");
				choice = scan.nextInt();
				scan.nextLine();
				while (choice != 0 && choice != 1) {
					System.out.println("Please enter a valid number.");
					choice = scan.nextInt();
					scan.nextLine();
				}
				if (choice == 1) {
					cart.addMedia(med);
					System.out.println("Enter any key to continue");
					scan.nextLine();
					fakeClearScreen();
					storeMenu();
				} else if (choice == 0) {
					fakeClearScreen();
					storeMenu();
				}
			} else if (choice == 0) {
				fakeClearScreen();
				storeMenu();
			} 
		}
	}
	
	
	public static void addToStoreMenu() throws Exception {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a new CD to the store");
		System.out.println("2. Add a new DVD to the store");
		System.out.println("3. Add a new book to the store");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		
		int choice = scan.nextInt();
		scan.nextLine();
		
		//Invalid input
		while (choice != 0 && choice != 1 && choice != 2 && choice != 3) {
			System.out.println("Please choose a valid number.");
			choice = scan.nextInt();
			scan.nextLine();
		}
		
		//Exit
		if (choice == 0) {
			fakeClearScreen();
			updateStoreMenu();
		}
		
		//CD
		else if (choice == 1) {
			System.out.println("Please enter the information of the new CD");
			System.out.println("Title: ");
			String title = scan.nextLine();
			System.out.println("Category: ");
			String category = scan.nextLine();
			System.out.println("Artist: ");
			String artist = scan.nextLine();
			System.out.println("Director: ");
			String director = scan.nextLine();
			System.out.println("Price: ");
			float price = Float.parseFloat(scan.nextLine());
			store.addMedia(new CompactDisc(title, category, artist, director, price));
			System.out.println("CD added. Enter any key to continue");
			scan.nextLine();
			fakeClearScreen();
			updateStoreMenu();
		}
		
		//DVD
		else if (choice == 2) {
			System.out.println("Please enter the information of the new DVD");
			System.out.println("Title: ");
			String title = scan.nextLine();
			System.out.println("Category: ");
			String category = scan.nextLine();
			System.out.println("Director: ");
			String director = scan.nextLine();
			System.out.println("Length: ");
			int length = scan.nextInt();
			scan.nextLine();
			System.out.println("Price: ");
			float price = Float.parseFloat(scan.nextLine());
			store.addMedia(new DigitalVideoDisc(title, category, director, length, price));
			System.out.println("DVD added. Enter any key to continue");
			scan.nextLine();
			fakeClearScreen();
			updateStoreMenu();
		}
		
		//Book
		else if (choice == 3) {
			System.out.println("Please enter the information of the new book");
			System.out.println("Title: ");
			String title = scan.nextLine();
			System.out.println("Category: ");
			String category = scan.nextLine();
			System.out.println("Number of pages: ");
			int length = scan.nextInt();
			scan.nextLine();
			System.out.println("Price: ");
			float price = Float.parseFloat(scan.nextLine());
			store.addMedia(new Book(title, category, length, price));
			System.out.println("Book added. Enter any key to continue");
			scan.nextLine();
			fakeClearScreen();
			updateStoreMenu();
		}
	}
	
	
	public static void removeFromStoreMenu() throws Exception {
		store.print();
		
		System.out.println("Please enter the title of the media you want to remove: ");
		String title = scan.nextLine();
		Media medium = store.searchMedia(title);
		//Invalid name
		while (medium == null) {
			System.out.println("Please enter a valid product name.");
			title = scan.nextLine();
			medium = store.searchMedia(title);
		}
		store.removeMedia(medium);
		System.out.println("Enter any key to continue");
		scan.nextLine();
		fakeClearScreen();
		updateStoreMenu();
	}
	
	
	public static void fakeClearScreen() {
		//Print many empty rows to fake screen clearing
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
}
*/