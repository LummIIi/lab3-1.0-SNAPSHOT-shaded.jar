package se.iths.java21.lab3;

import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import se.iths.java21.lab3.shapes.Circle;
import se.iths.java21.lab3.shapes.Shape;
import se.iths.java21.lab3.shapes.Square;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTest {

    HelloController helloController = new HelloController(new Model());

    @Test
    void undoLastAddedShape(){
        Circle circle = new Circle(10,10,10,Color.RED);
        Circle circle1 = new Circle(11,11,12,Color.RED);
        Square square = new Square(10,10,15,Color.RED);

        helloController.model.getShapes().add(circle);
        ObservableList<Shape> templist = helloController.model.getTempList();
        helloController.model.undo.addLast(templist);

        helloController.model.getShapes().add(circle1);
        ObservableList<Shape> templist1 = helloController.model.getTempList();
        helloController.model.undo.addLast(templist1);

        helloController.model.getShapes().add(square);

        undoLastTest();

        assertEquals(2,helloController.model.getShapes().size(),"Shape list should have size 2");



     }

     public void undoLastTest(){
         if(helloController.model.undo.isEmpty())
             return;

         helloController.model.setShapes(helloController.model.undo.removeLast());
     }


        @Test
    void deleteSelectedShape(){
        Circle circle = new Circle(10,10,10,Color.RED);
        Circle circle1= new Circle(10,10,10,Color.RED);


        helloController.model.getShapes().add(circle);
        ObservableList<Shape> templisst = helloController.model.getTempList();
        helloController.model.undo.addLast(templisst);

            helloController.model.getShapes().add(circle1);
            ObservableList<Shape> templisst1 = helloController.model.getTempList();
            helloController.model.undo.addLast(templisst1);

            helloController.model.getShapes().stream().filter(shape -> helloController.model.getSelectedShapes().contains(circle))
                    .findFirst().ifPresent(shape -> helloController.model.getShapes().remove(circle));

                   helloController.model.getShapes().remove(circle);

                    assertEquals(1,helloController.model.getShapes().size(),"size should be equal to one");



        }




}