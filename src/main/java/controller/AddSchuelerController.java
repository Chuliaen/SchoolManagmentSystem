package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.TextArea;
import java.net.URL;
import java.util.ResourceBundle;

public class AddSchuelerController {

    @FXML
    private TextField idField;

    /*
    Todo: add every TextField
     */

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
        System.out.println("Klappt");
    }

}
