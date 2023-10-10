module com.example.ej1practicafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.ej1practicafx to javafx.fxml;
    exports com.example.ej1practicafx;
}