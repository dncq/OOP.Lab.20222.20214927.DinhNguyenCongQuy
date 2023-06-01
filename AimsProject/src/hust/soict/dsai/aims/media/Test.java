package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Test {

	public static void main(String[] args) {
		CompactDisc cd1 = new CompactDisc("asd", "Yellow Music", 19.9f, "Tuan Vu");
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("ADVD","Category", 40.321f, 30, "Director" );
		Book b1 = new Book("Book Title1", "Book Category", 19.99f);
		Book b2 = new Book("Book Title2", "Book Category", 20.00f);
		Book b3 = new Book("Book Title3", "Book Category", 19.99f);
		Book b4 = new Book("Book Title4", "Book Category", 19.99f);
		Track t1 = new Track("dasds", 30);
		Track t2 = new Track("asd", 40);
		Track t3 = new Track("12", 50);
		Track t4 = new Track("ca", 60);
		cd1.addTrack(t1);
		cd1.addTrack(t2);
		cd1.addTrack(t3);
		cd1.addTrack(t4);
		cd1.addTrack(t1);
//		System.out.println(cd1.getTitle());
//		System.out.println(cd1.getLength());
//		cd1.play();
		List <Media> mediae = new ArrayList<Media>();
		mediae.add(cd1);
		mediae.add(dvd1);
		mediae.add(b1);
		mediae.add(b2);
		mediae.add(b3);
		mediae.add(b4);
		Collections.sort(mediae, Media.COMPARE_BY_COST_TITLE);

		for (Media m:mediae) {
			System.out.println(m.toString());
		}
	    
	}

}