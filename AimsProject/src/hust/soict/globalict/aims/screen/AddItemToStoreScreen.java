package hust.soict.globalict.aims.screen;

import java.awt.*;
import javax.swing.*;

import hust.soict.globalict.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {

    protected Store store;

    protected JTextField tfId;
    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost;

    protected JPanel centerPanel;

    public AddItemToStoreScreen(Store store, String screenTitle) {
        this.store = store;

        setTitle(screenTitle);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0, 2, 5, 5));

        tfId = new JTextField();
        tfTitle = new JTextField();
        tfCategory = new JTextField();
        tfCost = new JTextField();

        centerPanel.add(new JLabel("ID"));
        centerPanel.add(tfId);

        centerPanel.add(new JLabel("Title"));
        centerPanel.add(tfTitle);

        centerPanel.add(new JLabel("Category"));
        centerPanel.add(tfCategory);

        centerPanel.add(new JLabel("Cost"));
        centerPanel.add(tfCost);

        cp.add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}