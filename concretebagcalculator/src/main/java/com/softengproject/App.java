package com.softengproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.VBox;
import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private Concrete concrete;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Concrete Bag Calculator");
        concrete = new Concrete();

        Button saveButton = new Button("Save");
        Button loadButton = new Button("Load");
        Button showButton = new Button("Show Shapes");
        saveButton.setOnAction(e -> {
            concrete.saveFile();
        });
        loadButton.setOnAction(e -> {
            concrete.loadFile("shapes_2025_10_28_11_59_09");
        });
        showButton.setOnAction(e -> {
            concrete.getShapes().forEach(shape -> {
                System.out.println(shape);
            });
        });

        VBox vbox = new VBox(saveButton, loadButton, showButton);
        Scene scene = new Scene(vbox,400, 200);
        
        stage.setScene(scene);  
        stage.show();

    }


    public static void main(String[] args) {
        launch();
    }

}