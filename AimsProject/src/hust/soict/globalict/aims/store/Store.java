package hust.soict.globalict.aims.store;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class Store{
	public static final int MAX_ITEMS = 100;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	public void addMedia(Media media) {
		if(!mediaExist(media)) itemsInStore.add(media);
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
}
