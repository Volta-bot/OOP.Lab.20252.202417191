package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> Author = new ArrayList<>();
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	// add/remove Author
	public void addAuthor(String name) {
		if(!Author.contains(name)) Author.add(name);
	}
	public void removeAuthor(String name){
		if(Author.contains(name)) Author.remove(name);
	}
	@Override
	public String toString() {
	    return "Book - "
	            + getTitle() + " - "
	            + getCategory() + " - "
	            + Author + " - "
	            + getCost() + "$";
	}

}
