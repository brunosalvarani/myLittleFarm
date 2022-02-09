/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxminiproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafxminiproject.utils.Context;

/**
 * FXML Controller class
 *
 * @author bruno
 */
public class FXMLAnimalProfileController implements Initializable {


    @FXML
    private Circle profileImage;

    @FXML
    private TextField profileMother;

    @FXML
    private TextField profileFather;

    @FXML
    private TextField profileBirthDate;

    @FXML
    private TextField profileGender;

    @FXML
    private TextField profileWeighting;

    @FXML
    private TextField profileRace;

    @FXML
    private Button animalProfileWeighting;

    @FXML
    private Button animalProfileBackToMenu;

    @FXML
    void backToMenuPage(ActionEvent event) throws IOException {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
    }

    @FXML
    void openWeightingPage(ActionEvent event) throws IOException {
        Stage weightingScreen = Context.getWeightingScreen();
        if (weightingScreen.isShowing()) {
            weightingScreen.toFront();
        } else {
            weightingScreen.show();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
