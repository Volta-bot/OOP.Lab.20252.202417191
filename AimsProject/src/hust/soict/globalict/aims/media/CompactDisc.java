package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<>();
	public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
		super(id, title, category, cost, 0, director);
		if(artist == null || artist.isEmpty()) throw new IllegalArgumentException("ERROR: artist cannot be empty");
		this.artist = artist;
	}
	//
	public int getLength() {
		int total = 0;
		for (Track i : tracks) {
			total += i.getLength();
		}
		return total;
	}
	public String getArtist() {
		return artist;
	}
	//
	public void addTrack(Track track) {
		if(!tracks.contains(track)) tracks.add(track);
	}
	public void removeTrack(Track track) {
		if(tracks.contains(track)) tracks.remove(track);
	}
	
	@Override
	public void play() {
		System.out.println("Playing CD: " + getTitle());
	    System.out.println("CD length: " + getLength());
	    for (Track i : tracks) {
	        i.play();
	    }
	}
	@Override
	public String toString() {
	    return "CD - "
	            + getTitle() + " - "
	            + getCategory() + " - "
	            + artist + " - "
	            + getLength() + ": "
	            + getCost() + "$";
	}
}
