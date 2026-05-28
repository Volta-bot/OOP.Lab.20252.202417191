package hust.soict.globalict.aims.screen;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	private Store store;
    private Cart cart;
    private JFrame frame;
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    
    @FXML
    private TableView<Media> tblMedia;
    
    @FXML
    private TableColumn<Media, Integer> colMediaId;
    
    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;
    
    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;
    
    @FXML
    private Label lblTotalCost;

    public CartScreenController(Cart cart, Store store, JFrame frame) {
        super();
        this.store = store;
        this.cart = cart;
        this.frame = frame;
    }
    
    private FilteredList<Media> filteredMedia;
    
    @FXML
    private void initialize() {
    	colMediaId.setCellValueFactory(
    			new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost"));
        filteredMedia = new FilteredList<>(cart.getItemsOrdered(),media -> true);
        tblMedia.setItems(filteredMedia);
        updateTotalCost();
        
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {

                @Override
                public void changed(
                        ObservableValue<? extends Media> observable,
                        Media oldValue,
                        Media newValue) {

                    if (newValue != null) {
                        updateButtonBar(newValue);
                    }
                }
            });
        tfFilter.textProperty().addListener(
        	    (observable, oldValue, newValue) -> {
        	        showFilteredMedia(newValue);
        	    });
    }
    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media =
            tblMedia.getSelectionModel().getSelectedItem();

        if (media != null) {
            cart.removeMedia(media);
            updateTotalCost();   
        }
    }
    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }
    private void showFilteredMedia(String filterText) {

        if (filterText == null || filterText.isEmpty()) {
            filteredMedia.setPredicate(media -> true);
            return;
        }

        String keyword = filterText.toLowerCase();

        if (radioBtnFilterTitle.isSelected()) {

            filteredMedia.setPredicate(media ->
                media.getTitle().toLowerCase().contains(keyword));

        } else {

            filteredMedia.setPredicate(media ->
                String.valueOf(media.getId()).contains(keyword));

        }
    }
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        cart.emptyCart();
        updateTotalCost();
    }
    private void updateTotalCost() {
        lblTotalCost.setText(cart.totalCost() + " $");
    }
    @FXML
    void menuViewStorePressed(ActionEvent event) {
    	frame.setVisible(false);
        new StoreScreen(store,cart);
    }
    @FXML
    void menuAddBookPressed(ActionEvent event) {
        new AddBookToStoreScreen(store, null);
    }
    @FXML
    void menuAddCDPressed(ActionEvent event) {
        new AddCompactDiscToStoreScreen(store, null);
    }
    @FXML
    void menuAddDVDPressed(ActionEvent event) {
        new AddDigitalVideoDiscToStoreScreen(store, null);
    }
}