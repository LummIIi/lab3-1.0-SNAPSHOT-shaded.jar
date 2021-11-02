package se.iths.java21.lab3.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;


public class Triangel extends Shape{

    double[] xcoords = new double[3];
    double[] ycoords = new double[3];

    public Triangel(double x, double y, double size, Color color) {
        super(x, y, size, color);

        xcoords[0] = getX();
        ycoords[0] = getY();
        xcoords[1] = getX()+ 5;
        ycoords[1] = getY() +10;
        xcoords[2] = getX() -5;
        ycoords[2] = getY() +10;
    }

    public Triangel(double[] x, double[] y, int size, Color color) {
        super(x[0],y[0],color);
        xcoords = x;
        ycoords = y;
    }


    @Override
        public void draw(GraphicsContext graphicsContext){

        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillPolygon(xcoords,ycoords,3);

        }
}
