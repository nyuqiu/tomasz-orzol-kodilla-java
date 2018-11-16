package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    List<Shape> shapes;

    public ShapeCollector() {
        this.shapes = new ArrayList<>();
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void addFigure(Shape shape){

    }

    public boolean removeFigure(Shape shape){
        return true;
    }

    public Shape getFigure(int n){
        return null;
    }

    public String showFigures(){
        return null;
    }
}
