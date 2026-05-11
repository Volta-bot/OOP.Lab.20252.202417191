package hust.soict.globalict.test.cart;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		// Create a new cart
        Cart cart = new Cart();

        // Create new DVD objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers", 87, 19.95);
        cart.addDVD(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction", "George Lucas", 87, 24.95);
        cart.addDVD(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation", 18.99);
        cart.addDVD(dvd3);

        // Test print (toString)
        cart.printCart();
        // Test Search
        cart.searchByTitle("The Lion King");
        cart.searchByTitle("Fast and Furious");
    }
}
