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
    private TableView<Schueler> tableView;
    @FXML
    private TableColumn<Object, Object> schuelerID;
    @FXML
    private TableColumn<Object, Object> schuelerVorname;
    @FXML
    private TableColumn<Object, Object> schuelerNachname;
    @FXML
    private TableColumn<Object, Object> schuelerGeburtsdatum;
    @FXML
    private TableColumn<Object, Object> schuelerGeschlecht;
    @FXML
    private TableColumn<Object, Object> schuelerKlasse;

    Database db = new Database();

    @FXML
    private AnchorPane rootPane;

    public ShowSchuelerController() { }

    @FXML
    private void initialize(URL location, ResourceBundle resources) {
        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        schuelerID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        schuelerVorname.setCellValueFactory(new PropertyValueFactory<>("Vorname"));
        schuelerNachname.setCellValueFactory(new PropertyValueFactory<>("Nachname"));
        schuelerGeburtsdatum.setCellValueFactory(new PropertyValueFactory<>("Geburtsdatum"));
        schuelerGeschlecht.setCellValueFactory(new PropertyValueFactory<>("Geschlecht"));
        schuelerKlasse.setCellValueFactory(new PropertyValueFactory<>("Klasse"));
        //add your data to the table here.
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