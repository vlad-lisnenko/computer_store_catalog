package sample.control.accessories;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.control.Controller;
import sample.model.Device;

import static sample.model.Shop.*;

public class AccessoriesController extends Controller {
    static Device cloneSelectedAccessories;
    @FXML private ListView<Device> listViewAccessories;
    @FXML private Label nameLabel;
    @FXML private Label countryLabel;
    @FXML private Label charactLabel;
    @FXML private Label priceLabel;
    @FXML private Label countLabel;
    @FXML private Button managersButton;
    @FXML private Button computersButton;
    @FXML private Button accessoriesButton;
    @FXML private Button shopButton;
    @FXML private Button deleteButton;
    @FXML private Button editButton;
    @FXML private Button newButton;
    @FXML private TextField searchField;
    @FXML private Button searchButton;
    @FXML void initialize() {
        managersButton.setOnAction(actionEvent -> changePageEvent(managersButton, "/sample/fxmlFile/manager/managers.fxml"));
        accessoriesButton.setOnAction(actionEvent -> changePageEvent(accessoriesButton, "/sample/fxmlFile/accessories/accessories.fxml"));
        computersButton.setOnAction(actionEvent -> changePageEvent(computersButton, "/sample/fxmlFile/computer/computers.fxml"));
        shopButton.setOnAction(actionEvent -> changePageEvent(shopButton, "/sample/fxmlFile/main.fxml"));
        newButton.setOnAction(actionEvent -> createPopup(newButton, "/sample/fxmlFile/accessories/addAccessories.fxml", "Adding"));
        editButton.setOnAction(actionEvent -> createPopup(editButton,"/sample/fxmlFile/accessories/editAccessories.fxml" , "Editing"));
        deleteButton.setOnAction(actionEvent ->  removeDevice(listViewAccessories.getSelectionModel().getSelectedItem(), listAccessories));

        listViewAccessories.getItems().addAll(listAccessories);
        listViewAccessories.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listViewAccessories.getSelectionModel().selectedItemProperty().addListener((observableValue, accessories, t1) -> {
            cloneSelectedAccessories = listViewAccessories.getSelectionModel().getSelectedItem();
            nameLabel.setText(listViewAccessories.getSelectionModel().getSelectedItem().getName());
            countryLabel.setText(listViewAccessories.getSelectionModel().getSelectedItem().getCountryOfManufacture());
            charactLabel.setText(listViewAccessories.getSelectionModel().getSelectedItem().getCharacteristic());
            priceLabel.setText(listViewAccessories.getSelectionModel().getSelectedItem().getPrice());
            countLabel.setText(String.valueOf(listViewAccessories.getSelectionModel().getSelectedItem().getCount()));
        });
        searchButton.setOnAction(actionEvent -> {
            String search = searchField.getText();
            listViewAccessories.getItems().removeAll(listAccessories);
            listViewAccessories.getItems().addAll(searchDevice(listAccessories, search));
        });
    }
}
