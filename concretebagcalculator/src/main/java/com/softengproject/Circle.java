package com.softengproject;

public class Circle implements Shape {
    private double radius;
    private double depth;

    public Circle(double radius, double depth) {
        this.radius = radius;
        this.depth = depth;
    }

    @Override
    public double getVolume() {
        return Math.PI * radius * radius * depth;
    }

    @Override
    public String toString() {
        return "Circle";
    }
}