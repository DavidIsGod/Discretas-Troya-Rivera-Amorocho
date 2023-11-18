package com.example.grafo2.control;

import com.example.grafo2.model.Player;
import com.example.grafo2.screens.ScreenA;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HelloController  {

    private Player player;


    private PasswordField passwordField;




    public void registrarJugador(ActionEvent event) {
        String name = passwordField.getText();
        player.setNickname(name);

        if (player != null) {
            if (name.equals(player.getNickname())) {
                Juego();
            } else {
                showAlert("Contraseña incorrecta", "La contraseña ingresada es incorrecta.");
            }
        } else {
            showAlert("Error", "El objeto UserVault no ha sido inicializado.");
        }

    }

    public void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);

        alert.showAndWait();
    }

    public void Juego() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/grafo2/Juego.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Level 1 - 1");
            stage.setScene(new Scene(loader.load(), 460, 460));

            stage.show();

            Stage currentStage = (Stage) passwordField.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}