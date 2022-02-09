package javafxminiproject.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;

public class ParentScreenFactory {
    private static ParentScreenFactory instance;

    private ParentScreenFactory(){}



    public static ParentScreenFactory getInstance() {
        if(instance == null){
            instance = new ParentScreenFactory();
        }
        return instance;
    }

    public Scene getParentScreen(ScreenEnum screenEnum) {
        Scene homeScreenScene = null;
        try {
            URL resource = getClass().getResource(screenEnum.path);
            if(resource != null){
                Parent homeScreenParent = FXMLLoader.load(resource);
                homeScreenScene = new Scene(homeScreenParent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return homeScreenScene;
    }
}
