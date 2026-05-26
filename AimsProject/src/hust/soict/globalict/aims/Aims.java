package hust.soict.globalict.aims;

import java.util.Scanner;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.screen.CartScreen;
import hust.soict.globalict.aims.store.Store;

public class Aims {

	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		Store store = new Store();
		Cart cart = new Cart();

        // Sample media
        DigitalVideoDisc dvd =
                new DigitalVideoDisc(
                        1,
                        "Interstellar",
                        "Sci-fi",
                        25.0f,
                        150,
                        "Christopher Nolan"
                );

        Book book =
                new Book(
                        2,
                        "Maze Runner",
                        "Action",
                        20.0f
                );

        book.addAuthor("James Dashner");

        CompactDisc cd =
                new CompactDisc(
                        3,
                        "The Lion King",
                        "Animation",
                        30.0f,
                        "Roger Allers",
                        "Disney"
                );
		Track t1 = new Track("Circle of Life", 60);
		Track t2 = new Track("Hakuna Matata", 120);

		cd.addTrack(t1);
		cd.addTrack(t2);

		store.addMedia(dvd);
		store.addMedia(book);
		store.addMedia(cd);
		
		new CartScreen(cart);
		
		
		int choice;
		while(true) {
			showMenu();
			choice = input.nextInt();
			input.nextLine();
			switch (choice) {
			case 1:
				viewStore(store, cart);
				break;

			case 2:
				updateStore(store);
				break;
			case 3:
				seeCurrentCart(cart);
				break;
			case 0:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
	}
	// ========================= VIEW STORE =========================
	public static void viewStore(Store store, Cart cart) {
		int choice;
		while(true) {
			store.printStore();
			storeMenu();
			choice = input.nextInt();
			input.nextLine();
			switch (choice) {
			case 1:
				System.out.print("Enter media title: ");
				String title = input.nextLine();
				Media media = store.searchMediaByTitle(title);
				if (media == null) {
					System.out.println("Media not found");
					break;
				}
				System.out.println(media);
				mediaDetailsMenu(media instanceof Book);
				int detailChoice = input.nextInt();
				input.nextLine();
				switch (detailChoice) {
				case 1:
					cart.addMedia(media);
					System.out.println("Added to cart");
					break;
				case 2:
					if (media instanceof Playable) {
						((Playable) media).play();
					}
					break;
				}
				break;
			case 2:
				System.out.print("Enter media title: ");
				title = input.nextLine();
				media = store.searchMediaByTitle(title);
				if (media != null) {
					cart.addMedia(media);
					System.out.println("Added to cart");
				} else {
					System.out.println("Media not found");
				}
				break;
			case 3:
				System.out.print("Enter media title: ");
				title = input.nextLine();
				media = store.searchMediaByTitle(title);
				if (media instanceof Playable) {
					((Playable) media).play();
				} else {
					System.out.println("Media cannot be played");
				}
				break;
			case 4:
				seeCurrentCart(cart);
				break;
			}
		} 
	}
	// ========================= UPDATE STORE =========================
	public static void updateStore(Store store) {
	    int choice;

	    do {
	        System.out.println("Update Store");
	        System.out.println("-------------------");
	        System.out.println("1. Add media");
	        System.out.println("2. Remove media");
	        System.out.println("0. Back");
	        System.out.println("-------------------");

	        choice = input.nextInt();
	        input.nextLine();

	        switch (choice) {
	            case 1:
	                System.out.println("Choose media type:");
	                System.out.println("1. Book");
	                System.out.println("2. DVD");
	                System.out.println("3. CD");
	                
	                int type = input.nextInt();
	                input.nextLine();

	                System.out.print("ID: ");
	                int id = input.nextInt();
	                input.nextLine();

	                System.out.print("Title: ");
	                String title = input.nextLine();

	                System.out.print("Category: ");
	                String category = input.nextLine();

	                System.out.print("Cost: ");
	                float cost = input.nextFloat();
	                input.nextLine();
	                switch (type) {
	                    case 1:
	                        Book book = new Book(id, title, category, cost);
	                        store.addMedia(book);
	                        System.out.println("Book added");
	                        break;
	                    case 2:
	                        System.out.print("Length: ");
	                        int dvdLength = input.nextInt();
	                        input.nextLine();
	                        System.out.print("Director: ");
	                        String dvdDirector = input.nextLine();
	                        store.addMedia(
	                            new DigitalVideoDisc(
	                                id,
	                                title,
	                                category,
	                                cost,
	                                dvdLength,
	                                dvdDirector
	                            )
	                        );
	                        System.out.println("DVD added");
	                        break;
	                    case 3:
	                        System.out.print("Director: ");
	                        String cdDirector = input.nextLine();
	                        System.out.print("Artist: ");
	                        String artist = input.nextLine();
	                        CompactDisc cd = new CompactDisc(
	                            id,
	                            title,
	                            category,
	                            cost,
	                            cdDirector,
	                            artist
	                        );
	                        System.out.print("Number of tracks: ");
	                        int n = input.nextInt();
	                        input.nextLine();
	                        for (int i = 0; i < n; i++) {
	                            System.out.println("Track " + (i + 1));
	                            System.out.print("Track title: ");
	                            String trackTitle = input.nextLine();
	                            System.out.print("Track length: ");
	                            int trackLength = input.nextInt();
	                            input.nextLine();

	                            cd.addTrack(
	                                new Track(trackTitle, trackLength)
	                            );
	                        }
	                        store.addMedia(cd);
	                        System.out.println("CD added");
	                        break;
	                }
	                break;
	            case 2:
	                System.out.print("Enter title to remove: ");
	                String removeTitle = input.nextLine();

	                Media media = store.searchMediaByTitle(removeTitle);

	                if (media != null) {
	                    store.removeMedia(media);
	                    System.out.println("Media removed");
	                } else {
	                    System.out.println("Media not found");
	                }
	                break;
	            case 0:
	                break;
	            default:
	                System.out.println("Invalid choice");
	        }
	    } while (choice != 0);
	}
	// ========================= CURRENT CART =========================
	public static void seeCurrentCart(Cart cart) {
		int choice;
		while(true) {
			System.out.println("Current Cart:");
			cart.printCart();
			cartMenu();
			choice = input.nextInt();
			input.nextLine();
			switch (choice) {
			case 1:
				System.out.print("Enter title: ");
				String title = input.nextLine();
				cart.searchMediaByTitle(title);
				break;
			case 2:
				System.out.println("1. Sort by title");
				System.out.println("2. Sort by cost");
				int sortChoice = input.nextInt();
				input.nextLine();
				if (sortChoice == 1) {
					cart.sortByTitle();
				} else if (sortChoice == 2) {
					cart.sortByCost();
				}
				break;
			case 3:
				System.out.print("Enter title: ");
				title = input.nextLine();
				Media media = cart.searchMediaByTitle(title);
				if (media != null) {
					cart.removeMedia(media);
				}
				break;
			case 4:
				System.out.print("Enter title: ");
				title = input.nextLine();
				media = cart.searchMediaByTitle(title);
				if (media instanceof Playable) {
					((Playable) media).play();
				} else {
					System.out.println("Media cannot be played");
				}
				break;
			case 5:
				System.out.println("Order created");
				cart.emptyCart();
				break;
			}
		}
	}
	// ========================= MENUS =========================
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.print("Please choose a number: ");
	}
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.print("Please choose a number: ");
	}
	public static void mediaDetailsMenu(boolean isBook) {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		if (!isBook) {
			System.out.println("2. Play");
		}
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.print("Please choose a number: ");
	}
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.print("Please choose a number: ");
	}
}