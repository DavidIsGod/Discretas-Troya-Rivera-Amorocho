package com.example.grafo2.control;



import com.example.grafo2.model.Player;
import com.example.grafo2.screens.ScreenA;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class JuegoController implements Initializable {

    private Player player;

    @FXML
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private ScreenA screenA;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.graphicsContext = canvas.getGraphicsContext2D();
        this.screenA = new ScreenA(this.canvas);


        Image backgroundImage = new Image(getClass().getResourceAsStream("/portada/Map Maze xd.jpg"));

        graphicsContext.drawImage(backgroundImage, 500, 1200);

        // Permite movimiento
        this.canvas.setOnKeyPressed(event -> {
            screenA.onKeyPressed(event);

        });
        // Detiene el personaje cuando de presionar la tecla
        this.canvas.setOnKeyReleased(event -> {
            screenA.onKeyReleased(event);
        });

        // Hilo de Java
        new Thread(
                () -> {
                    while (true) {

                        Platform.runLater(() -> {
                            screenA.paint(backgroundImage);

                        });

                        try {
                            Thread.sleep(70);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

    }

}





