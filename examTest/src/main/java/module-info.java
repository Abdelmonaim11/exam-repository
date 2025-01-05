module com.example.examtest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens com.example.examtest.entities to javafx.base;
    exports com.example.examtest;
    opens com.example.examtest to java.base;
    exports com.example.examtest.controller;
    opens com.example.examtest.controller to java.base, javafx.fxml;
}
