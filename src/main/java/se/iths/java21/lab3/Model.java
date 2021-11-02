package se.iths.java21.lab3;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import se.iths.java21.lab3.shapes.Shape;
import javafx.collections.ListChangeListener.Change;

import java.util.ArrayDeque;
import java.util.Deque;

public class Model {

    private final BooleanProperty circle;
    private final BooleanProperty square;
    private final BooleanProperty triangle;
    private final StringProperty sizeOfShape;
    private ObservableList<Shape> shapes;
    private ObservableList<Shape> selectedShapes;
    private SimpleIntegerProperty shapesSizeInt;



    private BooleanProperty selectMode;







    double[] xcoords = new double[3];
    double[] ycoords = new double[3];
    int clickCount = 0;



    private final ObjectProperty<Color> color;

    public Model() {
        this.circle = new SimpleBooleanProperty();
        this.square = new SimpleBooleanProperty();
        this.triangle = new SimpleBooleanProperty();
        this.sizeOfShape = new SimpleStringProperty();
        this.shapes = FXCollections.observableArrayList();
        this.selectedShapes = FXCollections.observableArrayList();
        this.shapesSizeInt = new SimpleIntegerProperty();
        this.selectMode = new SimpleBooleanProperty();


        this.sizeOfShape.set("12");
        this.color = new SimpleObjectProperty<>(Color.BLACK);

    }



    public boolean isSelectMode() {
        return selectMode.get();
    }

    public BooleanProperty selectModeProperty() {
        return selectMode;
    }

    public void setSelectMode(boolean selectMode) {
        this.selectMode.set(selectMode);
    }



    public SimpleIntegerProperty shapesSizeIntProperty() {
        return shapesSizeInt;
    }

    public void setShapesSizeInt(int shapesSizeInt) {
        this.shapesSizeInt.set(shapesSizeInt);
    }

    public ObservableList<Shape> getSelectedShapes() {
        return selectedShapes;
    }

    public void setSelectedShapes(ObservableList<Shape> selectedShapes) {
        this.selectedShapes = selectedShapes;
    }

    public ObservableList<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(ObservableList<Shape> shapes) {
        this.shapes = shapes;
    }

    public Color getColor() {
        return color.get();
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    public void setColor(Color color) {
        this.color.set(color);
    }

    public boolean isTriangle() {
        return triangle.get();
    }

    public BooleanProperty triangleProperty() {
        return triangle;
    }

    public void setTriangle(boolean triangle) {
        this.triangle.set(triangle);
    }

    public boolean isSquare() {
        return square.get();
    }

    public BooleanProperty squareProperty() {
        return square;
    }

    public void setSquare(boolean square) {
        this.square.set(square);
    }


    public Double getSizeOfShapeAsDouble(){
        return Double.parseDouble(getSizeOfShape());
    }
    public String getSizeOfShape() {
        return sizeOfShape.get();
    }

    public StringProperty sizeOfShapeProperty() {
        return sizeOfShape;
    }

    public void setSizeOfShape(String sizeOfShape) {
        this.sizeOfShape.set(sizeOfShape);
    }

    public boolean isCircle() {
        return circle.get();
    }

    public BooleanProperty circleProperty() {
        return circle;
    }

    public void setCircle(boolean circle) {
        this.circle.set(circle);
    }



}
