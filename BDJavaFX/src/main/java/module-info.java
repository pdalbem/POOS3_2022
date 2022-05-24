module com.example.bdjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.bdjavafx to javafx.fxml;
    exports com.example.bdjavafx.model;
    opens com.example.bdjavafx.model to javafx.fxml;
    exports com.example.bdjavafx.data;
    opens com.example.bdjavafx.data to javafx.fxml;
     exports com.example.bdjavafx;
    exports com.example.bdjavafx.controller;
    opens com.example.bdjavafx.controller to javafx.fxml;

}