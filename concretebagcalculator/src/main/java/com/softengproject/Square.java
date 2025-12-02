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
        return this.length * this.length * this.depth;
    }

    public double getLength() {
        return this.length;
    }

    public double getDepth() {
        return this.depth;
    }

    @Override
    public String toString() {
        return "Square";
    }

}
