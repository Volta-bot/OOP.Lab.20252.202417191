package hust.soict.globalict.aims.screen;

import javax.naming.LimitExceededException;
import javax.swing.*;

import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector;
    private JTextField tfArtist;
    private StoreScreen storeScreen;

    public AddCompactDiscToStoreScreen(Store store, StoreScreen storeScreen) {
        super(store, "Add CD");
        this.storeScreen = storeScreen;

        tfDirector = new JTextField();
        tfArtist = new JTextField();

        centerPanel.add(new JLabel("Director"));
        centerPanel.add(tfDirector);

        centerPanel.add(new JLabel("Artist"));
        centerPanel.add(tfArtist);

        JButton btnAdd = new JButton("Add CD");
        btnAdd.addActionListener(e -> {
            try {
                CompactDisc cd =
                        new CompactDisc(
                                Integer.parseInt(tfId.getText()),
                                tfTitle.getText(),
                                tfCategory.getText(),
                                Float.parseFloat(tfCost.getText()),
                                tfDirector.getText(),
                                tfArtist.getText()
                        );
                store.addMedia(cd);
                if (storeScreen != null) {
                    storeScreen.refreshStore();
                }
                JOptionPane.showMessageDialog(
                        this,
                        "CD added successfully");
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