package padman.vidmot;

import javafx.fxml.Initializable;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import padman.vinnsla.SampleHolder;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

public class Keys implements Initializable {
    @FXML
    private GridPane fxGrid;
    @FXML
    private Button fxPad1, fxPad2, fxPad3, fxPad4, fxPad5, fxPad6, fxPad7, fxPad8, fxPad9;
    private Button[] pads;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pads = new Button[] { fxPad1, fxPad2, fxPad3, fxPad4, fxPad5, fxPad6, fxPad7, fxPad8, fxPad9 };
    }
    @FXML
    private void keyPressedSample(KeyEvent e) {
        int keyIndex = -1;
        switch(e.getCode()) {
            case Q: keyIndex = 0; break;
            case W: keyIndex = 1; break;
            case E: keyIndex = 2; break;
            case R: keyIndex = 3; break;
            case Y: keyIndex = 4; break;
            case U: keyIndex = 5; break;
            case I: keyIndex = 6; break;
            case O: keyIndex = 7; break;
            case P: keyIndex = 8; break;
        }
        if (keyIndex != -1) {
            SampleHolder.playMedia(keyIndex);
        }
    }

    @FXML
    private void mousePressedSample(MouseEvent e) {
        Button[] pads = {fxPad1, fxPad2, fxPad3, fxPad4, fxPad5, fxPad6, fxPad7, fxPad8, fxPad9};
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