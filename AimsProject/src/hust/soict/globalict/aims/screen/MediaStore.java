package hust.soict.globalict.aims.screen;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.*;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;
    public MediaStore(Media media, Cart cart) {
    	this.cart = cart;
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel id = new JLabel("ID: " + media.getId());
        id.setAlignmentX(CENTER_ALIGNMENT);

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel category = new JLabel("Category: " + media.getCategory());
        category.setAlignmentX(CENTER_ALIGNMENT);

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
			} catch (IllegalArgumentException ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage(), "Media already exists", JOptionPane.ERROR_MESSAGE);
			}
		});
        container.add(btnAddToCart);
        
        JButton btnPlay = new JButton("Play");
        btnPlay.addActionListener(e -> {
        	try {
        		((Playable) media).play();
        	}
        	catch (PlayerException e1) {
        		JOptionPane.showMessageDialog(
        			this,
        			e1.getMessage(),
        			"Player Error",
        			JOptionPane.ERROR_MESSAGE);
        	}
        });
        if (media instanceof Playable) {
            container.add(btnPlay);
        }

        this.add(Box.createVerticalGlue());
        this.add(id);
        this.add(title);
        this.add(category);

        if(media instanceof Book) {
        	JLabel author = new JLabel("Author: " + ((Book) media).getAuthors());
        	author.setAlignmentX(CENTER_ALIGNMENT);
        	this.add(author);
        }
        else if(media instanceof CompactDisc) {
        	JLabel director = new JLabel("Director: " + ((CompactDisc) media).getDirector());
        	JLabel artist = new JLabel("Artist: " + ((CompactDisc) media).getArtist());
        	director.setAlignmentX(CENTER_ALIGNMENT);
        	artist.setAlignmentX(CENTER_ALIGNMENT);
        	this.add(director);
        	this.add(artist);
        }
        else if(media instanceof DigitalVideoDisc) {
        	JLabel length = new JLabel("Length: " + ((DigitalVideoDisc) media).getLength());
        	JLabel director = new JLabel("Director: " + ((DigitalVideoDisc) media).getDirector());
        	length.setAlignmentX(CENTER_ALIGNMENT);
        	director.setAlignmentX(CENTER_ALIGNMENT);
        	this.add(length);
        	this.add(director);
        }

        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}