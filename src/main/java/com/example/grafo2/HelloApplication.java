package com.example.grafo2;
import com.example.grafo2.control.ControllerHomeScreen;
import com.example.grafo2.model.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/grafo2/home-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 460, 460);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        ControllerHomeScreen controller = fxmlLoader.getController();
        controller.setMainStage(stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}