package hust.soict.dsai.aims.media;
import java.util.Random;
public class DigitalVideoDisc extends Disc {
	private String director;
	private int length;
	//Create new attributes for exercise 5
	private int id;
	private static int nbDigitalVideoDisc = 0;
    Random rd = new Random();
    long seedValue = nbDigitalVideoDisc;

    
    // Constructor
	public DigitalVideoDisc() {
		// Generate the ID of the DVD
		rd.setSeed(seedValue);
		this.id = rd.nextInt(1000000 - 100000) + 100000;
		nbDigitalVideoDisc++;
	}
	
	
	public DigitalVideoDisc(String title) {
		rd.setSeed(seedValue);
		this.id = rd.nextInt(1000000 - 100000) + 100000;
		nbDigitalVideoDisc++;
		super.setTitle(title);
	}
	public DigitalVideoDisc(String title, String category) {
		super();
		rd.setSeed(seedValue);
		this.id = rd.nextInt(1000000 - 100000) + 100000;
		nbDigitalVideoDisc++;
		super.setTitle(title);
		super.setCategory(category);
	}
	
	public DigitalVideoDisc(String title, String category, String director) {
		super();
		rd.setSeed(seedValue);
		this.id = rd.nextInt(1000000 - 100000) + 100000;
		this.director = director;
		nbDigitalVideoDisc++;
		super.setTitle(title);
		super.setCategory(category);
	}
	
	public DigitalVideoDisc(String title, String category, int length) {
		super();
		rd.setSeed(seedValue);
		this.id = rd.nextInt(1000000 - 100000) + 100000;;
		this.length = length;
		nbDigitalVideoDisc++;
		super.setTitle(title);
		super.setCategory(category);
	}

	public DigitalVideoDisc(String title, String category, String director, int length) {
		super();
		rd.setSeed(seedValue);
		this.id = rd.nextInt(1000000 - 100000) + 100000;
		this.director = director;
		this.length = length;
		nbDigitalVideoDisc++;
		super.setTitle(title);
		super.setCategory(category);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		rd.setSeed(seedValue);
		this.id = rd.nextInt(1000000 - 100000) + 100000;
		nbDigitalVideoDisc++;
		super.setTitle(title);
		super.setCategory(category);
		super.setCost(cost);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		rd.setSeed(seedValue);
		this.id = rd.nextInt(1000000 - 100000) + 100000;
		this.director = director;
		nbDigitalVideoDisc++;
		super.setTitle(title);
		super.setCategory(category);
		super.setCost(cost);
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		rd.setSeed(seedValue);
		this.id = rd.nextInt(1000000 - 100000) + 100000;
		this.director = director;
		this.length = length;
		nbDigitalVideoDisc++;
		super.setTitle(title);
		super.setCategory(category);
		super.setCost(cost);
	}
	public int getID() {
		return id;
	}
	public String getDirector() {
		if (director == null) {
			return "Unknown";
		}
		return director;
	}

	public int getLength() {
		return length;
	}
	
	// Print the detail of the DVD
	public String getDetail() {
		if (this.getLength() == 0 && this.getCost() != 0.0) {
			return "Title: " + this.getTitle() + " - " + 
				   "Category: " + this.getCategory() + " - " +  
				   "Director: " + this.getDirector() + " - " + 
				   "Length: " + "Unknown" + " - " + 
				   "Price: " + this.getCost() + "$ ";
		} else if (this.getCost() == 0.0 && this.getLength() != 0) {
			return "Title: " + this.getTitle() + " - " + 
				   "Category: " + this.getCategory() + " - " +  
				   "Director: " + this.getDirector() + " - " + 
				   "Length: " + this.getLength() + " - " + 
				   "Price: " + "Unknown";
		} else if (this.getLength() == 0 && this.getCost() == 0.0) {
			return "Title: " + this.getTitle() + " - " + 
				   "Category: " + this.getCategory() + " - " +  
				   "Director: " + this.getDirector() + " - " + 
				   "Length: " + "Unknown" + " - " + 
				   "Price: " + "Unknown";	
		}
		else {
			return "Title: " + this.getTitle() + " - " + 
				   "Category: " + this.getCategory() + " - " +  
				   "Director: " + this.getDirector() + " - " + 
				   "Length: " + this.getLength() + " - " + 
				   "Price: " + this.getCost() + "$ ";
		}

	}
	
	
	
	
}
