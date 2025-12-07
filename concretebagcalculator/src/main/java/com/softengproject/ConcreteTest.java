package com.softengproject;

import java.io.File;
import java.io.IOException;

public class ConcreteTest {
    private static final double DELTA = 0.0001;
    private static int testsRun = 0;
    private static int testsPassed = 0;

    private static void assertEquals(double expected, double actual, double delta, String message) {
        testsRun++;
        // Check if the difference is within the acceptable delta
        if (Math.abs(expected - actual) <= delta) {
            testsPassed++;
            System.out.println("PASS: " + message);
        } else {
            System.err.println("FAIL: " + message);
            System.err.printf("   Expected: %.4f, Actual: %.4f\n", expected, actual);
        }
    }

    // --- Test Runner Methods ---
    public static void runShapeVolumeTests(){
        System.out.println("\n--- Running Shape Volume Tests ---");

        // --- Test 1: Rectangle Volume ---
        Shape rect = new Rectangle(10.0, 5.0, 0.5); // 10x5x0.5 = 25.0
        assertEquals(25.0, rect.getVolume(), DELTA, "Rectangle volume (L=10, W=5, D=0.5)");

        // --- Test 2: Square Volume ---
        Shape sq = new Square(4.0, 1.0);
        assertEquals(16.0, sq.getVolume(), DELTA, "Square volume (L=4, D=1)"); // 4x4x1 = 16.0

        // --- Test 3: Circle Volume ---
        Shape circ = new Circle(2.0, 0.25); // π * 2^2 * 0.25 = 3.14159
        assertEquals(3.14159, circ.getVolume(), DELTA, "Circle volume (R=2, d=0.25)");

        // --- Test 4: Triangle Volume ---
        Shape tri = new Triangle(6.0, 8.0, 0.1); // 0.5 * 6 * 8 * 0.1 = 2.4
        assertEquals(2.4, tri.getVolume(), DELTA, "Triangle volume (B=6, H=8, D=0.1)");
    }

    public static void runConcreteLogicTests() {
        System.out.println("\n--- Running Concrete Logic Tests ---");

        Concrete concrete = new Concrete();
        concrete.clearShapes();

        // --- Test 1 --- 
        // Add shapes
        concrete.addShape(new Rectangle(10.0, 5.0, 0.5)); // 25.0
        concrete.addShape(new Square(4.0, 1.0));         // 16.0
        concrete.addShape(new Triangle(6.0, 8.0, 0.1));  // 2.4
        // Total volume = 25.0 + 16.0 + 2.4 = 43.4
        // Bags required with default bag volume: ceil(43.4 / 0.45) = 97 bags
        assertEquals(97.0, concrete.getBagsRequired(), DELTA, "Bag Requirement (43.4 ft^3)");

        concrete.clearShapes();

        // --- Test 2 ---
        // Volume of 1.801 cu ft. Expected: ceil(1.801/0.45) = ceil(4.002) = 5 bags
        concrete.addShape(new Rectangle(10.0,1.0,0.1801));
        assertEquals(5.0, concrete.getBagsRequired(), DELTA, "Bags Required (1.801 ft^3)");

        concrete.clearShapes();

        // --- Test 3: Empty List Check ---
        assertEquals(0.0, concrete.getBagsRequired(), DELTA, "Bags Required should be 0 for empty list");

        concrete.clearShapes();

        // --- Test 4: Small Volume Check ---
        concrete.addShape(new Square(0.1, 0.1)); // 0.1*0.1*0.1 = 0.001 cu ft
        assertEquals(1.0, concrete.getBagsRequired(), DELTA, "Bags Required should be 1 for very small volume");

    }

    public static void runFileInteractionTests(){
        System.out.println("\n--- Running File Interaction Tests ---");

        Concrete concrete = new Concrete();
        concrete.clearShapes();

        // --- Test 1: clearShapes functionality (internal check for reset)
        concrete.addShape(new Square(1.0, 1.0));
        concrete.clearShapes(); 
        assertEquals(0.0, concrete.getBagsRequired(), DELTA, "Internal list is cleared by clearShapes().");

        // --- Test 2: clearFile effect on list
        concrete.addShape(new Square(1.0, 1.0));
        concrete.clearFile("non_existent_file.txt"); 
        assertEquals(0.0, concrete.getBagsRequired(), DELTA, "List is cleared by clearFile().");

        // --- Test 3: Sanity check for save operation
        concrete.addShape(new Square(1.0, 1.0));
        concrete.saveFile(); 
        System.out.println("INFO: A save test ran. A file named 'shapes_...' should exist in your project root.");

    }

    public static void main(String[] args) {
        System.out.println("Starting Manual Unit Tests(60 lb Bag)");

        runShapeVolumeTests();
        runConcreteLogicTests();
        runFileInteractionTests();

        System.out.println("\n=================================");
        System.out.println("Manual Testing Complete.");
        System.out.println("Total Tests Run: " + testsRun);
        System.out.println("Total Tests Passed: " + testsPassed);
        System.out.println("Total Tests Failed: " + (testsRun - testsPassed));
        System.out.println("=================================");

        if(testsRun != testsPassed){
            System.exit(1); // Indicate failure if any test failed

        }
    }

}

