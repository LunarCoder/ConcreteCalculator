package com.softengproject;

public class Square implements Shape {
    private double length;
    private double depth;

    public Square(double length, double depth) {
        this.length = length;
        this.depth = depth;
    }

    @Override
    public double getVolume() {
        return length * length * depth;
    }

    public double getLength() {
        return length;
    }

    public double getDepth() {
        return depth;
    }

    @Override
    public String toString() {
        return "Square";
    }

}
