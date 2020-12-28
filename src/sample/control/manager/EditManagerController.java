package sample.control.manager;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static sample.model.Shop.editManager;

public class EditManagerController extends ManagerController{
    @FXML private Button cancelButton;
    @FXML private TextField nameField;
    @FXML private TextField surnameField;
    @FXML private TextField ageField;
    @FXML private TextField positionField;
    @FXML private TextField numberField;
    @FXML private TextField salaryField;
    @FXML private Button editButton;
    @FXML void initialize() {
        try {
            nameField.setText(cloneSelectedManager.getName());
            surnameField.setText(cloneSelectedManager.getSurName());
            ageField.setText(cloneSelectedManager.getAge());
            positionField.setText(cloneSelectedManager.getPosition());
            numberField.setText(cloneSelectedManager.getPhoneNumber());
            salaryField.setText(cloneSelectedManager.getSalary());
            editButton.setOnAction(actionEvent -> {
                editManager(cloneSelectedManager, nameField.getText(), surnameField.getText(), ageField.getText(),
                        positionField.getText(), numberField.getText(), salaryField.getText());
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
