package com.softengproject;

public class Square implements Shape {
    private double length;

    public Square(double length) {
        this.length = length;
    }

    @Override
    public double getVolume() {
        return length * length;
    }

    @Override
    public String toString() {
        return "Square";
    }

}
