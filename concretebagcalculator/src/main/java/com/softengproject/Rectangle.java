package com.softengproject;

public class Rectangle implements Shape {
    private double length;
    private double width;
    private double depth;

    public Rectangle(double length, double width, double depth) {
        this.length = length;
        this.width = width;
        this.depth = depth;
    }

    @Override
    public double getVolume() {
        return length * width * depth;
    }

    @Override
    public String toString() {
        return "Rectangle";
    }

}
