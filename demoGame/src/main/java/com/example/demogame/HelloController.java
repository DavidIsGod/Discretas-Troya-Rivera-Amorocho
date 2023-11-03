package com.example.demogame;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private TextField nombreTextField;

    public void registrarJugador(ActionEvent event) {
        String name = nombreTextField.getText();
        System.out.println("Jugador registrado: " + name);
    }
}