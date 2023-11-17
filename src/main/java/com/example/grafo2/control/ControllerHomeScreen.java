package com.example.grafo2.control;

import com.example.grafo2.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ControllerHomeScreen {

    @FXML
    private ImageView MazeImage;

    @FXML
    public void onStartGameButtonClick() {
        HelloApplication.hideWindow((Stage) MazeImage.getScene().getWindow());
        HelloApplication.showWindow("hello-view", 732, 624);
    }

}
