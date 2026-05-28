package hust.soict.globalict.aims.media;
public class Disc extends Media {
	private int length;
	private String director;
	// Constructor
	public Disc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost);
		if(length < 0) throw new IllegalArgumentException("ERROR: Length cannot be negative");
		if (director == null || director.isBlank()) throw new IllegalArgumentException("ERROR: Director cannot be empty");
		this.length = length;
		this.director = director;
	}
	// Getters
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}

}
