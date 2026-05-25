package hust.soict.globalict.aims.store;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class Store{
	public static final int MAX_ITEMS = 100;
	public int nItemsInStore = 0;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	public Media searchMediaByTitle(String title) {
		for(Media i: itemsInStore) {
			if(i.getTitle().equals(title)) return i ;
		}
		return null;
	}
	public void printStore() {
		System.out.println("List of Medias in store: ");
		for(Media i: itemsInStore) {
			System.out.println(i.toString());
		}
	}
	
	public void addMedia(Media media) {
		if(!mediaExist(media) && nItemsInStore < 100) itemsInStore.add(media);
	}
	public void removeMedia(Media media) {
		if(mediaExist(media)) itemsInStore.remove(media);
	}
	private boolean mediaExist(Media media) {
		for(Media i: itemsInStore) {
			if(i.equals(media)) return true;
		}
		return false;
	}
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}	
}
