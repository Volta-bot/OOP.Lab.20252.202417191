package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test {
	public static void main(String args[]) {
		List<Media> mediae = new ArrayList<Media>();
		//cd
		CompactDisc cd = new CompactDisc(100, "The Lion King", "Animation", 50, "Roger Allers", "Dina");
		Track track1 = new Track("Circle of life", 60);
		Track track2 = new Track("Hakuna Matata", 120);
		cd.addTrack(track1);
		cd.addTrack(track2);
		//dvd
		DigitalVideoDisc dvd = new DigitalVideoDisc(101, "Interstellar", "Scifi", 50, 150, "Chistopher Nolan");
		//book
		Book book = new Book(102, "Maze Runner", "Action", 150);
		book.addAuthor("Janice");
		book.addAuthor("Rimac");
		//test
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);
		System.out.println("Before Sorting:");
		for (Media m:mediae) {
			System.out.println(m.toString());
		}
		//Sorting
		System.out.println("\nSorting By title-cost:");
		Collections.sort(mediae, Media.COMPARE_BY_TITLE_COST);
		for (Media m:mediae) {
			System.out.println(m.toString());
		}
		
		System.out.println("\nSorting By cost-title:");
		Collections.sort(mediae, Media.COMPARE_BY_COST_TITLE);
		for (Media m:mediae) {
			System.out.println(m.toString());
		}
	}	
}
