package controller;

import database.DatabaseConnection;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;


public class RegisterController {

    @FXML
    private AnchorPane bannerHeader;

    @FXML
    private Label tittleBanner;

    @FXML
    private PasswordField confirmPasswordLabel;

    @FXML
    private TextField lastNameLabel;

    @FXML
    private TextField nameLabel;

    @FXML
    private PasswordField passwordLabel;

    @FXML
    private TextField usernameLabel;

    @FXML
    private Button closeBtn;

    @FXML
    private Stage stage;

    @FXML
    private Button confirmBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private Label registrationMessageLabel;

    @FXML
    private Label confirmPasswordText;

    @FXML
    private BorderPane container;

    Alert noIguales = new Alert(Alert.AlertType.ERROR);
    Alert creado = new Alert(Alert.AlertType.INFORMATION);
    Alert faltanDatos = new Alert(Alert.AlertType.WARNING);



    @FXML
    void initialize() {

        assert bannerHeader != null : "fx:id=\"bannerHeader\" was not injected: check your FXML file 'Register.fxml'.";
        assert confirmPasswordLabel != null : "fx:id=\"confrimPasswordLabel\" was not injected: check your FXML file 'Register.fxml'.";
        assert lastNameLabel != null : "fx:id=\"lastNameLabel\" was not injected: check your FXML file 'Register.fxml'.";
        assert nameLabel != null : "fx:id=\"nameLabel\" was not injected: check your FXML file 'Register.fxml'.";
        assert passwordLabel != null : "fx:id=\"passwordLabel\" was not injected: check your FXML file 'Register.fxml'.";
        assert tittleBanner != null : "fx:id=\"tittleBanner\" was not injected: check your FXML file 'Register.fxml'.";
        assert usernameLabel != null : "fx:id=\"usernameLabel\" was not injected: check your FXML file 'Register.fxml'.";
        assert closeBtn != null : "fx:id=\"closeBtn\" was not injected: check your FXML file 'Register.fxml'.";
        assert confirmBtn != null : "fx:id=\"confirmBtn\" was not injected: check your FXML file 'Register.fxml'.";
        assert loginBtn != null : "fx:id=\"loginBtn\" was not injected: check your FXML file 'Register.fxml'.";
        assert registrationMessageLabel != null : "fx:id=\"registrationMessageLabel\" was not injected: check your FXML file 'Register.fxml'.";
        assert confirmPasswordText != null : "fx:id=\"confirmPasswordText\" was not injected: check your FXML file 'Register.fxml'.";

        bannerHeader.getStyleClass().add("background");

        tittleBanner.setId("titulos");

        closeBtn.getStyleClass().add("btn");

        confirmBtn.getStyleClass().add("btn");

        loginBtn.getStyleClass().add("btn");

        registrationMessageLabel.setId("textoConfirm");

        confirmPasswordText.getStyleClass().add("textoError");

        noIguales.setTitle("Error");
        noIguales.setHeaderText("No son iguales");
        noIguales.setContentText("Las contraseñas introducidas no son iguales");

        creado.setTitle("Creado");
        creado.setHeaderText("Se ha creado el usuario");
        creado.setContentText("El usuario se ha creado con los datos introducidos");

        faltanDatos.setTitle("Cuidado");
        faltanDatos.setHeaderText("Faltan datos");
        faltanDatos.setContentText("Faltan datos por introducir");

        container.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    registerButtomOnAction();
                }
            }
        });

    }

    public void setStage(Stage primaryStage) {
        stage = primaryStage;

    }




    public void loginBtnOnAction(javafx.event.ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Login.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            scene.getStylesheets().add("application/styles.css");

            LoginController controller = loader.getController();
            controller.setStage(stage);
            stage.setScene(scene);
            stage.show();

            Stage stageToClose = (Stage) loginBtn.getScene().getWindow();
            stageToClose.close();

        } catch (Exception e) {

            e.printStackTrace();
            e.getCause();

        }

    }

    public void closeBtnOnAction(javafx.event.ActionEvent event) {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();

    }


    public void registerButtomOnAction(javafx.event.ActionEvent event) {
        register();

    }


    public void registerButtomOnAction() {
        register();
    }

        public void registerUser() {

        DatabaseConnection dc = new DatabaseConnection();
        Connection con = dc.getConnection();

        String firstname = nameLabel.getText();
        String lastname = lastNameLabel.getText();
        String username = usernameLabel.getText();
        String password = passwordLabel.getText();

        String insertFields = "INSERT INTO usuarios(nombre, apellido, username,password) VALUES ('";
        String insertValues = firstname + "','" + lastname + "','" + username + "','" + password + "')";
        String insertToRegister = insertFields + insertValues;

        try {

            Statement stmt = con.createStatement();
            stmt.executeUpdate(insertToRegister);
            creado.showAndWait();
            redirect();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    public void redirect() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Login.fxml"));
            Parent root = loader.load();



            Scene scene = new Scene(root);
            Stage stage1 = new Stage();
            LoginController controller = loader.getController();
            controller.setStage(stage1);
            scene.getStylesheets().add("application/styles.css");
            stage1.setScene(scene);
            stage1.show();
            this.stage.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void register(){
        if (nameLabel.getText().isBlank() == false
                && lastNameLabel.getText().isBlank() == false
                && usernameLabel.getText().isBlank() == false
                && passwordLabel.getText().isBlank() == false
                && confirmPasswordLabel.getText().isBlank() == false) {
            registrationMessageLabel.setText("");
            if (passwordLabel.getText().equals(confirmPasswordLabel.getText())) {


                registerUser();


            } else {
                noIguales.showAndWait();
            }

        } else {

            faltanDatos.showAndWait();
        }
    }

}
