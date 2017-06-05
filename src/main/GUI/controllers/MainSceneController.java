package main.GUI.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.GUI.GUIPrototype;
import main.GUI.scenes.ScenesPaths;

public class MainSceneController extends BasicController {

    @FXML
    public Button adicionarCarro;

    @FXML
    public Button verCarros;

    @FXML
    public Button removerCarro;

    @FXML
    private Label label;

    // Add a public no-args constructor
    public MainSceneController()
    {

    }

    @FXML
    private void initialize()
    {
    }


    @FXML
    public void openSeeScene(ActionEvent actionEvent) {
    }

    @FXML
    public void openAddScene(ActionEvent actionEvent) {
        try{
            GUIPrototype.changeScene(ScenesPaths.ADD_SCENE, "Adicione um carro");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void openRemoveScene(ActionEvent actionEvent) {
    }
}
