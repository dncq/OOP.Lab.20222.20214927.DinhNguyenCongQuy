package hust.soict.dsai.aims.media;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class CompactDisc extends Disc{
	
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc() {
		super();
	}
	
	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public CompactDisc(String title, String category, float cost, int length) {
		super(title, category, cost, length);
	}
	
	public CompactDisc(String title, String category, float cost, String director) {
		super(title, category, cost, director);
	}
	
	public CompactDisc(String title, String category, float cost, int length, String director) {
		super(title, category, cost, length, director);
	}


	public CompactDisc(String title, String category, float cost, LocalDate date) {
		super(title, category, cost, date);
	}








	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("The track is already in the list");
		} else {
			tracks.add(track);
			System.out.println("The track is added");
		}
	}
	public void removeTrack(Track track) {
		if (tracks.isEmpty()) {
			System.out.println("The list is empty");
		} else if (tracks.contains(track) == false) {
			System.out.println("The track is not in the list");
		} else {
			tracks.remove(tracks.indexOf(track));
			System.out.println("The track is removed");
		}
	}
	public int getLength() {  
		int length = 0;
		for (Track track : tracks) {
			length += track.getLength();
		}
		return length;
	}
	
	
	
}
