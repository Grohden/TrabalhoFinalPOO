package main.GUI.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import main.GUI.GUIPrototype;

public abstract class BasicController  {
    // location and resources will be automatically injected by the FXML loader
    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;


    public void goBack(){
        GUIPrototype.goToLastScene();;
    }
}
