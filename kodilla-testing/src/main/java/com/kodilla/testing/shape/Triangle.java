package com.kodilla.testing.shape;

public class Triangle implements Shape {
    double base;
    double high;

    public Triangle(double base, double high) {
        this.base = base;
        this.high = high;
    }

    public double getBase() {
        return base;
    }

    public double getHigh() {
        return high;
    }

    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public double getField() {
        return (double)(base*high)/2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return base == triangle.base &&
                high == triangle.high;
    }

    @Override
    public int hashCode() {
        String result = base+""+(base*high/2);
        return Integer.valueOf(result);
    }
}
