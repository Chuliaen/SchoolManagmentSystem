package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

public class ControllerMain {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    public ControllerMain() { }

    @FXML
    private void initialize() { }

    @FXML
    private void addSchueler() {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("AddSchueler.fxml"));
            rootPane.getChildren().setAll(pane);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addLehrer() {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("AddLehrer.fxml"));
            rootPane.getChildren().setAll(pane);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
