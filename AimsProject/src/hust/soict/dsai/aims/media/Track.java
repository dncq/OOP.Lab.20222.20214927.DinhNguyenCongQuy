package hust.soict.dsai.aims.media;

public class Track {
	
	private String title = "Null";
	private int length;
	
	public Track() {
	}
	
	
	public Track(String title) {
		super();
		this.title = title;
	}


	public Track(int length) {
		super();
		this.length = length;
	}


	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}


	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}
	
	
}
