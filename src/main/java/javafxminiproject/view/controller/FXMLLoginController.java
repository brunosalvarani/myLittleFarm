/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.javafxminiproject.view.controller;

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
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import main.java.javafxminiproject.model.User;
import main.java.javafxminiproject.service.LoginService;
import main.java.javafxminiproject.utils.Context;
import main.java.javafxminiproject.view.ParentScreenFactory;
import main.java.javafxminiproject.view.ScreenEnum;

/**
 * FXML Controller class
 *
 * @author bruno
 */
public class FXMLLoginController implements Initializable {
    private LoginService serviceInstance = new LoginService().getInstance();

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button loginButton;

    @FXML
    private Button newAccountButton;

    @FXML
    private CheckBox saveUserCheckBox;

    @FXML
    void changeCheckBoxState(KeyEvent event) {

    }

    @FXML
    void login(KeyEvent event) {
        User user = new User(usernameTextField.getText(), passwordTextField.getText());
        if (serviceInstance.validateLogin(user) != 0){

        } else {
            Stage stage = (Stage) loginButton.getScene().getWindow();
            Scene animalHomePageScreenScene = ParentScreenFactory.getInstance().getParentScreen(ScreenEnum.HOME);
            stage.close();

            Stage dialog = new Stage();
            dialog.setTitle("Home Page");
            dialog.setScene(animalHomePageScreenScene);
            dialog.show();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}