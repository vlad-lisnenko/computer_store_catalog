package sample.control.manager;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static sample.model.Shop.addManager;

public class AddManagerController {
    @FXML private Button cancelButton;
    @FXML private TextField nameField;
    @FXML private TextField surnameField;
    @FXML private TextField ageField;
    @FXML private TextField positionField;
    @FXML private TextField numberField;
    @FXML private TextField salaryField;
    @FXML private Button addButton;
    @FXML void initialize() {
        cancelButton.setOnAction(actionEvent -> {
            Stage stage =(Stage) cancelButton.getScene().getWindow();
            stage.close();
        });
        addButton.setOnAction(actionEvent -> {
          addManager(nameField.getText(), surnameField.getText(), ageField.getText(),
                  positionField.getText(), numberField.getText(), salaryField.getText());
            Stage stage =(Stage) cancelButton.getScene().getWindow();
            stage.close();
        });
    }
}
