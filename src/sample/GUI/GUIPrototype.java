package sample.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.GUI.scenes.ScenesPaths;

import java.io.IOException;
import java.net.URL;
import java.util.Stack;

/**
 * Created by gabri on 04/06/2017.
 */
public class GUIPrototype extends Application {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 600;
    private static Stack<Scene> sceneStack = new Stack<Scene>();
    private static Stage mainStage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        createInitialStage(primaryStage, "Loja de veiculos", ScenesPaths.MAIN_SCENE);
    }

    public static void changeScene(ScenesPaths sceneURL, String title) throws IOException{
        Parent root = FXMLLoader.load(sceneURL.getURL());
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        mainStage.setScene(scene);
        mainStage.setTitle(title);

        sceneStack.push(scene);
    }

    public static void goToLastScene(){
        if(sceneStack.size() <= 1){
            return;
        }

        sceneStack.pop();
        mainStage.setScene(sceneStack.peek());

    }

    private static void createInitialStage(Stage stage,String title, ScenesPaths fxmlPath) throws IOException {
        mainStage = stage;
        Parent root = FXMLLoader.load(fxmlPath.getURL());
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();

        sceneStack.push(scene);
    }

    public static void main(String[] args){
        launch(args);
    }
}
