package se.iths.java21.lab3.shapes;

import javafx.scene.paint.Color;

public class ShapesFactory {


    public static Circle circleOf(double x, double y, double size, Color color){
        return new Circle(x,y,size,color);
    }

    public static Square squareOf(double x, double y, double size, Color color){
        return new Square(x,y,size,color);
    }
    public static Circle circleOf(Shape shape){
        return new Circle(shape);
    }

    public static Square squareOf(Shape shape){
        return new Square(shape);
    }
}
