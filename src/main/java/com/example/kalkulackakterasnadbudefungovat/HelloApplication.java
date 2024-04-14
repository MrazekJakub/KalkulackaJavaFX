package com.example.kalkulackakterasnadbudefungovat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
       // posun aplikace mi nefunguje omlouvám se
        Scene scene = new Scene(fxmlLoader.load());
        scene.setFill(Color.TRANSPARENT);
        boolean add = stage.getIcons().add(new Image(getClass().getResource("/com/example/kalkulackakterasnadbudefungovat/ikonakalkulacka.png").toExternalForm())); //ikonu nevyužiju
        stage.setTitle("Kalkulačka");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}