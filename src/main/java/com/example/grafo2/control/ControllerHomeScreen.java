package com.example.grafo2.control;

import com.example.grafo2.HelloApplication;
import com.example.grafo2.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Scene;

import java.io.IOException;

public class ControllerHomeScreen {

    private Player userVault;

    private PasswordField passwordField;

    private Stage mainStage;

    public void StartButtonClick (ActionEvent event) {
        openVentanaJuego();
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    @FXML
    private void openVentanaJuego() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/grafo2/hello-controller.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Register papi");
            stage.setScene(new Scene(loader.load(), 460, 460));

            stage.show();

            mainStage.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);

        alert.showAndWait();
    }




}
