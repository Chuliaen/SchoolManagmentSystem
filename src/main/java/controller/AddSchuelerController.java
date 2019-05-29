package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.TextArea;
import model.Database;

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
    private URL location;

    @FXML
    private ResourceBundle resources;

    public AddSchuelerController() { }

    @FXML
    private void initialize() { }

    /*
    Todo: add Schuüler to Database
     */
    @FXML
    private void addSchueler() {
        Database database = new Database();
        database.connect();

        database.addSchueler(Integer.parseInt(idField.getText()), vornameField.getText(), nachnameField.getText(),
                geburtsdatumField.getText(), geschlechtField.getText(), klasseField.getText());

        database.closeConnection();
    }

}
