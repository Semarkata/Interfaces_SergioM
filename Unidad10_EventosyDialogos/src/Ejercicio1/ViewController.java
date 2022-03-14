package Ejercicio1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;


public class ViewController {

    @FXML
    private TextField userInput;

    @FXML
    void abrirTexto(ActionEvent event) {
        TextInputDialog textDialog = new TextInputDialog("Texto de ejemplo...");
        textDialog.setTitle("Ejemplo de diálogo");
        textDialog.setHeaderText("Diálogo para introducir un texto");

        textDialog.showAndWait().ifPresent(response -> {
            userInput.setText(response);
        });
    }

    @FXML
    void initialize() {

    }
}
