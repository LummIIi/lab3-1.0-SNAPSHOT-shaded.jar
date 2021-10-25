module se.iths.java21.lab3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.swing;


    opens se.iths.java21.lab3 to javafx.fxml;
    exports se.iths.java21.lab3;
    exports se.iths.java21.lab3.shapes;
    opens se.iths.java21.lab3.shapes to javafx.fxml;
}