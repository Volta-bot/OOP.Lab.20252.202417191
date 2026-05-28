package hust.soict.globalict.aims.screen;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.*;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;
    public MediaStore(Media media, Cart cart) {
    	this.cart = cart;
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddToCart = new JButton("Add to cart");
		btnAddToCart.addActionListener(e -> {
			try {
				cart.addMedia(media);

				JOptionPane.showMessageDialog(this, "Added to cart");
			} catch (LimitExceededException ex) {

				JOptionPane.showMessageDialog(this, ex.getMessage(), "Cart Error", JOptionPane.ERROR_MESSAGE);
			}
		});
        
        container.add(btnAddToCart);
        if (media instanceof Playable) {
            container.add(new JButton("Play"));
        }

        
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
