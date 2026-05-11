package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class Aims {
	public static void main(String args[]) {
		Cart newOrder = new Cart();
		//ADD TO CART
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allens",87, 19.95);
		newOrder.addDVD(dvd1);
		DigitalVideoDisc ddv2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95);
		newOrder.addDVD(ddv2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99);
		newOrder.addDVD(dvd3);
		System.out.println("TOTAL COST IS: " + newOrder.totalCost());
		
		//REMOVE FROM CART
		newOrder.removeDVD(dvd1);
		System.out.println("TOTAL COST IS: " + newOrder.totalCost());
	}
}
