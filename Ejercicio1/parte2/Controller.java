package Ejercicio1.parte2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class Controller {

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private FlowPane contenedor;

    @FXML
    void initialize() {
        assert button1 != null : "fx:id=\"button1\" was not injected: check your FXML file 'FlowPaneLayout.fxml'.";
        assert button2 != null : "fx:id=\"button2\" was not injected: check your FXML file 'FlowPaneLayout.fxml'.";
        assert contenedor != null : "fx:id=\"contenedor\" was not injected: check your FXML file 'FlowPaneLayout.fxml'.";


        button1.getStyleClass().add("big");

        button2.setId("small");

        contenedor.setId("orientation");



    }
}
