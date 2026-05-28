package hust.soict.globalict.aims.screen;

import javax.naming.LimitExceededException;
import javax.swing.*;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    private JTextField tfAuthor;
    private StoreScreen storeScreen;

    public AddBookToStoreScreen(Store store, StoreScreen storeScreen) {
        super(store, "Add Book");
        this.storeScreen = storeScreen;

        tfAuthor = new JTextField();
        centerPanel.add(new JLabel("Author"));
        centerPanel.add(tfAuthor);
        JButton btnAdd = new JButton("Add Book");
        
        btnAdd.addActionListener(e -> {
            try {
                Book book = new Book(
                        Integer.parseInt(tfId.getText()),
                        tfTitle.getText(),
                        tfCategory.getText(),
                        Float.parseFloat(tfCost.getText())
                );
                book.addAuthor(tfAuthor.getText());
                store.addMedia(book);
                if (storeScreen != null) {
                    storeScreen.refreshStore();
                }
                JOptionPane.showMessageDialog(
                        this,
                        "Book added successfully");

            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Invalid numeric input",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage(),
                        "Validation Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (IllegalStateException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage(),
                        "Store Error",
                        JOptionPane.ERROR_MESSAGE);
            } 
            catch (LimitExceededException ex) {
            	JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage(),
                        "Store Full",
                        JOptionPane.ERROR_MESSAGE);
			}
        });
        add(btnAdd, java.awt.BorderLayout.SOUTH);
        revalidate();
    }
}