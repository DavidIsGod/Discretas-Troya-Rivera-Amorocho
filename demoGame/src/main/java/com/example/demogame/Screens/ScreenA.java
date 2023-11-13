package com.example.demogame.Screens;

import com.example.demogame.Player;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class    ScreenA {

    @FXML
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private Player player;

    public ScreenA(Canvas canvas) {
        this.canvas = canvas;
        this.graphicsContext = this.canvas.getGraphicsContext2D();
    //    this.player = new Player(this.canvas);

    }


    public void paint(Image mapImage) {
        drawMap(mapImage);
    //    drawBomberMan();
    }
    public void drawMap(Image mapImage) {
        setMapImage(mapImage);
    }

   // public void drawBomberMan() {
    //    player.paint();
   // }
    public void setMapImage(Image mapImage) {
        double nuevoAncho = 900;
        double nuevoAlto = (nuevoAncho / mapImage.getWidth()) * mapImage.getHeight();

        canvas.setWidth(nuevoAncho+400);
        canvas.setHeight(nuevoAlto);

        graphicsContext.drawImage(mapImage, 0, 0, nuevoAncho+300, nuevoAlto-4);

    }
}

