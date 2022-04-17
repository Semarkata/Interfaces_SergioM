package controller;

import database.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerEnviosController {

    private int user_Id = LoginController.getUser_Id();
    @FXML
    private TreeView<String> treePrueba;

    @FXML
    private Text misEnviosText;

//    Datos Envio
    private String pais;

    private String ciudad;

    private String cp;

    private String direccion;

    private String tipo;


//    Datos Paquete

    private String paqueteId;

    private String peso;

    private String unidadPeso;

    private String largo;

    private String ancho;

    private String alto;

    private String unidadMedida;



    @FXML
    void initialize() {
        assert treePrueba != null : "fx:id=\"treePrueba\" was not injected: check your FXML file 'VerEnvios.fxml'.";

        misEnviosText.setId("tituloMisEnvios");
        getQuery();


    }

    private void getQuery(){


        int count = 0;

        Connection conn = getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM envio WHERE userId = ?");
            pstmt.setString(1, Integer.toString(user_Id));

            ResultSet rs = pstmt.executeQuery();
            TreeItem<String> mega = new TreeItem<String>("Envios");


            while (rs.next()) {

                count++;

                TreeItem<String> rootItem = new TreeItem<String>("Envio  " + count);
                TreeItem<String> envio = new TreeItem<String>("Direccion del envio:");

                paqueteId = rs.getString("paqueteId");
                pais = rs.getString("pais");
                ciudad = rs.getString("ciudad");
                cp = rs.getString("cp");
                direccion = rs.getString("direccion");
                tipo = rs.getString("tipoEnvio");

                envio.getChildren().add(new TreeItem<String>("Direccion: " + direccion + ", " + cp + ", " + ciudad + ", " + pais));
                envio.getChildren().add(new TreeItem<String>("Tipo Envio: " + tipo));

                rootItem.getChildren().add(envio);
                rootItem.getChildren().add(getpacketData(paqueteId, conn));

                rootItem.setExpanded(true);

                mega.getChildren().add(rootItem);

            }

            mega.setExpanded(true);
            treePrueba.setRoot(mega);


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }


    }

    private TreeItem<String> getpacketData(String paqueteId, Connection conn){

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM paquete WHERE paqueteId = ?");
            pstmt.setString(1, paqueteId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                peso =  rs.getString("peso");
                unidadPeso =  rs.getString("unidadPeso");
                largo =  rs.getString("largo");
                ancho =  rs.getString("ancho");
                alto =  rs.getString("alto");
                unidadMedida =  rs.getString("unidadMedida");

                TreeItem<String> paquete = new TreeItem<String>("Datos del paquete:");
                paquete.getChildren().add(new TreeItem<String>("Peso: " + peso +unidadPeso));
                paquete.getChildren().add(new TreeItem<String>("Dimensiones: " +  largo + " X " + ancho + " X " + alto + unidadMedida));

                return  paquete;

            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    return  null;
    }
    private Connection getConnection() {

        return new DatabaseConnection().getConnection();
    }



}
