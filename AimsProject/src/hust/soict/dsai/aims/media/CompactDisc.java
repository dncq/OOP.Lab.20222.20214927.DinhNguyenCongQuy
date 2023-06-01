package hust.soict.dsai.aims.media;

import java.util.*;
import java.time.LocalDate;

public class CompactDisc extends Disc implements Playable {
	

	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	
	public void play() {
		for(Track track: tracks) {
			track.play();
		}
	}
	public CompactDisc() {
		super();
	}
	
	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public CompactDisc(String title, String category, float cost, String director) {
		super(title, category, cost, director);
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
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Compact Disc Information:\n");
	    sb.append("Title: ").append(getTitle()).append("\n");
	    sb.append("Category: ").append(getCategory()).append("\n");
	    sb.append("Cost: ").append(getCost()).append("\n");
	    sb.append("Artist: ").append(artist).append("\n");
	    sb.append("Number of Tracks: ").append(tracks.size()).append("\n");
	    sb.append("Total Length: ").append(getLength()).append(" minutes").append("\n");
	    sb.append("ID: ").append(getId()).append("\n");
	    return sb.toString();
	}
	
	
}
