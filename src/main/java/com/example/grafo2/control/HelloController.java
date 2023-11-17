package com.example.grafo2.control;

import com.example.grafo2.screens.ScreenA;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    @FXML
    private GraphicsContext graphicsContext;
    @FXML
    private ScreenA screenA;
    @FXML
    private Canvas canvas;

    @FXML
    private TextField nombreTextField;

    @FXML
    private Label passwordTextField;

    @FXML
    private Label nicknameField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.graphicsContext = canvas.getGraphicsContext2D();
        this.screenA = new ScreenA(this.canvas);

        // Cargar la imagen de fondo-
        Image backgroundImage = new Image(getClass().getResourceAsStream("/portada/img.png"));

        graphicsContext.drawImage(backgroundImage, 0, 0);


        //Permite movimiento
        this.canvas.setOnKeyPressed(event -> {
            screenA.onKeyPressed(event);
        });
        //Detiene el personaje cuando de presionar la tecla
        this.canvas.setOnKeyReleased(event -> {
            screenA.onKeyReleased(event);
        });

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
    public void registrarJugador(ActionEvent event) {
        String name = nombreTextField.getText();
        String password = passwordTextField.getText();


        System.out.println("Jugador registrado: " + name);
    }
}