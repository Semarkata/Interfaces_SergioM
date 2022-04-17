package controller;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class QuestionController {

    @FXML
    private Stage stage;

    @FXML
    private Text envioText;

    @FXML
    private Text misEnviosText;

    @FXML
    private Text perfilText;

    @FXML
    void initialize() {
        assert envioText != null : "fx:id=\"envioText\" was not injected: check your FXML file 'Question.fxml'.";
        assert misEnviosText != null : "fx:id=\"misEnviosText\" was not injected: check your FXML file 'Question.fxml'.";
        assert perfilText != null : "fx:id=\"perfilText\" was not injected: check your FXML file 'Question.fxml'.";

        envioText.getStyleClass().add("letrasAyuda");
        misEnviosText.getStyleClass().add("letrasAyuda");
        perfilText.getStyleClass().add("letrasAyuda");


    }

    public void setStage(Stage primaryStage) {
        stage = primaryStage;

    }
}
