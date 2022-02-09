/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxminiproject;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafxminiproject.utils.Context;

/**
 * FXML Controller class
 *
 * @author bruno
 */
public class FXMLHomePageController implements Initializable {


    @FXML
    private AnchorPane homePageAnchorPane;

    @FXML
    private Button animalProfileButton;

    @FXML
    void openAnimalProfile(ActionEvent event) {
        try {
            callAnimalScreen();

//            Parent animalProfileParent = FXMLLoader.load(getClass().getResource("FXMLAnimalProfile.fxml"));
//            Scene animalProfileScene = new Scene(animalProfileParent);
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            stage.hide();
//            stage.setScene(animalProfileScene);
//            stage.show();
        } catch (IOException e) {
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    private void callAnimalScreen() throws IOException {
        AnchorPane root;
        root = FXMLLoader.load(getClass().getResource("FXMLAnimalProfile.fxml"));

        Stage dialog = new Stage();

        Scene scene = new Scene(root);
        dialog.setTitle("Animal");

        dialog.setScene(scene);
        dialog.show();
        
    }

    private void removeFromList(Stage stage) {
    }
    
}
