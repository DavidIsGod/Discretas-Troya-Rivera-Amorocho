package com.example.grafo2.screens;

import com.example.grafo2.model.Avatar;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;


public class ScreenA {
    private Canvas canvas;
    private Avatar avatar;
    private GraphicsContext graphicsContext;

    public ScreenA(Canvas canvas) {
        this.canvas = canvas;
        this.graphicsContext = this.canvas.getGraphicsContext2D();
        this.avatar = new Avatar(this.canvas);

    }
    public void paint(Image mapImage) {
        drawMap(mapImage);
    }

    public void drawMap(Image mapImage) {

        setMapImage(mapImage);
    }


    public void setMapImage(Image mapImage) {
        double nuevoAncho = 900;
        double nuevoAlto = (nuevoAncho / mapImage.getWidth()) * mapImage.getHeight();

        canvas.setWidth(nuevoAncho + 400);
        canvas.setHeight(nuevoAlto);

        graphicsContext.drawImage(mapImage, 0, 0, nuevoAncho + 450, nuevoAlto+100);

    }




}
