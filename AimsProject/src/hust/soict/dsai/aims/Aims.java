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