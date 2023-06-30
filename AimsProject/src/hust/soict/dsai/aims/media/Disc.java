//package hust.soict.dsai.aims.media;
//import java.time.LocalDate;
//
//public abstract class Disc extends Media implements Playable {
//	
//	private int length;
//	private String director;
//	
//	public Disc() {
//		super();
//	}
//	
//	
//	public Disc(String title, String category, float cost, LocalDate date) {
//		super(title, category, cost, date);
//	}
//
//
//	public Disc(String title, String category, float cost) {
//		super(title, category, cost);
//	}
//
//	public Disc(String title, String category, float cost, int length) {
//		super(title, category, cost);
//		this.length = length;
//	}
//	
//	public Disc(String title, String category, float cost, String director) {
//		super(title, category, cost);
//		this.director = director;
//	}
//	
//	public Disc(String title, String category, float cost, int length, String director) {
//		super(title, category, cost);
//		this.length = length;
//		this.director = director;
//	}
//
//	public int getLength() {
//		return length;
//	}
//
//	public String getDirector() {
//		return director;
//	}
//
//	
//}

package hust.soict.dsai.aims.media;

public abstract class Disc extends Media implements Playable {
	private String director;
	private int length;
	
	public Disc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.director = director;
	}
	public Disc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
	}

	public Disc(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public Disc(String title, String category) {
		super(title, category);
		// TODO Auto-generated constructor stub
	}

	public Disc(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}

}