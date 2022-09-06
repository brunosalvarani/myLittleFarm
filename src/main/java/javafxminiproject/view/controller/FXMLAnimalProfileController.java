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
import java.util.ArrayList;
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
    private Button onEditButtonClicked;

    @FXML
    private Circle image;

    @FXML
    private Button buttonWeighting;

    @FXML
    private Button buttonBackToMenuFromAnimalProfile;

    @FXML
    private TextField parentTagTextField;

    @FXML
    private TextField dateOfBirthTextField;

    @FXML
    private TextField genderTextField;

    @FXML
    private TextField raceTextField;

    @FXML
    private CheckBox isNative;

    @FXML
    private Button addNewAnimalButton;

    @FXML
    private Button buttonSaveThisAnimal;

    @FXML
    private Button buttonRemoveThisAnimal;

    @FXML
    private TableView<?> tableView;

    private boolean isEditing;

    private Integer selectedAnimalId;
    private int selectedAnimalListIndex;

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
            weightingScreen.centerOnScreen();
            weightingScreen.toFront();
        } else {
            FXMLCheckUpController checkUpControllerInstance = FXMLCheckUpController.getInstance();
//            checkUpControllerInstance.fillFieldsOnCheckUpPage(tagLabel.getText());
            weightingScreen.show();
        }
    }

    @FXML
    void onSaveButtonClicked(ActionEvent event) {
        Animal selectedAnimal = screenDataToAnimal();
        if(isNewAnimal(selectedAnimal)){
            selectedAnimal = service.addAnimal(selectedAnimal);
            fillListView();
        } else {
            selectedAnimal = service.updateAnimal(selectedAnimal);
            updateAnimalListViewLine(selectedAnimal);
        }
        disableEditMode();
    }

    /*
        Update the lv line that is beeing edited, in order to not refresh the entirety of lv
     */
    private void updateAnimalListViewLine(Animal selectedAnimal) {
        List<Animal> animalStream = lvAnimals.getItems();
        List<Animal> firstPartWithoutSelected = animalStream.subList(0, selectedAnimalListIndex);
        List<Animal> secondPartWithoutSelected = animalStream.subList(selectedAnimalListIndex + 1, animalStream.size());
        List<Animal> finalListWithSelected = new ArrayList<>();
        finalListWithSelected.addAll(firstPartWithoutSelected);
        finalListWithSelected.add(selectedAnimal);
        finalListWithSelected.addAll(secondPartWithoutSelected);

        lvAnimals.setItems(FXCollections.observableArrayList(finalListWithSelected));

        lvAnimals.getFocusModel().focus(selectedAnimalListIndex);
        lvAnimals.getSelectionModel().select(selectedAnimalListIndex);
        lvAnimals.scrollTo(selectedAnimalListIndex);
    }

    private boolean isNewAnimal(Animal selectedAnimal){
        return selectedAnimal.getAnimalId() == 0;
    }

    @FXML
    void onAddButtonClicked(ActionEvent event) {
        enableEditMode();
        fillFieldsWithSelectedAnimalData(new Animal());
    }

    @FXML
    void removeExistingAnimal(ActionEvent event) {
        try {
            System.out.println(tagTextField.getText());
            service.checkAndRemoveAnimalByTag(tagTextField.getText());
            fillListView();
        } catch (EntityNotFoundException e) {
            // TODO create alert for EntityNotFoundException and other errors;
        }
    }


        // TODO implement the concept of " edit mode "
        //  when " edit mode " is enabled:
        //          - remove button will be disabled
        //          - all TextFields will be enabled
        //          - save button will save changes made to the existing animal
        //  when " edit mode " is disabled:
        //          - save button will be disabled and not visible
        //          - add button will be enabled and visible
        //          - remove button will be enabled
        //          - all textfields will be disabled
        // TODO buttom to save changes made to the selected animal
        // TODO whenever the selected animal changes, it should leave edit screen without saving the changes made.
        // TODO disable all fields if edit isn't pressed (including buttons save and remove)

    /*
        isEditing = true:
            edit mode is enabled, and all textfields will be enabled,
            save button will be visible ( add button won't be visible )
            remove button will be enabled
        isEditing = false:
            edit mode is disabled, no textfields should be enabled,
            add button will be visible ( save button won't be visible )
            remove button will be disabled
     */

    @FXML
    public void onEditButtonClicked(ActionEvent event){
        if (!isEditing){ // edit mode disabled
            enableEditMode();
        } else {
            disableEditMode();
        }
    }

    private void enableEditMode() {

        isEditing = true;

        visibilityOfItems(isEditing);
        focusabilityOfItems(isEditing);
        stateOfInputFields(isEditing);
    }

    private void disableEditMode() {

        isEditing = false;

        visibilityOfItems(isEditing);
        focusabilityOfItems(isEditing);
        stateOfInputFields(isEditing);
    }

    private void visibilityOfItems(boolean editMode) {
        tagTextField.setVisible(editMode);
        buttonSaveThisAnimal.setVisible(editMode);

        addNewAnimalButton.setVisible(!editMode);
        tagLabel.setVisible(!editMode);
    }

    private void focusabilityOfItems(boolean editMode) {
        buttonSaveThisAnimal.setFocusTraversable(editMode);
        tagTextField.setFocusTraversable(editMode);
        
        addNewAnimalButton.setFocusTraversable(!editMode);
    }

    private void stateOfInputFields(boolean editMode) {
        addNewAnimalButton.setDisable(editMode);

        tagTextField.setDisable(!editMode);
        dateOfBirthTextField.setDisable(!editMode);
        genderTextField.setDisable(!editMode);
        raceTextField.setDisable(!editMode);
        parentTagTextField.setDisable(!editMode);
        isNative.setDisable(!editMode);
        buttonSaveThisAnimal.setDisable(!editMode);
    }

    @FXML
    void searchAnimal(KeyEvent event) {
        if(KeyCode.ENTER.equals(event.getCode())){
            String tag = search.getText();
            if(tag != null && !tag.isEmpty()){
                Animal byTag = service.findByTag(tag);
                if(byTag != null){
                    selectedAnimal = byTag;
                    fillFieldsWithSelectedAnimalData(selectedAnimal);

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
    private void fillFieldsWithSelectedAnimalData(Animal animal){
        if(animal == null)
            return;

        selectedAnimalId = animal.getAnimalId();
        selectedAnimalListIndex = lvAnimals.getItems().indexOf(animal);
        setTextFieldsWithAnimalData(animal);
    }

    private void setTextFieldsWithAnimalData(Animal animal) {
        tagLabel.setText(animal.getTag());
        tagTextField.setText(animal.getTag());
        raceTextField.setText(animal.getRace());
        dateOfBirthTextField.setText(animal.getBirthDate());
        parentTagTextField.setText(animal.getParentTag());
        isNative.setSelected(animal.isIsNative());
        genderTextField.setText(animal.getGender());
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
                fillFieldsWithSelectedAnimalData(selectedAnimal);
                disableEditMode();
            }
        });
    }

    private Animal screenDataToAnimal(){
        return new Animal(
                selectedAnimalId,
                tagTextField.getText(),
                parentTagTextField.getText(),
                dateOfBirthTextField.getText(),
                genderTextField.getText(),
                raceTextField.getText(),
                isNative.isSelected());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        fillListView();
        disableEditMode();
    }
}
