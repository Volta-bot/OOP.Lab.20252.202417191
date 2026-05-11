package hust.soict.globalict.aims.media;

import java.util.List;

public class Book extends Media {
	private List<String> Author;
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	// add/remove Author
	public void addAuthor(String name) {
		if(!authorExist(name)) Author.add(name);
	}
	public void removeAuthor(String name){
		if(authorExist(name)) Author.remove(name);
	}
	public boolean authorExist(String name) {
		for(String i : Author) {
			if (i.equals(name)) {
				return true;
			}
		}
		return false;
	}

}
