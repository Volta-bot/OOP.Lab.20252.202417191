package hust.soict.globalict.aims.screen;

import java.io.IOException;

import javax.swing.*;
import javafx.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.store.Store;

public class CartScreen extends JFrame {
    private Cart cart;
    private Store store;
    public CartScreen(Cart cart,Store store) {
        super();

        this.cart = cart;
        this.store = store;
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        
        this.setSize(1024, 768);
        this.setTitle("Cart");
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));

                CartScreenController controller = new CartScreenController(cart,store,CartScreen.this);

                loader.setController(controller);

                try {
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}