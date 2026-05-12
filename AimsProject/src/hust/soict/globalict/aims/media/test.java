package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class test {
	public static void main(String args[]) {
		List<Media> mediae = new ArrayList<Media>();
		CompactDisc cd = new CompactDisc(100, "The Lion King", "Animation", 50, 200, "Roger Allers", "Dina");
		DigitalVideoDisc dvd = new DigitalVideoDisc(101, "Interstellar", "Scifi", 50, 150, "Chistopher Nolan");
		Book book = new Book(102, "Maze Runner", "Action", 150);
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);
		
		for (Media m:mediae) {
			System.out.println(m.toString());
		}
	}	
}
