package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Media implements Playable{
	String artist;
	ArrayList<Track> tracks;
	public CompactDisc(int id, String title, String category, float cost,String artist) {
		super(id, title, category, cost);
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
		for(Track i: tracks) {
			System.out.println("Playing CD: "+i.getTitle());
			System.out.println("CD length: " + i.getLength());
		}
	}
}
