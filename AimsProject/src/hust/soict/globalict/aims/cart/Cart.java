package hust.soict.globalict.aims.cart;
import hust.soict.globalict.aims.media.*;
import java.util.ArrayList;
public class Cart {
	public static final int MAX_CAPACITY = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	public void addMedia(Media media) {
		if(!mediaExist(media)) itemsOrdered.add(media);
	}
	public void removeMedia(Media media) {
		if(mediaExist(media)) itemsOrdered.remove(media);
	}
	private boolean mediaExist(Media media) {
		for(Media i: itemsOrdered) {
			if(i.equals(media)) return true;
		}
		return false;
	}	
	public double totalCost() {
		double cost = 0;
		for(Media i: itemsOrdered) {
			cost+=i.getCost();
		}
		return cost;	
	}
}
