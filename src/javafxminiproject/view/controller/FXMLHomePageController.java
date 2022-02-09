/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxminiproject.view.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafxminiproject.view.ParentScreenFactory;
import javafxminiproject.view.ScreenEnum;

import java.net.URL;
import java.util.ResourceBundle;

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
        callAnimalScreen();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    private void callAnimalScreen() {

        Scene animalProfileScreenScene = ParentScreenFactory.getInstance().getParentScreen(ScreenEnum.ANIMAL_PROFILE);
        Stage dialog = new Stage();

        dialog.setTitle("Animal");
        dialog.setScene(animalProfileScreenScene);
        dialog.show();
        
    }
}
