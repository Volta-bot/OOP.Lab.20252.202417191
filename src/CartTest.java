package AimsProject;

public class CartTest {

	public static void main(String[] args) {
		// Create a new cart
        Cart cart = new Cart();

        // Create new DVD objects and add them to the cart
        DVD dvd1 = new DVD("The Lion King",
                "Animation", "Roger Allers", 87, 19.95);
        cart.addDVD(dvd1);

        DVD dvd2 = new DVD("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95);
        cart.addDVD(dvd2);

        DVD dvd3 = new DVD("Aladin",
                "Animation", 18.99);
        cart.addDVD(dvd3);

        // Test print (toString)
        cart.printCart();
        // Test Search
        cart.searchByTitle("The Lion King");
        cart.searchByTitle("Fast and Furious");
    }
}
