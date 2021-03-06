/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.javafxminiproject.view.controller;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import main.java.javafxminiproject.model.Animal;
import main.java.javafxminiproject.service.AnimalService;
import main.java.javafxminiproject.service.exception.EntityNotFoundException;
import main.java.javafxminiproject.utils.Context;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author bruno
 */
public class FXMLAnimalProfileController implements Initializable {

    private final AnimalService service;
    public Button removeExistingAnimal;
    private Animal selectedAnimal;

    // TODO botões de ADD, Update
    // selected animal.

    @FXML
    private TextField search;

    @FXML
    private TextField tagTextField;

    @FXML
    private Label tagLabel;

    @FXML
    private ListView<Animal> lvAnimals;

    @FXML
    private Button buttonEditThisAnimal;

    @FXML
    private Circle image;

    @FXML
    private Button buttonWeighting;

    @FXML
    private Button buttonBackToMenuFromAnimalProfile;

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

    @FXML
    private TableView<?> tableView;

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
        Animal animal = new Animal(tagTextField.getText(), mother.getText(), birthDate.getText(), gender.getText(), race.getText(), isNative.isSelected());
        System.out.println(service.addAnimal(animal).toString());
        fillListView();
    }

    @FXML
    void removeExistingAnimal(ActionEvent event) {
        try {
            service.checkAndRemoveAnimalByID(Integer.parseInt(tagTextField.getText())); //TODO change the method ByID -> ByTag
            fillListView();
        } catch (EntityNotFoundException e) {
            // TODO create alert for EntityNotFoundException and other errors;
        }
    }

    @FXML
    void editExistingAnimal(ActionEvent event) {
        /* abling and desabling of textfields/buttons/listView when on edit mode */
        tagTextField.setVisible(!tagTextField.isVisible());
        tagTextField.setDisable(!tagTextField.isDisabled());
        tagLabel.setVisible(!tagTextField.isVisible()); // tagLabel should be visible only when tagTextField isn't

        tagTextField.setText(tagLabel.getText());
        // TODO edit values from x animal, using proper textfields.
        // TODO disable all fields if edit isn't pressed (including buttons save and remove)
    }

    @FXML
    void searchAnimal(KeyEvent event) {
        if(KeyCode.ENTER.equals(event.getCode())){
            String tag = search.getText();
            if(tag != null && !tag.isEmpty()){
                Animal byTag = service.findByTag(tag);
                if(byTag != null){
                    selectedAnimal = byTag;
                    fillSelectedAnimal(selectedAnimal);

                    selectAnimalOnListView();
                }
            }
        }
    }

    private void selectAnimalOnListView() {
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                //TODO search the animal list, for the 'animal.tag'
//                lvAnimals.getSelectionModel().select();
//                lvAnimals.getFocusModel().focus();
//                lvAnimals.scrollTo();

            }
        });
    }
    //TODO fix ui
    private void fillSelectedAnimal(Animal animal){
        tagLabel.setText(animal.getTag());
        race.setText(animal.getRace());
        birthDate.setText(animal.getBirthDate());
        mother.setText(animal.getParentTag());
        isNative.setSelected(animal.isIsNative());
        gender.setText(animal.getGender());
        //TODO finish fillSelectedAnimal, weight
    }

    private void fillListView() {
        List<Animal> animalList = service.findAll();
        ObservableList<Animal> items = FXCollections.observableArrayList (animalList);
        lvAnimals.setItems(items);

        lvAnimals.setCellFactory(lv -> new ListCell<Animal>() {
            @Override
            public void updateItem(Animal item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                } else {
                    setText(item.getTag());
                }
            }
        });

        lvAnimals.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Animal>() {
            @Override
            public void changed(ObservableValue<? extends Animal> observable, Animal oldValue, Animal newValue) {
                selectedAnimal = newValue;
                fillSelectedAnimal(selectedAnimal);
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        fillListView();
        tagTextField.setVisible(false);
        tagTextField.setDisable(true);
    }

    // TODO implement FXMLAnimalProfile(New Version) and review the code. ( most recent weighting shall be removed ).
}
