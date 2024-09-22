import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class JavaFXAssignment2 extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a pane to hold the circle and label
        StackPane pane = new StackPane();

        // Create a circle and set its properties
        Circle circle = new Circle(50, Color.WHITE);
        circle.setStroke(Color.BLACK);
        pane.getChildren().add(circle); // Add circle to the pane 

        // Create a label and set its properties
        Label label = new Label("");
        label.setTextFill(Color.BLACK); // Set label text color
        pane.getChildren().add(label);

        // Set mouse pressed and released event handlers
        circle.setOnMousePressed(e -> {
            circle.setFill(Color.BLACK); // Change to black on press
            label.setTextFill(Color.WHITE); // Change label color for contrast
        });
        circle.setOnMouseReleased(e -> {
            circle.setFill(Color.WHITE); // Change back to white on release
            label.setTextFill(Color.BLACK); // Reset label color
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("JavaFXAssignment2"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        launch(args); // Launch the application
    }
}
