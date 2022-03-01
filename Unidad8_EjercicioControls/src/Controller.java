import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;

public class Controller {

    public static final ObservableList names = FXCollections.observableArrayList();
    public static final ObservableList data =  FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<Object> choiceBox;

    @FXML
    private ToggleGroup gender;

    @FXML
    private ListView<String> qualifications = new ListView(data);

    @FXML
    private ComboBox<String> comboLocations;

    @FXML
    private TreeView tree = new TreeView();




    @FXML
    void initialize() {
        assert choiceBox != null : "fx:id=\"choicBox\" was not injected: check your FXML file 'MainLayouts.fxml'.";
        assert gender != null : "fx:id=\"gender\" was not injected: check your FXML file 'MainLayouts.fxml'.";
        assert qualifications != null : "fx:id=\"qualifications\" was not injected: check your FXML file 'MainLayouts.fxml'.";
        assert comboLocations != null : "fx:id=\"comboLocations\" was not injected: check your FXML file 'MainLayouts.fxml'.";
        assert tree != null : "fx:id=\"tree\" was not injected: check your FXML file 'MainLayouts.fxml'.";


        choiceBox.getItems().addAll("New York",
                                        "Orlando",
                                        new Separator(),
                                        "London",
                                        "Manchester");

        choiceBox.setValue("Select a value...");

        names.addAll("Objects", "Classes","Functions", "Variables", "Compiler", "Debugger", "Projects", "Beans", "Libraries", "Modules");

        for (int i = 0; i < 10; i++) {
            data.add("Indeterminate (pick a choice)");
        }

        qualifications.setItems(data);
        qualifications.setCellFactory(ComboBoxListCell.forListView(names));

        comboLocations.getItems().addAll("English", "Japanese", "Spanish");
        comboLocations.setValue("Select a language");

        TreeItem rootItem = new TreeItem("Inbox");

        TreeItem inbox = new TreeItem("Inbox");
        inbox.getChildren().add(new TreeItem("Sales"));
        inbox.getChildren().add(new TreeItem("Marketing"));
        inbox.getChildren().add(new TreeItem("Distribution"));
        inbox.getChildren().add(new TreeItem("Costs"));
        rootItem.getChildren().add(inbox);

        tree.setRoot(rootItem);

    }

}
