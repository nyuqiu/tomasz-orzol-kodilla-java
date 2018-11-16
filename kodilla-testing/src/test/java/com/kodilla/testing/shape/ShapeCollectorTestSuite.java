package com.kodilla.testing.shape;

import org.junit.*;

//Test suite for classes of Forum
public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(2);
        //When
        shapeCollector.addFigure(square);
        int arraySize = shapeCollector.getShapes().size();
        //Then
        Assert.assertEquals(1, arraySize);
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(2);
        shapeCollector.addFigure(square);
        //When
        shapeCollector.removeFigure(square);
        int arraySize = shapeCollector.getShapes().size();
        //Then
        Assert.assertEquals(0, arraySize);
    }

    @Test
    public void testRemoveFigureNotExisting() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(2);
        //When
        boolean result = shapeCollector.removeFigure(square);
        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testGetFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(2);
        shapeCollector.addFigure(square);
        //When
        Shape receivedShape = shapeCollector.getFigure(0);
        //Then
        Assert.assertEquals(square, receivedShape);
    }

    @Test
    public void testShowFigures() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(2);
        Shape circle = new Circle(2);
        Shape triangle = new Triangle(2,2);
        shapeCollector.addFigure(square);
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(triangle);
        //When
        String result =  shapeCollector.showFigures();
        //Then
        Assert.assertEquals("Figures in list are: Square, side dimension 2.0, field 4.0\n"+
        "Circle, radius dimension 2.0, field 12.566370614359172\n"+
        "Triangle, base and high dimensions 2.0 2.0, field 2.0\n", result);
    }

    @Test
    public void testGetFieldSquare() {
        //Given
        double length =2;
        Shape square = new Square(length);
        double field = square.getField();
        //When
        double testSquare = Math.pow(length, 2);
        //Then
        Assert.assertEquals((Double)field, (Double)testSquare);
    }

    @Test
    public void testGetFieldTriangle() {
        //Given
        double base =2;
        double high =2;
        Shape triangle = new Triangle(base, high);
        double field = triangle.getField();
        //When
        double testTriangle = (base*high)/2;
        //Then
        Assert.assertEquals((Double)field, (Double)testTriangle);
    }

    @Test
    public void testGetFieldCircle() {
        //Given
        double radius =2;
        Shape circle = new Circle(radius);
        double field = circle.getField();
        //When
        double testCircle = Math.PI*(Math.pow(radius, 2));
        //Then
        Assert.assertEquals((Double)field, (Double)testCircle);
    }

    @Test
    public void testGetNameSquare() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(2);
        //When
        String shapeName = square.getShapeName();
        //Then
        Assert.assertEquals(shapeName, "Square");
    }

    @Test
    public void testGetNameTriangle() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape triangle = new Triangle(2,2);
        //When
        String shapeName = triangle.getShapeName();
        //Then
        Assert.assertEquals(shapeName, "Triangle");
    }

    @Test
    public void testGetNameCircle() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape circle = new Circle(2);
        //When
        String shapeName = circle.getShapeName();
        //Then
        Assert.assertEquals(shapeName, "Circle");
    }
}