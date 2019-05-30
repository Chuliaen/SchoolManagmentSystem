package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Database;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddSchuelerController {

    @FXML
    private TextField idField;

    @FXML
    private TextField vornameField;

    @FXML
    private TextField nachnameField;

    @FXML
    private TextField geburtsdatumField;

    @FXML
    private TextField geschlechtField;

    @FXML
    private TextField klasseField;

    @FXML
    private AnchorPane rootPane;

    public AddSchuelerController() { }

    @FXML
    private void initialize(URL location, ResourceBundle resources) { }

    @FXML
    private void addSchueler() {
        try {
            Database database = new Database();
            database.connect();

            database.addSchueler(Integer.parseInt(idField.getText()), vornameField.getText(), nachnameField.getText(),
                    geburtsdatumField.getText(), geschlechtField.getText(), klasseField.getText());

            database.closeConnection();

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Schüler hinzufügen");
            alert.setHeaderText("Schüler hinzufügen");
            alert.setContentText("Der Schüler wurde hinzugefügt, sie werden zum Menü zurück geleitet");
            alert.showAndWait();

            back();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void back() {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("MainGUI.fxml"));
            rootPane.getChildren().setAll(pane);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
