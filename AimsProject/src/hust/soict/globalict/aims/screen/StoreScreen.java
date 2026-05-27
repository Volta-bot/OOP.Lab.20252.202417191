package hust.soict.globalict.aims.screen;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

public class StoreScreen extends JFrame {
	private Store store;
	private Cart cart;
	public StoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024,720);
	}
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout (north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}

	JMenuBar createMenuBar() {

	    JMenu menu = new JMenu("Options");

	    JMenu smUpdateStore = new JMenu("Update Store");
	    smUpdateStore.add(new JMenuItem("Add Book"));
	    smUpdateStore.add(new JMenuItem("Add CD"));
	    smUpdateStore.add(new JMenuItem("Add DVD"));

	    menu.add(smUpdateStore);
	    menu.add(new JMenuItem("View store"));

	    JMenuItem viewCart = new JMenuItem("View cart");
	    viewCart.addActionListener(e -> {
	        setVisible(false);
	    	new CartScreen(cart, store);
	    });
	    menu.add(viewCart);

	    JMenuBar menuBar = new JMenuBar();
	    menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    menuBar.add(menu);

	    return menuBar;
	}
	JPanel createHeader() {

	    JPanel header = new JPanel();
	    header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

	    JLabel title = new JLabel("AIMS");
	    title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
	    title.setForeground(Color.CYAN);

	    
	    header.add(Box.createRigidArea(new Dimension(10, 10)));
	    header.add(title);
	    header.add(Box.createHorizontalGlue());
	    header.add(Box.createRigidArea(new Dimension(10, 10)));

	    return header;
	}

	JPanel createCenter() {

	    JPanel center = new JPanel();
	    center.setLayout(new GridLayout(3, 3, 2, 2));

	    ArrayList<Media> mediaInStore = store.getItemsInStore();
	    for (int i = 0; i < mediaInStore.size(); i++) {
	        MediaStore cell = new MediaStore(mediaInStore.get(i),cart);
	        center.add(cell);
	    }

	    return center;
	}
}

