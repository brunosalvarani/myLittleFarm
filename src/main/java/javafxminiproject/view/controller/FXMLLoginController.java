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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.java.javafxminiproject.model.User;
import main.java.javafxminiproject.utils.Context;

/**
 * FXML Controller class
 *
 * @author bruno
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private TextField userTextField;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    void login(ActionEvent event) {
        if(userTextField.getText().equals("bruno")){
            if(passwordTextField.getText().equals("123")){
                Context.setCurrentUser(new User(userTextField.getText(), passwordTextField.getText()));
                System.out.println("Login efetuado");  
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.close();
            } else {
                System.out.println("Senha incorreta");
            }
        } else {
            System.out.println("Usuário não encontrado");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
