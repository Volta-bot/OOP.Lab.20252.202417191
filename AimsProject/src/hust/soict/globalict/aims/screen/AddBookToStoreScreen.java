package hust.soict.globalict.aims.screen;

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

            Book book = new Book(
                    Integer.parseInt(tfId.getText()),
                    tfTitle.getText(),
                    tfCategory.getText(),
                    Float.parseFloat(tfCost.getText())
            );

            book.addAuthor(tfAuthor.getText());

            store.addMedia(book);
            if(storeScreen != null) storeScreen.refreshStore();
            JOptionPane.showMessageDialog(
                    this,
                    "Book added successfully");
        });

        add(btnAdd, java.awt.BorderLayout.SOUTH);

        revalidate();
    }
}