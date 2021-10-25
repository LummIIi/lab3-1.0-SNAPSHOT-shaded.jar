package se.iths.java21.lab3;
// lektion 25/10 har information för hur jag implementerar allt som en jar fil.
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import se.iths.java21.lab3.shapes.Circle;
import se.iths.java21.lab3.shapes.Shape;
import se.iths.java21.lab3.shapes.Square;
import se.iths.java21.lab3.shapes.Triangel;


import javax.imageio.ImageIO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class HelloController {

    Model model;


    private List<Shape> selectedShapes = new ArrayList<>();

    @FXML
    private TextField shapeSize;

    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Button circleButton;

    @FXML
    private Button squareButton;

    @FXML
    private Button onTriangleButton;

    @FXML
    private CheckBox selector;
    @FXML
    private CheckBox delete;

    @FXML
    private TextField textField1;


    public void initialize() {
        model = new Model();
        shapeSize.textProperty().bindBidirectional(model.sizeOfShapeProperty());
        colorPicker.valueProperty().bindBidirectional(model.colorProperty());

        canvas.widthProperty().addListener(observable -> draw());
        canvas.heightProperty().addListener(observable -> draw());


    }


    @FXML
    private void onCanvasCLicked(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();


        if (model.isCircle()) {
            model.getShapes().add(new Circle(x, y, model.getSizeOfShapeAsDouble(), model.getColor()));
        } else if (model.isSquare()) {
            model.getShapes().add(new Square(x, y, model.getSizeOfShapeAsDouble(), model.getColor()));
        }
//        else if (model.isTriangle()){
//            model.getShapes().add( new Triangel(model.xcoords,model.ycoords, 3,Color.BLACK));
//            model.xcoords[model.clickCount] = mouseEvent.getX();
//            model.ycoords[model.clickCount] = mouseEvent.getY();


        model.getShapes().stream().filter(shape -> shape.isInside(mouseEvent.getX(), mouseEvent.getY()))
                .findFirst().ifPresent(shape -> shape.setColor(Color.RED));
//

        draw();

    }


    public void onSave() {
        try {
            WritableImage snapshot = canvas.snapshot(null, null);

            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", new File("Paint.png"));
        } catch (Exception e) {
            System.out.println("Failed to  save Image" + e);
        }


    }

    public void onExit() {
        Platform.exit();
    }

    public void onCircleButton(MouseEvent event) {
        model.circleProperty().setValue(true);
        model.squareProperty().setValue(false);
        model.triangleProperty().setValue(false);


    }


    public void onSquareButton(MouseEvent event) {
        model.circleProperty().setValue(false);
        model.squareProperty().setValue(true);
        model.triangleProperty().setValue(false);


    }


    public void onTriangleButton(MouseEvent event) {
        model.circleProperty().setValue(false);
        model.squareProperty().setValue(false);
        model.triangleProperty().setValue(true);

    }

    public void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.clearRect(0,0,canvas.getWidth(), canvas.getHeight());

        for (var shape : model.getShapes()) {
            if (shape.getClass() == Square.class) {
                gc.setFill(shape.getColor());
                gc.fillRect(shape.getX(), shape.getY(), shape.getSize(), shape.getSize());


            } else if (shape.getClass() == Circle.class) {
                gc.setFill(shape.getColor());
                gc.fillOval(shape.getX(), shape.getY(), shape.getSize(), shape.getSize());

            } else if (shape.getClass() == Triangel.class){
                gc.setFill(shape.getColor());
                gc.fillPolygon(model.xcoords, model.ycoords, 3);

            }

        }

    }

//    public void onShapeSelected(MouseEvent mouseEvent) {
//
//        if (!selectedShapes.contains()) {
//            selectedShapes.add(shape);
//        }
//    }
//
//        public void delete(ActionEvent actionEvent){
//
//
//
//    }


}
