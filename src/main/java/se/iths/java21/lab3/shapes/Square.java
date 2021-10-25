package se.iths.java21.lab3.shapes;

import javafx.scene.paint.Color;

public class Square extends Shape {

    public Square(double x, double y, double size, Color color) {
        super(x, y, size, color);
    }

    @Override
    public boolean isInside(double x, double y) {
        return true;
    }
}
