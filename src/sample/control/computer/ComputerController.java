package sample.control.computer;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.control.Controller;
import sample.model.Device;

import static sample.model.Shop.*;

public class ComputerController  extends Controller {
    static Device cloneSelectedComputer;
    @FXML public ListView<Device> listViewComputers;
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
        newButton.setOnAction(actionEvent -> createPopup(newButton, "/sample/fxmlFile/computer/addComputer.fxml", "Adding"));
        editButton.setOnAction(actionEvent -> createPopup(editButton, "/sample/fxmlFile/computer/editComputer.fxml", "Editing"));
        deleteButton.setOnAction(actionEvent -> removeDevice(listViewComputers.getSelectionModel().getSelectedItem(), listComputers));

        listViewComputers.getItems().addAll(listComputers);
        listViewComputers.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listViewComputers.getSelectionModel().selectedItemProperty().addListener((observableValue, computer, t1) -> {
            cloneSelectedComputer = listViewComputers.getSelectionModel().getSelectedItem();
            nameLabel.setText(listViewComputers.getSelectionModel().getSelectedItem().getName());
            countryLabel.setText(listViewComputers.getSelectionModel().getSelectedItem().getCountryOfManufacture());
            charactLabel.setText(listViewComputers.getSelectionModel().getSelectedItem().getCharacteristic());
            priceLabel.setText(listViewComputers.getSelectionModel().getSelectedItem().getPrice());
            countLabel.setText(String.valueOf(listViewComputers.getSelectionModel().getSelectedItem().getCount()));
        });
        searchButton.setOnAction(actionEvent -> {
            String search = searchField.getText();
            listViewComputers.getItems().removeAll(listComputers);
            listViewComputers.getItems().addAll(searchDevice(listComputers, search));
        });
    }
}
