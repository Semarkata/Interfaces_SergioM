package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeCenterController {

    @FXML
    private Text textoDinero;

    @FXML
    private Text textoPresentacion;

    @FXML
    private Text tituloText;

    @FXML
    void questionOnClick(MouseEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Question.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            scene.getStylesheets().add("application/styles.css");

            QuestionController controller = loader.getController();
            controller.setStage(stage);
            stage.setScene(scene);
            stage.showAndWait();



        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }


    @FXML
    void initialize() {

        tituloText.setId("textoTitulo");
        textoPresentacion.setId("descripcionTexto");
        textoDinero.setId("dineroTexto");

    }
}
