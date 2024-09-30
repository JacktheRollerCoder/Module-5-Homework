import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXAssignment3 extends Application {

    @Override
    public void start(Stage primaryStage) {
        ClockPane clock = new ClockPane();
        clock.setPrefSize(250, 250); // Keep the clock size consistent

        // Create input fields for hour, minute, and second with fixed width
        TextField hourField = new TextField();
        hourField.setPrefWidth(40);
        TextField minuteField = new TextField();
        minuteField.setPrefWidth(40);
        TextField secondField = new TextField();
        secondField.setPrefWidth(40);

        // Create a button to set the time
        Button setTimeButton = new Button("Set Time");
        setTimeButton.setOnAction(e -> {
            try {
                int hour = Integer.parseInt(hourField.getText());
                int minute = Integer.parseInt(minuteField.getText());
                int second = Integer.parseInt(secondField.getText());
                
                // Set the time in the clock
                clock.setHour(hour);
                clock.setMinute(minute);
                clock.setSecond(second);
            } catch (NumberFormatException ex) {
                // Handle invalid input
                System.out.println("Invalid input. Please enter valid numbers for hour, minute, and second.");
            }
        });

        // Create HBox for controls
        HBox controls = new HBox(10, 
            new Label("Hour:"), hourField, 
            new Label("Minute:"), minuteField, 
            new Label("Second:"), secondField, 
            setTimeButton
        );
        controls.setPadding(new Insets(10));
        
        // Create a main layout with GridPane
        GridPane mainLayout = new GridPane();
        mainLayout.setPadding(new Insets(10));
        mainLayout.setVgap(10);
        mainLayout.setHgap(10);
        mainLayout.add(clock, 0, 0); // Add the clock at the top
        mainLayout.add(controls, 0, 1); // Add controls below the clock
        mainLayout.setAlignment(javafx.geometry.Pos.CENTER); // Center the grid

        // Create a scene and set the stage
        Scene scene = new Scene(mainLayout, 300, 200); // Adjust height as needed
        primaryStage.setTitle("JavaFXAssignment3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
