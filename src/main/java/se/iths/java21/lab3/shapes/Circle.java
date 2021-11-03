package se.iths.java21.lab3.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public  class Circle extends Shape{


    public Circle(double x, double y, double size, Color color) {
        super(x, y, size, color);
    }

    public Circle(Shape shape) {
        super(shape);
    }

    @Override
    public String drawSVG() {
            String convertedColor = "#" +getColor().toString().substring(2,10);


            return "<circle cx=\"" +getX() + "\" " +
                    "cy=\""+getY() + "\" " +
                    "r=\"" + getSize() +"\" " +
                    "fill=\"" + convertedColor +"\" />";

    }

    @Override
    public boolean isInside(double x, double y) {

        double dx = x -getX();
        double dy = y - getY();

        double distanceFromCircleCenter = Math.sqrt(dx * dx + dy * dy);
        return distanceFromCircleCenter < getSize();
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getBorderColor());
        gc.fillOval(getX() -2.5 , getY() -2.5, getSize() + 5, getSize() + 5);

        gc.setFill(getColor());
        gc.fillOval(getX(), getY(), getSize(), getSize());
    }


}
