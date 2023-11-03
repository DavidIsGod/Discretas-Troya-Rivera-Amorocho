package com.example.demogame;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Login1jugador {

    public TextField nicknameField;
    ArrayList<Player> players = new ArrayList<>();

    public void loginAction(ActionEvent actionEvent) {

        String nickname = nicknameField.getText();
        Player player = new Player(nickname);

        players.add(player);

        for (Player players: players) {
            if (players != null) {
                try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ventanaDeJuego.fxml"));
                    Parent root = loader.load();

                    Scene nuevaEscena = new Scene(root);


                    Stage ventanaDeJuego = new Stage();
                    ventanaDeJuego.setTitle("GTA 90000");


                    ventanaDeJuego.setScene(nuevaEscena);


                    ventanaDeJuego.show();


                    Stage ventanaActual = (Stage) nicknameField.getScene().getWindow();
                    ventanaActual.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }



            }else{
                System.out.println("Error");
            }
        }

    }
}
