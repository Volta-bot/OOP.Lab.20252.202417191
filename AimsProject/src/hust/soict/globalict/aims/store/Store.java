package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.disc.DVD;

public class Store{
	public static final int MAX_ITEMS = 100;
	private DVD[] itemsInStore = new DVD[MAX_ITEMS];
	private int qtyDVDinStore = 0;
	public void addDVD(DVD disc) {
		if(qtyDVDinStore >= MAX_ITEMS) {
			System.out.println("Store is full");
			return;
		}
		itemsInStore[qtyDVDinStore] = disc;
		qtyDVDinStore++;
	}
	
	public void removeDVD(DVD disc) {
		for(int i=0;i<qtyDVDinStore;i++) {
			if(itemsInStore[i].equals(disc)) {
				for(int j=i;j<qtyDVDinStore-1;j++) {
					itemsInStore[j] = itemsInStore[j+1];
				}
				itemsInStore[qtyDVDinStore-1] = null;
				qtyDVDinStore--;
				return;
			}
		}
		System.out.println("DVD not found");
	}
	
	public void printStore() {
		System.out.println("DVDs in Store:");
		for(int i=0;i<qtyDVDinStore;i++) {
			System.out.println("DVD " + (i+1) + ": " + itemsInStore[i].toString());
		}
	}
}
