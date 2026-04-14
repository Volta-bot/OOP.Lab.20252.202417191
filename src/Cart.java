package AimsProject;
public class Cart {
	public static final int MAX_CAPACITY = 20;
	private int qtyOrdered = 0;
	private DVD itemsOrdered[] = new DVD[MAX_CAPACITY];
	public boolean addDVD(DVD disc) {
		if(qtyOrdered < MAX_CAPACITY) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered += 1;
			return true;
		}
		return false;
	}
	public boolean removeDVD(DVD disc) {						// Remove disc and shift every element in the cart to the left by 1 index
		for(int i=0; i<qtyOrdered;i++) {
			if(!itemsOrdered[i].equals(disc)) continue;
			
			for(int j = i;j<qtyOrdered-1;j++) {
				itemsOrdered[j] = itemsOrdered[j+1];
			}
			itemsOrdered[qtyOrdered - 1] = null;
			qtyOrdered -= 1;
			return true;
		}
		return false;
	}
	public double totalCost() {
		double cost = 0;
		for(int i=0;i<qtyOrdered;i++) {
			cost+=itemsOrdered[i].getCost();
		}
		return cost;
	}
	public void printCart() {
		String result = "***********************CART**************************\nOrdered Items:\n";
		for(int i=0;i<qtyOrdered;i++) {
			result += (i+1) + ". " + "DVD - ";
			result += itemsOrdered[i].toString() + "\n";
		}
		result += "Total Cost: " + totalCost() + "\n";
		result += "*****************************************************";
		System.out.println(result);
	}
	public void searchByTitle(String title) {
		boolean found = false;
		for(int i=0;i<qtyOrdered;i++) {
			if(this.itemsOrdered[i].getTitle().equals(title)) {
				found = true;
				break;
			}
		}
		if(found) System.out.println("DVD \"" + title + "\" is in cart.");
		else System.out.println("DVD \"" + title + "\" is not in cart.");
	}
}
