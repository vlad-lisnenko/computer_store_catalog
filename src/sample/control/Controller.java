package sample.control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import static sample.model.Shop.*;

public class Controller{

    ObservableList<String> mainDepartmentList = FXCollections.observableArrayList("Info", "Report");

    String infoStr = "This program allows you to keep records of managers and goods in the computer shop Fiksyk.\n"
            +"You can see and edit all information about the products and sellers that work there.\n";

    String reportStr = "The store has: "+ (getCount(listComputers) + getCount(listAccessories)) +" goods\n" +
            "Computers: " + getCount(listComputers)  + "\n" +
            "Accessories: "+ getCount(listAccessories) + "\n" +
            "Managers: " + listManagers.size() + "\n";

    @FXML private ComboBox<String> listComboBox;
    @FXML private Button updateButton;
    @FXML private Label labelArea;
    @FXML private Button managersButton;
    @FXML private Button computersButton;
    @FXML private Button accessoriesButton;
    @FXML private Button shopButton;
    @FXML void initialize() {
        managersButton.setOnAction(actionEvent -> changePageEvent(managersButton, "/sample/fxmlFile/manager/managers.fxml"));
        accessoriesButton.setOnAction(actionEvent -> changePageEvent(accessoriesButton, "/sample/fxmlFile/accessories/accessories.fxml"));
        computersButton.setOnAction(actionEvent -> changePageEvent(computersButton, "/sample/fxmlFile/computer/computers.fxml"));
        shopButton.setOnAction(actionEvent -> changePageEvent(shopButton, "/sample/fxmlFile/main.fxml"));

        listComboBox.setItems(mainDepartmentList);

        Label lbl = new Label();
        listComboBox.setOnAction(actionEvent -> lbl.setText(listComboBox.getValue()));

        labelArea.setWrapText(true);
        updateButton.setOnAction(actionEvent -> {
            if(listComboBox.getValue().equals("Info")) labelArea.setText(infoStr);
            if(listComboBox.getValue().equals("Report")) labelArea.setText(reportStr);
        });

    }
    public void createPopup(Button button, String url, String title){
        FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
        Parent root = null;
        try{
            root = loader.load();
        }catch (IOException e){
            e.printStackTrace();
        }
        Stage newWindow = new Stage();
        newWindow.setTitle(title);
        assert root != null;
        newWindow.setScene(new Scene(root));
        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.initOwner(button.getScene().getWindow());
        newWindow.show();
    }

    public void changePageEvent(Button button, String url){
        Stage stage = (Stage) button.getScene().getWindow();
        // do what you have to do
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(url));
        Parent root1 = null;
        try {
            root1 = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        assert root1 != null;
        stage.setScene(new Scene(root1));
        stage.setTitle("Fiksyk Shop");
        stage.setResizable(false);
        stage.show();
    }
}
