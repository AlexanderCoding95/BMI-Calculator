

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.geometry.Insets;

public class Main extends Application {

    private Stage window;


    public Scene buildScene() {
        //Specify names of the labels
        Label heightLabel = new Label("Height:");
        Label weightLabel = new Label("Weight:");
        //Specify text field background text
        TextField heightInput = new TextField();
        heightInput.setPromptText("Submit height here");
        TextField weightInput = new TextField();
        weightInput.setPromptText("Submit weight here");
        //Unit label
        Label heightUnitLabel = new Label("cm");
        Label weightUnitLabel = new Label("kg");


        Button calcButton = new Button();
        calcButton.setText("Click");
        calcButton.setOnAction(e -> {
            Double bmi = calculateBMI(heightInput, weightInput);
            if (bmi != null) {
                displayBMI(bmi);
            }
        });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(10);


        GridPane.setConstraints(heightLabel, 0,0);
        GridPane.setConstraints(weightLabel, 0,1);
        GridPane.setConstraints(heightInput,1,0);
        GridPane.setConstraints(weightInput, 1,1);
        GridPane.setConstraints(heightUnitLabel,2,0);
        GridPane.setConstraints(weightUnitLabel,2,1);
        GridPane.setConstraints(calcButton,1,2);

        grid.getChildren().addAll(heightLabel, weightLabel, heightInput, weightInput,
                heightUnitLabel,weightUnitLabel,calcButton);



        return new Scene(grid, 300,120);
    }

    public Double calculateBMI(TextField heightInput, TextField weightInput) {
        Double bmi = null;
        try {
            double height = Double.parseDouble(heightInput.getText()) / 100;
            double weight = Double.parseDouble(weightInput.getText());
            if (height <= 0 || weight <= 0) {
                throw new IllegalArgumentException();
            }
            bmi = new Double(weight / (height * height));
        } catch(NumberFormatException e1) {
            Box2.display("Error", "Letters are not allowed in this scope");
        } catch(IllegalArgumentException e2) {
            Box2.display("Error", "Positive numbers only");
        }


        if (bmi == null) {
            heightInput.setText("");
            weightInput.setText("");
        }

        return bmi;
    }

    public void displayBMI(double bmi) {
        String message;
        if (bmi >=35) {
            message = "are extremely obese and should see a local doctor immediately";
        } else if (bmi >= 30) {
            message = "are moderately obese";
        } else if (bmi >= 25) {
            message = "are slightly overweight";
        } else if (bmi >= 18.5) {
            message = "have a healthy weight";
        } else if (bmi >= 16) {
            message = "are underweight and should see a local doctor immediately";
        } else {
            message = "are extremely underweight and should see a local doctor immediately";
        }
        Box2.display("Result", String.format("Your BMI is %.2f,\n You %s.",bmi, message));
    }

    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Individual Health Assessment Program");

        Scene scene = buildScene();
        window.setScene(scene);

        window.setOnCloseRequest(e -> {
            e.consume();
            Boolean response = Box1.display("End program", "Would you like to exit?");
            if (response != null && response == true) {
                window.close();
            }
        });

        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
