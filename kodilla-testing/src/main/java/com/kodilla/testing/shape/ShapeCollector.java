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
        if(!shapes.contains(shape)){
            shapes.add(shape);
        }
    }

    public boolean removeFigure(Shape shape){
        if(shapes.contains(shape)){
            shapes.remove(shape);
            return true;
        } else {
            return false;
        }
    }

    public Shape getFigure(int n){
        Shape foundShape = null;
        if(shapes.size()>=n) {
            foundShape = shapes.get(n);
        }
        return foundShape;
    }

    public String showFigures(){
        String result = "Figures in list are: ";
        for(int i=0; i<shapes.size();i++) {
            Shape actualShape = shapes.get(i);
            if (actualShape.getShapeName() == "Square") {
                result += "Square, side dimension " + actualShape.getDimensions() + ", field " + actualShape.getField()+"\n";
            } else if(actualShape.getShapeName()== "Triangle"){
                result += "Triangle, base and high dimensions " + actualShape.getDimensions() + ", field " + actualShape.getField()+"\n";
            } else if(actualShape.getShapeName() == "Circle"){
                result += "Circle, radius dimension " + actualShape.getDimensions() + ", field " + actualShape.getField()+"\n";
            }
        }
        return result;
    }
}
