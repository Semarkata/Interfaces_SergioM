package Ejercicio1.parte1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class Controller {

    @FXML
    private Button button1;

    @FXML
    private Button button2;



    @FXML
    void initialize() {
        assert button1 != null : "fx:id=\"button1\" was not injected: check your FXML file 'FlowPaneLayout.fxml'.";
        assert button2 != null : "fx:id=\"button2\" was not injected: check your FXML file 'FlowPaneLayout.fxml'.";


        button1.getStyleClass().add("big");

        button2.setId("small");

    }
}
