package se.iths.java21.lab3;
// lektion 25/10 har information för hur jag implementerar allt som en jar fil.
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
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
import se.iths.java21.lab3.shapes.*;


import javax.imageio.ImageIO;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;


public class HelloController {


    @FXML
    private Button undo;
    @FXML
    private Button changeSize;
    @FXML
    private Button changeColor;
    @FXML
    private CheckBox selectMode;

    Model model;

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
    private Button delete;

    @FXML
    private Button redo;


    @FXML
    private TextField textField1;


    public void initialize() {
        model = new Model();
        shapeSize.textProperty().bindBidirectional(model.sizeOfShapeProperty());
        colorPicker.valueProperty().bindBidirectional(model.colorProperty());
        selectMode.selectedProperty().bindBidirectional(model.selectModeProperty());


        canvas.widthProperty().addListener(observable -> draw());
        canvas.heightProperty().addListener(observable -> draw());


    }


    @FXML
    private void onCanvasCLicked(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();


        if (model.isSelectMode()) {

            model.getShapes().stream()
                    .filter(shape -> shape.isInside(mouseEvent.getX(), mouseEvent.getY()))
                    .findFirst().ifPresent(shape -> {
                        if (model.getSelectedShapes().contains(shape)) {
                            model.getSelectedShapes().remove(shape);
                            shape.setBorderColor(Color.TRANSPARENT);
                        } else {
                            model.getSelectedShapes().add(shape);
                            shape.setBorderColor(Color.RED);
                        }
                    });

        } else {

            if (model.isCircle()) {
                model.getShapes().add(ShapesFactory.circleOf(x, y, model.getSizeOfShapeAsDouble(), model.getColor()));


            } else if (model.isSquare()) {
                model.getShapes().add(ShapesFactory.squareOf(x, y, model.getSizeOfShapeAsDouble(), model.getColor()));

            }

        }


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

    public void onSelected() {

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


    public void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.clearRect(0,0,canvas.getWidth(), canvas.getHeight());

        for (var shape : model.getShapes()) {
            shape.draw(gc);
        }

        }

    public void delete(ActionEvent event) {

        model.getShapes().stream()
                .filter(shape -> model.getSelectedShapes().contains(shape))
                .findFirst().ifPresent(shape -> model.getShapes().remove(shape));
        draw();


    }

    public void changeSize(ActionEvent event) {
        for (Shape shape : model.getSelectedShapes()) {
            shape.setSize(model.getSizeOfShapeAsDouble());


        }
        draw();
    }

    public void changeColor(ActionEvent event) {
        for (Shape shape : model.getSelectedShapes()) {
            shape.setColor(model.getColor());

        }
        draw();
    }

    public void UndoLast(ActionEvent event) {
        int value =1;
        try {
            for (int i = 0; i < value; i++) {
                Collections.reverse(model.getShapes());
                model.getShapes().remove(i);


            }
        }catch (IndexOutOfBoundsException e){
            
        }

           draw();
       }




    }


