package hust.soict.globalict.aims.media;

public class Track implements Playable {
	private String title;
	private int length;
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	@Override 
	public void play() {
		System.out.println("Playing track: " + this.getTitle());
	    System.out.println("Track length: " + this.getLength());
	}
	
	@Override 
	public boolean equals(Object obj) {
		// Same object in memory
		if(this == obj) return true;
		// null object
		if (obj == null) return false;
		// Object not a Track
		if (!(obj instanceof Track)) return false;
		// cast and compare
		Track other = (Track) obj;
		return this.getTitle().equals(other.getTitle()) && this.getLength() == other.getLength();
	}
}
