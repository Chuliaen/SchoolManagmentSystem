package controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import model.Database;
import model.Schueler;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ShowSchuelerController implements Initializable {

    @FXML
    private TextField idField;

    @FXML
    private TextField vornameField;

    @FXML
    private TextField nachnameField;

    @FXML
    private TextField geschlechtField;

    @FXML
    private TextField klasseField;

    @FXML
    private TableView tableView;

    Database db = new Database();

    @FXML
    private AnchorPane rootPane;

    public ShowSchuelerController() { }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        setupTable();
    }

    @FXML
    private void back() {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("MainGUI.fxml"));
            rootPane.getChildren().setAll(pane);


        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupTable(){

        try {
            db.connect();

            String SQL = "SELECT * from Schüler";

            Statement stat = db.getConnection().createStatement();
            ResultSet rs = stat.executeQuery(SQL);
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });
                tableView.getColumns().addAll(col);
            }
            db.closeConnection();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void search(){
        String id = idField.getText();
        String vorname = vornameField.getText();
        String nachname = nachnameField.getText();
        String geschlecht = geschlechtField.getText();
        String klasse = klasseField.getText();

        String query = "SELECT * FROM Schüler WHERE ";
        String tmp = "";

        if (!id.equals("")) {
            query += tmp + "ID = '" + id + "'";
            tmp = " AND ";
        }
        if (!vorname.equals("")) {
            query += tmp + "Vorname = '" + vorname + "'";
            tmp = " AND ";
        }
        if (!nachname.equals("")) {
            query += tmp + "Nachname = '" + nachname + "'";
            tmp = " AND ";
        }
        if (!geschlecht.equals("")) {
            query += tmp + "Geschlecht = '" + geschlecht + "'";
            tmp = " AND ";
        }
        if (!klasse.equals("")) {
            query += tmp + "Klasse = '" + klasse + "'";
            tmp = " AND ";
        }
        if (id.equals("") && klasse.equals("") && vorname.equals("") && nachname.equals("") && geschlecht.equals("")) {
            query = "SELECT * FROM Schüler";
        }
        db.connect();
        System.out.println(query);
        ObservableList data = db.getSchueler(query);
        tableView.getItems().clear();
        tableView.setItems(data);
        db.closeConnection();

    }

}