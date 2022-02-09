/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxminiproject;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafxminiproject.utils.Context;

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
    public void start(Stage stage) throws Exception {
        if(callLoginScreen()){
            callHomePage(stage);
        }
    }
    
    private void callHomePage(Stage stage){
        try {
            Parent homeScreenParent = FXMLLoader.load(getClass().getResource("FXMLHomePage.fxml"));
            Scene homeScreenScene = new Scene(homeScreenParent);
            stage.hide();
            stage.setScene(homeScreenScene);
            stage.show();
            stage.setOnCloseRequest(event->Platform.exit());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean callLoginScreen() {
        AnchorPane root;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));

            Stage dialog = new Stage();

            Scene scene = new Scene(root);
            dialog.setTitle("login");

            dialog.setScene(scene);
            dialog.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(FXMLHomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Context.getCurrentUser() != null;
    }
    
    


}
