package com.example.grafo2.control;



import com.example.grafo2.model.Player;
import com.example.grafo2.screens.ScreenA;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


import javafx.application.Platform;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
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

    @FXML
    private ToggleGroup toggleGroup;

    @FXML
    private AnchorPane anchorPane;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        this.graphicsContext = canvas.getGraphicsContext2D();
        this.screenA = new ScreenA(this.canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setStroke(Color.RED);
        gc.setLineWidth(2.0);

        Point2D nodo1 = new Point2D(10, 10);
        Point2D nodo2 = new Point2D(100, 100);



        gc.strokeLine(nodo1.getX(), nodo1.getY(), nodo2.getX(), nodo2.getY());


        inicializarNodos();



        conectarNodos("Node1", "Node2");
        conectarNodos("Node2", "Node3");
        conectarNodos("Node3", "Node4");
        conectarNodos("Node4", "Node5");
        conectarNodos("Node5", "Node6");
        conectarNodos("Node6", "Node7");
        conectarNodos("Node7", "Node8");
        conectarNodos("Node8", "Node9");
        conectarNodos("Node9", "Node10");
        conectarNodos("Node10", "Node11");
        conectarNodos("Node11", "Node12");
        conectarNodos("Node12", "Node13");
        conectarNodos("Node13", "Node14");
        conectarNodos("Node14", "Node15");
        conectarNodos("Node15", "Node16");
        conectarNodos("Node16", "Node17");
        conectarNodos("Node17", "Node18");
        conectarNodos("Node18", "Node19");
        conectarNodos("Node19", "Node20");
        conectarNodos("Node20", "Node21");
        conectarNodos("Node21", "Node22");
        conectarNodos("Node22", "Node23");
        conectarNodos("Node23", "Node24");
        conectarNodos("Node24", "Node25");
        conectarNodos("Node25", "Node26");
        conectarNodos("Node26", "Node27");
        conectarNodos("Node27", "Node28");
        conectarNodos("Node28", "Node29");
        conectarNodos("Node29", "Node30");
        conectarNodos("Node30", "Node31");
        conectarNodos("Node31", "Node32");
        conectarNodos("Node32", "Node33");
        conectarNodos("Node33", "Node34");
        conectarNodos("Node34", "Node35");
        conectarNodos("Node35", "Node36");
        conectarNodos("Node36", "Node37");
        conectarNodos("Node37", "Node38");
        conectarNodos("Node38", "Node39");
        conectarNodos("Node39", "Node40");
        conectarNodos("Node40", "Node41");
        conectarNodos("Node41", "Node42");
        conectarNodos("Node42", "Node43");
        conectarNodos("Node43", "Node44");
        conectarNodos("Node44", "Node45");
        conectarNodos("Node45", "Node46");
        conectarNodos("Node46", "Node47");
        conectarNodos("Node47", "Node48");
        conectarNodos("Node48", "Node49");
        conectarNodos("Node49", "Node50");
        conectarNodos("Node50", "Node51");
        conectarNodos("Node51", "Node52");
        conectarNodos("Node52", "Node53");
        conectarNodos("Node53", "Node54");
        conectarNodos("Node54", "Node55");
        conectarNodos("Node55", "Node56");
        conectarNodos("Node56", "Node57");
        conectarNodos("Node57", "Node58");
        conectarNodos("Node58", "Node59");
        conectarNodos("Node59", "Node60");
        conectarNodos("Node60", "Node61");
        conectarNodos("Node61", "Node62");
        conectarNodos("Node62", "Node63");
        conectarNodos("Node63", "Node64");
        conectarNodos("Node64", "Node65");
        conectarNodos("Node65", "Node66");
        conectarNodos("Node66", "Node67");
        conectarNodos("Node67", "Node68");
        conectarNodos("Node68", "Node69");
        conectarNodos("Node69", "Node70");
        conectarNodos("Node70", "Node71");
        conectarNodos("Node71", "Node72");
        conectarNodos("Node72", "Node73");
        conectarNodos("Node73", "Node74");
        conectarNodos("Node74", "Node75");
        conectarNodos("Node75", "Node76");
        conectarNodos("Node76", "Node77");
        conectarNodos("Node77", "Node78");
        conectarNodos("Node78", "Node79");
        conectarNodos("Node79", "Node80");
        conectarNodos("Node80", "Node81");
        conectarNodos("Node81", "Node82");
        conectarNodos("Node82", "Node83");
        conectarNodos("Node83", "Node84");
        conectarNodos("Node84", "Node85");
        conectarNodos("Node85", "Node86");
        conectarNodos("Node86", "Node87");





        Image backgroundImage = new Image(getClass().getResourceAsStream("/portada/Map Maze xd.jpg"));

        graphicsContext.drawImage(backgroundImage, 500, 500);

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


    private void inicializarNodos() {
        for (int i = 1; i <= 87; i++) {
            RadioButton radioButton = (RadioButton) anchorPane.lookup("#Node" + i);
            radioButton.setToggleGroup(toggleGroup);
            final int nodo = i;

            radioButton.setOnAction(event -> {
                System.out.println("Seleccionado el nodo: " + nodo);
                // Puedes realizar acciones adicionales aquí si es necesario
            });
        }
    }

    private void conectarNodos(String nodo1, String nodo2) {
        RadioButton radioButton1 = (RadioButton) anchorPane.lookup("#" + nodo1);
        RadioButton radioButton2 = (RadioButton) anchorPane.lookup("#" + nodo2);

        // Configurar acciones de los nodos (puedes personalizar esto según tus necesidades)
        radioButton1.setOnAction(event -> {
            System.out.println("Conectado a: " + nodo2);
            // Puedes realizar acciones adicionales aquí si es necesario
        });

        radioButton2.setOnAction(event -> {
            System.out.println("Conectado a: " + nodo1);
            // Puedes realizar acciones adicionales aquí si es necesario
        });
    }



}





