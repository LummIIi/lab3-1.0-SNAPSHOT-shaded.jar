package se.iths.java21.lab3.shapes;

import javafx.scene.paint.Color;

import java.util.Deque;
import java.util.Stack;

public class Undo extends Shape{

    private Deque<Shape> undo;
    public Undo(double x, double y, double size, Color color) {
        super(x, y, size, color);
    }

    public Deque<Shape> getUndo() {
        return undo;
    }

    public void setUndo(Deque<Shape> undo) {
        this.undo = undo;
    }

    public void undo(Deque<Shape> undo){
        undo.removeLast();
    }
    public void redo(Deque<Shape> undo){
        undo.add(canv)
    }
}
