package hust.soict.dsai.aims.media;
import java.time.LocalDate;

public class Disc extends Media {
	
	private int length;
	private String director;
	
	public Disc() {
		super();
	}
	
	
	public Disc(String title, String category, float cost, LocalDate date) {
		super(title, category, cost, date);
	}


	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}

	public Disc(String title, String category, float cost, int length) {
		super(title, category, cost);
		this.length = length;
	}
	
	public Disc(String title, String category, float cost, String director) {
		super(title, category, cost);
		this.director = director;
	}
	
	public Disc(String title, String category, float cost, int length, String director) {
		super(title, category, cost);
		this.length = length;
		this.director = director;
	}

	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	
}
