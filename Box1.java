package com.example.lab1alexandersadeghipour;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.*;


public class Box1 {
    public static final int DEFAULT_MIN_WIDTH = 750;
    public static final int DEFAULT_MIN_Height = 250;
    private static Boolean response;
    public static Boolean display(String title, String message, int minWidth, int minHeight) {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(minWidth);
        window.setMinHeight(minHeight);
        window.setOnCloseRequest(e -> {
            Box1.response = null;
            window.close();
        });


        Label label = new Label();
        label.setText(message);


        Button yesButton = new Button("Sure");
        Button noButton = new Button("No, stay");


        yesButton.setOnAction(e -> {
            Box1.response = true;
            window.close();
        });
        noButton.setOnAction(e -> {
            Box1.response = false;
            window.close();
        });


        BorderPane subLayout = new BorderPane();
        int sideMargin = (int) (minWidth * 1.0 / 4);
        subLayout.setPadding(new Insets(0, sideMargin,0, sideMargin));
        subLayout.setLeft(yesButton);
        subLayout.setRight(noButton);

        VBox layout = new VBox();
        layout.setSpacing(20);
        layout.getChildren().addAll(label, subLayout);
        layout.setAlignment(Pos.CENTER);


        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return Box1.response;
    }

    public static Boolean display(String title, String message) {
        return Box1.display(title, message, Box1.DEFAULT_MIN_WIDTH, Box1.DEFAULT_MIN_Height);
    }
}
