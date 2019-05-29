package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMain {

    @FXML
    private Label inputLbl;

    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    public ControllerMain() { }

    @FXML
    private void initialize() { }

    /*
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MainGUI.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void login(javafx.event.ActionEvent event) throws IOException
    {
        if(pwf1.getText().equals("dolphin"))
        {
                Parent blah = FXMLLoader.load(getClass().getResource("Home.fxml"));
                Scene scene = new Scene(blah);
                Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                appStage.setScene(scene);
                appStage.show();
        }
        else
        {
                label1.setText("Password is incorrect. Please Try Again");
        }

     */

    @FXML
    private void addSchueler(javafx.event.ActionEvent event) {
        try {
            System.out.println("Klappt");
            Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("MainGUI.fxml"));

            Scene scene = new Scene(parent);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addLehrer() {
        System.out.println("Klappt auch");
        inputLbl.setText("Klappt auch!");
    }

}
