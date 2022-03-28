package Ejercicio3;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class ViewController {

    @FXML
    private ImageView imageView;

    @FXML
    private Text source;

    @FXML
    private Text destination;


    @FXML
    void initialize() {
        assert imageView != null : "fx:id=\"imageView\" was not injected: check your FXML file 'MainView.fxml'.";

    }

    @FXML
    void handleDragOver(DragEvent event) {
        if(event.getDragboard().hasFiles()){
            event.acceptTransferModes(TransferMode.ANY);
        }

    }

    @FXML
    void handleDroped(DragEvent event) throws FileNotFoundException {
        List<File> files = event.getDragboard().getFiles();
        Image img = new Image(new FileInputStream(files.get(0)));
        imageView.setImage(img);
    }

    @FXML
    void handleDragDetectedInicio(MouseEvent event) {

        Dragboard db = source.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cc = new ClipboardContent();
        cc.putString(source.getText());
        db.setContent(cc);
        event.consume();

    }

    @FXML
    void handleDragoDone(DragEvent event) {

        source.setText("Acion completada");


    }

    @FXML
    void handleDragDropped(DragEvent event) {

        String text = event.getDragboard().getString();
        destination.setText(text);

    }


    @FXML
    void handleDragOverDes(DragEvent event) {

        if(event.getDragboard().hasString()){
            event.acceptTransferModes(TransferMode.ANY);
        }
    }


}
