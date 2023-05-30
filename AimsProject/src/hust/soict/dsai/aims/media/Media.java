package hust.soict.dsai.aims.media;
import java.time.LocalDate;


public abstract class Media {
	
	// Define fields for the class
	private int id;
	private String title;
	private String category;
	private float cost;
	private LocalDate date;
	private static Integer nbMedia = 0;
	
	// Constructor from superclass
	public Media() {
		nbMedia++;
		this.id = Integer.parseInt(nbMedia.toString());
	}
	
	
	public Media( String title, String category, float cost) {
		nbMedia++;
		this.id = Integer.parseInt(nbMedia.toString());
		this.title = title;
		this.category = category;
		this.cost = cost;
	}


	public Media(String title, String category, float cost, LocalDate date) {
		nbMedia++;
		this.id = Integer.parseInt(nbMedia.toString());
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.date = date;
	}

	// Define Getter and Setter methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
