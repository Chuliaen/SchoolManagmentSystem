package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMain {

    @FXML
    private AnchorPane rootPane;

    public ControllerMain() { }

    @FXML
    private void initialize(URL location, ResourceBundle resources) { }

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

    @FXML
    private void showSchueler() {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("ShowSchueler.fxml"));
            rootPane.getChildren().setAll(pane);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
