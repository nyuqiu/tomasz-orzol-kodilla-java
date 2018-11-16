package com.kodilla.testing.shape;

public class Square implements Shape {
    double length;

    public Square(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public double getField() {
        return Math.pow(length, 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return length == square.length;
    }

    @Override
    public int hashCode() {
        String result = length+""+Math.pow(length, 2);
        return Integer.valueOf(result);
    }
}
