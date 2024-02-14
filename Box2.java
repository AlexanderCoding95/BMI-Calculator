package com.example.lab1alexandersadeghipour;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


public class Box2 {
    public static final int DEFAULT_MIN_WIDTH = 1000;
    public static final int DEFAULT_MIN_Height = 250;
    public static final String DEFAULT_CONFIRM = "End";

    public static void display(String title, String message, String confirm, int minWidth, int minHeight) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        window.setTitle(title);
        window.setMinWidth(minWidth);
        window.setMinHeight(minHeight);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button(confirm);

        closeButton.setOnAction(e -> {
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }


    public static void display(String title, String message) {
        Box2.display(title, message,
                Box2.DEFAULT_CONFIRM,
                Box2.DEFAULT_MIN_WIDTH,
                Box2.DEFAULT_MIN_Height);
    }


    public static void display(String title, String message, String confirm) {
        Box2.display(title, message, confirm, Box2.DEFAULT_MIN_WIDTH, Box2.DEFAULT_MIN_Height);
    }
}
