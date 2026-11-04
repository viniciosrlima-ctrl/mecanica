package com.senai.mecanica;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 560);
        stage.setTitle("Oficina Mecânica | Acesso ao Sistema");
        stage.setMinWidth(560);
        stage.setMinHeight(480);
        stage.setScene(scene);
        stage.show();
    }
}
