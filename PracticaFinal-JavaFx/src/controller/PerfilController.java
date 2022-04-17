package controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class PerfilController {

    @FXML
    private TextField lastNameLabel;

    @FXML
    private TextField nameLabel;

    @FXML
    private TextField usernameLabel;

    @FXML
    private Text welcomeText;

    @FXML
    private Button saveBtn;

    @FXML
    private Text cambioPasswordText;

    @FXML
    private Button cambiarPasswordBtn;

    @FXML
    private PasswordField passActualLabel;

    @FXML
    private PasswordField passNuevaLabel;

    private int user_Id = LoginController.getUser_Id();

    private String nombre;

    private String apellido;

    private String nombreDeUsuario;


    private String password;

    Alert confirmChange = new Alert(Alert.AlertType.CONFIRMATION);
    Alert noCambios = new Alert(Alert.AlertType.INFORMATION);

    Alert noDataPassword = new Alert(Alert.AlertType.WARNING);

    Alert passsDiferente = new Alert(Alert.AlertType.ERROR);

    Alert cambioCorrecto = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    void initialize() {
        assert lastNameLabel != null : "fx:id=\"lastNameLabel\" was not injected: check your FXML file 'Perfil.fxml'.";
        assert nameLabel != null : "fx:id=\"nameLabel\" was not injected: check your FXML file 'Perfil.fxml'.";
        assert usernameLabel != null : "fx:id=\"usernameLabel\" was not injected: check your FXML file 'Perfil.fxml'.";
        assert welcomeText != null : "fx:id=\"welcomeText\" was not injected: check your FXML file 'Perfil.fxml'.";

        confirmChange.setTitle("Cambio");
        confirmChange.setHeaderText("Cambio de datos");
        confirmChange.setContentText("Si usted esta seguro de cambiar los datos, pulse aceptar");

        noCambios.setTitle("Cambio");
        noCambios.setHeaderText("Cambio de datos");
        noCambios.setContentText("No ha habiado datos que se hayan cambiado");

        noDataPassword.setTitle("Error");
        noDataPassword.setHeaderText("Rellena todos los datos");
        noDataPassword.setContentText("Si quiere cambiar la contraseña, rellene con la contraseña actual y la nueva");

        passsDiferente.setTitle("Error");
        passsDiferente.setHeaderText("Ha ocurrido un error");
        passsDiferente.setContentText("La contraseña actual no coincide con la introducida");


        cambioCorrecto.setTitle("Correcto");
        cambioCorrecto.setHeaderText("Se ha cambiado con exito");
        cambioCorrecto.setContentText("Los datos introducidos se han cambiado con exito");

        getData();


        welcomeText.setText("Bienvenido " + nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase());
        welcomeText.setId("bannerBienvenida");
        cambioPasswordText.setId("textCambioPassword");


        nameLabel.setText(nombre);
        lastNameLabel.setText(apellido);
        usernameLabel.setText(nombreDeUsuario);


        saveBtn.setOnAction(e -> {

                    if ((!nameLabel.getText().toString().equalsIgnoreCase(this.nombre))
                            || !(lastNameLabel.getText().toString().equalsIgnoreCase(this.apellido))
                            || !(usernameLabel.getText().toString().equalsIgnoreCase(this.nombreDeUsuario))) {
                        confirmChange.showAndWait().ifPresent(response -> {
                            if (response == ButtonType.OK) {
                                updateData(nameLabel.getText().toString(), lastNameLabel.getText().toString(), usernameLabel.getText().toString(), Integer.toString(user_Id));
                                cambioCorrecto.showAndWait();
                            }
                        });
                    } else {
                        noCambios.showAndWait();
                    }

                }
        );

        cambiarPasswordBtn.setOnAction(e -> {
            if (passActualLabel.getText().isBlank() == false && passNuevaLabel.getText().isBlank() == false) {
                if (passActualLabel.getText().toString().equals(this.password)) {
                    updatePassword(passNuevaLabel.getText().toString(), Integer.toString(user_Id));
                    passActualLabel.setText("");
                    passNuevaLabel.setText("");
                    cambioCorrecto.showAndWait();
                } else {
                    passsDiferente.showAndWait();
                }

            } else {
                noDataPassword.showAndWait();
            }
        });

    }


    private void getData() {
        Connection conn = getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM usuarios WHERE userId = ?");
            pstmt.setString(1, Integer.toString(user_Id));

            ResultSet rs = pstmt.executeQuery();


            while (rs.next()) {

                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                nombreDeUsuario = rs.getString("username");
                password = rs.getString("password");


            }


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }

    }


    private void updateData(String nombre, String apellido, String username, String userId) {
        Connection conn = getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE usuarios SET nombre = ?, apellido = ?, username = ? WHERE userId = ?");
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setString(3, username);
            pstmt.setString(4, userId);

            pstmt.execute();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }


    }


    private void updatePassword(String nuevaPassword, String userId) {
        Connection conn = getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE usuarios SET password = ? WHERE userId = ?");
            pstmt.setString(1, nuevaPassword);
            pstmt.setString(2, userId);
            pstmt.execute();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }


    }


    private Connection getConnection() {

        return new DatabaseConnection().getConnection();
    }

}
