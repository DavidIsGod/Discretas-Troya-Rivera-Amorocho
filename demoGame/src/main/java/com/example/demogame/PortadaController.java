package com.example.demogame;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PortadaController {
    public void jugarUnJugador(ActionEvent actionEvent) {

        Stage ventanaActual = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        ventanaActual.close();

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("login1jugador.fxml"));
            Parent root = loader.load();

            Scene nuevaEscena = new Scene(root);

            Stage nuevaVentana = new Stage();
            nuevaVentana.setTitle("Login");
            nuevaVentana.setScene(nuevaEscena);

            nuevaVentana.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    public void jugarDosJugadores(ActionEvent actionEvent) {

        Stage ventanaActual = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        ventanaActual.close();

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("login2jugadores.fxml"));
            Parent root = loader.load();

            Scene nuevaEscena = new Scene(root);

            Stage nuevaVentana = new Stage();
            nuevaVentana.setTitle("Login");
            nuevaVentana.setScene(nuevaEscena);

            nuevaVentana.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
