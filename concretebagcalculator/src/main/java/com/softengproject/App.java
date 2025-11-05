package com.softengproject;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * JavaFX App
 */
public class App extends Application {

    private TextArea outputArea;
    private ObservableList<String> savedCalculationsList = FXCollections.observableArrayList();
    private ListView<String> savedCalculationsView;

    @Override
    public void start(Stage stage) throws IOException {
        
        //Top Left Section (Image and Dropdown)
        VBox leftControlBox = new VBox(10);
        leftControlBox.setPadding(new Insets(20));

        Image shapesImage = new Image(getClass().getResourceAsStream("/images/shapes_image.png"));
        ImageView imageView = new ImageView(shapesImage);
        imageView.setFitWidth(200); //set image size
        imageView.setPreserveRatio(true);

        Label shapeLabel = new Label("Select Shape;");
        ChoiceBox<String> shapeChoiceBox = new ChoiceBox<>();
        shapeChoiceBox.setItems(FXCollections.observableArrayList(
                "Rectangle", "Square", "Circle", "Triangle"
        ));
        leftControlBox.getChildren().addAll(imageView, shapeLabel, shapeChoiceBox);

        //Top right section (parameters)
        GridPane parameterPane = new GridPane();
        parameterPane.setPadding(new Insets(20));
        parameterPane.setHgap(10);
        parameterPane.setVgap(10);
        //allign the gridpane to the top right of the window
        parameterPane.setAlignment(Pos.TOP_RIGHT);

        final Label lengthLabel = new Label("L:");
        final Label widthLabel = new Label("W:");
        final Label depthLabel = new Label("D:");
        final Label radiusLabel = new Label("R:");

        final TextField lengthField = new TextField();
        final TextField widthField = new TextField();
        final TextField depthField = new TextField(); // depth field is always displayed
        final TextField radiusField = new TextField();

        //Add to the gridpane
        parameterPane.add(lengthLabel, 0, 0); parameterPane.add(lengthField, 1, 0);
        parameterPane.add(widthLabel, 0, 1); parameterPane.add(widthField, 1, 1);
        parameterPane.add(depthLabel, 0, 2); parameterPane.add(depthField, 1, 2);
        parameterPane.add(radiusLabel, 0, 3); parameterPane.add(radiusField, 1, 3);

        //center section (history list)
        savedCalculationsView = new ListView<>(savedCalculationsList);
        savedCalculationsView.setPlaceholder(new Label("No saved calculations yet."));

        VBox historyBox = new VBox(10, new Label("Saved Calculations:"), savedCalculationsView);
        historyBox.setPadding(new Insets(0, 20, 0, 20));
        VBox.setVgrow(savedCalculationsView, Priority.ALWAYS);

        //bottom sections (output on the left, buttons on the right)

        //Bottom Left: output area or total bags needed
        outputArea = new TextArea(); // initializing the output area
        outputArea.setEditable(false);
        outputArea.setPromptText("Calculation Results: ");
        outputArea.setWrapText(true);
        outputArea.setPrefHeight(100); //fixed height

        VBox outputBox = new VBox(10, new Label("Current Results:"), outputArea);
        outputBox.setPadding(new Insets(0, 10, 20, 20));

        //Bottom Right: Buttons
        HBox buttonBar = new HBox(15);
        buttonBar.setPadding(new Insets(0, 20, 20, 10));
        buttonBar.setAlignment(Pos.BOTTOM_RIGHT);
        Button calculateButton = new Button("Calculate");
        Button addToListButton = new Button("Add to List");
        Button saveToFileButton = new Button("Save");
        Button clearButton = new Button("Clear");
        buttonBar.getChildren().addAll(calculateButton,addToListButton, saveToFileButton, clearButton);

        //a nested BorderPane for the bottom area
        BorderPane bottomPane = new BorderPane();
        bottomPane.setLeft(outputBox);
        bottomPane.setRight(buttonBar);
        //ensure the output area stretches horizontally with window resize
        HBox.setHgrow(outputBox, Priority.ALWAYS);

        //main layout(borderpane)
        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(new HBox(leftControlBox, parameterPane)); //combine top left and right
        mainLayout.setCenter(historyBox);
        mainLayout.setBottom(bottomPane);

        //listener to manage which output fields are vsible based on selected shape
        shapeChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            //reset the parameters before applying specific rules
            lengthLabel.setVisible(true);
            lengthField.setVisible(true);
            widthLabel.setVisible(true);
            widthField.setVisible(true);
            radiusLabel.setVisible(true);
            radiusField.setVisible(true);
            //depth field is always visible

            if("Rectangle".equals(newValue)) {
                radiusLabel.setVisible(false); radiusField.setVisible(false);
            } else
            if ("Circle".equals(newValue)) {
                lengthLabel.setVisible(false); lengthField.setVisible(false);
                widthLabel.setVisible(false); widthField.setVisible(false);
            } else if ("Square".equals(newValue)) {
                widthLabel.setVisible(false); widthField.setVisible(false);
                radiusLabel.setVisible(false); radiusField.setVisible(false);
            } else if ("Triangle".equals(newValue)) {
                radiusLabel.setVisible(false); radiusField.setVisible(false);
            }
        });

        //Place Holder Button Logic...
        calculateButton.setOnAction(event -> {
            System.out.println("Calculate button clicked. Logic to be implemented.");
            outputArea.setText("Calculation logic goes here.");
        });

        addToListButton.setOnAction(event -> {
            System.out.println("Add to List button clicked. Logic to be implemented.");
            outputArea.setText("Add to List logic goes here.");
        });

        saveToFileButton.setOnAction(event -> {
            System.out.println("Save button clicked. Logic to be implemented.");
            outputArea.setText("Save logic goes here.");
        });

        clearButton.setOnAction(event -> {
            System.out.println("Clear button clicked. Resetting fields.");
            lengthField.clear();
            widthField.clear();
            depthField.clear();
            radiusField.clear();
            outputArea.clear();
            shapeChoiceBox.getSelectionModel().selectFirst();
        });

        Scene scene = new Scene(mainLayout,800,600);
        stage.setTitle("Concrete Calculator");
        stage.setScene(scene);
        stage.show();

        shapeChoiceBox.getSelectionModel().selectFirst();
    }

    public static void main(String[] args) {
        launch(args);
    }

}