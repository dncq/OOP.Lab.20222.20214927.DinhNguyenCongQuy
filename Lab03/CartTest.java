
public class CartTest {

	public static void main(String[] args) {
		// Create a new cart
		Cart cart = new Cart();
		// Create new dvd onjects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Cinderella", "Live Action", "Andersen", 90, 18.95f);
		cart.addDigitalVideoDisc(dvd3);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd4);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Sugar Daddy");
		cart.addDigitalVideoDisc(dvd5);
		
		//Test the print method
		cart.print();
		
		//Test the seatchTitle method
		cart.searchTitle("Star Wars");
		cart.searchTitle("LUL");
		
		//Test the searchID method
		cart.searchID(241360);
		cart.searchID(123456);
		cart.searchID(1234567);
//		System.out.println(dvd1.getID());
//		System.out.println(dvd2.getID());
//		System.out.println(dvd3.getID());
//		System.out.println(dvd4.getID());
//		System.out.println(dvd5.getID());
	}
}
