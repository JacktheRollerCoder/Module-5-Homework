import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.stage.Stage;

public class JavaFXAssignment1 extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a GridPane to hold the images
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        // Load images using relative paths
        Image image1 = new Image(getClass().getResourceAsStream("/flag2.gif"));
        Image image2 = new Image(getClass().getResourceAsStream("/flag7.gif"));
        Image image3 = new Image(getClass().getResourceAsStream("/flag6.gif"));
        Image image4 = new Image(getClass().getResourceAsStream("/flag1.gif"));
        
        // Create ImageViews for each image
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);
        ImageView imageView4 = new ImageView(image4);
        
        // Set the size of the ImageViews
        imageView1.setFitHeight(100);
        imageView1.setFitWidth(200);
        imageView2.setFitHeight(100);
        imageView2.setFitWidth(200);
        imageView3.setFitHeight(100);
        imageView3.setFitWidth(200);
        imageView4.setFitHeight(100);
        imageView4.setFitWidth(200);
        
        // Add ImageViews to the GridPane
        gridPane.add(imageView1, 0, 0);
        gridPane.add(imageView2, 1, 0);
        gridPane.add(imageView3, 0, 1);
        gridPane.add(imageView4, 1, 1);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("Show Images"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage 
        primaryStage.show(); // Display the stage 
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
