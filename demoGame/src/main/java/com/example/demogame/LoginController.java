package com.example.demogame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.util.ArrayList;

public class LoginController {

    ArrayList<Player> players = new ArrayList<>();
    @FXML
    private TextField nicknameTextField;
    @FXML
    private PasswordField PasswordField;

    public void Login(ActionEvent event) {
        String nickname = nicknameTextField.getText();
        String password = PasswordField.getText();

        Player player = new Player(nickname, password);

        players.add(player);

        for (Player players: players) {
            if (players != null) {
                System.out.println("Player added succesfully");



            }else{
                System.out.println("Error");
            }
        }
    }
}

