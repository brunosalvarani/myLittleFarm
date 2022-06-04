/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.javafxminiproject;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.javafxminiproject.utils.Context;
import main.java.javafxminiproject.view.ParentScreenFactory;
import main.java.javafxminiproject.view.ScreenEnum;

/**
 *
 * @author bruno
 */
public class MyFirstApplication extends Application {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        if(callLoginScreen()){
            callHomePage(stage);
        }
    }
    
    private void callHomePage(Stage stage){

        Scene homeScreenScene = ParentScreenFactory.getInstance().getParentScreen(ScreenEnum.HOME);
        stage.hide();
        stage.setScene(homeScreenScene);
        stage.show();
        stage.setOnCloseRequest(event->Platform.exit());
    }

    private boolean callLoginScreen() {

        Scene loginScreenScene = ParentScreenFactory.getInstance().getParentScreen(ScreenEnum.LOGIN);
        Stage dialog = new Stage();

        dialog.setTitle("Login");
        dialog.setScene(loginScreenScene);
        dialog.showAndWait();

        return Context.getCurrentUser() != null;
    }
    
    


}
