package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

    private Cart cart;
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    
    @FXML
    private TableView<Media> tblMedia;

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

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }
    
    private FilteredList<Media> filteredMedia;
    
    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title"));

        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category"));

        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost"));

        filteredMedia = new FilteredList<>(cart.getItemsOrdered(),media -> true);
        tblMedia.setItems(filteredMedia);
        
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
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
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
    }
}