package AimsProject;
public class DVD {
	private String title;
	private String category;
	private String director;
	private int length;
	private double cost;
	
	private static int nbDVD = 0;
	private int id;
	// Constructor
	public DVD(String title) {
		this.title = title;
		this.id = nbDVD;
		nbDVD++;
	}
	
	public DVD(String title, String category, double cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = nbDVD;
		nbDVD++;
	}
	public DVD(String title, String category, String director, double cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.id = nbDVD;
		nbDVD++;
	}
	public DVD(String title, String category, String director, int length, double cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.id = nbDVD;
		nbDVD++;
	}
	// Getters
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public double getCost() {
		return cost;
	}
	// Setter
	public void setTitle(String newTitle) {
		this.title = newTitle;
	}
	public boolean isMatch(String title) {
		if(this.title.equals(title)) return true;
		return false;
	}
	@Override
	public String toString() {
		String result = "";
		result += this.title + " - " + this.category + " - " + this.director + " - " + this.length + " - " + this.cost;
		return result;
	}
	
}
