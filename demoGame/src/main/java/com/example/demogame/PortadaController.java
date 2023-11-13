package com.example.demogame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import com.example.demogame.Screens.ScreenA;
import javafx.application.Platform;
import javafx.scene.image.Image;

import java.net.URL;
import java.util.ResourceBundle;

public class PortadaController implements Initializable{

    @FXML
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private ScreenA screenA;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.graphicsContext = canvas.getGraphicsContext2D();
        this.screenA = new ScreenA(this.canvas);

        // Cargar la imagen de fondo
        Image backgroundImage = new Image(getClass().getResourceAsStream("/map/mapa.png"));

        graphicsContext.drawImage(backgroundImage, 0, 0);


        // Hilo de Java
        new Thread(
                () -> {
                    while (true){

                        Platform.runLater( () -> {
                            screenA.paint(backgroundImage);

                        });

                        try {
                            Thread.sleep(70);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
        ).start();

    }
}
