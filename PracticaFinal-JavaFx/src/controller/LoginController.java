package controller;

import database.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {

    @FXML
    private BorderPane container;

    @FXML
    private Text TituloLogin;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private Label textoError;

    @FXML
    private AnchorPane derecha;

    @FXML
    private Hyperlink link;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Button registerBtn;

    @FXML
    private Stage stage;

    private static int user_Id;


    public void setStage(Stage primaryStage) {
        stage = primaryStage;

    }

    public static int getUser_Id() {
        return user_Id;
    }

    Alert camposNecesarios = new Alert(Alert.AlertType.WARNING);

    Alert camposErroneos = new Alert(Alert.AlertType.ERROR);


    public void loginBtnOnAction(ActionEvent event) {

        login();

    }

    public void loginBtnOnAction() {

        login();
    }


    public boolean validateLogin() {

        DatabaseConnection conn = new DatabaseConnection();

        Connection connecDB = conn.getConnection();

        String verifyLogin = "SELECT count(1) FROM usuarios WHERE username = '" + usernameTextField.getText() + "' AND password = '" + passwordField.getText() + "'";

        try {

            Statement stmt = connecDB.createStatement();
            ResultSet queryResult = stmt.executeQuery(verifyLogin);

            while (queryResult.next()) {

                if (queryResult.getInt(1) == 1) {
                    textoError.setText("Correcto");
                    user_Id = getId(connecDB);
                    return true;
                } else {
                    camposErroneos.showAndWait();
                    return false;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return false;
    }


    private int getId(Connection con) {

        String selectQuery = "SELECT userId FROM usuarios WHERE username = '" + usernameTextField.getText() + "'";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);

            int userId = 0;
            while (rs.next()) {
                userId = rs.getInt("userId");
//                 System.out.println(userId);
            }

            return userId;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }


    public void registerBtnOnAction(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Register.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            scene.getStylesheets().add("application/styles.css");

            RegisterController controller = loader.getController();
            controller.setStage(stage);
            stage.setScene(scene);
            stage.show();

            Stage stageToClose = (Stage) registerBtn.getScene().getWindow();
            stageToClose.close();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }


    public void cancelBtnOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }


    private void login() {
        if (usernameTextField.getText().isBlank() == false && passwordField.getText().isBlank() == false) {
            if (validateLogin()) {
                try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Home.fxml"));
                    Parent root = loader.load();

                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    scene.getStylesheets().add("application/styles.css");
                    stage.show();

                    Stage stageClose = (Stage) loginBtn.getScene().getWindow();
                    stageClose.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } else {
            camposNecesarios.showAndWait();
        }
    }

    @FXML
    void initialize() {
        assert TituloLogin != null : "fx:id=\"TituloLogin\" was not injected: check your FXML file 'Login.fxml'.";
        assert cancelBtn != null : "fx:id=\"cancelBtn\" was not injected: check your FXML file 'Login.fxml'.";
        assert derecha != null : "fx:id=\"derecha\" was not injected: check your FXML file 'Login.fxml'.";
        assert link != null : "fx:id=\"link\" was not injected: check your FXML file 'Login.fxml'.";
        assert loginBtn != null : "fx:id=\"loginBtn\" was not injected: check your FXML file 'Login.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'Login.fxml'.";
        assert textoError != null : "fx:id=\"textoError\" was not injected: check your FXML file 'Login.fxml'.";
        assert usernameTextField != null : "fx:id=\"usernameTextField\" was not injected: check your FXML file 'Login.fxml'.";
        assert registerBtn != null : "fx:id=\"registerBtn\" was not injected: check your FXML file 'Login.fxml'.";
        assert container != null : "fx:id=\"container\" was not injected: check your FXML file 'Login.fxml'.";


        derecha.getStyleClass().add("background");

        TituloLogin.setId("titulos");

        link.setId("link");

        loginBtn.getStyleClass().add("btn");

        textoError.getStyleClass().add("textoError");

        cancelBtn.getStyleClass().add("btn");

        registerBtn.getStyleClass().add("btn");

        camposNecesarios.setTitle("Alerta");
        camposNecesarios.setHeaderText("Campos necesarios");
        camposNecesarios.setContentText("Es necesario que ingreses el usuario y la contraseña");

        camposErroneos.setTitle("Error");
        camposErroneos.setHeaderText("Error en credenciales");
        camposErroneos.setContentText("El usuario o la contraseña no coincide");

        container.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    loginBtnOnAction();
                }
            }
        });

    }


}
