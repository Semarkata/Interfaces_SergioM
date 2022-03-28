package Ejercicio3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainLayout3 extends Application {
    private BorderPane rootLayout;
    @Override
    public void start(Stage primaryStage) {
        try {
// Carga el diseño del archivo FXML en la variable rootLayout
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainLayout3.class.getResource("MainView.fxml"));
            rootLayout = (BorderPane) loader.load();
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


    public BorderPane getRootLayout() {
        return rootLayout;
    }

    public void setRootLayout(BorderPane rootLayout) {
        this.rootLayout = rootLayout;
    }
}


