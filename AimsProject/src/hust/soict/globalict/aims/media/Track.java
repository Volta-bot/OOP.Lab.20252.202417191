package hust.soict.globalict.aims.media;

public class Track implements Playable {
	private String title;
	private int length;
	public Track() {
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	@Override 
	public void play() {
		
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
		return this.getTitle() == other.getTitle()	&&	this.getLength() == other.getLength();
	}
}
