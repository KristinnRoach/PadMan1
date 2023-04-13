package padman.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import padman.vinnsla.SampleHolder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class KeysUI implements Initializable {
    @FXML
    private GridPane fxGrid;
    @FXML
    private Button fxPad1, fxPad2, fxPad3, fxPad4, fxPad5, fxPad6, fxPad7, fxPad8, fxPad9, fxPad0, fxPadQ, fxPadW, fxPadE, fxPadR, fxPadT, fxPadY, fxPadU, fxPadI, fxPadO, fxPadP, fxPadA, fxPadS, fxPadD, fxPadF, fxPadG, fxPadH, fxPadJ, fxPadK, fxPadL, fxPadÆ, fxPadZ, fxPadX, fxPadC, fxPadV, fxPadB, fxPadN, fxPadM, fxPad10, fxPad11, fxPadÞ;
    private Button[] pads;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pads = new Button[] { fxPad1, fxPad2, fxPad3, fxPad4, fxPad5, fxPad6, fxPad7, fxPad8, fxPad9, fxPad0, fxPadQ, fxPadW, fxPadE, fxPadR, fxPadT, fxPadY, fxPadU, fxPadI, fxPadO, fxPadP, fxPadA, fxPadS, fxPadD, fxPadF, fxPadG, fxPadH, fxPadJ, fxPadK, fxPadL, fxPadÆ, fxPadZ, fxPadX, fxPadC, fxPadV, fxPadB, fxPadN, fxPadM, fxPad10, fxPad11, fxPadÞ};
        SampleHolder.setSamplesFromFolder("src/main/resources/padman/vidmot/Audio/SoftPiano/Diatonic");
    }

    @FXML
    private void onButtonFxUI (ActionEvent e) throws IOException {
        FxUI.loadFxUI();
    }

    @FXML
    private void keyPressedSample(KeyEvent e) {
        int keyIndex = -1;
        switch(e.getCode()) {
            case DIGIT1: keyIndex = 0; break;
            case DIGIT2: keyIndex = 1; break;
            case DIGIT3: keyIndex = 2; break;
            case DIGIT4: keyIndex = 3; break;
            case DIGIT5: keyIndex = 4; break;
            case DIGIT6: keyIndex = 5; break;
            case DIGIT7: keyIndex = 6; break;
            case DIGIT8: keyIndex = 7; break;
            case DIGIT9: keyIndex = 8; break;
            case DIGIT0: keyIndex = 9; break;
            case Q: keyIndex = 10; break;
            case W: keyIndex = 11; break;
            case E: keyIndex = 12; break;
            case R: keyIndex = 13; break;
            case T: keyIndex = 14; break;
            case Y: keyIndex = 15; break;
            case U: keyIndex = 16; break;
            case I: keyIndex = 17; break;
            case O: keyIndex = 18; break;
            case P: keyIndex = 19; break;
            case A: keyIndex = 20; break;
            case S: keyIndex = 21; break;
            case D: keyIndex = 22; break;
            case F: keyIndex = 23; break;
            case G: keyIndex = 24; break;
            case H: keyIndex = 25; break;
            case J: keyIndex = 26; break;
            case K: keyIndex = 27; break;
            case L: keyIndex = 28; break;
            case SEMICOLON: keyIndex = 29; break;
            case Z: keyIndex = 30; break;
            case X: keyIndex = 31; break;
            case C: keyIndex = 32; break;
            case V: keyIndex = 33; break;
            case B: keyIndex = 34; break;
            case N: keyIndex = 35; break;
            case M: keyIndex = 36; break;
            case COMMA: keyIndex = 37; break;
            case PERIOD: keyIndex = 38; break;
            case SLASH: keyIndex = 39; break; // / (slash)
        }
        if (keyIndex != -1) {
            SampleHolder.playMedia(keyIndex);
        }
    }

    @FXML
    private void mousePressedSample(MouseEvent e) {
        Button[] pads = {fxPad1, fxPad2, fxPad3, fxPad4, fxPad5, fxPad6, fxPad7, fxPad8, fxPad9, fxPad0, fxPadQ, fxPadW, fxPadE, fxPadR, fxPadT, fxPadY, fxPadU, fxPadI, fxPadO, fxPadP, fxPadA, fxPadS, fxPadD, fxPadF, fxPadG, fxPadH, fxPadJ, fxPadK, fxPadL, fxPadÆ, fxPadZ, fxPadX, fxPadC, fxPadV, fxPadB, fxPadN, fxPadM, fxPad10, fxPad11, fxPadÞ};
        for (int i = 0; i < pads.length; i++) {
            if (e.getSource().equals(pads[i])) {
                SampleHolder.playMedia(i);
                break;
            }
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
        Button targetButton = (Button) e.getGestureTarget();
        int key = Arrays.asList(pads).indexOf(targetButton);
        SampleHolder.handleDragDropped(e, key);
    }
}