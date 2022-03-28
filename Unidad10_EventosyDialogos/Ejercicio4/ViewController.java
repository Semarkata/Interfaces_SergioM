package Ejercicio4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.util.List;


public class ViewController {

    @FXML
    private ListView<String> lista;

    @FXML
    private Button mostrar;

    @FXML
    void initialize() {
        assert lista != null : "fx:id=\"lista\" was not injected: check your FXML file 'MainView.fxml'.";
        assert mostrar != null : "fx:id=\"mostrar\" was not injected: check your FXML file 'MainView.fxml'.";

       for(int i = 1; i<=10; i++)
        lista.getItems().add("Opcion"+i);

       lista.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

       mostrar.setOnAction(e -> {
           List<String> dialogData = lista.getSelectionModel().getSelectedItems();
           ChoiceDialog<String> choiceDialog = new ChoiceDialog<String>(dialogData.get(0),dialogData);

           choiceDialog.setTitle("Ejemplo de dialogo");
           choiceDialog.setHeaderText("Selecciona un valor...");

           choiceDialog.showAndWait().ifPresent(response -> {
               lista.getSelectionModel().clearSelection();
               lista.getSelectionModel().select(response);

           });

       });

    }




}
