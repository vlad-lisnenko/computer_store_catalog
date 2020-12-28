package sample.control.computer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static sample.model.Shop.editDevice;

public class EditComputerController extends ComputerController{
    @FXML private Button cancelButton;
    @FXML private TextField nameField;
    @FXML private TextField countryField;
    @FXML private TextField priceField;
    @FXML private TextField countField;
    @FXML private TextArea characteristicArea;
    @FXML private Button editButton;
    @FXML void initialize() {
        try {
            nameField.setText(cloneSelectedComputer.getName());
            countryField.setText(cloneSelectedComputer.getCountryOfManufacture());
            priceField.setText(cloneSelectedComputer.getPrice());
            characteristicArea.setText(cloneSelectedComputer.getCharacteristic());
            countField.setText(String.valueOf(cloneSelectedComputer.getCount()));
            editButton.setOnAction(actionEvent -> {
                editDevice(cloneSelectedComputer, nameField.getText(), countryField.getText(), characteristicArea.getText(),
                        priceField.getText(), Integer.parseInt(countField.getText()));
                Stage stage =(Stage) editButton.getScene().getWindow();
                stage.close();
            });
        }catch (NullPointerException exception){
            System.out.println(exception.getMessage());
        }
        cancelButton.setOnAction(actionEvent -> {
            Stage stage =(Stage) cancelButton.getScene().getWindow();
            stage.close();
        });
    }
}
