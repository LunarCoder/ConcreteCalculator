import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.StackPane;

public class App extends Application {

    public void start(Stage primaryStage){
        StackPane root = new StackPane();
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.setTitle("ConcreteCalculator");
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
