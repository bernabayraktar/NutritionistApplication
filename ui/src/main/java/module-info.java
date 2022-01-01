module com.java.ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires gson;
    requires java.sql;


    opens com.java.ui to javafx.fxml;
    exports com.java.ui;
    exports com.java.ui.Controllers;
    opens com.java.ui.Controllers to javafx.fxml;
}