package hust.soict.globalict.test.disc;

import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}
	public static void correctSwap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		String temp = dvd1.getTitle();
		dvd1.setTitle(dvd2.getTitle());
		dvd2.setTitle(temp);
	}
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("CinderellaDVD");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungleDVD title: " + jungleDVD.getTitle());
		System.out.println("CinderellaDVD title: " + cinderellaDVD.getTitle());
		
		// correct swap
		correctSwap(jungleDVD, cinderellaDVD);
		System.out.println("jungleDVD title: " + jungleDVD.getTitle());
		System.out.println("CinderellaDVD title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungleDVD title: " + jungleDVD.getTitle());
	
	}
}
