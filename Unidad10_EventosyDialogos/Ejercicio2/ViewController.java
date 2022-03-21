package Ejercicio2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Locale;


public class ViewController {

    @FXML
    private TextField userInput;

    @FXML
    void abrirTexto(ActionEvent event) {
        TextInputDialog textDialog = new TextInputDialog("");
        textDialog.setTitle("Ejemplo de diálogo");
        textDialog.setHeaderText("Diálogo para introducir un texto");

        textDialog.getDialogPane().addEventFilter(KeyEvent.KEY_TYPED, e->{

            if(!e.getCharacter().equals(e.getCharacter().toUpperCase())){
                System.out.println("No puedes mayuscula");
                e.consume();
            }
        });

        textDialog.showAndWait().ifPresent(response -> {

            userInput.setText(response);
        });



    }



    @FXML
    void initialize() {

    }







}
