package com.example.grafo2.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.Objects;

public class Avatar {
    // elementos gráficos
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private ArrayList<Image> idles;
    private ArrayList<Image> right;
    private ArrayList<Image> down;

    private ArrayList<Image> left;

    private ArrayList<Image> up;
    private int frame;

    // elementos espaciales
    private Position position;
    private int state;

    private boolean rightPressed;
    private boolean upPressed;

    private boolean leftPressed;
    private boolean downPressed;
    //private final double screenWidth; // Ancho de la pantalla
    //private final double screenHeight; // Alto de la pantalla

    private double escala = 1.1;
    public Avatar(Canvas canvas) {

        this.canvas = canvas;
        this.graphicsContext = this.canvas.getGraphicsContext2D();

        this.state = 0;
        this.frame = 0;

        this.idles = new ArrayList<>();
        this.right = new ArrayList<>();
        this.down = new ArrayList<>();
        this.up = new ArrayList<>();
        this.left = new ArrayList<>();

        //this.screenWidth = canvas.getWidth();
        //this.screenHeight = canvas.getHeight();


        this.position = new Position(77, 0);


    }


}
