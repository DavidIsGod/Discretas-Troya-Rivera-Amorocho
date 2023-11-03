package com.example.demogame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField nicknameTextField;
    @FXML
    private PasswordField PasswordField;

    public void Login(ActionEvent event) {
        String nickname = nicknameTextField.getText();
        String password = PasswordField.getText();


        System.out.println("Login: " + nickname);
    }
}

