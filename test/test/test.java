/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class test extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("fuck Kien");
        Button button1 = new Button("fuck");
        button.setOnAction((event) -> {
            button.setStyle("-fx-background-color: blue;");
        });
        button1.setOnAction((event) -> {
            button1.setStyle("-fx-background-color: blue;");
        });
        StackPane root = new StackPane(button, button1);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
