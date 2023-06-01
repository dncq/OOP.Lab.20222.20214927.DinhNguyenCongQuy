package hust.soict.dsai.aims.media;

public class Track implements Playable {
	
	private String title = "Null";
	private int length;
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
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


	@Override
	public boolean equals(Object obj) {
		Track track = (Track) obj;
		return (this.title.equals(track.getTitle()) && this.length == track.getLength());
	}
	
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}
	
	
}
