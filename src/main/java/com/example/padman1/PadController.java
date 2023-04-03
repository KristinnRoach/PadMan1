package com.example.padman1;

import javafx.fxml.Initializable;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Button;
import javafx.fxml.FXML;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

public class PadController implements Initializable {
    @FXML
    private GridPane fxGrid;
    private final int N = 9; // Max nr of MediaPlayers
    @FXML
    private Button fxPad1, fxPad2, fxPad3, fxPad4, fxPad5, fxPad6, fxPad7, fxPad8, fxPad9;
    private Button[] pads;
    private Media[] medias = new Media[N];
    private MediaPlayer[] mediaPlayers = new MediaPlayer[N];

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pads = new Button[] { fxPad1, fxPad2, fxPad3, fxPad4, fxPad5, fxPad6, fxPad7, fxPad8, fxPad9 };
    }

    private void setSamples(String folderPath) {

        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name)
                -> name.endsWith(".wav") || name.endsWith(".mp3"));
        Arrays.sort(files);

        for (int i = 0; i < 9; i++) {
            medias[i] = new Media(files[i].toURI().toString());
            mediaPlayers[i] = new MediaPlayer(medias[i]);
        }
        for (MediaPlayer mp : mediaPlayers) { // hafa í sér function fyrir öll sömpl? bæta við mp.dispose();
            mp.setOnEndOfMedia(() -> mp.stop());
        }
    }

    private void setSamples(File keySample, int key) {
        System.out.println(key);
        if (!keySample.isFile() || !(keySample.getName().endsWith(".wav") || keySample.getName().endsWith(".mp3"))) {
            throw new IllegalArgumentException("Sample needs to be wav or mp3");
        }
        Media media = new Media(keySample.toURI().toString());
        mediaPlayers[key] = new MediaPlayer(media);
        mediaPlayers[key].setOnEndOfMedia(() -> mediaPlayers[key].stop()); // hafa í sér function fyrir öll sömpl? bæta við .dispose();
    }

    @FXML
    private void keyPressedSample(KeyEvent e) {
        if (e.getCode() == KeyCode.Z) {
            mediaPlayers[0].stop();
            mediaPlayers[0].play();
        }
        if (e.getCode() == KeyCode.X) {
            mediaPlayers[1].stop();
            mediaPlayers[1].play();
        }
        if (e.getCode() == KeyCode.C) {
            mediaPlayers[2].stop();
            mediaPlayers[2].play();
        }
        if (e.getCode() == KeyCode.A) {
            mediaPlayers[3].stop();
            mediaPlayers[3].play();
        }
        if (e.getCode() == KeyCode.S) {
            mediaPlayers[4].stop();
            mediaPlayers[4].play();
        }
        if (e.getCode() == KeyCode.D) {
            mediaPlayers[5].stop();
            mediaPlayers[5].play();
        }
        if (e.getCode() == KeyCode.Q) {
            mediaPlayers[7].stop();
            mediaPlayers[6].stop();
            mediaPlayers[6].play();
        }
        if (e.getCode() == KeyCode.W) {
            mediaPlayers[7].stop();
            mediaPlayers[7].play();
        }
        if (e.getCode() == KeyCode.E) {
            mediaPlayers[8].stop();
            mediaPlayers[8].play();
        }
    }

    @FXML
    private void mousePressedSample(MouseEvent e) {
        if (e.getSource().equals(fxPad1)) {
            mediaPlayers[0].stop();
            mediaPlayers[0].play();
        }
        if (e.getSource().equals(fxPad2)) {
            mediaPlayers[1].stop();
            mediaPlayers[1].play();
        }
        if (e.getSource().equals(fxPad3)) {
            mediaPlayers[2].stop();
            mediaPlayers[2].play();
        }
        if (e.getSource().equals(fxPad4)) {
            mediaPlayers[3].stop();
            mediaPlayers[3].play();
        }
        if (e.getSource().equals(fxPad5)) {
            mediaPlayers[4].stop();
            mediaPlayers[4].play();
        }
        if (e.getSource().equals(fxPad6)) {
            mediaPlayers[5].stop();
            mediaPlayers[5].play();
        }
        if (e.getSource().equals(fxPad7)) {
            mediaPlayers[7].stop();
            mediaPlayers[6].stop();
            mediaPlayers[6].play();
        }
        if (e.getSource().equals(fxPad8)) {
            mediaPlayers[7].stop();
            mediaPlayers[7].play();
        }
        if (e.getSource().equals(fxPad9)) {
            mediaPlayers[8].stop();
            mediaPlayers[8].play();
        }
    }

    @FXML
    private void onDragOver(DragEvent e) {
        if (e.getDragboard().hasFiles()) {
            e.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    private void onDragDropped(DragEvent e) throws FileNotFoundException {

        String str = e.getSource().toString();  // losnum við þetta þegar gagnagrind er komin
        int index = str.indexOf(",") - 1;
        char keyChar = str.charAt(index);
        int key = Character.getNumericValue(keyChar)-1;

        File file = e.getDragboard().getFiles().iterator().next();
        setSamples(file, key);
        e.setDropCompleted(true);
        e.consume();
    }
}