package sample.control.accessories;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static sample.model.Shop.*;

public class AddAccessoriesController {
    @FXML private Button cancelButton;
    @FXML private TextField nameField;
    @FXML private TextField countryField;
    @FXML private TextField priceField;
    @FXML private TextField countField;
    @FXML private TextArea characteristicArea;
    @FXML private Button addButton;
    @FXML void initialize() {
        cancelButton.setOnAction(actionEvent -> {
            Stage stage =(Stage) cancelButton.getScene().getWindow();
            stage.close();
        });
        addButton.setOnAction(actionEvent -> {
            addDevice(listAccessories,nameField.getText(), countryField.getText(), characteristicArea.getText(),
                    priceField.getText(), Integer.parseInt(countField.getText()));
            Stage stage =(Stage) addButton.getScene().getWindow();
            stage.close();
        });
    }

}
