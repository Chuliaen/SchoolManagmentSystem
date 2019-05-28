package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
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

    @FXML
    private void testButton() {
        System.out.println("Klappt");
        inputLbl.setText("Klappt!");
    }

    @FXML
    private void testButton2() {
        System.out.println("Klappt auch");
        inputLbl.setText("Klappt auch!");
    }

}
