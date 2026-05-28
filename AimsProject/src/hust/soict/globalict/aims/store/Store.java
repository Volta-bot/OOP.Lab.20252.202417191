package hust.soict.globalict.aims.store;

import java.util.ArrayList;

import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class Store{
	public static final int MAX_CAPACITY = 100;
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
	
	public void addMedia(Media media) throws LimitExceededException {
		if (nItemsInStore >= MAX_CAPACITY) {
			throw new LimitExceededException("ERROR: Store is full");
		}
		if (!mediaExist(media)) {
			itemsInStore.add(media);
			nItemsInStore++;
		}
	}
	public void removeMedia(Media media) {
		if(mediaExist(media)) {
			itemsInStore.remove(media);
			nItemsInStore--;
		}
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
