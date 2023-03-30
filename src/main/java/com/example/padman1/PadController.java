package com.example.padman1;

import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class PadController implements Initializable {
    @FXML
    private GridPane fxGrid;
    private final int N = 9; // number of pads
    @FXML
    private Button fxPad1, fxPad2, fxPad3, fxPad4, fxPad5, fxPad6, fxPad7, fxPad8, fxPad9;
    private Button[] pads;
    private Map<String, MediaPlayer> padIdMap = new HashMap<>();
    private MediaPlayer[] currentSamplePack;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        pads = new Button[]{fxPad1, fxPad2, fxPad3, fxPad4, fxPad5, fxPad6, fxPad7, fxPad8, fxPad9};
        setCurrentSamplePack("src/main/resources/com/example/padman1/Audio/DrumPack1");
    }

    private void setCurrentSamplePack(String folderPath) {

        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name)
                -> name.endsWith(".wav") || name.endsWith(".mp3"));
        Arrays.sort(files);

        Media[] samples = new Media[N]; // mínus 1??
        currentSamplePack = new MediaPlayer[N];
        for (int i = 0; i < 9; i++) {
            samples[i] = new Media(files[i].toURI().toString());
            currentSamplePack[i] = new MediaPlayer(samples[i]);
        }
        for (MediaPlayer mp : currentSamplePack) {
            mp.setOnEndOfMedia(() -> mp.stop());
        }
    }

    /*
    private Map<Button, MediaPlayer> padIdMap(Button[] buttons) {
        Map<Button, MediaPlayer> map = new HashMap<>();
        for (Button button : buttons) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            map.put(button, mediaPlayer);
        }
        return map;
    }
    private void keysDrumPlay(int index) {
        currentSamplePack[index].stop();
        currentSamplePack[index].seek(Duration.ZERO);
        currentSamplePack[index].play();
    }
    private void mouseDrumPlay(int index) {
        currentSamplePack[index].stop();
        currentSamplePack[index].seek(Duration.ZERO);
        currentSamplePack[index].play();
    }
  */

    @FXML
    private void keyPressedSample(KeyEvent e) {
        if (e.getCode() == KeyCode.Q) { currentSamplePack[0].stop(); currentSamplePack[0].play(); }
        if (e.getCode() == KeyCode.W) { currentSamplePack[1].stop(); currentSamplePack[1].play(); }
        if (e.getCode() == KeyCode.E) { currentSamplePack[2].stop(); currentSamplePack[2].play(); }
        if (e.getCode() == KeyCode.R) { currentSamplePack[3].stop(); currentSamplePack[3].play(); }
        if (e.getCode() == KeyCode.T) { currentSamplePack[4].stop(); currentSamplePack[4].play(); }
        if (e.getCode() == KeyCode.Y) { currentSamplePack[5].stop(); currentSamplePack[5].play(); }
        if (e.getCode() == KeyCode.U) { currentSamplePack[7].stop(); currentSamplePack[6].stop(); currentSamplePack[6].play(); }
        if (e.getCode() == KeyCode.I) { currentSamplePack[7].stop(); currentSamplePack[7].play(); }
        if (e.getCode() == KeyCode.O) { currentSamplePack[8].stop(); currentSamplePack[8].play(); }
    }
    @FXML
    private void mousePressedSample(MouseEvent e) {
        if (e.getSource().equals(fxPad1)) { currentSamplePack[0].stop(); currentSamplePack[0].play(); }
        if (e.getSource().equals(fxPad2)) { currentSamplePack[1].stop(); currentSamplePack[1].play(); }
        if (e.getSource().equals(fxPad3)) { currentSamplePack[2].stop(); currentSamplePack[2].play(); }
        if (e.getSource().equals(fxPad4)) { currentSamplePack[3].stop(); currentSamplePack[3].play(); }
        if (e.getSource().equals(fxPad5)) { currentSamplePack[4].stop(); currentSamplePack[4].play(); }
        if (e.getSource().equals(fxPad6)) { currentSamplePack[5].stop(); currentSamplePack[5].play(); }
        if (e.getSource().equals(fxPad7)) { currentSamplePack[7].stop(); currentSamplePack[6].stop(); currentSamplePack[6].play(); }
        if (e.getSource().equals(fxPad8)) { currentSamplePack[7].stop(); currentSamplePack[7].play(); }
        if (e.getSource().equals(fxPad9)) { currentSamplePack[8].stop(); currentSamplePack[8].play(); }
    }
}

