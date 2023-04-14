package padman.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import padman.vinnsla.SampleHolder;


import java.io.IOException;
import java.util.Objects;

public class ApplicationUI extends Application {

    private static Stage mainStage;
    public static Stage getMainStage() {
        return mainStage;
    }

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("keys-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 590, 280);
        //scene.getStylesheets().add(getClass().getResource("src/main/java/padman/vinnsla/style.css").toExternalForm());
        stage.setTitle("KeyNotes");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}