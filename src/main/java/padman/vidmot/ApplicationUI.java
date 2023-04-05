package padman.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationUI extends Application {

    private static Stage mainStage;
    public static Stage getMainStage() {
        return mainStage;
    }

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("keys-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 590, 300);
        stage.setTitle("KeyNotes");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}