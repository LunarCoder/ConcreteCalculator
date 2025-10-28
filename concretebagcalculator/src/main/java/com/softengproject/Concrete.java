package com.softengproject;

import java.util.ArrayList;
import com.softengproject.Shape;

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

}
