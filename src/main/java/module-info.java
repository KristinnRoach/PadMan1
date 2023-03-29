module com.example.padman1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.padman1 to javafx.fxml;
    exports com.example.padman1;
}