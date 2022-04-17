package application;

import controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainLayout extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            LoginController controller = loader.getController();
            controller.setStage(primaryStage);

            primaryStage.setTitle("Envio Rapidito");
            primaryStage.setScene(scene);
            scene.getStylesheets().add("application/styles.css");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}