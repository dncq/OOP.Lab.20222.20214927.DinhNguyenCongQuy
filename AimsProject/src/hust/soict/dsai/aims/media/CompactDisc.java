//package hust.soict.dsai.aims.media;
//
//import java.util.*;
//import java.time.LocalDate;
//
//public class CompactDisc extends Disc implements Playable {
//	
//
//	private String artist;
//	private List<Track> tracks = new ArrayList<Track>();
//	
//	
//	public void play() {
//		for(Track track: tracks) {
//			track.play();
//		}
//	}
//	public CompactDisc() {
//		super();
//	}
//	
//	public CompactDisc(String title, String category, float cost) {
//		super(title, category, cost);
//	}
//	
//	public CompactDisc(String title, String category, float cost, String director) {
//		super(title, category, cost, director);
//	}
//	
//	public CompactDisc(String title, String category, float cost, LocalDate date) {
//		super(title, category, cost, date);
//	}
//
//	public String getArtist() {
//		return artist;
//	}
//	
//	public void addTrack(Track track) {
//		if (tracks.contains(track)) {
//			System.out.println("The track is already in the list");
//		} else {
//			tracks.add(track);
//			System.out.println("The track is added");
//		}
//	}
//	
//	
//	public void removeTrack(Track track) {
//		if (tracks.isEmpty()) {
//			System.out.println("The list is empty");
//		} else if (tracks.contains(track) == false) {
//			System.out.println("The track is not in the list");
//		} else {
//			tracks.remove(tracks.indexOf(track));
//			System.out.println("The track is removed");
//		}
//	}
//	public int getLength() {  
//		int length = 0;
//		for (Track track : tracks) {
//			length += track.getLength();
//		}
//		return length;
//	}
//	
//	@Override
//	public String toString() {
//	    StringBuilder sb = new StringBuilder();
//	    sb.append("Compact Disc Information:\n");
//	    sb.append("Title: ").append(getTitle()).append("\n");
//	    sb.append("Category: ").append(getCategory()).append("\n");
//	    sb.append("Cost: ").append(getCost()).append("\n");
//	    sb.append("Artist: ").append(artist).append("\n");
//	    sb.append("Number of Tracks: ").append(tracks.size()).append("\n");
//	    sb.append("Total Length: ").append(getLength()).append(" minutes").append("\n");
//	    sb.append("ID: ").append(getId()).append("\n");
//	    return sb.toString();
//	}
//	
//	
//}

package hust.soict.dsai.aims.media;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.dsai.aims.exception.*;


public class CompactDisc extends Disc {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public void addTrack(Track track) throws DuplicatedItemException {
		if (this.tracks.contains(track)) {
			throw new DuplicatedItemException("The track " + track.getTitle() + " is already in the tracklist of " + this.getTitle());
		} else {
			this.tracks.add(track);
			System.out.println("The track " + track.getTitle() + " has been added to the tracklist of " + this.getTitle());
		}
	}
	
	public void removeTrack(Track track) throws NonExistingItemException {
		if (this.tracks.remove(track)) {
			System.out.println("The track " + track.getTitle() + " has been removed from the tracklist of " + this.getTitle());
		} else {
			throw new NonExistingItemException("The track " + track.getTitle() + " is not in the tracklist of " + this.getTitle());
		}
	}
	
	public int getLength() {
		int totalLength = 0;
		for (Track track: this.tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}
	
	public void play() throws PlayerException {
		if (this.getLength() <= 0) {
			throw new PlayerException("ERROR: CD length is non-positive!");
		} else {
			System.out.println("Playing CD: " + this.getTitle());
			
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			JPanel p = new JPanel();
			JDialog d = new JDialog();
			JLabel l1 = new JLabel("Now playing: " + this.getTitle());
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
			l1.setAlignmentX(Component.CENTER_ALIGNMENT);
			d.setTitle("Media Player");
			p.add(Box.createVerticalGlue());
			p.add(l1);
			p.add(Box.createVerticalGlue());
			d.add(p);
			d.setSize(250,100);
			int w = d.getSize().width;
	        int h = d.getSize().height;
	        int x = (dim.width - w) / 2;
	        int y = (dim.height - h) / 2;
			d.setLocation(x, y);
			d.setVisible(true);
			
			for (Track track: this.tracks) {
				try {
					track.play();
				} catch (PlayerException e) {
					throw e;
				}
			}
		}
	}
	
	public String getType() {
		return "CD";
	}
	
	public String getDetails() {
		StringBuffer tracklist = new StringBuffer();
		if (this.tracks.size() >= 1) {
			tracklist.append(this.tracks.get(0).getTitle());
			for (int i = 1; i < this.tracks.size(); i++) {
				tracklist.append(", " + this.tracks.get(i).getTitle());
			}
		}
		return ("Product ID: " + String.valueOf(this.getID())
		+ "\n" + "\t" + "Title: " + this.getTitle()
		+ "\n" + "\t" + "Category: " + this.getCategory()
		+ "\n" + "\t" + "Artist: " + this.getArtist()
		+ "\n" + "\t" + "Director: " + this.getDirector()
		+ "\n" + "\t" + "Tracklist: " + tracklist
		+ "\n" + "\t" + "Length: " + String.valueOf(this.getLength()) + " minutes"
		+ "\n" + "\t" + "Price: $" + String.valueOf(this.getCost()));
	}

	public CompactDisc(String title, String category, String artist, String director, float cost) {
		super(title, category, director, cost);
		this.artist = artist;
	}
	
	public CompactDisc(String title, String category, String artist, float cost) {
		super(title, category, cost);
		this.artist = artist;
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title, String category) {
		super(title, category);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public String getArtist() {
		return artist;
	}

}
