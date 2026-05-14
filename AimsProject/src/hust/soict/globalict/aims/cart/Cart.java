package hust.soict.globalict.aims.cart;
import hust.soict.globalict.aims.media.*;
import java.util.Collections;
import java.util.ArrayList;
public class Cart {
	public static final int MAX_CAPACITY = 20;
	public int nItemsOrdered = 0;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	public void printCart() {
		for(Media i: itemsOrdered) {
			System.out.println(i.toString());
		}
	}
	public void addMedia(Media media) {
		if(!mediaExist(media) && nItemsOrdered<MAX_CAPACITY ) {
			itemsOrdered.add(media);
			nItemsOrdered++;
		}
	}
	public void removeMedia(Media media) {
		if(mediaExist(media)) {
			itemsOrdered.remove(media);
			nItemsOrdered--;
		}
		
	}
	private boolean mediaExist(Media media) {
		for(Media i: itemsOrdered) {
			if(i.equals(media)) return true;
		}
		return false;
	}	
	public Media searchMediaByTitle(String title) {
		for(Media i: itemsOrdered) {
			if(i.getTitle().equals(title)) return i;
		}
		return null;
	}
	public void sortByTitle() {
	    Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}
	public void sortByCost() {
	    Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}
	public void emptyCart() {
		itemsOrdered.clear();
	}
	public double totalCost() {
		double cost = 0;
		for(Media i: itemsOrdered) {
			cost+=i.getCost();
		}
		return cost;	
	}
}
