package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class HomeController {


    private int user_Id = LoginController.getUser_Id();

    @FXML
    private Button exitBtn;

    @FXML
    private Button misEnviosBtn;

    @FXML
    private Button nuevoEnvioBtn;

    @FXML
    private Button perfilBtn;

    @FXML
    private ImageView boxImage;

    @FXML
    private AnchorPane navBar;

    @FXML
    private Text textoDinero;

    @FXML
    private Text textoPresentacion;

    @FXML
    private Text tituloText;

    @FXML
    private ImageView questionImg;

    @FXML
    private Button ayudaBtn;

    @FXML
    void nuevoEnvioOnAction(ActionEvent event) {

        BorderPane bp = (BorderPane) nuevoEnvioBtn.getScene().getRoot();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/NuevoEnvio.fxml"));

        try {
            bp.setCenter(new AnchorPane((Parent) fxmlLoader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void perfilOnAction(ActionEvent event) {

        BorderPane bp = (BorderPane) perfilBtn.getScene().getRoot();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/Perfil.fxml"));

        try {
            bp.setCenter(new AnchorPane((Parent) fxmlLoader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void verEnviosOnAction(ActionEvent event) {
        BorderPane bp = (BorderPane) misEnviosBtn.getScene().getRoot();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/VerEnvios.fxml"));

        try {
            bp.setCenter(new AnchorPane((Parent) fxmlLoader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void exitOnAction(ActionEvent event) {

        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void imageOnClick(MouseEvent event) {
        BorderPane bp = (BorderPane) boxImage.getScene().getRoot();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/HomeCenter.fxml"));

        try {
            bp.setCenter(new AnchorPane((Parent) fxmlLoader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


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
        assert boxImage != null : "fx:id=\"boxImage\" was not injected: check your FXML file 'Home.fxml'.";
        assert exitBtn != null : "fx:id=\"exitBtn\" was not injected: check your FXML file 'Home.fxml'.";
        assert misEnviosBtn != null : "fx:id=\"misEnviosBtn\" was not injected: check your FXML file 'Home.fxml'.";
        assert navBar != null : "fx:id=\"navBar\" was not injected: check your FXML file 'Home.fxml'.";
        assert nuevoEnvioBtn != null : "fx:id=\"nuevoEnvioBtn\" was not injected: check your FXML file 'Home.fxml'.";
        assert perfilBtn != null : "fx:id=\"perfilBtn\" was not injected: check your FXML file 'Home.fxml'.";


//        prueba.setOnAction(e -> {
//            infoAlert.showAndWait();
//        });


        navBar.getStyleClass().add("background");
        tituloText.setId("textoTitulo");
        textoPresentacion.setId("descripcionTexto");
        textoDinero.setId("dineroTexto");


    }

}
