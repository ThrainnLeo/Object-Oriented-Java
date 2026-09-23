module thrainn.Lab3A {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;


    opens thrainn to javafx.fxml;
    exports thrainn;
}