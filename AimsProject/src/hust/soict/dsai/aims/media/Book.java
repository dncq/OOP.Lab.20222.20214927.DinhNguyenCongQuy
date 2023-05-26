package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;


public class Book extends Media{
	
	// Define fields for the class
	private int id;
	private List<String> authors = new ArrayList<String>();
	
	// Constructor from Superclass
	public Book() {
		// TODO Auto-generated constructor stub
	}

	// Define Getter and Setter method
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public List<String> getAuthors() {
		return authors;
	}


	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	// Create addAuthor method
	public void addAuthor(String authorName) {
		// Check whether the authorName is in the list
		if (authors.contains(authorName)) {
			System.out.println("The author's name has been already in the list ");
		}else {
			authors.add(authorName);
			System.out.println("The author's name has been added");
		}
	}
	
	// Create removeAuthor method
	public void removeAuthor(String authorName) {
		// Check whether the list is empty
		if (authors.size() == 0) {
			System.out.println("The list is empty");
		// Check whether the authorName is in the list
		}else if(authors.contains(authorName) == false){
			System.out.println("The author's name isn't in the list");
		
		}else {
			authors.remove(authorName);
			System.out.println("The author's name has been deleted");
		}
	}		
		
}
