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
        System.out.println("Klappt auch");
        //inputLbl.setText("Klappt auch!");
    }

}
