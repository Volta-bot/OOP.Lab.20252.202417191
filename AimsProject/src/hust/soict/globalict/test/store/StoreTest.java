package hust.soict.globalict.test.store;

import hust.soict.globalict.aims.disc.DVD;
import hust.soict.globalict.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		DVD dvd1 = new DVD("The Lion King","Animation", "Roger Allers", 87, 19.95);
		DVD dvd2 = new DVD("Aladin","Animation", 18.99);
		DVD dvd3 = new DVD("Whiplash");
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
