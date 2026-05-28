package hust.soict.globalict.aims.screen;

import javax.swing.*;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen
        extends AddItemToStoreScreen {

    private JTextField tfDirector;
    private JTextField tfLength;
    private StoreScreen storeScreen;
    public AddDigitalVideoDiscToStoreScreen(Store store, StoreScreen storeScreen) {

        super(store, "Add DVD");
        this.storeScreen = storeScreen;
        tfDirector = new JTextField();
        tfLength = new JTextField();

        centerPanel.add(new JLabel("Director"));
        centerPanel.add(tfDirector);

        centerPanel.add(new JLabel("Length"));
        centerPanel.add(tfLength);

        JButton btnAdd = new JButton("Add DVD");

        btnAdd.addActionListener(e -> {

            DigitalVideoDisc dvd =
                    new DigitalVideoDisc(
                            Integer.parseInt(tfId.getText()),
                            tfTitle.getText(),
                            tfCategory.getText(),
                            Float.parseFloat(tfCost.getText()),
                            Integer.parseInt(tfLength.getText()),
                            tfDirector.getText()
                    );

            store.addMedia(dvd);
            if(storeScreen != null) storeScreen.refreshStore();
            JOptionPane.showMessageDialog(
                    this,
                    "DVD added successfully");
        });

        add(btnAdd, java.awt.BorderLayout.SOUTH);

        revalidate();
    }
}