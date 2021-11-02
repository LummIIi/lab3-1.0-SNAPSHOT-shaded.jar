package se.iths.java21.lab3.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Shape {

    public Square(double x, double y, double size, Color color) {
        super(x, y, size, color);
    }

    @Override
    public boolean isInside(double x, double y) {

        double leftX = getX() - getSize();
        double topY = getY() - getSize();

        return x >= leftX &&
                x <= leftX +2 * getSize() &&
                y >= topY &&
                y >= topY +2 * getSize();

    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getBorderColor());
        gc.fillRect(getX() -2.5, getY() -2.5, getSize() + 5, getSize() + 5);

        gc.setFill(getColor());
        gc.fillRect(getX() , getY() , getSize(), getSize());
    }
}
