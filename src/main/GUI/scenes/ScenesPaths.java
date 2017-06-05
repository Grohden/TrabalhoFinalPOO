package main.GUI.scenes;

import java.net.URL;

public enum ScenesPaths {
    MAIN_SCENE("mainScene.fxml"),
    ADD_SCENE("addScene.fxml");

    private URL url;
    ScenesPaths(String file){
        url = getClass().getResource(file) ;
    }

    public URL getURL(){
        return url;
    }

}
