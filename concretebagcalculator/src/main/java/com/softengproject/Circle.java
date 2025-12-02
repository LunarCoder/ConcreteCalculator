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
        return Math.PI * this.radius * this.radius * this.depth;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getDepth() {
        return this.depth;
    }

    @Override
    public String toString() {
        return "Circle";
    }
}