/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxminiproject.view.controller;

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
import javafxminiproject.model.Animal;
import javafxminiproject.service.AnimalService;
import javafxminiproject.service.exception.EntityNotFoundException;
import javafxminiproject.utils.Context;

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
        Animal animal = new Animal(tagTextField.getText(), mother.getText(), birthDate.getText(), race.getText(), isNative.isSelected(), Double.parseDouble(mostRecentWeighting.getText()));
        System.out.println(service.addAnimal(animal).toString());
        //TODO insert a textfield for the TAG, so I can stop using the seachbox as an input for the tag.
    }

    @FXML
    void removeExistingAnimal(ActionEvent event) {
        try {
            service.checkAndRemoveAnimalByID(Integer.parseInt(tagTextField.getText()));
            // TODO stop using searchbox as input to remove animal by ID, and start using a proper textfield
        } catch (EntityNotFoundException e) {
            // TODO create alert for EntityNotFoundException and other errors;
        }
    }

    @FXML
    void editExistingAnimal(ActionEvent event) {
        tagTextField.setVisible(!tagTextField.isVisible());
        tagTextField.setDisable(!tagTextField.isDisabled());
        // TODO edit values from x animal, using proper textfields.
        // TODO disable all fields if edit isn't pressed ( including save, remove )
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

    private void fillSelectedAnimal(Animal animal){
        tagLabel.setText(animal.getTag());
        //TODO create a function to fill up the inputs return by the search
    }

    //TODO make listview show all the animals registered in the data base;


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

    //TODO fix the add function, it is prohibited to add an animal to an already existing tag


}
