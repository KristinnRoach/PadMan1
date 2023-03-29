package com.example.padman1;

import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class PadController implements Initializable {
    @FXML
    private GridPane fxGrid;
    @FXML
    private Button fxPad1, fxPad2, fxPad3, fxPad4, fxPad5, fxPad6, fxPad7, fxPad8, fxPad9;
    private Button[] pads;
    // private Map<Button, MediaPlayer> buttonMap = new HashMap<>();
    private Media[] samples;
    private MediaPlayer[] mediaPlayers;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pads = new Button[] { fxPad1, fxPad2, fxPad3, fxPad4, fxPad5, fxPad6, fxPad7, fxPad8, fxPad9 };

        String drumPath = "src/main/resources/com/example/padman1/Audio/DrumPack1/Cassette808_";
       // createButtons(8);
        createDrumPack(drumPath);
    }

    private void createButtons(int n) {
        //buttons = new Button[n];
        for (int i = 0; i < n; i++) {
            pads[i] = new Button();
            fxGrid.add(pads[i], i % n, i / n);
        }
    }

    private void createDrumPack(String fileName) {
        samples = new Media[9];
        mediaPlayers = new MediaPlayer[9];
        for (int i = 0; i < 9; i++) {
            samples[i] = new Media(new File(fileName + (i) + ".wav").toURI().toString());
            mediaPlayers[i] = new MediaPlayer(samples[i]);
        }
    }

    private void keysDrums(){
        for (int i = 0; i < 9; i++) {
            int index = i;
            pads[i].setOnAction(e -> mediaPlayers[index].play());
        }
    }

    @FXML
    public void mousePressedSample(MouseEvent e) {

        if (e.getSource().equals(fxPad1)) { mediaPlayers[0].play(); }
        if (e.getSource().equals(fxPad2)) { mediaPlayers[1].play(); }
        if (e.getSource().equals(fxPad3)) { mediaPlayers[2].play(); }
        if (e.getSource().equals(fxPad4)) { mediaPlayers[3].play(); }
        if (e.getSource().equals(fxPad5)) { mediaPlayers[4].play(); }
        if (e.getSource().equals(fxPad6)) { mediaPlayers[5].play(); }
        if (e.getSource().equals(fxPad7)) { mediaPlayers[6].play(); }
        if (e.getSource().equals(fxPad8)) { mediaPlayers[7].play(); }
        if (e.getSource().equals(fxPad9)) { mediaPlayers[8].play(); }

        for (MediaPlayer mp : mediaPlayers) {
           // mp.setOnEndOfMedia(() -> mp.seek(Duration.ZERO));
            mp.setOnEndOfMedia(() -> mp.stop());
        //    mp.setOnStopped(() -> mp.dispose());
        }
    }
}

