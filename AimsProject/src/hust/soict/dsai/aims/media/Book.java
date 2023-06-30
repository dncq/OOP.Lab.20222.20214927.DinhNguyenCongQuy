//package hust.soict.dsai.aims.media;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class Book extends Media{
//	
//	// Define fields for the class
//	private List<String> authors = new ArrayList<String>();
//	
//	
//	// Constructor from Superclass
//	public Book() {
//		super();
//	}
//
//	public Book(String title, String category, float cost, LocalDate date) {
//		super(title, category, cost, date);
//	}
//	
//	public Book(String title, String category, float cost) {
//		super(title, category, cost);
//	}
//	
//	public Book(String title, String category, float cost, List<String> authors) {
//		super(title, category, cost);
//		this.authors = authors;
//	}
//
//
//	// Define Getter and Setter method
//	public List<String> getAuthors() {
//		return authors;
//	}
//	
//	// Create addAuthor method
//	public void addAuthor(String authorName) {
//		// Check whether the authorName is in the list
//		if (authors.contains(authorName)) {
//			System.out.println("The author's name has been already in the list ");
//		}else {
//			authors.add(authorName);
//			System.out.println("The author's name has been added");
//		}
//	}
//	
//	// Create removeAuthor method
//	public void removeAuthor(String authorName) {
//		// Check whether the list is empty
//		if (authors.size() == 0) {
//			System.out.println("The list is empty");
//		// Check whether the authorName is in the list
//		}else if(authors.contains(authorName) == false){
//			System.out.println("The author's name isn't in the list");
//		
//		}else {
//			authors.remove(authorName);
//			System.out.println("The author's name has been deleted");
//		}
//	}		
//	@Override
//	public String toString() {
//	    StringBuilder sb = new StringBuilder();
//	    sb.append("Book Information:\n");
//	    sb.append("Title: ").append(getTitle()).append("\n");
//	    sb.append("Category: ").append(getCategory()).append("\n");
//	    sb.append("Cost: ").append(getCost()).append("\n");
//	    sb.append("Authors: ").append(getAuthors()).append("\n");
//	    sb.append("ID: ").append(getId()).append("\n");
//	    return sb.toString();
//	}
//		
//}
package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.*;

public class Book extends Media {
	private int contentLength;
	private List<String> authors = new ArrayList<String>();
	
	public void addAuthor(String authorName) throws DuplicatedItemException {
		for (String name: this.authors) {
			if (name.toLowerCase().equals(authorName.toLowerCase())) {
				throw new DuplicatedItemException(name + " is already in the list of authors.");
			}
		}
		this.authors.add(authorName);
		System.out.println(authorName + " has been added to the " + this.getTitle() + " list of authors.");
	}
	
	
	public void removeAuthor(String authorName) throws NonExistingItemException {
		for (String name: this.authors) {
			if (name.toLowerCase().equals(authorName.toLowerCase())) {
				this.authors.remove(name);
				System.out.println(name + " has been removed from the " + this.getTitle() + " list of authors.");
				return;
			}
		}
		throw new NonExistingItemException(authorName + " is not in the list of authors.");
	}
	
	public String getType() {
		return "Book";
	}
	
	public String getDetails() {
		StringBuffer authorsList = new StringBuffer();
		if (this.authors.size() >= 1) {
			authorsList.append(this.authors.get(0));
			for (int i = 1; i < this.authors.size(); i++) {
				authorsList.append(", " + this.authors.get(i));
			}
		}
		return ("Product ID: " + String.valueOf(this.getID())
		+ "\n" + "\t" + "Title: " + this.getTitle()
		+ "\n" + "\t" + "Category: " + this.getCategory()
		+ "\n" + "\t" + "Authors: " + authorsList
		+ "\n" + "\t" + "Content Length: " + String.valueOf(this.getContentLength()) + " pages"
		+ "\n" + "\t" + "Price: $" + String.valueOf(this.getCost()));
	}
	
	public Book(String title, String category, int contentLength, float cost) {
		super(title, category, cost);
		this.contentLength = contentLength;
	}

	public Book(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String category) {
		super(title, category);
		// TODO Auto-generated constructor stub
	}

	public Book(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public int getContentLength() {
		return contentLength;
	}

}
