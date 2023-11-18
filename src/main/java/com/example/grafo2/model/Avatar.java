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
    private final double screenWidth; // Ancho de la pantalla
    private final double screenHeight; // Alto de la pantalla

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

        this.screenWidth = canvas.getWidth();
        this.screenHeight = canvas.getHeight();


        this.position = new Position(77, 0);



        for (int i = 0; i <1 ; i++) {
            Image idleImage = new Image(getClass().getResourceAsStream("/animations.avatar/STOP/Avatar_STOP_0"+i+".png"));
            this.idles.add(idleImage);


        }
        // Load run animation
        for (int i = 0; i < 3; i++) {
            String imagePath = "/animations.avatar/RIGHT/Avatar_RIGHT_0"+i+".png";
            Image runImage = new Image(getClass().getResourceAsStream(imagePath));
            this.right.add(runImage);
        }

        for (int i = 0; i <3 ; i++) {
            String imagePath = "/animations.avatar/DOWN/Avatar_DOWN_0"+i+".png";
            Image downImage = new Image(getClass().getResourceAsStream(imagePath));
            this.down.add(downImage);
        }
        for (int i = 0; i <3 ; i++) {
            String imagePath = "/animations.avatar/UP/Avatar_UP_0"+i+".png";
            Image upImage = new Image(getClass().getResourceAsStream(imagePath));
            this.up.add(upImage);
        }
        for (int i = 0; i < 3; i++) {
            String imagePath = "/animations.avatar/LEFT/Avatar_LEFT_0"+i+".png";
            Image leftImage = new Image(getClass().getResourceAsStream(imagePath));
            this.left.add(leftImage);
        }
    }


    public void paint() {
        double width = getImageWidth() * escala;
        double height = getImageHeight() * escala;
        onMove();
        if (state ==0 ) {
            graphicsContext.drawImage(idles.get(frame % idles.size()), position.getX(), position.getY(), width, height);
            frame++;
        } else if (state == 1) {
            graphicsContext.drawImage(right.get(frame % right.size()), position.getX(), position.getY(), width, height);
            frame++;
        } else if (state == 2) {
            graphicsContext.drawImage(up.get(frame % up.size()), position.getX(), position.getY(), width, height);
            frame++;
        } else if (state == 3) {
            graphicsContext.drawImage(left.get(frame % left.size()), position.getX(), position.getY(), width, height);
            frame++;
        } else if (state == 4) {
            graphicsContext.drawImage(down.get(frame % down.size()), position.getX(), position.getY(), width, height);
            frame++;
        }
    }

    public void onKeyPressed(KeyEvent event) {
        if (Objects.requireNonNull(event.getCode()) == KeyCode.RIGHT) {
            state = 1;
            rightPressed = true;
        }else if (event.getCode() == KeyCode.UP) {

            state = 2;
            upPressed = true;
        }else if (event.getCode() == KeyCode.LEFT) {
            state = 3;
            leftPressed = true;
        } else if (event.getCode() == KeyCode.DOWN) {
            state = 4;
            downPressed = true;
        }
    }
    public void setDownPressed(boolean downPressed) {
        this.downPressed = downPressed;
    }
    public void setLeftPressed(boolean leftPressed) {
        this.leftPressed = leftPressed;
    }

    public void setRightPressed(boolean rightPressed) {
        this.rightPressed = rightPressed;
    }

    public void setUpPressed(boolean upPressed) {
        this.upPressed = upPressed;
    }


    public void onMove() {
        if (rightPressed) {
            // Mueve hacia la derecha si no supera el límite derecho
            if (position.getX() + 10 + getImageWidth()-10 <= screenWidth) {
                position.setX(position.getX() + 10);
            }
        } else if (upPressed) {
            // Mueve hacia arriba si no supera el límite superior
            if (position.getY() - 10 >= 0) {
                position.setY(position.getY() - 10);
            }
        } else if (downPressed) {
            // Mueve hacia abajo si no supera el límite inferior
            if (position.getY() + 10 + getImageHeight() <= screenHeight) {
                position.setY(position.getY() + 10);
            }
        } else if (leftPressed) {
            // Mueve hacia la izquierda si no supera el límite izquierdo
            if (position.getX() - 82 >= 0) {
                position.setX(position.getX() - 10);
            }
        }
    }
    //Ajusta el ancho
    private double getImageWidth() {
        return ((idles.get(0)).getWidth()-1000);
    }
    //Ajusta la altura
    private double getImageHeight() {
        return idles.get(0).getHeight()-1000;
    }
    public void onKeyReleasedAll() {
        rightPressed = false;
        upPressed = false;
        leftPressed = false;
        downPressed = false;
        state = 0;
        frame = 0;
    }


}
