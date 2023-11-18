package com.example.grafo2;

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

        Player player = new Player("Pepito");

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/grafo2/home-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 460, 460);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}