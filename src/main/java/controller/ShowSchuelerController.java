package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Database;
import model.Schueler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowSchuelerController {

    //Used to show Schüler in a TableView
    private ObservableList<ObservableList> data;

    //Every needed TableView data
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn schuelerID;
    @FXML
    private TableColumn schuelerVorname;
    @FXML
    private TableColumn schuelerNachname;
    @FXML
    private TableColumn schuelerGeburtsdatum;
    @FXML
    private TableColumn schuelerGeschlecht;
    @FXML
    private TableColumn schuelerKlasse;

    Database db = new Database();

    @FXML
    private AnchorPane rootPane;

    public ShowSchuelerController() { }

    //Todo: schaun wie das geht!
    @FXML
    private void initialize(URL location, ResourceBundle resources) {
        db.connect();
        tableView.setItems(db.getSchueler());
        db.closeConnection();
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