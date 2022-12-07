/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.javafxminiproject.view.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import main.java.javafxminiproject.model.CheckUp;
import main.java.javafxminiproject.service.CheckUpService;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author bruno
 */


public class FXMLCheckUpController implements Initializable {
    private final String[] areasFromMyLittleFarm = {"Area 1", "Montanha", "Vargem", "Beira Mar"};

    @FXML
    private TextField tagTextField;

    @FXML
    private TextField textfieldWeigh;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ChoiceBox<String> choiceBoxDesignatedArea;

    @FXML
    private Label labelTag;

    @FXML
    private CheckBox checkBox;

    @FXML
    private TextArea textArea;

    @FXML
    private Button buttonSave;


    @FXML
    void saveCheckUp(ActionEvent event) {

        CheckUpService instance = CheckUpService.getInstance();

        CheckUp checkUp = new CheckUp(Double.parseDouble(textfieldWeigh.getText()),
                choiceBoxDesignatedArea.getSelectionModel().getSelectedItem(),
                datePicker.getValue().toString(),
                textArea.getText());

        instance.passCheckUpToRepository(checkUp, tagTextField.getText());

        if (!checkBox.isSelected()){
            Stage stage = (Stage) buttonSave.getScene().getWindow();
            stage.close();
        }

        //TODO check if the Tag(animal) exists,
        // yes: save the checkUp -> call CheckUpService
        // no: error entityNotFound
    }
    private static FXMLCheckUpController instance;

    public static FXMLCheckUpController getInstance(){
        if (instance == null) {
            instance = new FXMLCheckUpController();
        }
        return instance;
    }

    public void fillFieldsOnCheckUpPage(String tag){
        //TODO make this method work.
        tagTextField.setText(tag);
        textfieldWeigh.setText(null);
        textArea.setText(null);
        checkBox.setSelected(false);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choiceBoxDesignatedArea.getItems().addAll(areasFromMyLittleFarm);
    }

}
