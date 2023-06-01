package hust.soict.dsai.aims.media;
import java.time.LocalDate;
import java.util.Comparator;

public abstract class Media implements Comparable<Media>{
	
	// Define fields for the class
	private int id;
	private String title;
	private String category;
	private float cost;
	private LocalDate date;
	private static Integer nbMedia = 0;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
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
	
	@Override
	public boolean equals(Object obj) {
		Media media = (Media) obj;
		return (this.title.equals(media.getTitle()));
	}
	
	@Override
	public int compareTo(Media media) {
		if(this.cost > media.getCost()) {
			return 1;
		} else if(this.cost < media.getCost()) {
			return -1;
		} else {
			return (this.title.compareTo(media.getTitle()));
		}
	}
	
	// Define Getter and Setter methods
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public LocalDate getDate() {
		return date;
	}
	
    public boolean isMatch(String title) {
        if (this.title.equals(title)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isMatch(int id) {
        if (this.id == id) {
            return true;
        } else {
            return false;
        }
    }
}
