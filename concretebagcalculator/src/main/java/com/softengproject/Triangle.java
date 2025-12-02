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
        return 1.0 / 2.0 * this.base * this.height * this.depth;
    }

    public double getbase() {
        return this.base;
    }

    public double getHeight() {
        return this.height;
    }

    public double getDepth() {
        return this.depth;
    }

    @Override
    public String toString() {
        return "Triangle";
    }
}
