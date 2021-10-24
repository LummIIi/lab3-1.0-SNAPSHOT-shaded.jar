package se.iths.java21.lab3;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Model {

    private final BooleanProperty circle;

    public Model() {
        this.circle = new SimpleBooleanProperty();
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
