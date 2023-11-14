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
        drawAvatar();
    }

    public void drawMap(Image mapImage) {
        setMapImage(mapImage);
    }

    public void drawAvatar() {
        avatar.paint();
    }

    public void setMapImage(Image mapImage) {
        double nuevoAncho = 600;
        double nuevoAlto = (nuevoAncho / mapImage.getWidth()) * mapImage.getHeight();

        canvas.setWidth(nuevoAncho);
        canvas.setHeight(nuevoAlto);

        graphicsContext.drawImage(mapImage, 0, 0, nuevoAncho+300, nuevoAlto-4);

    }


    public void onKeyPressed(KeyEvent event){
        this.avatar.onKeyPressed(event);
    }
    public void onKeyReleased(KeyEvent event) {
        switch (event.getCode()) {
            case RIGHT:
                avatar.setRightPressed(false);
                break;
            case UP:
                avatar.setUpPressed(false);
                break;
            case LEFT:
                avatar.setLeftPressed(false);
                break;
            case DOWN:
                avatar.setDownPressed(false);
                break;
        }

        if (!event.isControlDown() && !event.isAltDown() && !event.isMetaDown()) {
            avatar.onKeyReleasedAll();
        }
    }


}
