/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxminiproject.utils;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafxminiproject.MyFirstApplication;
import javafxminiproject.model.User;

/**
 *
 * @author bruno
 */
public class Context {
    private static User currentUser;
    
    private static Stage weightingScreen;

    public static Stage getWeightingScreen() {
        if(weightingScreen==null){
            try {
                Parent root = FXMLLoader.load(MyFirstApplication.class.getResource("FXMLQuickWeighting.fxml"));
                
                Scene scene = new Scene(root);
                
                Stage stage = new Stage();
                stage.setScene(scene);
                
                weightingScreen = stage;
            } catch (IOException ex) {
                Logger.getLogger(Context.class.getName()).log(Level.SEVERE, null, ex);
            }
            
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