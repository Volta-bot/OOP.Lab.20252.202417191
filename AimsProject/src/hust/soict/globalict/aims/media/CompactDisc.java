package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	String artist;
	private ArrayList<Track> tracks = new ArrayList<>();
	public CompactDisc(int id, String title, String category, float cost,int length, String director, String artist) {
		super(id, title, category, cost, length, director);
		this.artist = artist;
	}
	//
	public void addTrack(Track track) {
		if(!trackExist(track)) tracks.add(track);
	}
	public void removeTrack(Track track) {
		if(trackExist(track)) tracks.remove(track);
	}
	private boolean trackExist(Track track) {
		for(Track i: tracks) if(i.equals(track)) return true;
		return false;
	}
	
	public int getLength() {
		int total = 0;
		for (Track i : tracks) {
			total += i.getLength();
		}
		return total;
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
