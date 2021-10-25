package se.iths.java21.lab3.shapes;

import javafx.scene.paint.Color;

public class Circle extends Shape{


    public Circle(double x, double y, double size, Color color) {
        super(x, y, size, color);
    }

    @Override
    public boolean isInside(double x, double y) {

        double dx = x -getX();
        double dy = y - getY();

        double distanceFromCircleCenter = Math.sqrt(dx * dx + dy * dy);
        return distanceFromCircleCenter < getSize();
    }
}
