package com.example.demogame;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Login2Jugadores {

    public TextField nicknameField1;

    public TextField nicknameField2;

    ArrayList<Player> players = new ArrayList<>();

    public void loginAction(ActionEvent actionEvent) {

        String nickname1 = nicknameField1.getText();

        String nickname2 = nicknameField2.getText();

        Player player1 = new Player(nickname1);
        Player player2 = new Player(nickname2);

        players.add(player1);
        players.add(player2);


        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ventanaDeJuego.fxml"));
            Parent root = loader.load();

            Scene nuevaEscena = new Scene(root);


            Stage ventanaDeJuego = new Stage();
            ventanaDeJuego.setTitle("Amorocho Gay");


            ventanaDeJuego.setScene(nuevaEscena);


            ventanaDeJuego.show();


            Stage ventanaActual = (Stage) nicknameField1.getScene().getWindow();
            ventanaActual.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    
    }
}
