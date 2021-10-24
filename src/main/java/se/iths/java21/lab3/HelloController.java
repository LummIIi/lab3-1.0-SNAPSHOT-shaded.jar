package se.iths.java21.lab3;

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


import javax.imageio.ImageIO;

import java.io.File;


public class HelloController {

    Model model;


    public TextField brushsize;
    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private java.awt.TextField brushSize;

    @FXML
    private Button button;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private CheckBox eraser;

    @FXML
    private TextField textField1;


          public void initialize() {
              model = new Model();



          }



    @FXML
    private void drawCircle(MouseEvent mouseEvent) {
              double x = mouseEvent.getX();
              double y = mouseEvent.getY();


        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.RED);
        gc.fillOval(x,y,50,50);

    }


    private void drawSquare() {
        var f = canvas.getGraphicsContext2D();
        f.fillRect(brushSize.getWidth(), brushSize.getHeight(), brushSize.getWidth(), brushSize.getHeight());

    }

    private void drawRectangle() {
        var f = canvas.getGraphicsContext2D();
        f.fillRect(brushSize.getHeight(), brushSize.getHeight(), brushSize.getWidth(), brushSize.getWidth());
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



    }


    public void onButton1(MouseEvent event) {
        drawSquare();


    }

    public void onButton2(MouseEvent event) {
        drawRectangle();
    }


}
