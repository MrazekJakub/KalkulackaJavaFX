module com.example.kalkulackakterasnadbudefungovat {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kalkulackakterasnadbudefungovat to javafx.fxml;
    exports com.example.kalkulackakterasnadbudefungovat;
}