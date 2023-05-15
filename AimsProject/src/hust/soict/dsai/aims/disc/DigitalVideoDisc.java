package hust.soict.dsai.aims.disc;
import java.util.Random;
public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	//Create new attibutes for exercise 5
//	int seed_value = 100;
	private int id;
	private static int nbDigitalVideoDisc = 0;
    Random rd = new Random();
    long seedValue = nbDigitalVideoDisc;

//	Random rd = new Random();
	public DigitalVideoDisc() {
		rd.setSeed(seedValue);
		this.id = rd.nextInt(1000000 - 100000) + 100000;
		nbDigitalVideoDisc++;
	}

	public DigitalVideoDisc(String title) {
		super();
		rd.setSeed(seedValue);
		this.id = rd.nextInt(1000000 - 100000) + 100000;
		this.title = title;
		nbDigitalVideoDisc++;
	}
	public DigitalVideoDisc(String title, String category) {
		super();
		rd.setSeed(seedValue);
		this.id = rd.nextInt(1000000 - 100000) + 100000;
		this.title = title;
		this.category = category;
		nbDigitalVideoDisc++;
	}
	
	public DigitalVideoDisc(String title, String category, String director) {
		super();
		rd.setSeed(seedValue);
		this.id = rd.nextInt(1000000 - 100000) + 100000;
		this.title = title;
		this.category = category;
		this.director = director;
		nbDigitalVideoDisc++;
	}
	
	public DigitalVideoDisc(String title, String category, int length) {
		super();
		rd.setSeed(seedValue);
		this.id = rd.nextInt(1000000 - 100000) + 100000;
		this.title = title;
		this.category = category;
		this.length = length;
		nbDigitalVideoDisc++;
	}

	public DigitalVideoDisc(String title, String category, String director, int length) {
		super();
		rd.setSeed(seedValue);
		this.id = rd.nextInt(1000000 - 100000) + 100000;
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		nbDigitalVideoDisc++;
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		rd.setSeed(seedValue);
		this.id = rd.nextInt(1000000 - 100000) + 100000;
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDisc++;
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		rd.setSeed(seedValue);
		this.id = rd.nextInt(1000000 - 100000) + 100000;
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		nbDigitalVideoDisc++;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		rd.setSeed(seedValue);
		this.id = rd.nextInt(1000000 - 100000) + 100000;
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDisc++;
	}
	public int getID() {
		return id;
	}
	public String getTitle() {
		if (title == null) {
			return "Unknown";
		}
		return title;
	}
	// Add a setter
	
	public void setTitle(String title) {
		this.title = title;
	}
	

	public String getCategory() {
		if (category == null) {
			return "Unknown";
		}
		return category;
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
	public float getCost() {
		return cost;
	}
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
