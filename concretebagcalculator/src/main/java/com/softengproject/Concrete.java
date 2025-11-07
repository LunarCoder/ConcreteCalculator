package com.softengproject;

import java.util.ArrayList;
import com.softengproject.Shape;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Concrete {
    private ArrayList<Shape> shapes;

    public Concrete() {
        shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void clearShapes() {
        shapes.clear();
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public void saveFile() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime now = LocalDateTime.now();
        String filename= "shapes_" + now.format(dtf);
        System.out.println(filename);

        //Save shapes to a file, each line is a shape name with parameters separated by dashes
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Shape shape : shapes) {
                if (shape.toString().equals("Circle")) {
                    Circle circle = (Circle) shape;
                    writer.println("Circle-" + circle.getRadius() + "-" + circle.getDepth());
                } else if (shape.toString().equals("Triangle")) {
                    Triangle triangle = (Triangle) shape;
                    writer.println("Triangle-" + triangle.getbase() + "-" + triangle.getHeight() + "-" + triangle.getDepth());
                } else if (shape.toString().equals("Rectangle")) {
                    Rectangle rectangle = (Rectangle) shape;
                    writer.println("Rectangle-" + rectangle.getLength() + "-" + rectangle.getWidth() + "-" + rectangle.getDepth());
                } else if (shape.toString().equals("Square")) {
                    Square square = (Square) shape;
                    writer.println("Square-" + square.getLength() + "-" + square.getDepth());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Implementation for loading shapes from a file
    public void loadFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("-");
                String shapeType = parts[0];
                //Load new Shape() based on name from each name + parameters
                if (shapeType.equals("Circle")) {
                    shapes.add(new Circle(Double.parseDouble(parts[1]), Double.parseDouble(parts[2])));
                } else if (shapeType.equals("Triangle")) {
                    shapes.add(new Triangle(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]), Double.parseDouble(parts[3])));
                } else if (shapeType.equals("Rectangle")) {
                    shapes.add(new Rectangle(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]), Double.parseDouble(parts[3])));
                } else if (shapeType.equals("Square")) {
                    shapes.add(new Square(Double.parseDouble(parts[1]),  Double.parseDouble(parts[3])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
