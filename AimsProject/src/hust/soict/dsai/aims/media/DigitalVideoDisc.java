package hust.soict.dsai.aims.media;
import java.time.LocalDate;
//import java.util.Random;
public class DigitalVideoDisc extends Disc {
	/*
	private String director;
	private int length;
	private int id;
	private static Integer nbDigitalVideoDisc = 0;
    Random rd = new Random();
    long seedValue = nbDigitalVideoDisc;
	*/
    
    
    public DigitalVideoDisc() {
		super();
	}
    
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public DigitalVideoDisc(String title, String category, float cost, int length) {
		super(title, category, cost, length);
	}
	
	public DigitalVideoDisc(String title, String category, float cost, String director) {
		super(title, category, cost, director);
	}

	public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
		super(title, category, cost, length, director);
	}

	public DigitalVideoDisc(String title, String category, float cost, LocalDate date) {
		super(title, category, cost, date);
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
