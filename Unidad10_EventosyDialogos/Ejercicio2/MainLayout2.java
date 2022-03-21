package Ejercicio2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainLayout2 extends Application {
    private Pane rootLayout;
    @Override
    public void start(Stage primaryStage) {
        try {
// Carga el diseño del archivo FXML en la variable rootLayout
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainLayout2.class.getResource("MainView.fxml"));
            rootLayout = (Pane) loader.load();
// Mostramos la escena del BorderPane de la variable rootLayot
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }


    public Pane getRootLayout() {
        return rootLayout;
    }

    public void setRootLayout(Pane rootLayout) {
        this.rootLayout = rootLayout;
    }
}


