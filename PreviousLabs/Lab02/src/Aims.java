
public class Aims {
	public static void main(String args[]) {
		Cart newOrder = new Cart();
		//ADD TO CART
		DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allens",87, 19.95);
		newOrder.addDVD(dvd1);
		DVD ddv2 = new DVD("Star Wars","Science Fiction","George Lucas",87,24.95);
		newOrder.addDVD(ddv2);
		DVD dvd3 = new DVD("Aladin","Animation",18.99);
		newOrder.addDVD(dvd3);
		System.out.println("TOTAL COST IS: " + newOrder.totalCost());
		
		//REMOVE FROM CART
		newOrder.removeDVD(dvd1);
		System.out.println("TOTAL COST IS: " + newOrder.totalCost());
	}
}
