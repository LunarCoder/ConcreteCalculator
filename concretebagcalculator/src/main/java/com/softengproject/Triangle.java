package com.softengproject;

public class Triangle implements Shape {
    private double base;
    private double height;
    private double depth;

    public Triangle(double base, double height, double depth) {
        this.base = base;
        this.height = height;
        this.depth = depth;
    }

    @Override
    public double getVolume() {
        return (1.0/2.0 * base * height) * depth;
    }

    public double getbase() {
        return base;
    }

    public double getHeight() {
        return height;
    }
    public double getDepth() {
        return depth;
    }
    
    @Override
    public String toString() {
        return "Triangle";
    }
}
