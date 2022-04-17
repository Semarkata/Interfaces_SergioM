package controller;

import database.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class NuevoEnvioController {


    @FXML
    private Button altoBtn;

    @FXML
    private Text altoText;

    @FXML
    private Button anchoBtn;

    @FXML
    private Text anchoText;

    @FXML
    private HBox bannerImages;

    @FXML
    private Text bannerText;

    @FXML
    private Button borrarBtn;

    @FXML
    private Button ciudadBtn;

    @FXML
    private Text ciudadText;

    @FXML
    private Button cpBtn;

    @FXML
    private Text cpText;

    @FXML
    private Button dirBtn;

    @FXML
    private Text dirText;

    @FXML
    private Button enviarBtn;

    @FXML
    private Button largoBtn;

    @FXML
    private Text largoText;

    @FXML
    private Button paisBtn;

    @FXML
    private Text paisText;

    @FXML
    private Button pesoBtn;

    @FXML
    private Text pesoText;

    @FXML
    private Button selectTipoEnvioBtn;

    @FXML
    private Text tipoEnvioText;

    @FXML
    private Button unidadMedidaBtn;

    @FXML
    private Text unidadMedidaText;

    @FXML
    private Button unidadPesoBtn;

    @FXML
    private Text unidadPesoText;

    @FXML
    private Text dirEnvioBannerText;

    @FXML
    private Text datosPaqueteBannerText;
    @FXML
    private Text resumenText;
    @FXML
    private Text tipoEnvioBannerText;

    private int user_Id = LoginController.getUser_Id();

    private String paqueteId;


    //Boton paises
    String[] paisesData = {"Francia", "Portugal", "España", "Alemania", "Italia"};
    List<String> paisesList = Arrays.asList(paisesData);
    ChoiceDialog<String> choicePais = new ChoiceDialog<String>("Seleccione Pais", paisesList);


    //    Dialog CP
    TextInputDialog cpDialog = new TextInputDialog("");

    //    Dialog Direccion
    TextInputDialog dirDialog = new TextInputDialog("");

    //    Dialog Peso
    TextInputDialog pesoDialog = new TextInputDialog("");

    //    Boton Unidad de peso
    String[] unidadPesoData = {"KG", "LB"};
    List<String> unidadPesoList = Arrays.asList(unidadPesoData);
    ChoiceDialog<String> choiceUnidadPeso = new ChoiceDialog<String>(unidadPesoList.get(0), unidadPesoList);

    //    Largo Dialog
    TextInputDialog largoDialog = new TextInputDialog("");

    //    Ancho Dialog
    TextInputDialog anchoDialog = new TextInputDialog("");

    //    Alto Dialog
    TextInputDialog altoDialog = new TextInputDialog("");

    //    Boton Unidad de medida
    String[] unidadMedidaData = {"CM", "IN"};
    List<String> unidadMedidaList = Arrays.asList(unidadMedidaData);
    ChoiceDialog<String> choiceUnidadMedida = new ChoiceDialog<String>(unidadMedidaList.get(0), unidadMedidaList);

    //    Boton tipo de envio
    String[] tipoEnvioData = {"Envio normal", "Envio rapido", "Envio urgente"};
    List<String> tipoEnvioList = Arrays.asList(tipoEnvioData);
    ChoiceDialog<String> choiceTipoEnvio = new ChoiceDialog<String>("Tipo de envio...", tipoEnvioList);

    Alert camposNecesarios = new Alert(Alert.AlertType.WARNING);

    Alert soloNum = new Alert(Alert.AlertType.WARNING);


    @FXML
    void initialize() {
        assert altoBtn != null : "fx:id=\"altoBtn\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert altoText != null : "fx:id=\"altoText\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert anchoBtn != null : "fx:id=\"anchoBtn\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert anchoText != null : "fx:id=\"anchoText\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert bannerImages != null : "fx:id=\"bannerImages\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert bannerText != null : "fx:id=\"bannerText\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert borrarBtn != null : "fx:id=\"borrarBtn\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert ciudadBtn != null : "fx:id=\"ciudadBtn\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert ciudadText != null : "fx:id=\"ciudadText\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert cpBtn != null : "fx:id=\"cpBtn\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert cpText != null : "fx:id=\"cpText\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert dirBtn != null : "fx:id=\"dirBtn\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert dirText != null : "fx:id=\"dirText\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert enviarBtn != null : "fx:id=\"enviarBtn\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert largoBtn != null : "fx:id=\"largoBtn\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert largoText != null : "fx:id=\"largoText\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert paisBtn != null : "fx:id=\"paisBtn\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert paisText != null : "fx:id=\"paisText\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert pesoBtn != null : "fx:id=\"pesoBtn\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert pesoText != null : "fx:id=\"pesoText\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert selectTipoEnvioBtn != null : "fx:id=\"slectTipoEnvioBtn\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert tipoEnvioText != null : "fx:id=\"tipoEnvioText\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert unidadMedidaBtn != null : "fx:id=\"unidadMedidaBtn\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert unidadMedidaText != null : "fx:id=\"unidadMedidaText\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert unidadPesoBtn != null : "fx:id=\"unidadPesoBtn\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";
        assert unidadPesoText != null : "fx:id=\"unidadpesoText\" was not injected: check your FXML file 'NuevoEnvio.fxml'.";

        camposNecesarios.setTitle("Alerta");
        camposNecesarios.setHeaderText("Campos necesarios");
        camposNecesarios.setContentText("Completa todos los campos");

        soloNum.setTitle("Alerta");
        soloNum.setHeaderText("Solo numeros");
        soloNum.setContentText("Solo estan permitido numeros");

        paisBtn.getStyleClass().add("btn");
        ciudadBtn.getStyleClass().add("btn");
        cpBtn.getStyleClass().add("btn");
        dirBtn.getStyleClass().add("btn");
        pesoBtn.getStyleClass().add("btn");
        unidadPesoBtn.getStyleClass().add("btn");
        largoBtn.getStyleClass().add("btn");
        anchoBtn.getStyleClass().add("btn");
        altoBtn.getStyleClass().add("btn");
        unidadMedidaBtn.getStyleClass().add("btn");
        selectTipoEnvioBtn.getStyleClass().add("btn");
        borrarBtn.getStyleClass().add("btn");
        enviarBtn.getStyleClass().add("btn");

        dirEnvioBannerText.getStyleClass().add("textoEnvios");
        datosPaqueteBannerText.getStyleClass().add("textoEnvios");
        resumenText.getStyleClass().add("textoEnvios");
        tipoEnvioBannerText.getStyleClass().add("textoEnvios");


//        Colocacion de las imagenes
        bannerImages.setId("bannerImages");
        bannerText.setId("textoBanner");


//        Pais accion
        paisBtn.setOnAction(e -> {
            choicePais.showAndWait().ifPresent(response -> {
                ciudadText.setText("");
                paisText.setText(response);
            });
        });
//        Ciudad  accion
        ciudadBtn.setOnAction(e -> {
            ChoiceDialog<String> choiceCiudad;
            if (paisText.getText().isBlank()) {
                String[] nulo = {"Seleccione pais primero"};
                List<String> nuloList = Arrays.asList(nulo);
                choiceCiudad = new ChoiceDialog<String>(nuloList.get(0), nuloList);
                choiceCiudad.showAndWait();
            } else {
                choiceCiudad = ciudadPorPais(paisText.getText().toString());
                choiceCiudad.showAndWait().ifPresent(response -> {
                    ciudadText.setText(response);
                });
            }

        });

//        CP Accion

        cpDialog.setTitle("Codigo Postal");
        cpDialog.setHeaderText("Escriba el codigo Postal");
        cpDialog.getDialogPane().addEventFilter(KeyEvent.KEY_TYPED, e -> {
            char carac = (char) e.getCharacter().charAt(0);

            if (!Character.isDigit(carac)) {
                soloNum.showAndWait();
                e.consume();
            }
        });
        cpBtn.setOnAction(e -> {
            cpDialog.showAndWait().ifPresent(response -> {
                cpText.setText(response);
            });
        });


//        Direccion Accion
        dirDialog.setTitle("Direccion");
        dirDialog.setHeaderText("Escribe la direccion de envio");
        dirBtn.setOnAction(e -> {
            dirDialog.showAndWait().ifPresent(response -> {
                dirText.setText(response);
            });
        });

//        Peso Accion
        pesoDialog.setTitle("Peso");
        pesoDialog.setHeaderText("Escribe el peso del paquete");
        pesoDialog.getDialogPane().addEventFilter(KeyEvent.KEY_TYPED, e -> {
            char carac = (char) e.getCharacter().charAt(0);

            if (!Character.isDigit(carac)) {
                soloNum.showAndWait();
                e.consume();
            }
        });
        pesoBtn.setOnAction(e -> {
            pesoDialog.showAndWait().ifPresent(response -> {
                pesoText.setText(response);
            });
        });

//        Unidad Peso Accion
        unidadPesoBtn.setOnAction(e -> {
            choiceUnidadPeso.showAndWait().ifPresent(response -> {
                unidadPesoText.setText(response);
            });
        });

//        Largo Accion
        largoDialog.setTitle("Largo");
        largoDialog.setHeaderText("Escribe el largo del paquete");
        largoDialog.getDialogPane().addEventFilter(KeyEvent.KEY_TYPED, e -> {
            char carac = (char) e.getCharacter().charAt(0);

            if (!Character.isDigit(carac)) {
                soloNum.showAndWait();
                e.consume();
            }
        });
        largoBtn.setOnAction(e -> {
            largoDialog.showAndWait().ifPresent(response -> {
                largoText.setText(response);
            });
        });

//        Ancho Accion
        anchoDialog.setTitle("Ancho");
        anchoDialog.setHeaderText("Escribe el ancho del paquete");
        anchoDialog.getDialogPane().addEventFilter(KeyEvent.KEY_TYPED, e -> {
            char carac = (char) e.getCharacter().charAt(0);

            if (!Character.isDigit(carac)) {
                soloNum.showAndWait();
                e.consume();
            }
        });
        anchoBtn.setOnAction(e -> {
            anchoDialog.showAndWait().ifPresent(response -> {
                anchoText.setText(response);
            });
        });

//        Alto Accion
        altoDialog.setTitle("Alto");
        altoDialog.setHeaderText("Escribe el alto del paquete");
        altoDialog.getDialogPane().addEventFilter(KeyEvent.KEY_TYPED, e -> {
            char carac = (char) e.getCharacter().charAt(0);

            if (!Character.isDigit(carac)) {
                soloNum.showAndWait();
                e.consume();
            }
        });
        altoBtn.setOnAction(e -> {
            altoDialog.showAndWait().ifPresent(response -> {
                altoText.setText(response);
            });
        });

//        Unidad Medida Accion
        unidadMedidaBtn.setOnAction(e -> {
            choiceUnidadMedida.showAndWait().ifPresent(response -> {
                unidadMedidaText.setText(response);
            });
        });

//        Tipo de envio
        selectTipoEnvioBtn.setOnAction(e -> {
            choiceTipoEnvio.showAndWait().ifPresent(response -> {
                tipoEnvioText.setText(response);
            });
        });


        borrarBtn.setOnAction(e -> {

            elimiarDatos();
        });

        enviarBtn.setOnAction(e -> {
            if (paisText.getText().isBlank() == false
                    && ciudadText.getText().isBlank() == false
                    && cpText.getText().isBlank() == false
                    && dirText.getText().isBlank() == false
                    && pesoText.getText().isBlank() == false
                    && unidadPesoText.getText().isBlank() == false
                    && largoText.getText().isBlank() == false
                    && anchoText.getText().isBlank() == false
                    && altoText.getText().isBlank() == false
                    && unidadMedidaText.getText().isBlank() == false
                    && tipoEnvioText.getText().isBlank() == false) {

                guardarPaquete();
                guardarEnvio(paqueteId);
                elimiarDatos();

            } else {
                camposNecesarios.showAndWait();
            }

        });

    }

    public void restriccionNumerica() {

    }


    private ChoiceDialog<String> ciudadPorPais(String pais) {

        String[] ciudadesData;
        List<String> ciudadesList;
        ChoiceDialog<String> choiceCiudad;
        switch (pais) {
            case "Francia":
                ciudadesData = new String[]{"Paris", "Marsella", "Lyon", "Niza"};
                ciudadesList = Arrays.asList(ciudadesData);
                choiceCiudad = new ChoiceDialog<String>("Selecciona Ciudad", ciudadesList);

                return choiceCiudad;
            case "Portugal":
                ciudadesData = new String[]{"Lisboa", "Oporto", "Guimaraes", "Viseu"};
                ciudadesList = Arrays.asList(ciudadesData);
                choiceCiudad = new ChoiceDialog<String>("Selecciona Ciudad", ciudadesList);
                return choiceCiudad;
            case "Italia":
                ciudadesData = new String[]{"Roma", "Milan", "Napoles", "Turin"};
                ciudadesList = Arrays.asList(ciudadesData);
                choiceCiudad = new ChoiceDialog<String>("Selecciona Ciudad", ciudadesList);
                return choiceCiudad;

            case "Alemania":
                ciudadesData = new String[]{"Berlin", "Hamburgo", "Munich", "Colonia"};
                ciudadesList = Arrays.asList(ciudadesData);
                choiceCiudad = new ChoiceDialog<String>("Selecciona Ciudad", ciudadesList);
                return choiceCiudad;

            case "España":
                ciudadesData = new String[]{"Madrid", "Barcelona", "Vitoria", "Sevilla"};
                ciudadesList = Arrays.asList(ciudadesData);
                choiceCiudad = new ChoiceDialog<String>("Selecciona Ciudad", ciudadesList);
                return choiceCiudad;
        }


        return null;
    }


    private void guardarPaquete() {
        Connection conn = getConnection();

        String peso = pesoText.getText().toString();
        String unidadPeso = unidadPesoText.getText().toString();
        String largo = largoText.getText().toString();
        String ancho = anchoText.getText().toString();
        String alto = altoText.getText().toString();
        String unidadMedida = unidadMedidaText.getText().toString();

        String insertFields = "INSERT INTO paquete(userId,peso,unidadPeso, largo, ancho, alto, UnidadMedida) VALUES('";
        String insertValues = Integer.toString(user_Id) + "','" + peso + "','" + unidadPeso + "','" + largo + "','" + ancho + "','" + alto + "','" + unidadMedida + "')";

        String insertToRegister = insertFields + insertValues;

        try {

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(insertToRegister);
            getPaqueteId(conn);

            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }


    }

    private void guardarEnvio(String paqueteId) {
        Connection conn = getConnection();

        String pais = paisText.getText().toString();
        String ciudad = ciudadText.getText().toString();
        String cp = cpText.getText().toString();
        String direccion = dirText.getText().toString();
        String tipoEnvio = tipoEnvioText.getText().toString();

        String insertFields = "INSERT INTO envio(userId, paqueteId, pais,ciudad,cp,direccion, tipoEnvio) VALUES('";
        String insertValues = Integer.toString(user_Id) + "','" + paqueteId + "','" + pais + "','" + ciudad + "','" + cp + "','" + direccion + "','" + tipoEnvio + "')";
        String insertToRegister = insertFields + insertValues;

        try {

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(insertToRegister);

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    private void getPaqueteId(Connection conn) {

        String query = "SELECT paqueteId from paquete ORDER BY paqueteId desc limit 1";

        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);


            while (rs.next()) {
                paqueteId = rs.getString("paqueteId");
            }


        } catch (Exception e) {

            e.printStackTrace();
            e.getCause();

        }

    }

    private Connection getConnection() {

        return new DatabaseConnection().getConnection();
    }


    private void elimiarDatos() {
        paisText.setText("");
        ciudadText.setText("");
        cpText.setText("");
        dirText.setText("");
        pesoText.setText("");
        unidadPesoText.setText("");
        largoText.setText("");
        anchoText.setText("");
        altoText.setText("");
        unidadMedidaText.setText("");
        tipoEnvioText.setText("");
    }

}
