/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxminiproject.utils;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafxminiproject.model.User;
import javafxminiproject.view.ParentScreenFactory;
import javafxminiproject.view.ScreenEnum;

/**
 *
 * @author bruno
 */
public class Context {
    private static User currentUser;
    
    private static Stage weightingScreen;

    public static Stage getWeightingScreen() {
        if(weightingScreen==null){
            Scene quickWheithingScreenScene = ParentScreenFactory.getInstance().getParentScreen(ScreenEnum.QUICK_WEIGHTING);
            Stage stage = new Stage();
            stage.setScene(quickWheithingScreenScene);
            weightingScreen = stage;
        }
        return weightingScreen;
    }
    
    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        Context.currentUser = currentUser;
    }
    
    
}