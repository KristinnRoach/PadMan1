module padman.vidmot {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens padman.vidmot to javafx.fxml;
    exports padman.vidmot;
}