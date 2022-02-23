/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxminiproject.view.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafxminiproject.model.Animal;
import javafxminiproject.service.AnimalService;
import javafxminiproject.service.exception.EntityNotFoundException;
import javafxminiproject.utils.Context;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author bruno
 */
public class FXMLAnimalProfileController implements Initializable {

    private final AnimalService service;

    // TODO botões de ADD, Update
    // selected animal.

    @FXML
    private TextField search;

    @FXML
    private Button buttonEditThisAnimal;

    @FXML
    private Circle image;

    @FXML
    private Button buttonWeighting;

    @FXML
    private Button buttonBackToMenuFromAnimalProfile;

    @FXML
    private TextField mostRecentWeighting;

    @FXML
    private TextField race;

    @FXML
    private TextField gender;

    @FXML
    private TextField birthDate;

    @FXML
    private TextField mother;

    @FXML
    private CheckBox isNative;

    @FXML
    private Button buttonSaveThisAnimal;

    @FXML
    private Button buttonRemoveThisAnimal;

    public FXMLAnimalProfileController() {
        service = AnimalService.getInstance();
    }

    @FXML
    void backToMenuPage(ActionEvent event) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
    }

    @FXML
    void openWeightingPage(ActionEvent event) {
        Stage weightingScreen = Context.getWeightingScreen();
        if (weightingScreen.isShowing()) {
            weightingScreen.toFront();
        } else {
            weightingScreen.show();
        }
    }

    @FXML
    void addNewAnimal(ActionEvent event) {
        Animal animal = new Animal(1, "123", "000", "2000-10-22", "nelore", false, 495.00);
        System.out.println(service.addAnimal(animal).toString());
    }

    @FXML
    void removeExistingAnimal(ActionEvent event) {
        try {
            service.checkAndRemoveAnimalByID(Integer.parseInt(search.getText()));
        } catch (EntityNotFoundException e) {
            // TODO create alert for EntityNotFoundException and other errors;
        }
    }

    @FXML
    void editExistingAnimal(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
}
