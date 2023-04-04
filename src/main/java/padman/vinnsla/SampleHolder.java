package padman.vinnsla;

import javafx.scene.control.Alert;
import javafx.scene.input.DragEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.Arrays;

public class SampleHolder {
    private static final int N = 9; // Max nr of MediaPlayers
    private static Media[] medias = new Media[N];
    private static MediaPlayer[] mediaPlayers = new MediaPlayer[N];


    private static void setSamples(String folderPath) {

        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name)
                -> name.endsWith(".wav") || name.endsWith(".mp3"));
        Arrays.sort(files);

        for (int i = 0; i < 9; i++) {
            medias[i] = new Media(files[i].toURI().toString());
            mediaPlayers[i] = new MediaPlayer(medias[i]);
        }
        for (MediaPlayer mp : mediaPlayers) {
            mp.setOnEndOfMedia(() -> mp.stop());
        }
    }

    public static void setSample(File keySample, int key) {
        if (!keySample.isFile() || !(keySample.getName().endsWith(".wav") || keySample.getName().endsWith(".mp3"))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Illegal Argument Exception");
            alert.setContentText("Sample needs to be wav or mp3");
            alert.showAndWait();
            throw new IllegalArgumentException("Sample needs to be wav or mp3");
        }
        Media media = new Media(keySample.toURI().toString());
        mediaPlayers[key] = new MediaPlayer(media);
        mediaPlayers[key].setOnEndOfMedia(() -> mediaPlayers[key].stop());
    }

    public static void playMedia(int key) {
        if (mediaPlayers[key] != null) {
            mediaPlayers[key].stop();
            mediaPlayers[key].play();
        }
    }

    public static void stopMedia(int key) {
        if (mediaPlayers[key] != null) {
            mediaPlayers[key].stop();
        }
    }

    public static void setSamplesFromFolder(String folderPath) {
        setSamples(folderPath);
    }

    public static void setSampleFromFile(File keySample, int key) {
        setSample(keySample, key);
    }

    public static void handleDragDropped(DragEvent e, int key) {
        File file = e.getDragboard().getFiles().iterator().next();
        setSample(file, key);
        e.setDropCompleted(true);
        e.consume();
    }
}