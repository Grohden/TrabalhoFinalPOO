package sample.GUI.controllers;

import javafx.fxml.FXML;
import sample.GUI.GUIPrototype;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by gabri on 04/06/2017.
 */
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
