package hust.soict.globalict.test.store;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers", 87, 19.95);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Aladin","Animation", 18.99);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Whiplash");
		//test addDVD
		Store DVDStore = new Store();
		DVDStore.addDVD(dvd1);
		DVDStore.addDVD(dvd2);
		DVDStore.addDVD(dvd3);
		DVDStore.printStore();
		
		//test removeDVD
		DVDStore.removeDVD(dvd2);
		DVDStore.printStore();
    }
}
