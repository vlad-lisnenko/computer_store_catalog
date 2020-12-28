package sample.control.accessories;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static sample.model.Shop.editDevice;

public class EditAccessoriesController extends AccessoriesController {
    @FXML private Button cancelButton;
    @FXML private TextField nameField;
    @FXML private TextField countryField;
    @FXML private TextField priceField;
    @FXML private TextField availabilityField;
    @FXML private TextArea characteristicArea;
    @FXML private Button editButton;
    @FXML void initialize() {
        try {
            nameField.setText(cloneSelectedAccessories.getName());
            countryField.setText(cloneSelectedAccessories.getCountryOfManufacture());
            priceField.setText(cloneSelectedAccessories.getPrice());
            characteristicArea.setText(cloneSelectedAccessories.getCharacteristic());
            availabilityField.setText(String.valueOf(cloneSelectedAccessories.getCount()));
            editButton.setOnAction(actionEvent -> {
                editDevice(cloneSelectedAccessories, nameField.getText(), countryField.getText(), characteristicArea.getText(),
                        priceField.getText(), Integer.parseInt(availabilityField.getText()));
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
