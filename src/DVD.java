package AimsProject;
public class DVD {
	private String title;
	private String category;
	private String director;
	private int length;
	private double cost;
	// Constructor
	public DVD(String title) {
		this.title = title;
	}
	
	public DVD(String title, String category, double cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public DVD(String title, String category, String director, double cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	public DVD(String title, String category, String director, int length, double cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
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
	
}
