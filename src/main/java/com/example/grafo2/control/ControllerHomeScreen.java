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


    @FXML
    private TextField nicknameField;

    private Stage mainStage;

    public void StartButtonClick (ActionEvent event) {
        String username = nicknameField.getText();
        openVentanaJuego();

    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }






    @FXML
    private void openVentanaJuego() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/grafo2/Juego.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Register papi");
            stage.setScene(new Scene(loader.load(), 740, 435));

            stage.show();

           Stage stage2 = (Stage) nicknameField.getScene().getWindow();
              stage2.close();


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


    public void UserVault(Player player) {
        this.userVault = player;
    }
}
