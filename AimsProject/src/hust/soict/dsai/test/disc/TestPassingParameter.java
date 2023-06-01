package hust.soict.dsai.test.disc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

class DVDWrapper{
	DigitalVideoDisc dvd;
	DVDWrapper(DigitalVideoDisc dvd){
		this.dvd = dvd;
	}
}

//public class TestPassingParameter {
//	public static void main(String[] args) {
//		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
//		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
//		DVDWrapper dvd1 = new DVDWrapper(jungleDVD);
//		DVDWrapper dvd2 = new DVDWrapper(cinderellaDVD);
//		System.out.println("Jungle dvd title: " + dvd1.dvd.getTitle());
//		System.out.println("Cinderella dvd title: " + dvd2.dvd.getTitle());
//		swap(dvd1, dvd2);
//		System.out.println("Jungle dvd title: " + dvd1.dvd.getTitle());
//		System.out.println("Cinderella dvd title: " + dvd2.dvd.getTitle());
//		/*
//		changeTitle(jungleDVD, cinderellaDVD.getTitle());
//		System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
//		*/
//	}
//	
//	public static void swap(DVDWrapper dvd1, DVDWrapper dvd2) {
//		DigitalVideoDisc tmp = dvd1.dvd;
//		dvd1.dvd = dvd2.dvd;
//		dvd2.dvd = tmp;
//	}
//	
//	public static void changeTitle(DigitalVideoDisc dvd, String title) {
//		String oldTitle = dvd.getTitle();
//		dvd.setTitle(title);
//		dvd = new DigitalVideoDisc(oldTitle);
//	}
//}
