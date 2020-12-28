package sample.control.manager;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.control.Controller;
import sample.model.Manager;

import static sample.model.Shop.*;

public class ManagerController extends Controller {
    static Manager cloneSelectedManager;
    @FXML private ListView<Manager> listViewManager;
    @FXML private Label nameLabel;
    @FXML private Label surNameLabel;
    @FXML private Label ageLabel;
    @FXML private Label positionLabel;
    @FXML private Label numberLabel;
    @FXML private Label salaryLabel;
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
        newButton.setOnAction(actionEvent -> createPopup(newButton, "/sample/fxmlFile/manager/addManager.fxml", "Adding"));
        editButton.setOnAction(actionEvent -> createPopup(editButton,"/sample/fxmlFile/manager/editManager.fxml" , "Editing"));
        deleteButton.setOnAction(actionEvent ->  removeManager(listViewManager.getSelectionModel().getSelectedItem()));

        listViewManager.getItems().addAll(listManagers);
        listViewManager.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listViewManager.getSelectionModel().selectedItemProperty().addListener((observableValue, manager, manager1) -> {
            cloneSelectedManager = listViewManager.getSelectionModel().getSelectedItem();
            nameLabel.setText(listViewManager.getSelectionModel().getSelectedItem().getName());
            surNameLabel.setText(listViewManager.getSelectionModel().getSelectedItem().getSurName());
            ageLabel.setText(listViewManager.getSelectionModel().getSelectedItem().getAge());
            positionLabel.setText(listViewManager.getSelectionModel().getSelectedItem().getPosition());
            numberLabel.setText(listViewManager.getSelectionModel().getSelectedItem().getPhoneNumber());
            salaryLabel.setText(listViewManager.getSelectionModel().getSelectedItem().getSalary());
        });
        searchButton.setOnAction(actionEvent -> {
            String search = searchField.getText();
            listViewManager.getItems().removeAll(listManagers);
            listViewManager.getItems().addAll(searchManager(search));
        });
    }
}
