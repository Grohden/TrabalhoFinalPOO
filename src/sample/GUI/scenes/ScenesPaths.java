package sample.GUI.scenes;

import java.net.URL;

/**
 * Created by gabri on 04/06/2017.
 */
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
